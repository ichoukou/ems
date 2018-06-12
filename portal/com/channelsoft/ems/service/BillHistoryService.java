package com.channelsoft.ems.service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxin on 2017/3/1.
 */
public interface BillHistoryService {
    //获得老人所住的信息
    public List<Map<String,String>> getOldManMessage(String oldManId);
    //获得老人缴费信息
    public List<Map<String,String>> getOldManList(String oldManId, String searchEntryDate, String searchEndDate);
}
