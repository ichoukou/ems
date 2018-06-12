package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.OldManChargeMapper;
import com.channelsoft.ems.po.OldManChargePo;
import com.channelsoft.ems.service.OldManChargeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangjs on 2016/12/21.
 */
@Service
public class OldManChargeServiceImpl implements OldManChargeService{

    private Logger logger= Logger.getLogger(OldManChargeServiceImpl.class);

    @Autowired
    private OldManChargeMapper mapper;

    public int queryCount(OldManChargePo po){
        return mapper.queryCount(po);
    }

    /**
     * @Method: queryList
     * @Description: 分页查询老人费用
     * @Para: [OldManChargePo po,int page,int pageSize]
     * @Retun: List<OldManChargePo>
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    public List<OldManChargePo> queryList(OldManChargePo po,int page,int pageSize){
        logger.debug("进入OldManChargeServiceImpl.queryList()方法");
        List<OldManChargePo> manCharges=mapper.queryList(po,page,pageSize);
        logger.debug("查询老人费用结果："+manCharges.size());
        return manCharges;
    }

    /**
     * @Method: getList
     * @Description: 查询老人费用
     * @Para: [OldManChargePo po]
     * @Retun: List<OldManChargePo>
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    public List<OldManChargePo> getList(OldManChargePo po){
        logger.debug("进入OldManChargeServiceImpl.queryList()方法");
        List<OldManChargePo> manCharges=mapper.getList(po);
        logger.debug("查询老人费用结果："+manCharges.size());
        return manCharges;
    }

    /**
     * @Method: getOldManCharge
     * @Description: 查询老人费用
     * @Para: [OldManChargePo po]
     * @Retun: List<OldManChargePo>
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    public List<OldManChargePo> getOldManCharge(OldManChargePo po){
        logger.debug("进入OldManChargeServiceImpl.getOldManCharge()方法");
        List<OldManChargePo> manCharges=mapper.getOldManCharge(po);
        logger.debug("查询老人费用结果："+manCharges.size());
        return manCharges;
    }

    /**
     * @Method: addOldManCharge
     * @Description: 添加老人收费
     * @Para: [OldManChargePo po]
     * @Retun:
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    public void addOldManCharge(OldManChargePo po){
        logger.debug("进入OldManChargeServiceImpl.addOldManCharge()方法");
        try{
            mapper.addOldManCharge(po);
        }catch (Exception e){
            logger.error("添加老人费用异常"+e.getMessage());
        }
    }

    /**
     * @Method: delOldManCharge
     * @Description: 删除老人收费
     * @Para: [OldManChargePo po]
     * @Retun:
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    public void delOldManCharge(OldManChargePo po){
        logger.debug("进入OldManChargeServiceImpl.addOldManCharge()方法");
        try{
            mapper.delOldManCharge(po);
        }catch (Exception e){
            logger.error("添加老人费用异常"+e.getMessage());
        }
    }

    /**
     * @Method: addOldManChargeArr
     * @Description: 批量添加老人收费
     * @Para: [String[] arr]
     * @Retun:
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,rollbackFor={Exception.class})
    public void addOldManChargeArr(String[] arr){
        logger.debug("进入OldManChargeServiceImpl.addOldManChargeArr()方法");
        try{
            for(int i=0;i<arr.length;i++){
                String[] temp=arr[i].split("=");
                String fOldManID=temp[0];
                String fManChargeID=temp[1];
                String fChargePrice=temp[2];
                String fNursingHomeID=temp[3];
                String fChargeStartTime=temp[4];
                String fOldManName=temp[5];
                int result=mapper.addOldManChargeArr(fOldManID,fManChargeID,fChargePrice,fNursingHomeID,fChargeStartTime,fOldManName);
                if(result<0){
                    throw new Exception("开始回滚");
                }
            }

        }catch (Exception e){
            logger.error("批量添加老人费用异常"+e.getMessage());
        }
    }

    /**
     * @Method: updChargeStatus
     * @Description: 批量修改老人收费状态
     * @Para: [String[] arr]
     * @Retun:
     * @Author: wangjs
     * @Date: 2017/3/10
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,rollbackFor={Exception.class})
    public void updChargeStatus(String[] arr){
        logger.debug("进入OldManChargeServiceImpl.updChargeStatus()方法");
        try{
            for(int i=0;i<arr.length;i++) {
                String[] temp=arr[i].split("=");
                String foldChargeStatus=temp[0];
                String fID=temp[1];
                String foldManID=temp[2];
                String fChargeStartTime=null;
                String fChargeEndTime=null;
                if(foldChargeStatus.equals("1")){
                    fChargeStartTime=temp[3];
                }else if(foldChargeStatus.equals("2")){
                    fChargeEndTime=temp[3];
                }
                int result=mapper.updChargeStatus(foldChargeStatus,fID,foldManID,fChargeStartTime,fChargeEndTime);
                if(result<0){
                    throw new Exception("开始回滚");
                }
            }
        }catch (Exception e){
            logger.error("批量修改老人费用状态异常"+e.getMessage());
        }
    }
}
