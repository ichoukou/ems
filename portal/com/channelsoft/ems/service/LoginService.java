package com.channelsoft.ems.service;

import com.channelsoft.ems.po.MenuPo;
import com.channelsoft.ems.po.MessagePo;
import com.channelsoft.ems.po.UserPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * 登录
 * @author  wuhl
 * @date 创建时间：2017年2月15日 下午16:13:41
 * @parameter  
 * @return  
 */

public interface LoginService {

	public  List<UserPo> queryLogin(UserPo user);

	public  List<MenuPo> queryAllMenu( String roleId);

	public  List<Map<String,String>> queryMenu(UserPo user);

	public List<MessagePo> getList( MessagePo param);

	public int  updatePass(UserPo po);




}
