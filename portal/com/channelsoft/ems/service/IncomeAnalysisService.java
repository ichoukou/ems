package com.channelsoft.ems.service;


import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxing on 2017/3/6.
 */
public interface IncomeAnalysisService {
    /**
     * @description: 条件查询所有数据
     * @param date
     * @return Map<String,List<Object>>
     * @author liuxing
     * @date 2017年3月10日
     */
    public Map<String,List<Object>> queryIncomeAnalysisList(String date);
}
