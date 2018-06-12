package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.OldManLeaveMapper;
import com.channelsoft.ems.po.OldManLeavePo;
import com.channelsoft.ems.service.OldManLeaveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by wangjs on 2016/12/26.
 */
@Service
public class OldManLeaveServiceImpl implements OldManLeaveService {

    private Logger logger=Logger.getLogger(OldManLeaveServiceImpl.class);

    @Autowired
    private OldManLeaveMapper mapper;

    /**
     * @Method: queryCount
     * @Description: 查询老人请假总数
     * @Param: [OldManLeavePo]
     * @Return: int
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public int queryCount(OldManLeavePo po){
        int dataCount=mapper.queryCount(po);
        logger.debug("老人请假总数:"+dataCount);
        return dataCount;
    }

    /**
     * @Method: queryListByPage
     * @Description: 分页查询老人请假
     * @Param: [OldManLeavePo, page,pageSize]
     * @Return: com.channelsoft.ems.po.OldManLeavePo;
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<OldManLeavePo> queryListByPage(OldManLeavePo po,int page,int pageSize){
        logger.debug("进入OldManLeaveServiceImpl.queryList()方法");
        List<OldManLeavePo> getList=mapper.queryList(po,page,pageSize);
        logger.debug("查询老人请假，查询结果:"+getList.size());
        return getList;
    }

    /**
     * @Method: addOldManLeave
     * @Description: 老人请假
     * @param: [OldManLeavePo]
     * @Return: com.channelsoft.ems.po.OldManLeavePo;
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void addOldManLeave(OldManLeavePo po){
        logger.debug("进入OldManLeaveServiceImpl.addOldManLeave()方法");
        try{
            mapper.addOldManLeave(po);
            logger.debug("老人请假成功");
        }catch (Exception e){
            logger.error("添加老人请假异常"+e.getMessage());
        }
    }

    /**
     * @Method: addOldManLeave
     * @Description: 老人销假
     * @param: [OldManLeavePo]
     * @Return: com.channelsoft.ems.po.OldManLeavePo;
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updOldManLeave(OldManLeavePo po){
        logger.debug("进入OldManLeaveServiceImpl.updOldManLeave()方法");
        try{
            mapper.updOldManLeave(po);
            logger.debug("老人销假成功");
        }catch (Exception e){
            logger.error("老人销假异常"+e.getMessage());
        }
    }

    /**
     * @Method: addOldManLeave
     * @Description: 删除老人请假
     * @param: [OldManLeavePo]
     * @Return: com.channelsoft.ems.po.OldManLeavePo;
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void delOldManLeave(OldManLeavePo po){
        logger.debug("进入OldManLeaveServiceImpl.delOldManLeave()方法");
        try{
            mapper.delOldManLeave(po);
            logger.debug("删除老人请假成功");
        }catch (Exception e){
            logger.error("删除老人请假异常"+e.getMessage());
        }
    }

}
