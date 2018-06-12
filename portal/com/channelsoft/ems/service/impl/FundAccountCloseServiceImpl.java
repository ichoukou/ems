package com.channelsoft.ems.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.channelsoft.ems.po.FundAccountPo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.channelsoft.ems.mapper.FundAccountCloseMapper;
import com.channelsoft.ems.po.BalancePo;
import com.channelsoft.ems.po.FundAccountBillPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.FundAccountBillService;
import com.channelsoft.ems.service.FundAccountCloseService;

@Service
public class FundAccountCloseServiceImpl implements FundAccountCloseService {

	private Logger logger=Logger.getLogger(FundAccountCloseServiceImpl.class);

	@Autowired
	private FundAccountCloseMapper fundAccountCloseMapper;

	@Autowired
	private FundAccountBillService fundAccountBillService;

	/**
	 * 查询余额
	 */
	public List<BalancePo> queryBalance(BalancePo balancePo) {
		logger.debug("开始查询余额表");
		List<BalancePo> list=fundAccountCloseMapper.queryBalance(balancePo);
		return list;
	}

	/**
	 * 添加账户余额
	 */
	public int insertBalance(BalancePo balancePo) {
		logger.debug("开始添加账户余额");
		int result=fundAccountCloseMapper.insertBalance(balancePo);
		return result;
	}

