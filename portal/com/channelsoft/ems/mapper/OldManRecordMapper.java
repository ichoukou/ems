package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManRecordPo;

/**
 *   老人日常行为记录mapper层
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年1月3日
 */
public interface OldManRecordMapper {
	@SelectProvider(type=RecordProvider.class,method="getRecordList")
	@Results(value={
			@Result(column="FID",property="fID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FoldManName",property="foldManName",javaType=String.class,jdbcType=JdbcType.VARCHAR ),
			@Result(column="FNumber",property="fNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FNursinghomeID",property="fNursinghomeId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FOldManID",property="fOldManId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRecordType",property="fRecordType",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRecordDate",property="fRecordDate",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FKeeper",property="fKeeper",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FExplain",property="fExplain",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreatorID",property="fCreatorID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreateTime",property="fCreateTime",javaType=String.class,jdbcType=JdbcType.VARCHAR )
	})
	public List<OldManRecordPo> queryRecordList(@Param("oldManRecordPo") OldManRecordPo oldManRecordPo,@Param("page") int page,@Param("pageSize")int pageSize);
	
	@SelectProvider(type=RecordProvider.class,method="getCount")
	public int getCount(@Param("oldManRecordPo") OldManRecordPo oldManRecordPo);
	
	@Select("Select * from DATA_DICTIONARY where dc_name=#{dcName}")
	@Results(value={
			@Result(column="DC_ID",property="id",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="DC_NAME",property="name",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="DC_VALUE",property="value",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	})
	public List<DataDictionaryPo> getType(@Param("dcName")String dcName);
	
	@Select("SELECT DC_VALUE FROM DATA_DICTIONARY WHERE DC_ID=#{id}")
	public String getTypeNameById(@Param("id")String id);
	
	@Select("Select FStaffName FROM T_STAFF_MESSAGE WHERE FID=#{id}")
	public String getStaffNameById(@Param("id")String id);
	
	@SelectProvider(type=RecordProvider.class,method="addRecord")
	public int addRecord(@Param("oldManRecordPo")OldManRecordPo oldManRecordPo);
	
	@Delete("DELETE FROM T_OldMan_Record WHERE FID=#{fId}")
	public int deleteRecord(@Param("fId")String fId);
	
	@UpdateProvider(type=RecordProvider.class,method="updateRecord")
	public int updateRecord(@Param("oldManRecordPo")OldManRecordPo oldManRecordPo);

	class RecordProvider{
		private Logger logger=Logger.getLogger(RecordProvider.class);
		/**
		 * 查询老人日常行为记录SelectProvider
		 * @param oldManRecordMap
		 * @return
		 */
		public String getRecordList(Map<String,Object> oldManRecordMap){
			OldManRecordPo oldManRecordPo=(OldManRecordPo)oldManRecordMap.get("oldManRecordPo");
			StringBuffer sql=new StringBuffer("SELECT T_OldMan_Main.FoldManName,T_OldMan_Record.FID,T_OldMan_Record.FNumber,T_OldMan_Record.FNursinghomeID"
					+ ",T_OldMan_Record.FOldManID,T_OldMan_Record.FRecordType,T_OldMan_Record.FRecordDate,T_OldMan_Record.FKeeper"
					+ ",T_OldMan_Record.FExplain,T_OldMan_Record.FCreatorID,T_OldMan_Record.FCreateTime FROM T_OldMan_Record,T_OldMan_Main WHERE T_OldMan_Record.FOldManID=T_OldMan_Main.FID AND T_OldMan_Main.FoldManStatusID<>'111' AND T_OldMan_Main.FoldManStatusID<>'195' ");
			if(oldManRecordPo!=null){
				if(oldManRecordPo.getFoldManName()!=null&&!oldManRecordPo.getFoldManName().equals("")){
					sql.append(" AND T_OldMan_Main.FoldManName LIKE '%"+oldManRecordPo.getFoldManName()+"%'");
				}
				if(oldManRecordPo.getfRecordDate()!=null&&!oldManRecordPo.getfRecordDate().equals("")){
					String[] recordDate=oldManRecordPo.getfRecordDate().split("@");
					if(recordDate.length==1){
						sql.append("AND T_OldMan_Record.FRecordDate ='"+recordDate[0]+"'");
					}else{
						sql.append("AND T_OldMan_Record.FRecordDate BETWEEN '"+recordDate[0]+"' AND '"+recordDate[1]+"'");
					}
				}
			}
			sql.append(" limit #{page},#{pageSize}");
			logger.debug("查询的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 分页用获得所有记录
		 * @param oldManRecordMap
		 * @return
		 */
		public String getCount(Map<String,Object> oldManRecordMap){
			OldManRecordPo oldManRecordPo=(OldManRecordPo)oldManRecordMap.get("oldManRecordPo");
			StringBuffer sql=new StringBuffer("SELECT COUNT(*) FROM T_OldMan_Record,T_OldMan_Main WHERE T_OldMan_Record.FOldManID=T_OldMan_Main.FID AND  T_OldMan_Main.FoldManStatusID<>'111' AND T_OldMan_Main.FoldManStatusID<>'195' ");
			if(oldManRecordPo!=null){
				if(oldManRecordPo.getFoldManName()!=null&&!oldManRecordPo.getFoldManName().equals("")){
					sql.append(" AND T_OldMan_Main.FoldManName LIKE '%"+oldManRecordPo.getFoldManName()+"%'");
				}
				if(oldManRecordPo.getfRecordDate()!=null&&!oldManRecordPo.getfRecordDate().equals("")){
					String[] recordDate=oldManRecordPo.getfRecordDate().split("@");
					if(recordDate.length==1){
						sql.append("AND T_OldMan_Record.FRecordDate ='"+recordDate[0]+"'");
					}else{
						sql.append("AND T_OldMan_Record.FRecordDate BETWEEN '"+recordDate[0]+"' AND '"+recordDate[1]+"'");
					}
				}
			}
			logger.debug("查询总条数的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 修改老人日常行为记录
		 * @param recordPo
		 * @return
		 */
		public String updateRecord(Map<String,Object> recordPo){
			OldManRecordPo oldManRecordPo=(OldManRecordPo)recordPo.get("oldManRecordPo");
			StringBuffer sql=new StringBuffer("UPDATE T_OldMan_Record SET ");
			if(oldManRecordPo!=null){
				sql.append("FRecordType='"+oldManRecordPo.getfRecordType()+"',");
				sql.append("FRecordDate='"+oldManRecordPo.getfRecordDate()+"',");
				sql.append("FKeeper='"+oldManRecordPo.getfKeeper()+"',");
				sql.append("FExplain='"+oldManRecordPo.getfExplain()+"'");
				sql.append("WHERE FID='"+oldManRecordPo.getfID()+"'");
				logger.debug("修改老人日常行为的sql语句为"+sql.toString());
				return sql.toString();
			}else{
				return null;
			}
		}
		/**
		 * 添加老人日常行为记录
		 * @param recordPo
		 * @return
		 */
		public String addRecord(Map<String,Object> recordPo){
			OldManRecordPo oldManRecordPo=(OldManRecordPo)recordPo.get("oldManRecordPo");
			StringBuffer sql=new StringBuffer();
			if(oldManRecordPo!=null){
				sql.append("INSERT INTO T_OldMan_Record (FNumber,FNursinghomeID,FOldManID,FRecordType,FRecordDate,FKeeper,FExplain,FCreatorID,FCreateTime) ");
				sql.append(" VALUES ('"+oldManRecordPo.getfNumber()+"',");
				sql.append("'"+oldManRecordPo.getfNursingHomeId()+"',");
				sql.append("'"+oldManRecordPo.getfOldManId()+"',");
				sql.append("'"+oldManRecordPo.getfRecordType()+"',");
				sql.append("'"+oldManRecordPo.getfRecordDate()+"',");
				sql.append("'"+oldManRecordPo.getfKeeper()+"',");
				sql.append("'"+oldManRecordPo.getfExplain()+"',");
				sql.append("'"+oldManRecordPo.getfCreatorID()+"',");
				sql.append("'"+oldManRecordPo.getfCreateTime()+"'");
				sql.append(")");
				logger.debug("添加老人日常记录的sql语句为"+sql.toString());
				return sql.toString();
			}
			return null;
		}
	}
}
