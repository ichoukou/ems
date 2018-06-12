package com.channelsoft.ems.nursing.nursingProject.service;

import java.util.List;
import java.util.Map;

import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;
import com.channelsoft.ems.nursing.nursingProject.po.NursingServiceGroupPo;
import com.channelsoft.ems.nursing.nursingProject.po.NursingServiceItemLevelPo;
import com.channelsoft.ems.po.DataDictionaryPo;

/** 
 * 
 * 护理项目service  
 * @author  lwj
 * @date 创建时间：2017年02月09日 下午14:31:41 
 * @parameter  
 * @return  
 */
public interface NursingProjectService {

	List<NursingProjectPo> queryList(NursingProjectPo po);

	void saveNursingServiceGroup(NursingServiceGroupPo po);

	void saveNursingProject(NursingProjectPo po);

	String checkNursingServiceGroupName(String fName);

	String checkNursingProjectName(String fName);

	List<DataDictionaryPo> getDcValueByName(DataDictionaryPo po);

	List<NursingServiceGroupPo> getServiceGroups(Map<String,String> map);

	NursingProjectPo getNursingProject(String fid);

	List<NursingServiceItemLevelPo> getServiceLevelByFparentId(String fid);

	void delNursingProject(String fid);

	List<NursingProjectPo> queryDetailList(NursingProjectPo po);

	int getTotalSize(NursingProjectPo po);

	List<NursingServiceGroupPo> queryServiceGroupList(NursingServiceGroupPo po);

	int getServiceGroupTotalSize(NursingServiceGroupPo po);

	void updateNursingProject(NursingProjectPo po);

	boolean checkProjectUsed(NursingProjectPo po);

	NursingProjectPo getNursingProjectPoByFid(String fid);

	String getFnursingHomeIDByUserID(String uid);

	String checkServiceType(String fServiceGroupID);


}
