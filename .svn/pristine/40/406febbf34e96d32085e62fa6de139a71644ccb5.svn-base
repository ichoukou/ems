package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.RoleManageMapper;
import com.channelsoft.ems.po.RolePo;
import com.channelsoft.ems.service.RoleManageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 张鑫
 * Created by Administrator on 2016/12/1.
 */
@Service
public class RoleManageImpl implements RoleManageService {
    private Logger logger = Logger.getLogger(RoleManageImpl.class);
    @Autowired
    private RoleManageMapper roleManageMapper;

    /**
     * 得到列表
     *
     * @return
     */
    public int getRolecount() {
        int roleCount=roleManageMapper.getRolecount();
        logger.debug("roleCount"+roleCount);
        return roleCount;
    }

    public List<RolePo> getFenRoleList(Integer page, Integer pageSize) {
        logger.debug("进入getFenRoleList方法");
        logger.debug("查询参数："+"page="+page+"pageSize"+pageSize);
        return roleManageMapper.getFenRoleList(page, pageSize);
    }

    /**
     * 添加用户
     *
     * @param rolePo
     */
    public int addRoleList(RolePo rolePo) {
        try {
            logger.debug("进入增加" + rolePo);
            this.roleManageMapper.addRoleList(rolePo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    /**
     * 修改
     * @param rolePo
     * @return
     */
    public int updateRoleList(RolePo rolePo) {
        try {
            logger.debug("进行更新"+rolePo);
            this.roleManageMapper.updateRoleList(rolePo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }

        return 0;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int updateState(String id) {
        try {
            logger.debug("进行更新"+id);
            this.roleManageMapper.updateState(id);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int check(RolePo rolePo) {
        try{
            int result=roleManageMapper.check(rolePo);
            return result;
        }catch(Exception e){
            logger.debug("校验的sql执行失败");
            return -1;
        }
    }

    public int updateCheck(RolePo po){
        return this.roleManageMapper.updateCheck(po);
    };


    public int startState(RolePo po) {
        // TODO Auto-generated method stub
        try {
            logger.debug("启用账号"+po.getId());
            this.roleManageMapper.startState(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("启用错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
