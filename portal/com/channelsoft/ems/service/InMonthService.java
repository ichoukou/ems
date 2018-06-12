package com.channelsoft.ems.service;

import com.channelsoft.ems.po.InComeMonthPo;

import java.util.List;

/**
 * Created by zhangxin on 2017/3/3.
 */
public interface InMonthService {
    /**
     *@Description:查询 分页用
     *@Param:po
     * @Param:page
     * @param:pageSize
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public int queryCount(InComeMonthPo po);
    public List<InComeMonthPo> queryList(InComeMonthPo po, int page, int pageSize);
}
