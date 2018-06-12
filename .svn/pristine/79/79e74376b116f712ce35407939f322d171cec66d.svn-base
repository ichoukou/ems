package com.channelsoft.ems.expenses.retirement.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.common.IdGen;
import com.channelsoft.ems.expenses.retirement.mapper.RetirementMapper;
import com.channelsoft.ems.expenses.retirement.po.RetirementPo;
import com.channelsoft.ems.expenses.retirement.service.RetirementService;
import com.channelsoft.ems.expenses.rpayment.mapper.PaymentMapper;
import com.channelsoft.ems.expenses.rpayment.mapper.PaymententryMapper;
import com.channelsoft.ems.expenses.rpayment.mapper.RpaymentMapper;
import com.channelsoft.ems.expenses.rpayment.mapper.RpaymententryMapper;
import com.channelsoft.ems.expenses.rpayment.po.Payment;
import com.channelsoft.ems.expenses.rpayment.po.Paymententry;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;
import com.channelsoft.ems.expenses.rpayment.po.Rpaymententry;

/** 
 * 
 * 退住借款serviceImpl  
 * @author  lwj
 * @date 创建时间：2017年3月10日09:43:42
 * @parameter  
 * @return  
 */
@Service
public class RetirementServiceImpl implements RetirementService{
	@Autowired
	private RetirementMapper rmapper;
	
	@Autowired
	private PaymentMapper payMapper;
	
	@Autowired
	private PaymententryMapper paymententryMapper;
	
	@Autowired
	private RpaymentMapper rpayMapper;
	
	@Autowired
	private RpaymententryMapper rpaymentryMapper;
	
	@Override
	public List<Rpayment> QueryList(Rpayment po) {
		return rmapper.QueryList(po);
	}

	@Override
	public int getTotalSize(Rpayment po) {
		return rmapper.getTotalSize(po);
	}

	@Override
	public List<RetirementPo> queryRetirementDetailList(RetirementPo po) {
		List<RetirementPo> all=new ArrayList<RetirementPo>();
		
		//1-历史期间应缴费明细
		List<RetirementPo> poHistorys=rmapper.getRetirementPoHistorys(po);
		for (RetirementPo retirementPo : poHistorys) {
			all.add(retirementPo);
		}
		
		//2-一次性费用
		List<RetirementPo> poOnes=rmapper.getRetirementPoOnes(po);
		for (RetirementPo retirementPo : poOnes) {
			all.add(retirementPo);
		}
		
		//3-阶段性费用 应缴费
		List<RetirementPo> poPhasicRpays=rmapper.getRetirementPoPhasicRpays(po);
		for (RetirementPo retirementPo : poPhasicRpays) {
			all.add(retirementPo);
		}
		
		//4-月循环费用 应缴费
		List<RetirementPo> poMounLoopRpays=rmapper.getRetirementPoMounLoopRpays(po);
		for (RetirementPo retirementPo : poMounLoopRpays) {
			all.add(retirementPo);
		}
		
		//5-阶段性费用 已收 当期
		List<RetirementPo> poPhasicPays=rmapper.getRetirementPoPhasicPays(po);
		for (RetirementPo retirementPo : poPhasicPays) {
			all.add(retirementPo);
		}
		
		//6-月循环费用  已收 当期
		List<RetirementPo> poMounLoopPays=rmapper.getRetirementPoMounLoopPays(po);
		for (RetirementPo retirementPo : poMounLoopPays) {
			all.add(retirementPo);
		}
		
		//7-应缴费表  减免
		List<RetirementPo> poReductions=rmapper.getRetirementPoReductions(po);
		
		for (RetirementPo retirementPo : poReductions) {
			all.add(retirementPo);
		}
		
		return all;
	}

	@Override
	public void savePayMent(Payment po) {
		//判断实际付费不为0，则需将多余的金额 写进 实收表
		BigDecimal pamentTotal=po.getPamentTotal();
		Double sub=pamentTotal.doubleValue();
				
		String fcostitemid=po.getFcostitemid();
		if(sub !=0){
			String fid=IdGen.getRandomNo("",11);
			String fnumber=IdGen.getRandomNoYMS("SJ",4);
			
			po.setFid(fid);
			po.setFnumber(fnumber);
			po.setFstatus("1");
			String fpaymentdate=po.getFpaymentdate();
			String[] ss=fpaymentdate.split("-");
			int fperiod=Integer.parseInt(ss[0]);
			int fmoun=Integer.parseInt(ss[1]);
			
			po.setFperiod(fperiod);
			po.setFmoun(fmoun);
			
			//插入实缴费用主表记录
			payMapper.insertSelective(po);
			
			Paymententry paymententry=new Paymententry();
					
			String entryfid=IdGen.getRandomNo("", 11);
			paymententry.setFid(entryfid);
			paymententry.setFparentid(fid);
			paymententry.setFcostitem("1");
			paymententry.setFarpaymentamount(pamentTotal);
					
			paymententryMapper.insertSelective(paymententry);
		}
		
		String rentryfids=po.getRentryfids();
		if(rentryfids !=null && !"".equals(rentryfids)){
		String[] fids=rentryfids.split(",");
		String rentryPayamounts=po.getRentryPayamounts();
		String[] payamounts=rentryPayamounts.split(",");
		for (int i = 0; i < fids.length; i++) {
			String rentryfid=fids[i];
			String payamount=payamounts[i];
			BigDecimal farpaymentamount=new BigDecimal(payamount).setScale(2, BigDecimal.ROUND_HALF_DOWN);
			BigDecimal fpaymentamount=new BigDecimal(payamount).setScale(2, BigDecimal.ROUND_HALF_DOWN);
			//根据应缴明细ID 查询出 明细信息
			Rpaymententry rentry=rpaymentryMapper.selectByPrimaryKey(rentryfid);
			
			if(rentry !=null){
				//用现在每条的实际应缴费用 反写相应的应缴费费用，即将其覆盖，同时将应缴费费用的实际缴费金额覆盖。
				rentry.setFarpaymentamount(farpaymentamount);
				rentry.setFpaymentamount(fpaymentamount);
				
				rpaymentryMapper.updateByPrimaryKeySelective(rentry);
			}
		}
	}
		//将老人状态改为 结算状态 即状态值 改为 195（数据字典 结算状态ID）
		Map<String,String> map=new HashMap<String,String>();
		
		map.put("foldmanid", po.getFoldmanid());
		map.put("status","195");
		rmapper.updateOldmanStatus(map);
	}
	
	
}
