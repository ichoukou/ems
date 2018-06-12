package com.channelsoft.ems.controller;

import com.channelsoft.ems.common.ConstantsMap;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.TBuildingPo;
import com.channelsoft.ems.po.TFloorPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.TeFloorService;
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
@RequestMapping("/floor")
public class TeFloorController {

    private static Logger logger=Logger.getLogger(TeFloorController.class);

    @Autowired
    private TeFloorService teFloorService;

    @RequestMapping("/flList")
    public String gotoChargeStandardList(){
        logger.debug("楼层，已经跳转");
        return "tFloor/tFloorList";
    }

    /**
     * @Method: queryFloor
     * @Description: 分页查询楼层
     * @Para: [TFloorPo po, int page, int pageSize]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo queryFloor(TFloorPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入TeFloorController.query()方法，请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<TFloorPo> floorList= teFloorService.queryFloor(po,page,pageSize);
//        for(int i=0;i<floorList.size();i++){
//            String buildId=floorList.get(i).getfBuildingID();
//            TBuildingPo tbPo=ConstantsMap.buildingMap.get(buildId);
//            String buildName=tbPo.getfBuildingName();
//            floorList.get(i).setfBuildingName(buildName);
//        }
        return new AjaxResultPo(true,"success",floorList.size(),floorList);
    }

    /**
     * @Method: getFloor
     * @Description: 查询楼层
     * @Para: [TFloorPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/get")
    public AjaxResultPo getFloor(TFloorPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入TeFloorController.getFloor()方法,请求参数: "+ po.toString());
        List<TFloorPo> floorList= teFloorService.getFloor(po);
        return new AjaxResultPo(true,"success",floorList.size(),floorList);
    }

    /**
     * @Method: addFloor
     * @Description: 添加楼层
     * @Para: [TFloorPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/addFloor")
    public AjaxResultPo addFloor(TFloorPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeFloorController.addFloor（）方法");
        try{
            UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
            po.setfNursingHomeID(user.getOldhouse());
            teFloorService.addFloor(po);
//            ConstantsMap.queryFloor();
            return new AjaxResultPo(true,"楼层添加成功");
        }catch (Exception e){
            logger.error("楼层添加失败",e);
            return new AjaxResultPo(false,"楼层添加失败");
        }
    }

    /**
     * @Method: updFloor
     * @Description: 修改楼层
     * @Para: [TFloorPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updFloor")
    public AjaxResultPo updFloor(TFloorPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeFloorController.updFloor()方法");
        try{
            teFloorService.updFloor(po);
//            ConstantsMap.queryFloor();
            return new AjaxResultPo(true,"修改楼层成功");
        }catch (Exception e){
            logger.error("修改楼层失败",e);
            return new AjaxResultPo(false,"修改楼层失败");
        }
    }

    /**
     * @Method: updStateFloor
     * @Description: 修改楼层状态
     * @Para: [TFloorPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updStateFloor")
    public AjaxResultPo updStateFloor(TFloorPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeFloorController.updStateFloor()方法");
        try{
            teFloorService.updStateFloor(po);
//            ConstantsMap.queryFloor();
            return new AjaxResultPo(true,"修改楼层状态成功");
        }catch (Exception e){
            logger.error("修改楼层状态失败",e);
            return new AjaxResultPo(false,"修改楼层状态失败");
        }
    }

    /**
     * @Method: delFloor
     * @Description: 删除楼层
     * @Para: [TFloorPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/delFloor")
    public AjaxResultPo delFloor(TFloorPo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入TeFloorController.delFloor()方法");
        try{
            teFloorService.delFloor(po);
//            ConstantsMap.queryFloor();
            return new AjaxResultPo(true,"删除楼层成功");
        }catch (Exception e){
            logger.error("删除楼层失败",e);
            return new AjaxResultPo(false,"删除楼层失败");
        }
    }

}
