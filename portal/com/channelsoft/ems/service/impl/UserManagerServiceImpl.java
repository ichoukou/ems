package com.channelsoft.ems.service.impl;

import java.util.List;
import java.util.Map;

import com.channelsoft.ems.po.MessagePo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.EvaluationScoreMapper;
import com.channelsoft.ems.mapper.UserManagerMapper;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.UserManagerService;
/** 
 * 
 * 用户管理  
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */
@Service
public class UserManagerServiceImpl implements UserManagerService {

	private static Logger logger = Logger.getLogger(UserManagerServiceImpl.class);
	
	
	@Autowired
	private UserManagerMapper mapper;
	
	public int addUser(UserPo userPo) {
		// TODO Auto-generated method stub
		try {
			logger.debug("进入增加"+userPo);
			this.mapper.addUser(userPo);
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("添加错误"+e.getMessage());
			e.printStackTrace();
		    return 1;
		}
		
		return 0;

	}

	public int updateState(UserPo userPo) {
		// TODO Auto-generated method stub
		try {
			logger.debug("禁用账号"+userPo.getUid());
			this.mapper.updateState(userPo);;
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("禁用错误"+e.getMessage());
			e.printStackTrace();
		    return 1;
		}		
		return 0;
	}

	public int updataUser(UserPo userPo) {
		// TODO Auto-generated method stub
		try {
			logger.debug("更新账号"+userPo.getUid());
			this.mapper.updataUser(userPo);
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("更新错误"+e.getMessage());
			e.printStackTrace();
		    return 1;
		}		
		return 0;
	}

	public List<Map<String, String>> getALLRole() {
		// TODO Auto-generated method stub
		return this.mapper.getALLRole();
	}

	public int CheckUser(UserPo userPo) {
		try {
			logger.debug("启用账号"+userPo.getUname());
			if(this.mapper.CheckUser(userPo)==0){
				logger.debug("不存在重复账号"+userPo.getUname());
                return 0;
			};
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("验证用户名出错"+e.getMessage());
			e.printStackTrace();
			return 1;
		}
		return 1;
	}

	public int CheckUpdateUser(UserPo userPo) {
		try {
			logger.debug("更新账号"+userPo.getUname());
			if(this.mapper.CheckUpdateUser(userPo)==0){
				logger.debug("不存在重复账号"+userPo.getUname());
				return 0;
			};
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("验证用户名出错"+e.getMessage());
			e.printStackTrace();
			return 1;
		}
		return 1;
	}

	public int queryCount(MessagePo param) {
		return this.mapper.queryCount(param);
	}

	public List<MessagePo> queryList(MessagePo param, int page, int pageSize) {
		return this.mapper.queryList(param, page, pageSize);
	}

	public List<UserPo> getUser(String page, String pageSize) {
		// TODO Auto-generated method stub
		return this.mapper.getUser(page, pageSize);
	}

	public List<UserPo> queryAllUser(UserPo param, int page, int pageSize) {
		return this.mapper.queryAllUser(param,page,pageSize);
	}

	public int queryAllUserCount(UserPo param) {
		return this.mapper.queryAllUserCount(param);
	}

	public int getUserCount() {
		// TODO Auto-generated method stub
		return this.mapper.getUserCount();
	}

	public int startState(UserPo userPo) {
		// TODO Auto-generated method stub
		try {
			logger.debug("启用账号"+userPo.getUid());
			this.mapper.startState(userPo);
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("启用错误"+e.getMessage());
			e.printStackTrace();
		    return 1;
		}		
		return 0;
	}
	}


