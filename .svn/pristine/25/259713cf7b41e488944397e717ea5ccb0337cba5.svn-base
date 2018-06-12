package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.AssessRankMapper;
import com.channelsoft.ems.po.RankPo;
import com.channelsoft.ems.service.AssRankService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxin on 2016/11/24.
 */
@Service
public class AssRankServiceImpl implements AssRankService {
    private Logger logger=Logger.getLogger(AssRankServiceImpl.class);

    @Autowired
    private AssessRankMapper assessRankMapper;


    public List<Map<String,String>> getDicname(){
        logger.debug("进入getDicname（）方法查询数据字典中的value");
        return this.assessRankMapper.getDicname();
    }

    public List<RankPo> getFlevelNameValue(){
        logger.debug("进入getFLlevelNameValue()方法");
        List<RankPo> list=this.assessRankMapper.getFlevelNameValue();
        logger.debug("list:"+list);
        return list;
    }

    public List<Map<String,String>> getStatus(String sum) {
        return assessRankMapper.getStatus(sum);
    }

    public int addSum(RankPo rankPo) {
        try {
            logger.debug("进入增加"+rankPo);
            this.assessRankMapper.addSum(rankPo);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public List<RankPo> getFResultSum() {
        return this.assessRankMapper.getFResultSum();
    }
}
