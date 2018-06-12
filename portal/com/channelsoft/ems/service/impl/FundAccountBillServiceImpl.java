package com.channelsoft.ems.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.channelsoft.ems.mapper.FundAccountBillDelRecordMapper;
import com.channelsoft.ems.mapper.FundAccountBillMapper;
import com.channelsoft.ems.mapper.FundAccountBillModRecordMapper;
import com.channelsoft.ems.po.CwglPaymentPo;
import com.channelsoft.ems.po.FundAccountBillDelRecordPo;
import com.channelsoft.ems.po.FundAccountBillModRecordPo;
import com.channelsoft.ems.po.FundAccountBillPo;
import com.channelsoft.ems.po.FundAccountPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.FundAccountBillService;
import com.channelsoft.ems.service.FundAccountService;
import org.springframework.util.StringUtils;

@Service
public class FundAccountBillServiceImpl implements FundAccountBillService {

	@Autowired
	private FundAccountBillMapper fundAccountBillMapper;
	@Autowired
	private FundAccountBillModRecordMapper modRecordMapper;
	@Autowired
	private FundAccountBillDelRecordMapper delRecordMapper;
	@Autowired
	private FundAccountService fundAccountService;

	private Logger logger=Logger.getLogger(FundAccountBillServiceImpl.class);

	public List<CwglPaymentPo> getPayments(String id,String type) {
		logger.debug("开始查询业务杂项");
		List<CwglPaymentPo> list=fundAccountBillMapper.getPayments(id,type);
		return list;
	}

	//@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,rollbackFor={Exception.class})
	public int addFundAccountBill(FundAccountBillPo fundAccountBillPo,HttpServletRequest request){
		logger.debug("开始添加收支明细");
		Date date=new Date();
		//当前日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//流水用
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd");
		String fNumerTime=sdf1.format(date);
		//流水
		String nowTime=sdf.format(date);
		//转入账户的uuid
		UUID iUuid=UUID.randomUUID();
		//主键UUID
		if(StringUtils.isEmpty(fundAccountBillPo.getfId())){
			fundAccountBillPo.setfId(iUuid.toString());
		}
		//养老院ID
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		fundAccountBillPo.setFnursinghomeID(user.getOldhouse());
		//审核时间
		fundAccountBillPo.setfAuditTime(nowTime);
		//创建时间
		if(StringUtils.isEmpty(fundAccountBillPo.getfCreateTime())){
			fundAccountBillPo.setfCreateTime(nowTime);
		}
		fundAccountBillPo.setfCreateTime(nowTime);
		fundAccountBillPo.setfStatus("0");
		//单号的格式为GLS+yyyymmdd+XXXX（流水)
		StringBuffer inNumber=new StringBuffer("GLS");
		inNumber.append(fNumerTime);
		inNumber.append((int)(Math.random()*(9999-1000+1))+1000);
		fundAccountBillPo.setfProofnumber(inNumber.toString());
		int result=fundAccountBillMapper.addBill(fundAccountBillPo);
		return result;
	}

	/**
	 * 收支明细的查询
	 */
	public List<FundAccountBillPo> queryFundAccountBill(int page, int pageSize, FundAccountBillPo fundAccountBillPo) {
		logger.debug("进入queryFundAccountBill开始查询");
		List<FundAccountBillPo> billList=fundAccountBillMapper.queryFundAccountBillPo(page, pageSize, fundAccountBillPo);
		return billList;
	}

	/**
	 * 得到表中总数  分页使用
	 */
	public int getTotal(FundAccountBillPo fundAccountBillPo) {
		logger.info("开始查询收支明细的总数getTotal");
		int result=fundAccountBillMapper.getTotal(fundAccountBillPo);
		return result;
	}

