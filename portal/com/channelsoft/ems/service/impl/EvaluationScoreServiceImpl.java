package com.channelsoft.ems.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.EvaluationScoreMapper;
import com.channelsoft.ems.po.RangePo;
import com.channelsoft.ems.service.EvaluationScoreService;

/**
 * 评估等级范围  
 * 
 * 增删改查
 * 
 * wuhl
 */
@Service
public class EvaluationScoreServiceImpl implements EvaluationScoreService {

	private static Logger logger = Logger.getLogger(EvaluationScoreServiceImpl.class);
	
	@Autowired
	private EvaluationScoreMapper mapper;

	public int addEvalScore(RangePo rangePo) {
		// TODO Auto-generated method stub
		try {
			logger.debug("进入增加"+rangePo);
			this.mapper.addEvalScore(rangePo);
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("添加错误"+e.getMessage());
			e.printStackTrace();
		    return 1;
		}
		return 0;
	}

	
	public int deleteEvalScore(String fScoreID) {
		// TODO Auto-generated method stub
		try {
			logger.debug("删除账号"+fScoreID);
			this.mapper.deleteEvalScore(fScoreID);
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("删除错误"+e.getMessage());
			e.printStackTrace();
		    return 1;
		}		
		return 0;
	}


	public int updateEvalLevel(RangePo rangePo) {
		// TODO Auto-generated method stub
		try {
			logger.debug("进行更新"+rangePo);
			this.mapper.updateEvalLevel(rangePo);
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("更新错误"+e.getMessage());
			e.printStackTrace();
		    return 1;
		}
		
		return 0;
	}

	public List<RangePo> getEvalScore() {
		// TODO Auto-generated method stub
		return mapper.getEvalScore();
	}

    //增加 更新 --显示下拉框
	public List<Map<String, String>> getALLEvalLevel() {
		// TODO Auto-generated method stub
		return mapper.getALLEvalLevel();
	}


	public List<RangePo> getInternListBy(RangePo rangePo,int page,int pageSize) {
		// TODO Auto-generated method stub
		return this.mapper.getInternListBy(rangePo,page,pageSize);


	}

	public int getInternListByCount(RangePo rangePo) {
		return this.mapper.getInternListByCount(rangePo);
	}

    public List<Map<String,String>> queryFLevelID(){
        return this.mapper.queryFLevelID();
    }

}
