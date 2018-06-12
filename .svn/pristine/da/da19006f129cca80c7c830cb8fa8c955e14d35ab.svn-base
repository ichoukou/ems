package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.CwglPaymentMapper;
import com.channelsoft.ems.po.CwglPaymentPo;
import com.channelsoft.ems.service.CwglPaymentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by wangjs on 2017/1/12.
 */
@Service
public class CwglPaymentServiceImpl implements CwglPaymentService{
    private Logger logger= Logger.getLogger(CwglPaymentServiceImpl.class);

    @Autowired
    private CwglPaymentMapper mapper;

    /**
     * @Method: queryPayList
     * @Description: 查询收支用途分类
     * @Para: [CwglPaymentPo po,String flag]
     * @Retun: List<CwglPaymentPo>
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    public List<CwglPaymentPo> queryPayList(CwglPaymentPo po,String flag){
        logger.debug("进入CwglPaymentServiceImpl.queryPayList()方法");
        logger.debug("查询参数: " + po.toString());
        List<CwglPaymentPo> dcList = mapper.queryPayList(po,flag);
        logger.debug("查询得到: " + dcList.size()+" 条数据");
        return dcList;
    }

    /**
     * @Method: getPayList
     * @Description: 查询收支用途分类（修改，添加时回显数据）
     * @Para: [String]
     * @Retun: List<CwglPaymentPo>
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    public List<CwglPaymentPo> getPayList(String id){
        logger.debug("进入CwglPaymentServiceImpl.getPayList()方法");
        logger.debug("查询参数: " + id);
        List<CwglPaymentPo> dcList = mapper.getPayList(id);
        logger.debug("查询得到: " + dcList.size()+" 条数据");
        return dcList;
    }

    /**
     * @Method: queryPaySonList
     * @Description: 查询收支用途分类子类
     * @Para: [CwglPaymentPo]
     * @Retun: List<CwglPaymentPo>
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    public List<CwglPaymentPo> queryPaySonList(String parentId,String flag){
        logger.debug("进入CwglPaymentServiceImpl.queryPaySonList()方法");
        logger.debug("查询参数: " +parentId);
        List<CwglPaymentPo> dcList = mapper.queryPaySonList(parentId,flag);
        logger.debug("查询得到: " + dcList.size()+" 条数据");
        return dcList;
    }

    /**
     * @Method: addPayment
     * @Description: 添加收支用途分类
     * @Para: [CwglPaymentPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    public void addPayment(CwglPaymentPo po){
        logger.debug("进入CwglPaymentServiceImpl.addPayment()方法");
        try{
            mapper.addPayment(po);
            logger.debug("添加收支用途分类成功");
        }catch (Exception e){
            logger.error("添加收支用途分类异常:"+e.getMessage());
        }
    }

    /**
     * @Method: updateCwglPayment
     * @Description: 更新收支用途分类
     * @Para: [CwglPaymentPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    public void updateCwglPayment(CwglPaymentPo po) {
        logger.debug("进入CwglPaymentServiceImpl.updateCwglPayment()方法");
        try{
            mapper.updateCwglPayment(po);
            logger.debug("更新收支用途分类成功");
        }catch (Exception e){
            logger.error("更新收支用途分类异常:"+e.getMessage());
        }
    }

    /**
     * @Method: searchCwglPayment
     * @Description: 查询收支用途分类是否有子类
     * @Para: [CwglPaymentPo]
     * @Retun: int
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    public int searchCwglPayment(String id) {
        logger.debug("进入CwglPaymentServiceImpl.searchCwglPayment()方法");
        int count = mapper.searchCwglPayment(id);
        return count;
    }

    /**
     * @Method: deleteCwglPayment
     * @Description: 删除收支用途分类
     * @Para: [CwglPaymentPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/27
     */
    public void deleteCwglPayment(String id) {
        logger.debug("进入CwglPaymentServiceImpl.deleteCwglPayment()方法");
        try{
            mapper.deleteCwglPayment(id);
            logger.debug("删除收支用途分类成功");
        }catch (Exception e){
            logger.error("删除收支用途分类异常:"+e.getMessage());
        }
    }

}