	/**
	 * 更改状态
	 */
	public int changeStatus(FundAccountBillPo fundAccountBillPo) {
		int result=fundAccountBillMapper.changeStatus(fundAccountBillPo);
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,rollbackFor={Exception.class})
	public int updateFundAccountBill(FundAccountBillPo fundAccountBillPo, HttpServletRequest request) throws Exception{
		List<FundAccountBillPo> list =fundAccountBillMapper.queryFundAccountBillPo(0, 1, fundAccountBillPo);
		FundAccountBillModRecordPo modRecordPo=new FundAccountBillModRecordPo();
		double fAmount,fNewAmount,fChangeAmount;
		UUID uuid=UUID.randomUUID();
		Date date=new Date();
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		//当前日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String nowTime=sdf.format(date);
		if(list.size()>0){
			System.out.println(list.get(0).getfType());
			if(list.get(0).getfType().equals("2")){
				modRecordPo.setFname("收入");
			}else if(list.get(0).getfType().equals("3")){
				modRecordPo.setFname("支出");
			}
			fAmount=Double.parseDouble(list.get(0).getfAmount());
			fNewAmount=Double.parseDouble(fundAccountBillPo.getfAmount());
			fChangeAmount=fNewAmount-fAmount;
			modRecordPo.setfAmount(fAmount+"");
			modRecordPo.setfNewAmount(fNewAmount+"");
			modRecordPo.setfChangeAmount(fChangeAmount+"");
			modRecordPo.setfChangeDate(nowTime);
			modRecordPo.setfId(uuid.toString());
			modRecordPo.setFnumber(fundAccountBillPo.getfNumber());
			modRecordPo.setfPayment(fundAccountBillPo.getfPayment());
			modRecordPo.setfOperationer(fundAccountBillPo.getfOperator());
			modRecordPo.setfRemark(request.getParameter("fRemark"));
			//开始修改账户明细表
			fundAccountBillPo.setfModificationTime(nowTime);
			fundAccountBillPo.setfModifierID(user.getEmployId());
			//修改账户余额中的现金额
			//判断修改之后账户是否为 之前转出或转入的账户
			//如果是 需要进行一下三步  1、修改资金账户中的余额  2、修改账户明细   3、添加修改记录至数据库
			//如果不是 需要进行以下四步  1、恢复之前支出或者收入的余额  2、修改当前账户的余额  3、修改账户明细  4、添加修改记录至数据库
			//只有1和4不同 提取出相同点2、3
			if(fundAccountBillPo.getfFundaccount().equals(list.get(0).getfFundaccount())){
				logger.debug("开始");
				FundAccountPo account=new FundAccountPo();
				account.setfId(fundAccountBillPo.getfFundaccount());
				account.setfRestAmount(fChangeAmount+"");
				int result=fundAccountService.updateFundAmount(account, request);
				if(result>0){
					int result1=fundAccountBillMapper.updateFundAccountBill(fundAccountBillPo);
					if(result1>0){
						int result2=modRecordMapper.insertRecord(modRecordPo);
						if(result2>0){
							return result2;
						}else{
							logger.debug("添加修改记录失败，开始回滚");
							throw new Exception();
						}
					}else{
						logger.debug("修改账户明细失败，开始回滚");
						throw new Exception();
					}
				}else{
					logger.debug("修改原账户余额失败，开始回滚");
					throw new Exception();
				}
			}else{
				//和原账户不相同的情况
				//恢复原账户记录
				FundAccountPo beforeAccount=new FundAccountPo();
				FundAccountPo afterAccount=new FundAccountPo();
				beforeAccount.setfId(list.get(0).getfFundaccount());
				double befordAmount=-fAmount;
				beforeAccount.setfRestAmount(befordAmount+"");
				int s_result=fundAccountService.updateFundAmount(beforeAccount, request);
				if(s_result<=0){
					logger.debug("恢复原账户余额失败，开始回滚");
					throw new Exception();
				}else{
					//修改当前账户的余额
					afterAccount.setfRestAmount(fAmount+"");
					afterAccount.setfId(fundAccountBillPo.getfFundaccount());
					int s_result1=fundAccountService.updateFundAmount(afterAccount,request);
					if(s_result1<=0){
						logger.debug("修改当前账户余额失败失败，开始回滚");
						throw new Exception();
					}else{
						int s_result2=fundAccountBillMapper.updateFundAccountBill(fundAccountBillPo);
						if(s_result2<=0){
							logger.debug("修改账户明细失败，开始回滚");
							throw new Exception();
						}else{
							int s_result3=modRecordMapper.insertRecord(modRecordPo);
							if(s_result3<=0){
								logger.debug("添加修改记录失败，开始回滚");
								throw new Exception();
							}else{
								return s_result3;
							}
						}
					}
				}
			}
		}else{
			return 0;
		}
	}

	/**
	 * 删除资金明细记录
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,rollbackFor={Exception.class})
	public int delFundAccountBill(FundAccountBillPo fundAccountBillPo, HttpServletRequest request) throws Exception {
		List<FundAccountBillPo> list =fundAccountBillMapper.queryFundAccountBillPo(0, 1, fundAccountBillPo);
		FundAccountBillDelRecordPo delRecordPo=new FundAccountBillDelRecordPo();
		FundAccountPo fundAccountPo=new FundAccountPo();
		double fAmount;
		UUID uuid=UUID.randomUUID();
		Date date=new Date();
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		//当前日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String nowTime=sdf.format(date);
		if(list.size()>0){
			if(list.get(0).getfType().equals("2")){
				delRecordPo.setfName("收入");
			}else if(list.get(0).getfType().equals("3")){
				delRecordPo.setfName("支出");
			}
			fAmount=Double.parseDouble(list.get(0).getfAmount());
			delRecordPo.setfAmount(fAmount+"");
			delRecordPo.setfDeldate(nowTime);
			delRecordPo.setfId(uuid.toString());
			delRecordPo.setfOprationer(user.getEmployId());
			delRecordPo.setfRemark(request.getParameter("fRemark"));
			delRecordPo.setfPayment(list.get(0).getfPayment());
			delRecordPo.setFnumber(list.get(0).getfNumber());

			fundAccountPo.setfRestAmount(-fAmount+"");
			fundAccountPo.setfId(list.get(0).getfFundaccount());
			int result=fundAccountService.updateFundAmount(fundAccountPo, request);
			if(result>0){
				int result1=fundAccountBillMapper.delFundAccountBill(fundAccountBillPo);
				if(result1>0){
					int result2=delRecordMapper.insertDelRecord(delRecordPo);
					if(result2>0){
						return result2;
					}else{
						logger.debug("添加删除账户明细失败，开始回滚");
						throw new Exception();
					}
				}else{
					logger.debug("删除账户明细失败，开始回滚");
					throw new Exception();
				}
			}else{
				logger.debug("恢复记录失败，开始回滚");
				throw new Exception();
			}
		}else{
			return 0;
		}
	}


	/**
	 * 根据日期和账户号查询  本账户记录
	 */
	public List<FundAccountBillPo> queryFundAccountBillByDate(String fDate, String fundAccount,String fType) {
		List<FundAccountBillPo> list=fundAccountBillMapper.queryByMonth(fDate, fundAccount,fType);
		return list;
	}

	/**
	 * 去重查询本月分收支明细中的所有记录
	 */
	public List<String> queryDistinct(String fDate) {
		List<String> list=fundAccountBillMapper.queryDistinct(fDate);
		return list;
	}
}
