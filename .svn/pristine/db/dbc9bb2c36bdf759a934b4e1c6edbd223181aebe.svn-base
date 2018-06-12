package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import com.channelsoft.ems.po.FundAccountBillDelRecordPo;

import static com.sun.xml.internal.bind.api.impl.NameConverter.standard;

/**
 *  账户明细修改表的操作
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年2月20日
 */
public interface FundAccountBillDelRecordMapper {

	@Results(value = {
			@Result(column = "Fname", property = "fName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FAmount", property = "fAmount", javaType = String.class, jdbcType = JdbcType.DECIMAL),
			@Result(column = "Fdeldate", property = "fDeldate", javaType = String.class, jdbcType = JdbcType.DATE),
			@Result(column = "FPayment", property = "fPayment", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FStaffName", property = "fOprationer", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "Fremark", property = "fRemark", javaType = String.class, jdbcType = JdbcType.VARCHAR),
	})
	@SelectProvider(type=MapperProvider.class,method = "selectRecord")
	public List<FundAccountBillDelRecordPo> queryDelRecord(@Param("fOprationer") String fOprationer,@Param("Ldate")String Ldate,@Param("Edate")String Edate,@Param("page")int page,@Param("pageSize")int pageSize);
	@SelectProvider(type=MapperProvider.class,method = "selectRecordCount")
	public int queryDelRecordCount(@Param("fOprationer") String fOprationer,@Param("Ldate")String Ldate,@Param("Edate")String Edate,@Param("page")int page,@Param("pageSize")int pageSize);
	@InsertProvider(type=MapperProvider.class,method ="insertRecord")
	public int insertDelRecord(@Param("fundAccountBillDelRecordPo")FundAccountBillDelRecordPo fundAccountBillDelRecordPo);

	public class MapperProvider{
		private Logger logger=Logger.getLogger(MapperProvider.class);
		
		public String insertRecord(Map<String,Object> map){
			FundAccountBillDelRecordPo fundAccountBillDelRecordPo=(FundAccountBillDelRecordPo)map.get("fundAccountBillDelRecordPo");
			StringBuffer sql=new StringBuffer("INSERT INTO T_CWGL_DELRECORDER VALUES ");
			if(fundAccountBillDelRecordPo!=null){
				sql.append("('"+fundAccountBillDelRecordPo.getfId()+"',");
				sql.append("'"+fundAccountBillDelRecordPo.getfName()+"',");
				sql.append("'"+fundAccountBillDelRecordPo.getFnumber()+"',");
				sql.append("'"+fundAccountBillDelRecordPo.getfAmount()+"',");
				sql.append("'"+fundAccountBillDelRecordPo.getfDeldate()+"',");
				sql.append("'"+fundAccountBillDelRecordPo.getfPayment()+"',");
				sql.append("'"+fundAccountBillDelRecordPo.getfOprationer()+"',");
				sql.append("'"+fundAccountBillDelRecordPo.getfRemark()+"')");
			}
			logger.debug("添加删除记录的sql语句为"+sql.toString());
			return sql.toString();
		}
		public String selectRecord(Map<String, Object> params) {
			String fOprationer = (String) params.get("fOprationer");
			String Edate = (String) params.get("Edate");
			String Ldate = (String) params.get("Ldate");
			StringBuffer sql = new StringBuffer();
			sql.append("select " +
					"record.Fname,record.FAmount,record.Fdeldate,record.FPayment,staff.FStaffName,record.Fremark " +
					"from T_CWGL_DELRECORDER record,T_STAFF_MESSAGE staff " +
					"where staff.FID=record.Foprationer ");
			if ((fOprationer != null) && (fOprationer.length() != 0)) {
				sql.append(" and staff.FStaffName = '" + fOprationer + "'");
			}
			if ((Edate != null) && (Edate.length() != 0)) {
				sql.append(" and record.Fdeldate >= '" + Edate + "'");
			}
			if ((Ldate != null) && (Ldate.length() != 0)) {
				sql.append(" and record.Fdeldate <= '" + Ldate + "'");
			}
			sql.append(" order by record.Fdeldate desc limit #{page},#{pageSize}");
			return sql.toString();
		}
		public String selectRecordCount(Map<String, Object> params) {
			String fOprationer = (String) params.get("fOprationer");
			String Edate = (String) params.get("Edate");
			String Ldate = (String) params.get("Ldate");
			StringBuffer sql = new StringBuffer();
			sql.append("select count(*) from T_CWGL_DELRECORDER record,T_STAFF_MESSAGE staff where staff.FID=record.Foprationer ");
			if ((fOprationer != null) && (fOprationer.length() != 0)) {
				sql.append(" and staff.FStaffName = '" + fOprationer + "'");
			}
			if ((Edate != null) && (Edate.length() != 0)) {
				sql.append(" and record.Fdeldate >= '" + Edate + "'");
			}
			if ((Ldate != null) && (Ldate.length() != 0)) {
				sql.append(" and record.Fdeldate <= '" + Ldate + "'");
			}
			return sql.toString();
		}
	}

}
