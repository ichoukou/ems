package com.channelsoft.ems.mapper;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.channelsoft.ems.po.CwglPaymentPo;
import com.channelsoft.ems.po.FundAccountBillPo;

/**
 *	收支明细mapper
 * @author lizhu
 * @Copyright Channelsoft
 * @2017年1月9日
 */
public interface FundAccountBillMapper {

	@InsertProvider(type=BillProvider.class,method="addBill")
	public int addBill(@Param("fundAccountBillPo")FundAccountBillPo fundAccountBillPo);

	@SelectProvider(type=BillProvider.class,method="queryPayments")
	@Results(value = {
			@Result(column = "Fid", property = "fid", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FnursinghomeID", property = "fnursinghomeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FAuditorID", property = "fAuditorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FAuditTime", property = "fAuditTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FModifierID", property = "fModifierID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FModificationTime", property = "fModificationTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FRemarks", property = "fRemarks", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "Fnumber", property = "fnumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "Ffstatus", property = "ffstatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "Fname", property = "fname", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "Fparentid", property = "fparentid", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "Ftype", property = "ftype", javaType = String.class, jdbcType = JdbcType.VARCHAR)
	})
	public List<CwglPaymentPo> getPayments(@Param("id")String id,@Param("type")String type);

	@SelectProvider(type=BillProvider.class,method="queryBill")
	@Results(value={
			@Result(column="Fid",property="fId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FnursinghomeID",property="fnursinghomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAuditorID",property="fAuditorID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAuditTime",property="fAuditTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreatorID",property="fCreatorID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreateTime",property="fCreateTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FModifierID",property="fModifierID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FModificationTime",property="fModificationTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRemarks",property="fRemarks",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FNumber",property="fNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FStatus",property="fStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FType",property="fType",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAmount",property="fAmount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Fbizdate",property="fbizdate",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPayments",property="fPayments",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FBusinessitem",property="fBusinessitem",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FFundaccount",property="fFundaccount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPayment",property="fPayment",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FOperator",property="fOperator",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FProofnumber",property="fProofnumber",javaType=String.class,jdbcType=JdbcType.VARCHAR)
			//@Result(column="FProofdoc",property="FProofdoc",javaType=String.class,jdbcType=JdbcType.VARCHAR),
	})
	public List<FundAccountBillPo> queryFundAccountBillPo(@Param("page") int page,@Param("pageSize") int pageSize,@Param("fundAccountBillPo")FundAccountBillPo fundAccountBillPo);


	@SelectProvider(type=BillProvider.class,method="queryByMonth")
	@Results(value={
			@Result(column="Fid",property="fId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FnursinghomeID",property="fnursinghomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAuditorID",property="fAuditorID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAuditTime",property="fAuditTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreatorID",property="fCreatorID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreateTime",property="fCreateTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FModifierID",property="fModifierID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FModificationTime",property="fModificationTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRemarks",property="fRemarks",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FNumber",property="fNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FStatus",property="fStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FType",property="fType",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAmount",property="fAmount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Fbizdate",property="fbizdate",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPayments",property="fPayments",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FBusinessitem",property="fBusinessitem",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FFundaccount",property="fFundaccount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPayment",property="fPayment",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FOperator",property="fOperator",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FProofnumber",property="fProofnumber",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	})
	public List<FundAccountBillPo> queryByMonth(@Param("month")String month,@Param("fundAccount")String fundAccount,@Param("fType")String fType);

	@SelectProvider(type=BillProvider.class,method="queryDistinct")
	@Results(value={
			@Result(column="FFundaccount",property="fFundaccount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
	})
	public List<String> queryDistinct(@Param("month")String month);


	@SelectProvider(type=BillProvider.class,method="getTotal")
	public int getTotal(@Param("fundAccountBillPo")FundAccountBillPo fundAccountBillPo);


	@Update("UPDATE T_CWGL_FUNDACCOUNTBILL SET FSTATUS ='0' WHERE FID=#{fundAccountBillPo.fId}")
	public int changeStatus(@Param("fundAccountBillPo")FundAccountBillPo fundAccountBillPo);

	@UpdateProvider(type=BillProvider.class,method="updateBill")
	public int updateFundAccountBill(@Param("fundAccountBillPo")FundAccountBillPo fundAccountBillPo);

	@Delete("DELETE FROM T_CWGL_FUNDACCOUNTBILL WHERE FID=#{fundAccountBillPo.fId} ")
	public int delFundAccountBill(@Param("fundAccountBillPo")FundAccountBillPo fundAccountBillPo);

	class BillProvider{

		private Logger logger=Logger.getLogger(BillProvider.class);
		/**
		 * 添加
		 * @param map
		 * @return
		 */

		public String addBill(Map<String,Object> map){
			FundAccountBillPo fundAccountBillPo=(FundAccountBillPo)map.get("fundAccountBillPo");
			StringBuffer sql=new StringBuffer("INSERT INTO T_CWGL_FUNDACCOUNTBILL VALUES ");
			if(fundAccountBillPo!=null){
				sql.append("('"+fundAccountBillPo.getfId()+"',");
				sql.append("'"+fundAccountBillPo.getFnursinghomeID()+"',");
				sql.append("'"+fundAccountBillPo.getfAuditorID()+"',");
				sql.append("'"+fundAccountBillPo.getfAuditTime()+"',");
				sql.append("'"+fundAccountBillPo.getfCreatorID()+"',");
				sql.append("'"+fundAccountBillPo.getfCreateTime()+"',");
				sql.append("'"+fundAccountBillPo.getfModifierID()+"',");
				sql.append("'"+fundAccountBillPo.getfModificationTime()+"',");
				sql.append("'"+fundAccountBillPo.getfRemarks()+"',");
				sql.append("'"+fundAccountBillPo.getfNumber()+"',");
				sql.append("'"+fundAccountBillPo.getfStatus()+"',");
				sql.append("'"+fundAccountBillPo.getfType()+"',");
				sql.append("'"+fundAccountBillPo.getfAmount()+"',");
				sql.append("'"+fundAccountBillPo.getFbizdate()+"',");
				sql.append("'"+fundAccountBillPo.getfPayments()+"',");
				sql.append("'"+fundAccountBillPo.getfBusinessitem()+"',");
				sql.append("'"+fundAccountBillPo.getfFundaccount()+"',");
				sql.append("'"+fundAccountBillPo.getfPayment()+"',");
				sql.append("'"+fundAccountBillPo.getfOperator()+"',");
				sql.append("'"+fundAccountBillPo.getfProofnumber()+"',");
				sql.append("'"+fundAccountBillPo.getfProofdoc()+"')");
			}
			logger.debug("添加资金明细的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 查询收支明细
		 * @param map
		 * @return
		 */
		public String queryBill(Map<String,Object> map){
			FundAccountBillPo fundAccountBillPo=(FundAccountBillPo)map.get("fundAccountBillPo");
			StringBuffer sql=new StringBuffer("SELECT * FROM T_CWGL_FUNDACCOUNTBILL WHERE 1=1 ");
			if(fundAccountBillPo==null){
				sql.append(" LIMIT #{page},#{pageSize}");
				logger.debug("查询收支明细的sql语句为"+sql.toString());
				return sql.toString();
			}

			if(!StringUtils.isEmpty(fundAccountBillPo.getfId())){
				sql.append(" AND FID='"+fundAccountBillPo.getfId()+"'");
				logger.debug("查询的sql语句为"+sql.toString());
				return sql.toString();
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfType())){
				sql.append(" AND Ftype ='"+fundAccountBillPo.getfType()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfPayments())){
				sql.append(" AND FPayments ='"+fundAccountBillPo.getfPayments()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfStartDate())&&StringUtils.isEmpty(fundAccountBillPo.getfEndDate())){
				sql.append(" AND FCreateTime >='"+fundAccountBillPo.getfStartDate()+"' ");
			}else if(StringUtils.isEmpty(fundAccountBillPo.getfStartDate())&&!StringUtils.isEmpty(fundAccountBillPo.getfEndDate())){
				sql.append(" AND FCreateTime <='"+fundAccountBillPo.getfEndDate()+"' ");
			}else if(!StringUtils.isEmpty(fundAccountBillPo.getfStartDate())&&!StringUtils.isEmpty(fundAccountBillPo.getfEndDate())){
				sql.append(" AND FCreateTime BETWEEN '"+fundAccountBillPo.getfStartDate()+"' AND '"+fundAccountBillPo.getfEndDate()+"'");
			}
			/*if(!StringUtils.isEmpty(fundAccountBillPo.getfCreateTime())){
				String[] createDate=fundAccountBillPo.getfCreateTime().split("@");
				if(createDate.length==1){
					sql.append(" AND FCreateTime='"+createDate[0]+"'");
				}else{
					sql.append(" AND FCreateTime BETWEEN '"+createDate[0]+"' AND '"+createDate[1]+"'");
				}
			}*/
			if(!StringUtils.isEmpty(fundAccountBillPo.getfBusinessitem())){
				sql.append(" AND FBusinessitem ='"+fundAccountBillPo.getfBusinessitem()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfPayment())){
				sql.append(" AND  FPayment = '"+fundAccountBillPo.getfPayment()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfFundaccount())){
				sql.append(" AND FFundaccount = '"+fundAccountBillPo.getfFundaccount()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfOperator())){
				sql.append(" AND FOperator ='"+fundAccountBillPo.getfOperator()+"'");
			}

			if(!StringUtils.isEmpty(fundAccountBillPo.getfStatus())){
				sql.append(" AND FSTATUS ='"+fundAccountBillPo.getfStatus()+"'");
			}
			sql.append(" LIMIT #{page},#{pageSize}");
			logger.debug("查询收支明细的sql语句为"+sql.toString());
			return sql.toString();
		}

		/**
		 * 查询总数
		 * @param map
		 * @return
		 */
		public String getTotal(Map<String,Object> map){
			FundAccountBillPo fundAccountBillPo=(FundAccountBillPo)map.get("fundAccountBillPo");
			StringBuffer sql=new StringBuffer("SELECT COUNT(*) FROM T_CWGL_FUNDACCOUNTBILL WHERE 1=1 ");
			if(fundAccountBillPo==null){
				logger.debug("查询收支明细总数的sql语句为"+sql.toString());
				return sql.toString();
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfId())){
				sql.append(" AND FID='"+fundAccountBillPo.getfId()+"'");
				logger.debug("查询的sql语句为"+sql.toString());
				return sql.toString();
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfType())){
				sql.append(" AND Ftype ='"+fundAccountBillPo.getfType()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfPayments())){
				sql.append(" AND FPayments ='"+fundAccountBillPo.getfPayments()+"'");
			}
/*			if(!StringUtils.isEmpty(fundAccountBillPo.getfCreateTime())){
				String[] createDate=fundAccountBillPo.getfCreateTime().split("@");
				if(createDate.length==1){
					sql.append(" AND FCreateTime='"+createDate[0]+"'");
				}else{
					sql.append(" AND FCreateTime BETWEEN '"+createDate[0]+"' AND '"+createDate[1]+"'");
				}
			}*/
			if(!StringUtils.isEmpty(fundAccountBillPo.getfStartDate())&&StringUtils.isEmpty(fundAccountBillPo.getfEndDate())){
				sql.append(" AND FCreateTime >='"+fundAccountBillPo.getfStartDate()+"' ");
			}else if(StringUtils.isEmpty(fundAccountBillPo.getfStartDate())&&!StringUtils.isEmpty(fundAccountBillPo.getfEndDate())){
				sql.append(" AND FCreateTime <='"+fundAccountBillPo.getfEndDate()+"' ");
			}else if(!StringUtils.isEmpty(fundAccountBillPo.getfStartDate())&&!StringUtils.isEmpty(fundAccountBillPo.getfEndDate())){
				sql.append(" AND FCreateTime BETWEEN '"+fundAccountBillPo.getfStartDate()+"' AND '"+fundAccountBillPo.getfEndDate()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfBusinessitem())){
				sql.append(" AND FBusinessitem ='"+fundAccountBillPo.getfBusinessitem()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfPayment())){
				sql.append(" AND  FPayment = '"+fundAccountBillPo.getfPayment()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfFundaccount())){
				sql.append(" AND FFundaccount = '"+fundAccountBillPo.getfFundaccount()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfOperator())){
				sql.append(" AND FOperator ='"+fundAccountBillPo.getfOperator()+"'");
			}
			logger.debug("查询收支明细总数的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 修改收支明细记录
		 * @param map
		 * @return
		 */
		public String updateBill(Map<String,Object> map){
			FundAccountBillPo fundAccountBillPo=(FundAccountBillPo)map.get("fundAccountBillPo");
			StringBuffer sql=new StringBuffer("UPDATE T_CWGL_FUNDACCOUNTBILL SET ");
			if(!StringUtils.isEmpty(fundAccountBillPo.getfAmount())){
				sql.append("FAMOUNT='"+fundAccountBillPo.getfAmount()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfCreateTime())){
				sql.append(",FCreateTime='"+fundAccountBillPo.getfCreateTime()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfPayments())){
				sql.append(",FPayments='"+fundAccountBillPo.getfPayments()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfFundaccount())){
				sql.append(",FFundaccount='"+fundAccountBillPo.getfFundaccount()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfOperator())){
				sql.append(",Foperator='"+fundAccountBillPo.getfOperator()+"'");
			}
			if(!StringUtils.isEmpty(fundAccountBillPo.getfPayment())){
				sql.append(",FPayment='"+fundAccountBillPo.getfPayment()+"'");
			}
			sql.append(",FRemarks='"+fundAccountBillPo.getfRemarks()+"'");
			sql.append(" WHERE FID='"+fundAccountBillPo.getfId()+"'");
			logger.debug("修改收支明细的sql语句为"+sql.toString());
			return sql.toString();
		}

		public String queryPayments(Map<String,Object> map){
			String fid=(String)map.get("id");
			String fType=(String)map.get("type");
			StringBuffer sql=new StringBuffer("SELECT * FROM T_CWGL_Payments WHERE FID<>'"+fid+"'");
			if(!StringUtils.isEmpty(fType)){
				sql.append(" AND FTYPE='"+fType+"'");
			}
			logger.debug("查询杂项的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 按照月份查询收支明细
		 * @param map
		 * @return
		 */
		public String queryByMonth(Map<String,Object> map){
			String month=(String)map.get("month");
			String fundAccount=(String)map.get("fundAccount");
			String fType=(String)map.get("fType");
			StringBuffer sql=new StringBuffer("SELECT * FROM T_CWGL_FUNDACCOUNTBILL WHERE 1=1");
			if(!StringUtils.isEmpty(month)){
				sql.append(" AND DATE_FORMAT(Fbizdate,'%Y-%m')= '"+month+"'");
			}
			if(!StringUtils.isEmpty(fundAccount)){
				sql.append(" AND FFundaccount='"+fundAccount+"'");
			}
			//根据类型分成是期初和不是期初
			if(!StringUtils.isEmpty(fType)){
				sql.append(" AND Ftype='0'");
			}else{
				sql.append(" AND Ftype<>'0'");
			}
			logger.debug("按照月份查询明细的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 查询收支明细中 本月的记录中不重复的账号
		 * @param map
		 * @return
		 */
		public String queryDistinct(Map<String,Object> map){
			String month=(String)map.get("month");
			StringBuffer sql=new StringBuffer("SELECT DISTINCT(FFundaccount) FROM T_CWGL_FUNDACCOUNTBILL WHERE 1=1");
			if(!StringUtils.isEmpty("month")){
				sql.append(" AND DATE_FORMAT(Fbizdate,'%Y-%m')= '"+month+"'");
			}
			logger.debug("去重查询收支明细的sql语句"+sql.toString());
			return sql.toString();
		}
	}
}
