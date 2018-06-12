package com.channelsoft.ems.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.channelsoft.ems.mapper.FundAccountMapper;
import com.channelsoft.ems.po.FundAccountBillPo;
import com.channelsoft.ems.po.FundAccountPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.FundAccountBillService;
import com.channelsoft.ems.service.FundAccountService;
@Service
public class FundAccountServiceImpl implements FundAccountService {

	private Logger logger=Logger.getLogger(FundAccountServiceImpl.class);

	@Autowired
	private FundAccountMapper fundAccountMapper;

	@Autowired
	private FundAccountBillService fundAccountBillService;

	public List<FundAccountPo> queryFundAccount(int page, int pageSize, FundAccountPo fundAccountPo,
												HttpServletRequest request, HttpServletResponse response) {
		logger.debug("进入queryFundAccount，开始查询");
		List<FundAccountPo> fundAccountList=fundAccountMapper.queryFundAccount(page, pageSize, fundAccountPo);
		return fundAccountList;
	}

	public List<FundAccountPo> queryIgnoreStatus(int page, int pageSize, FundAccountPo fundAccountPo,
												 HttpServletRequest request, HttpServletResponse response) {
		logger.debug("进入queryFundAccount，开始查询");
		List<FundAccountPo> fundAccountList=fundAccountMapper.queryIgnoreStatus(page, pageSize, fundAccountPo);
		return fundAccountList;
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false,rollbackFor=Exception.class)
	public int addFundAccount(FundAccountPo fundAccountPo,HttpServletRequest request) throws Exception{
		logger.debug("开始添加");
		//fNursinghomeId为假值
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		fundAccountPo.setfNursinghomeId(user.getOldhouse());
		fundAccountPo.setfAuditorId(user.getEmployId());
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd");
		String nowTime=sdf.format(date);
		String fNumerTime=sdf1.format(date);
		UUID uuid=UUID.randomUUID();
		UUID uuid1=UUID.randomUUID();
		fundAccountPo.setfId(uuid1.toString());
		fundAccountPo.setfAuditTime(nowTime);
		fundAccountPo.setfModifierId(user.getEmployId());
		fundAccountPo.setfModificationTime(nowTime);
		fundAccountPo.setfCreatorId(user.getEmployId());
		fundAccountPo.setfCreateTime(nowTime);
		fundAccountPo.setfRestAmount(fundAccountPo.getfAmount());
		//使用中
		fundAccountPo.setfStatus("0");
		fundAccountPo.setfRemarks("");

		FundAccountBillPo bill=new FundAccountBillPo();
		bill.setfId(uuid.toString());
		bill.setFnursinghomeID(user.getOldhouse());
		bill.setfAuditorID(user.getEmployId());
		bill.setfAuditTime(nowTime);
		bill.setfCreatorID(user.getEmployId());
		bill.setfCreateTime(nowTime);
		bill.setfType("0");
		bill.setfModifierID(user.getEmployId());
		bill.setfModificationTime(nowTime);
		//单号的格式为GLS+yyyymmdd+XXXX（流水)
		StringBuffer fNumber=new StringBuffer("GLS");
		fNumber.append(fNumerTime);
		fNumber.append((int)(Math.random()*(9999-1000+1))+1000);
		bill.setfNumber(fNumber.toString());
		//0位已审核，1位待审核  默认位待审核
		bill.setfStatus("0");
		bill.setfAmount(fundAccountPo.getfAmount());
		bill.setFbizdate(nowTime);
		//资金账户表中的id
		bill.setfFundaccount(uuid1.toString());
		bill.setfOperator(user.getEmployId());

		int result=fundAccountMapper.addFundAccount(fundAccountPo);
		if(result<0){
			logger.debug("添加账户失败，开始回滚");
			throw new Exception("添加账户失败");
		}else{
			int i=fundAccountBillService.addFundAccountBill(bill,request);
			if(i>0){
				return i;
			}else{
				logger.debug("添加账户失败，开始回滚");
				throw new Exception("添加账户失败");
			}
		}


	}

