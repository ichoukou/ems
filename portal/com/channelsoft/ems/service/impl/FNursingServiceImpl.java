package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.FNursingMapper;
import com.channelsoft.ems.po.FNursingPo;
import com.channelsoft.ems.service.FNursingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wuhl on 2017/2/14.
 */
@Service
public class FNursingServiceImpl implements FNursingService {

    private static Logger logger = Logger.getLogger(FNursingServiceImpl.class);

    @Autowired
    private FNursingMapper fNursingMapper;

    //查询养老院数量
    public int queryFNursingCount( FNursingPo param){
        logger.debug("进入FNursingServiceImpl类，c查询养老院总数");

        return this.fNursingMapper.queryFNursingCount(param);
    };

    //查询养老院数据
    public List<FNursingPo> queryFNursing(FNursingPo param, int page, int pageSize){
        logger.debug("进入FNursingServiceImpl类，查询养老院数据");

        return this.fNursingMapper.queryFNursing(param, page, pageSize);
    };

    public int start(FNursingPo param) {
        // TODO Auto-generated method stub
        try {
            logger.debug("启用养老院"+param);
            this.fNursingMapper.start(param);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("启用错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }

        return 0;

    }

    public int delete(FNursingPo param){
        // TODO Auto-generated method stub
        try {
            logger.debug("禁用养老院"+param);
            this.fNursingMapper.delete(param);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("禁用错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }

        return 0;

    };

    public int addFBursing(FNursingPo param) {
        // TODO Auto-generated method stub
        try {
            logger.debug("增加养老院"+param);
            this.fNursingMapper.addFBursing(param);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("增加错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }

        return 0;
    }

    public List<Map<String, String>> showFursing() {
        return this.fNursingMapper.showFursing();
    }

    public List<FNursingPo> queryStartFNursing(){

        return this.fNursingMapper.queryStartFNursing();
    };

    /**
     * @Method: getNusingHomeById
     * @Description: 根据ID查询养老院信息
     * @Para: [FNursingPo]
     * @Retun: List<FNursingPo>
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    public List<FNursingPo> getNusingHomeById(FNursingPo po){
        logger.debug("进入FNursingServiceImpl.getNusingHomeById()方法");
        return this.fNursingMapper.getNusingHomeById(po);
    };

    public List<FNursingPo> queryAllFNursing( ){

        return this.fNursingMapper.queryAllFNursing();
    };

    public int check(FNursingPo po){
        return this.fNursingMapper.check(po);
    };

    public int updateCheck(FNursingPo po){
        return this.fNursingMapper.updateCheck(po);
    };

    public int updateFBursing(FNursingPo po){
        // TODO Auto-generated method stub
        try {
            logger.debug("更新养老院"+po);
            this.fNursingMapper.updateFBursing(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }

        return 0;
    };


}
