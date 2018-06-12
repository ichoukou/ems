package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.RewardsPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.EmpRewardsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by 张鑫 on 2016/12/15.
 */
@Controller
@RequestMapping("/rewards")
public class EmpRewardsController {

    private static Logger logger = Logger.getLogger(EmpRewardsController.class);

    @Autowired
    private EmpRewardsService empRewardsService;

    @RequestMapping("/employRewards")
    public String gotoEmpRewards(HttpServletRequest request, HttpServletResponse response) {
        return "empRewards/empRewardsList";
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
    public AjaxResultPo gotoEmpleaveList(RewardsPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("leave--请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<RewardsPo> leaveList=empRewardsService.queryList(po,page,pageSize);
        logger.debug("gotoEmpleaveList（）方法");
        int dataCount=empRewardsService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,leaveList);
    }


    /**
     *@Description:新增奖惩信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/addEmpRewards")
    public AjaxResultPo addEmpList(RewardsPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入   addEmpList()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("穿过来的对象"+po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setfNursingHomeID(user.getOldhouse());
        po.setfCreatorID(user.getEmployId());
        try {
            if(this.empRewardsService.addEmpRewards(po)==0){
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
     *@Description:删除奖惩信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/deleteEmpRewards")
    public AjaxResultPo deleteEmpRewards(RewardsPo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   deleteEmpRewards()......");
        try {
            if(this.empRewardsService.deleteEmpRewards(po.getfID())==0){
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
     *@Description:更新请假信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/updateEmpRewards")
    public AjaxResultPo updateEmpRewards(RewardsPo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   updateEmpRewards()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("需要更新字段"+po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setfNursingHomeID(user.getOldhouse());
        po.setfCreatorID(user.getEmployId());
        try {
            if(this.empRewardsService.updateEmpRewards(po)==0){
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
}