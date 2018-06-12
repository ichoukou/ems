package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.OldManPaymentEntryMapper;
import com.channelsoft.ems.po.OldManPaymentEntryPo;
import com.channelsoft.ems.service.OldManPaymentEntryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by wangjs on 2016/12/28.
 */
@Service
public class OldManPaymentEntryServiceImpl implements OldManPaymentEntryService{

    private Logger logger= Logger.getLogger(OldManPaymentEntryServiceImpl.class);

    @Autowired
    private OldManPaymentEntryMapper mapper;

    /**
     * @Method: addPaymentEntry
     * @Description: 批量添加应缴费用明细
     * @Para: [String[] arr]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,rollbackFor={Exception.class})
    public void addPaymentEntry(String[] arr){
        logger.debug("进入OldManPaymentEntryServiceImpl.addPaymentEntry()方法");
        try{
            for(int i=0;i<arr.length;i++){
                String[] temp=arr[i].split("=");
                String fParentid=temp[0];
                String fCostItem=temp[1];
                String fitemID=temp[2];
                String fArPaymentAmount=temp[3];
                int result=mapper.addPaymentEntry(fParentid,fCostItem,fitemID,fArPaymentAmount);
                if(result<0){
                    throw new Exception("开始回滚");
                }
            }
            logger.debug("批量添加应缴费用明细成功");
        }catch (Exception e){
            logger.error("批量添加应缴费用明细异常:"+e.getMessage());
        }
    }

    /**
     * @Method: addPaymentEntryOne
     * @Description: 添加应缴费用明细
     * @Para: [OldManPaymentEntryPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    public void addPaymentEntryOne(OldManPaymentEntryPo po){
        logger.debug("进入OldManPaymentEntryServiceImpl.addPaymentEntryOne()方法");
        try{
            mapper.addPaymentEntryOne(po);
            logger.debug("添加应缴费用明细成功");
        }catch (Exception e){
            logger.error("添加应缴费用明细异常:"+e.getMessage());
        }
    }

    /**
     * @Method: updPaymentEntryOne
     * @Description: 修改应缴费用明细
     * @Para: [OldManPaymentEntryPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    public void updPaymentEntryOne(OldManPaymentEntryPo po){
        logger.debug("进入OldManPaymentEntryServiceImpl.updPaymentEntryOne()方法");
        try{
            mapper.updPaymentEntryOne(po);
            logger.debug("修改应缴费用明细成功");
        }catch (Exception e){
            logger.error("修改应缴费用明细异常:"+e.getMessage());
        }
    }

    /**
     * @Method: delPaymentEntryOne
     * @Description: 删除应缴费用明细
     * @Para: [OldManPaymentEntryPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    public void delPaymentEntryOne(OldManPaymentEntryPo po){
        logger.debug("进入OldManPaymentEntryServiceImpl.delPaymentEntryOne()方法");
        try{
            mapper.delPaymentEntryOne(po);
            logger.debug("删除应缴费用明细成功");
        }catch (Exception e){
            logger.error("删除应缴费用明细异常:"+e.getMessage());
        }
    }
}
