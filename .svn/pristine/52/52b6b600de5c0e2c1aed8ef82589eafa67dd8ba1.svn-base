package com.channelsoft.ems.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.channelsoft.ems.mapper.OldManQuitMapper;
import com.channelsoft.ems.mapper.TRoomMapper;
import com.channelsoft.ems.mapper.TeBedMapper;
import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManMainPo;
import com.channelsoft.ems.po.TBedPo;
import com.channelsoft.ems.po.TRoomPo;
import com.channelsoft.ems.service.OldManQuitService;

@Service
public class OldManQuitServiceImpl implements OldManQuitService {

	private Logger logger=Logger.getLogger(OldManQuitServiceImpl.class);
	
	@Autowired
	private OldManQuitMapper oldManQuitMapper; 
	
	@Autowired
	private TRoomMapper tRoomMapper;
	@Autowired
	private TeBedMapper teBedMapper;
	/**
	 * 查询老人信息list
	 */
	public List<OldManMainPo> query(OldManMainPo oldManMainPo,int page,int pageSize) {
		logger.debug("进入OldManLeaveServiceImpl中，开始查询退住信息");
		List<OldManMainPo> oldManMainPoList = oldManQuitMapper.query(oldManMainPo, page,pageSize);
		return oldManMainPoList;
	}
	
	/**
	 *查询所有条数
	*/
	public int getCount(OldManMainPo oldManMainPo) {
		logger.debug("进入getCount，开始查询满足添加的条数");
		return oldManQuitMapper.getCount(oldManMainPo);
	}
	/**
	 * 查询床位  回显用
	 */
	public String getBed(String bedId) {
		logger.debug("开始查询床位号");
		String bedNumber=oldManQuitMapper.queryBedById(bedId);
		return bedNumber;
	}
/**
 * 查询退住类型  回显用
 */
	public String getLeaveTypeName(String typeId) {
		logger.debug("开始查询退住类型");
		String typeName=oldManQuitMapper.queryTypeName(typeId);
		return typeName;
	}
/**
 * 根据名获得所有类型
 */
public List<DataDictionaryPo> queryLeaveType(String typeName) {
	logger.debug("根据类型名获得所有value");
	List<DataDictionaryPo> list=oldManQuitMapper.queryLeaveType(typeName);
	return list;
}

/**
 * 根据老人的id进行查询
 */
public List<OldManMainPo> queryByFId(OldManMainPo oldManMainPo) {
	logger.debug("根据输入老人的id查询老人信息");
	 List<OldManMainPo> oldMan = oldManQuitMapper.queryOldManByUserFId(oldManMainPo);
	return oldMan;
}

/**
 * 撤销退住
 */
public int deleteLeave(OldManMainPo oldManMainPo) {
	logger.debug("根据id办理撤销退住");
	try{
		return oldManQuitMapper.deletLeave(oldManMainPo);
	}catch(Exception e){
		return 0;
	}
}
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false,rollbackFor=Exception.class)
public int addLeave(OldManMainPo oldManMainPo) throws Exception {
		logger.debug("开始办理退住业务层实现 addLeave方法");
		 List<OldManMainPo> oldMan=queryByFId(oldManMainPo);
		 int result=0;
		if(oldMan.size()==0||oldMan==null){
			return 2;
		}
		int i=oldManQuitMapper.addOldManLeave(oldManMainPo);
		if(i>0){
			if(oldMan.get(0).getFisEntire().equals("9")){
				TRoomPo room=new TRoomPo();
				room.setfID(oldMan.get(0).getFroomID());
				room.setfStatus("01");
				try{
					tRoomMapper.updRoomState(room);
					result=1;
				}catch(Exception e){
					result=0;
					throw new Exception();
				}
				TBedPo bed=new TBedPo();
				bed.setfRoomID(room.getfID());
				bed.setfStatus("2");
				try{
					teBedMapper.updBedStateByRoom(bed);
					result=1;
				}catch(Exception e){
					result=0;
					throw new Exception();
				}
			}else{
				TBedPo bed=new TBedPo();
				bed.setfID(oldMan.get(0).getFbedID());
				bed.setfStatus("2");
				try{
					teBedMapper.updBedState(bed);
					result=1;
				}catch(Exception e){
					result=0;
					throw new Exception();
				}
			}
		}else{
			throw new Exception();
		}
		return result;
	}
}
