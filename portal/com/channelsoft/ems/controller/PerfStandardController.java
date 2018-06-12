package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.RankPo;
import com.channelsoft.ems.po.StandardPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.PerfStandardService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 张鑫 on 2016/12/16.
 */

@Controller
@RequestMapping("/standard")
public class PerfStandardController {

    private static Logger logger = Logger.getLogger(PerfStandardController.class);

    @Autowired
    private PerfStandardService standardService;

    @RequestMapping("/perfStandard")
    public String gotoEmpRewards(HttpServletRequest request, HttpServletResponse response) {
        return "perfStandard/perfStandardList";
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
    public AjaxResultPo gotoList( int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("请求参数: page "+ page + " pageSize " + pageSize);
        List<StandardPo> list = this.standardService.queryList(page, pageSize);
        logger.debug("gotoEmpleaveList（）方法");
        int dataCount=standardService.queryCount();
        return new AjaxResultPo(true, "success",dataCount, list);
    }

    /**
     *@Description:新增
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/addStandard")
    public AjaxResultPo addStandard(StandardPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入   addStandard()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("穿过来的对象"+po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setfNursingHomeID(user.getOldhouse());
        po.setfCreatorID(user.getEmployId());

        try {
            if(this.standardService.addStandard(po)==0){
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
     *@Description:删除
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/deleteStandard")
    public AjaxResultPo deleteStandard(StandardPo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   deleteStandard()......");
        try {
            if(this.standardService.deleteStandard(po.getfID())==0){
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

    /**
     *@Description:更新
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/updateStandard")
    public AjaxResultPo updateStandard(StandardPo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   updateStandard()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("需要更新字段"+po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setfNursingHomeID(user.getOldhouse());
        po.setfCreatorID(user.getEmployId());

        try {
            if(this.standardService.updatePerfStandardList(po)==0){
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
