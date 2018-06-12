package com.channelsoft.ems.nursing.nursingProject.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.common.IdGen;
import com.channelsoft.ems.nursing.nursingProject.mapper.NursingProjectMapper;
import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;
import com.channelsoft.ems.nursing.nursingProject.po.NursingServiceGroupPo;
import com.channelsoft.ems.nursing.nursingProject.po.NursingServiceItemLevelPo;
import com.channelsoft.ems.nursing.nursingProject.service.NursingProjectService;
import com.channelsoft.ems.po.DataDictionaryPo;

/** 
 * 
 * 护理项目serviceInpl  
 * @author  lwj
 * @date 创建时间：2017年02月09日 下午14:31:41
 * @parameter  
 * @return  
 */
@Service
public class NursingProjectServiceImpl implements NursingProjectService{
	
	private Logger logger=Logger.getLogger(NursingProjectServiceImpl.class);
	
	@Autowired
	private NursingProjectMapper mapper;

	public List<NursingProjectPo> queryList(NursingProjectPo po) {
		return mapper.queryList(po);
	}
	
	public int getTotalSize(NursingProjectPo po) {
		return mapper.getTotalSize(po);
	}

	public void saveNursingServiceGroup(NursingServiceGroupPo po) {
		if(po.getFid()==null || "".equals(po.getFid())){
				//新增
				String fid=IdGen.getRandomNoYMS("HLLX",4);
				String fNumber=IdGen.getRandomNoYMS("HLLXN",4);
				po.setFid(fid);
				po.setfNumber(fNumber);
				po.setfStatus("1");
				
				mapper.insertNursingServiceGroup(po);
		}else{
			//修改
			mapper.updateNursingServiceGroup(po);
			
		}
		
	}

	public String checkNursingServiceGroupName(String fName) {
		String existFid=mapper.checkNursingServiceGroupName(fName);
		return existFid;
	}

	public void saveNursingProject(NursingProjectPo po) {
		if(po.getFid()==null || "".equals(po.getFid())){
				//新增
				String fid=IdGen.getRandomNoYMS("HLXM",4);
				po.setFid(fid);
				po.setFstatus("1");
				
				//if("1".equals(po.getfExecuteType())){
				
					int fExecutecycle=Integer.parseInt(po.getfExecutecycle()==null?"0":po.getfExecutecycle());
					//2-周，换算成天存储
					if("2".equals(po.getfExecutecycleUnit())){
						fExecutecycle=fExecutecycle*7;
						po.setfExecutecycle(fExecutecycle+"");
					}
					//3-月，换算成天存储
					if("3".equals(po.getfExecutecycleUnit())){
						fExecutecycle=fExecutecycle*30;
						po.setfExecutecycle(fExecutecycle+"");
					}
					//4-年，换算成天存储
					if("4".equals(po.getfExecutecycleUnit())){
						fExecutecycle=fExecutecycle*365;
						po.setfExecutecycle(fExecutecycle+"");
					}
				/*}else{
					po.setfExecutecycle("0");
					po.setfExecuteQty("0");
					po.setfExcludtime("0");
				}*/
				mapper.insertNursingProject(po);
				
				//先删除原有的护理级别与项目的关系，在存入数据
				mapper.deleteServiceItemLevel(po.getFid());
				
				if(po.getFserviceLevels() !=null && !"".equals(po.getFserviceLevels())){
					String[] fserviceLevels=po.getFserviceLevels().split(",");
					for (String levelID : fserviceLevels) {
						NursingServiceItemLevelPo serviceItemLevelPo=new  NursingServiceItemLevelPo();
						String levelFid=IdGen.getRandomNoYMS("HLJB",4);
						serviceItemLevelPo.setFid(levelFid);
						serviceItemLevelPo.setfParentID(fid);
						serviceItemLevelPo.setfNurseLevelID(levelID);
						mapper.insertServiceItemLevel(serviceItemLevelPo);
					}
				}
				
		}else{
			//修改
			String fid=po.getFid();
			po.setFid(fid);
			po.setFstatus("1");
			
			po.setFstatus("1");
			
			//if("1".equals(po.getfExecuteType())){
				
				int fExecutecycle=Integer.parseInt(po.getfExecutecycle()==null?"0":po.getfExecutecycle());
				//2-周，换算成天存储
				if("2".equals(po.getfExecutecycleUnit())){
					fExecutecycle=fExecutecycle*7;
					po.setfExecutecycle(fExecutecycle+"");
				}
				//3-月，换算成天存储
				if("3".equals(po.getfExecutecycleUnit())){
					fExecutecycle=fExecutecycle*30;
					po.setfExecutecycle(fExecutecycle+"");
				}
				//4-年，换算成天存储
				if("4".equals(po.getfExecutecycleUnit())){
					fExecutecycle=fExecutecycle*365;
					po.setfExecutecycle(fExecutecycle+"");
				}
			/*}else{
				po.setfExecutecycle("0");
				po.setfExecuteQty("0");
				po.setfExcludtime("0");
			}*/
			mapper.updateNursingProject(po);
			
			//先删除原有的护理级别与项目的关系，在存入数据
			mapper.deleteServiceItemLevel(po.getFid());
			
			if(po.getFserviceLevels() !=null && !"".equals(po.getFserviceLevels())){
				String[] fserviceLevels=po.getFserviceLevels().split(",");
				for (String levelID : fserviceLevels) {
					NursingServiceItemLevelPo serviceItemLevelPo=new  NursingServiceItemLevelPo();
					String levelFid=IdGen.getRandomNoYMS("HLJB",4);
					serviceItemLevelPo.setFid(levelFid);
					serviceItemLevelPo.setfParentID(fid);
					serviceItemLevelPo.setfNurseLevelID(levelID);
					mapper.insertServiceItemLevel(serviceItemLevelPo);
				}
			}
			
		}
		
	}

