package com.channelsoft.ems.expenses.rpayment.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.common.IdGen;
import com.channelsoft.ems.expenses.mouthblance.mapper.OldmanblanceMapper;
import com.channelsoft.ems.expenses.rpayment.mapper.PaymentMapper;
import com.channelsoft.ems.expenses.rpayment.mapper.PaymententryMapper;
import com.channelsoft.ems.expenses.rpayment.mapper.RpaymentMapper;
import com.channelsoft.ems.expenses.rpayment.mapper.RpaymententryMapper;
import com.channelsoft.ems.expenses.rpayment.po.Oldmanblance;
import com.channelsoft.ems.expenses.rpayment.po.Payment;
import com.channelsoft.ems.expenses.rpayment.po.Paymententry;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;
import com.channelsoft.ems.expenses.rpayment.po.Rpaymententry;
import com.channelsoft.ems.expenses.rpayment.service.PaymentService;
import com.channelsoft.ems.po.OldManChargePo;

/** 
 * 
 * 实际缴费serviceImpl  
 * @author  lwj
 * @date 创建时间：2017年03月04日 下午14:31:41 
 * @parameter  
 * @return  
 */
@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentMapper payMapper;
	
	@Autowired
	private PaymententryMapper paymententryMapper;
	
	@Autowired
	private RpaymentMapper rpayMapper;
	
	@Autowired
	private RpaymententryMapper rpaymentryMapper;
	

	@Autowired
	private OldmanblanceMapper oldmanblanceMapper;
	
	public int deleteByPrimaryKey(String fid) {
		// TODO Auto-generated method stub
		return payMapper.deleteByPrimaryKey(fid);
	}

	public int insert(Payment record) {
		// TODO Auto-generated method stub
		return payMapper.insert(record);
	}

	public int insertSelective(Payment record) {
		// TODO Auto-generated method stub
		return payMapper.insertSelective(record);
	}

	public Payment selectByPrimaryKey(String fid) {
		// TODO Auto-generated method stub
		return payMapper.selectByPrimaryKey(fid);
	}

	public int updateByPrimaryKeySelective(Payment record) {
		// TODO Auto-generated method stub
		return payMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Payment record) {
		// TODO Auto-generated method stub
		return payMapper.updateByPrimaryKey(record);
	}

	public List<Rpayment> queryPaymentList(Rpayment po) {
		return payMapper.queryPaymentList(po);
	}

	@Override
	public Oldmanblance getOldManBlanceCurrent(Rpayment po) {
		Oldmanblance omb=oldmanblanceMapper.getOldManBlanceByOldman(po.getFoldmanid());
		if(omb==null){
			omb=new Oldmanblance();
			
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-M");
			Date now=new Date();
			String fyearmouth=sdf.format(now);
			String[] ss=fyearmouth.split("-");
			int fperiod=Integer.parseInt(ss[0]);
			int fmoun=Integer.parseInt(ss[1]);
			
			omb.setFoldmanid(po.getFoldmanid());
			omb.setFperiod(fperiod);
			omb.setFmoun(fmoun);
			omb.setFyearmouth(fyearmouth);
		}
		//本期期初金额
		BigDecimal fbeginamount=omb.getFbeginamount()==null?new BigDecimal("0.00"):omb.getFbeginamount();
				
		BigDecimal faramount=oldmanblanceMapper.getFaramountTotal(omb);
				
		BigDecimal fapamount=oldmanblanceMapper.getFapamountTotal(omb);
				
		//本期期末金额
		BigDecimal fendamount=fbeginamount.add(faramount).subtract(fapamount);
		
		omb.setFendamount(fendamount);
		
		return omb;
	}

	@Override
	public List<OldManChargePo> getFcostitem(String foldmanid) {
		// TODO Auto-generated method stub
		return payMapper.getFcostitem(foldmanid);
	}

	@Override
	public String savePayMent(Payment po) {
		String fid=IdGen.getRandomNo("",11);
		String fnumber=IdGen.getRandomNoYMS("SJ",4);
		
		po.setFid(fid);
		//po.setFnursinghomeid(rpayment.getFnursingHomeid());
		po.setFnumber(fnumber);
		po.setFstatus("1");
		//po.setFoldmanid(rpayment.getFoldmanid());
		String fpaymentdate=po.getFpaymentdate();
		String[] ss=fpaymentdate.split("-");
		int fperiod=Integer.parseInt(ss[0]);
		int fmoun=Integer.parseInt(ss[1]);
		
		po.setFperiod(fperiod);
		po.setFmoun(fmoun);
		
		//插入实缴费用主表记录
		payMapper.insertSelective(po);
		
		//判断多缴费金额是否大于0，若果大于0，这说明多缴费了
		BigDecimal morePaymentAmount=po.getMorePaymentAmount();
		
		String fcostitemid=po.getFcostitemid();
		if(morePaymentAmount.compareTo(new BigDecimal("0"))==1){
			Paymententry paymententry=new Paymententry();
			
			String entryfid=IdGen.getRandomNo("", 11);
			paymententry.setFid(entryfid);
			paymententry.setFparentid(fid);
			paymententry.setFcostitem(null);
			paymententry.setFitemid("1");
			paymententry.setFarpaymentamount(morePaymentAmount);
			
			paymententryMapper.insertSelective(paymententry);
		}
		
		//判断实际应付金额是否小于0，如果小于0，则实际缴费金额为0
		BigDecimal rpaymetTotal=po.getRpaymetTotal();
		
		String rentryfids=po.getRentryfids();
		String[] fids=rentryfids.split(",");
		for (int i = 0; i < fids.length; i++) {
			String rentryfid=fids[i];
			Rpaymententry rentry=rpaymentryMapper.selectByPrimaryKey(rentryfid);
			
			Rpayment  rpayment=rpayMapper.selectByPrimaryKey(rentry.getFparentid());
			
			String fbiztype=rpayment.getFbiztype();
			
			Paymententry paymententry=new Paymententry();
			
			String entryfid=IdGen.getRandomNo("", 11);
			paymententry.setFid(entryfid);
			paymententry.setFparentid(fid);
			paymententry.setFcostitem(rentry.getFcostitem());
			paymententry.setFarpaymentamount(rentry.getFarpaymentamount());
			paymententry.setFsourcebillentryid(rentry.getFid());
			paymententry.setFsourcebillid(rpayment.getFid());
			paymententry.setFitemid(rentry.getFitemid());
			
			//如果小于0，则实际缴费金额为0
			if(rpaymetTotal.compareTo(new BigDecimal("0"))==-1){
				paymententry.setFarpaymentamount(new BigDecimal("0"));
			}else{
				//如果大于0，则需要依次与大于0的应缴费比较 
				BigDecimal farpaymentamount=rentry.getFarpaymentamount();
				//如果当前应缴费明细金额小于0，则实际缴费金额为0
				if(farpaymentamount.compareTo(new BigDecimal("0"))==-1){
					paymententry.setFarpaymentamount(new BigDecimal("0"));
				}else{
					/**
					 * 若实际应缴费总额大于0，应缴费明细金额也大于0，则进行比较，
					 * 若总额小于明细金额时，设置当前实缴费金额为 总缴费金额
					 * 并重新计算总缴费金额
					 */
					if(rpaymetTotal.compareTo(farpaymentamount)==-1){
						paymententry.setFarpaymentamount(rpaymetTotal);
						rpaymetTotal=rpaymetTotal.subtract(farpaymentamount).setScale(2, BigDecimal.ROUND_HALF_DOWN);
					}else{
						paymententry.setFarpaymentamount(rentry.getFarpaymentamount());
						rpaymetTotal=rpaymetTotal.subtract(farpaymentamount).setScale(2, BigDecimal.ROUND_HALF_DOWN);
					}
				}
			}
			
			if("2".equals(fbiztype)){
				paymententry.setFarpaymentamount(new BigDecimal("0"));
			}
			
			paymententryMapper.insertSelective(paymententry);
			
			
			rentry.setFpaymentamount(rentry.getFarpaymentamount());
			
			rpaymentryMapper.updateByPrimaryKeySelective(rentry);
		}
		
		return fid;
		
	}

	@Override
	public List<Payment> queryHasPaymentList(Payment po) {
		return payMapper.queryHasPaymentList(po);
	}

}
