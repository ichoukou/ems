package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import com.channelsoft.ems.po.BalancePo;

/**
 *   账户余额Mapper
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年1月12日
 */
public interface BalanceMapper {
	
	@Results(value={
			@Result(column="Fid",property="fId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FnursinghomeID",property="fNursinghomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FFundaccountID",property="fFundaccountID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPeriod",property="fPeriod",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FMoun",property="fMoun",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAmount",property="fAmount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Foutamount",property="fOutamount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Finamount",property="fInamount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Fbalance",property="fBalance",javaType=String.class,jdbcType=JdbcType.VARCHAR),
	})
	@SelectProvider(type=BalanceProvider.class,method="queryByAccount")
	public List<BalancePo> queryByAccount(@Param("fNumber")String fNumber);
	
	class BalanceProvider{
		private Logger logger=Logger.getLogger(BalanceProvider.class);
		public String queryByAccount(Map<String,Object> map){
			String fNumber=(String)map.get("fNumber");
			StringBuffer sql=new StringBuffer("SELECT * FROM T_CWGL_BALANCE WHERE 1=1 ");
			if(fNumber!=null&&StringUtils.isNotEmpty(fNumber)){
				sql.append(" AND FFUNDACCOUNTID='"+fNumber+"'");
			}
			logger.debug("查询余额表中记录的sql语句为"+sql.toString());
			return sql.toString();
		}
	}
}
