package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import com.channelsoft.ems.po.MessagePo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.channelsoft.ems.po.RangePo;
import com.channelsoft.ems.po.RolePo;
import com.channelsoft.ems.po.UserPo;
import org.apache.log4j.Logger;


/** 
 * 
 * 用户管理  
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */
public interface UserManagerMapper {

	public static Logger logger=Logger.getLogger(UserManagerMapper.class);


	@Select( "select count(*) from S_USER")
    public int  getUserCount();

	
	@Select("select u_id,u_name,u_password,name,u_phonenum,role_id, r_name,employ_id,T_STAFF_MESSAGE.FStaffName 'fStaffName',u_oldhouse,u_state from S_USER,S_ROLE,T_STAFF_MESSAGE where S_USER.role_id=S_ROLE.r_id and S_USER.employ_id=T_STAFF_MESSAGE.FID order by u_id LIMIT ${page},${pageSize} ")
	@Results(value = {  
			@Result(column="u_id",property="uid",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="u_name",property="uname",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="u_password",property="passWord",javaType=String.class, jdbcType=JdbcType.VARCHAR),
			@Result(column="name",property="name",javaType=String.class, jdbcType=JdbcType.VARCHAR),
			@Result(column="u_phonenum",property="phoneNum",javaType=String.class, jdbcType=JdbcType.VARCHAR),		
			@Result(column="role_id",property="roleId",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="r_name",property="roleName",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="employ_id",property="employId",javaType=String.class, jdbcType=JdbcType.INTEGER),
			@Result(column="fStaffName",property="fStaffName",javaType=String.class,  jdbcType=JdbcType.VARCHAR),
			@Result(column="u_oldhouse",property="oldhouse",javaType=String.class,  jdbcType=JdbcType.VARCHAR),
			@Result(column="u_state",property="state",javaType=String.class, jdbcType=JdbcType.INTEGER)		
	        })
	        public List<UserPo> getUser(@Param("page") String page,@Param("pageSize") String pageSize);
	
	
	@Insert("insert into S_USER(u_name,u_password,name,u_phonenum,role_id,employ_id,u_oldhouse,u_state ) VALUES(#{uname},#{passWord},#{name},#{phoneNum},#{roleId},#{employId},#{oldhouse},1)")
	public void addUser(UserPo userPo); 

	//禁用
	@Update(" update S_USER set u_state=0 WHERE u_id=#{uid} ")
	public void updateState(UserPo userPo);
	
	
	//启用
	@Update(" update S_USER set u_state=1 WHERE u_id=#{uid} ")
	public void startState(UserPo userPo);


    @Update(" UPDATE S_USER SET  u_name=#{uname},u_password=#{passWord}, u_phonenum=#{phoneNum},name=#{name},role_id=#{roleId},employ_id=#{employId},u_oldhouse=#{oldhouse} WHERE u_id=#{uid}")
    public void updataUser(UserPo userPo);

    //查询角色 和id的匹配
    @Select(" select r_id,r_name from S_ROLE where S_ROLE.r_state='1'")
	public List<Map<String,String>> getALLRole();

	//查询养老院
	@Select(" SELECT FID ,FNursingName FROM T_SYS_NursingHome ")
	public List<Map<String,String>> getALLNursing();

	//验证用户名不能重复
	@Select(" SELECT COUNT(*) FROM S_USER WHERE u_name=#{uname}")
	public int CheckUser(UserPo userPo);
	//验证更新用户名不能重复
	@Select(" SELECT COUNT(*) FROM S_USER WHERE u_name=#{uname} and u_id<>#{uid}")
	public int CheckUpdateUser(UserPo userPo);

	@SelectProvider(type=AllUser.class,method = "queryAllUser")
	@Results(value = {
			@Result(column="u_id",property="uid",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="u_name",property="uname",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="u_password",property="passWord",javaType=String.class, jdbcType=JdbcType.VARCHAR),
			@Result(column="name",property="name",javaType=String.class, jdbcType=JdbcType.VARCHAR),
			@Result(column="u_phonenum",property="phoneNum",javaType=String.class, jdbcType=JdbcType.VARCHAR),
			@Result(column="role_id",property="roleId",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="r_name",property="roleName",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="employ_id",property="employId",javaType=String.class, jdbcType=JdbcType.INTEGER),
			@Result(column="fStaffName",property="fStaffName",javaType=String.class,  jdbcType=JdbcType.VARCHAR),
			@Result(column="u_oldhouse",property="oldhouse",javaType=String.class,  jdbcType=JdbcType.VARCHAR),
			@Result(column="u_state",property="state",javaType=String.class, jdbcType=JdbcType.INTEGER),
			@Result(column="r_state",property="r_state",javaType=String.class, jdbcType=JdbcType.INTEGER)

	})
	public List<UserPo> queryAllUser(@Param("param") UserPo param,@Param(value="page") int page,@Param(value="pageSize") int pageSize);

	@SelectProvider(type=AllUser.class,method = "queryAllUserCount")
	public int queryAllUserCount(@Param("param") UserPo param);

   //被禁用员工
   @SelectProvider(type = AllUser.class, method = "queryCount")
   public int queryCount(@Param("param") MessagePo param);


