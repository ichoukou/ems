package com.channelsoft.ems.nursing.nursingPlan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.channelsoft.ems.nursing.nursingPlan.po.PublicServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlan.po.RoomPo;
import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;

/** 
 * 
 * 护理公共计划mapper  
 * @author  lwj
 * @date 创建时间：2017年02月18日 下午14:31:41 
 * @parameter  
 * @return  
 */
public interface NursingPlanPublicMapper {

	List<PublicServiceItemPo> queryDetailList(PublicServiceItemPo po);

	List<RoomPo> queryRoomList(RoomPo po);

	int queryRoomTotal(RoomPo po);

	List<PublicServiceItemPo> queryList(PublicServiceItemPo po);

	int getTotalSize(PublicServiceItemPo po);

	List<PublicServiceItemPo> getNoSelectPublicServiceItem(PublicServiceItemPo po);

	void updatePublicServiceItem(PublicServiceItemPo po);
	
	List<RoomPo> getAllRoom();

	List<PublicServiceItemPo> getPublicServiceItems(PublicServiceItemPo po);

	void updateByPrimaryKeySelective(PublicServiceItemPo po);

	void insertSelective(PublicServiceItemPo oldManServiceItemPo);
	
	List<NursingProjectPo> getAllServiceItem();

	int checkServiceItemExist(@Param("fserviceitemid")String fserviceitemid, @Param("froomid")String froomid);

}
