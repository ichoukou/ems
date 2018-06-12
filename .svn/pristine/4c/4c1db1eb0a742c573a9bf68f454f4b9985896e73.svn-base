package com.channelsoft.ems.service;

import com.channelsoft.ems.po.ProviderPo;

import java.util.List;

/**
 * Created by zhangxin on 2016/12/27.
 */
public interface ProviderManagerService {
    /**
    *@Description:新增
    *@Param:po
    *@return:int
    *@author:zhangxin
    *@Date:2017/3/13
    */

    public int addProviderManager(ProviderPo providerPo);
    //禁用
    public int deleteProviderManager(String fID);
    //启用
    public int startState(ProviderPo po);
    /**
     *@Description:更新
     *@Param:po
     *@return:int
     *@author:zhangxin
     *@Date:2017/3/13
     */
    public int updateProviderManager(ProviderPo providerPo);
    /**
     *@Description:查询分页用
     *@Param:po
     *@return:int
     *@author:zhangxin
     *@Date:2017/3/13
     */
    public int queryCount(ProviderPo po);
    public List<ProviderPo> queryList(ProviderPo po, int page, int pageSize);
}
