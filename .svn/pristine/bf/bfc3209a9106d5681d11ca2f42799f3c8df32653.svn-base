package com.channelsoft.ems.controller;

import com.channelsoft.ems.common.ConstantsMap;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.OldManFreePo;
import com.channelsoft.ems.po.OldManMainPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.OldManFreeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

/**
 * Created by wangjs on 2016/12/28.
 */
@Controller
@RequestMapping("/free")
public class OldManFreeController {

    private Logger logger= Logger.getLogger(OldManLeaveController.class);

    @Autowired
    private OldManFreeService oldManFreeService;

    @RequestMapping("/omFree")
    public String getList(HttpServletRequest request, HttpServletResponse response){
        logger.debug("减免单据，已经跳转");
        return "oldManFree/oldManFreeList";
    }

    /**
     * @Method: queryOldManFree
     * @Description: 分页减免单据
     * @Para: [OldManFreePo, page, pageSize]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo queryOldManFree(OldManFreePo po,String startTime,String stopTime, int page, int pageSize, HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入OldManFreeController.query()方法");
        List<OldManFreePo> getList=oldManFreeService.queryList(po,page,pageSize,startTime,stopTime);
        int dataCount=oldManFreeService.queryCount(po,startTime,stopTime);
        return new AjaxResultPo(true,"success",dataCount,getList);
    }

    /**
     * @Method: queryLastFree
     * @Description: 查询减免单据最后一条数据
     * @Para: [OldManFreePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    @ResponseBody
    @RequestMapping("/queryLastFree")
    public AjaxResultPo queryLastFree(OldManFreePo po,HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入OldManFreeController.query()方法");
        List<OldManFreePo> getList=oldManFreeService.queryLastFree(po);
        return new AjaxResultPo(true,"success",getList.size(),getList);
    }

    /**
     * @Method: addOldManFree
     * @Description: 添加减免单据
     * @Para: [OldManFreePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/addOmFree")
    public AjaxResultPo addOldManFree(OldManFreePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入OldManFreeController.addOmFree()方法");
        try{
            UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
            po.setfCreatorID(user.getEmployId());
            po.setfNursinghomeID(user.getOldhouse());
            po.setfNumber(UUID.randomUUID().toString());
            oldManFreeService.addOldManFree(po);
            return new AjaxResultPo(true, "添加减免单据成功");
        }catch (Exception e){
            logger.error("添加减免单据失败",e);
            return new AjaxResultPo(false, "添加减免单据失败");
        }
    }

    /**
     * @Method: updOldManFree
     * @Description: 更新减免单据
     * @Para: [OldManFreePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updOldManFree")
    public AjaxResultPo updOldManFree(OldManFreePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入OldManFreeController.updOldManFree()方法");
        try{
            UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
            po.setfNursinghomeID(user.getOldhouse());
            oldManFreeService.updOldManFree(po);
            return new AjaxResultPo(true, "更新减免单据成功");
        }catch (Exception e){
            logger.error("更新减免单据失败",e);
            return new AjaxResultPo(false, "更新减免单据失败");
        }
    }

    /**
     * @Method: delOldManFree
     * @Description: 删除减免单据
     * @Para: [OldManFreePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/delOldManFree")
    public AjaxResultPo delOldManFree(OldManFreePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入OldManFreeController.delOldManFree()方法");
        try{
            oldManFreeService.delOldManFree(po);
            return new AjaxResultPo(true, "删除减免单据成功");
        }catch (Exception e){
            logger.error("删除减免单据失败",e);
            return new AjaxResultPo(false, "删除减免单据失败");
        }
    }

}
