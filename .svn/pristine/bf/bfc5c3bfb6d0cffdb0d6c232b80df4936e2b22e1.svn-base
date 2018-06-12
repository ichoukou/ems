package com.channelsoft.ems.service;

import com.channelsoft.ems.po.RolePo;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 张鑫
 * Created by Administrator on 2016/12/1.
 */
public interface RoleManageService {
    //计算总数，分页用
    public int getRolecount();
    //查询 显示用
    public List<RolePo> getFenRoleList(Integer page,Integer pageSize);
    //新增不能用户名不能重复
    public int check(RolePo rolePo);
    //更新不能重复
    public int updateCheck(RolePo po);
    //新增
    public int addRoleList(RolePo rolePo);
    //更新
    public int updateRoleList(RolePo rolePo);
    //禁用
    public int updateState(String id);
    //启用
    public int startState(RolePo po);
}
