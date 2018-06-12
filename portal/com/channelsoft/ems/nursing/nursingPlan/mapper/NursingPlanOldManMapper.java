package com.channelsoft.ems.nursing.nursingPlan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.channelsoft.ems.nursing.nursingPlan.po.OldManPo;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManServiceItemPo;
import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;

/** 
 * 
 * 护理老人计划mapper  
 * @author  lwj
 * @date 创建时间：2017年02月18日 下午14:31:41 
 * @parameter  
 * @return  
 */
public interface NursingPlanOldManMapper {

	List<OldManServiceItemPo> queryDetailList(OldManServiceItemPo po);

	List<OldManPo> queryOldManList(OldManPo po);

	int queryOldManTotal(OldManPo po);

	List<OldManServiceItemPo> queryList(OldManServiceItemPo po);

	int getTotalSize(OldManServiceItemPo po);

	List<OldManServiceItemPo> getNoSelectOldManServiceItem(OldManServiceItemPo po);

	void updateOldManServiceItem(OldManServiceItemPo po);

	List<OldManPo> getAllOldMan();

	List<OldManServiceItemPo> getOldManServiceItems(OldManServiceItemPo po);

	void updateByPrimaryKeySelective(OldManServiceItemPo po);
	
	void insertSelective(OldManServiceItemPo po);

	List<NursingProjectPo> getAllServiceItem();

	List<NursingProjectPo> getOwnerServiceItem(String fnursingLevel);
	
	int checkServiceItemExist(@Param("fserviceitemid")String fserviceitemid, @Param("foldmanid")String foldmanid);

	List<OldManPo> getLevelOldMan(@Param("levels")String levels);

	List<OldManPo> queryOldManListNoPage(OldManPo po);

}
