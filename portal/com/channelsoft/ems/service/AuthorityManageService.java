package com.channelsoft.ems.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.channelsoft.ems.po.MenuPo;

/** 
 * 
 * 权限分配
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午19:13:41 
 * @parameter  
 * @return  
 */
public interface AuthorityManageService {
    public List<MenuPo> getMenu();
  
    public List<MenuPo> getSonMenu(String parentid);
    
    public List<Map<String,String>> getRoleMenu();

	public List<Map<String,String>> getRoleNotMeun();

	public List<Map<String,String>>getParenSon();

    public int insertAuthority(int roleid,String newAuthority);
    
    public int updateAuthority(int roleid,String newAuthority);


    
}
