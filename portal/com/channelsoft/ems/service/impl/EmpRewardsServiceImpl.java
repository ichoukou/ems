package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.EmpRewardsMapper;
import com.channelsoft.ems.po.RewardsPo;
import com.channelsoft.ems.service.EmpRewardsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张鑫 on 2016/12/15.
 */
@Service
public class EmpRewardsServiceImpl implements EmpRewardsService {
    private static Logger logger = Logger.getLogger(EmpRewardsServiceImpl.class);

    @Autowired
    private EmpRewardsMapper empRewardsMapper;

    public int queryCount(RewardsPo po) {
        logger.debug("进入queryCount方法");
        int dataCount=empRewardsMapper.queryCount(po);
        logger.debug("dataCount"+dataCount);
        return dataCount;
    }

    public List<RewardsPo> queryList(RewardsPo po, int page, int pageSize) {
        logger.debug("进入queryList方法");
        logger.debug("查询参数："+po.toString()+"page:"+page+"pageSize:"+pageSize);
        List<RewardsPo> rewardsList=empRewardsMapper.queryList(po,page,pageSize);
        logger.debug("查询结果："+rewardsList.size());
        return rewardsList;
    }

    public int addEmpRewards(RewardsPo rewardsPo) {
        try {
            logger.debug("进入增加" + rewardsPo);
            this.empRewardsMapper.addEmpRewards(rewardsPo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int deleteEmpRewards(String fID) {
        logger.debug("进入deleteEmpRewards方法");
        try {
            logger.debug("删除账号"+fID);
            this.empRewardsMapper.deleteEmpRewards(fID);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("删除错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int updateEmpRewards(RewardsPo rewardsPo) {
        logger.debug("进入updateEmpMessage方法");
        try {
            logger.debug("进行更新"+rewardsPo);
            this.empRewardsMapper.updateEmpRewards(rewardsPo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
