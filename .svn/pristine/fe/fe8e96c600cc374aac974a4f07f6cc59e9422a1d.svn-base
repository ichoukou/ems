package com.channelsoft.ems.controller;

import com.channelsoft.ems.common.ConstantsMap;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanOldManService;
import com.channelsoft.ems.po.*;
import com.channelsoft.ems.service.OldManHosingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjs on 2016/12/14.
 */
@Controller
@RequestMapping("/hosing")
public class OldManHosingController {

    private static Logger logger=Logger.getLogger(OldManHosingController.class);

    @Autowired
    private OldManHosingService oldManHosingService;

    @Autowired
    private NursingPlanOldManService nursingPlanOldManService;

    @RequestMapping("/oldMan")
    public String gotoOldMan(HttpServletRequest request ,HttpServletResponse response){
        logger.debug("老人入住,已经跳转");
        return "oldManHosing/oldManHosingList";
    }

    /**
     * @Method: getOldManRoom
     * @Description: 查询老人房间信息
     * @Para: [OldManMainPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/getOldManRoom")
    public AjaxResultPo getOldManRoom(OldManMainPo po,HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入oldManHosingController.getOldManRoom()方法");
        List<OldManMainPo> oldManMain=oldManHosingService.getOldManRoom(po);
        return new AjaxResultPo(true, "success", oldManMain.size(), oldManMain);
    }

    /**
     * @Method: getOldManMain
     * @Description: 查询老人信息
     * @Para: [OldManMainPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/getom")
    public AjaxResultPo getOldManMain(OldManMainPo po,HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入oldManHosingController.getomList()方法");
        List<OldManMainPo> oldManMain=oldManHosingService.getomList(po);
        for(int i=0;i<oldManMain.size();i++) {
            //老人状态从数据字典中取
            String oldManStateId=oldManMain.get(i).getFoldManStatusID();
            DataDictionaryPo dictionaryPo=ConstantsMap.dataDictionaryMap.get(oldManStateId);
            oldManMain.get(i).setFoldManStatusName(dictionaryPo.getValue());

            //入住类型从数据字典中取
            String oldManTypeId=oldManMain.get(i).getFoldManTypeID();
            DataDictionaryPo dicPo=ConstantsMap.dataDictionaryMap.get(oldManTypeId);
            oldManMain.get(i).setFoldManTypeName(dicPo.getValue());

            //根据内存中加载的床位是否为空，返回是否是整租
            String bedId = oldManMain.get(i).getFbedID();
            TBedPo bedPo = ConstantsMap.bedMap.get(bedId);
            String bedNumber = "";
            if (bedPo != null) {
                bedNumber = bedPo.getfBedNumber();
            }else{
                bedNumber="整租";
            }
            oldManMain.get(i).setfBedNumber(bedNumber);
            //根据老人护理级别ID查询内存中的护理级别并显示
//            String nursingId=oldManMain.get(i).getfLevelID();
            String nursingId=oldManMain.get(i).getFnursingLevel();
            DataDictionaryPo dataDictionaryPo=ConstantsMap.dataDictionaryMap.get(nursingId);
            oldManMain.get(i).setFnursingLevelName(dataDictionaryPo.getValue());
        }
        return new AjaxResultPo(true, "success", oldManMain.size(), oldManMain);
    }

    /**
     * @Method: queryOldManMain
     * @Description: 分页查询老人信息
     * @Para: [OldManMainPo, page, pageSize,startTime,stopTime]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo queryOldManMain(OldManMainPo po, int page, int pageSize,String startTime,
                  String stopTime, HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入OldManHosingController.queryOldManMain()方法，老人入住列表请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<OldManMainPo> oldManMain=oldManHosingService.queryList(po,page,pageSize,startTime,stopTime);

        for(int i=0;i<oldManMain.size();i++) {
            //老人状态从数据字典中取
            String oldManStateId=oldManMain.get(i).getFoldManStatusID();
            DataDictionaryPo dictionaryPo=ConstantsMap.dataDictionaryMap.get(oldManStateId);
            oldManMain.get(i).setFoldManStatusName(dictionaryPo.getValue());

            //入住类型从数据字典中取
            String oldManTypeId=oldManMain.get(i).getFoldManTypeID();
            DataDictionaryPo dicPo=ConstantsMap.dataDictionaryMap.get(oldManTypeId);
            oldManMain.get(i).setFoldManTypeName(dicPo.getValue());

            //根据内存中加载的床位是否为空，返回是否是整租
            String bedId = oldManMain.get(i).getFbedID();
            TBedPo bedPo = ConstantsMap.bedMap.get(bedId);
            String bedNumber = "";
            if (bedPo != null) {
                bedNumber = bedPo.getfBedNumber();
            }else{
                bedNumber="整租";
            }
            oldManMain.get(i).setfBedNumber(bedNumber);
            //根据老人护理级别ID查询内存中的护理级别并显示
//            String nursingId=oldManMain.get(i).getfLevelID();
//            DataDictionaryPo dataDictionaryPo=ConstantsMap.dataDictionaryMap.get(nursingId);
//            oldManMain.get(i).setFnursingLevelName(dataDictionaryPo.getValue());
            //根据老人护理级别ID查询内存中的护理级别并显示
            String nursingId=oldManMain.get(i).getFnursingLevel();
            DataDictionaryPo dataDictionaryPo=ConstantsMap.dataDictionaryMap.get(nursingId);
            oldManMain.get(i).setFnursingLevelName(dataDictionaryPo.getValue());
        }
        int dataCount=oldManHosingService.queryCount(po,startTime,stopTime);
        return new AjaxResultPo(true, "success", dataCount, oldManMain);
    }

    /**
     * @Method: queryOldManMainByState
     * @Description: 根据状态分页查询老人信息
     * @Para: [OldManMainPo, page, pageSize,startTime,stopTime]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/queryOldManMainByState")
    public AjaxResultPo queryOldManMainByState(OldManMainPo po, int page, int pageSize,String startTime,
                  String stopTime, HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入OldManHosingController.queryOldManMainByState()方法，老人入住列表请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<OldManMainPo> oldManMain=oldManHosingService.queryOldManMainByState(po,page,pageSize,startTime,stopTime);

        for(int i=0;i<oldManMain.size();i++) {
            OldManMainPo oldManMainPo = oldManMain.get(i);
            //老人状态从数据字典中取
            String oldManStateId = oldManMainPo.getFoldManStatusID();
            DataDictionaryPo dictionaryPo = ConstantsMap.dataDictionaryMap.get(oldManStateId);
            oldManMain.get(i).setFoldManStatusName(dictionaryPo.getValue());

            //入住类型从数据字典中取
            String oldManTypeId = oldManMainPo.getFoldManTypeID();
            DataDictionaryPo dicPo = ConstantsMap.dataDictionaryMap.get(oldManTypeId);
            oldManMain.get(i).setFoldManTypeName(dicPo.getValue());

            //根据内存中加载的床位是否为空，返回是否是整租
            String bedId = oldManMainPo.getFbedID();
            TBedPo bedPo = ConstantsMap.bedMap.get(bedId);
            String bedNumber = "";
            if (bedPo != null) {
                bedNumber = bedPo.getfBedNumber();
            } else {
                bedNumber = "整租";
            }
            oldManMain.get(i).setfBedNumber(bedNumber);
            String nursingId =oldManMainPo.getFnursingLevel();
            DataDictionaryPo dataDictionaryPo = ConstantsMap.dataDictionaryMap.get(nursingId);
            oldManMain.get(i).setFnursingLevelName(dataDictionaryPo.getValue());
        }
        int dataCount=oldManHosingService.queryCountByState(po);
        return new AjaxResultPo(true, "success", dataCount, oldManMain);
    }

    /**
     * @Method: queryLast
     * @Description: 查询最后一条老人信息
     * @Para: [OldManMainPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/queryLast")
    public AjaxResultPo queryLast(HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入OldManHosingController.queryLast()方法");
        List<OldManMainPo> lastOldManMain=oldManHosingService.queryLast();
        return new AjaxResultPo(true, "success", lastOldManMain.size(), lastOldManMain);
    }

    /**
     * @Method: addOldManBase
     * @Description: 添加老人基本信息
     * @Para: [OldManMainPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/addBase")
    public AjaxResultPo addOldManBase(OldManMainPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入OldManHosingController.addBase()方法");
        try{
            UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
            po.setfCreatorID(user.getEmployId());
            po.setfNursing_homeID(user.getOldhouse());

            //添加的同时查询出来给护理康复使用
            List<OldManMainPo> lastOldMan=oldManHosingService.addBase(po);
            String foldmanid=lastOldMan.get(0).getfID();
            String fnursingLevel=lastOldMan.get(0).getFnursingLevel();
            nursingPlanOldManService.insertOldManServiceItemByContidtion(foldmanid,fnursingLevel);
//            ConstantsMap.queryOldman();
            return new AjaxResultPo(true,"添加老人基本信息成功");
        }catch (Exception e){
            logger.error("添加老人基本信息失败",e);
            return new AjaxResultPo(false,"添加老人基本信息失败");
        }
    }

    /**
     * @Method: updBase
     * @Description: 修改老人基本信息
     * @Para: [OldManMainPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updBase")
    public AjaxResultPo updBase(OldManMainPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入OldManHosingController.updBase()方法");
        try{
            OldManMainPo oldManMain=oldManHosingService.getOldManById(po.getfID());
//            如果评估老人定级修改了，调用护理康复接口
            if(!oldManMain.getFnursingLevel().equals(po.getFnursingLevel())){
                nursingPlanOldManService.insertOldManServiceItemByContidtion(po.getfID(),po.getFnursingLevel());
            }
            oldManHosingService.updBase(po);
//            ConstantsMap.queryOldman();
            return new AjaxResultPo(true,"修改老人基本信息成功");
        }catch (Exception e){
            logger.error("修改老人基本信息失败",e);
            return new AjaxResultPo(false,"修改老人基本信息失败");
        }
    }

    /**
     * @Method: updOldManState
     * @Description: 修改老人状态
     * @Para: [OldManMainPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updOldManState")
    public AjaxResultPo updOldManState(OldManMainPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入OldManHosingController.updOldManState()方法");

        try{
            oldManHosingService.updOldManState(po);
//            ConstantsMap.queryOldman();
            return new AjaxResultPo(true,"修改老人状态成功");
        }catch (Exception e){
            logger.error("修改老人状态失败",e);
            return new AjaxResultPo(false,"修改老人状态失败");
        }
    }
}