	public int getCount(FundAccountPo fundAccountPo) {
		logger.debug("开始查询总条数");
		int count=fundAccountMapper.getCount(fundAccountPo);
		return count;
	}

	public int getCountIgnoreStatus(FundAccountPo fundAccountPo) {
		logger.debug("开始查询总条数");
		int count=fundAccountMapper.getCountIgnoreStatus(fundAccountPo);
		return count;
	}

	public String getStatusNameById(String id) {
		String dcValue=fundAccountMapper.getStatusNameById(id);
		return dcValue;
	}

	public int changeStatus(String fId,String fStatus) {
		try{
			int result=fundAccountMapper.updateFundAccountStatus(fId, fStatus);
			return result;
		}catch(Exception e){
			logger.debug("更改状态sql语句执行失败");
			return 0;
		}
	}

	public int check(FundAccountPo fundAccountPo) {
		try{
			int result=fundAccountMapper.check(fundAccountPo);
			return result;
		}catch(Exception e){
			logger.debug("校验的sql执行失败");
			return -1;
		}
	}

	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false,rollbackFor=Exception.class)
	public int updateFundAccount(FundAccountPo fundAccountPo,HttpServletRequest request) throws Exception{
		FundAccountPo fundPo=new FundAccountPo();
		fundPo.setfId(fundAccountPo.getfId());
		//根据账户id查询修改之前的账户信息
		List<FundAccountPo> list=fundAccountMapper.queryFundAccount(0, 1, fundPo);
		double beforeAmount=Double.parseDouble(list.get(0).getfAmount());
		double nowFundAmount=Double.parseDouble(fundAccountPo.getfAmount());
		double changeAmount=nowFundAmount-beforeAmount;
		//得到登录人的信息
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String nowTime=sdf.format(new Date());
		fundAccountPo.setfModificationTime(nowTime);
		fundAccountPo.setfModifierId(user.getEmployId());
		//	List<FundAccountPo> accountList = queryFundAccount(0,1,fundAccountPo,request,null);
		logger.debug(fundAccountPo.toString());
		int result=fundAccountMapper.updateFundAccount(fundAccountPo);
		if(result>0){
			fundPo.setfRestAmount(changeAmount+"");
			int result1=updateFundAmount(fundPo, request);
			if(result1>0){
				FundAccountBillPo fundAccountBillPo=new FundAccountBillPo();
				fundAccountBillPo.setfType("0");
				fundAccountBillPo.setfFundaccount(list.get(0).getfId());
				List<FundAccountBillPo> billPo = fundAccountBillService.queryFundAccountBill(0, 1, fundAccountBillPo);
				if(billPo.size()>0){
					fundAccountBillPo=billPo.get(0);
					fundAccountBillPo.setfAmount(fundAccountPo.getfAmount());
					fundAccountBillPo.setfNumber(fundAccountPo.getfNumber());
					fundAccountBillPo.setfName(fundAccountPo.getfName());
					fundAccountBillPo.setfAuditorID(fundAccountPo.getfHeader());
					int result2=fundAccountBillService.updateFundAccountBill(fundAccountBillPo, request);
					logger.debug(result2);
					if(result2>0){
						return result2;
					}else{
						logger.debug("修改收支明细中账户期初信息失败");
						throw new Exception();
					}
				}else{
					logger.debug("修改账户时，修改期初信息失败");
					throw new Exception();
				}
			}else{
				logger.debug("添加失败，开始回滚");
				throw new Exception();
			}
		}else{
			throw new Exception();
		}
	}

	public int updateFundAmount(FundAccountPo fundAccountPo,HttpServletRequest request) {
		logger.debug("更改资金账户余额传进来的参数为"+fundAccountPo.toString());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		String nowTime=sdf.format(new Date());
		fundAccountPo.setfModificationTime(nowTime);
		fundAccountPo.setfModifierId(user.getEmployId());
		try{
			int result=fundAccountMapper.updateAmount(fundAccountPo);
			return result;
		}catch(Exception e){
			logger.debug("更改账户余额信息sql语句执行失败");
			return 0;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,rollbackFor={Exception.class})
	public int transfer(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FundAccountBillPo outFundAccoutBill=new FundAccountBillPo();
		FundAccountBillPo inFundAccountBill=new FundAccountBillPo();
		FundAccountPo outFundAccount=new FundAccountPo();
		FundAccountPo inFundAccount=new FundAccountPo();
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		//日期使用
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//流水使用
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyyMMdd");
		String nowTime=sdf.format(date);
		String fNumerTime=sdf1.format(date);
		
		//转出账户的uuid
		UUID oUuid=UUID.randomUUID();
		//转入账户的uuid
		UUID iUuid=UUID.randomUUID();
		//主键UUID
		outFundAccoutBill.setfId(oUuid.toString());
		inFundAccountBill.setfId(iUuid.toString());

		outFundAccoutBill.setfCreatorID(user.getEmployId());
		inFundAccountBill.setfCreatorID(user.getEmployId());

		outFundAccoutBill.setfAuditorID(user.getEmployId());
		inFundAccountBill.setfAuditorID(user.getEmployId());
		//创建时间
		outFundAccoutBill.setfCreateTime(nowTime);
		inFundAccountBill.setfCreateTime(nowTime);
		//业务时间
		outFundAccoutBill.setFbizdate(request.getParameter("fbizdate"));
		inFundAccountBill.setFbizdate(request.getParameter("fbizdate"));

		/*///养老院ID  假数据
		outFundAccoutBill.setFnursinghomeID("1");
		inFundAccountBill.setFnursinghomeID("1");
		//审核人 
		outFundAccoutBill.setfAuditorID("1");
		inFundAccountBill.setfAuditorID("1");
		//审核时间
		outFundAccoutBill.setfAuditTime(nowTime);
		inFundAccountBill.setfAuditTime(nowTime);
		//创建人
		outFundAccoutBill.setfCreatorID("1");
		inFundAccountBill.setfCreatorID("1");
		//创建时间
		outFundAccoutBill.setfCreateTime(nowTime);
		inFundAccountBill.setfCreateTime(nowTime);*/
		//业务类型  转账
		outFundAccoutBill.setfType("1");
		inFundAccountBill.setfType("1");
		//单号的格式为GLS+yyyymmdd+XXXX（流水)
		StringBuffer outNumber=new StringBuffer("GLS");
		StringBuffer inNumber=new StringBuffer("GLS");
		outNumber.append(fNumerTime);
		inNumber.append(fNumerTime);
		outNumber.append((int)(Math.random()*(9999-1000+1))+1000);
		inNumber.append((int)(Math.random()*(9999-1000+1))+1000);
		outFundAccoutBill.setfNumber(outNumber.toString());
		inFundAccountBill.setfNumber(inNumber.toString());
		//0位已审核，1位待审核  默认位待审核
		outFundAccoutBill.setfStatus("0");
		inFundAccountBill.setfStatus("0");

		/*String fDate=request.getParameter("fDate");
		//业务日期
		outFundAccoutBill.setFbizdate(fDate);
		inFundAccountBill.setFbizdate(fDate);*/

		String Foperator=request.getParameter("ts_fKeeper");
		//操作人
		outFundAccoutBill.setfOperator(Foperator);
		inFundAccountBill.setfOperator(Foperator);
		//转账备注
		String fRemarks=request.getParameter("fRemarks");
		outFundAccoutBill.setfRemarks(fRemarks);
		inFundAccountBill.setfRemarks(fRemarks);

		double outAmount=-Double.parseDouble(request.getParameter("outAmount"));
		//设置转账金额  其中转出方为负  转入方为正
		outFundAccoutBill.setfAmount(outAmount+"");
		inFundAccountBill.setfAmount(-outAmount+"");
		logger.debug(outFundAccoutBill.getfAmount());
 		logger.debug(inFundAccountBill.getfAmount());
		inFundAccount.setfRestAmount(-outAmount+"");
		outFundAccount.setfRestAmount(outAmount+"");

		//账户名称
		String outAccount=request.getParameter("outAccount");
		String inAccount=request.getParameter("inAccount");
		outFundAccoutBill.setfFundaccount(outAccount);
		inFundAccountBill.setfFundaccount(inAccount);
		outFundAccount.setfId(outAccount);
		inFundAccount.setfId(inAccount);

		int result1=fundAccountBillService.addFundAccountBill(outFundAccoutBill,request);
		if(result1>0){
			int result2=fundAccountBillService.addFundAccountBill(inFundAccountBill,request);
			if(result2>0){
				int result3=updateFundAmount(inFundAccount,request);
				if(result3>0){
					int result4=updateFundAmount(outFundAccount,request);
					if(result4>0){
						return result4;
					}else{
						logger.debug("账户转出失败");
						throw new Exception("开始回滚");
					}
				}else{
					logger.debug("账户转入失败");
					throw new Exception("开始回滚");
				}
			}else{
				throw new Exception("开始回滚");
			}
		}else{
			throw new Exception("语句执行失败，开始回滚");
		}
	}
	/**
	 * 账户收入
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,rollbackFor={Exception.class})
	public int fundAccountIn(FundAccountPo fundAccountPo,FundAccountBillPo fundAccountBillPo,HttpServletRequest request) throws Exception{
		logger.debug("账户收入传进来的参数为"+fundAccountPo.toString());
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String time = sdf.format(new Date());
		int num = (int)(Math.random()*(9999-1000+1))+1000;
		String fNumber="SZ"+time+num;
		fundAccountBillPo.setfNumber(fNumber);
		fundAccountBillPo.setfCreatorID(user.getEmployId());
		fundAccountBillPo.setfOperator(user.getEmployId());
		fundAccountBillPo.setfAuditorID(user.getEmployId());
		int result = fundAccountBillService.addFundAccountBill(fundAccountBillPo,request);
		if(result<=0){
			logger.debug("账户收入添加账户明细失败");
			throw new Exception("添加失败");
		}else{
			//明细表添加成功  开始修改账户余额
			int result2=updateFundAmount(fundAccountPo,request);
			if(result2>0){
				return result2;
			}else{
				logger.debug("账户余额修改失败");
				throw new Exception("添加失败");
			}
		}
	}

	/**
	 * 财务支出
	 * @param fundAccountPo
	 * @param fundAccountBillPo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,rollbackFor={Exception.class})
	public int fundAccountOut(FundAccountPo fundAccountPo,FundAccountBillPo fundAccountBillPo,HttpServletRequest request) throws Exception {
		logger.debug("账户支出传进来的参数为"+fundAccountPo.toString());
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String time = sdf.format(new Date());
		int num = (int)(Math.random()*(9999-1000+1))+1000;
		String fNumber="SZ"+time+num;
		fundAccountBillPo.setfNumber(fNumber);
		fundAccountBillPo.setfCreatorID(user.getEmployId());
		fundAccountBillPo.setfOperator(user.getEmployId());
		fundAccountBillPo.setfAuditorID(user.getEmployId());
		int result = fundAccountBillService.addFundAccountBill(fundAccountBillPo,request);
		if(result<=0){
			logger.debug("账户支出添加账户明细失败");
			throw new Exception("添加失败");
		}else{
			//明细表添加成功  开始修改账户余额
			int result2=updateFundAmount(fundAccountPo,request);
			if(result2>0){
				return result2;
			}else{
				logger.debug("账户余额修改失败");
				throw new Exception("添加失败");
			}
		}
	}
}
