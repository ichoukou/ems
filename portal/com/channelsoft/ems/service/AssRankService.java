package com.channelsoft.ems.service;

import com.channelsoft.ems.po.RankPo;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxin on 2016/11/24.
 */
public interface AssRankService {

    /**
    *@Description:在数据字典中得到项目
    *@Param:null
    *@return:list
    *@author:zhangxin
    *@Date:2017/3/13
    */

    public List<Map<String,String>> getDicname();
    /**
    *@Description:得到项目，及其项目所对应的分数
    *@Param:null
    *@return:list
    *@author:zhangxin
    *@Date:2017/3/13
    */

    public  List<RankPo> getFlevelNameValue();
    /**
    *@Description:根据sum和，求出该分数对应的定级
    *@Param:sum
    *@return:List
    *@author:zhangxin
    *@Date:2017/3/13
    */

    public List<Map<String,String>> getStatus(String sum);
    /**
    *@Description:新增
    *@Param:rankpo
    *@return:int
    *@author:zhangxin
    *@Date:2017/3/13
    */

    public int addSum(RankPo rankPo);
    /**
    *@Description:查询到数据库信息显示用
    *@Param:null
    *@return:List
    *@author:zhangxin
    *@Date:2017/3/13
    */
    public List<RankPo>  getFResultSum();
}

