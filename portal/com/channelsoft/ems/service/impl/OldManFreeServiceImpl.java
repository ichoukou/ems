package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.OldManFreeMapper;
import com.channelsoft.ems.po.OldManFreePo;
import com.channelsoft.ems.service.OldManFreeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjs on 2016/12/29.
 */
@Service
public class OldManFreeServiceImpl implements OldManFreeService{

    private Logger logger=Logger.getLogger(OldManLeaveServiceImpl.class);

    @Autowired
    private OldManFreeMapper mapper;

    /**
     * @Method: queryCount
     * @Description: 查询单据删除
     * @Para: [OldManFreePo,startTime,stopTime]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public int queryCount(OldManFreePo po,String startTime,String stopTime){
        int dataCount=mapper.queryCount(po,startTime,stopTime);
        logger.debug("减免单据总数:"+dataCount);
        return dataCount;
    }

    /**
     * @Method: queryList
     * @Description: 分页查询单据
     * @Para: [OldManFreePo,page, pageSize,startTime,stopTime]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<OldManFreePo> queryList(OldManFreePo po, int page, int pageSize,String startTime,String stopTime){
        logger.debug("进入OldManLeaveServiceImpl.queryList()方法");
        List<OldManFreePo> getList=mapper.queryList(po,page,pageSize,startTime,stopTime);
        logger.debug("减免单据，查询结果:"+getList.size());
        return getList;
    }

    /**
     * @Method: queryLastFree
     * @Description: 查询最后一条单据
     * @Para: [OldManFreePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    public List<OldManFreePo> queryLastFree(OldManFreePo po){
        logger.debug("进入OldManLeaveServiceImpl.queryLastFree()方法");
        List<OldManFreePo> getList=mapper.queryLastFree(po);
        logger.debug("减免单据，查询结果:"+getList.size());
        return getList;
    }

    /**
     * @Method: addOldManFree
     * @Description: 添加减免单据
     * @Para: [OldManFreePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void addOldManFree(OldManFreePo po){
        logger.debug("进入OldManLeaveServiceImpl.addOldManFree()方法");
        try{
            mapper.addOldManFree(po);
            logger.debug("添加减免单据成功");
        }catch (Exception e){
            logger.error("添加减免单据异常:"+e.getMessage());
        }
    }

    /**
     * @Method: updOldManFree
     * @Description: 更新单据删除
     * @Para: [OldManFreePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updOldManFree(OldManFreePo po){
        logger.debug("进入OldManLeaveServiceImpl.updOldManFree()方法");
        try{
            mapper.updOldManFree(po);
            logger.debug("修改减免单据成功");
        }catch (Exception e){
            logger.error("修改减免单据异常:"+e.getMessage());
        }
    }

    /**
     * @Method: delOldManFree
     * @Description: 减免单据删除
     * @Para: [OldManFreePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void delOldManFree(OldManFreePo po){
        logger.debug("进入OldManLeaveServiceImpl.delOldManFree()方法");
        try{
            mapper.delOldManFree(po);
            logger.debug("删除减免单据成功");
        }catch (Exception e){
            logger.error("删除减免单据异常:"+e.getMessage());
        }
    }
}
