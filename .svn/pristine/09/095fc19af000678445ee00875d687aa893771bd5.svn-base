package com.channelsoft.ems.controller;

import com.channelsoft.ems.common.ConstantsMap;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.ChargePo;
import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.ChargeStandardService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;
/**
 * Description:收费标准菜单
 * Created by wangjs on 2016/12/1.
 */
@Controller
@RequestMapping("/charge")
public class ChargeStandardController {

    private static Logger logger=Logger.getLogger(ChargeStandardController.class);

    @Autowired
    private ChargeStandardService chargeStandardService;

    @RequestMapping("/chList")
    public String gotoChargeStandardList(){
        logger.debug("收费标准，已经跳转");
        return "chargeStandard/chargeStandardList";
    }

    /**
     * @Method: queryChargeStandard
     * @Description: 分页查询收费标准
     * @Para: [ChargePo, page, pageSize]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo queryChargeStandard(ChargePo po, int page,boolean flag, int pageSize,
                             HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入ChargeStandardController.query()方法,请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        try{
            List<ChargePo> chargeList=chargeStandardService.queryChargeList(po,page,pageSize,flag);
            for(int i=0;i<chargeList.size();i++) {
                //查询数据字典费用类型
                String chargeTypeId=chargeList.get(i).getfChrgeType();
                DataDictionaryPo dictionaryPo=ConstantsMap.dataDictionaryMap.get(chargeTypeId);
                chargeList.get(i).setfChrgeTypeName(dictionaryPo.getValue());

                //查询数据字典费用周期
                String chargeCycleId=chargeList.get(i).getfChargeCycle();
                DataDictionaryPo dicPo=ConstantsMap.dataDictionaryMap.get(chargeCycleId);
                chargeList.get(i).setfChargeCycleName(dicPo.getValue());

                //查询数据字典费用单位
                String unitId=chargeList.get(i).getfUnit();
                DataDictionaryPo dictionPo=ConstantsMap.dataDictionaryMap.get(unitId);
                chargeList.get(i).setfUnitName(dictionPo.getValue());

                //根据护理级别ID查询内存中的护理级别并显示
                String nursingId=chargeList.get(i).getfNursingLevel();
                DataDictionaryPo dataDictionaryPo=ConstantsMap.dataDictionaryMap.get(nursingId);
                chargeList.get(i).setfNursingLevelName(dataDictionaryPo.getValue());
            }
            logger.debug("进入ChargeStandardController.queryCount（）方法");
            int dataCount=chargeStandardService.queryCount(po);
            return new AjaxResultPo(true,"success",dataCount,chargeList);
        }catch (Exception e){
            logger.error("查询收费标准失败",e);
            return new AjaxResultPo(false);
        }

    }

    /**
     * @Method: getCharge
     * @Description: 查询收费标准
     * @Para: [ChargePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/queryCharge")
    public AjaxResultPo getCharge(ChargePo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入ChargeStandardController.getCharge()方法，请求参数: "+ po.toString());
        List<ChargePo> oldManCharge=chargeStandardService.getCharge(po);
        for(int i=0;i<oldManCharge.size();i++) {
            //查询数据字典费用类型
            String chargeTypeId=oldManCharge.get(i).getfChrgeType();
            DataDictionaryPo dictionaryPo=ConstantsMap.dataDictionaryMap.get(chargeTypeId);
            oldManCharge.get(i).setfChrgeTypeName(dictionaryPo.getValue());

            //查询数据字典费用单位
            String unitId=oldManCharge.get(i).getfUnit();
            DataDictionaryPo dictionPo=ConstantsMap.dataDictionaryMap.get(unitId);
            oldManCharge.get(i).setfUnitName(dictionPo.getValue());

        }
        return new AjaxResultPo(true,"success",oldManCharge.size(),oldManCharge);
    }

    @ResponseBody
    @RequestMapping("/queryChargeMess")
    public AjaxResultPo queryChargeMess(ChargePo po, @RequestParam(value = "arrayCharge") String[] arr, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入ChargeStandardController.queryChargeMess请求参数arr: "+ arr.length);
        List<ChargePo> oldManChargeMess=chargeStandardService.queryChargeMess(arr);
        return new AjaxResultPo(true,"success",oldManChargeMess.size(),oldManChargeMess);
    }

    /**
     * @Method: addStandard
     * @Description: 添加收费标准
     * @Para: [ChargePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/addStandard")
    public AjaxResultPo addChargeStandard(ChargePo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入ChargeStandardController.addChargeStandard（）方法");
        try{
            UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
            po.setfNursinghomeID(user.getOldhouse());
            chargeStandardService.addStandard(po);
            return new AjaxResultPo(true,"添加收费标准成功");
        }catch (Exception e){
            logger.error("费用标准添加失败",e);
            return new AjaxResultPo(false,"添加收费标准成功");
        }

    }

    /**
     * @Method: updChargeStandard
     * @Description: 修改收费标准
     * @Para: [ChargePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updStandard")
    public AjaxResultPo updChargeStandard(ChargePo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入ChargeStandardController.updChargeStandard()方法");
        try{
            chargeStandardService.updStandard(po);
            return new AjaxResultPo(true,"修改收费标准成功");
        }catch (Exception e){
            logger.error("修改收费标准失败",e);
            return new AjaxResultPo(false,"修改收费标准失败");
        }

    }

    /**
     * @Method: delStandard
     * @Description: 作废收费标准
     * @Para: [ChargePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/delCharge")
    public AjaxResultPo delStandard(ChargePo po,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入ChargeStandardController.delStandard()方法");
        try{
            chargeStandardService.delStandard(po);
            return new AjaxResultPo(true,"作废收费标准成功");
        }catch (Exception e){
            logger.error("删除收费标准失败",e);
            return new AjaxResultPo(false,"作废收费标准失败");
        }
    }

}