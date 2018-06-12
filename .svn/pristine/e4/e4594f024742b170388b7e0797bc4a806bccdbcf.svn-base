package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.LoginMapper;
import com.channelsoft.ems.po.MenuPo;
import com.channelsoft.ems.po.MessagePo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.LoginService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by wuhl on 2017/2/15.
 */
@Service
public class LoginServiceImpl  implements LoginService {

    private static Logger logger = Logger.getLogger(LoginServiceImpl.class);


    @Autowired
    private LoginMapper loginMapper;



    public List<UserPo> queryLogin(UserPo user) {

        return this.loginMapper.queryLogin(user);
    }


    public List<MenuPo> queryAllMenu( String roleId) {

        return this.loginMapper.queryAllMenu(roleId );
    }

    public List<Map<String,String>> queryMenu(UserPo user) {

        return this.loginMapper.queryMenu(user);
    }

    public List<MessagePo> getList(MessagePo param) {
        return this.loginMapper.getList(param);
    }

    public int updatePass(UserPo po) {
        // TODO Auto-generated method stub
        try {
            logger.debug("进入更新");
            this.loginMapper.updatePass(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }

        return 0;

    }
}
