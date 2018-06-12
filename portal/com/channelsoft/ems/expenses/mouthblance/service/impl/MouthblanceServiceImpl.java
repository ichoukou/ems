package com.channelsoft.ems.expenses.mouthblance.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.common.IdGen;
import com.channelsoft.ems.expenses.mouthblance.mapper.OldmanblanceMapper;
import com.channelsoft.ems.expenses.mouthblance.service.MouthblanceService;
import com.channelsoft.ems.expenses.rpayment.mapper.RpaymentMapper;
import com.channelsoft.ems.expenses.rpayment.mapper.RpaymententryMapper;
import com.channelsoft.ems.expenses.rpayment.po.Oldmanblance;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;
import com.channelsoft.ems.expenses.rpayment.po.Rpaymententry;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManPo;
import com.channelsoft.ems.po.OldManChargePo;

/** 
 * 
 * 月结账serviceImpl  
 * @author  lwj
 * @date 创建时间：2017年3月6日21:18:43
 * @parameter  
 * @return  
 */
@Service
public class MouthblanceServiceImpl implements MouthblanceService{

	@Autowired
	private OldmanblanceMapper mapper;
	@Autowired
	private RpaymentMapper rpayMapper;
	@Autowired
	private RpaymententryMapper rpayentryMapper;
	
