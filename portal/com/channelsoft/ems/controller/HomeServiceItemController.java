package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.HomeServiceItemPo;
import com.channelsoft.ems.po.HomeServiceTypePo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.HomeServiceItemService;
import org.apache.axis.utils.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxing on 2016/12/20.
 */
@Controller
@RequestMapping("/homeServiceItem")
public class HomeServiceItemController {

    private static Logger logger=Logger.getLogger(HomeServiceItemController.class);

    @Autowired
    private HomeServiceItemService homeServiceItemService;

    @RequestMapping("/hsList")
    public String gotoHomeServiceList(){
        logger.debug("hsList已经跳转");
        return "homeService/homeServiceList";
    }
    /**
     * @description: 获取居家服务项目名称列表
     * @param request
     * @param response
     * @return List<String>
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getHomeServiceItemNameList")
    public List<String>  getHomeServiceItemNameList(HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入  getHomeServiceItemNameList（）");
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        List<String> list = new ArrayList<String>();
        list = homeServiceItemService.getHomeServiceItemNameList(user.getOldhouse());
        System.out.print(list.toString());
        return list;
    }
    /**
     * @description: 获取居家服务项目类别列表
     * @param request
     * @param response
     * @return List<String>
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getHomeServiceItemTypeList")
    public List<String> getHomeServiceItemTypeList(HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入  getHomeServiceItemTypeList（）");
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        List<String> list = new ArrayList<String>();
        list = homeServiceItemService.getHomeServiceItemTypeList(user.getOldhouse());
        System.out.print(list.toString());
        return list;
    }
    /**
     * @description: 获取居家服务项目单位列表
     * @param request
     * @param response
     * @return List<String>
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getHomeServiceItemUnitList")
    public List<String> getHomeServiceItemUnitList(HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入  getHomeServiceItemUnitList（）");
        List<String> list = new ArrayList<String>();
        list = homeServiceItemService.getHomeServiceItemUnitList();
        logger.debug("获取数据："+list.toString());
        return list;
    }
    /**
     * @description: 获取居家服务项目列表
     * @param po
     * @param pageSize
     * @param page
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getHomeServiceItemList")
    public AjaxResultPo getHomeServiceItemList(HomeServiceItemPo po,int page,int pageSize,HttpServletResponse response, HttpServletRequest request) throws IOException{
//        po.setServiceTypeName(new String(po.getServiceTypeName().getBytes("ISO-8859-1"), "utf-8"));
//        po.setServiceItemName(new String(po.getServiceItemName().getBytes("ISO-8859-1"), "utf-8"));
//        po.setItemStatus(new String(po.getItemStatus().getBytes("ISO-8859-1"), "utf-8"));
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setNursing_homeID(user.getOldhouse());
        List<HomeServiceItemPo> itemList=new ArrayList<HomeServiceItemPo>();
        itemList = homeServiceItemService.getHomeServiceItemList(po,page,pageSize);
        int count= homeServiceItemService.getHomeServiceItemCount(po);
        for (HomeServiceItemPo item:itemList) {
            if(item.getItemStatus().equals("1")){
                item.setItemStatus("<span style='color:green'>已启用</span>");
            }
            else
            {
                item.setItemStatus("<span style='color:red'>已禁用</span>");
            }
        }
        return new AjaxResultPo(true,"success",count,itemList);
    }
    /**
     * @description: 居家服务项目更新
     * @param po
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/updateServiceItem")
    public AjaxResultPo updateHomeServiceItem(HomeServiceItemPo po,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   updateHomeServiceItem()......");
        logger.debug("请求参数: " + po.toString());
        logger.debug("需要更新字段" + po);
        try {
            if (this.homeServiceItemService.updateHomeServiceItem(po) == 0) {
                logger.debug("更新成功");

                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("进入更新方法,更新失败");
                request.getSession().setAttribute("dmsg", "更新失败");
                return new AjaxResultPo(false, "error");
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "更新异常");
            logger.debug("异常:" + e.getMessage());
            e.printStackTrace();
            return new AjaxResultPo(false, "error");
        }
    }
    /**
     * @description: 居家服务项目添加
     * @param po
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/addServiceItem")
    public AjaxResultPo addHomeServiceItem(HomeServiceItemPo po,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   addHomeServiceItem()......");
        logger.debug("请求参数: " + po.toString());
        logger.debug("需要添加字段" + po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setNursing_homeID(user.getOldhouse());
        try {
            if (this.homeServiceItemService.addHomeServiceItem(po) == 0) {

                logger.debug("添加成功");
                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("进入添加方法,添加失败");
                request.getSession().setAttribute("dmsg", "添加失败");
                return new AjaxResultPo(false, "error");
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "添加异常");
            logger.debug("异常:" + e.getMessage());
            e.printStackTrace();
            return new AjaxResultPo(false, "error");
        }
    }
    /**
     * @description: 居家服务项目类型添加
     * @param po
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/addServiceType")
    public AjaxResultPo addHomeServiceItemType(HomeServiceTypePo po, HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   addHomeServiceItemType()......");
        logger.debug("请求参数: " + po.toString());
        logger.debug("判断名称是否重复" + po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setNursing_homeID(user.getOldhouse());
        int result=homeServiceItemService.checkHomeServiceType(po.getServiceTypeName(),po.getNursing_homeID());
        if(result==1){
            logger.debug("名称重复" + po);
            return new AjaxResultPo(false, "error");
        }
        else{
            logger.debug("名称不重复" + po);
            logger.debug("需要添加字段" + po);
            try {
                if (this.homeServiceItemService.addHomeServiceType(po) == 0) {
                    logger.debug("添加成功");
                    return new AjaxResultPo(true, "success");
                } else {
                    logger.debug("进入添加方法,添加失败");
                    request.getSession().setAttribute("dmsg", "添加失败");
                    return new AjaxResultPo(false, "error");
                }
            } catch (Exception e) {
                // TODO: handle exception
                request.getSession().setAttribute("dmsg", "添加异常");
                logger.debug("异常:" + e.getMessage());
                e.printStackTrace();
                return new AjaxResultPo(false, "error");
            }
        }
    }
}
