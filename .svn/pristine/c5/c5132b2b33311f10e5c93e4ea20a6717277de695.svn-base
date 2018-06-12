package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManMainPo;

public interface OldManQuitMapper {
	
	@SelectProvider(type=OldManUnsubMapperPro.class,method="queryLeave")
	@Results(value={
			@Result(column="FID",property="fID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FoldManName",property="foldManName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FOldManIDnSex",property="fOldManIDnSex",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FcheckoutTime",property="fcheckoutTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FLeaveType",property="fLeaveType",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FcheckinTime",property="fcheckinTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FbuildingID",property="fbuildingID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column = "FBuildingName", property = "fBuildingName", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column="FroomID",property="froomID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column = "FRoomName", property = "fRoomName", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column="FbedID",property="fbedID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column = "FBedNumber", property = "fBedNumber", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column="FLeaveReason",property="fLeaveReason",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	})
	public List<OldManMainPo> query(@Param("oldManMainPo")OldManMainPo oldManMainPo,@Param("page") int page,@Param("pageSize") int pageSize);
	
	@SelectProvider(type=OldManUnsubMapperPro.class,method="getCount")
	public int getCount(@Param("oldManMainPo")OldManMainPo oldManMainPo);
	
	@Select("SELECT FBedNumber FROM T_BED WHERE FID=#{id}")
	@Result(column="FBedNumber",property="fBedNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	public String queryBedById(@Param("id")String id);
	
	@Select("SELECT DC_VALUE FROM DATA_DICTIONARY WHERE DC_ID=#{id}")
	@Result(column="DC_ID",property="id",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	public String queryTypeName(@Param("id")String id);
	
	@Select("SELECT * FROM DATA_DICTIONARY WHERE DC_NAME=#{dcName}")
	@Results(value={
			@Result(column="DC_ID",property="id",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="DC_NAME",property="name",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="DC_VALUE",property="value",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	})
	public List<DataDictionaryPo> queryLeaveType(@Param("dcName")String dcName);
	
	@InsertProvider(type=OldManUnsubMapperPro.class,method="addLeave")
	public int addOldManLeave(@Param("oldManMainPo")OldManMainPo oldManMainPo);
	
	@SelectProvider(type=OldManUnsubMapperPro.class,method="queryByUserFId")
	@Result(column="FID",property="fID",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	public List<OldManMainPo> queryOldManByUserFId(@Param("oldManMainPo")OldManMainPo oldManMainPo);
	
	@UpdateProvider(type=OldManUnsubMapperPro.class,method="deleteLeave")
	public int deletLeave(@Param("oldManMainPo")OldManMainPo oldManMainPo);

	class OldManUnsubMapperPro{
		private Logger logger =Logger.getLogger(OldManQuitMapper.class);
		
		/**
		 * 得到应经出院老人的信息
		 * @param map
		 * @return
		 */
		public String queryLeave(Map<String,Object> map){
			OldManMainPo oldManMainPo=(OldManMainPo)map.get("oldManMainPo");
			StringBuffer sql=new StringBuffer("SELECT * FROM T_OldMan_Main,T_ROOM,T_BUILDING,T_BED  WHERE 1=1  AND FoldManStatusID='111' AND T_OldMan_Main.FoldManStatusID<>'195' ");
			sql.append(" AND T_OldMan_Main.FbedID=T_BED.FID and T_OldMan_Main.FbuildingID=T_BUILDING.FID and T_OldMan_Main.FroomID=T_ROOM.FID");
			if (oldManMainPo == null) {
				return sql.toString();
			} else {
				logger.debug(oldManMainPo.getFcheckoutTime());
				if (oldManMainPo.getFoldManName()!= null&&!oldManMainPo.getFoldManName().equals("")) {
					sql.append(" AND FoldManName LIKE '%" + oldManMainPo.getFoldManName() + "%'");
				}
				if (oldManMainPo.getFcheckoutTime()!=null&&!oldManMainPo.getFcheckoutTime().equals("")) {
					String[] checkOutTime = oldManMainPo.getFcheckoutTime().split("@");
					if (checkOutTime.length == 1) {
						sql.append(" AND FcheckoutTime ='" + checkOutTime[0] + "'");
					} else {
						sql.append(" AND FcheckoutTime BETWEEN '" + checkOutTime[0] + "' AND '" + checkOutTime[1] + "'");
					}
				}
			}
	            sql.append(" limit #{page},#{pageSize}");
	            logger.debug("sql:"+sql);
				return sql.toString();
		}
		/**
		 * 得到所有已经出院的老人的数量  bootstrap分页用
		 * @param map
		 * @return
		 */
		public String getCount(Map<String,Object> map){
			OldManMainPo oldManMainPo=(OldManMainPo)map.get("oldManMainPo");
			StringBuffer sql=new StringBuffer("SELECT COUNT(*) FROM T_OldMan_Main WHERE 1=1 AND FoldManStatusID='111' AND T_OldMan_Main.FoldManStatusID<>'195' ");
			if (oldManMainPo == null) {
				return sql.toString();
			} else {
				if (oldManMainPo.getFoldManName()!= null&&!oldManMainPo.getFoldManName().equals("")) {
					sql.append(" AND FoldManName LIKE '%" + oldManMainPo.getFoldManName() + "%'");
				}
				if (oldManMainPo.getFcheckoutTime()!=null&&!oldManMainPo.getFcheckoutTime().equals("")) {
					String[] checkOutTime = oldManMainPo.getFcheckoutTime().split("@");
					if (checkOutTime.length == 1) {
						sql.append(" AND FcheckoutTime ='" + checkOutTime[0] + "'");
					} else {
						sql.append(" AND FcheckoutTime BETWEEN '" + checkOutTime[0] + "' AND '" + checkOutTime[1] + "'");
					}
				}
			}
				return sql.toString();
		}
		
		/**
		 * 更改老人的状态等  不是真正办理退住
		 * 前台已经有非空校验  所以此处并不需要控制非空
		 * @param oldManMainPo
		 * @return
		 */
		public String addLeave(Map<String,Object> oldManMainPo){
			logger.debug("开始办理退住");
			OldManMainPo oldMan=(OldManMainPo)oldManMainPo.get("oldManMainPo");
			StringBuffer sql=new StringBuffer("UPDATE T_OldMan_Main SET FoldManStatusID='111',");
			sql.append("FcheckoutTime='"+oldMan.getFcheckoutTime()+"',");
			sql.append("FLeaveType='"+oldMan.getfLeaveType()+"',");
			sql.append("FLeaveReason='"+oldMan.getfLeaveReason()+"'");
			sql.append(" WHERE FID='"+oldMan.getfID()+"'");
			logger.debug("办理退住的sql为"+sql.toString());
			return sql.toString();
			
		}
		/**
		 * 根据id查询老人
		 * @param oldManMainPo
		 * @return
		 */
		public String queryByUserFId(Map<String,Object> oldManMainPo){
			OldManMainPo oldMan=(OldManMainPo)oldManMainPo.get("oldManMainPo");
			String sql="SELECT * FROM T_OldMan_Main WHERE FoldManStatusID <>'111' AND T_OldMan_Main.FoldManStatusID<>'195'  AND FID='"+oldMan.getfID()+"'";
			logger.debug("根据来人id查询的sql为"+sql);
			return sql;
		}
		
		/**
		 * 撤销入住
		 * @param oldManMainPo
		 * @return
		 */
		public String deleteLeave(Map<String,Object> oldManMainPo){
			logger.debug("开始执行撤销退住");
			OldManMainPo oldMan=(OldManMainPo) oldManMainPo.get("oldManMainPo");
			StringBuffer sql=new StringBuffer("UPDATE T_OldMan_Main SET FoldManStatusID='3',");
			sql.append("FcheckoutTime='',");
			sql.append("FLeaveType='',");
			sql.append("FLeaveReason=''");
			sql.append(" WHERE FID='"+oldMan.getfID()+"'");
			logger.debug("撤销入住的sql语句为"+sql.toString());
			return sql.toString();
		}
	}
}
