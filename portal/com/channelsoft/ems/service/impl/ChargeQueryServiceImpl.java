package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.ChargeQueryMapper;
import com.channelsoft.ems.po.ChargeQueryPo;
import com.channelsoft.ems.service.ChargeQueryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangxin on 2017/3/7.
 */
@Service
public class ChargeQueryServiceImpl implements ChargeQueryService{
    private static Logger logger = Logger.getLogger(ChargeQueryServiceImpl.class);

    @Autowired
    private ChargeQueryMapper chargeQueryMapper;

    public int queryCount(ChargeQueryPo po) {
        logger.debug("进入queryCount方法");
        int dataCount=chargeQueryMapper.queryCount(po);
        logger.debug("dataCount"+dataCount);
        return dataCount;
    }

    public List<ChargeQueryPo> queryList(ChargeQueryPo po, int page, int pageSize) {
        logger.debug("进入queryList方法");
        logger.debug("查询参数："+po.toString()+"page:"+page+"pageSize:"+pageSize);
        List<ChargeQueryPo> chargeQueryList=chargeQueryMapper.queryList(po,page,pageSize);
        logger.debug("查询结果："+chargeQueryList.size());
        return chargeQueryList;
    }
}
