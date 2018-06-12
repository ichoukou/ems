package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.InMonthMapper;
import com.channelsoft.ems.po.InComeMonthPo;
import com.channelsoft.ems.service.InMonthService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangxin on 2017/3/3.
 */
@Service
public class InMonthServiceImpl implements InMonthService {
    public static Logger logger = Logger.getLogger(InMonthServiceImpl.class);

    @Autowired
    private InMonthMapper monthMapper;

    public int queryCount(InComeMonthPo po) {
        logger.debug("进入queryCount()方法");
        return monthMapper.queryCount(po);
    }

    public List<InComeMonthPo> queryList(InComeMonthPo po, int page, int pageSize) {
        logger.debug("进入queryList()方法");
        List<InComeMonthPo> list = monthMapper.OldmanList(po,page,pageSize);
        logger.debug("List"+list);
        return list;
    }
}
