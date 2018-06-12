package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.MenuPo;
import com.channelsoft.ems.po.MessagePo;
import com.channelsoft.ems.po.UserPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;


/** 
 *
 * 登录
 * @author  wuhl
 * @date 创建时间：2016年12月15日 下午20:13:41
 * @parameter  
 * @return  
 */
public interface MobileMapper {


    //养老院用户名密码
	@Select(" select S_USER.*,S_ROLE.r_name ,T_STAFF_MESSAGE.FStaffName from S_USER ,S_ROLE ,T_STAFF_MESSAGE where S_ROLE.r_id=S_USER.role_id and S_USER.employ_id=T_STAFF_MESSAGE.FID and u_name=#{uname} and u_password=#{passWord} and S_ROLE.r_name=#{roleName} \n" +
			" and S_ROLE.r_state='1' and T_STAFF_MESSAGE.FState='1' " )

	@Results(value={
			@Result(column="u_id",property="uid",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="u_name",property="uname",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="u_password",property="passWord",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="name",property="name",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="r_name",property="roleName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="role_id",property="roleId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="employ_id",property="employId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="u_oldhouse",property="oldhouse",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="u_state",property="state",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FStaffName",property="fStaffName",javaType=String.class,jdbcType=JdbcType.VARCHAR)})
	public  List<UserPo> queryMobile(UserPo user);


	@Update(" update `S_USER` set `u_password`=#{passWord} where `u_id`=#{uid}")
	public void  updatePass(UserPo po);
}   
    
    
    
    
    

