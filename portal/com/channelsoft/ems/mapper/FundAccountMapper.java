package com.channelsoft.ems.mapper;

import java.util.List;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;
import com.channelsoft.ems.po.FundAccountPo;

/**
 *  资金账户mapper
 * @author lizhu
 * @Copyright Channelsoft
 * @2017年1月5日
 */
public interface FundAccountMapper {

	@SelectProvider(type=FundAccountProvider.class,method="query")
	@Results(value={
			@Result(column="FID",property="fId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FNursing_homeID",property="fNursinghomeId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAuditorID",property="fAuditorId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAuditTime",property="fAuditTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreatorId",property="fCreatorId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreateTime",property="fCreateTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FModifierID",property="fModifierId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FModificationTime",property="fModificationTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRemarks",property="fRemarks",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Fnumber",property="fNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Fstatus",property="fStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Fname",property="fName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAmount",property="fAmount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FHeader",property="fHeader",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FStaffName",property="fStaffName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRestAmount",property="fRestAmount",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	})
	public List<FundAccountPo> queryFundAccount(@Param("page")int page,@Param("pageSize")int pageSize,@Param("fundAccountPo")FundAccountPo fundAccountPo);


	@SelectProvider(type=FundAccountProvider.class,method="queryIgnoreStatus")
	@Results(value={
			@Result(column="FID",property="fId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FNursing_homeID",property="fNursinghomeId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAuditorID",property="fAuditorId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAuditTime",property="fAuditTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreatorId",property="fCreatorId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreateTime",property="fCreateTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FModifierID",property="fModifierId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FModificationTime",property="fModificationTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRemarks",property="fRemarks",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Fnumber",property="fNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Fstatus",property="fStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Fname",property="fName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAmount",property="fAmount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FHeader",property="fHeader",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FStaffName",property="fStaffName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRestAmount",property="fRestAmount",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	})
	public List<FundAccountPo> queryIgnoreStatus(@Param("page")int page,@Param("pageSize")int pageSize,@Param("fundAccountPo")FundAccountPo fundAccountPo);

	@SelectProvider(type=FundAccountProvider.class,method="getCount")
	public int getCount(@Param("fundAccountPo")FundAccountPo fundAccountPo);

	@SelectProvider(type=FundAccountProvider.class,method="getCountIgnoreStatus")
	public int getCountIgnoreStatus(@Param("fundAccountPo")FundAccountPo fundAccountPo);

	@Select("SELECT DC_VALUE FROM DATA_DICTIONARY WHERE DC_ID=#{id}")
	public String getStatusNameById(@Param("id")String id);

	@UpdateProvider(type=FundAccountProvider.class,method="updateFundAccount")
	public int updateFundAccountStatus(@Param("fId")String fId,@Param("fStatus")String fStatus);

	@SelectProvider(type=FundAccountProvider.class,method="check")
	public int check(@Param("fundAccountPo")FundAccountPo fundAccountPo);

	@InsertProvider(type=FundAccountProvider.class,method="add")
	public int addFundAccount(@Param("fundAccountPo")FundAccountPo fundAccountPo);

	@UpdateProvider(type=FundAccountProvider.class,method="update")
	public int updateFundAccount(@Param("fundAccountPo")FundAccountPo fundAccountPo);

	@UpdateProvider(type=FundAccountProvider.class,method="updateAmount")
	public int updateAmount(@Param("fundAccountPo")FundAccountPo fundAccountPo);


	class FundAccountProvider{
		private Logger logger=Logger.getLogger(FundAccountProvider.class);
		/**
		 * 查询所有
		 * @param map
		 * @return
		 */
		public String query(Map<String,Object> map){
			FundAccountPo fundAccountPo=(FundAccountPo)map.get("fundAccountPo");
			int page=(Integer)map.get("page");
			int pageSize=(Integer)map.get("pageSize");
			StringBuffer sql=new StringBuffer("SELECT T_CWGL_FUNDACCOUNT.FID,T_CWGL_FUNDACCOUNT.FNursing_homeID,T_CWGL_FUNDACCOUNT.FAuditorID,T_CWGL_FUNDACCOUNT.FAuditTime,T_CWGL_FUNDACCOUNT.FCreatorID,T_CWGL_FUNDACCOUNT.FCreateTime,"
					+ "T_CWGL_FUNDACCOUNT.FModifierID,T_CWGL_FUNDACCOUNT.FModificationTime,T_CWGL_FUNDACCOUNT.FRemarks,T_CWGL_FUNDACCOUNT.Fnumber,T_CWGL_FUNDACCOUNT.Fstatus,T_CWGL_FUNDACCOUNT.Fname,T_CWGL_FUNDACCOUNT.FAmount,T_CWGL_FUNDACCOUNT.FRestAmount,T_CWGL_FUNDACCOUNT.FHeader,T_CWGL_FUNDACCOUNT.FHeader,T_STAFF_MESSAGE.FStaffName"
					+ " FROM T_CWGL_FUNDACCOUNT,T_STAFF_MESSAGE "
					+ "WHERE T_CWGL_FUNDACCOUNT.FHeader=T_STAFF_MESSAGE.FID AND 1=1 AND Fstatus='0'  ");
			if(fundAccountPo!=null){
				if(fundAccountPo.getfId()!=null&&!StringUtils.isEmpty(fundAccountPo.getfId())){
					sql.append(" AND T_CWGL_FUNDACCOUNT.FID='"+fundAccountPo.getfId()+"'");
					logger.debug("根据id查询账户的sql语句为"+sql.toString());
					return sql.toString();
				}
				if(fundAccountPo.getfName()!=null&&!fundAccountPo.getfName().equals("")){
					sql.append("AND T_CWGL_FUNDACCOUNT.FNAME LIKE '%"+fundAccountPo.getfName()+"%'");
				}
				if(fundAccountPo.getfHeader()!=null&&!fundAccountPo.getfHeader().equals("")){
					sql.append(" AND T_STAFF_MESSAGE.FStaffName LIKE '%"+fundAccountPo.getfHeader()+"%'");
				}
				if(fundAccountPo.getfStatus()!=null&&!fundAccountPo.getfStatus().equals("")){
					sql.append(" AND T_CWGL_FUNDACCOUNT.FSTATUS = '"+fundAccountPo.getfStatus()+"'");
				}
				//回显除了该账户之外的所有账户信息
				if(StringUtils.isNotEmpty(fundAccountPo.getfNumber())){
					sql.append(" AND FNUMBER <> '"+fundAccountPo.getfNumber()+"'");
				}
			}
			sql.append(" LIMIT "+page+","+pageSize+"");
			logger.debug("查询资金用户的sql语句为"+sql.toString());
			return sql.toString();
		}


		/**
		 * 查询所有
		 * @param map
		 * @return
		 */
		public String queryIgnoreStatus(Map<String,Object> map){
			FundAccountPo fundAccountPo=(FundAccountPo)map.get("fundAccountPo");
			int page=(Integer)map.get("page");
			int pageSize=(Integer)map.get("pageSize");
			StringBuffer sql=new StringBuffer("SELECT T_CWGL_FUNDACCOUNT.FID,T_CWGL_FUNDACCOUNT.FNursing_homeID,T_CWGL_FUNDACCOUNT.FAuditorID,T_CWGL_FUNDACCOUNT.FAuditTime,T_CWGL_FUNDACCOUNT.FCreatorID,T_CWGL_FUNDACCOUNT.FCreateTime,"
					+ "T_CWGL_FUNDACCOUNT.FModifierID,T_CWGL_FUNDACCOUNT.FModificationTime,T_CWGL_FUNDACCOUNT.FRemarks,T_CWGL_FUNDACCOUNT.Fnumber,T_CWGL_FUNDACCOUNT.Fstatus,T_CWGL_FUNDACCOUNT.Fname,T_CWGL_FUNDACCOUNT.FAmount,T_CWGL_FUNDACCOUNT.FRestAmount,T_CWGL_FUNDACCOUNT.FHeader,T_CWGL_FUNDACCOUNT.FHeader,T_STAFF_MESSAGE.FStaffName"
					+ " FROM T_CWGL_FUNDACCOUNT,T_STAFF_MESSAGE "
					+ "WHERE T_CWGL_FUNDACCOUNT.FHeader=T_STAFF_MESSAGE.FID AND 1=1  ");
			if(fundAccountPo!=null){
				if(fundAccountPo.getfId()!=null&&!StringUtils.isEmpty(fundAccountPo.getfId())){
					sql.append(" AND T_CWGL_FUNDACCOUNT.FID='"+fundAccountPo.getfId()+"'");
					logger.debug("根据id查询账户的sql语句为"+sql.toString());
					return sql.toString();
				}
				if(fundAccountPo.getfName()!=null&&!fundAccountPo.getfName().equals("")){
					sql.append("AND T_CWGL_FUNDACCOUNT.FNAME LIKE '%"+fundAccountPo.getfName()+"%'");
				}
				if(fundAccountPo.getfHeader()!=null&&!fundAccountPo.getfHeader().equals("")){
					sql.append(" AND T_STAFF_MESSAGE.FStaffName LIKE '%"+fundAccountPo.getfHeader()+"%'");
				}
				if(fundAccountPo.getfStatus()!=null&&!fundAccountPo.getfStatus().equals("")){
					sql.append(" AND T_CWGL_FUNDACCOUNT.FSTATUS = '"+fundAccountPo.getfStatus()+"'");
				}
				//回显除了该账户之外的所有账户信息
				if(StringUtils.isNotEmpty(fundAccountPo.getfNumber())){
					sql.append(" AND FNUMBER <> '"+fundAccountPo.getfNumber()+"'");
				}
			}
			sql.append(" LIMIT "+page+","+pageSize+"");
			logger.debug("查询资金用户的sql语句为"+sql.toString());
			return sql.toString();
		}


		/**
		 *
		 * @param map
		 * @return
		 */
		public String getCount(Map<String,Object> map){
			FundAccountPo fundAccountPo=(FundAccountPo)map.get("fundAccountPo");
			StringBuffer sql=new StringBuffer("SELECT COUNT(*) FROM T_CWGL_FUNDACCOUNT,T_STAFF_MESSAGE WHERE T_CWGL_FUNDACCOUNT.FHeader=T_STAFF_MESSAGE.FID AND 1=1 AND Fstatus='0' ");
			if(fundAccountPo!=null){

				if(fundAccountPo.getfId()!=null&&!StringUtils.isEmpty(fundAccountPo.getfId())){
					sql.append(" AND T_CWGL_FUNDACCOUNT.FID='"+fundAccountPo.getfId()+"'");
					logger.debug("查询账户信息的sql语句为"+sql.toString());
					return sql.toString();
				}

				if(fundAccountPo.getfName()!=null&&!fundAccountPo.getfName().equals("")){
					sql.append("AND FNAME LIKE '%"+fundAccountPo.getfName()+"%'");
				}
				if(fundAccountPo.getfHeader()!=null&&!fundAccountPo.getfHeader().equals("")){
					sql.append(" AND FHEADER LIKE '%"+fundAccountPo.getfHeader()+"%'");
				}
				if(fundAccountPo.getfStatus()!=null&&!fundAccountPo.getfStatus().equals("")){
					sql.append(" AND FSTATUS = '"+fundAccountPo.getfStatus()+"'");
				}
				//回显除了该账户之外的所有账户信息
				if(fundAccountPo.getfNumber()!=null&&StringUtils.isNotEmpty(fundAccountPo.getfNumber())){
					sql.append(" AND FNUMBER <> '"+fundAccountPo.getfNumber()+"'");
				}
			}
			logger.debug("查询资金账户的sql语句为"+sql.toString());
			return sql.toString();
		}


		/**
		 *
		 * @param map
		 * @return
		 */
		public String getCountIgnoreStatus(Map<String,Object> map){
			FundAccountPo fundAccountPo=(FundAccountPo)map.get("fundAccountPo");
			StringBuffer sql=new StringBuffer("SELECT COUNT(*) FROM T_CWGL_FUNDACCOUNT,T_STAFF_MESSAGE WHERE T_CWGL_FUNDACCOUNT.FHeader=T_STAFF_MESSAGE.FID AND 1=1 ");
			if(fundAccountPo!=null){

				if(fundAccountPo.getfId()!=null&&!StringUtils.isEmpty(fundAccountPo.getfId())){
					sql.append(" AND T_CWGL_FUNDACCOUNT.FID='"+fundAccountPo.getfId()+"'");
					logger.debug("查询账户信息的sql语句为"+sql.toString());
					return sql.toString();
				}

				if(fundAccountPo.getfName()!=null&&!fundAccountPo.getfName().equals("")){
					sql.append("AND FNAME LIKE '%"+fundAccountPo.getfName()+"%'");
				}
				if(fundAccountPo.getfHeader()!=null&&!fundAccountPo.getfHeader().equals("")){
					sql.append(" AND FHEADER LIKE '%"+fundAccountPo.getfHeader()+"%'");
				}
				if(fundAccountPo.getfStatus()!=null&&!fundAccountPo.getfStatus().equals("")){
					sql.append(" AND FSTATUS = '"+fundAccountPo.getfStatus()+"'");
				}
				//回显除了该账户之外的所有账户信息
				if(fundAccountPo.getfNumber()!=null&&StringUtils.isNotEmpty(fundAccountPo.getfNumber())){
					sql.append(" AND FNUMBER <> '"+fundAccountPo.getfNumber()+"'");
				}
			}
			logger.debug("查询资金账户的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 *
		 * @param map
		 * @return
		 */
		public String updateFundAccount(Map<String,Object> map){
			String fId=(String)map.get("fId");
			String fStatus=(String)map.get("fStatus");
			StringBuffer sql=new StringBuffer("UPDATE T_CWGL_FUNDACCOUNT SET FSTATUS=");
			if(fStatus.equals("1")){
				sql.append("'0'");
			}else{
				sql.append("'1'");
			}
			sql.append(" WHERE FID='"+fId+"'");
			logger.debug("更改状态的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 校验是否存在
		 * @param map
		 * @return
		 */
		public String check(Map<String,Object> map){
			FundAccountPo fundAccountPo=(FundAccountPo)map.get("fundAccountPo");
			StringBuffer sql=new StringBuffer("SELECT COUNT(*) FROM T_CWGL_FUNDACCOUNT WHERE 1=1 ");
			if(fundAccountPo.getfName()!=null){
				sql.append("AND FNAME='"+fundAccountPo.getfName()+"'");
			}
			if(fundAccountPo.getfNumber()!=null){
				sql.append(" AND FNUMBER='"+fundAccountPo.getfNumber()+"'");
			}
			if(fundAccountPo.getfId()!=null&&StringUtils.isNotEmpty(fundAccountPo.getfId())){
				sql.append(" AND FID <> '"+fundAccountPo.getfId()+"'");
			}
			logger.debug("校验的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 新增资金账户信息
		 * @param map
		 * @return
		 */
		public String add(Map<String,Object> map){
			FundAccountPo fundAccountPo=(FundAccountPo)map.get("fundAccountPo");
			StringBuffer sql=new StringBuffer("INSERT INTO T_CWGL_FUNDACCOUNT VALUE ");
			if(fundAccountPo!=null){
				sql.append(" ('"+fundAccountPo.getfId()+"',");
				sql.append("'"+fundAccountPo.getfNursinghomeId()+"',");
				sql.append("'"+fundAccountPo.getfAuditorId()+"',");
				sql.append("'"+fundAccountPo.getfAuditTime()+"',");
				sql.append("'"+fundAccountPo.getfCreatorId()+"',");
				sql.append("'"+fundAccountPo.getfCreateTime()+"',");
				sql.append("'"+fundAccountPo.getfModifierId()+"',");
				sql.append("'"+fundAccountPo.getfModificationTime()+"',");
				sql.append("'"+fundAccountPo.getfRemarks()+"',");
				sql.append("'"+fundAccountPo.getfNumber()+"',");
				sql.append("'"+fundAccountPo.getfStatus()+"',");
				sql.append("'"+fundAccountPo.getfName()+"',");
				sql.append("'"+fundAccountPo.getfAmount()+"',");
				sql.append("'"+fundAccountPo.getfHeader()+"',");
				sql.append("'"+fundAccountPo.getfRestAmount()+"')");
			}
			return sql.toString();
		}
		/**
		 * 修改资金账户信息
		 * @param map
		 * @return
		 */
		public String update(Map<String,Object> map){
			FundAccountPo fundAccountPo=(FundAccountPo)map.get("fundAccountPo");
			StringBuffer sql=new StringBuffer("UPDATE T_CWGL_FUNDACCOUNT SET ");
			if(fundAccountPo!=null){
				sql.append(" FMODIFIERID='"+fundAccountPo.getfModifierId()+"',");
				sql.append("FMODIFICATIONTIME='"+fundAccountPo.getfModificationTime()+"',");
				sql.append("FNAME='"+fundAccountPo.getfName()+"',");
				sql.append("FNUMBER='"+fundAccountPo.getfNumber()+"',");
				sql.append("FAMOUNT='"+fundAccountPo.getfAmount()+"',");
				sql.append("FHEADER='"+fundAccountPo.getfHeader()+"'");
				sql.append(" WHERE FID='"+fundAccountPo.getfId()+"'");
			}
			logger.debug("更改账户信息的sql为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 账户余额更改
		 * @param map
		 * @return
		 */
		public String updateAmount(Map<String,Object> map){
			FundAccountPo fundAccountPo=(FundAccountPo)map.get("fundAccountPo");
			StringBuffer sql=new StringBuffer("UPDATE T_CWGL_FUNDACCOUNT SET ");
			if(fundAccountPo.getfRestAmount()!=null&&!StringUtils.isEmpty(fundAccountPo.getfRestAmount())){
				sql.append("FRESTAMOUNT=FRESTAMOUNT+'"+fundAccountPo.getfRestAmount()+"'");
				sql.append(" WHERE FID='"+fundAccountPo.getfId()+"'");
				logger.debug("更改账户余额的sql语句为"+sql.toString());
				return sql.toString();
			}else{
				return null;
			}
		}
	}
}