	public String checkNursingProjectName(String fName) {
		String existFid=mapper.checkNursingProjectName(fName);
		return existFid;
	}

	public List<DataDictionaryPo> getDcValueByName(DataDictionaryPo po) {
		return mapper.getDcValueByName(po);
	}

	public List<NursingServiceGroupPo> getServiceGroups(Map<String,String> map) {
		return mapper.getServiceGroups(map);
	}

	public NursingProjectPo getNursingProject(String fid) {
		return mapper.getNursingProject(fid);
	}

	public List<NursingServiceItemLevelPo> getServiceLevelByFparentId(String fid) {
		return mapper.getServiceLevelByFparentId(fid);
	}

	public void delNursingProject(String fid) {
		mapper.delNursingProject(fid);
	}

	public List<NursingProjectPo> queryDetailList(NursingProjectPo po) {
		return mapper.queryDetailList(po);
	}

	public List<NursingServiceGroupPo> queryServiceGroupList(
			NursingServiceGroupPo po) {
		return mapper.queryServiceGroupList(po);
	}

	public int getServiceGroupTotalSize(NursingServiceGroupPo po) {
		return mapper.getServiceGroupTotalSize(po);
	}

	public void updateNursingProject(NursingProjectPo po) {
		String fstatus=po.getFstatus();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		/**
		 * 状态fstatus=1 启用，启用时，将结束时间置空，修改开始时间为当前时间
		 * 状态 fstatus=2 禁用，禁用时，结束时间由前台选择传入
		 */
		
		if("1".equals(fstatus)){
			po.setfEndDate(null);
			po.setfStarteDate(sdf.format(new Date()));
			//启用项目后，将老人/公共护理项目的启用时间修改为当前时间，并将结束时间置空 TO-DO
			
		}else if("2".equals(fstatus)){
			//禁用项目后，将老人/公共护理项目的结束时间修改为用户的选择时间TO-DO
			
		}
		mapper.updateNursingProject(po);
	}

	public boolean checkProjectUsed(NursingProjectPo po) {
		int count=mapper.checkProjectUsed(po);
		if(count>0){
			//能查找到记录则说明已经在老人/公共服务项目引用，反之没有
			return true;
		}else{
			return false; 
		}
	}

	@Override
	public NursingProjectPo getNursingProjectPoByFid(String fid) {
		return mapper.getNursingProjectPoByFid(fid);
	}

	@Override
	public String getFnursingHomeIDByUserID(String uid) {
		return mapper.getFnursingHomeIDByUserID(uid);
	}

	@Override
	public String checkServiceType(String fServiceGroupID) {
		return mapper.checkServiceType(fServiceGroupID);
	}
	
}
