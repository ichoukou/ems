package com.channelsoft.ems.nursing.nursingPlanExcute.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.channelsoft.ems.nursing.nursingPlan.po.OldManPo;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlanExcute.po.OldManServiceExecutePo;
/** 
 * 
 * 老人护理计划执行mapper
 * @author  lwj
 * @date 创建时间：2017年2月24日09:44:46
 * @parameter  
 * @return  
 */
public interface OldManServiceExecutePoMapper {
    int deleteByPrimaryKey(String fid);

    int insert(OldManServiceExecutePo record);

    int insertSelective(OldManServiceExecutePo record);

    OldManServiceExecutePo selectByPrimaryKey(String fid);

    int updateByPrimaryKeySelective(OldManServiceExecutePo record);

    int updateByPrimaryKey(OldManServiceExecutePo record);

	List<OldManServiceExecutePo> queryList(OldManServiceExecutePo po);

	int getTotalSize(OldManServiceExecutePo po);

	List<OldManServiceExecutePo> queryDetailList(OldManServiceExecutePo po);

	OldManPo showOldManInfo(String fid);

	OldManServiceExecutePo showOldManPlanInfo(String fid);

	void updatePlanStatusExcludcount(String fid);
}