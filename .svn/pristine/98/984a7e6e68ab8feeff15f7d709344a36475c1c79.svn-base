package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.TFoorMapper;
import com.channelsoft.ems.po.TFloorPo;
import com.channelsoft.ems.service.TeFloorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjs on 2016/12/4.
 */
@Service
public class TeFloorServiceImpl implements TeFloorService {

    private static Logger logger= Logger.getLogger(TeFloorService.class);

    @Autowired
    private TFoorMapper mapper;

    /**
     * @Method: queryFloor
     * @Description: 分页查询楼层
     * @Para: [TFloorPo,page,pageSize]
     * @Retun: List<TFloorPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TFloorPo> queryFloor(TFloorPo po,int page,int pageSize) {
        logger.debug("进入TeFloorServiceImpl.queryBuilding()方法");
        logger.debug("楼层，查询参数："+po.toString());
        List<TFloorPo> floorList=mapper.queryFloor(po,page,pageSize);
        logger.debug("楼层，查询结果："+floorList.size());
        return floorList;
    }

    /**
     * @Method: getFloor
     * @Description: 查询楼层
     * @Para: [TFloorPo]
     * @Retun: List<TFloorPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TFloorPo> getFloor(TFloorPo po) {
        logger.debug("进入TeFloorServiceImpl.getFloor()方法");
        logger.debug("查询参数："+po.toString());
        List<TFloorPo> floorList=mapper.getFloor(po);
        logger.debug("楼层（不分页），查询结果："+floorList.size());
        return floorList;
    }

    /**
     * @Method: queryTreeFloor
     * @Description: 查询楼层
     * @Para: [TFloorPo]
     * @Retun: List<TFloorPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TFloorPo> queryTreeFloor() {
        logger.debug("进入TeFloorServiceImpl.queryTreeFloor()方法");
        List<TFloorPo> floorList=mapper.queryTreeFloor();
        logger.debug("菜单树楼层，查询结果："+floorList.size());
        return floorList;
    }

    /**
     * @Method: addFloor
     * @Description: 添加楼层
     * @Para: [TFloorPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void addFloor(TFloorPo po) {
        logger.debug("进入TeFloorServiceImpl.addFloor()方法");
        try{
            mapper.addFloor(po);
            logger.debug("添加楼层成功");
        }catch (Exception e){
            logger.error("添加楼层异常::"+e.getMessage());
        }
    }

    /**
     * @Method: updFloor
     * @Description: 修改楼层
     * @Para: [TFloorPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updFloor(TFloorPo po) {
        logger.debug("进入TeFloorServiceImpl.updFloor()方法");
        try{
            mapper.updFloor(po);
            logger.debug("修改楼层成功");
        }catch (Exception e){
            logger.error("修改楼层异常:"+e.getMessage());
        }
    }

    /**
     * @Method: updStateFloor
     * @Description: 修改楼层状态
     * @Para: [TFloorPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updStateFloor(TFloorPo po) {
        logger.debug("进入TeFloorServiceImpl.updStateFloor()方法");
        try{
            mapper.updStateFloor(po);
            logger.debug("修改楼层状态成功");
        }catch (Exception e){
            logger.error("修改楼层状态异常:"+e.getMessage());
        }
    }

    /**
     * @Method: delFloor
     * @Description: 删除楼层
     * @Para: [TFloorPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void delFloor(TFloorPo po) {
        logger.debug("进入TeFloorServiceImpl.delFloor()方法");
        try{
            mapper.delFloor(po);
            logger.debug("删除楼层成功");
        }catch (Exception e){
            logger.error("删除楼层异常:"+e.getMessage());
        }
    }

}
