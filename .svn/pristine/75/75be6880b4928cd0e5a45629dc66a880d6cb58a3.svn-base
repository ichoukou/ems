package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.TeBedMapper;
import com.channelsoft.ems.po.TBedPo;
import com.channelsoft.ems.service.TeBedService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjs on 2016/12/12.
 */
@Service
public class TeBedServiceImpl implements TeBedService {

    private static Logger logger= Logger.getLogger(TeBedServiceImpl.class);

    @Autowired
    private TeBedMapper mapper;

    /**
     * @Method: queryCount
     * @Description: 查询床位总数
     * @Para: [TBedPo]
     * @Retun: int
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public int queryCount(TBedPo po){
        int dataCount=mapper.queryCount(po);
        logger.debug("查询床位总数:"+dataCount);
        return dataCount;
    }

    /**
     * @Method: queryBed
     * @Description: 分页查询床位
     * @Para: [TBedPo, page, pageSize]
     * @Retun: List<TBedPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TBedPo> queryBed(TBedPo po, int page, int pageSize) {
        logger.debug("进入TeBedServiceImpl.queryBed()方法");
        logger.debug("床位,查询参数："+po.toString());
        List<TBedPo> bedList=mapper.queryBed(po,page,pageSize);
        logger.debug("床位,查询结果："+bedList.size());
        return bedList;
    }

    /**
     * @Method: queryBedByRoom
     * @Description: 查询床位
     * @Para: [TBedPo]
     * @Retun: List<TBedPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TBedPo> queryBedByRoom(TBedPo po) {
        logger.debug("进入TeBedServiceImpl.queryBedByRoom()方法");
        logger.debug("床位,查询参数："+po.toString());
        List<TBedPo> bedList=mapper.queryBedByRoom(po);
        logger.debug("床位,查询结果："+bedList.size());
        return bedList;
    }

    /**
     * @Method: getBedByRoom
     * @Description: 查询床位
     * @Para: [TBedPo]
     * @Retun: List<TBedPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TBedPo> getBedByRoom(String roomId) {
        logger.debug("进入TeBedServiceImpl.getBedByRoom()方法");
        List<TBedPo> bedList=mapper.getBedByRoom(roomId);
        logger.debug("床位,查询结果："+bedList.size());
        return bedList;
    }

    /**
     * @Method: getBed
     * @Description: 查询床位
     * @Para: [TBedPo]
     * @Retun: List<TBedPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TBedPo> getBed(TBedPo po) {
        logger.debug("进入TeBedServiceImpl.getBed()方法");
        logger.debug("床位,查询参数："+po.toString());
        List<TBedPo> bedList=mapper.getBed(po);
        logger.debug("床位(不分页),查询结果："+bedList.size());
        return bedList;
    }

    /**
     * @Method: addBed
     * @Description: 添加床位
     * @Para: [TBedPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void addBed(TBedPo po) {
        logger.debug("进入TeBedServiceImpl.addBed()方法");
        try{
            mapper.addBed(po);
            logger.debug("添加床位成功");
        }catch (Exception e){
            logger.error("添加床位异常:"+e.getMessage());
        }
    }

    /**
     * @Method: updBedState
     * @Description: 修改床位状态
     * @Para: [TBedPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updBedState(TBedPo po) {
        logger.debug("进入TeBedServiceImpl.updBedState()方法");
        try{
            mapper.updBedState(po);
            logger.debug("修改床位状态成功");
        }catch (Exception e){
            logger.error("修改床位状态异常:"+e.getMessage());
        }
    }

    /**
     * @Method: updBedStateByRoom
     * @Description: 修改床位状态
     * @Para: [TBedPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updBedStateByRoom(TBedPo po) {
        logger.debug("进入TeBedServiceImpl.updBedStateByRoom()方法");
        try{
            mapper.updBedStateByRoom(po);
            logger.debug("修改床位状态成功");
        }catch (Exception e){
            logger.error("修改床位状态异常:："+e.getMessage());
        }
    }

    /**
     * @Method: updBed
     * @Description: 修改床位
     * @Para: [TBedPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updBed(TBedPo po) {
        logger.debug("进入TeBedServiceImpl.updBed()方法");
        try{
            mapper.updBed(po);
            logger.debug("修改床位成功");
        }catch (Exception e){
            logger.error("修改床位异常:"+e.getMessage());
        }
    }

    /**
     * @Method: delBed
     * @Description: 删除床位
     * @Para: [TBedPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void delBed(TBedPo po) {
        logger.debug("进入TeBedServiceImpl.delBed()方法");
        try{
            mapper.delBed(po);
            logger.debug("删除床位成功");
        }catch (Exception e){
            logger.error("删除床位异常:"+e.getMessage());
        }
    }
}
