package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.*;
import com.channelsoft.ems.service.StorageGoodsService;
import com.channelsoft.ems.service.StorageOutDetailedService;
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
import java.util.Date;
import java.util.List;

/**
 * Created by liuxing on 2016/12/27.
 */
@Controller
@RequestMapping("/StorageOut")
public class StorageOutController {
    private static Logger logger=Logger.getLogger(StorageOutController.class);
    private static String poType;
    @Autowired
    private StorageOutDetailedService storageOutDetailedService;
    @Autowired
    private StorageGoodsService storageGoodsService;

    @RequestMapping("/soList")
    public String gotoStorageOutList(HttpServletRequest request, HttpServletResponse response){
        return "storageOut/storageOutList";
    }
    /**
     * @description: 获得库存物品名称列表
     * @param  response
     * @param  request
     * @return List<StorageOutDetailedEntryPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getStorageMaterialNameList")
    public List<StorageOutDetailedEntryPo> getStorageMaterialNameList(HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   getStorageMaterialNameList  方法");
        List<StorageOutDetailedEntryPo> list= new ArrayList<StorageOutDetailedEntryPo>();
        list = storageOutDetailedService.getStorageOutDetialedMaterialList();
        return list;
    }
    /**
     * @description: 获取物品规格列表
     * @param  response
     * @param  request
     * @return List<String>
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getStorageStandardList")
    public List<String> getStorageStandardList(HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   getStorageStandardList  方法");
        List<String> list= new ArrayList<String>();
        list = storageOutDetailedService.getStorageOutStandardList();
        return list;
    }

    /**
     * @description: 获取仓库列表
     * @param  response
     * @param  request
     * @return List<StorageOutDetailedEntryPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getStorageOutStoreHouseList")
    public List<StorageOutDetailedEntryPo> getStorageOutStoreHouseList(HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   getStorageOutStoreHouseList  方法");
        List<StorageOutDetailedEntryPo> list= new ArrayList<StorageOutDetailedEntryPo>();
        list = storageOutDetailedService.getStorageOutStoreHouseList();
        return list;
    }


    /**
     * @description: 获取经办人列表
     * @param  response
     * @param  request
     * @return List<StorageOutDetailedEntryPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getStroageOutOperatorList")
    public List<StorageOutDetailedEntryPo> getStroageOutOperatorList(HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   getStorageOutStoreHouseList  方法");
        List<StorageOutDetailedEntryPo> list= new ArrayList<StorageOutDetailedEntryPo>();
        list = storageOutDetailedService.getOutOperatorList();
        return list;
    }
    /**
     * @description: 条件查询出库单信息(分页)
     * @param po
     * @param page
     * @param pageSize
     * @param response
     * @param request
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/queryStorageOutDetailedList")
    public AjaxResultPo queryStorageOutDetailedList(StorageOutDetailedEntryPo po, int page, int pageSize, HttpServletResponse response, HttpServletRequest request)  {
        logger.debug("进入   queryStorageOutDetailedList  方法");
//        po.setFnumber(new String(po.getFnumber().getBytes("ISO-8859-1"), "utf-8"));
//        po.setMaterialID(new String(po.getMaterialID().getBytes("ISO-8859-1"), "utf-8"));
//        po.setStandard(new String(po.getStandard().getBytes("ISO-8859-1"), "utf-8"));
//        po.setStorageID(new String(po.getStorageID().getBytes("ISO-8859-1"), "utf-8"));
        logger.debug("请求参数：po"+po.toString()+"page:"+page+"pageSize:" + pageSize);
        List<StorageOutDetailedEntryPo> list= new ArrayList<StorageOutDetailedEntryPo>();
        int count = storageOutDetailedService.queryStorageOutDetailedCount(po);
        list = storageOutDetailedService.queryStorageOutDetailedList(po,page,pageSize);
        return new AjaxResultPo(true,"success",count,list);
    }
    /**
     * @description: 条件查询仓库中可出库物品信息(分页)
     * @param po
     * @param page
     * @param pageSize
     * @param response
     * @param request
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/queryOutMaterial")
    public AjaxResultPo queryOutMaterial(StockMaterialPo po, int page, int pageSize, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        logger.debug("进入   queryOutMaterial  方法");
//        po.setMaterial(new String(po.getMaterial().getBytes("ISO-8859-1"), "utf-8"));
        if(!po.getMaterialTypeID().equals(""))
        {
            List<StorageGoodsSortingPo> listFirst= new ArrayList<StorageGoodsSortingPo>();
            listFirst = storageGoodsService.getStorageGoodsSortingTypeList("");
            poType="(0";
            getType(listFirst,po.getMaterialTypeID());
            poType=poType+")";
            po.setMaterialTypeID(poType);
        }
        logger.debug("请求参数：po"+po.toString()+"page:"+page+"pageSize:" + pageSize);
        List<StockMaterialPo> list= new ArrayList<StockMaterialPo>();
        int count = storageOutDetailedService.queryOutMaterialCount(po);
        list = storageOutDetailedService.queryOutMaterial(po,page,pageSize);
        return new AjaxResultPo(true,"success",count,list);
    }
    //获取类别所有子类别
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
    /**
     * @description: 保存出库单操作
     * @param outStorageSql
     * @param outStorageEntrySql
     * @param stockAccountSql
     * @param response
     * @param request
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/addOutDetailed")
    public AjaxResultPo addOutDetailed(String outStorageSql,String outStorageEntrySql,String  stockAccountSql, HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   addOutDetailed  方法");
        logger.debug("请求参数：outStorageSql"+outStorageSql+"outStorageEntrySql:"+outStorageEntrySql+"stockAccountSql:" + stockAccountSql);
        String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        UserPo user= (UserPo) request.getSession().getAttribute("loginUser");
        String[] str=outStorageSql.split("=");
        StorageOutDetailedEntryPo po=new StorageOutDetailedEntryPo();
        po.setFnumber(str[0]);
        po.setOutDate(str[1]);
        po.setOperatorID(str[2]);
        if(str.length==3)
        {
            po.setExplain("");
        }
        else {
            po.setExplain(str[3]);
        }
        po.setNursingHomeID(user.getOldhouse());
        po.setCreatorID(user.getEmployId());
        po.setCreatDate(date);


        List<StorageOutDetailedEntryPo> entrylist =new ArrayList<StorageOutDetailedEntryPo>();
        String[] strlist=outStorageEntrySql.split("_");
        StorageOutDetailedEntryPo po2;
        for(int i=1;i<strlist.length;i++){
            po2=new StorageOutDetailedEntryPo();
            str=strlist[i].split("=");
            po2.setStorageID(str[0]);
            po2.setStorageManID(str[1]);
            po2.setMaterialID(str[2]);
            po2.setStandard(str[3]);
            po2.setQty(str[4]);
            System.out.println(str.length);
            if(str.length==5)
            {
                po2.setRemark("");
            }
            else{
                po2.setRemark(str[5]);
            }
            entrylist.add(po2);
        }
        List<StockMaterialPo> stocklist =new ArrayList<StockMaterialPo>();
        strlist=stockAccountSql.split("_");
        StockMaterialPo po3;
        for(int i=1;i<strlist.length;i++){
            po3=new StockMaterialPo();
            str=strlist[i].split("=");
            po3.setId(str[0]);
            po3.setStockCount(str[1]);
            stocklist.add(po3);
        }
        try {
            logger.debug("进行添加");
            if (storageOutDetailedService.creatStockAccount(po,entrylist,stocklist) == 0) {
                logger.debug("添加成功");
                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("添加失败");
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
     * @description: 加载物品名称列表
     * @param outNumber
     * @param response
     * @param request
     * @return List<StorageOutDetailedEntryPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/loadMaterialNameList")
    public List<StorageOutDetailedEntryPo> loadMaterialNameList(String outNumber,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   loadMaterialNameList  方法");
        logger.debug("请求参数：outNumber："+outNumber);
        List<StorageOutDetailedEntryPo> list= new ArrayList<StorageOutDetailedEntryPo>();
        list = storageOutDetailedService.loadMaterialNameList(outNumber);
        return list;
    }
    /**
     * @descriptidon: 更新出库单操作
     * @param delectQtyList
     * @param delectFidList
     * @param outStorageSql
     * @param outStorageEntrySql
     * @param stockAccountSql
     * @param response
     * @param request
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/updateOutDetailed")
    public AjaxResultPo updateOutDetailed(String delectQtyList,String delectFidList,String outStorageSql,String outStorageEntrySql,String  stockAccountSql, HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   updateOutDetailed  方法");
        logger.debug("请求参数：delectQtyList:"+delectQtyList+"delectFidList:"+delectFidList+"outStorageSql"+outStorageSql+"outStorageEntrySql:"+outStorageEntrySql+"stockAccountSql:" + stockAccountSql);
        String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        UserPo user= (UserPo) request.getSession().getAttribute("loginUser");
        String[] str=outStorageSql.split("=");
        StorageOutDetailedEntryPo po=new StorageOutDetailedEntryPo();
        po.setFnumber(str[0]);
        po.setOutDate(str[1]);
        po.setOperatorID(str[2]);
        if(str.length==3)
        {
            po.setExplain("");
        }
        else {
            po.setExplain(str[3]);
        }
        po.setNursingHomeID(user.getOldhouse());
        po.setModifierID(user.getEmployId());
        po.setModificationTime(date);


        List<StorageOutDetailedEntryPo> entrylist =new ArrayList<StorageOutDetailedEntryPo>();
        String[] strlist=outStorageEntrySql.split("_");
        StorageOutDetailedEntryPo po2;
        for(int i=1;i<strlist.length;i++){
            po2=new StorageOutDetailedEntryPo();
            str=strlist[i].split("=");
            po2.setFpid(str[0]);
            po2.setStorageID(str[1]);
            po2.setStorageManID(str[2]);
            po2.setMaterialID(str[3]);
            po2.setStandard(str[4]);
            po2.setQty(str[5]);
            if(str.length==6)
            {
                po2.setRemark("");
            }
            else{
                po2.setRemark(str[6]);
            }
            entrylist.add(po2);

        }

        List<StockMaterialPo> stocklist =new ArrayList<StockMaterialPo>();
        strlist=stockAccountSql.split("_");
        StockMaterialPo po3;
        for(int i=1;i<strlist.length;i++){
            po3=new StockMaterialPo();
            str=strlist[i].split("=");
            po3.setId(str[0]);
            po3.setStockCount(str[1]);
            stocklist.add(po3);
        }

        String  delectFid="(0";
        str=delectFidList.split("=");
        for(int i=1;i<str.length;i++){
            delectFid=delectFid+","+str[i];
        }
        delectFid=delectFid+")";

        List<StorageOutDetailedEntryPo> deleteEntryList =new ArrayList<StorageOutDetailedEntryPo>();
        strlist=delectQtyList.split("_");
        StorageOutDetailedEntryPo po4;
        for(int i=1;i<strlist.length;i++){
            po4=new StorageOutDetailedEntryPo();
            str=strlist[i].split("=");
            po4.setStorageID(str[0]);
            po4.setMaterialID(str[1]);
            po4.setQty(str[2]);
            deleteEntryList.add(po4);
        }
        try {
            logger.debug("进行修改");
            if (storageOutDetailedService.updateStockAccount(po,entrylist,stocklist,delectFid,deleteEntryList) == 0) {
                logger.debug("修改成功");
                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("修改失败");
                request.getSession().setAttribute("dmsg", "修改失败");
                return new AjaxResultPo(false, "error");
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "修改异常");
            logger.debug("异常:" + e.getMessage());
            e.printStackTrace();
            return new AjaxResultPo(false, "error");
        }
    }
    /**
     * @description: 删除出库单
     * @param fnumber
     * @param response
     * @param request
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/deleteOutDetailed")
    public AjaxResultPo deleteOutDetailed(String fnumber, HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   updateOutDetailed  方法");
        logger.debug("请求参数：fnumber:"+fnumber);
        try {
            logger.debug("进行删除");
            if (storageOutDetailedService.deleteOutDetail(fnumber) == 0) {
                logger.debug("删除成功");
                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("删除失败");
                request.getSession().setAttribute("dmsg", "删除失败");
                return new AjaxResultPo(false, "error");
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "删除异常");
            logger.debug("异常:" + e.getMessage());
            e.printStackTrace();
            return new AjaxResultPo(false, "error");
        }
    }
}
