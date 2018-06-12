package com.channelsoft.ems.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.channelsoft.ems.po.*;
import com.channelsoft.ems.service.impl.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Description：把数据字典放到map中以供其他模块添加时直接取
 * @author wangjs
 *
 */
public class ConstantsMap {
	
	private static Log logger= LogFactory.getLog(ConstantsMap.class);
	
	public static Map<String,DataDictionaryPo> dataDictionaryMap;
	public static Map<String,TBuildingPo> buildingMap;
	public static Map<String,TFloorPo> floorMapForName;
	public static Map<String,TFloorPo> floorMap;
	public static Map<String,TRoomPo> roomMap;
	public static Map<String,TBedPo> bedMap;
	public static Map<String,OldManMainPo> oldManMap;

	private static SysManagerServiceImpl sysManagerServiceImpl;
	private static TeBuildingServiceImpl teBuildingServiceImpl;
	private static TeFloorServiceImpl teFloorServiceImpl;
//	private static TeRoomServiceImpl teRoomServiceImpl;
	private static TeBedServiceImpl teBedServiceImpl;
	private static OldManHosingServiceImpl oldManHosingServiceImpl;

	public static void loadMap(){
		sysManagerServiceImpl=(SysManagerServiceImpl)BeanFactoryUtil.getBean("sysManagerServiceImpl");
//		teBuildingServiceImpl=(TeBuildingServiceImpl)BeanFactoryUtil.getBean("teBuildingServiceImpl");
//		teFloorServiceImpl=(TeFloorServiceImpl)BeanFactoryUtil.getBean("teFloorServiceImpl");
//		teRoomServiceImpl=(TeRoomServiceImpl)BeanFactoryUtil.getBean("teRoomServiceImpl");
		teBedServiceImpl=(TeBedServiceImpl)BeanFactoryUtil.getBean("teBedServiceImpl");
//		oldManHosingServiceImpl=(OldManHosingServiceImpl)BeanFactoryUtil.getBean("oldManHosingServiceImpl");
		queryDataDic();
//		queryBuilding();
//		queryFloor();
//		queryRoom();
		queryBed();
//		queryOldman();
	}

//	封装数据字典
	public static void queryDataDic(){
		logger.debug("进入queryDataDic()方法");
		dataDictionaryMap=new HashMap<String,DataDictionaryPo>();
		List<DataDictionaryPo> list=sysManagerServiceImpl.getDcList(new DataDictionaryPo());
		for(int i=0;i<list.size();i++){
			DataDictionaryPo dataPo=list.get(i);
			dataDictionaryMap.put(dataPo.getId(), dataPo);
		}
	}
	//封装大厦
//	public static void queryBuilding(){
//		logger.debug("进入queryBuilding()方法");
//		buildingMap=new HashMap<String,TBuildingPo>();
//		List<TBuildingPo> list=teBuildingServiceImpl.getBuilding(new TBuildingPo());
//		for(int i=0;i<list.size();i++){
//			TBuildingPo tBuildPo=list.get(i);
//			buildingMap.put(tBuildPo.getfID(), tBuildPo);
//		}
//	}
////	封装楼层
//	public static void queryFloor(){
//		logger.debug("进入queryFloor()方法");
//		floorMap=new HashMap<String,TFloorPo>();
//		floorMapForName=new HashMap<String,TFloorPo>();
//		List<TFloorPo> list=teFloorServiceImpl.getFloor(new TFloorPo());
//		for(int i=0;i<list.size();i++){
//			TFloorPo floorPo=list.get(i);
//			floorMap.put(floorPo.getfID(), floorPo);
//			floorMapForName.put(floorPo.getfFLoorName(), floorPo);
//		}
//	}
//	封装房间
//	public static void queryRoom(){
//		logger.debug("进入queryRoom()方法");
//		roomMap=new HashMap<String,TRoomPo>();
//		List<TRoomPo> list=teRoomServiceImpl.getRoom(new TRoomPo());
//		for(int i=0;i<list.size();i++){
//			TRoomPo roomPo=list.get(i);
//			roomMap.put(roomPo.getfID(), roomPo);
//		}
//	}
	//	封装床位
	public static void queryBed(){
		logger.debug("进入queryBed()方法");
		bedMap=new HashMap<String,TBedPo>();
		List<TBedPo> list=teBedServiceImpl.getBed(new TBedPo());
		for(int i=0;i<list.size();i++){
			TBedPo bedPo=list.get(i);
			bedMap.put(bedPo.getfID(), bedPo);
		}
	}
	//	封装老人
//	public static void queryOldman(){
//		logger.debug("进入queryOldman()方法");
//		oldManMap=new HashMap<String,OldManMainPo>();
//		List<OldManMainPo> list=oldManHosingServiceImpl.getomList(new OldManMainPo());
//		for(int i=0;i<list.size();i++){
//			OldManMainPo oldManMainPo=list.get(i);
//			oldManMap.put(oldManMainPo.getfID(), oldManMainPo);
//		}
//	}

}
