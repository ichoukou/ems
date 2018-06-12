package com.channelsoft.ems.nursing.nursingPlanExcute.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.channelsoft.ems.nursing.nursingPlanExcute.po.PublicServiceExecutePo;
/** 
 * 
 * 公共护理计划执行mapper  
 * @author  lwj
 * @date 创建时间：2017年2月24日09:44:46
 * @parameter  
 * @return  
 */
public interface PublicServiceExecutePoMapper {
    int deleteByPrimaryKey(String fid);

    int insert(PublicServiceExecutePo record);

    int insertSelective(PublicServiceExecutePo record);

    PublicServiceExecutePo selectByPrimaryKey(String fid);

    int updateByPrimaryKeySelective(PublicServiceExecutePo record);

    int updateByPrimaryKey(PublicServiceExecutePo record);

	List<PublicServiceExecutePo> queryList(PublicServiceExecutePo po);

	int getTotalSize(PublicServiceExecutePo po);

	List<PublicServiceExecutePo> queryDetailList(PublicServiceExecutePo po);
	
	void updatePlanStatusExcludcount(String fid);
}