package com.channelsoft.ems.service;

import com.channelsoft.ems.po.LeavePo;

import java.util.List;

/**
 * Created by 张鑫 on 2016/12/7.
 */
public interface EmpLeaveService {
    /**
     *@Description:新增请假信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public int addEmpList(LeavePo leavePo);
    /**
     *@Description:根据id删除员工请假信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    public int deleteEmpLeave(String fId);
    /**
     *@Description:更新
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public int updateEmpLeaveList(LeavePo leavePo);
    /**
     *@Description:查询分页用
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    public int queryCount(LeavePo po);
    public List<LeavePo> queryList(LeavePo po, int page, int pageSize);
    /**
     *@Description:新增验证时间不重复
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public List<LeavePo> queryAddTime(LeavePo po);
    /**
     *@Description:更新验证时间不重复
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public List<LeavePo> queryUpdateTime(LeavePo po);
}
