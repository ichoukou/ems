package com.channelsoft.ems.nursing.nursingPlan.service;

import java.util.List;

import com.channelsoft.ems.nursing.nursingPlan.po.PublicServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlan.po.RoomPo;

/** 
 * 
 * 护理公共计划service  
 * @author  lwj
 * @date 创建时间：2017年02月18日 下午14:31:41 
 * @parameter  
 * @return  
 */
public interface NursingPlanPublicService {

	List<PublicServiceItemPo> queryDetailList(PublicServiceItemPo po);

	List<RoomPo> queryRoomList(RoomPo po);

	int queryRoomTotal(RoomPo po);

	List<PublicServiceItemPo> queryList(PublicServiceItemPo po);

	int getTotalSize(PublicServiceItemPo po);

	void savePublicServiceItem(String[] fids, String froomid);
	
	List<RoomPo> getAllRoom();

	List<PublicServiceItemPo> getPublicServiceItems(PublicServiceItemPo po);
	
	void updateByPrimaryKeySelective(PublicServiceItemPo po);
	
	/**
	 * 新增房间时，传入房间id和所做项目id，调用方法，存入公共服务项目表
	 * @param froomid
	 * @param serviceItemIds
	 */
	void insertPublicServiceItemByContidtion(String froomid,List<String> serviceItemIds);

	void insertSelective(PublicServiceItemPo publicServiceItemPo);
}
