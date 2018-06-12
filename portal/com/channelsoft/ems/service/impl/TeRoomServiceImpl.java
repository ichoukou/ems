package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.TRoomMapper;
import com.channelsoft.ems.mapper.TeBedMapper;
import com.channelsoft.ems.po.TBedPo;
import com.channelsoft.ems.po.TRoomPo;
import com.channelsoft.ems.service.TeRoomService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangjs on 2016/12/4.
 */
@Service
public class TeRoomServiceImpl implements TeRoomService {

    private static Logger logger= Logger.getLogger(TeRoomServiceImpl.class);

    @Autowired
    private TRoomMapper mapper;

    @Autowired
    private TeBedMapper bedMapper;
    /**
     * @Method: queryCount
     * @Description: 查询房间总数
     * @Para: [TRoomPo]
     * @Retun: int
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public int queryCount(TRoomPo po){
        int dataCount=mapper.queryCount(po);
        logger.debug("查询房间总数:"+dataCount);
        return dataCount;
    }

    /**
     * @Method: queryRoom
     * @Description: 分页查询房间
     * @Para: [TRoomPo, page, pageSize]
     * @Retun: List<TRoomPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TRoomPo> queryRoom(TRoomPo po,int page,int pageSize) {
        logger.debug("进入TeRoomServiceImpl.queryRoom()方法");
        logger.debug("查询房间,查询参数："+po.toString());
        List<TRoomPo> roomList=mapper.queryRoom(po,page,pageSize);
        for (TRoomPo roomPo:roomList) {
            List<TBedPo> bedList=bedMapper.getBedByRoom(roomPo.getfID());
            for (TBedPo bedPo: bedList) {
               if("1".equals(bedPo.getfBedNumber()) || "A".equals(bedPo.getfBedNumber())){
                   roomPo.setfBedStatusA(bedPo.getfStatus());
               }else if("2".equals(bedPo.getfBedNumber()) || "B".equals(bedPo.getfBedNumber())){
                   roomPo.setfBedStatusB(bedPo.getfStatus());
               } else if("3".equals(bedPo.getfBedNumber()) || "C".equals(bedPo.getfBedNumber())){
                   roomPo.setfBedStatusC(bedPo.getfStatus());
               }else if("4".equals(bedPo.getfBedNumber()) || "D".equals(bedPo.getfBedNumber())){
                   roomPo.setfBedStatusD(bedPo.getfStatus());
               }else if("5".equals(bedPo.getfBedNumber()) || "E".equals(bedPo.getfBedNumber())){
                   roomPo.setfBedStatusE(bedPo.getfStatus());
               }else if("6".equals(bedPo.getfBedNumber()) || "F".equals(bedPo.getfBedNumber())){
                   roomPo.setfBedStatusF(bedPo.getfStatus());
               }

            }

        }
        logger.debug("查询房间,查询结果："+roomList.size());
        return roomList;
    }

    /**
     * @Method: getRoom
     * @Description: 查询房间
     * @Para: [TRoomPo]
     * @Retun: List<TRoomPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TRoomPo> getRoom(TRoomPo po) {
        logger.debug("进入TeRoomServiceImpl.getRoom()方法");
        logger.debug("查询房间,查询参数："+po.toString());
        List<TRoomPo> roomList=mapper.getRoom(po);
        logger.debug("查询房间(不分页),查询结果:"+roomList.size());
        return roomList;
    }

    /**
     * @Method: getLastRoom
     * @Description: 查询最后一间房间
     * @Para: [TRoomPo]
     * @Retun: List<TRoomPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TRoomPo> getLastRoom(TRoomPo po){
        logger.debug("进入TeRoomServiceImpl.getLastRoom()方法");
        logger.debug("查询房间,查询参数："+po.toString());
        List<TRoomPo> roomList=mapper.getLastRoom(po);
        logger.debug("查询房间,查询结果："+roomList.size());
        return roomList;
    }

    /**
     * @Method: addRoom
     * @Description: 添加房间
     * @Para: [TRoomPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,rollbackFor={Exception.class})
    public List<TRoomPo> addRoom(TRoomPo po) throws Exception{
        logger.debug("进入TeRoomServiceImpl.addRoom()方法");
        List<TRoomPo> lastRoom=null;
        int result=mapper.addRoom(po);
        if(result<0){
            throw new Exception("添加房间异常，开始回滚");
        }else{
            logger.debug("添加房间成功");
            lastRoom=mapper.getLastRoom(new TRoomPo());
            if(lastRoom==null){
                throw new Exception("查询新添加的房间异常，开始回滚");
            }
        }
        return lastRoom;
    }

    /**
     * @Method: updRoom
     * @Description: 修改房间
     * @Para: [TRoomPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updRoom(TRoomPo po) {
        logger.debug("进入TeRoomServiceImpl.updRoom()方法");
        try{
            mapper.updRoom(po);
            logger.debug("修改房间成功");
        }catch (Exception e){
            logger.error("修改房间异常:"+e.getMessage());
        }
    }

    /**
     * @Method: updRoomState
     * @Description: 修改房间状态
     * @Para: [TRoomPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updRoomState(TRoomPo po) {
        logger.debug("进入TeRoomServiceImpl.updRoomState()方法");
        try{
            mapper.updRoomState(po);
            logger.debug("修改房间状态成功");
        }catch (Exception e){
            logger.error("修改房间状态异常:"+e.getMessage());
        }
    }

    /**
     * @Method: delRoom
     * @Description: 删除房间
     * @Para: [TRoomPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void delRoom(TRoomPo po) {
        logger.debug("进入TeRoomServiceImpl.delRoom()方法");
        try{
            mapper.delRoom(po);
            logger.debug("删除房间成功");
        }catch (Exception e){
            logger.error("删除房间异常:"+e.getMessage());
        }
    }

}
