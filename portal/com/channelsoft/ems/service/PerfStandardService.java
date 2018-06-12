package com.channelsoft.ems.service;

import com.channelsoft.ems.po.StandardPo;

import java.util.List;

/**
 * Created by 张鑫 on 2016/12/18.
 */
public interface PerfStandardService {
    /**
     *@Description:新增
     *@Param:StandardPo
     *@return:int
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public int addStandard(StandardPo standardPo);
    /**
     *@Description:删除
     *@Param:fID
     *@return:int
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public int deleteStandard(String fID);
    /**
    *@Description:更新
    *@Param:StandardPo
    *@return:int
    *@author:zhangxin
    *@Date:2017/3/13
    */

    public int updatePerfStandardList(StandardPo standardPo);
    /**
     *@Description:查询分页用
     *@Param:StandardPo
     *@return:int
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public int queryCount();
    public List<StandardPo> queryList(int page, int pageSize);
}
