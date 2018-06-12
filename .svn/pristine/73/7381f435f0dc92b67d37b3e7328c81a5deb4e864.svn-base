package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.LeavePo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.EmpLeaveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 张鑫 on 2016/12/7.
 */
@Controller
@RequestMapping("/employ")
public class EmpLeaveController {

    private static Logger logger = Logger.getLogger(EmpLeaveController.class);

    @Autowired
    private EmpLeaveService empLeaveService;

    @RequestMapping("/employLeave")
    public String gotoEmpLeave(HttpServletRequest request , HttpServletResponse response){
        return "empLeave/empLeaveList";
    }

    /**
    *@Description:查询分页用
    *@Param:po
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo gotoEmpleaveList(LeavePo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("leave--请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<LeavePo> leaveList=empLeaveService.queryList(po,page,pageSize);
        logger.debug("gotoEmpleaveList（）方法");
        int dataCount=empLeaveService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,leaveList);
    }


    /**
    *@Description:新增请假信息
    *@Param:po
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    @ResponseBody
    @RequestMapping("/addEmpLeave")
    public AjaxResultPo addEmpList(LeavePo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入   addEmpList()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("穿过来的对象"+po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setfNursinghomeID(user.getOldhouse());
        po.setfCreatorID(user.getEmployId());
        try {
            if(this.empLeaveService.addEmpList(po)==0){
                logger.debug("增加成功");
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入增加方法,增加失败");
                request.getSession().setAttribute("dmsg", "增加失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "增加异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    /**
    *@Description:根据id删除员工请假信息
    *@Param:po
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    @ResponseBody
    @RequestMapping("/deleteEmpLeave")
    public AjaxResultPo deleteEmpLeave(LeavePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   deleteEmpLeave()......");
        try {
            if(this.empLeaveService.deleteEmpLeave(po.getfId())==0){
                logger.debug("成功删除"+po.getfId());
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入删除方法,删除失败");
                request.getSession().setAttribute("dmsg", "删除失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "删除异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    /**
    *@Description:更新
    *@Param:po
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    @ResponseBody
    @RequestMapping("/updateEmpLeave")
    public AjaxResultPo updateEmpLeave(LeavePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   updateEmpLeave()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("需要更新字段"+po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setfNursinghomeID(user.getOldhouse());
        po.setfCreatorID(user.getEmployId());
        try {
            if(this.empLeaveService.updateEmpLeaveList(po)==0){
                logger.debug("更新成功");
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入更新方法,更新失败");
                request.getSession().setAttribute("dmsg", "更新失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "更新异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
    *@Description:新增请假时间验证
    *@Param:po
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    @ResponseBody
    @RequestMapping("/addTimeCheck")
    public AjaxResultPo addTimeCheck(LeavePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入 addTimeCheck()......");
        try {
            List<LeavePo> timeList =  this.empLeaveService.queryAddTime(po);
            return new AjaxResultPo(true,"success",timeList.size(),timeList);
        } catch (Exception e) {
            request.getSession().setAttribute("dmsg", "删除异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    /**
    *@Description:更新验证时间不重复
    *@Param:po
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    @ResponseBody
    @RequestMapping("/updateTimeCheck")
    public AjaxResultPo updateTimeCheck(LeavePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入 updateTimeCheck()......");
        try {
            List<LeavePo> timeList =  this.empLeaveService.queryUpdateTime(po);
            return new AjaxResultPo(true,"success",timeList.size(),timeList);
        } catch (Exception e) {
            request.getSession().setAttribute("dmsg", "删除异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