	/**
	 * 结账 返回0计算失败  1收支表没有本月记录 ，余额表中也没记录   2结算成功
	 *
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false,rollbackFor=Exception.class)
	public int jieZhang(String fDate,HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		//1 查询收支明细中 本月份记录(去重) 得到本月份不重复的账户
		//本月无记录也要讲
		List<String> fundList = fundAccountBillService.queryDistinct(fDate);
		//2循环  不重复的账户
		if(fundList.size()==0){
			//说明所有账户本期都没有消费记录，但是也应该结账  将余额表中的记录复制下一个月
			//四月份没有消费记录也要将余额表中四月份的复制成五月份的
			BalancePo po=new BalancePo();
			po.setfPeriod(fDate.split("-")[0]);
			po.setfMoun(fDate.split("-")[1]);
			//查询本月余额中的记录
			List<BalancePo> poList=fundAccountCloseMapper.queryBalance(po);
			if(poList.size()>0){
				//循环每一条记录 添加至下一个月
				for(int i=0;i<poList.size();i++){
					BalancePo tempPo=new BalancePo();
					tempPo.setfNursinghomeID(poList.get(i).getfNursinghomeID());
					tempPo.setfAmount(poList.get(i).getfAmount());
					tempPo.setfBalance(poList.get(i).getfBalance());
					tempPo.setfInamount(poList.get(i).getfInamount());
					tempPo.setfOutamount(poList.get(i).getfOutamount());
					tempPo.setfFundaccountID(poList.get(i).getfFundaccountID());
					tempPo.setfPeriod(this.getNextMonth(fDate).split("-")[0]);
					tempPo.setfMoun(this.getNextMonth(fDate).split("-")[1]);
					int result=fundAccountCloseMapper.insertBalance(tempPo);
					if(result<=0){
						//添加失败
						logger.debug("本月所有账户均没有消费的情况下，更新余额表记录失败");
						throw new Exception();
					}
				}
				return 2;
			}else{
				//本月没有任何消费  余额表中也不存在任何消费记录
				return 1;
			}
		}
		//循环收支明细表中的记录
		for(int i=0;i<fundList.size();i++){
			//得到了第i个账户的信息
			String fFundAccount=fundList.get(i);
			//查询第i个账户中是否存在期初行为
			List<FundAccountBillPo> billList = fundAccountBillService.queryFundAccountBillByDate(fDate, fFundAccount, "0");
			if(billList.size()>0){
				//说明存在期初行为
				//首先去余额表中查询  是否有本账户的信息
				BalancePo balancePo=new BalancePo();
				balancePo.setfFundaccountID(fFundAccount);
				List<BalancePo> balancePoList = fundAccountCloseMapper.queryBalance(balancePo);
				if(balancePoList.size()<=0){
					//说明不存在本账户的信息
					//应该初始化本账户的信息
					//不存在记录 添加至余额表 金额作为期初金额
					balancePo.setfAmount(billList.get(0).getfAmount());
					balancePo.setfBalance("0");
					balancePo.setfInamount("0");
					balancePo.setfOutamount("0");
					//balancePo.setfId(UUID.randomUUID().toString());
					balancePo.setfNursinghomeID(user.getOldhouse());
					int year1=Integer.parseInt(fDate.split("-")[0]);
					int month1=Integer.parseInt(fDate.split("-")[1]);
					//期初的记录将年和月存储成本年和本月  不是期初的需要存储为下一个月
					balancePo.setfPeriod(year1+"");
					balancePo.setfMoun(month1+"");
					int result=fundAccountCloseMapper.insertBalance(balancePo);
					if(result>0){
						//期初的初始化成功  查询本账户不是期初的收支明细
						List<FundAccountBillPo> billList1 = fundAccountBillService.queryFundAccountBillByDate(fDate, fFundAccount, "");
						double fInAmount=0;
						double fOutAmount=0;
						double fAmount=0;
						if(billList1.size()>0){
							for(int j=0;j<billList1.size();j++){
								//临时变量用于存储本每条收支记录的资金
								double tempAmount=Double.parseDouble(billList1.get(j).getfAmount());
								if(tempAmount>=0){
									fInAmount+=tempAmount;
								}else{
									fOutAmount+=tempAmount;
								}
								//计算总收支
								fAmount+=tempAmount;
							}
							//查询本期的期初金额  实际上 这是有期初有收支的账户  首先添加了期初的信息  因此金额也就是billList中的金额
							fAmount+=Double.parseDouble(billList.get(0).getfAmount());
							BalancePo balancePo1=new BalancePo();
							//更改期初中的收支用的PO
							BalancePo updBalancePo=new BalancePo();
							balancePo1.setfFundaccountID(fFundAccount);
							updBalancePo.setfFundaccountID(fFundAccount);
							//添加成下一个月
							balancePo1.setfPeriod(this.getNextMonth(fDate).split("-")[0]);
							balancePo1.setfMoun(this.getNextMonth(fDate).split("-")[1]);
							balancePo1.setfBalance("0");
							balancePo1.setfAmount(fAmount+"");
							balancePo1.setfInamount("0");
							balancePo1.setfOutamount("0");

							updBalancePo.setfInamount(fInAmount+"");
							updBalancePo.setfOutamount(fOutAmount+"");
							updBalancePo.setfBalance(fAmount+"");
							//balancePo1.setfId(UUID.randomUUID().toString());
							balancePo1.setfNursinghomeID(user.getOldhouse());
							//修改本月期初的记录  修改的是支出 收入和余额
							int updResult=fundAccountCloseMapper.updateBalance(updBalancePo);
							if(updResult>0){
								int result1=fundAccountCloseMapper.insertBalance(balancePo1);
								if(result1>0){
									//判读是不是最后一次  如果是则返回
									if(i==fundList.size()-1){
										//所有有消费记录的已经完成
                                        //跳出循环  去添加当期没有消费信息至余额表中
                                        break;
									}
									//不是最后一次则继续执行循环
									continue;
								}else{
									//添加失败
									logger.debug("存在期初也存在收支的账户，收支添加至余额表中失败");
									throw new Exception();
								}
							}else{
								//添加失败
								logger.debug("存在期初也存在收支的账户，修改本月期初记录失败");
								throw new Exception();
							}
						}else{
							//本账户不存在其他  应该存入到下一个月的期初中
							BalancePo nextBalancePo=new BalancePo();
							nextBalancePo.setfNursinghomeID(user.getOldhouse());
							nextBalancePo.setfFundaccountID(fFundAccount);
							//添加成下一个月
							nextBalancePo.setfPeriod(this.getNextMonth(fDate).split("-")[0]);
							nextBalancePo.setfMoun(this.getNextMonth(fDate).split("-")[1]);
							nextBalancePo.setfAmount(billList.get(0).getfAmount());
							nextBalancePo.setfInamount("0");
							nextBalancePo.setfOutamount("0");
							nextBalancePo.setfBalance("0");
							int k=fundAccountCloseMapper.insertBalance(nextBalancePo);
							if(k>0){
								if(i==fundList.size()-1){
									//所有账户都结算成功
									//跳出循环  去添加当期没有消费信息至余额表中
									break;
								}
								continue;
							}else{
								//说明添加失败
								logger.debug("添加期初到余额表中失败");
								throw new Exception();
							}
						}
					}else{
						//说明未初始化成功 抛出异常
						logger.debug("添加期初到余额表中失败");
						throw new Exception();
					}
				}else{
					//本账户不存在其他
					if(i==fundList.size()-1){
						//跳出循环  去添加当期没有消费信息至余额表中
						break;
					}else{
						continue;
					}

				}//存在本账户信息则不需要进行任何操作
			}else{
				//本账户不存在期初金额  也就是本账户本期的收支以及转账行为统一计算
				List<FundAccountBillPo> billList2 = fundAccountBillService.queryFundAccountBillByDate(fDate, fFundAccount, "");
				double fAmount=0;
				double fInAmount=0;
				double fOutAmount=0;
				for(int k=0;k<billList2.size();k++){
					//循环本账户
					double tempAmount=Double.parseDouble(billList2.get(k).getfAmount());
					if(tempAmount>=0){
						fInAmount+=tempAmount;
					}else{
						fOutAmount+=tempAmount;
					}
					fAmount+=tempAmount;
				}
				//还需要查询本月余额表中期初的金额
				BalancePo balancePo3=new BalancePo();
				BalancePo updBalancePo=new BalancePo();

				balancePo3.setfPeriod(fDate.split("-")[0]);
				balancePo3.setfMoun(fDate.split("-")[1]);

				updBalancePo.setfPeriod(fDate.split("-")[0]);
				updBalancePo.setfMoun(fDate.split("-")[1]);

				balancePo3.setfFundaccountID(fFundAccount);
				updBalancePo.setfFundaccountID(fFundAccount);
				updBalancePo.setfInamount(fInAmount+"");
				updBalancePo.setfOutamount(fOutAmount+"");

				List<BalancePo> balancePoList = fundAccountCloseMapper.queryBalance(balancePo3);
				if(balancePoList.size()>0){
                    //balance=famount+inamount+ountamount(存的是负数)
                    updBalancePo.setfBalance(fAmount+Double.parseDouble(balancePoList.get(0).getfAmount())+"");
					int updResult=fundAccountCloseMapper.updateBalance(updBalancePo);
					if(updResult>0) {
						//先更新本期  然后添加下期
						String fBalaceAmount = balancePoList.get(0).getfAmount();
						fAmount += Double.parseDouble(fBalaceAmount);
						//添加成下一个月
						balancePo3.setfPeriod(this.getNextMonth(fDate).split("-")[0]);
						balancePo3.setfMoun(this.getNextMonth(fDate).split("-")[1]);
						balancePo3.setfAmount(fAmount + "");
						balancePo3.setfInamount("0");
						balancePo3.setfBalance("0");
						balancePo3.setfOutamount("0");
						//	balancePo3.setfId(UUID.randomUUID().toString());
						balancePo3.setfNursinghomeID(user.getOldhouse());
						int result3 = fundAccountCloseMapper.insertBalance(balancePo3);
						if (result3 > 0) {
							//判读是不是最后一次  如果是则返回
							if (i == fundList.size() - 1) {
								//跳出循环  去添加当期没有消费信息至余额表中
								break;
							} else {
								continue;
							}
						} else {
							logger.debug("不存在期初的账户添加至余额表失败");
							throw new Exception();
						}
					}else{
						//添加失败
						logger.debug("存在期初也存在收支的账户，修改本月期初记录失败");
						throw new Exception();
					}

				}else{
					return 0;
				}
			}

		}//以上已经循环的是有消费记录的部分
		//当明细表中所有记录都已经结账成功  需要在余额表中继续判断 （当期没有收支的用户余额复制到下一期）
		//部分账户存在消费
		BalancePo po=new BalancePo();
		po.setfPeriod(fDate.split("-")[0]);
		po.setfMoun(fDate.split("-")[1]);
		//查询本期账户余额表中的记录
		List<BalancePo> getBalanceByMonth=fundAccountCloseMapper.queryBalance(po);
			for(int i=0;i<getBalanceByMonth.size();i++){
				//查询不存在下一个月的信息的 直接复制 成下一个月
				BalancePo balancePo3=new BalancePo();
				balancePo3.setfFundaccountID(getBalanceByMonth.get(i).getfFundaccountID());
				balancePo3.setfPeriod(this.getNextMonth(fDate).split("-")[0]);
				balancePo3.setfMoun(this.getNextMonth(fDate).split("-")[1]);
				List<BalancePo> balancePos=fundAccountCloseMapper.queryBalance(balancePo3);
				if(balancePos.size()==0){
					BalancePo temp=new BalancePo();
					temp.setfNursinghomeID(getBalanceByMonth.get(i).getfNursinghomeID());
					temp.setfAmount(getBalanceByMonth.get(i).getfAmount());
					temp.setfBalance(getBalanceByMonth.get(i).getfBalance());
					temp.setfInamount(getBalanceByMonth.get(i).getfInamount());
					temp.setfOutamount(getBalanceByMonth.get(i).getfOutamount());
					temp.setfFundaccountID(getBalanceByMonth.get(i).getfFundaccountID());
					temp.setfPeriod(this.getNextMonth(fDate).split("-")[0]);
					temp.setfMoun(this.getNextMonth(fDate).split("-")[1]);
					int result=fundAccountCloseMapper.insertBalance(temp);
					if(result<=0){
						//添加失败
						logger.debug("本月部分账户存在消费的情况下，更新余额表记录失败");
						throw new Exception();
					}else{
						if(i==(getBalanceByMonth.size()-1)){
							//最后一个
							return 2;
						}
						continue;
					}
				}
			}
		return 2;
	}

	/**
	 * 反结算  返回1代表表中无记录  抛异常代表失败  返回正数表示成功
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false,rollbackFor = Exception.class)
	public int balanceBack(String fDate) throws Exception{
		logger.debug("反结账传进来的参数为"+fDate);
		BalancePo balancePo=new BalancePo();
		BalancePo updBalacePo=new BalancePo();

		balancePo.setfPeriod(fDate.split("-")[0]);
		balancePo.setfMoun(fDate.split("-")[1]);

		int year = Integer.parseInt(fDate.split("-")[0]);
		int month = Integer.parseInt(fDate.split("-")[1]);
		if (Integer.parseInt(fDate.split("-")[1]) == 1) {
			updBalacePo.setfPeriod(year - 1 + "");
			updBalacePo.setfMoun("12");
		} else {
			updBalacePo.setfPeriod(fDate.split("-")[0]);
			updBalacePo.setfMoun("0"+((month % 12) - 1));
		}
		//用于查询收支明细表中是上期否为期初
		String fQuweyDate=updBalacePo.getfPeriod()+"-"+updBalacePo.getfMoun();
		updBalacePo.setfBalance("0");
		updBalacePo.setfInamount("0");
		updBalacePo.setfOutamount("0");
		logger.debug("balancePo="+balancePo.toString());
		//反结账应该将本期删除  然后更新上一期的记录
		List<BalancePo> delBalanceList=fundAccountCloseMapper.queryBalance(balancePo);
		if(delBalanceList.size()>0){
			int result=fundAccountCloseMapper.deleteBalance(balancePo);
			if(result==delBalanceList.size()){
				//首先查询是否存在上一期的记录
				List<BalancePo> balanceList=fundAccountCloseMapper.queryBalance(updBalacePo);
				if(balanceList.size()>0){
					int updResult=fundAccountCloseMapper.updateBalance(updBalacePo);
					if(updResult>0){
						//在此处还得判断本账户上一期是否为期初  是则需要将期初的也删除
						//1查询余额表中上一期的记录  2根据账户id和日期查询上一期是否为期初
						for(int i=0;i<balanceList.size();i++){
							List<FundAccountBillPo> isStart = fundAccountBillService.queryFundAccountBillByDate(fQuweyDate, balanceList.get(i).getfFundaccountID(), "0");
							if(isStart.size()>0){
								//删除上期
								int j=fundAccountCloseMapper.deleteBalance(updBalacePo);
								if(j>0){
									return j;
								}else{
									logger.debug("上期为期初的情况下，删除上期记录失败，开始回滚");
									throw new Exception();
								}
							}
						}
						//fundAccountBillService.queryFundAccountBillByDate();
						return updResult;
					}else{
						logger.debug("修改上期记录失败，开始回滚");
						throw new Exception();
					}
				}else{
					return result;
				}
			}else{
				logger.debug("删除本期记录失败，开始回滚");
				throw new Exception();
			}
		}else{
			return -1;
		}
	}

	/**
	 * 得到最大的日期
	 */
	public String getMaxDate() {
		BalancePo balance = fundAccountCloseMapper.getMaxDate();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		if(balance==null){
			return sdf.format(new Date());
		}else{
			return balance.getfPeriod()+"-"+balance.getfMoun();
		}
	}

	//根据本月得到 下一个月 本月日期的格式为  19997-09/1997-9
	public String getNextMonth(String fDate){
		String newDate;
		int year = Integer.parseInt(fDate.split("-")[0]);
		int month = Integer.parseInt(fDate.split("-")[1]);
		if (Integer.parseInt(fDate.split("-")[1]) == 12) {
			newDate=(year + 1)+"-"+"1";

		} else {
			newDate=year+"-"+((month % 12) + 1);
		}
		return newDate;
	}
}



