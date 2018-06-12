package com.channelsoft.ems.service;

import com.channelsoft.ems.po.MessagePo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by 张鑫 on 2016/12/6.
 */
public interface EmpMessageService {
    /**
    *@Description:查询 显示 分页用
    *@Param:MessagePo
    *@return:int
    *@author:zhangxin
    *@Date:2017/3/13
    */
    public int queryCount(MessagePo po);
    public List<MessagePo> queryList(MessagePo po,int page,int pageSize);
    /**
    *@Description:查询不带分页
    *@Param:MessagePo
    *@return:list
    *@author:wjs
    *@Date:2017/3/13
    */

    public List<MessagePo> getList(MessagePo po);
    /**
    *@Description:得到部门信息
    *@Param:null
    *@return:list
    *@author:zhangxin
    *@Date:2017/3/13
    */

    public List<Map<String,String>> getDepartName();
    /**
    *@Description:新增
    *@Param:messagePo
    *@return:int
    *@author:zhangxin
    *@Date:2017/3/13
    */

    public int addEmpList(MessagePo messagePo);
    //禁用
    public int deleteEmpMessage(String fId);
    //启用
    public int startState(MessagePo po);

    /**
    *@Description:更新
    *@Param:messagePo
    *@return:int
    *@author:zhangxin
    *@Date:2017/3/13
    */

    public int updateEmpMessage(MessagePo messagePo);

    /**
    *@Description:更新用户养老院信息
    *@Param:messagePo
    *@return:int
    *@author:zhangxin
    *@Date:2017/3/13
    */

    public int updateUserMessage(MessagePo po);
}
