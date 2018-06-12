package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.channelsoft.ems.po.DataDictionaryPo;
import org.apache.log4j.Logger;

public interface SysManagerMapper {
	public Logger logger=Logger.getLogger(SysManagerMapper.class);

	@SelectProvider(type=SysDcProvider.class,method ="queryCount")
	public int queryCount(@Param("param")DataDictionaryPo param);
	
	@SelectProvider(type = SysDcProvider.class, method = "queryDcList")
	@Results(value = {
			@Result(column = "DC_ID", property = "id", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column = "DC_NAME", property = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "DC_VALUE", property = "value", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "DC_STATUS", property = "status", javaType = String.class, jdbcType = JdbcType.VARCHAR)
	})
	public List<DataDictionaryPo> queryDcList(@Param("param") DataDictionaryPo param,@Param(value = "page") int page,
	@Param(value = "pageSize") int pageSize,@Param(value = "sortName") String sortName,@Param(value = "sortOrder") String sortOrder);

	@SelectProvider(type = SysDcProvider.class, method = "getDcList")
	@Results(value = {
			@Result(column = "DC_ID", property = "id", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column = "DC_NAME", property = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "DC_VALUE", property = "value", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "DC_STATUS", property = "status", javaType = String.class, jdbcType = JdbcType.VARCHAR)
	})
	public List<DataDictionaryPo> getDcList(@Param("param") DataDictionaryPo param);

	@SelectProvider(type = SysDcProvider.class, method = "checkDc")
	public int checkDc(@Param("param") DataDictionaryPo param);


	@Insert("insert into DATA_DICTIONARY(DC_NAME,DC_VALUE,DC_STATUS) values(#{name},#{value},#{status});")
	public int addData(DataDictionaryPo param);

	@Update("update DATA_DICTIONARY set DC_NAME=#{name},DC_VALUE=#{value},DC_STATUS=#{status}" +
			" where DC_ID=#{id};")
	public int updData(DataDictionaryPo param);

	@Update("update DATA_DICTIONARY set DC_STATUS=#{status} where DC_ID=#{id};")
	public int updDcStatus(DataDictionaryPo param);
	
	class SysDcProvider{
		public String getDcList(Map<String, Object> params) {
			StringBuffer sql = new StringBuffer();
			sql.append("select * from DATA_DICTIONARY where 1=1 ");
			logger.debug("查询数据字典语句（不分页）："+sql.toString());
			return sql.toString();
		}

		public String queryDcList(Map<String, Object> params) {
			DataDictionaryPo dc = (DataDictionaryPo) params.get("param");
			String sortName =  (String) params.get("sortName");
			String sortOrder =  (String) params.get("sortOrder");
			StringBuffer sql = new StringBuffer();
			sql.append("select * from DATA_DICTIONARY where 1=1 ");

			if(null != dc) {
				if(StringUtils.isNotEmpty(dc.getName())){
					sql.append(" and DC_NAME LIKE '%" + dc.getName() + "%'");
				}
				if(StringUtils.isNotEmpty(dc.getValue())){
					sql.append(" and DC_VALUE LIKE '%" + dc.getValue() + "%'");
				}
			}
//			System.out.println(sortName!=null||sortName!="");
//			System.out.println(sortName!="");
//			System.out.println(sortName);
//			System.out.println(sortName!=null);
//			System.out.println(StringUtils.isNotEmpty(sortName));

			if(sortName!=null){
				if(sortName.equals("name")){
					sql.append(" order by DC_NAME "+sortOrder+"");
				}

			}
			sql.append(" limit #{page},#{pageSize}");
			logger.debug("查询数据字典语句："+sql.toString());

			return sql.toString();
		}

		public String checkDc(Map<String, Object> params) {
			DataDictionaryPo dc = (DataDictionaryPo) params.get("param");
			StringBuffer sql = new StringBuffer();
			sql.append("select count(*) from DATA_DICTIONARY where 1=1 ");

			if(null != dc) {
				if(StringUtils.isNotEmpty(dc.getName())){
					sql.append(" and DC_NAME = '" + dc.getName() + "'");
				}
				if(StringUtils.isNotEmpty(dc.getValue())){
					sql.append(" and DC_VALUE = '" + dc.getValue() + "'");
				}
				if(StringUtils.isNotEmpty(dc.getStatus())){
					sql.append(" and DC_STATUS = '" + dc.getStatus() + "'");
				}
			}
			logger.debug("查询数据字典语句（验证）："+sql.toString());

			return sql.toString();
		}



		public String queryCount(Map<String,Object> params){
			DataDictionaryPo dc=(DataDictionaryPo) params.get("param");
			StringBuffer sql=new StringBuffer();
			sql.append("select count(*) from DATA_DICTIONARY where 1=1");


			if(null != dc) {
				if(StringUtils.isNotEmpty(dc.getName())){
					sql.append(" and DC_NAME LIKE '%" + dc.getName() + "%'");
				}
				if(StringUtils.isNotEmpty(dc.getValue())){
					sql.append(" and DC_VALUE LIKE '%" + dc.getValue() + "%'");
				}
			}

			logger.debug("查询数据字典总数语句："+sql.toString());
			return sql.toString();
		}
	}
		
}
