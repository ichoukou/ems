package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.channelsoft.ems.po.BalancePo;

/**
 * 结算与反结算
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年2月28日
 */
public interface FundAccountCloseMapper {
	
	@SelectProvider(type=BanlanceProvider.class,method="queryBalance")
	@Results(value={
			@Result(column="Fid",property="fId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FnursinghomeID",property="fNursinghomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FFundaccountID",property="fFundaccountID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPeriod",property="fPeriod",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FMoun",property="fMoun",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAmount",property="fAmount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Foutamount",property="fOutamount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Finamount",property="fInamount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Fbalance",property="fBalance",javaType=String.class,jdbcType=JdbcType.VARCHAR)
			
	})
	public List<BalancePo> queryBalance(@Param("balancePo")BalancePo balancePo);
	
	@InsertProvider(type=BanlanceProvider.class,method="insertBalance")
	public int insertBalance(@Param("balancePo")BalancePo balancePo);
	
	@Select("SELECT FPeriod,MAX(FMoun)AS FMoun  FROM t_cwgl_balance WHERE FPeriod =(SELECT MAX(FPeriod) AS p  FROM t_cwgl_balance)  GROUP BY FPeriod ")
	@Results(value={
			@Result(column="FPeriod",property="fPeriod",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FMoun",property="fMoun",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	})
	public BalancePo getMaxDate();
	
	@DeleteProvider(type=BanlanceProvider.class,method="deleteBalance")
	public int deleteBalance(@Param("balancePo")BalancePo balancePo);

	@UpdateProvider(type=BanlanceProvider.class,method="updateBalance")
	public int updateBalance(@Param("balancePo")BalancePo balancePo);

	class BanlanceProvider{
		
		private Logger logger=Logger.getLogger(BanlanceProvider.class);
		
		/**
		 * 查询账户余额
		 * @param map
		 * @return
		 */
		public String queryBalance(Map<String,Object> map){
			BalancePo balance =(BalancePo)map.get("balancePo");
			StringBuffer sql=new StringBuffer("SELECT * FROM T_CWGL_BALANCE WHERE 1=1");
			if(balance!=null){
				if(!StringUtils.isEmpty(balance.getfFundaccountID())){
					sql.append(" AND FFundaccountID='"+balance.getfFundaccountID()+"'");
				}
				if(!StringUtils.isEmpty(balance.getfPeriod())){
					sql.append(" AND FPeriod='"+balance.getfPeriod()+"'");
				}
				if(!StringUtils.isEmpty(balance.getfMoun())){
					if(balance.getfMoun().length()>1){
						sql.append("AND   FMoun='"+balance.getfMoun()+"'");
					}else{
						sql.append(" AND  FMoun='0"+balance.getfMoun()+"'");
					}
					//sql.append(" AND FMoun='"+balance.getfMoun()+"'");
				}
			}
			logger.debug("查询余额表的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 添加账户余额
		 * @param map
		 * @return
		 */
		public String insertBalance(Map<String,Object> map){
			BalancePo balancePo=(BalancePo)map.get("balancePo");
			StringBuffer sql=new StringBuffer("INSERT INTO T_CWGL_BALANCE VALUES");
			if(balancePo!=null){
				//sql.append(" ('"+balancePo.getfId()+"',");
				sql.append("( null,");
				sql.append(" '"+balancePo.getfNursinghomeID()+"',");
				sql.append(" '"+balancePo.getfFundaccountID()+"',");
				sql.append(" '"+balancePo.getfPeriod()+"',");
				if(Integer.parseInt(balancePo.getfMoun())>=10){
					sql.append(" '"+balancePo.getfMoun()+"',");
				}else{
					sql.append(" '0"+balancePo.getfMoun()+"',");
				}
				sql.append(" '"+balancePo.getfAmount()+"',");
				sql.append(" '"+balancePo.getfOutamount()+"',");
				sql.append(" '"+balancePo.getfInamount()+"',");
				sql.append(" '"+balancePo.getfBalance()+"')");
			}
			logger.debug("添加账户余额的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 反结算
		 * @param map
		 * @return
		 */
		public String deleteBalance(Map<String,Object> map){
			BalancePo balancePo=(BalancePo)map.get("balancePo");
			StringBuffer sql=new StringBuffer();
			if(balancePo!=null){
				if(!StringUtils.isEmpty(balancePo.getfPeriod())&&!StringUtils.isEmpty(balancePo.getfMoun())){
					sql.append("DELETE FROM T_CWGL_BALANCE ");
					int period=Integer.parseInt(balancePo.getfPeriod());
					sql.append(" WHERE FPeriod="+period+"");
					int month=Integer.parseInt(balancePo.getfMoun());
					sql.append(" AND FMoun="+month+"");
					if(!StringUtils.isEmpty(balancePo.getfFundaccountID())){
						sql.append(" AND FFundaccountID='"+balancePo.getfFundaccountID()+"'");
					}
					return sql.toString();
				}
			}
			
			return sql.toString();
		}

		public String updateBalance(Map<String,Object> map){
			BalancePo balancePo=(BalancePo)map.get("balancePo");
			StringBuffer sql=new StringBuffer("UPDATE T_CWGL_BALANCE ");
			if(balancePo!=null){
				if(!StringUtils.isEmpty(balancePo.getfInamount())){
					sql.append(" SET Finamount='"+balancePo.getfInamount()+"'");
				}
				if(!StringUtils.isEmpty(balancePo.getfOutamount())){
					sql.append(", Foutamount='"+balancePo.getfOutamount()+"'");
				}
				if(!StringUtils.isEmpty(balancePo.getfBalance())){
					sql.append(", Fbalance='"+balancePo.getfBalance()+"'");
				}
				if(!StringUtils.isEmpty(balancePo.getfFundaccountID())){
					sql.append(" WHERE  FFundaccountID='"+balancePo.getfFundaccountID()+"'");
				}
				//按照月份和账户进行修改  这三个字段能都唯一确定一条记录
				if(!StringUtils.isEmpty(balancePo.getfPeriod())&&!StringUtils.isEmpty(balancePo.getfMoun())){
					sql.append(" AND FPeriod='"+balancePo.getfPeriod()+"'");
					sql.append(" AND FMoun='"+balancePo.getfMoun()+"'");
				}
			}
			logger.debug("更新账户余额表的sql语句为"+sql.toString());
			return sql.toString();
		}
	}

}
