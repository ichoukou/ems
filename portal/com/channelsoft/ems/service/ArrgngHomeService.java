package com.channelsoft.ems.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.channelsoft.ems.po.ArrgngHomePo;
/** 
 * 
 * 员工排房  
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
public interface ArrgngHomeService {

	public List<ArrgngHomePo> getAssHome();
	
	
	//获取员工对应的房间
	public List<Map<String,String>> getRoomByStaffID();
	
	//获取所有的护理员工
    public List<ArrgngHomePo> getCountSumMan();

    //获取指定员工的合计
    public List<Map<String,String>> getCount(ArrgngHomePo po);


    //得到所有房间
	public List<Map<String,String>> getAllRoom();

    //获取员工指定id
    public List<Map<String,String>> getStaffIDRoomid(String empid);
    
    //获取员工指定大厦id
    public List<Map<String,String>> getStaffIDBuildid(String idInsert);


    //删除
    public int deleteRoom(String idSum,String empid);
    
 
    //插入
	public int insertArrngHome(String[]buildId,String insertID[],String empid,String houser,String creator);

    //查询被占用的房间
    public List<Map<String,String>> getHaveNum();

    public List<Map<String,String>> getHave( String empid);



}
