package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.MessagePo;
import com.channelsoft.ems.service.EmpMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by 张鑫 on 2016/12/6.
 */
@Controller
@RequestMapping("employee")
public class EmpMessageController {

    private static Logger logger = Logger.getLogger(EmpMessageController.class);

    @Autowired
    private EmpMessageService empMessageService;

    @RequestMapping("/employList")
    public String gotoEmpMessage(HttpServletRequest request , HttpServletResponse response){
        return "empMessage/empMessageList";
    }

    /**
    *@Description:查询 带分页
    *@Param:MessagePo
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo gotoEmpMessageList(MessagePo po, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="10")int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("message--请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<MessagePo> messageList=empMessageService.queryList(po,page,pageSize);
        logger.debug("进入gotoEmpMessageList（）方法");
        int dataCount=empMessageService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,messageList);
    }

    /**
     *@Description:查询 不带分页
     *@Param:Message
     *@return:AjaxResultPo
     *@author:wangjunsheng
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/get")
    public AjaxResultPo getList(MessagePo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("message--请求参数: "+ po.toString());
        List<MessagePo> messageList=empMessageService.getList(po);
        logger.debug("进入getList（）方法");
        return new AjaxResultPo(true,"success",messageList.size(),messageList);
    }

    //解决分页乱码 旧版 ，新版在js层解决
    @ResponseBody
    @RequestMapping("/queryTranscoding")
    public AjaxResultPo queryTranscoding(MessagePo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response) throws UnsupportedEncodingException {
//        po.setfStaffStatus(new String(po.getfStaffStatus().getBytes("ISO-8859-1"), "utf-8"));
        logger.debug("message--请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<MessagePo> messageList=empMessageService.queryList(po,page,pageSize);
        logger.debug("进入gotoEmpMessageList（）方法");
        int dataCount=empMessageService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,messageList);
    }

    /**
     *@Description:得到部门信息
     *@Param:null
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/showDname")
    public AjaxResultPo getDepartName( HttpServletRequest request ,HttpServletResponse response){
        logger.debug("得到getDepartName");
        logger.debug("请求参数: ");
        List<Map<String,String>> list=this.empMessageService.getDepartName();
        logger.debug("list");
        return new AjaxResultPo(true, "success", list.size(), list);
    }

    /**
     *@Description:新增
     *@Param:MessagePo
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/addEmp")
    public AjaxResultPo addEmp(MessagePo po,HttpServletRequest request,HttpServletResponse response) {
        logger.debug("进入   addEmp()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("穿过来的对象"+po);
        try {
            if(this.empMessageService.addEmpList(po)==0){
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
     *@Description:根据id，更改员工状态 0.禁用，1.启用
     *@Param:MessagePo
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/deleteEmp")
    public AjaxResultPo deleteEmpMessage(MessagePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   deleteEmpMessage()......");
        try {
            if(this.empMessageService.deleteEmpMessage(po.getfId())==0){
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

    @ResponseBody
    @RequestMapping("/startMessage")
    public AjaxResultPo startMessage(MessagePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   startMessage()......");
        logger.debug("请求参数: "+ po.toString());
        try {
            if(this.empMessageService.startState(po)==0){
                logger.debug("成功启用"+po.getfId());
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入启用方法,启用失败");
                request.getSession().setAttribute("dmsg", "启用失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "启用异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    /**
     *@Description:更新
     *@Param:MessagePo
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/updateEmp")
    public AjaxResultPo updateEmpMessage(MessagePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   updateEmpMessage()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("需要更新字段"+po);
        try {
            if(this.empMessageService.updateEmpMessage(po)==0){
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
     *@Description:更新员工所属养老院的同时，更新用户的养老院
     *@Param:MessagePo
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/updateUser")
    public AjaxResultPo updateUser(MessagePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   updateEmpMessage()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("需要更新字段"+po);
        try {
            if(this.empMessageService.updateUserMessage(po)==0){
                logger.debug("更新成功");
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入更新方法,更新失败");
                request.getSession().setAttribute("dmsg", "更新失败");
                return null;
            }
        } catch (Exception e) {
            request.getSession().setAttribute("dmsg", "更新异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
