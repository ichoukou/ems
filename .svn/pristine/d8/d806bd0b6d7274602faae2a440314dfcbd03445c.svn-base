package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.CwglPaymentPo;
import com.channelsoft.ems.service.CwglPaymentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by wangjs on 2017/1/12.
 */
@Controller
@RequestMapping("/cwglPayment")
public class CwglPaymentController {
    private Logger logger = Logger.getLogger(CwglPaymentController.class);
    private static List<CwglPaymentPo> poList = new ArrayList<CwglPaymentPo>();

    @Autowired
    private CwglPaymentService cwglPaymentService;


    @RequestMapping("/gotoList")
    public String gotoCwglPayment(HttpServletRequest request, HttpServletResponse response) {

        logger.debug("收支用途分类，已经跳转");
        return "cwglPayment/cwglPaymentList";
    }

    /**
     * @Method: queryPayList
     * @Description: 查询收支用途分类
     * @Para: [CwglPaymentPo,String]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo queryPayList(CwglPaymentPo po,String flag, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("进入CwglPaymentController.queryPayList()方法,请求参数: " + po.toString() );
        List<CwglPaymentPo> cwPayList = cwglPaymentService.queryPayList(po,flag);
//        int dataCount=CwglPaymentService.queryCount(po);
        for (CwglPaymentPo pmPo : cwPayList) {
            pmPo.setLevel(1);
        }
        return new AjaxResultPo(true, "success", cwPayList.size(), cwPayList);
    }

    /**
     * @Method: getPayList
     * @Description: 查询收支用途分类作为新增和修改时的下拉列表
     * @Para: [String]
     * @Retun: List<CwglPaymentPo>
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    @ResponseBody
    @RequestMapping("/getPayList")
    public List<CwglPaymentPo> getPayList(String id, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("进入CwglPaymentController.getPayList()方法,请求参数: " + id);
        List<CwglPaymentPo> cwPayList = cwglPaymentService.getPayList(id);
        poList.clear();
        listFormate(cwPayList, "0", 0);
        return poList;
    }

    /**
     * @Method: listFormate
     * @Description: 类型列表排序
     * @Para: [List<CwglPaymentPo> list, String id, int level]
     * @Retun: List<CwglPaymentPo>
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    public static void listFormate(List<CwglPaymentPo> list, String id, int level) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFparentid().equals(id)) {
                StringBuffer str = new StringBuffer();
                for (int j = 0; j < level; j++) {
                    if (j == (level - 1)) {
                        str.append("&nbsp;&nbsp;&nbsp;&nbsp;" + "▶");
                    } else {
                        str.append("&nbsp;&nbsp;&nbsp;&nbsp;");
                    }
                }
                list.get(i).setFname(str + list.get(i).getFname());
                poList.add(list.get(i));
                listFormate(list, list.get(i).getFid(), level + 1);
            }
        }
    }

    /**
     * @Method: listFormate
     * @Description: 查询收支用途分类子表
     * @Para: [String fid,String flag, int level]
     * @Retun: List<CwglPaymentPo>
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    @ResponseBody
    @RequestMapping("/querySon")
    public List<CwglPaymentPo> gotoSonList(String fid,String flag, int level, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("进入CwglPaymentController.getPayList()方法,请求参数: " + fid + level);
        List<CwglPaymentPo> cwPayList = cwglPaymentService.queryPaySonList(fid,flag);
//        int dataCount=CwglPaymentService.queryCount(po);
        for (CwglPaymentPo pmPo : cwPayList) {
            pmPo.setLevel(level + 1);
        }
        return cwPayList;
    }

    /**
     * @Method: addPayment
     * @Description: 添加收支用途分类
     * @Para: [CwglPaymentPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    @ResponseBody
    @RequestMapping("/addPayment")
    public AjaxResultPo addPayment(CwglPaymentPo po, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("进入CwglPaymentController.getPayList()方法,");
        logger.debug("请求参数: " + po.toString());
        try {
            UUID uuid = UUID.randomUUID();
            po.setFid(uuid.toString());
            this.cwglPaymentService.addPayment(po);
            return new AjaxResultPo(true, "添加收支用途分类成功");
        } catch (Exception e) {
            logger.debug("添加收支用途分类失败" ,e);
            return new AjaxResultPo(false, "添加收支用途分类失败");
        }
    }


    /**
     * @Method: updateCwglPayment
     * @Description: 更新收支用途分类
     * @Para: [CwglPaymentPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    @ResponseBody
    @RequestMapping("/updateCwglPayment")
    public AjaxResultPo updateCwglPayment(CwglPaymentPo po, HttpServletResponse response, HttpServletRequest request) {
        logger.debug("进入CwglPaymentController.updateCwglPayment()方法,");
        logger.debug("请求参数: " + po.toString());
        logger.debug("需要更新字段" + po);
        try {
            this.cwglPaymentService.updateCwglPayment(po);
            return new AjaxResultPo(true, "更新收支用途分类成功");
        } catch (Exception e) {
            logger.debug("更新收支用途分类失败" ,e);
            return new AjaxResultPo(false, "更新收支用途分类失败");
        }
    }

    /**
     * @Method: deleteCwglPayment
     * @Description: 删除收支用途分类
     * @Para: [CwglPaymentPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    @ResponseBody
    @RequestMapping("/deleteCwglPayment")
    public AjaxResultPo deleteCwglPayment(String  fid,HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入CwglPaymentController.deleteCwglPayment()方法,");
        logger.debug("请求参数: 要删除的类型ID:" + fid);
        int count =cwglPaymentService.searchCwglPayment(fid);
        if(count == 0)
        {
            try {
                this.cwglPaymentService.deleteCwglPayment(fid);
                return new AjaxResultPo(true, "删除收支用途分类成功");
            } catch (Exception e) {
                logger.error("删除收支用途分类失败:" ,e);
                return new AjaxResultPo(false,"删除收支用途分类失败");
            }
        }
        else {
            return new AjaxResultPo(false,"删除收支用途分类失败,有子表");
        }
    }

}