	public int deleteByPrimaryKey(String fid) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(fid);
	}

	public int insert(Oldmanblance record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	public int insertSelective(Oldmanblance record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	public Oldmanblance selectByPrimaryKey(String fid) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(fid);
	}

	public int updateByPrimaryKeySelective(Oldmanblance record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Oldmanblance record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public Oldmanblance getOldManBlance() {
		Oldmanblance omb=mapper.getOldManBlance();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-M");
		Date now=new Date();
		String fyearmouth=sdf.format(now);
		String[] ss=fyearmouth.split("-");
		int fperiod=Integer.parseInt(ss[0]);
		int fmoun=Integer.parseInt(ss[1]);
		
		if(omb==null){
			omb=new Oldmanblance();
			omb.setFperiod(fperiod);
			omb.setFmoun(fmoun);
			omb.setFyearmouth(fyearmouth);
			
			/**
			 * 如果数据库记录为空，则初始化全院老人的余额记录，设置默认期初和期末金额为0
			 */
			//initAllOldmanblance(omb);
		}else if(omb.getFyearmouth()==null ||"".equals(omb.getFyearmouth())){
			omb=new Oldmanblance();
			omb.setFperiod(fperiod);
			omb.setFmoun(fmoun);
			omb.setFyearmouth(fyearmouth);
		}
		
		return omb;
	}

	private void initAllOldmanblance(Oldmanblance oldmanblance) {
		List<OldManPo> oldMans= mapper.getAllOldManOfwhole();
		for (OldManPo oldManPo : oldMans) {
			String fid =IdGen.getRandomNoYMS("LRYE", 4);
			oldmanblance.setFid(fid);
			oldmanblance.setFnursinghomeid(oldManPo.getFnursingHomeid());
			oldmanblance.setFoldmanid(oldManPo.getFid());
			oldmanblance.setFbeginamount(new BigDecimal("0")); //期初金额
			oldmanblance.setFaramount(new BigDecimal("0"));    //当期应缴金额
			oldmanblance.setFapamount(new BigDecimal("0"));    //当期实缴金额
			oldmanblance.setFendamount(new BigDecimal("0"));   //期末金额
			//插入老人余额表
			mapper.insertSelective(oldmanblance);
		}
	}

	@Override
	public void paymentSubmit() {
		// 查询出余额表所有老人
		List<OldManPo> oldMans= mapper.getAllOldManOfwhole();
		//循环老人，分别查询出老人余额表信息，老人当期应交费用，老人当期实缴费用
		for (OldManPo oldManPo : oldMans) {
			Oldmanblance omb=mapper.getOldManBlanceByOldman(oldManPo.getFid());
			//如果该老人余额表记录为空，则初始化插入一条老人余额记录
			if(omb==null){
				insertOneOldmanBlance(oldManPo);
				
				//初始化改老人余额数据后再获取信息
				omb=mapper.getOldManBlanceByOldman(oldManPo.getFid());
				
				//生成下期应交费用时 需要判断老人状态（只生成 在院和请假的 即FoldManStatusID 为 46,47）
				if("46".equals(oldManPo.getFoldManStatusID()) || "47".equals(oldManPo.getFoldManStatusID())){
					//生成老人下期应缴费用
					createNextOldmanRpayment(omb);					
				}
				
				//插入下期老人余额
				insertNextOldmanBlance(omb);
			}else{
				//生成下期应交费用时 需要判断老人状态（只生成 在院和请假的 即FoldManStatusID 为 46,47）
				if("46".equals(oldManPo.getFoldManStatusID()) || "47".equals(oldManPo.getFoldManStatusID())){
					//生成老人下期应缴费用
					createNextOldmanRpayment(omb);
				}
				
				//插入下期老人余额
				insertNextOldmanBlance(omb);
			}
		}
		
		
	}

	private void createNextOldmanRpayment(Oldmanblance omb) {
		//1-生成下期应缴费单
		Rpayment rpay=createNextRpayment(omb);
		
		String fparentid=rpay.getFid();
		
		//2-老人费用表 查询出需要生成应缴费的项目
		List<OldManChargePo> oldManCharges=mapper.getOldManChargeNeed(omb.getFoldmanid());
		
		//3-生成下期应缴费单明细
		for (OldManChargePo oldManChargePo : oldManCharges) {
			Rpaymententry rapyentry=new Rpaymententry();
			String fid=IdGen.getRandomNo("", 11);
			String fcostitem=oldManChargePo.getfID();
			String farpaymentamount=oldManChargePo.getfChargePrice();
			if(farpaymentamount==null || "".equals(farpaymentamount)){
				farpaymentamount="0";
			}
			String fitemid=oldManChargePo.getfManChargeID();
			rapyentry.setFid(Integer.parseInt(fid));
			rapyentry.setFparentid(fparentid);
			rapyentry.setFcostitem(fcostitem);
			rapyentry.setFarpaymentamount(new BigDecimal(farpaymentamount));
			rapyentry.setFpaymentamount(new BigDecimal("0"));
			rapyentry.setFitemid(fitemid);
			
			rpayentryMapper.insertSelective(rapyentry);
		}
	}

	private Rpayment createNextRpayment(Oldmanblance omb) {
		Rpayment rpay=new Rpayment();
		rpay.setFaudittime(new Date());
		rpay.setFcreatetime(new Date());
		rpay.setFmodificationtime(new Date());
		
		String fid=IdGen.getRandomNo("", 11);
		String fnursingHomeid=omb.getFnursinghomeid();
		String fnumber=IdGen.getRandomNoYMS("YS", 4);
		String fstatus="1";
		String fbiztype="1";
		String foldmanid=omb.getFoldmanid();
		Date fpaymentdate=new Date();
		
		String nextFyearmouth=getNextFyearmouth(omb.getFyearmouth());
		
		String[] ss=nextFyearmouth.split("-");
		int fperiod=Integer.parseInt(ss[0]);
		int fmoun=Integer.parseInt(ss[1]);
		rpay.setFid(fid);
		rpay.setFnursingHomeid(fnursingHomeid);
		rpay.setFnumber(fnumber);
		rpay.setFstatus(fstatus);
		rpay.setFbiztype(fbiztype);
		rpay.setFoldmanid(foldmanid);
		rpay.setFpaymentdate(fpaymentdate);
		rpay.setFperiod(fperiod);
		rpay.setFmoun(fmoun);
		
		rpayMapper.insertSelective(rpay);
		return rpay;
	}

	private void insertNextOldmanBlance(Oldmanblance omb) {
		//本期期初金额
		BigDecimal fbeginamount=omb.getFbeginamount();
		
		BigDecimal faramount=mapper.getFaramountTotalBlance(omb);
		
		BigDecimal fapamount=mapper.getFapamountTotalBlance(omb);
		
		//本期期末金额(期初+应收-实收)
		BigDecimal fendamount=fbeginamount.add(faramount).subtract(fapamount);
		
		//下一期期初金额
		BigDecimal nextFbeginamount=fendamount;
		omb.setFaramount(faramount);
		omb.setFapamount(fapamount);
		omb.setFendamount(fendamount);
		mapper.updateByPrimaryKey(omb);
		
		
		String fid=IdGen.getRandomNoYMS("LRYE", 4);
		String fnursinghomeid=omb.getFnursinghomeid();
		String foldmanid=omb.getFoldmanid();
		
		String fyearmouth=omb.getFyearmouth();
		
		String nextFyearmouth=getNextFyearmouth(fyearmouth);
		
		String[] ss=nextFyearmouth.split("-");
		int fperiod=Integer.parseInt(ss[0]);
		int fmoun=Integer.parseInt(ss[1]);
		
		//下一期的老人余额记录
		Oldmanblance oldmanblance=new Oldmanblance();
		
		oldmanblance.setFid(fid);
		oldmanblance.setFnursinghomeid(fnursinghomeid);
		oldmanblance.setFoldmanid(foldmanid);
		oldmanblance.setFbeginamount(nextFbeginamount);
		oldmanblance.setFaramount(new BigDecimal("0"));
		oldmanblance.setFapamount(new BigDecimal("0"));
		oldmanblance.setFendamount(new BigDecimal("0"));
		oldmanblance.setFperiod(fperiod);
		oldmanblance.setFmoun(fmoun);
		mapper.insertSelective(oldmanblance);
	}

	private String getNextFyearmouth(String fyearmouth) {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-M");
		Date date=null;
		try {
			date=sdf.parse(fyearmouth);
		} catch (ParseException e) {
			date=new Date();
		}
		Calendar dd = Calendar.getInstance();
		
		dd.setTime(date);
		
		dd.add(Calendar.MONTH, 1);
		
		String nextFyearmouth = sdf.format(dd.getTime());
		
		
		
		return nextFyearmouth;
	}

	private void insertOneOldmanBlance(OldManPo oldManPo) {
		Oldmanblance oldmanblance=new Oldmanblance();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-M");
		Date now=new Date();
		String fyearmouth=sdf.format(now);
		String[] ss=fyearmouth.split("-");
		int fperiod=Integer.parseInt(ss[0]);
		int fmoun=Integer.parseInt(ss[1]);
		
		String fid =IdGen.getRandomNoYMS("LRYE", 4);
		oldmanblance.setFid(fid);
		oldmanblance.setFnursinghomeid(oldManPo.getFnursingHomeid());
		oldmanblance.setFperiod(fperiod);
		oldmanblance.setFmoun(fmoun);
		oldmanblance.setFoldmanid(oldManPo.getFid());
		oldmanblance.setFbeginamount(new BigDecimal("0")); //期初金额
		oldmanblance.setFaramount(new BigDecimal("0"));    //当期应缴金额
		oldmanblance.setFapamount(new BigDecimal("0"));    //当期实缴金额
		oldmanblance.setFendamount(new BigDecimal("0"));   //期末金额
		//插入老人余额表
		mapper.insertSelective(oldmanblance);
		
	}

	@Override
	public void paymentSubmitBack() {
		//查询出当前最大期数
		Oldmanblance oldmanblance= getOldManBlance();
		
		mapper.deleteOldmanblanceByyearmouth(oldmanblance);
	}

	@Override
	public List<Oldmanblance> QueryList(Oldmanblance po) {
		List<Oldmanblance> oldmanblances=new ArrayList<Oldmanblance>();
		List<Oldmanblance> ombs=mapper.QueryList(po);
		for (Oldmanblance omb : ombs) {
			
			//如果当老人余额表没数据时，则设置当前系统时间为当前期
			if(omb.getFid()==null || "".equals(omb.getFid())){
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy-M");
				Date now=new Date();
				String fyearmouth=sdf.format(now);
				String[] ss=fyearmouth.split("-");
				int fperiod=Integer.parseInt(ss[0]);
				int fmoun=Integer.parseInt(ss[1]);
				
				omb.setFperiod(fperiod);
				omb.setFmoun(fmoun);
				omb.setFyearmouth(fyearmouth);
			}
			
			//本期期初金额
			BigDecimal fbeginamount=omb.getFbeginamount()==null?new BigDecimal("0.00"):omb.getFbeginamount();
					
			BigDecimal faramount=mapper.getFaramountTotal(omb);
					
			BigDecimal fapamount=mapper.getFapamountTotal(omb);
					
			//本期期末金额
			BigDecimal fendamount=fbeginamount.add(faramount).subtract(fapamount);
			
			omb.setFendamount(fendamount);
			oldmanblances.add(omb);
		}
		
		return oldmanblances;
	}

	@Override
	public int getTotalSize(Oldmanblance po) {
		// TODO Auto-generated method stub
		return mapper.getTotalSize(po);
	}
}
