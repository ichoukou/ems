package com.channelsoft.ems.nursing.nursingProject.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;

import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;
import com.channelsoft.ems.nursing.nursingProject.po.NursingServiceGroupPo;
import com.channelsoft.ems.nursing.nursingProject.po.NursingServiceItemLevelPo;
import com.channelsoft.ems.po.DataDictionaryPo;

/** 
 * 
 * 护理项目mapper  
 * @author  lwj
 * @date 创建时间：2017年02月09日 下午14:31:41 
 * @parameter  
 * @return  
 */
public interface NursingProjectMapper {
	public static Logger logger=Logger.getLogger(NursingProjectMapper.class);
	
	List<NursingProjectPo> queryList(NursingProjectPo po);
	
	int getTotalSize(NursingProjectPo po);

	void insertNursingServiceGroup(NursingServiceGroupPo po);

	String checkNursingServiceGroupName(String fName);

	void insertNursingProject(NursingProjectPo po);

	String checkNursingProjectName(String fName);

	List<DataDictionaryPo> getDcValueByName(DataDictionaryPo po);

	List<NursingServiceGroupPo> getServiceGroups(Map<String,String> map);

	void deleteServiceItemLevel(String fParentID);

	void insertServiceItemLevel(NursingServiceItemLevelPo serviceItemLevelPo);

	NursingProjectPo getNursingProject(String fid);

	List<NursingServiceItemLevelPo> getServiceLevelByFparentId(String fid);

	void delNursingProject(String fid);

	List<NursingProjectPo> queryDetailList(NursingProjectPo po);

	List<NursingServiceGroupPo> queryServiceGroupList(NursingServiceGroupPo po);

	int getServiceGroupTotalSize(NursingServiceGroupPo po);

	void updateNursingProject(NursingProjectPo po);

	void updateNursingServiceGroup(NursingServiceGroupPo po);

	int checkProjectUsed(NursingProjectPo po);

	NursingProjectPo getNursingProjectPoByFid(String fid);

	String getFnursingHomeIDByUserID(String uid);

	String checkServiceType(String fServiceGroupID);

}
