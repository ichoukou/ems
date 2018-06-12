package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.PerfMaintainMapper;
import com.channelsoft.ems.po.PerfMaintainPo;
import com.channelsoft.ems.service.PerfMaintainService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by 张鑫 on 2016/12/19.
 */
@Service
public class PerfMaintainServiceImpl implements PerfMaintainService{

    private Logger logger=Logger.getLogger(PerfMaintainServiceImpl.class);

    @Autowired
    private PerfMaintainMapper maintainMapper;

    public List<Map<String,String>> getDCname(){
        logger.debug("进入getDCname()方法");
        return this.maintainMapper.getDCname();
    }

    public List<Map<String,String>> getResult(String sum) {
        logger.debug("进入getResult()方法");
        return this.maintainMapper.getResult(sum);
    }

    public int addParentTable(PerfMaintainPo maintainPo) {
        try {
            logger.debug("进入增加" + maintainPo);
            this.maintainMapper.addParentTable(maintainPo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int queryCount(PerfMaintainPo po) {
        logger.debug("进入queryCount方法");
        int dataCount= this.maintainMapper.queryCount(po);
        logger.debug("dataCount"+dataCount);
        return dataCount;
    }

    public List<PerfMaintainPo> queryList(PerfMaintainPo po, int page, int pageSize) {
        logger.debug("进入queryList方法");
        logger.debug("查询参数："+po.toString()+"page:"+page+"pageSize:"+pageSize);
        List<PerfMaintainPo> maintainList= this.maintainMapper.queryList(po,page,pageSize);
        logger.debug("查询结果："+maintainList.size());
        return maintainList;
    }

    public String queryFID() {
        logger.debug("进入queryFID方法");
        String fId=this.maintainMapper.queryFID();
        logger.debug("查询结果："+fId);
        return fId;
    }
    //根据FNumber得到子表分数，FID
    public  List<Map<String,String>> queryScore(String fNumber){
        logger.debug("进入queryScore方法");
        return this.maintainMapper.queryScore(fNumber);
    }

    public int insertID(String[] nowFproject, String[] nowScore, PerfMaintainPo po,String fId) {
        // TODO Auto-generated method stub
        logger.debug("插入信息:");
        try{
            this.maintainMapper.insertID(nowFproject, nowScore, po,fId);
        }catch (Exception e){
            logger.debug(e.getMessage());
            e.printStackTrace();
            logger.debug("添加子表信息失败");
            return 1;
        }
        return 0;
    }
    //更新主表
    public int updateMainMaintain(PerfMaintainPo po) {
        logger.debug("进入updateMainMaintain方法");
        try {
            logger.debug("进行更新"+po);
            this.maintainMapper.updateMainMaintain(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    //更新子表
    public int updateMaintainList(String[] fId ,String nowScore[],PerfMaintainPo po,String[] nowIdFproject) {
        logger.debug("进入updateMainMaintain方法");
        try {
            logger.debug("进行更新"+po);
            this.maintainMapper.updateMaintainList(fId,nowScore,po,nowIdFproject);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
    //删除父亲表 字表
    @Transactional(rollbackFor=Exception.class)
    public int deleteMaintain(PerfMaintainPo po){
        try {
            //更新主表
            this.maintainMapper.deleteMaintain(po);

            //删除从表
            this.maintainMapper.deleteMaintainEntry(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

}
