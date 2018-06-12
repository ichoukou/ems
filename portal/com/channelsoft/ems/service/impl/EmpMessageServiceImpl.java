package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.EmpMessageMapper;
import com.channelsoft.ems.po.MessagePo;
import com.channelsoft.ems.service.EmpMessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/6.
 */
@Service
public class EmpMessageServiceImpl implements EmpMessageService{

    private static Logger logger= Logger.getLogger(EmpMessageServiceImpl.class);

    @Autowired
    private EmpMessageMapper mapper;

    public int queryCount(MessagePo po) {
        logger.debug("进入queryCount方法");
        int dataCount=mapper.queryCount(po);
        logger.debug("dataCount"+dataCount);
        return dataCount;
    }

    public List<MessagePo> queryList(MessagePo po, int page, int pageSize) {
        logger.debug("进入queryList方法");
        logger.debug("查询参数："+po.toString()+"page:"+page+"pageSize:"+pageSize);
        List<MessagePo> messageList=mapper.queryList(po,page,pageSize);
        logger.debug("查询结果："+messageList.size());
        return messageList;
    }

    public List<MessagePo> getList(MessagePo po) {
        logger.debug("进入getList方法");
        logger.debug("查询参数："+po.toString());
        List<MessagePo> messageList=mapper.getList(po);
        logger.debug("查询结果："+messageList.size());
        return messageList;
    }
    public List<Map<String,String>> getDepartName(){
        logger.debug("进入getDepartName方法");
        return this.mapper.getDepartName();
    }

    public int addEmpList(MessagePo messagePo) {
        logger.debug("进入addEmpList方法");
        try {
            logger.debug("进入增加"+messagePo);
            this.mapper.addEmpList(messagePo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int deleteEmpMessage(String fId) {
        logger.debug("进入deleteEmpMessage方法");
        try {
            logger.debug("删除账号"+fId);
            this.mapper.deleteEmpMessage(fId);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("删除错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int startState(MessagePo po) {
        // TODO Auto-generated method stub
        try {
            logger.debug("启用账号"+po.getfId());
            this.mapper.startState(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("启用错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int updateEmpMessage(MessagePo messagePo) {
        logger.debug("进入updateEmpMessage方法");
        try {
            logger.debug("进行更新"+messagePo);
            this.mapper.updateEmpMessage(messagePo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
    public int updateUserMessage(MessagePo po) {
        logger.debug("进入updateUserMessage方法");
        try {
            logger.debug("进行更新"+po);
            this.mapper.updateUserMessage(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
