package com.channelsoft.ems.service.impl;


import com.channelsoft.ems.mapper.ProviderManagerMapper;
import com.channelsoft.ems.po.ProviderPo;
import com.channelsoft.ems.service.ProviderManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangxin on 2016/12/27.
 */
@Service
public class ProviderManagerServiceImpl implements ProviderManagerService{

    private Logger logger=Logger.getLogger(ProviderManagerServiceImpl.class);

    @Autowired
    private ProviderManagerMapper managerMapper;

    public int addProviderManager(ProviderPo providerPo) {
        try {
            logger.debug("进入增加" + providerPo);
            this.managerMapper.addProviderManager(providerPo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
    public int deleteProviderManager(String fID) {
        logger.debug("进入deleteEmpMessage方法");
        try {
            logger.debug("删除账号"+fID);
            this.managerMapper.deleteProviderManager(fID);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("删除错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int queryCount(ProviderPo po) {
        logger.debug("进入queryCount方法");
        int dataCount = this.managerMapper.queryCount(po);
        logger.debug("dataCount"+dataCount);
        return dataCount;
    }

    public List<ProviderPo> queryList(ProviderPo po, int page, int pageSize) {
        logger.debug("进入queryList方法");
        logger.debug("查询参数："+po.toString()+"page:"+page+"pageSize:"+pageSize);
        List<ProviderPo> providerList=this.managerMapper.queryList(po,page,pageSize);
        logger.debug("查询结果："+providerList.size());
        return providerList;
    }

    public int updateProviderManager(ProviderPo providerPo) {
        logger.debug("进入updateEmpMessage方法");
        try {
            logger.debug("进行更新"+providerPo);
            this.managerMapper.updateProviderManager(providerPo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
    public int startState(ProviderPo po) {
        // TODO Auto-generated method stub
        try {
            logger.debug("启用账号"+po.getfID());
            this.managerMapper.startState(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("启用错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
