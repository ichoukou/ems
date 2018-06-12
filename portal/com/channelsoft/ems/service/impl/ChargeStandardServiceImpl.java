package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.ChargeStandardMapper;
import com.channelsoft.ems.po.ChargePo;
import com.channelsoft.ems.service.ChargeStandardService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjs on 2016/12/1.
 */
@Service
public class ChargeStandardServiceImpl implements ChargeStandardService {
    private static Logger logger= Logger.getLogger(ChargeStandardServiceImpl.class);

    @Autowired
    private ChargeStandardMapper mapper;

    /**
     * @Method: updChargeStandard
     * @Description: 修改收费标准
     * @Para: [ChargePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public int queryCount(ChargePo po){
        int dataCount=mapper.queryCount(po);
        logger.debug("dataCount"+dataCount);
        return dataCount;
    }

    /**
     * @Method: queryChargeList
     * @Description: 查询收费标准，带分页
     * @Para: [ChargePo,page,pageSize]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<ChargePo> queryChargeList(ChargePo po,int page,int pageSize,boolean flag) {
        logger.debug("进入ChargeStandardServiceImpl.queryChangeList()方法");
        logger.debug("查询参数："+po.toString()+"page="+page+"pageSize"+pageSize);
        List<ChargePo> chargeList=mapper.queryList(po,page,pageSize,flag);
        logger.debug("收费标准，查询结果："+chargeList.size());
        return chargeList;
    }

    /**
     * @Method: getCharge
     * @Description: 查询收费标准
     * @Para: [ChargePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<ChargePo> getCharge(ChargePo po) {
        logger.debug("进入ChargeStandardServiceImpl.queryChange方法");
        logger.debug("查询参数："+po.toString());
        List<ChargePo> oldManCharge=mapper.getCharge(po);
        logger.debug("收费标准(不带分页),查询结果："+oldManCharge.size());
        return oldManCharge;
    }

    /**
     * @Method: queryChargeMess
     * @Description: 查询收费标准
     * @Para: [String[]]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<ChargePo> queryChargeMess(String[] arr) {
        logger.debug("进入ChargeStandardServiceImpl.queryChargeMess()方法");
        logger.debug("查询参数："+arr.toString());
        List<ChargePo> oldManChargeMess=mapper.queryChargeMess(arr);
        logger.debug("查询老人所有收费标准语句,查询结果："+oldManChargeMess.size());
        return oldManChargeMess;
    }

    /**
     * @Method: addStandard
     * @Description: 添加收费标准
     * @Para: [ChargePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void addStandard(ChargePo po){
        logger.debug("进入ChargeStandardServiceImpl.addStandard()方法");
        try{
            mapper.addStandard(po);
            logger.debug("添加收费标准成功");
        }catch (Exception e){
            logger.error("添加收费标准异常"+e.getMessage());
        }
    }

    /**
     * @Method: updStandard
     * @Description: 修改收费标准
     * @Para: [ChargePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updStandard(ChargePo po){
        logger.debug("进入ChargeStandardServiceImpl.updStandard()方法");
        try{
            mapper.updStandard(po);
            logger.debug("修改收费标准成功");
        }catch (Exception e){
            logger.error("修改收费标准异常"+e.getMessage());
        }
    }

    /**
     * @Method: delStandard
     * @Description: 删除收费标准
     * @Para: [ChargePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void delStandard(ChargePo po){
        logger.debug("进入ChargeStandardServiceImpl.delStandard()方法");
        try{
            mapper.delStandard(po);
            logger.debug("删除收费标准成功");
        }catch (Exception e){
            logger.error("删除收费标准异常"+e.getMessage());
        }
    }
}
