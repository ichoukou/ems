package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.EmpLeaveMapper;
import com.channelsoft.ems.mapper.EmpMessageMapper;
import com.channelsoft.ems.mapper.RoleManageMapper;
import com.channelsoft.ems.po.LeavePo;
import com.channelsoft.ems.service.EmpLeaveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 张鑫 on 2016/12/7.
 */
@Service
public class EmpLeaveServiceImpl implements EmpLeaveService {
    private Logger logger = Logger.getLogger(EmpLeaveServiceImpl.class);
    @Autowired
    private EmpLeaveMapper empLeaveMapper;

    public int queryCount(LeavePo po) {
        logger.debug("进入queryCount方法");
        int dataCount=empLeaveMapper.queryCount(po);
        logger.debug("dataCount"+dataCount);
        return dataCount;
    }

    public List<LeavePo> queryList(LeavePo po, int page, int pageSize) {
        logger.debug("进入queryList方法");
        logger.debug("查询参数："+po.toString()+"page:"+page+"pageSize:"+pageSize);
        List<LeavePo> leaveList=empLeaveMapper.queryList(po,page,pageSize);
        logger.debug("查询结果："+leaveList.size());
        return leaveList;
    }

    public int addEmpList(LeavePo leavePo) {
        try {
            logger.debug("进入增加" + leavePo);
            this.empLeaveMapper.addEmpList(leavePo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int deleteEmpLeave(String fId) {
        logger.debug("进入deleteEmpMessage方法");
        try {
            logger.debug("删除账号"+fId);
            this.empLeaveMapper.deleteEmpLeave(fId);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("删除错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int updateEmpLeaveList(LeavePo leavePo) {
        logger.debug("进入updateEmpMessage方法");
        try {
            logger.debug("进行更新"+leavePo);
            this.empLeaveMapper.updateEmpLeaveList(leavePo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public List<LeavePo> queryAddTime(LeavePo po) {
        logger.debug("进入queryAddTime方法");
        logger.debug("查询参数："+po.toString());
        List<LeavePo> timeList=empLeaveMapper.queryAddTime(po);
        logger.debug("查询结果："+timeList.size());
        return timeList;
    }
    public List<LeavePo> queryUpdateTime(LeavePo po){
        logger.debug("进入queryUpdateTime方法");
        logger.debug("查询参数："+po.toString());
        List<LeavePo> timeList=empLeaveMapper.queryUpdateTime(po);
        logger.debug("查询结果："+timeList.size());
        return timeList;
    }
}
