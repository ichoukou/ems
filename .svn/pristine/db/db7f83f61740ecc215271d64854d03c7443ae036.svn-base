package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import com.channelsoft.ems.po.FundAccountBillPo;

/**
 * 月份分析
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年3月1日
 */
public interface MonthAnalyseMapper {
	@SelectProvider(type=AnalyseProvider.class,method="queryBill")
	@Results(value={
			@Result(column="FCreateTime",property="fCreateTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAmount",property="fAmount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
	})
	public List<FundAccountBillPo> queryFundAccountBillPo(@Param("page") int page,@Param("pageSize") int pageSize,@Param("fundAccountBillPo")FundAccountBillPo fundAccountBillPo);

	@SelectProvider(type=AnalyseProvider.class,method="queryByMonth")
	public String queryMonth(@Param("month")String month,@Param("fuHao")String fuHao);
	
	@SelectProvider(type=AnalyseProvider.class,method="getTotal")
	public int getTotal(@Param("fundAccountBillPo")FundAccountBillPo fundAccountBillPo);
	
class AnalyseProvider{
		
		private Logger logger=Logger.getLogger(AnalyseProvider.class);
		
		/**
		 * 查询收支明细
		 * @param map
		 * @return
		 */
		public String queryBill(Map<String,Object> map){
			FundAccountBillPo fundAccountBillPo=(FundAccountBillPo)map.get("fundAccountBillPo");
			// SELECT sum(FAmount),DATE_FORMAT(FCreateTime,'%Y-%m') FROM T_CWGL_FUNDACCOUNTBILL  where FCreateTime>'2017-03-05' and FAmount>0 GROUP BY DATE_FORMAT(FCreateTime,'%Y-%m')
			StringBuffer sql=new StringBuffer("SELECT sum(FAmount) AS FAmount,DATE_FORMAT(FCreateTime,'%Y-%m') AS FCreateTime FROM T_CWGL_FUNDACCOUNTBILL WHERE 1=1 ");
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
			sql.append(" GROUP BY DATE_FORMAT(FCreateTime,'%Y-%m')");
			sql.append(" LIMIT #{page},#{pageSize}");
			logger.debug("查询收支明细的sql语句为"+sql.toString());
			return sql.toString();
		}
		
		/**
		 * 按照月份查询收支明细
		 * @param map
		 * @return
		 */
		public String queryByMonth(Map<String,Object> map){
			String month=(String)map.get("month");
			String fuHao=(String)map.get("fuHao");
			StringBuffer sql=new StringBuffer("SELECT SUM(FAmount) FROM T_CWGL_FUNDACCOUNTBILL WHERE 1=1");
			if(!StringUtils.isEmpty(month)){
				sql.append(" AND DATE_FORMAT(FCreateTime,'%Y-%m')= '"+month+"'");
			}
			if(!StringUtils.isEmpty(fuHao)){
				sql.append(" AND fAmount"+fuHao+"0");
			}
			logger.debug("按照月份查询明细的sql语句为"+sql.toString());
			return sql.toString();
		}
		/**
		 * 查询总数
		 * @param map
		 * @return
		 */
		public String getTotal(Map<String,Object> map){
			FundAccountBillPo fundAccountBillPo=(FundAccountBillPo)map.get("fundAccountBillPo");
			// SELECT sum(FAmount),DATE_FORMAT(FCreateTime,'%Y-%m') FROM T_CWGL_FUNDACCOUNTBILL  where FCreateTime>'2017-03-05' and FAmount>0 GROUP BY DATE_FORMAT(FCreateTime,'%Y-%m')
			StringBuffer sql=new StringBuffer("SELECT COUNT(*) FROM (SELECT sum(FAmount) AS FAmount,DATE_FORMAT(FCreateTime,'%Y-%m') AS FCreateTime FROM T_CWGL_FUNDACCOUNTBILL WHERE 1=1 ");
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
			sql.append(" GROUP BY DATE_FORMAT(FCreateTime,'%Y-%m')) AS TOTAL");
			logger.debug("查询收支明细的sql语句为"+sql.toString());
			return sql.toString();
		}
	}
	
}
