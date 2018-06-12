package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.OldManPaymentEntryPo;
import com.channelsoft.ems.service.OldManPaymentEntryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by wangjs on 2016/12/28.
 */
@Controller
@RequestMapping("/paymentEntry")
public class OldManPaymentEntryController {
    private Logger logger= Logger.getLogger(OldManPaymentEntryController.class);

    @Autowired
    private OldManPaymentEntryService oldManPaymentEntryService;

//    @ResponseBody
//    @RequestMapping("/query")
//    public AjaxResultPo gotoList(TBuildingPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
//        logger.debug("大厦查询--请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
//        List<TBuildingPo> chargeList= teBuildingService.queryBuilding(po,page,pageSize);
//        logger.debug("进入queryCount（）方法");
//        int dataCount= teBuildingService.queryCount(po);
//        return new AjaxResultPo(true,"success",dataCount,chargeList);
//    }

    /**
     * @Method: addPaymentEntry
     * @Description: 批量添加费用应缴明细
     * @Para: [OldManPaymentEntryPo po, @RequestParam(value = "chargeArrPara")String[] arr]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    @ResponseBody
    @RequestMapping("/addPaymentEntry")
    public AjaxResultPo addPaymentEntry(OldManPaymentEntryPo po, @RequestParam(value = "chargeArrPara")String[] arr, HttpServletRequest request, HttpServletResponse response){

        logger.debug("进入OldManPaymentEntryController.addPaymentEntry()方法");
        try{
            oldManPaymentEntryService.addPaymentEntry(arr);
            return new AjaxResultPo(true, "批量添加费用应缴明细成功");
        }catch (Exception e){
            logger.error("批量添加费用应缴明细失败",e);
            return new AjaxResultPo(false, "批量添加费用应缴明细失败");
        }
    }

    /**
     * @Method: addPaymentEntryOne
     * @Description: 添加费用应缴明细
     * @Para: [OldManPaymentEntryPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    @ResponseBody
    @RequestMapping("/addPaymentEntryOne")
    public AjaxResultPo addPaymentEntryOne(OldManPaymentEntryPo po, HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入OldManPaymentEntryController.addPaymentEntryOne()方法");
        try{
            oldManPaymentEntryService.addPaymentEntryOne(po);
            return new AjaxResultPo(true, "添加费用应缴明细成功");
        }catch (Exception e){
            logger.error("添加费用应缴明细失败",e);
            return new AjaxResultPo(false, "添加费用应缴明细失败");
        }
    }

    /**
     * @Method: updPaymentEntryOne
     * @Description: 修改费用应缴明细
     * @Para: [OldManPaymentEntryPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    @ResponseBody
    @RequestMapping("/updPaymentEntryOne")
    public AjaxResultPo updPaymentEntryOne(OldManPaymentEntryPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入OldManPaymentEntryController.updPaymentEntryOne()方法");
        try{
            oldManPaymentEntryService.updPaymentEntryOne(po);
            return new AjaxResultPo(true, "修改费用应缴明细成功");
        }catch (Exception e){
            logger.error("修改费用应缴明细失败",e);
            return new AjaxResultPo(false, "修改费用应缴明细失败");
        }
    }

    /**
     * @Method: delPaymentEntryOne
     * @Description: 删除费用应缴明细
     * @Para: [OldManPaymentEntryPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    @ResponseBody
    @RequestMapping("/delPaymentEntryOne")
    public AjaxResultPo delPaymentEntryOne(OldManPaymentEntryPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入OldManPaymentEntryController.delPaymentEntryOne()方法");
        try{
            oldManPaymentEntryService.delPaymentEntryOne(po);
            return new AjaxResultPo(true, "删除费用应缴明细成功");
        }catch (Exception e){
            logger.error("删除费用应缴明细失败",e);
            return new AjaxResultPo(false, "删除费用应缴明细失败");
        }
    }

}
