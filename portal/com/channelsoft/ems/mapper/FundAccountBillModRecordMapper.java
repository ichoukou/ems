package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import com.channelsoft.ems.po.FundAccountBillDelRecordPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import com.channelsoft.ems.po.FundAccountBillModRecordPo;

/**
 *  账户明细修改表的操作
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年2月20日
 */
public interface FundAccountBillModRecordMapper {
	@Results(value = {
			@Result(column = "Fname", property = "fname", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FAmount", property = "fAmount", javaType = String.class, jdbcType = JdbcType.DECIMAL),
			@Result(column = "FchangAmount", property = "fChangeAmount", javaType = String.class, jdbcType = JdbcType.DECIMAL),
			@Result(column = "FnewAmount", property = "fNewAmount", javaType = String.class, jdbcType = JdbcType.DECIMAL),
			@Result(column = "Fchangdate", property = "fChangeDate", javaType = String.class, jdbcType = JdbcType.DATE),
			@Result(column = "FStaffName", property = "fOperationer", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "Fremark", property = "fRemark", javaType = String.class, jdbcType = JdbcType.VARCHAR),
	})

	@SelectProvider(type=FundAccountBillModRecordMapper.MapperProvider.class,method = "selectRecord")
	public List<FundAccountBillModRecordPo> queryModRecord(@Param("fOprationer") String fOprationer, @Param("Ldate")String Ldate, @Param("Edate")String Edate, @Param("page")int page, @Param("pageSize")int pageSize);
	@SelectProvider(type=FundAccountBillModRecordMapper.MapperProvider.class,method = "selectRecordCount")
	public int queryModRecordCount(@Param("fOprationer") String fOprationer,@Param("Ldate")String Ldate,@Param("Edate")String Edate,@Param("page")int page,@Param("pageSize")int pageSize);

	@InsertProvider(type=MapperProvider.class,method="insertRecord")
	public int insertRecord(@Param("fundAccountBillModRecordPo")FundAccountBillModRecordPo fundAccountBillModRecordPo);
	
	public class MapperProvider{
		private Logger logger=Logger.getLogger(MapperProvider.class);
		
		public String insertRecord(Map<String,Object> map){
			FundAccountBillModRecordPo fundAccountBillModRecordPo=(FundAccountBillModRecordPo)map.get("fundAccountBillModRecordPo");
			StringBuffer sql=new StringBuffer("INSERT INTO T_CWGL_MODRECORDER VALUES ");
			if(fundAccountBillModRecordPo!=null){
				sql.append("('"+fundAccountBillModRecordPo.getfId()+"',");
				sql.append("'"+fundAccountBillModRecordPo.getFnumber()+"',");
				sql.append("'"+fundAccountBillModRecordPo.getFname()+"',");
				sql.append("'"+fundAccountBillModRecordPo.getfAmount()+"',");
				sql.append("'"+fundAccountBillModRecordPo.getfNewAmount()+"',");
				sql.append("'"+fundAccountBillModRecordPo.getfChangeAmount()+"',");
				sql.append("'"+fundAccountBillModRecordPo.getfChangeDate()+"',");
				sql.append("'"+fundAccountBillModRecordPo.getfPayment()+"',");
				sql.append("'"+fundAccountBillModRecordPo.getfOperationer()+"',");
				sql.append("'"+fundAccountBillModRecordPo.getfRemark()+"')");
			}
			logger.debug("添加修改记录的sql语句为"+sql.toString());
			return sql.toString();
		}
		public String selectRecord(Map<String, Object> params) {
			String fOprationer = (String) params.get("fOprationer");
			String Edate = (String) params.get("Edate");
			String Ldate = (String) params.get("Ldate");
			StringBuffer sql = new StringBuffer();
			sql.append("select " +
					"record.Fname,record.Fchangdate,staff.FStaffName,record.FAmount,record.FchangAmount,record.FnewAmount,record.Fremark " +
					"from " +
					"T_CWGL_MODRECORDER record,T_STAFF_MESSAGE staff " +
					"where" +
					" staff.FID=record.Foprationer ");
			if ((fOprationer != null) && (fOprationer.length() != 0)) {
				sql.append(" and staff.FStaffName = '" + fOprationer + "'");
			}
			if ((Edate != null) && (Edate.length() != 0)) {
				sql.append(" and record.Fchangdate >= '" + Edate + "'");
			}
			if ((Ldate != null) && (Ldate.length() != 0)) {
				sql.append(" and record.Fchangdate <= '" + Ldate + "'");
			}
			sql.append(" order by record.Fchangdate desc limit #{page},#{pageSize}");
			return sql.toString();
		}
		public String selectRecordCount(Map<String, Object> params) {
			String fOprationer = (String) params.get("fOprationer");
			String Edate = (String) params.get("Edate");
			String Ldate = (String) params.get("Ldate");
			StringBuffer sql = new StringBuffer();
			sql.append("select count(*)" +
					"from " +
					"T_CWGL_MODRECORDER record,T_STAFF_MESSAGE staff " +
					"where" +
					" staff.FID=record.Foprationer ");
			if ((fOprationer != null) && (fOprationer.length() != 0)) {
				sql.append(" and staff.FStaffName = '" + fOprationer + "'");
			}
			if ((Edate != null) && (Edate.length() != 0)) {
				sql.append(" and record.Fchangdate >= '" + Edate + "'");
			}
			if ((Ldate != null) && (Ldate.length() != 0)) {
				sql.append(" and record.Fchangdate <= '" + Ldate + "'");
			}
			return sql.toString();
		}
	}

}
