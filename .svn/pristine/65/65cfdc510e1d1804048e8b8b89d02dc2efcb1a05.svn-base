package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.OldManPaymentMapper;
import com.channelsoft.ems.po.OldManPaymentPo;
import com.channelsoft.ems.service.OldManPaymentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjs on 2016/12/27.
 */
@Service
public class OldManPaymentServiceImpl implements OldManPaymentService{
    private static Logger logger = Logger.getLogger(OldManPaymentServiceImpl.class);

    @Autowired
    private OldManPaymentMapper mapper;

    /**
     * @Method: queryLast
     * @Description: 查询最后一条应缴费用
     * @Para: [OldManPaymentPo]
     * @Retun: List<OldManPaymentPo>
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    public List<OldManPaymentPo> queryLast(){
        logger.debug("进入OldManHosingServiceImpl.queryLast()方法,");
        List<OldManPaymentPo> payMent=mapper.queryLast();
        logger.debug("查询结果:"+payMent.size());
        return payMent;
    }

    /**
     * @Method: queryList
     * @Description: 查询应缴费用
     * @Para: [OldManPaymentPo]
     * @Retun: List<OldManPaymentPo>
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    public List<OldManPaymentPo> queryList(OldManPaymentPo po){
        logger.debug("进入OldManHosingServiceImpl.queryList()方法,");
        List<OldManPaymentPo> payMent=mapper.queryList(po);
        logger.debug("查询结果:"+payMent.size());
        return payMent;
    }

    /**
     * @Method: addPayment
     * @Description: 添加应缴费用
     * @Para: [OldManPaymentPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    public void addPayment(OldManPaymentPo po){
        logger.debug("进入OldManPaymentServiceImpl.addPayment()方法");
        try{
            mapper.addPayment(po);
            logger.debug("添加应缴费用成功");
        }catch (Exception e){
            logger.error("添加应缴费用异常:"+e.getMessage());
        }
    }

    /**
     * @Method: updOmPayment
     * @Description: 更新应缴费用
     * @Para: [OldManPaymentPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    public void updOmPayment(OldManPaymentPo po){
        logger.debug("进入OldManPaymentServiceImpl.updOmPayment()方法");
        try{
            mapper.updOmPayment(po);
            logger.debug("更新应缴费用成功");
        }catch (Exception e){
            logger.error("更新应缴费用异常:"+e.getMessage());
        }
    }

    /**
     * @Method: delOmPayment
     * @Description: 删除应缴费用
     * @Para: [OldManPaymentPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    public void delOmPayment(OldManPaymentPo po){
        logger.debug("进入OldManPaymentServiceImpl.delOmPayment()方法");
        try{
            mapper.delOmPayment(po);
            logger.debug("删除应缴费用成功");
        }catch (Exception e){
            logger.error("删除应缴费用异常:"+e.getMessage());
        }
    }
}
