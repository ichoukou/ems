package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.PerfStandardMapper;
import com.channelsoft.ems.po.StandardPo;
import com.channelsoft.ems.service.PerfStandardService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张鑫 on 2016/12/18.
 */

@Service
public class PerfStandardServiceImpl implements PerfStandardService{
    private Logger logger = Logger.getLogger(PerfStandardServiceImpl.class);

    @Autowired
    private PerfStandardMapper standardMapper;

    public int addStandard(StandardPo standardPo) {
        try {
            logger.debug("进入增加" + standardPo);
            this.standardMapper.addStandard(standardPo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int deleteStandard(String fID) {
        logger.debug("进入deleteEmpMessage方法");
        try {
            logger.debug("删除账号"+fID);
            this.standardMapper.deleteStandard(fID);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("删除错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int updatePerfStandardList(StandardPo standardPo) {
        logger.debug("进入updateEmpMessage方法");
        try {
            logger.debug("进行更新"+standardPo);
            this.standardMapper.updatePerfStandardList(standardPo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int queryCount() {
        logger.debug("进入queryCount方法");
        int dataCount=standardMapper.queryCount();
        logger.debug("dataCount"+dataCount);
        return dataCount;
    }

    public List<StandardPo> queryList(int page, int pageSize) {
        logger.debug("进入queryList方法");
        logger.debug("查询参数：page:"+page+"pageSize:"+pageSize);
        List<StandardPo> standardList=standardMapper.queryList(page,pageSize);
        logger.debug("查询结果："+standardList.size());
        return standardList;
    }
}
