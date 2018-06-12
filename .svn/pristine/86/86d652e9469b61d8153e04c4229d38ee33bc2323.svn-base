package com.channelsoft.ems.controller;

import com.channelsoft.ems.common.ConstantsMap;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManChargePo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.OldManChargeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wangjs on 2016/12/21.
 */
@Controller
@RequestMapping("/manCharge")
public class OldManChargeController {
    private Logger logger= Logger.getLogger(OldManChargeController.class);

    @Autowired
    private OldManChargeService oldManChargeService;

    @RequestMapping("/omCharge")
    public String getList(HttpServletRequest request, HttpServletResponse response){
        logger.debug("跳转到 oldManCharge/oldManChargeList.jsp");
        return "oldManCharge/oldManChargeList";
    }

    /**
     * @Method: getList
     * @Description: 查询老人收费
     * @Para: [OldManChargePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    @ResponseBody
    @RequestMapping("/getList")
    public AjaxResultPo getList(OldManChargePo po, HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入OldManChargeController.gotoList()方法");
        List<OldManChargePo> manCharges=oldManChargeService.getList(po);
        for(int i=0;i<manCharges.size();i++) {
            //查询数据字典费用类型
            String chargeTypeId=manCharges.get(i).getfChrgeType();
            DataDictionaryPo dictionaryPo= ConstantsMap.dataDictionaryMap.get(chargeTypeId);
            manCharges.get(i).setfChrgeTypeName(dictionaryPo.getValue());
        }
        return new AjaxResultPo(true,"success",manCharges.size(),manCharges);
    }

    /**
     * @Method: getOldManCharge
     * @Description: 查询老人收费用来验证是否添加重复数据
     * @Para: [OldManChargePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    @ResponseBody
    @RequestMapping("/getOldManCharge")
    public AjaxResultPo getOldManCharge(OldManChargePo po, HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入OldManChargeController.getOldManCharge()方法");
        List<OldManChargePo> manCharges=oldManChargeService.getOldManCharge(po);
        return new AjaxResultPo(true,"success",manCharges.size(),manCharges);
    }

    /**
     * @Method: queryList
     * @Description: 分页查询老人收费
     * @Para: [OldManChargePo po,int page,int pageSize,]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo queryList(OldManChargePo po,int page,int pageSize, HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入OldManChargeController.gotoList()方法");
        List<OldManChargePo> manCharges=oldManChargeService.queryList(po,page,pageSize);
        for(int i=0;i<manCharges.size();i++) {
            //查询数据字典费用类型
            String chargeTypeId=manCharges.get(i).getfChrgeType();
            DataDictionaryPo dictionaryPo= ConstantsMap.dataDictionaryMap.get(chargeTypeId);
            manCharges.get(i).setfChrgeTypeName(dictionaryPo.getValue());
        }
        int dataCount=oldManChargeService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,manCharges);
    }

    /**
     * @Method: addOldManCharge
     * @Description: 添加老人费用
     * @Para: [OldManChargePo po]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    @ResponseBody
    @RequestMapping("addOldManCharge")
    public AjaxResultPo addOldManCharge(OldManChargePo po, HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入OldManChargeController.addOldManCharge()方法");
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setfCreatorID(user.getEmployId());
        po.setfNursingHomeID(user.getOldhouse());
        try{
            oldManChargeService.addOldManCharge(po);
            return new AjaxResultPo(true,"添加老人收费成功");
        }catch (Exception e){
            logger.error("添加老人收费失败",e);
            return new AjaxResultPo(true,"添加老人收费失败");
        }
    }

    /**
     * @Method: addOldManChargeArr
     * @Description: 批量添加老人费用
     * @Para: [OldManChargePo po，String[] arr]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    @ResponseBody
    @RequestMapping("addOldManChargeArr")
    public AjaxResultPo addOldManChargeArr(OldManChargePo po,@RequestParam(value = "chargeArrPara")String[] arr, HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入OldManChargeController.addOldManCharge()方法");
        try{
            oldManChargeService.addOldManChargeArr(arr);
            return new AjaxResultPo(true,"批量添加老人收费成功");
        }catch (Exception e){
            logger.error("批量添加老人收费失败",e);
            return new AjaxResultPo(true,"批量添加老人收费失败");
        }
    }

    /**
     * @Method: updChargeStatus
     * @Description: 批量修改老人费用状态
     * @Para: [OldManChargePo po，String[] arr]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    @ResponseBody
    @RequestMapping("updChargeStatus")
    public AjaxResultPo updChargeStatus(OldManChargePo po, @RequestParam(value = "selectDataList")String[] arr, HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入OldManChargeController.updChargeStatus()方法");
        try{
            oldManChargeService.updChargeStatus(arr);
            return new AjaxResultPo(true,"批量修改老人收费状态成功");
        }catch (Exception e){
            logger.error("批量修改老人收费状态失败",e);
            return new AjaxResultPo(true,"批量修改老人收费状态失败");
        }
    }

    /**
     * @Method: delOldManCharge
     * @Description: 删除老人收费
     * @Para: [OldManChargePo po]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    @ResponseBody
    @RequestMapping("delOldManCharge")
    public AjaxResultPo delOldManCharge(OldManChargePo po, HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入OldManChargeController.delOldManCharge()方法");
        try{
            oldManChargeService.delOldManCharge(po);
            return new AjaxResultPo(true,"删除老人收费成功");
        }catch (Exception e){
            logger.error("删除老人收费失败",e);
            return new AjaxResultPo(true,"删除老人收费失败");
        }
    }
}
