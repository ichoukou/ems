
package com.channelsoft.ems.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.channelsoft.ems.mapper.MonthAnalyseMapper;
import com.channelsoft.ems.po.AnalysePo;
import com.channelsoft.ems.po.FundAccountBillPo;
import com.channelsoft.ems.service.MonthAnalyseService;
@Service
public class MonthAnalyseServiceImpl implements MonthAnalyseService{

	@Autowired
	private MonthAnalyseMapper monthAnalyseMapper;
	
	private Logger logger=Logger.getLogger(MonthAnalyseServiceImpl.class);
	/**
	 * 月份分析
	 */
	public List<AnalysePo> monthAnalyse(int page,int pageSize,FundAccountBillPo fundAccountBillPo) {
		logger.debug("开始进行月份分析");
		List<FundAccountBillPo> list = monthAnalyseMapper.queryFundAccountBillPo(0, 10, fundAccountBillPo);
		List<AnalysePo> analysePo=new ArrayList<AnalysePo>();
		for(int i=0;i<list.size();i++){
			AnalysePo analyse=new AnalysePo();
			analyse.setChangeAmount(Double.parseDouble(list.get(i).getfAmount()));
			if(!StringUtils.isEmpty(monthAnalyseMapper.queryMonth(list.get(i).getfCreateTime(),">"))){
				analyse.setfInAmount(Double.parseDouble(monthAnalyseMapper.queryMonth(list.get(i).getfCreateTime(),">")));
			}else{
				analyse.setfInAmount(0);
			}
			if(!StringUtils.isEmpty(monthAnalyseMapper.queryMonth(list.get(i).getfCreateTime(),"<"))){
				analyse.setfOutAmount(-Double.parseDouble(monthAnalyseMapper.queryMonth(list.get(i).getfCreateTime(),"<")));
			}else{
				analyse.setfOutAmount(0);
			}
			analyse.setPeriod(list.get(i).getfCreateTime());
			analysePo.add(analyse);
		}
		return analysePo;
	}
	/**
	 * 总数
	 */
	public int getTotal(FundAccountBillPo fundAccountBillPo) {
		int result=monthAnalyseMapper.getTotal(fundAccountBillPo);
		return result;
	}

	
}
