package com.channelsoft.ems.nursing.nursingPlan.service;

import java.util.List;

import com.channelsoft.ems.nursing.nursingPlan.po.OldManPo;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManServiceItemPo;
import com.channelsoft.ems.po.DataDictionaryPo;

/** 
 * 
 * 护理老人计划service  
 * @author  lwj
 * @date 创建时间：2017年02月18日 下午14:31:41 
 * @parameter  
 * @return  
 */
public interface NursingPlanOldManService {

	List<OldManServiceItemPo> queryDetailList(OldManServiceItemPo po);

	List<OldManPo> queryOldManList(OldManPo po);

	int queryOldManTotal(OldManPo po);

	List<OldManServiceItemPo> queryList(OldManServiceItemPo po);

	int getTotalSize(OldManServiceItemPo po);

	void saveOldManServiceItem(String[] fids, String foldmanid);

	List<OldManPo> getAllOldMan();

	List<OldManServiceItemPo> getOldManServiceItems(OldManServiceItemPo po);

	void updateByPrimaryKeySelective(OldManServiceItemPo po);
	
	/**
	 * 老人入住时，传入老人和护理等级，调用方法，存入老人服务项目表
	 * @param foldmanid
	 * @param fnursingLevel
	 */
	void insertOldManServiceItemByContidtion(String foldmanid,String fnursingLevel);

	List<OldManPo> getLevelOldMan(String levels);

	void insertSelective(OldManServiceItemPo oldManServiceItemPo);

	List<OldManPo> queryOldManListNoPage(OldManPo po);
}