	@SelectProvider(type = AllUser.class, method = "queryList")
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
			@Result(column="FNursinghomeID",property="fNursinghomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRemarks",property="fRemarks",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FState",property="fState",javaType=String.class,jdbcType=JdbcType.INTEGER),
	})
	public List<MessagePo> queryList(@Param("param") MessagePo param, @Param(value = "page") int page, @Param(value = "pageSize") int pageSize);


	//条件查询
	class AllUser {
		public String queryAllUser(Map<String, Object> params) {

			UserPo user = (UserPo) params.get("param");

			StringBuffer sql = new StringBuffer();
			sql.append("   select u_id,u_name,u_password,name,u_phonenum,role_id, r_name,S_ROLE.r_state,employ_id,T_STAFF_MESSAGE.FStaffName 'fStaffName',T_SYS_NursingHome.FNursingName 'u_oldhouse',u_state from S_USER,S_ROLE,T_STAFF_MESSAGE ,T_SYS_NursingHome where S_USER.role_id=S_ROLE.r_id and S_USER.employ_id=T_STAFF_MESSAGE.FID and T_SYS_NursingHome.FID=S_USER.u_oldhouse  ");

			if (null == user) {
				return sql.toString();
			} else {
				if (StringUtils.isNotEmpty(user.getUname())) {
					sql.append(" and u_name = '" + user.getUname() + "'");
				}
				if (StringUtils.isNotEmpty(user.getEmployId())) {

					sql.append(" and employ_id = '" + user.getEmployId() + "'");
				}
			}
			sql.append("  order by u_id LIMIT #{page},#{pageSize}   ");
			logger.debug("查询用户语句：" + sql.toString());
			return sql.toString();
		}

		public String queryAllUserCount(Map<String, Object> params) {

			UserPo user = (UserPo) params.get("param");

			StringBuffer sql = new StringBuffer();
			sql.append("  select count(*) from S_USER,S_ROLE,T_STAFF_MESSAGE ,T_SYS_NursingHome where S_USER.role_id=S_ROLE.r_id and S_USER.employ_id=T_STAFF_MESSAGE.FID and T_SYS_NursingHome.FID=S_USER.u_oldhouse ");

			if (null == user) {
				return sql.toString();
			} else {
				if (StringUtils.isNotEmpty(user.getUname())) {
					sql.append(" and u_name = '" + user.getUname() + "'");
				}
				if (StringUtils.isNotEmpty(user.getEmployId())) {

					sql.append(" and employ_id = '" + user.getEmployId() + "'");
				}
			}

			logger.debug("查询用户总数：" + sql.toString());


			return sql.toString();
		}


		public String queryList(Map<String, Object> params) {
			MessagePo message = (MessagePo) params.get("param");
			StringBuffer empSql = new StringBuffer();
			empSql.append("select " +
					"a.FID FID,a.FStaffName FStaffName,d.FNursingName,a.FSex FSex,a.FEntryDate FEntryDate,b.FDepartmentName FDepartmentName,a.FPost FPost, " +
					"c.FBuildingName FBuildingName,a.FMobileTel FMobileTel,a.FTitle FTitle,a.FSalryType FSalryType,a.FStaffStatus FStaffStatus, " +
					"a.FFnation,a.FNursinghomeID,a.FIdentityCardID,a.FLunarCalendar,a.FMaritalStatus, a.FLunarBrith,a.FDismissalDate,FBrith, " +
					"a.FGraduateSchool,a.FEducation,a.FMajor,a.FCertificate,a.FComputerLevel,a.FLanguageLevel,a.FSalryType,a.FBankCardID,a.FHealth, " +
					"a.FPostcode,a.FPhotoID,a.FHpisejpldRegister,a.FHomeAddress,a.FPoliticalStatus,a.FTel,a.FWechatNumber,a.FRemarks,a.FState " +
					"from  " +
					"T_STAFF_MESSAGE a,T_DEPARTMENT b,T_BUILDING c,T_SYS_NursingHome d " +
					"where " +
					"a.FDepartmentID = b.FID and a.FBuildingID = c.FID and a.FNursinghomeID = d.FID and a.FState='1'");
			if (null == message) {
				return empSql.toString();
			} else {
				if (StringUtils.isNotEmpty(message.getfStaffName())) {
					empSql.append(" and FStaffName like '%" + message.getfStaffName() + "%'");
				}
				if (StringUtils.isNotEmpty(message.getfStaffStatus())) {
					empSql.append(" and FStaffStatus = '" + message.getfStaffStatus() + "'");
				}
				if (StringUtils.isNotEmpty(message.getfDepartmentID())) {
					empSql.append(" and FDepartmentID = " + Integer.parseInt(message.getfDepartmentID()));
				}
			}
			empSql.append(" limit #{page},#{pageSize}");
			logger.debug(empSql.toString());
			return empSql.toString();
		}

		public String queryCount(Map<String, Object> params) {
			MessagePo message = (MessagePo) params.get("param");
			StringBuffer sb = new StringBuffer();
			sb.append("select count(*) from  T_STAFF_MESSAGE a,T_DEPARTMENT b,T_BUILDING c,T_SYS_NursingHome d \n" +
					"\t\t\t\t\twhere\n" +
					"\t\t\t\t\ta.FDepartmentID = b.FID and a.FBuildingID = c.FID and a.FNursinghomeID = d.FID and a.FState='1'");
			if (null == message) {
				return sb.toString();
			} else {
				if (StringUtils.isNotEmpty(message.getfStaffName())) {
					sb.append(" and FStaffName like '%" + message.getfStaffName() + "%'");
				}
				if (StringUtils.isNotEmpty(message.getfStaffStatus())) {
					sb.append(" and FStaffStatus = '" + message.getfStaffStatus() + "'");
				}
				if (StringUtils.isNotEmpty(message.getfDepartmentID())) {
					sb.append(" and FDepartmentID = " + Integer.parseInt(message.getfDepartmentID()));
				}
			}
			logger.debug(sb.toString());
			return sb.toString();
		}
	}

}
