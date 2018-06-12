package com.channelsoft.ems.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.AuthorityManageMapper;
import com.channelsoft.ems.po.MenuPo;
import com.channelsoft.ems.service.AuthorityManageService;


/** 
 * 
 * 权限分配
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午19:13:41 
 * @parameter  
 * @return  
 */
@Service
public class AuthorityManageServiceImpl implements AuthorityManageService{

private static Logger logger = Logger.getLogger(AuthorityManageServiceImpl.class);
	
	
	@Autowired
	private AuthorityManageMapper mapper;
	
	public List<MenuPo> getMenu() {
		// TODO Auto-generated method stub
		logger.debug("进入查询父菜单 ");
		return this.mapper.getMenu();
	}

	public List<MenuPo> getSonMenu(String parentid) {
		// TODO Auto-generated method stub
		logger.debug("进入查询子菜单");
		return this.mapper.getSonMenu(parentid);
	}

	public List<Map<String, String>> getRoleMenu() {
		// TODO Auto-generated method stub
		return this.mapper.getRoleMenu();
	}

	public List<Map<String, String>> getRoleNotMeun() {
		// TODO Auto-generated method stub
		return this.mapper.getRoleNotMeun();
	}

	public List<Map<String, String>> getParenSon() {
		// TODO Auto-generated method stub
		return this.mapper.getParenSon();
	}

	public int insertAuthority(int roleid, String newAuthority) {
		// TODO Auto-generated method stub
		try {
			logger.debug("对该角色进行赋予权限:"+roleid);
			this.mapper.insertAuthority(roleid, newAuthority);;
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("添加错误"+e.getMessage());
			e.printStackTrace();
		    return 1;
		}
		
		return 0;
		
	}

	public int updateAuthority(int roleid, String newAuthority) {
		// TODO Auto-generated method stub
		try {
			logger.debug("对该角色进行更新权限:"+roleid);
			this.mapper.updateAuthority(roleid, newAuthority);;
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("添加错误"+e.getMessage());
			e.printStackTrace();
		    return 1;
		}
		
		return 0;
		
		
	}



}
