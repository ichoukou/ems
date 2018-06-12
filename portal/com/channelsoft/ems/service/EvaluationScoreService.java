package com.channelsoft.ems.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.channelsoft.ems.po.RangePo;

/** 
 *  评估等级范围  
 * @author  wuhl
 * @date 创建时间：2016年11月13日 
 * @parameter  
 * @return  
 */
public interface EvaluationScoreService {

	public int addEvalScore(RangePo rangePo); 
	
	public int deleteEvalScore(String fScoreID);
	
	public int updateEvalLevel(RangePo rangePo);
   
	public List<RangePo> getEvalScore();
	
	public List<Map<String,String>> getALLEvalLevel();
	 
	public List<RangePo> getInternListBy(RangePo rangePo,int page,int pageSize);


	public int getInternListByCount(RangePo rangePo);

    public List<Map<String,String>> queryFLevelID();



}
