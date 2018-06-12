package com.channelsoft.ems.controller;

import com.channelsoft.ems.nursing.nursingPlan.po.OldManPo;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanOldManService;
import com.channelsoft.ems.po.*;
import com.channelsoft.ems.service.CaregiversService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

/**
 * Created by zhangxin on 2017/2/24.
 */
@Controller
@RequestMapping("/staff")
public class MobileStaffController {

    private static Logger logger = Logger.getLogger(MobileStaffController.class);

    @Autowired
    private CaregiversService caregiversService;
    
    @Autowired
	private NursingPlanOldManService nursingPlanOldManService;

    @RequestMapping("/staffServiceHome")
    public String staffServiceHome(HttpServletRequest request,ModelMap model){
        UserPo user=(UserPo) request.getSession().getAttribute("mobileUser");
        List<List<PublicServicePlanPo>> roomCleanStateList=caregiversService.getRoomCleanState(user.getEmployId());
        for(int i=0;i<roomCleanStateList.size();i++){
            for(int j=0;j<roomCleanStateList.get(i).size();j++){
                if((roomCleanStateList.get(i).get(j).getFstatus()).equals("1")){
                    roomCleanStateList.get(i).get(j).setFstatus("未执行");
                }
                if((roomCleanStateList.get(i).get(j).getFstatus()).equals("2")){
                    roomCleanStateList.get(i).get(j).setFstatus("已执行");
                }
            }
        }

        //个人护理
        List<List<OldManServiceplanPo>> oldManCleanStateList=caregiversService.getOldManService(user.getEmployId());

        model.addAttribute("roomCleanStateList",roomCleanStateList);
        model.addAttribute("oldManCleanStateList",oldManCleanStateList);
        return "mobile/mobileStaff/staffHome";
    }

    @RequestMapping("/allHome")
    public String allHome(HttpServletRequest request,ModelMap model){
        List<List<PublicServicePlanPo>> allRoomCleanStateList=caregiversService.getAllRoomCleanState();
        for(int i=0;i<allRoomCleanStateList.size();i++){
            for(int j=0;j<allRoomCleanStateList.get(i).size();j++){
                if((allRoomCleanStateList.get(i).get(j).getFstatus()).equals("1")){
                    allRoomCleanStateList.get(i).get(j).setFstatus("未执行");
                }
                if((allRoomCleanStateList.get(i).get(j).getFstatus()).equals("2")){
                    allRoomCleanStateList.get(i).get(j).setFstatus("已执行");
                }
            }
        }
        model.addAttribute("allRoomCleanStateList",allRoomCleanStateList);
        return "mobile/mobileStaff/allHome";
    }


    @ResponseBody
    @RequestMapping("/getRoomCleanState")
    public AjaxResultPo getRoomCleanState(HttpServletRequest request){
        UserPo user=(UserPo) request.getSession().getAttribute("mobileUser");
        if(user!=null){
            List<List<PublicServicePlanPo>> roomCleanStateList=caregiversService.getRoomCleanState(user.getEmployId());
            return new AjaxResultPo(true,"查询房间清理状态成功",roomCleanStateList.size(),roomCleanStateList);
        }else{
            return new AjaxResultPo(false,"查询房间清理状态失败");
        }
    }
    
	
	/**
	 * 护理计划老人信息数据查询
	 * @param po
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryOldmanList")
    public AjaxResultPo queryOldManList(OldManPo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	
    	List<OldManPo> pos=nursingPlanOldManService.queryOldManListNoPage(po);
        //int totalSize=nursingPlanOldManService.queryOldManTotal(po);
    	
        return new AjaxResultPo(true, "success", pos.size(), pos);
    }
    

    @RequestMapping("/staffHomeDetail")
    public String staffHomeDetail(String froomID, ModelMap model, HttpServletRequest request, HttpServletResponse response){
        List<ServiceItemPo> list=caregiversService.getServiceItem(froomID);
        model.addAttribute("list",list);
        return "mobile/mobileStaff/roomService";
    }

    @RequestMapping("/oldManServiceDetail")
    public String oldManServiceDetail(String froomID, ModelMap model, HttpServletRequest request, HttpServletResponse response){
        List<ServiceItemPo> list=caregiversService.getOldManServiceItem(froomID);
        model.addAttribute("list",list);
        return "mobile/mobileStaff/roomService";
    }

    @ResponseBody
    @RequestMapping("/staffHomeDetailPerform")
    public String staffHomeDetailPerform(@RequestParam(value = "arrData")String [] arr, HttpServletRequest request, HttpServletResponse response){
        try {
            caregiversService.staffHomeDetailPerform(arr);
        }catch (Exception e){
            e.getMessage();
        }

        return "mobile/mobileStaff/roomService";
    }

    @ResponseBody
    @RequestMapping("/staffHomeDetailCancelPerform")
    public String staffHomeDetailCancelPerform(@RequestParam(value = "arrData")String [] arr, HttpServletRequest request, HttpServletResponse response){
        try {
            caregiversService.staffHomeDetailCancelPerform(arr);
        }catch (Exception e){
            e.getMessage();
        }

        return "mobile/mobileStaff/roomService";
    }

    @ResponseBody
    @RequestMapping("/getStaffHomeDetail")
    public AjaxResultPo getRoomItem(String froomID, HttpServletRequest request){
        List<ServiceItemPo> serviceItemPoList=caregiversService.getServiceItem(froomID);
        return new AjaxResultPo(true,"查询房间清理状态成功",serviceItemPoList.size(),serviceItemPoList);
    }

    @RequestMapping("/staffOldMan")
    public String StaffOldMan(){
        return "mobile/mobileStaff/staffOldMan";
    }

    @RequestMapping("/staffMessage")
    public String StaffMessage(){
        return "mobile/mobileStaff/staffMessage";
    }

    @RequestMapping("/staffMine")
    public String StaffMine(){
        return "mobile/mobileStaff/staffMine";
    }
}
