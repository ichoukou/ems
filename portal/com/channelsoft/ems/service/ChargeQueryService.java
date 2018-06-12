package com.channelsoft.ems.service;

import com.channelsoft.ems.po.ChargeQueryPo;

import java.util.List;

/**
 * Created by zhangxin on 2017/3/7.
 */
public interface ChargeQueryService {
    /**
     *@Description:根据老人ID 日期 查询信息
     *@Param:oldManId
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    public int queryCount(ChargeQueryPo po);
    public List<ChargeQueryPo> queryList(ChargeQueryPo po, int page, int pageSize);
}
