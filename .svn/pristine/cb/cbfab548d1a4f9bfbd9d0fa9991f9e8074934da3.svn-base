package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.HomeServiceItemPo;
import com.channelsoft.ems.po.StorageGoodsManagementPo;
import com.channelsoft.ems.po.StorageGoodsSortingPo;
import com.channelsoft.ems.service.StorageGoodsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxing on 2016/12/23.
 */
@Controller
@RequestMapping("/storageGoods")
public class StorageGoodsController {

    private static Logger logger=Logger.getLogger(StorageGoodsController.class);
    private static List<StorageGoodsSortingPo> poList=new ArrayList<StorageGoodsSortingPo>();
    private static String poType;


    @Autowired
    private StorageGoodsService storageGoodsService;

    @RequestMapping("/sgsList")
    public String gotoStorageGoodsSortingList(HttpServletResponse response, HttpServletRequest request){
        logger.debug("sgsList已经跳转");
        return "storageGoods/storageGoodsSortingList";
    }

    @RequestMapping("/sgmList")
    public String gotoStorageGoodsManagementList(HttpServletResponse response, HttpServletRequest request){
        logger.debug("sgmList已经跳转");
        return "storageGoods/storageGoodsManagementList";
    }

    /**
     * @description: 获取未禁用物品分类类别列表
     * @param id
     * @param request
     * @param response
     * @return List<StorageGoodsSortingPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getStorageGoodsSortingTypeList")
    public List<StorageGoodsSortingPo> getStorageGoodsSortingTypeList(String id,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   getStorageGoodsSortingTypeList  方法");
        logger.debug("请求参数：类型ID：" +id);
        List<StorageGoodsSortingPo> list= new ArrayList<StorageGoodsSortingPo>();
        list = storageGoodsService.getStorageGoodsSortingTypeList(id);
        poList.clear();
        listFormate(list,"0",0);
        return poList;
    }
    /**
     * @description: 物品管理页面获取全部的物品分类类别列表
     * @param id
     * @param request
     * @param response
     * @return List<StorageGoodsSortingPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getStorageGoodsSortingTypeList2")
    public List<StorageGoodsSortingPo> getStorageGoodsSortingTypeList2(String id,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   getStorageGoodsSortingTypeList2  方法");
        logger.debug("请求参数：类型ID：" +id);
        List<StorageGoodsSortingPo> list= new ArrayList<StorageGoodsSortingPo>();
        list = storageGoodsService.getStorageGoodsSortingTypeList2(id);
        poList.clear();
        listFormate(list,"0",0);
        return poList;
    }
    /**
     * @description: 获取物品分类页面的全部类别列表
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getStorageGoodsSortingList")
    public AjaxResultPo getStorageGoodsSortingList(HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   getStorageGoodsSortingList  方法");
        List<StorageGoodsSortingPo> list= new ArrayList<StorageGoodsSortingPo>();
        list = storageGoodsService.getStorageGoodsSortingList();
        for (StorageGoodsSortingPo po:list) {
            po.setLevel(1);
        }
        return new AjaxResultPo(true,"success",list.size(),list);
    }
    /**
     * @description: 条件查询物品管理页面获取物品列表（分页）
     * @param po
     * @param page
     * @param pageSize
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getStorageGoodsManagementList")
    public AjaxResultPo getStorageGoodsManagementList(StorageGoodsManagementPo po, int page, int pageSize, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        logger.debug("进入 getStorageGoodsManagementList()方法 ");
        if(!po.getType().equals(""))
        {
            List<StorageGoodsSortingPo> listFirst= new ArrayList<StorageGoodsSortingPo>();
            listFirst = storageGoodsService.getStorageGoodsSortingTypeList("");
            poType="(0";
            getType(listFirst,po.getType());
            poType=poType+")";
            po.setType(poType);
        }
//        po.setName(new String(po.getName().getBytes("ISO-8859-1"), "utf-8"));
        logger.debug("请求参数：po"+po.toString()+"page:"+page+"pageSize:"+pageSize);
        List<StorageGoodsManagementPo> list=new ArrayList<StorageGoodsManagementPo>();
        list = storageGoodsService.getStorageGoodsManagementList(po,page,pageSize);
        int count= storageGoodsService.getStorageGoodsManagementCount(po);
        return new AjaxResultPo(true,"success",count,list);
    }

    /**
     * @description: 获得物品分类子分类
     * @param id
     * @param level
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getStorageGoodsSortingSonList")
    public List<StorageGoodsSortingPo> getStorageGoodsSortingSonList(String id,int level,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   getStorageGoodsSortingSonList  方法");
        logger.debug("请求参数：父级ID：" +id+"父类级别："+level);
        List<StorageGoodsSortingPo> list= new ArrayList<StorageGoodsSortingPo>();
        list = storageGoodsService.getStorageGoodsSortingSonList(id);
        for (StorageGoodsSortingPo po:list) {
            po.setLevel(level+1);
        }
        return list;
    }
    /**
     * @description: 更新时的物品分类列表
     * @param po
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/updateStorageGoodsSortingType")
    public AjaxResultPo updateStorageGoodsSortingType(StorageGoodsSortingPo po,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   updateStorageGoodsSortingType()......");
        logger.debug("请求参数: " + po.toString());
        logger.debug("需要更新字段" + po);
        try {
            if (this.storageGoodsService.updateStorageGoods(po) == 0) {
                logger.debug("更新成功");

                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("进入更新方法,更新失败");
                request.getSession().setAttribute("dmsg", "更新失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "更新异常");
            logger.debug("异常:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @description: 物品管理的物品更新操作
     * @param po
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/updateStorageGoodsManagement")
    public AjaxResultPo updateStorageGoodsManagement(StorageGoodsManagementPo po,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   updateStorageGoodsManagement()......");
        logger.debug("请求参数: " + po.toString());
        try {
            if (this.storageGoodsService.updateStorageGoodsManagement(po) == 0) {
                logger.debug("更新成功");

                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("进入更新方法,更新失败");
                request.getSession().setAttribute("dmsg", "更新失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "更新异常");
            logger.debug("异常:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @description: 物品分类的添加操作
     * @param po
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/addStorageGoodsSortingType")
    public AjaxResultPo addStorageGoodsSortingType(StorageGoodsSortingPo po,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   addStorageGoodsSortingType()......");
        logger.debug("请求参数: " + po.toString());
        try {
            if (this.storageGoodsService.addStorageGoods(po) == 0) {
                logger.debug("添加成功");

                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("进入添加方法,添加失败");
                request.getSession().setAttribute("dmsg", "添加失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "添加异常");
            logger.debug("异常:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @description: 物品添加操作
     * @param po
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/addStorageGoodsManagement")
    public AjaxResultPo addStorageGoodsManagement(StorageGoodsManagementPo po,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   addStorageGoodsManagement()......");
        logger.debug("请求参数: " + po.toString());
        try {
            if (this.storageGoodsService.addStorageGoodsManagement(po) == 0) {
                logger.debug("添加成功");

                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("进入添加方法,添加失败");
                request.getSession().setAttribute("dmsg", "添加失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "添加异常");
            logger.debug("异常:" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    /**
     * @description: 物品分类 的禁用
     * @param id
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/forbiddenStorageGoodsSortingType")
    public AjaxResultPo forbiddenStorageGoodsSortingType(String  id,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   forbiddenStorageGoodsSortingType()......");
        logger.debug("请求参数: 要禁用的类型ID:" + id);
        int count =storageGoodsService.searchStorageGoodsSonCount(id);
        if(count == 0)
        {
            try {
                logger.debug("进行禁用");
                if (this.storageGoodsService.forbiddenStorageGoodsType(id) == 0) {
                    logger.debug("禁用成功");
                    return new AjaxResultPo(true, "success");
                } else {
                    logger.debug("进入禁用方法,禁用失败");
                    request.getSession().setAttribute("dmsg", "禁用失败");
                    return null;
                }
            } catch (Exception e) {
                // TODO: handle exception
                request.getSession().setAttribute("dmsg", "禁用异常");
                logger.debug("异常:" + e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
        else {
            return new AjaxResultPo(false,"error");
        }
    }
    /**
     * @description: 物品的禁用
     * @param id
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/forbiddenStorageGoodsManagement")
    public AjaxResultPo forbiddenStorageGoodsManagement(String  id,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   forbiddenStorageGoodsManagement()......");
        logger.debug("请求参数: 要禁用的类型ID:" + id);
            try {
                logger.debug("进行禁用");
                if (this.storageGoodsService.forbiddenStorageGoodsManagement(id) == 0) {
                    logger.debug("禁用成功");
                    return new AjaxResultPo(true, "success");
                } else {
                    logger.debug("进入禁用方法,禁用失败");
                    request.getSession().setAttribute("dmsg", "禁用失败");
                    return new AjaxResultPo(false, "error");
                }
            } catch (Exception e) {
                // TODO: handle exception
                request.getSession().setAttribute("dmsg", "禁用异常");
                logger.debug("异常:" + e.getMessage());
                e.printStackTrace();
                return new AjaxResultPo(false, "error");
            }
        }
    /**
     * @description: 物品的启用
     * @param id
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/startStorageGoodsManagement")
    public AjaxResultPo startStorageGoodsManagement(String  id,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   startStorageGoodsManagement()......");
        logger.debug("请求参数: 要起用的类型ID:" + id);
        try {
            logger.debug("进行启用");
            if (this.storageGoodsService.startStorageGoodsManagement(id) == 0) {
                logger.debug("启用成功");
                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("进入启用方法,启用失败");
                request.getSession().setAttribute("dmsg", "启用失败");
                return new AjaxResultPo(false, "error");
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "启用异常");
            logger.debug("异常:" + e.getMessage());
            e.printStackTrace();
            return new AjaxResultPo(false, "error");
        }
    }
    /**
     * @description: 物品分类排序
     * @author liuxing
     * @date 2017年3月10日
     */
    public static void listFormate(List<StorageGoodsSortingPo> list,String id,int level){
        boolean yezi=true;
        int length=poList.size();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getFatherID().equals(id))
            {
                yezi=false;
                StringBuffer str =new StringBuffer();
                for(int j=0;j<level;j++)
                {
                    if(j==(level-1))
                    {
                        str.append("&nbsp;&nbsp;&nbsp;&nbsp;"+"▶");
                    }
                    else{
                        str.append("&nbsp;&nbsp;&nbsp;&nbsp;");
                    }
                }
                list.get(i).setTypeName(str+list.get(i).getTypeName());
                list.get(i).setRemark("0");
                poList.add(list.get(i));
                listFormate(list,list.get(i).getId(),level+1);
            }
        }
        if(!yezi && !id.equals("0")){
            poList.get(length-1).setRemark("1");
        }
    }
    public static void getType(List<StorageGoodsSortingPo> list,String type){
        poType=poType+","+type;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getFatherID().equals(type))
            {
                getType(list,list.get(i).getId());
            }
        }
    }
}
