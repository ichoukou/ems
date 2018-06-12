package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.ArrgngHomePo;
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
public interface LoginMapper {


    //养老院用户名密码
	@Select("   SELECT S_USER.*,S_ROLE.r_name,T_STAFF_MESSAGE.FStaffName,T_STAFF_MESSAGE.FPhotoID FROM S_USER ,S_ROLE , T_STAFF_MESSAGE  WHERE 1=1 AND u_name=#{uname} \n" +
			"  AND u_password=#{passWord} and S_USER.role_id=S_ROLE.r_id and S_USER.employ_id=T_STAFF_MESSAGE.FID  and S_USER.u_state='1' and T_STAFF_MESSAGE.FState='1'" )

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
			@Result(column="FStaffName",property="fStaffName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPhotoID",property="staffPicture",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="u_phonenum",property="phoneNum",javaType=String.class,jdbcType=JdbcType.INTEGER )
	})
	public  List<UserPo> queryLogin(UserPo user);

	@Select(" SELECT s_menuid from S_ROLE_MENU where s_roleid=#{roleId}")
	public  List<Map<String,String>> queryMenu(UserPo user);

	@Select("  SELECT * FROM (SELECT S1.s_menuid 'MID' ,S1.s_name 'parent',S2.s_name 'children',S2.s_url,S2.s_menuid 'SON' FROM S_MENU S1,S_MENU S2 WHERE S1.s_menuid= S2.s_parentid)" +
			" P WHERE P.SON IN   (${roleId})  order by P.MID,P.SON ")
	@Results(value={
			@Result(column="MID",property="sparentid",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="parent",property="sname",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="children",property="soname",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="s_url",property="surl",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="SON",property="smenuid",javaType=String.class,jdbcType=JdbcType.INTEGER )
	})
	public  List<MenuPo> queryAllMenu(@Param("roleId") String roleId);


	 //查询用户信息
	@Select(" select  a.FID FID,a.FStaffName FStaffName,a.FSex FSex,a.FEntryDate FEntryDate,b.FDepartmentName FDepartmentName,a.FPost FPost, \n" +
			"                    c.FBuildingName FBuildingName,a.FMobileTel FMobileTel,a.FTitle FTitle,a.FSalryType FSalryType,a.FStaffStatus FStaffStatus, \n" +
			"                    a.FFnation,a.FNursinghomeID,a.FIdentityCardID,a.FLunarCalendar,a.FMaritalStatus, a.FLunarBrith,a.FDismissalDate,FBrith, \n" +
			"                    a.FGraduateSchool,a.FEducation,a.FMajor,a.FCertificate,a.FComputerLevel,a.FLanguageLevel,a.FSalryType,a.FBankCardID,a.FHealth, \n" +
			"                    a.FPostcode,a.FPhotoID,a.FHpisejpldRegister,a.FHomeAddress,a.FPoliticalStatus,a.FTel,a.FWechatNumber,a.FRemarks  \n" +
			"                    from  \n" +
			"                    T_STAFF_MESSAGE a,T_DEPARTMENT b,T_BUILDING c \n" +
			"                    where \n" +
			"                    a.FDepartmentID = b.FID and a.FBuildingID = c.FID AND a.FID=#{fId}")
	@Results(value = {
			@Result(column="FID",property="fId",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="FStaffName",property="fStaffName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FSex",property="fSex",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FEntryDate",property="fEntryDate",javaType=String.class,jdbcType=JdbcType.DATE),
			@Result(column="FDismissalDate",property="fDismissalDate",javaType=String.class,jdbcType=JdbcType.DATE),
			@Result(column="FBrith",property="fBrith",javaType=String.class,jdbcType=JdbcType.DATE),
			@Result(column="FLunarBrith",property="fLunarBrith",javaType=String.class,jdbcType=JdbcType.DATE),
			@Result(column="FDepartmentName",property="fDepartmentName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPost",property="fPost",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FBuildingName",property="fBuildingName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FMobileTel",property="fMobileTel",javaType=String.class,jdbcType = JdbcType.VARCHAR),
			@Result(column="FTitle",property="fTitle",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FSalryType",property="fSalryType",javaType=String.class,jdbcType = JdbcType.VARCHAR),
			@Result(column="FStaffStatus",property="fStaffStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FFnation",property="fFnation",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FNursinghomeID",property="fNursinghomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FIdentityCardID",property="fIdentityCardID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FLunarCalendar",property="fLunarCalendar",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FMaritalStatus",property="fMaritalStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FGraduateSchool",property="fGraduateSchool",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FEducation",property="fEducation",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FMajor",property="fMajor",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCertificate",property="fCertificate",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FComputerLevel",property="fComputerLevel",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FLanguageLevel",property="fLanguageLevel",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FSalryType",property="fSalryType",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FBankCardID",property="fBankCardID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FHealth",property="fHealth",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPostcode",property="fPostcode",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FHpisejpldRegister",property="fHpisejpldRegister",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FHomeAddress",property="fHomeAddress",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPoliticalStatus",property="fPoliticalStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FTel",property="fTel",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FWechatNumber",property="fWechatNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRemarks",property="fRemarks",javaType=String.class,jdbcType=JdbcType.VARCHAR),

	})

	public List<MessagePo> getList( MessagePo param);


 @Update(" update `S_USER` set `u_password`=#{passWord} where `u_id`=#{uid}")
	public void  updatePass(UserPo po);

}   
    
    
    
    
    

