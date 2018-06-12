package com.channelsoft.ems.controller;

import com.channelsoft.ems.mapper.StorageCheckMapper;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.StorageCheckPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.StorageCheckService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by liuxing on 2017/1/6.
 */
@Controller
@RequestMapping("/StorageCheck")
public class StorageCheckController {
    private static Logger logger=Logger.getLogger(StorageCheckController.class);

    @Autowired
    private  StorageCheckService storageCheckService;

    @RequestMapping("/scList")
    public String gotoStorageCheckList(HttpServletRequest request, HttpServletResponse response)
    {
        logger.debug("进入 gotoStorageCheckList()  方法");
        return "storageCheck/storageCheckList";
    }
    /**
     * @description: 盘点列表查询(分页)
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
    @RequestMapping("/queryStorageCheckList")
    public AjaxResultPo queryStorageCheckList(StorageCheckPo po, int page, int pageSize, HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入 queryStorageCheckList方法");
        logger.debug("请求参数：po:"+po+"page:"+page+"pageSize:"+pageSize);
        List<StorageCheckPo> list =  new ArrayList<StorageCheckPo>();
        list=storageCheckService.queryStorageCheckList(po,page,pageSize);
        System.out.println(list.toString());
        int count = storageCheckService.queryStorageCheckCount(po);
        return new AjaxResultPo(true,"success",count,list);
    }
    /**
     * @description: 根据选择的盘点列表行，得到需要打印的列表
     * @param storageID
     * @param checkDate
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getPrintList")
    public List<StorageCheckPo> getPrintList( String storageID,String checkDate,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入   getPrintList（）方法");
        logger.debug("请求参数：storage:"+storageID+"checkDate:"+checkDate);
        List<StorageCheckPo> list=new ArrayList<StorageCheckPo>();
        list = storageCheckService.getPrintList(storageID,checkDate);
        return list;
    }
    /**
     * @description: 根据仓库ID得到该仓库里所有的物品列表
     * @param storageID
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getStorageMaterial")
    public AjaxResultPo getStorageMaterial( String storageID,HttpServletRequest request,HttpServletResponse response) {
        logger.debug("进入   getStorageMaterial（）方法");
        logger.debug("请求参数：storage:" + storageID );
        List<StorageCheckPo> list = new ArrayList<StorageCheckPo>();
        list = storageCheckService.getStorageMaterial(storageID);
        int count=storageCheckService.getStorageMaterialCount(storageID);
        return new AjaxResultPo(true,"success",count,list);
    }
    /**
     * @description: 加载checkman  select下拉框
     * @param request
     * @param response
     * @return List<StorageCheckPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/getCheckManList")
    public List<StorageCheckPo> getCheckManList(HttpServletRequest request,HttpServletResponse response) {
        logger.debug("进入   getCheckManList（）方法");
        List<StorageCheckPo> list = new ArrayList<StorageCheckPo>();
        list = storageCheckService.getCheckManList();
        return list;
    }
    /**
     * @description: 检查表单增加
     * @param str
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/add_check")
    public AjaxResultPo addCheck(String str,HttpServletResponse response,HttpServletRequest request){
        logger.debug("进入  add_check方法");
        logger.debug("请求参数：str:"+str);
        List<StorageCheckPo> list=new ArrayList<StorageCheckPo>();
        String[] strlist=str.split("_");
        StorageCheckPo po;
        String[] sstr;
        UserPo user= (UserPo) request.getSession().getAttribute("loginUser");
        for(int i=1;i<strlist.length;i++){
            po=new StorageCheckPo();
            sstr=strlist[i].split("=");
            po.setFnumber(sstr[0]);
            po.setNursingHomeID(sstr[1]);
            po.setCheckDate(sstr[2]);
            po.setStorageManID(sstr[3]);
            po.setStorageID(sstr[4]);
            po.setMaterialID(sstr[5]);
            po.setPaperNumber(sstr[6]);
            po.setCheckNumber(sstr[7]);
            po.setDifference(sstr[8]);
            po.setStatus(sstr[9]);
            po.setExplain(sstr[10]);
            po.setRemarks(sstr[11]);
            po.setCheckManID(sstr[12]);
            po.setCreatorID(user.getEmployId());
            po.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
            list.add(po);
        }
        try {
            logger.debug("进行添加");
            if (storageCheckService.addCheck(list) == 0) {
                logger.debug("添加成功");
                return new AjaxResultPo(true, "success");
            } else {
                logger.debug("添加失败");
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
}
