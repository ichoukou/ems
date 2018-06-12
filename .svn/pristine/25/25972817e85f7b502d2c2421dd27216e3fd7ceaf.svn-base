package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.OldManHosingMapper;
import com.channelsoft.ems.po.OldManMainPo;
import com.channelsoft.ems.service.OldManHosingService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjs on 2016/12/15.
 */
@Service
public class OldManHosingServiceImpl implements OldManHosingService {

    private Logger logger=Logger.getLogger(OldManHosingServiceImpl.class);

    @Autowired
    private OldManHosingMapper mapper;

    /**
     * @Method: queryCount
     * @Description: 查询老人总数
     * @Para: [OldManMainPo,startTime,stopTime]
     * @Retun: int
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public int queryCount(OldManMainPo po,String startTime,String stopTime){
        int dataCount=mapper.queryCount(po,startTime,stopTime);
        logger.debug("查询老人总数"+dataCount);
        return dataCount;
    }

    /**
     * @Method: queryCountByState
     * @Description: 查询状态是在院和请假的老人总数
     * @Para: [OldManMainPo,startTime,stopTime]
     * @Retun: int
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public int queryCountByState(OldManMainPo po){
        int dataCount=mapper.queryCountByState(po);
        logger.debug("查询状态是在院和请假的老人总数"+dataCount);
        return dataCount;
    }

    /**
     * @Method: queryList
     * @Description: 分页查询老人基本信息
     * @Para: [OldManFreePo,page,pageSize,startTime,stopTime]
     * @Retun: List<OldManMainPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<OldManMainPo> queryList(OldManMainPo po,int page,int pageSize,String startTime,String stopTime){
        logger.debug("进入OldManHosingServiceImpl.queryList()方法,po:"+po);
        List<OldManMainPo> oldMan=new ArrayList<OldManMainPo>();
        try{
            oldMan=mapper.queryList(po,page,pageSize,startTime,stopTime);
            logger.debug("分页查询老人基本信息，查询结果:"+oldMan.size());
        }catch (Exception e){
            logger.error("查询失败",e);
        }
        return oldMan;
    }

    /**
     * @Method: queryOldManMainByState
     * @Description: 根据状态分页查询老人基本信息
     * @Para: [OldManFreePo,page,pageSize,startTime,stopTime]
     * @Retun: List<OldManMainPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<OldManMainPo> queryOldManMainByState(OldManMainPo po,int page,int pageSize,String startTime,String stopTime){
        logger.debug("进入OldManHosingServiceImpl.queryOldManMainByState()方法,po:"+po);
        List<OldManMainPo> oldMan=new ArrayList<OldManMainPo>();
        try{
            oldMan=mapper.queryOldManMainByState(po,page,pageSize,startTime,stopTime);
            logger.debug("根据状态分页查询老人基本信息，查询结果:"+oldMan.size());
        }catch (Exception e){
            logger.error("查询失败",e);
        }
        return oldMan;
    }

    /**
     * @Method: getOldManRoom
     * @Description: 查询老人房间
     * @Para: [OldManFreePo]
     * @Retun: List<OldManMainPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<OldManMainPo> getOldManRoom(OldManMainPo po){
        logger.debug("进入OldManHosingServiceImpl.getOldManRoom()方法,po:"+po);
        List<OldManMainPo> oldMan=mapper.getOldManRoom(po);
        logger.debug("查询结果:"+oldMan.size());
        return oldMan;
    }

    /**
     * @Method: getomList
     * @Description: 查询老人基本信息
     * @Para: [OldManFreePo]
     * @Retun: List<OldManMainPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<OldManMainPo> getomList(OldManMainPo po){
        logger.debug("进入OldManHosingServiceImpl.getomList()方法,po:"+po);
        List<OldManMainPo> oldMan=mapper.getomList(po);
        logger.debug("查询结果:"+oldMan.size());
        return oldMan;
    }

    /**
     * @Method: queryLast
     * @Description: 查询最后一个老人信息
     * @Para: [OldManFreePo]
     * @Retun: List<OldManMainPo>
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public List<OldManMainPo> queryLast(){
        logger.debug("进入OldManHosingServiceImpl.queryLast()方法,");
        List<OldManMainPo> oldMan=mapper.queryLast();
        logger.debug("查询结果:"+oldMan.size());
        return oldMan;
    }

    /**
     * @Method: getOldManById
     * @Description: 根据ID查询查询老人信息
     * @Para: [Id]
     * @Retun: OldManMainPo
     * @Author: wangjs
     * @Date: 2017/3/5
     */
    public OldManMainPo getOldManById(String Id){
        logger.debug("进入OldManHosingServiceImpl.getOldManById()方法,");
        OldManMainPo oldMan=mapper.getOldManById(Id);
        logger.debug("查询结果:"+oldMan);
        return oldMan;
    }

    /**
     * @Method: addBase
     * @Description: 新增老人基本信息
     * @Para: [OldManFreePo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,rollbackFor={Exception.class})
    public List<OldManMainPo> addBase(OldManMainPo po)throws Exception{
        logger.debug("进入OldManHosingServiceImpl.addBase（）方法");
        List<OldManMainPo> lastOldMan=null;
        if(po.getFoldManBirth().equals("")){
            po.setFoldManBirth("0000-00-00 00:00:00");
        }
        if(po.getFcontractEnd().equals("")){
            po.setFcontractEnd("0000-00-00 00:00:00");
        }
        int result=mapper.addBase(po);
        if(result<0){
            throw new Exception("添加老人异常，开始回滚");
        }else{
            logger.debug("新增老人基本信息成功");
        }
        lastOldMan=mapper.queryLast();
        if(lastOldMan==null){
            throw new Exception("查询最后添加老人异常，开始回滚");
        }
        return lastOldMan;
    }

    /**
     * @Method: updBase
     * @Description: 修改老人基本信息
     * @Para: [OldManFreePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updBase(OldManMainPo po){
        logger.debug("进入OldManHosingServiceImpl.updBase（）方法");
        try{
            if(po.getFoldManBirth().equals("")){
                po.setFoldManBirth("0000-00-00 00:00:00");
            }
            if(po.getFcontractEnd().equals("")){
                po.setFcontractEnd("0000-00-00 00:00:00");
            }
            mapper.updBase(po);
            logger.debug("修改老人基本信息成功");
        }catch (Exception e){
            logger.error("修改老人基本信息异常:"+e.getMessage());
        }
    }

    /**
     * @Method: updOldManState
     * @Description: 修改老人状态
     * @Para: [OldManFreePo]
     * @Retun: void
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    public void updOldManState(OldManMainPo po){
        logger.debug("进入OldManHosingServiceImpl.updoldManState（）方法");
        try{
            mapper.updOldManState(po);
            logger.debug("修改老人状态成功");
        }catch (Exception e){
            logger.error("修改老人状态异常:"+e.getMessage());
        }
    }
}
