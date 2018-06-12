package com.channelsoft.ems.controller;

import com.channelsoft.ems.common.ConstantsMap;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.TBedPo;
import com.channelsoft.ems.service.TeBedService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wangjs on 2016/12/12.
 */
@Controller
@RequestMapping("/bed")
public class TeBedController {

    private static Logger logger=Logger.getLogger(TeRoomController.class);

    @Autowired
    private TeBedService teBedService;

    /**
     * @Method: queryBed
     * @Description: 分页查询床位
     * @Para: [TBedPo po, int page, int pageSize]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/queryBed")
    public AjaxResultPo queryBed(TBedPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入TeBedController.queryBed()方法,请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<TBedPo> chargeList= teBedService.queryBed(po,page,pageSize);
        int dataCount= teBedService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,chargeList);
    }

    /**
     * @Method: queryBedByRoom
     * @Description: 查询床位
     * @Para: [TBedPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/queryBedByRoom")
    public AjaxResultPo queryBedByRoom(TBedPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入TeBedController.queryBedByRoom()方法,请求参数: "+ po.toString());
        List<TBedPo> bedList= teBedService.queryBedByRoom(po);
        return new AjaxResultPo(true,"success",bedList.size(),bedList);
    }

    /**
     * @Method: getBed
     * @Description: 查询床位
     * @Para: [TBedPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/get")
    public AjaxResultPo getBed(TBedPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入TeBedController.getBed()方法,请求参数: "+ po.toString());
        List<TBedPo> chargeList= teBedService.getBed(po);
        return new AjaxResultPo(true,"success",chargeList.size(),chargeList);
    }

    /**
     * @Method: addBed
     * @Description: 添加床位
     * @Para: [TBedPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/addBed")
    public AjaxResultPo addBed(TBedPo po, int page, int pageSize,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeBedController.addBed()方法");
        try{
            teBedService.addBed(po);
            ConstantsMap.queryBed();
            List<TBedPo> chargeList= teBedService.queryBed(po,page,pageSize);
            return new AjaxResultPo(true,"床位添加成功",chargeList.size(),chargeList);
        }catch (Exception e){
            logger.error("床位添加失败",e);
            return new AjaxResultPo(false,"床位添加失败");
        }
    }

    /**
     * @Method: updBedState
     * @Description: 修改床位状态
     * @Para: [TBedPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updBedState")
    public AjaxResultPo updBedState(TBedPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeBedController.updChargeStandard()方法");
        try{
            teBedService.updBedState(po);
            ConstantsMap.queryBed();
            return new AjaxResultPo(true,"修改床位状态成功");
        }catch (Exception e){
            logger.error("修改床位状态失败",e);
            return new AjaxResultPo(false,"修改床位状态失败");
        }
    }

    /**
     * @Method: updBedStateByRoom
     * @Description: 修改床位状态
     * @Para: [TBedPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updBedStateByRoom")
    public AjaxResultPo updBedStateByRoom(TBedPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeBedController.updBedStateByRoom()方法");
        try{
            teBedService.updBedStateByRoom(po);
            ConstantsMap.queryBed();
            return new AjaxResultPo(true,"修改床位状态成功");
        }catch (Exception e){
            logger.error("修改床位状态失败",e);
            return new AjaxResultPo(false,"修改床位状态失败");
        }
    }

    /**
     * @Method: updBed
     * @Description: 修改床位
     * @Para: [TBedPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updBed")
    public AjaxResultPo updBed(TBedPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeBedController.updBed()方法");
        try{
            teBedService.updBed(po);
            ConstantsMap.queryBed();
            return new AjaxResultPo(true,"修改床位成功");
        }catch (Exception e){
            logger.error("删除房间是失败",e);
            return new AjaxResultPo(false,"修改床位失败");
        }
    }

    /**
     * @Method: delBed
     * @Description: 删除床位
     * @Para: [TBedPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/delBed")
    public AjaxResultPo delBed(TBedPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeBedController.delBed()方法");
        try{
            teBedService.delBed(po);
            ConstantsMap.queryBed();
            return new AjaxResultPo(true,"删除床位成功");
        }catch (Exception e){
            logger.error("删除床位失败",e);
            return new AjaxResultPo(false,"删除床位失败");
        }
    }
}
