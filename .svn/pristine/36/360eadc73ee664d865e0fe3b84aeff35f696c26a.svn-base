package com.channelsoft.ems.controller;

import com.channelsoft.ems.common.Constants;
import com.channelsoft.ems.common.ConstantsMap;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.TBuildingPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.TeBuildingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by wangjs on 2016/12/4.
 */
@Controller
@RequestMapping("/building")
public class TeBuildingController {

    private static Logger logger=Logger.getLogger(TeBuildingController.class);

    @Autowired
    private TeBuildingService teBuildingService;

    @RequestMapping("/buList")
    public String gotoChargeStandardList(){
        logger.debug("大厦，已经跳转");
        return "tBuilding/tBuildingList";
    }

    /**
     * @Method: queryBuilding
     * @Description: 分页查询大厦
     * @Para: [TBuildingPo,page,pageSize]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo queryBuilding(TBuildingPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response)
    throws UnsupportedEncodingException{
        logger.debug("进入TeBuildingController.query()方法，请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
//        po.setfBuildingName(new String(po.getfBuildingName().getBytes("ISO-8859-1"),"utf-8"));
        List<TBuildingPo> chargeList= teBuildingService.queryBuilding(po,page,pageSize);
        logger.debug("进入TeBuildingController.queryCount（）方法");
        int dataCount= teBuildingService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,chargeList);
    }

    /**
     * @Method: getBuilding
     * @Description: 查询大厦
     * @Para: [TBuildingPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/get")
    public AjaxResultPo getBuilding(TBuildingPo po,HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入TeBuildingController.getBuilding()方法: "+ po.toString());
        List<TBuildingPo> buildList= teBuildingService.getBuilding(po);
        return new AjaxResultPo(true,"success",buildList.size(),buildList);
    }

    /**
     * @Method: addBuilding
     * @Description: 添加大厦
     * @Para: [TBuildingPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/addBuilding")
    public AjaxResultPo addBuilding(TBuildingPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeBuildingController.addChargeStandard（）方法");
        try{
            UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
            po.setfNursingHomeID(user.getOldhouse());
            teBuildingService.addBuilding(po);
//            ConstantsMap.queryBuilding();
            return new AjaxResultPo(true,"添加大厦成功");
        }catch (Exception e){
            logger.error("修改大厦失败",e);
            return new AjaxResultPo(false,"添加大厦失败");
        }
    }

    /**
     * @Method: updBuilding
     * @Description: 修改大厦
     * @Para: [TBuildingPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updBuilding")
    public AjaxResultPo updBuilding(TBuildingPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeBuildingController.updChargeStandard()方法");
        try{
            teBuildingService.updBuilding(po);
//            ConstantsMap.queryBuilding();
            return new AjaxResultPo(true,"修改大厦成功");
        }catch (Exception e){
            logger.error("修改大厦失败",e);
            return new AjaxResultPo(false,"修改大厦失败");
        }
    }

    /**
     * @Method: deleteBuilding
     * @Description: 删除大厦
     * @Para: [TBuildingPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/delBuilding")
    public AjaxResultPo deleteBuilding(TBuildingPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeBuildingController.deleteBuilding()方法");
        try{
            teBuildingService.delBuilding(po);
//            ConstantsMap.queryBuilding();
            return new AjaxResultPo(true,"删除大厦成功");
        }catch (Exception e){
            logger.error("删除大厦失败",e);
            return new AjaxResultPo(false,"删除大厦失败");
        }
    }

}
