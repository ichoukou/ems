package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.LoginMapper;
import com.channelsoft.ems.mapper.MobileMapper;
import com.channelsoft.ems.po.MenuPo;
import com.channelsoft.ems.po.MessagePo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.LoginService;
import com.channelsoft.ems.service.MobileService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wuhl on 2017/2/15.
 */
@Service
public class MobileServiceImpl implements MobileService {

    private static Logger logger = Logger.getLogger(MobileServiceImpl.class);

    @Autowired
    private MobileMapper mobileMapper;


    public List<UserPo> queryMobile(UserPo user) {
        return this.mobileMapper.queryMobile(user);
    }

    public int updatePass(UserPo po) {
        // TODO Auto-generated method stub
        try {
            logger.debug("进入更新");
            this.mobileMapper.updatePass(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }

        return 0;

    }
}
