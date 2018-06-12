package com.channelsoft.ems.service;

import java.util.List;
import java.util.Map;

import com.channelsoft.ems.po.MessagePo;
import org.apache.ibatis.annotations.Param;

import com.channelsoft.ems.po.UserPo;
/** 
 * 
 * 用户管理  
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */

public interface UserManagerService {
	
    public int  getUserCount();

    public List<UserPo> getUser(String page,String pageSize);

	public List<UserPo> queryAllUser( UserPo param,int page,int pageSize);

	public int queryAllUserCount( UserPo param);

	public int addUser(UserPo userPo); 
	
	//假删除
	public int updateState(UserPo userPo);
	
	//启用
	public int startState(UserPo userPo);

	public int updataUser(UserPo userPo);

	public List<Map<String,String>> getALLRole();

	//验证用户名不能重复
	public int CheckUser(UserPo userPo);

	//验证更新用户名不能重复
	public int CheckUpdateUser(UserPo userPo);


	//查询开启的员工
	public int queryCount( MessagePo param);


	public List<MessagePo> queryList (MessagePo param,  int page,  int pageSize);



}
