package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.IncomeAnalysisMapper;
import com.channelsoft.ems.po.ChargePo;
import com.channelsoft.ems.service.IncomeAnalysisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liuxing on 2017/3/6.
 */
@Service
public class IncomeAnalysisServiceImpl implements IncomeAnalysisService{
    private Logger logger=Logger.getLogger(IncomeAnalysisServiceImpl.class);
    @Autowired
    public IncomeAnalysisMapper mapper;

    public Map<String, List<Object>> queryIncomeAnalysisList(String date) {
        logger.debug("进入 queryIncomeAnalysisList 方法");
        List<Object> list=new ArrayList<Object>();
        Map<String,List<Object>> map=new HashMap<String, List<Object>>();
        List<Map<String, List<String>>> incomeList=new ArrayList<Map<String, List<String>>>();

        int year=Integer.parseInt(date.split("-")[0]);
        int month=Integer.parseInt(date.split("-")[1]);
        String lastDay=Integer.toString(year)+"-"+date.split("-")[1]+"-"+Integer.toString(getMonthLastDay(year,month));
        String lastDay2=Integer.toString(year)+"-"+"12"+"-"+"30";
        if(date.substring(0,date.lastIndexOf("-")).equals(new SimpleDateFormat("yyyy-MM").format(new Date())))
        {
            lastDay=new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        }
        if(date.split("-")[0].equals(new SimpleDateFormat("yyyy").format(new Date())))
        {
            lastDay2=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }

        //护理床位数
        list.add(mapper.getBedNumber());
        map.put("hlcw",list);


        //自然月天数
        list=new ArrayList<Object>();
        list.add("1");
        //本月
        list.add(Integer.toString(getMonthLastDay(year,month)));
        //本年
        list.add(Integer.toString(getallYearDays(year)));
        //上年度月累计
        list.add(Integer.toString(getMonthLastDay(year-1,month)));
        //上年度年累计
        list.add(Integer.toString(getallYearDays(year-1)));
        map.put("zryt",list);



        //已出租的床/晚数
        list=new ArrayList<Object>();
        //当日
        list.add(mapper.getTheSameDayBedNumber(date));
        //本月累计
        list.add(mapper.getTheSameMonthBedNumber(Integer.toString(year)+"-"+date.split("-")[1]+"-01",lastDay));
        //本年累计
        list.add(mapper.getTheSameMonthBedNumber(Integer.toString(year)+"-"+"01"+"-01",lastDay2));
        //上年度月累计
        list.add(mapper.getTheSameMonthBedNumber(Integer.toString(year-1)+"-"+date.split("-")[1]+"-01",Integer.toString(year-1)+"-"+date.split("-")[1]+"-"+Integer.toString(getMonthLastDay(year-1,month))));
        //上年度年累计
        list.add(mapper.getTheSameMonthBedNumber(Integer.toString(year-1)+"-"+"01"+"-01",Integer.toString(year-1)+"-"+"12"+"-"+"30"));

        map.put("sjcz",list);

        //床位收入
        list=new ArrayList<Object>();
        //当日
        list.add("");
        //本月累计
        list.add("");
        //本年累计
        list.add("");
        //上年度月累计
        list.add("");
        //上年度年累计
        list.add("");
        map.put("",list);
//护理
        //自理
        list=new ArrayList<Object>();
        //当日
        list.add(mapper.getTheSameDayNursingNumber(date,"自理"));
        if(mapper.getDaysNursingNumber(Integer.toString(year)+"-"+date.split("-")[1]+"-01",lastDay,"自理")==null)
        {
            //本月累计
            list.add("0");
            //本年累计
            list.add("0");
            //上年度月累计
            list.add("0");
            //上年度年累计
            list.add("0");
        }
        else{
            //本月累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year)+"-"+date.split("-")[1]+"-01",lastDay,"自理"));
            //本年累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year)+"-"+"01"+"-01",lastDay2,"自理"));
            //上年度月累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year-1)+"-"+date.split("-")[1]+"-01",Integer.toString(year-1)+"-"+date.split("-")[1]+"-"+Integer.toString(getMonthLastDay(year-1,month)),"自理"));
            //上年度年累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year-1)+"-"+"01"+"-01",Integer.toString(year-1)+"-"+"12"+"-"+"30","自理"));
        }
        map.put("zl",list);


        //介住
        list=new ArrayList<Object>();
        //当日
        list.add(mapper.getTheSameDayNursingNumber(date,"介住"));
        if(mapper.getDaysNursingNumber(Integer.toString(year)+"-"+date.split("-")[1]+"-01",lastDay,"介住")==null){
            //本月累计
            list.add("0");
            //本年累计
            list.add("0");
            //上年度月累计
            list.add("0");
            //上年度年累计
            list.add("0");

        }
        else {
            //本月累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year) + "-" + date.split("-")[1] + "-01", lastDay, "介住"));
            //本年累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year) + "-" + "01" + "-01", lastDay2, "介住"));
            //上年度月累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year - 1) + "-" + date.split("-")[1] + "-01", Integer.toString(year - 1) + "-" + date.split("-")[1] + "-" + Integer.toString(getMonthLastDay(year - 1, month)), "介住"));
            //上年度年累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year - 1) + "-" + "01" + "-01", Integer.toString(year - 1) + "-" + "12" + "-" + "30", "介住"));
        }
        map.put("jz",list);


        //介护
        list=new ArrayList<Object>();
        //当日
        list.add(mapper.getTheSameDayNursingNumber(date,"介护"));
        if(mapper.getDaysNursingNumber(Integer.toString(year)+"-"+date.split("-")[1]+"-01",lastDay,"介护")==null)
        {
            //本月累计
            list.add("0");
            //本年累计
            list.add("0");
            //上年度月累计
            list.add("0");
            //上年度年累计
            list.add("0");
        }
        else {
            //本月累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year) + "-" + date.split("-")[1] + "-01", lastDay, "介护"));
            //本年累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year) + "-" + "01" + "-01", lastDay2, "介护"));
            //上年度月累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year - 1) + "-" + date.split("-")[1] + "-01", Integer.toString(year - 1) + "-" + date.split("-")[1] + "-" + Integer.toString(getMonthLastDay(year - 1, month)), "介护"));
            //上年度年累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year - 1) + "-" + "01" + "-01", Integer.toString(year - 1) + "-" + "12" + "-" + "30", "介护"));
        }
        map.put("jh",list);


        //全护
        list=new ArrayList<Object>();
        //当日
        list.add(mapper.getTheSameDayNursingNumber(date,"全护"));
        if(mapper.getDaysNursingNumber(Integer.toString(year) + "-" + date.split("-")[1] + "-01", lastDay, "全护")==null)
        {
            //本月累计
            list.add("0");
            //本年累计
            list.add("0");
            //上年度月累计
            list.add("0");
            //上年度年累计
            list.add("0");
        }
        else {
            //本月累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year) + "-" + date.split("-")[1] + "-01", lastDay, "全护"));
            //本年累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year) + "-" + "01" + "-01", lastDay2, "全护"));
            //上年度月累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year - 1) + "-" + date.split("-")[1] + "-01", Integer.toString(year - 1) + "-" + date.split("-")[1] + "-" + Integer.toString(getMonthLastDay(year - 1, month)), "全护"));
            //上年度年累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year - 1) + "-" + "01" + "-01", Integer.toString(year - 1) + "-" + "12" + "-" + "30", "全护"));
        }
        map.put("qh",list);

        //特护
        list=new ArrayList<Object>();
        //当日

        list.add(mapper.getTheSameDayNursingNumber(date,"特护"));
        if(mapper.getDaysNursingNumber(Integer.toString(year) + "-" + date.split("-")[1] + "-01", lastDay, "特护")==null)
        {
            //本月累计
            list.add("0");
            //本年累计
            list.add("0");
            //上年度月累计
            list.add("0");
            //上年度年累计
            list.add("0");
        }
        else {
            //本月累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year) + "-" + date.split("-")[1] + "-01", lastDay, "特护"));
            //本年累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year) + "-" + "01" + "-01", lastDay2, "特护"));
            //上年度月累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year - 1) + "-" + date.split("-")[1] + "-01", Integer.toString(year - 1) + "-" + date.split("-")[1] + "-" + Integer.toString(getMonthLastDay(year - 1, month)), "特护"));
            //上年度年累计
            list.add(mapper.getDaysNursingNumber(Integer.toString(year - 1) + "-" + "01" + "-01", Integer.toString(year - 1) + "-" + "12" + "-" + "30", "特护"));
        }
        map.put("th",list);


    //各种费用的查询
        List<ChargePo> chargePoList=mapper.getchargeList();
        List<Object> list2=new ArrayList<Object>();
        for (ChargePo po:chargePoList) {
            list=new ArrayList<Object>();
            list.add(po.getfChrgeName());
            //当日
            list.add(mapper.getDaysPayment(date,date+" 23:59:59",po.getfID()));
            //本月累计
            list.add(mapper.getDaysPayment(Integer.toString(year) + "-" + date.split("-")[1] + "-01",lastDay+" 23:59:59",po.getfID()));
            //本年累计
            list.add(mapper.getDaysPayment(Integer.toString(year) + "-" + "01" + "-01",lastDay2+" 23:59:59",po.getfID()));
            //上年度月累计
            list.add(mapper.getDaysPayment(Integer.toString(year-1) + "-" + date.split("-")[1] + "-01",Integer.toString(year - 1) + date.split("-")[1] + "-" + Integer.toString(getMonthLastDay(year - 1, month))+" 23:59:59",po.getfID()));
            //上年度年累计
            list.add(mapper.getDaysPayment(Integer.toString(year-1) + "-" + "01" + "-01",Integer.toString(year - 1) + "-" + "12" + "-" + "30"+" 23:59:59",po.getfID()));
            list2.add(list);
        }
        map.put("sfbz",list2);
        return map;
    }

    public static int getMonthLastDay(int year, int month)
    {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }
    public static int getallYearDays(int year)
    {
        if (((year % 100 == 0) && year % 400 == 0) || ((year % 100 != 0) && year % 4 == 0))
        {
            return 366;
        }
        else
        {
            return 365;
        }
    }
}
