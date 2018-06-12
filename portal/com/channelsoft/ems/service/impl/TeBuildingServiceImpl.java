package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.TBuildingMapper;
import com.channelsoft.ems.po.TBuildingPo;
import com.channelsoft.ems.service.TeBuildingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangjs on 2016/12/4.
 */
@Service
public class TeBuildingServiceImpl implements TeBuildingService {

    private static Logger logger= Logger.getLogger(TeBuildingService.class);

    @Autowired
    private TBuildingMapper mapper;

    /**
     * @Method: queryCount
     * @Description: 查询大厦总数
     * @Para: [TBuildingPo]
     * @Retun: int
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public int queryCount(TBuildingPo po){
        int dataCount=mapper.queryCount(po);
        logger.debug("查询大厦总数："+dataCount);
        return dataCount;
    }

    /**
     * @Method: queryBuilding
     * @Description: 分页查询大厦
     * @Para: [TBuildingPo po,int page,int pageSize]
     * @Retun: List<TBuildingPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TBuildingPo> queryBuilding(TBuildingPo po,int page,int pageSize) {
        logger.debug("进入TeBuildingServiceImpl.queryBuilding()方法");
        logger.debug("查询参数："+po.toString());
        List<TBuildingPo> buildingList=mapper.queryBuilding(po,page,pageSize);
        logger.debug("查询大厦，查询结果："+buildingList.size());
        return buildingList;
    }

    /**
     * @Method: getBuilding
     * @Description: 查询大厦
     * @Para: [TBuildingPo]
     * @Retun: List<TBuildingPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TBuildingPo> getBuilding(TBuildingPo po) {
        logger.debug("TeBuildingServiceImpl.getBuilding()方法");
        logger.debug("查询参数："+po.toString());
        List<TBuildingPo> buildingList=mapper.getBuilding(po);
        logger.debug("查询大厦（不分页）查询结果："+buildingList.size());
        return buildingList;
    }

    /**
     * @Method: queryTreeBuilding
     * @Description: 查询大厦
     * @Para: [TBuildingPo]
     * @Retun: List<TBuildingPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<TBuildingPo> queryTreeBuilding() {
        logger.debug("TeBuildingServiceImpl.queryTreeBuilding()方法");
        List<TBuildingPo> buildingList=mapper.queryTreeBuilding();
        logger.debug("tree查询结果："+buildingList.size());
        return buildingList;
    }

    /**
     * @Method: addBuilding
     * @Description: 添加大厦
     * @Para: [TBuildingPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void addBuilding(TBuildingPo po) {
        logger.debug("TeBuildingServiceImpl.addBuilding()方法");
        try{
            mapper.addBuilding(po);
            logger.debug("添加大厦成功");
        }catch (Exception e){
            logger.error("添加大厦异常:"+e.getMessage());
        }
    }

    /**
     * @Method: updBuilding
     * @Description: 修改大厦
     * @Para: [TBuildingPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updBuilding(TBuildingPo po) {
        logger.debug("TeBuildingServiceImpl.updBuilding()方法");
        try{
            mapper.updBuilding(po);
            logger.debug("修改大厦成功");
        }catch (Exception e){
            logger.error("修改大厦异常:"+e.getMessage());
        }
    }

    /**
     * @Method: delBuilding
     * @Description: 删除大厦
     * @Para: [TBuildingPo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void delBuilding(TBuildingPo po) {
        logger.debug("TeBuildingServiceImpl.updBuilding()方法");
        try{
            mapper.delBuilding(po);
            logger.debug("删除大厦成功");
        }catch (Exception e){
            logger.error("删除大厦异常:"+e.getMessage());
        }
    }

}
