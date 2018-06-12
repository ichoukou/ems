package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.BillHistoryMapper;
import com.channelsoft.ems.service.BillHistoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxin on 2017/3/1.
 */
@Service
public class BillHistoryImpl implements BillHistoryService {
    public static Logger logger = Logger.getLogger(BillHistoryImpl.class);

    @Autowired
    private BillHistoryMapper historyMapper;

    public List<Map<String, String>> getOldManMessage(String oldManId) {
        logger.debug("进入getOldManMessage()方法");
        return historyMapper.getOldManMessage(oldManId);
    }
    public List<Map<String,String>> getOldManList(String oldManId, String searchEntryDate, String searchEndDate){
        logger.debug("进入getOldManList()方法");
        return historyMapper.getOldManList(oldManId,searchEntryDate,searchEndDate);
    }
}
