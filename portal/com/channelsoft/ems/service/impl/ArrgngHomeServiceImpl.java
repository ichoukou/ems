package com.channelsoft.ems.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.ArrgngHomeMapper;
import com.channelsoft.ems.mapper.AssessProjectMapper;
import com.channelsoft.ems.po.ArrgngHomePo;
import com.channelsoft.ems.service.ArrgngHomeService;
/** 
 * 
 * 员工排房  
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
@Service
public class ArrgngHomeServiceImpl implements ArrgngHomeService {


	private Logger logger=Logger.getLogger(ArrgngHomeServiceImpl.class);
	
	@Autowired
	private ArrgngHomeMapper arrgngHomeMapper;
	
	public List<ArrgngHomePo> getAssHome() {
		// TODO Auto-generated method stub
		logger.debug("进行查询 房间数");
		return this.arrgngHomeMapper.getAssHome();
	}

	public List<Map<String, String>> getRoomByStaffID() {
		// TODO Auto-generated method stub
		logger.debug("根据id 查询出管理员管理的房间");
		return this.arrgngHomeMapper.getRoomByStaffID();
	}

	public List<Map<String, String>> getCount(ArrgngHomePo po) {
		return this.arrgngHomeMapper.getCount(po);
	}

	public List<ArrgngHomePo> getCountSumMan() {
		// TODO Auto-generated method stub
		return this.arrgngHomeMapper.getCountSumMan();
	}

	public List<Map<String, String>> getAllRoom() {
		// TODO Auto-generated method stub
		return this.arrgngHomeMapper.getAllRoom();
	}

	public List<Map<String,String>> getStaffIDRoomid(String empid) {
		// TODO Auto-generated method stub
		return this.arrgngHomeMapper.getStaffIDRoomid(empid);
	}

	public int deleteRoom(String idSum,String empid) {
		logger.debug("进入delRoom()方法");
		try{
			this.arrgngHomeMapper.deleteRoom(idSum,empid);
		}catch (Exception e){
			logger.debug(e.getMessage());
			e.printStackTrace();
			logger.debug("删除房间失败");
			return 1;
		}
		return 0;
	}

	public List<Map<String, String>> getStaffIDBuildid(String idInsert) {
		// TODO Auto-generated method stub
		logger.debug("获取指定大厦id:"+idInsert);
		return this.arrgngHomeMapper.getStaffIDBuildid(idInsert);
	}

	public int insertArrngHome(String[] buildId, String[] insertID,
			String empid,String houser,String creator) {
		// TODO Auto-generated method stub
		logger.debug("插入信息:");
		try{
			this.arrgngHomeMapper.insertArrngHome(buildId, insertID, empid, houser, creator);
		}catch (Exception e){
			logger.debug(e.getMessage());
			e.printStackTrace();
			logger.debug("添加房间失败");
			return 1;
		}
		return 0;
	}

	public List<Map<String, String>> getHaveNum() {
		return this.arrgngHomeMapper.getHaveNum();
	}

	public List<Map<String, String>> getHave(String empid) {
		return this.arrgngHomeMapper.getHave(empid);
	}


}
