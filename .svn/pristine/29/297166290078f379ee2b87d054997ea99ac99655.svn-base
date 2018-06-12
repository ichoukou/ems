package com.channelsoft.ems.controller;

import com.channelsoft.ems.common.ConstantsMap;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanPublicService;
import com.channelsoft.ems.po.*;
import com.channelsoft.ems.service.TeRoomService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wangjs on 2016/12/4.
 */
@Controller
@RequestMapping("/room")
public class TeRoomController {

    private static Logger logger=Logger.getLogger(TeRoomController.class);

    @Autowired
    private TeRoomService teRoomService;

    @Autowired
    private NursingPlanPublicService nursingPlanPublicService;

    @RequestMapping("/roList")
    public String gotoChargeStandardList(){
        logger.debug("房间,已经跳转");
        return "tRoom/tRoomList";
    }

    /**
     * @Method: queryRoom
     * @Description: 分页查询房间
     * @Para: [TRoomPo po, int page, int pageSize]
     * @Retun: List<TRoomPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo queryRoom(TRoomPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入TeRoomController.query()方法,请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);

//        if(po.getfFLoorName()!=null&&!(po.getfFLoorName().equals(""))) {
//            TFloorPo floPo = ConstantsMap.floorMapForName.get(po.getfFLoorName());
//            String floId = floPo.getfID();
//            po.setfFLoorID(floId);
//        }
        List<TRoomPo> roomList=teRoomService.queryRoom(po,page,pageSize);
//        for(int i=0;i<roomList.size();i++){
//            String buildId=roomList.get(i).getfBuildingID();
//            TBuildingPo tbPo= ConstantsMap.buildingMap.get(buildId);
//            String buildName=tbPo.getfBuildingName();
//            roomList.get(i).setfBuildingName(buildName);
//
//            String floorId=roomList.get(i).getfFLoorID();
//            TFloorPo flPo= ConstantsMap.floorMap.get(floorId);
//            String floorName=flPo.getfFLoorName();
//            roomList.get(i).setfFLoorName(floorName);
//        }
        int dataCount=teRoomService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,roomList);
    }

    /**
     * @Method: getRoom
     * @Description: 查询房间
     * @Para: [TRoomPo]
     * @Retun: List<TRoomPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/get")
    public AjaxResultPo getRoom(TRoomPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入TeRoomController.方法,请求参数: "+ po.toString());

        List<TRoomPo> roomList=teRoomService.getRoom(po);
        return new AjaxResultPo(true,"success",roomList.size(),roomList);
    }

    /**
     * @Method: getLastRoom
     * @Description: 查询最后一间房间
     * @Para: [TRoomPo]
     * @Retun: List<TRoomPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/getLastRoom")
    public AjaxResultPo getLastRoom(TRoomPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入TeRoomController.getLastRoom()方法 ");
        List<TRoomPo> roomList=teRoomService.getLastRoom(po);
        return new AjaxResultPo(true,"success",roomList.size(),roomList);
    }

    /**
     * @Method: addRoom
     * @Description: 添加房间
     * @Para: [TRoomPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/addRoom")
    public AjaxResultPo addRoom(TRoomPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeRoomController.addChargeStandard()方法");
        try{
            UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
            po.setfNursingHomeID(user.getOldhouse());

            //添加房间后查询出新添加房间的ID，给护理康复模块使用
            List<TRoomPo> lastRoom=teRoomService.addRoom(po);
            String roomId=lastRoom.get(0).getfID();
            nursingPlanPublicService.insertPublicServiceItemByContidtion(roomId,null);
//            ConstantsMap.queryRoom();
            return new AjaxResultPo(true,"添加房间成功");
        }catch (Exception e){
            logger.error("添加房间失败",e);
            return new AjaxResultPo(true,"添加房间失败");
        }
    }

    /**
     * @Method: updRoom
     * @Description: 修改房间
     * @Para: [TRoomPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updRoom")
    public AjaxResultPo updRoom(TRoomPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeRoomController.updChargeStandard()方法");
        try{
            teRoomService.updRoom(po);
//            ConstantsMap.queryRoom();
            return new AjaxResultPo(true,"修改房间成功");
        }catch (Exception e){
            logger.error("修改房间失败",e);
            return new AjaxResultPo(true,"修改房间失败");
        }
    }

    /**
     * @Method: updRoomState
     * @Description: 修改房间状态
     * @Para: [TRoomPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updRoomState")
    public AjaxResultPo updRoomState(TRoomPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeRoomController.updChargeStandard()方法");
        try{
            teRoomService.updRoomState(po);
//            ConstantsMap.queryRoom();
            return new AjaxResultPo(true,"修改房间状态成功");
        }catch (Exception e){
            logger.error("修改房间状态失败",e);
            return new AjaxResultPo(true,"修改房间状态失败");
        }
    }

    /**
     * @Method: delRoom
     * @Description: 删除房间
     * @Para: [TRoomPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/delRoom")
    public AjaxResultPo delRoom(TRoomPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeRoomController.delRoom()方法");
        try{
            teRoomService.delRoom(po);
//            ConstantsMap.queryRoom();
            return new AjaxResultPo(true,"删除房间成功");
        }catch (Exception e){
            logger.error("删除房间失败",e);
            return new AjaxResultPo(true,"删除房间失败");
        }
    }
}
