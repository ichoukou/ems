package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.*;
import com.channelsoft.ems.service.ResEnterWarehouseService;
import com.channelsoft.ems.service.StorageGoodsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by 张鑫 on 2016/12/26.
 */
@Controller
@RequestMapping("/wareHouse")
public class ResEnterWareHouseController {

    private static Logger logger = Logger.getLogger(ResEnterWareHouseController.class);

    private static String poType;

    @Autowired
    private ResEnterWarehouseService warehouseService;

    @Autowired
    private StorageGoodsService storageGoodsService;

    @RequestMapping("/resEnterWareHouse")
    public String gotoEmpRewards(HttpServletRequest request, HttpServletResponse response) {
        return "resEnterWareHouse/resEnterWareHouseList";
    }

    /**
     *@Description:入库主表的显示
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/queryMainList")
    public AjaxResultPo queryMainList(WarehouseEntryPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("WarehouseEntryPo--请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<WarehouseEntryPo> houseList=this.warehouseService.queryMainList(po,page,pageSize);
        logger.debug("queryMainList（）方法");
        int dataCount=this.warehouseService.queryMainCount(po);
        return new AjaxResultPo(true,"success",dataCount,houseList);
    }

    /**
     *@Description:物资表的查询
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo gotoMaterialList(MaterialManagePo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("MaterialManagePo--请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        if(!po.getfCategoryID().equals(""))
        {
            List<StorageGoodsSortingPo> listFirst= new ArrayList<StorageGoodsSortingPo>();
            listFirst = storageGoodsService.getStorageGoodsSortingTypeList("");
            poType="(0";
            getType(listFirst,po.getfCategoryID());
            poType=poType+")";
            po.setfCategoryID(poType);
        }
        List<MaterialManagePo> houseList=this.warehouseService.queryList(po,page,pageSize);
        logger.debug("gotoWarehouseList（）方法");
        int dataCount=warehouseService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,houseList);
    }
    @ResponseBody
    @RequestMapping("/queryMaterial")
    public AjaxResultPo queryMaterial(MaterialManagePo po, int page, int pageSize, HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   queryMaterial  方法");
        if(!po.getfCategoryID().equals(""))
        {
            List<StorageGoodsSortingPo> listFirst= new ArrayList<StorageGoodsSortingPo>();
            listFirst = storageGoodsService.getStorageGoodsSortingTypeList("");
            poType="(0";
            getType(listFirst,po.getfCategoryID());
            poType=poType+")";
            po.setfCategoryID(poType);
        }
        logger.debug("请求参数：po"+po.toString()+"page:"+page+"pageSize:" + pageSize);
        List<MaterialManagePo> houseList=this.warehouseService.queryList(po,page,pageSize);
        logger.debug("gotoWarehouseList（）方法");
        int dataCount=warehouseService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,houseList);
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

    /**
     *@Description:新增入库信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/addInStorage")
    public AjaxResultPo addOrder(WarehouseEntryPo po, String inStorageEntrySql, String stockAccountSql, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入addOrder()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("主表参数"+po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setfNursingHomeID(user.getOldhouse());
        po.setfCreatorID(user.getEmployId());

        String[] str;

        //仓库id  数量  备注  物料id  保管员id  供应商id,单价price,金额fSum
        List<WarehouseEntryPo> list =new ArrayList<WarehouseEntryPo>();
        String[] strlist=inStorageEntrySql.split("_");
        WarehouseEntryPo po2;
        for(int i=1;i<strlist.length;i++){
            po2=new WarehouseEntryPo();
            str=strlist[i].split("=");
            po2.setfStorageID(str[0]);
            po2.setfAmount(str[1]);
            po2.setfRemarks(str[2]);
            po2.setfMaterialID(str[3]);
            po2.setfStoremanID(str[4]);
            po2.setfSupplierID(str[5]);
            po2.setfPrice(str[6]);
            po2.setfSum(str[7]);
            po2.setfPurchaseManID(user.getEmployId());
            list.add(po2);
        }

        //仓库id  物料id 数量 规格
        List<WarehouseEntryPo> list1 =new ArrayList<WarehouseEntryPo>();
        String[] strlist1=stockAccountSql.split("_");
        WarehouseEntryPo po3;
        for(int i=1;i<strlist.length;i++){
            po3=new WarehouseEntryPo();
            str=strlist1[i].split("=");
            po3.setfStorageID(str[0]);
            po3.setfMaterialID(str[1]);
            po3.setfAmount(str[2]);
            po3.setfStandard(str[3]);
            po3.setfNursingHomeID(user.getOldhouse());
            po3.setfNumber(po.getfNumber());
            list1.add(po3);
        }
        try {
            if(this.warehouseService.creatStockAccount(po,list,list1)==0){
                logger.debug("增加成功");
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入增加方法,增加失败");
                request.getSession().setAttribute("dmsg", "增加失败");
                return new AjaxResultPo(false, "error");
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "增加异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return new AjaxResultPo(false, "error");
        }


    }

    /**
     *@Description:更新所有物资
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/getUpdateAllMaterial")
    public AjaxResultPo getUpdateAllMaterial(WarehouseEntryPo po,HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入获得仓库信息......");

        List<Map<String,String>> list=this.warehouseService.getUpdateAllMaterial(po);

        return new AjaxResultPo(true, "success", list.size(), list);
    }

    /**
     *@Description:更新入库信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/updateInStorage")
    public AjaxResultPo updateOrder(WarehouseEntryPo po, String inStorageEntrySql,String inStorageEntrySqlDelect,String stockAccountSql,String stockAccountSqlDelect,HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入updateOrder()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("主表参数"+po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setfNursingHomeID(user.getOldhouse());
        po.setfCreatorID(user.getEmployId());
        po.setfPurchaseManID(user.getEmployId());

        String[] str;
        String arr1[]=request.getParameterValues("arr1");
        String []arr=arr1[0].split(",");
        String[] arr2=null;
        if(!inStorageEntrySqlDelect.equals("")){
            arr2=inStorageEntrySqlDelect.substring(1,inStorageEntrySqlDelect.length()).split("_");
        }
        logger.debug(inStorageEntrySql.equals("")&&stockAccountSql.equals(""));
        logger.debug("删除全部 并且更新");
        logger.debug("如果原来的数据全都删除："+arr2==null);
        logger.debug("删除全部 并且更新111");
        if(arr2==null){
            //如果所有的原来数据都删除了  先删除全部 再添加
            if(inStorageEntrySql.equals("")&&stockAccountSql.equals("")){
                logger.debug("直接全删除"+po.getfNumber());
                logger.debug(arr2==null);
            }else{
                logger.debug("全删除并且 增加新的数据");
            //仓库id  物料id 数量 规格 需要进行修改的数据
                List<WarehouseEntryPo> list2 =new ArrayList<WarehouseEntryPo>();
                String[] strlist2=stockAccountSqlDelect.split("_");
                WarehouseEntryPo po4;
                for(int i=1;i<strlist2.length;i++){
                    po4=new WarehouseEntryPo();
                    str=strlist2[i].split("=");
                    po4.setfStorageID(str[0]);
                    po4.setfMaterialID(str[1]);
                    po4.setfAmount(str[2]);
                    po4.setfStandard(str[3]);
                    po4.setFid(str[4]);
                    list2.add(po4);
                }
                logger.debug("全部删除---部分添加");
                //还需要增加：
                //仓库id  数量  备注  物料id  保管员id  供应商id,单价price,金额fSum
                List<WarehouseEntryPo> list =new ArrayList<WarehouseEntryPo>();
                String[] strlist=inStorageEntrySql.split("_");
                WarehouseEntryPo po2;
                for(int i=1;i<strlist.length;i++){
                    po2=new WarehouseEntryPo();
                    str=strlist[i].split("=");
                    po2.setfStorageID(str[0]);
                    po2.setfAmount(str[1]);
                    po2.setfRemarks(str[2]);
                    po2.setfMaterialID(str[3]);
                    po2.setfStoremanID(str[4]);
                    po2.setfSupplierID(str[5]);
                    po2.setfPrice(str[6]);
                    po2.setfSum(str[7]);
                    po2.setfPurchaseManID(user.getEmployId());
                    list.add(po2);
                }
                //仓库id  物料id 数量 规格
                List<WarehouseEntryPo> list1 =new ArrayList<WarehouseEntryPo>();
                String[] strlist1=stockAccountSql.split("_");
                WarehouseEntryPo po3;
                for(int i=1;i<strlist.length;i++){
                    po3=new WarehouseEntryPo();
                    str=strlist1[i].split("=");
                    po3.setfStorageID(str[0]);
                    po3.setfMaterialID(str[1]);
                    po3.setfAmount(str[2]);
                    po3.setfStandard(str[3]);
                    po3.setfNursingHomeID(user.getOldhouse());
                    po3.setfNumber(po.getfNumber());
                    list1.add(po3);
                }
                logger.debug("删除数据id:"+arr+""+stockAccountSqlDelect);
                logger.debug("新增的数据："+""+inStorageEntrySql+" "+stockAccountSql);
                try {
                    String id=po.getFid();
                    if((this.warehouseService.updateStockAccount(po,arr,list2)==0)){
                        logger.debug("删除原来数据");
                        po.setFid(id);//更新时候存值
                        if(this.warehouseService.creatStockAccount(po,list,list1)==0){
                            logger.debug("更新成功");
                            return new AjaxResultPo(true, "success");
                        }else{
                            logger.debug("进入更新方法,更新失败");
                            request.getSession().setAttribute("dmsg", "更新失败");
                            return new AjaxResultPo(false, "error");
                        }
                    }else{
                        logger.debug("进入更新方法,更新失败");
                        request.getSession().setAttribute("dmsg", "更新失败");
                        return new AjaxResultPo(false, "error");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    request.getSession().setAttribute("dmsg", "更新异常");
                    logger.debug("异常:"+e.getMessage());
                    e.printStackTrace();
                    return new AjaxResultPo(false, "error");
                }
            }
        }else if(arr.length==arr2.length){
            logger.debug("没有删除只有更新");
            if(inStorageEntrySql.equals("")&&stockAccountSql.equals("")){
                logger.debug("不进行添加");
                try {
                    if(this.warehouseService.updateStock(po)==0){
                        logger.debug("更新成功");
                        return new AjaxResultPo(true, "success");
                    }else{
                        logger.debug("进入更新方法,更新失败");
                        request.getSession().setAttribute("dmsg", "更新失败");
                        return new AjaxResultPo(false, "error");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    request.getSession().setAttribute("dmsg", "更新异常");
                    logger.debug("异常:"+e.getMessage());
                    e.printStackTrace();
                    return new AjaxResultPo(false, "error");
                }
            }else{
                //仓库id  数量  备注  物料id  保管员id  供应商id,单价price,金额fSum
                List<WarehouseEntryPo> list =new ArrayList<WarehouseEntryPo>();
                String[] strlist=inStorageEntrySql.split("_");
                WarehouseEntryPo po2;
                for(int i=1;i<strlist.length;i++){
                    po2=new WarehouseEntryPo();
                    str=strlist[i].split("=");
                    po2.setfStorageID(str[0]);
                    po2.setfAmount(str[1]);
                    po2.setfRemarks(str[2]);
                    po2.setfMaterialID(str[3]);
                    po2.setfStoremanID(str[4]);
                    po2.setfSupplierID(str[5]);
                    po2.setfPrice(str[6]);
                    po2.setfSum(str[7]);
                    po2.setfPurchaseManID(user.getEmployId());
                    list.add(po2);
                }
                //仓库id  物料id 数量 规格
                List<WarehouseEntryPo> list1 =new ArrayList<WarehouseEntryPo>();
                String[] strlist1=stockAccountSql.split("_");
                WarehouseEntryPo po3;
                for(int i=1;i<strlist.length;i++){
                    po3=new WarehouseEntryPo();
                    str=strlist1[i].split("=");
                    po3.setfStorageID(str[0]);
                    po3.setfMaterialID(str[1]);
                    po3.setfAmount(str[2]);
                    po3.setfStandard(str[3]);
                    po3.setfNursingHomeID(user.getOldhouse());
                    po3.setfNumber(po.getfNumber());
                    list1.add(po3);
                }
                try {
                    if(this.warehouseService.creatStockAccount(po,list,list1)==0){

                        logger.debug("更新成功");
                        return new AjaxResultPo(true, "success");
                    }else{
                        logger.debug("进入更新方法,更新失败");
                        request.getSession().setAttribute("dmsg", "更新失败");
                        return new AjaxResultPo(false, "error");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    request.getSession().setAttribute("dmsg", "更新异常");
                    logger.debug("异常:"+e.getMessage());
                    e.printStackTrace();
                    return new AjaxResultPo(false, "error");
                }
            }
        }else{
            logger.debug("既有删除又有更新");
            String delete[]=deff(arr,arr2);
            logger.debug(stockAccountSqlDelect);
            if(inStorageEntrySql.equals("")&&stockAccountSql.equals("")){
                //仓库id  物料id 数量 规格 需要进行修改的数据
                List<WarehouseEntryPo> list2 =new ArrayList<WarehouseEntryPo>();
                String[] strlist2=stockAccountSqlDelect.split("_");
                WarehouseEntryPo po4;
                for(int i=1;i<strlist2.length;i++){
                    po4=new WarehouseEntryPo();
                    str=strlist2[i].split("=");
                    po4.setfStorageID(str[0]);
                    po4.setfMaterialID(str[1]);
                    po4.setfAmount(str[2]);
                    po4.setfStandard(str[3]);
                    po4.setFid(str[4]);
                    list2.add(po4);
                }
                try {
                    if(this.warehouseService.updateStockAccount(po,delete,list2)==0){
                        logger.debug("更新成功");
                        return new AjaxResultPo(true, "success");
                    }else{
                        logger.debug("进入更新方法,更新失败");
                        request.getSession().setAttribute("dmsg", "更新失败");
                        return new AjaxResultPo(false, "error");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    request.getSession().setAttribute("dmsg", "更新异常");
                    logger.debug("异常:"+e.getMessage());
                    e.printStackTrace();
                    return new AjaxResultPo(false, "error");
                }
            }else{
                //4 2
                //仓库id  物料id 数量 规格 需要进行修改的数据
                List<WarehouseEntryPo> list2 =new ArrayList<WarehouseEntryPo>();
                String[] strlist2=stockAccountSqlDelect.split("_");
                WarehouseEntryPo po4;
                for(int i=1;i<strlist2.length;i++){
                    po4=new WarehouseEntryPo();
                    str=strlist2[i].split("=");
                    po4.setfStorageID(str[0]);
                    po4.setfMaterialID(str[1]);
                    po4.setfAmount(str[2]);
                    po4.setfStandard(str[3]);
                    po4.setFid(str[4]);
                    list2.add(po4);
                }

                //进行增加的
                //仓库id  数量  备注  物料id  保管员id  供应商id,单价price,金额fSum
                List<WarehouseEntryPo> list =new ArrayList<WarehouseEntryPo>();
                String[] strlist=inStorageEntrySql.split("_");
                WarehouseEntryPo po2;
                for(int i=1;i<strlist.length;i++){
                    po2=new WarehouseEntryPo();
                    str=strlist[i].split("=");
                    po2.setfStorageID(str[0]);
                    po2.setfAmount(str[1]);
                    po2.setfRemarks(str[2]);
                    po2.setfMaterialID(str[3]);
                    po2.setfStoremanID(str[4]);
                    po2.setfSupplierID(str[5]);
                    po2.setfPrice(str[6]);
                    po2.setfSum(str[7]);
                    po2.setfPurchaseManID(user.getEmployId());
                    list.add(po2);
                }
                //仓库id  物料id 数量 规格
                List<WarehouseEntryPo> list1 =new ArrayList<WarehouseEntryPo>();
                String[] strlist1=stockAccountSql.split("_");
                WarehouseEntryPo po3;
                for(int i=1;i<strlist.length;i++){
                    po3=new WarehouseEntryPo();
                    str=strlist1[i].split("=");
                    po3.setfStorageID(str[0]);
                    po3.setfMaterialID(str[1]);
                    po3.setfAmount(str[2]);
                    po3.setfStandard(str[3]);
                    po3.setfNursingHomeID(user.getOldhouse());
                    po3.setfNumber(po.getfNumber());
                    list1.add(po3);
                }
                try {
                    String id=po.getFid();
                    if((this.warehouseService.updateStockAccount(po,delete,list2)==0)){
                        logger.debug("删除原来数据");
                        po.setFid(id);//更新时候存值
                        if(this.warehouseService.creatStockAccount(po,list,list1)==0){
                            logger.debug("更新成功");
                            return new AjaxResultPo(true, "success");
                        }else{
                            logger.debug("进入更新方法,更新失败");
                            request.getSession().setAttribute("dmsg", "更新失败");
                            return new AjaxResultPo(false, "error");
                        }
                    }else{
                        logger.debug("进入更新方法,更新失败");
                        request.getSession().setAttribute("dmsg", "更新失败");
                        return new AjaxResultPo(false, "error");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    request.getSession().setAttribute("dmsg", "更新异常");
                    logger.debug("异常:"+e.getMessage());
                    e.printStackTrace();
                    return new AjaxResultPo(false, "error");
                }
            }
        }
        try {
          /* if(this.inStorageService.creatStockAccount(po,list,list1)==0){
                logger.debug("增加成功");
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入增加方法,增加失败");
                request.getSession().setAttribute("dmsg", "增加失败");
                return null;
            }*/
            return null;
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "增加异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return new AjaxResultPo(false, "error");
        }
    }

    @ResponseBody
    @RequestMapping("/deleteInStorage")
    public AjaxResultPo deleteOrder(WarehouseEntryPo po,String stockAccountSqlDelect,HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入delectOrder()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("主表参数"+po);
        String[] str;

        List<WarehouseEntryPo> list2 =new ArrayList<WarehouseEntryPo>();
        String[] strlist2=stockAccountSqlDelect.split("_");
        WarehouseEntryPo po4;
        for(int i=1;i<strlist2.length;i++){
            po4=new WarehouseEntryPo();
            str=strlist2[i].split("=");
            po4.setfStorageID(str[0]);
            po4.setfMaterialID(str[1]);
            po4.setfAmount(str[2]);
            po4.setfStandard(str[3]);
            po4.setFid(str[4]);
            list2.add(po4);
        }

        try {
            if(this.warehouseService.deleteUpdateStock(po,list2)==0){
                logger.debug("删除成功");
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入删除方法,删除失败");
                request.getSession().setAttribute("dmsg", "添加失败");
                return new AjaxResultPo(false, "error");
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "删除异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return new AjaxResultPo(false, "error");
        }
    }

    //判断出需要批量增加  批量删除的房间
    public String[] deff(String[] str,String[] str1){
        StringBuffer sb=new StringBuffer("");
        int flag=0;
        for(int i=0;i<str.length;i++){
            for(int j=0;j<str1.length;j++){
                if(!str[i].equals(str1[j])){
                    flag++;
                }
            }
            if(flag==str1.length){
                sb.append(str[i]);
                if(i!=str.length-1){
                    sb.append(",");
                }
            }
            flag=0;
        }
        String[] result=sb.toString().split(",");
        return result;
    }
}
