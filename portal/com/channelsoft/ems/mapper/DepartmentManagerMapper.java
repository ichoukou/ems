package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.DepartmentPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;


/**
 *
 * 部门管理
 * @author  wuhl
 * @date 创建时间：2016年12月17日 下午16:13:41
 * @parameter
 * @return
 */
public interface DepartmentManagerMapper {
	@Select("select FID,FDepartmentName,FHigherUpID,FAttribute,FPortalType,FSortNumber,FParameter from T_DEPARTMENT where FStatus='Y' and FHigherUpID=0")
	@Results(value = {
			@Result(column = "FID", property = "fid", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column = "FDepartmentName", property = "fDepartmentName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FAttribute", property = "fDepartmentAttrbute", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FHigherUpID", property = "fHigherUpID", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FPortalType", property = "fPortalType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FSortNumber", property = "fSortNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FParameter", property = "fParameter", javaType = String.class, jdbcType = JdbcType.VARCHAR),})
	public List<DepartmentPo> quertDepartment();


	@Select(" SELECT FID , FDepartmentName ,FHigherUpID FROM T_DEPARTMENT where FStatus='Y'and FID!=#{fid} ")
	public List<DepartmentPo> queryDepartmentHigh(DepartmentPo po);

	@Insert(" insert into  T_DEPARTMENT(`FDepartmentNumber`,`FDepartmentName`,`FAttribute`,`FNursinghomeID`,`FHigherUpID`,`FStatus`,`FPortalType`,`FSortNumber`,`FParameter`) values ( 'B',#{fDepartmentName},#{fDepartmentAttrbute},'1',#{fHigherUpID},'Y',#{fPortalType},#{fSortNumber},#{fParameter})")
	public void addDepartment(DepartmentPo po);



	@Update(" UPDATE T_DEPARTMENT set `FDepartmentName`=#{fDepartmentName},`FAttribute`=#{fDepartmentAttrbute},`FHigherUpID`=#{fHigherUpID},`FPortalType`=#{fPortalType},`FSortNumber`=#{fSortNumber},`FParameter`=#{fParameter} where `FID`=#{fid}")
	public void updataDepartment(DepartmentPo po);

	@Select("select T1.FID, T1.FDepartmentName, T.FDepartmentName 'father', T1.FHigherUpID ,T1.FAttribute,T1.FPortalType,T1.FSortNumber,T1.FParameter from T_DEPARTMENT T ,"
			+ "(select FID,FDepartmentName,FHigherUpID,FAttribute,FPortalType,FSortNumber,FParameter from T_DEPARTMENT"
			+ " where FStatus='Y' and FHigherUpID=#{id}  order by  FDepartmentName) as T1 where T1.FHigherUpID=T.FID")
	@Results(value = {
			@Result(column = "FID", property = "fid", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column = "FDepartmentName", property = "fDepartmentName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FAttribute", property = "fDepartmentAttrbute", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "father", property = "father", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column = "FPortalType", property = "fPortalType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FSortNumber", property = "fSortNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FHigherUpID", property = "fHigherUpID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FParameter", property = "fParameter", javaType = String.class, jdbcType = JdbcType.VARCHAR),})


	public List<Map<String,String>> quertSonDepartment(@Param("id") String id);

	//验证部门名称不能重复
	@Select(" SELECT COUNT(*) FROM T_DEPARTMENT WHERE FDepartmentName=#{fDepartmentName}")
	public int CheckEmp(DepartmentPo po);
	//验证更新用户名不能重复
	@Select(" SELECT COUNT(*) FROM T_DEPARTMENT WHERE FDepartmentName=#{fDepartmentName} and FID<>#{fid}")
	public int CheckUpdateEmp(DepartmentPo po);

	@Select(" SELECT COUNT(*) FROM T_DEPARTMENT WHERE FHigherUpID=#{fid}")
	public int DelectCount(DepartmentPo po);

	//查询出已经被占用的部门
	@Select(" SELECT count(*) FROM T_DEPARTMENT T,T_STAFF_MESSAGE S WHERE T.FID=S.FDepartmentID and T.FID=#{fid} ")
	public int deletcBefore(DepartmentPo po);

	@Update("update T_DEPARTMENT set FStatus='N' WHERE FID=#{fid}")
	public void delectDepartment(DepartmentPo po);
}
