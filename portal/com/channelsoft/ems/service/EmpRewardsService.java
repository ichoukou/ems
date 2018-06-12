package com.channelsoft.ems.service;

import com.channelsoft.ems.po.RewardsPo;

import java.util.List;

/**
 * Created by 张鑫 on 2016/12/15.
 */
public interface EmpRewardsService {
    /**
     *@Description:新增奖惩信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    public int addEmpRewards(RewardsPo rewardsPo);
    /**
     *@Description:删除奖惩信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    public int deleteEmpRewards(String fID);
    /**
     *@Description:更新请假信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    public int updateEmpRewards(RewardsPo rewardsPo);
    /**
     *@Description:查询分页用
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    public int queryCount(RewardsPo po);
    public List<RewardsPo> queryList(RewardsPo po, int page, int pageSize);
}
