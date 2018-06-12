package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.channelsoft.ems.po.MenuPo;


/** 
 * 
 * 权限分配
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午19:13:41 
 * @parameter  
 * @return  
 */
public interface AuthorityManageMapper {
	
	@Select("select s_menuid ,s_name  from S_MENU where s_parentid=0")
	@Results(value = {  
			@Result(column="s_menuid",property="smenuid",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="s_name",property="sname",javaType=String.class,jdbcType=JdbcType.VARCHAR)	
	        })       
	public List<MenuPo> getMenu();
	
	
	@Select("select s_menuid,s_name from S_MENU where s_parentid=#{parentid}")
	@Results(value = {  
			@Result(column="s_menuid",property="smenuid",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="s_name",property="soname",javaType=String.class,jdbcType=JdbcType.VARCHAR)	
	        })  
	public List<MenuPo> getSonMenu(String parentid);
	
	//父菜单子菜单一起关联
	@Select("select s.s_parentid 'fatherid',b.s_name 'father' ,s.s_menuid 'sonid',s.s_name 'son' from S_MENU as s,"
			+ "(select s_menuid,s_name from S_MENU where s_parentid=0)as b where s.s_parentid=b.s_menuid order by s.s_parentid ")
	public List<Map<String,String>>getParenSon();
	
	//有权限角色                                                         
	@Select(" select r_id,r_name ,s_menuid from S_ROLE,S_ROLE_MENU WHERE S_ROLE.r_id=S_ROLE_MENU.s_roleid and S_ROLE.r_state='1' ")
    public List<Map<String,String>> getRoleMenu();
	
	//没有权限角色
    @Select(" select r_id,r_name  from S_ROLE WHERE S_ROLE.r_id not in (select r_id from S_ROLE,S_ROLE_MENU WHERE S_ROLE.r_id=S_ROLE_MENU.s_roleid) AND r_state=1 ")
	public List<Map<String,String>> getRoleNotMeun();
    
    //赋予权限
    @Insert("insert into S_ROLE_MENU(s_roleid,s_menuid ) VALUES(#{roleid},#{newAuthority})")
    public void insertAuthority(@Param("roleid")int roleid,@Param("newAuthority")String newAuthority);

    @Update(" update S_ROLE_MENU set s_menuid=#{newAuthority} where s_roleid=#{roleid}")
    public void updateAuthority(@Param("roleid")int roleid,@Param("newAuthority")String newAuthority);


}
