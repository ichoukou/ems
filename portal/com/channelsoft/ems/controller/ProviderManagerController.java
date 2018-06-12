package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.ProviderPo;
import com.channelsoft.ems.service.ProviderManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhangxin on 2016/12/27.
 */
@Controller
@RequestMapping("/manager")
public class ProviderManagerController {

    private static Logger logger = Logger.getLogger(ProviderManagerController.class);

    @Autowired
    private ProviderManagerService managerService;

    @RequestMapping("/providerManager")
    public String gotoEmpRewards(HttpServletRequest request, HttpServletResponse response) {
        return "providerManager/providerManagerList";
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
    public AjaxResultPo gotoProviderManagerList(ProviderPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("leave--请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<ProviderPo> providerList=this.managerService.queryList(po,page,pageSize);
        logger.debug("gotoEmpleaveList（）方法");
        int dataCount=this.managerService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,providerList);
    }


    /**
     *@Description:新增
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/addProviderManager")
    public AjaxResultPo addProviderManager(ProviderPo po, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("进入   addProviderManager()......");
        logger.debug("请求参数: " + po.toString());
        logger.debug("穿过来的对象" + po);
        try {
            if (this.managerService.addProviderManager(po) == 0) {
                logger.debug("增加成功");
                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("进入增加方法,增加失败");
                request.getSession().setAttribute("dmsg", "增加失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "增加异常");
            logger.debug("异常:" + e.getMessage());
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
    @RequestMapping("/updateProviderManager")
    public AjaxResultPo updateProviderManager(ProviderPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入   updateProviderManager()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("需要更新字段"+po);
        try {
            if(this.managerService.updateProviderManager(po)==0){
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
     *@Description:更新状态：0.禁用，1.启用
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/deleteProviderManager")
    public AjaxResultPo deleteProviderManager(ProviderPo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   deleteProviderManager()......");
        try {
            if(this.managerService.deleteProviderManager(po.getfID())==0){
                logger.debug("成功删除"+po.getfID());
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
    @RequestMapping("/startRole")
    public AjaxResultPo startRole(ProviderPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入   startRole()......");
        logger.debug("请求参数: "+ po.toString());
        try {
            if(this.managerService.startState(po)==0){
                logger.debug("成功启用"+po.getfID());
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
}
