package com.channelsoft.ems.mapper;

import java.util.List;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManRelationPo;
/**
 *  老人家属信息的添加
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2016年12月22日
 */
public interface OldManRelationMapper {
	
	@Update("UPDATE T_OldMan_Relation SET FOldManID=#{fOldManID},FRelation=#{fRelation},FRelationName=#{fRelationName},FRelationSex=#{fRelationSex},FRelationAge=#{fRelationAge}"
			+ ",FRelationMobile=#{fRelationMobile},FRelationPhone=#{fRelationPhone},FRelationQQ=#{fRelationQQ},FRelationMM=#{fRelationMM},FRelationCompany=#{fRelationCompany}"
			+ ",FRelationAdrress=#{fRelationAdrress},FNursingHomeID=#{fNursingHomeID},FCreatorID=#{fCreatorID},FCreateTime=#{fCreateTime} WEHRE FID=#{fID}")
	public void updateOldManRelation(OldManRelationPo oldManRelationPo);
	
	@InsertProvider(type=OldManRelationProvider.class,method="addMoreRelation")
	public int addOldManRelation(@Param("oldManRelationPo")OldManRelationPo oldManRelationPo);
	/**
	 * 得到数据字典中的亲属关系
	 * @param dict
	 * @return
	 */
	@SelectProvider(type=OldManRelationProvider.class,method="getRelation")
	@Results(value={
					@Result(column="DC_NAME",property="name",javaType=String.class,jdbcType=JdbcType.VARCHAR),
					@Result(column="DC_VALUE",property="value",javaType=String.class,jdbcType=JdbcType.VARCHAR),
					@Result(column="DC_ID",property="id",javaType=String.class,jdbcType=JdbcType.VARCHAR)
				})
	public List<DataDictionaryPo> queryRelationPo(@Param("dict")DataDictionaryPo dict);
	/**
	 * 查询老人的亲属信息
	 * @param oldManRelationPo
	 * @return
	 */
	@SelectProvider(type=OldManRelationProvider.class,method="queryRelation")
	@Results(value={
			@Result(column="FID",property="fID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FOldManID",property="fOldManID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRelation",property="fRelation",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRelationName",property="fRelationName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRelationSex",property="fRelationSex",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRelationAge",property="fRelationAge",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRelationMobile",property="fRelationMobile",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRelationPhone",property="fRelationPhone",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRelationQQ",property="fRelationQQ",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRelationMM",property="fRelationMM",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRelationCompany",property="fRelationCompany",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRelationAdrress",property="fRelationAdrress",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FNursingHomeID",property="fNursingHomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreatorID",property="fCreatorID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreateTime",property="fCreateTime",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	})
	public List<OldManRelationPo> queryRelation(@Param("oldManRelationPo")OldManRelationPo oldManRelationPo);
	
	@UpdateProvider(type=OldManRelationProvider.class,method="updateRelation")
	public int updateRelation(@Param("oldManRelationPo")OldManRelationPo oldManRelationPo);
	
	class OldManRelationProvider{
		Logger logger=Logger.getLogger(OldManRelationProvider.class);
		/**
		 * 用于处理批量添加的方法
		 * @param map
		 * @return
		 */
		public String addMoreRelation(Map<String,Object> map){
			OldManRelationPo oldManRelationPo=(OldManRelationPo)map.get("oldManRelationPo");
			//将sql语句拼成 insert into () values (),()形式
			StringBuffer sql=new StringBuffer("INSERT INTO T_OldMan_Relation (FOldManID,FRelation,FRelationName,FRelationSex,FRelationAge,FRelationMobile,FRelationPhone,FRelationQQ,FRelationMM,FRelationCompany,FRelationAdrress,FNursingHomeID,FCreatorID,FCreateTime) VALUES ");
				sql.append("(");
				sql.append("'").append(oldManRelationPo.getfOldManID()).append("',");
				sql.append("'"+oldManRelationPo.getfRelation()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfRelationName()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfRelationSex()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfRelationAge()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfRelationMobile()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfRelationPhone()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfRelationQQ()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfRelationMM()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfRelationCompany()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfRelationAdrress()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfNursingHomeID()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfCreatorID()+"'").append(",");
				sql.append("'"+oldManRelationPo.getfCreateTime()+"'").append("),");
			//去掉最后一个逗号
			logger.debug("添加亲属的sql语句为"+sql.toString().substring(0,(sql.toString().length()-1)));
			return sql.toString().substring(0,(sql.toString().length()-1));
		}
		/**
		 * 回显亲属信息
		 * @param map
		 * @return
		 */
		public String getRelation(Map<String,Object> map){
			StringBuffer sql=new StringBuffer("SELECT * FROM DATA_DICTIONARY WHERE 1=1 AND DC_STATUS<>'10' ");
			DataDictionaryPo dict=(DataDictionaryPo) map.get("dict");
			if(dict.getId()!=null&&!StringUtils.isEmpty(dict.getId())){
				sql.append(" AND DC_ID='"+dict.getId()+"'");
			}
			if(dict.getName()!=null&&!StringUtils.isEmpty(dict.getName())){
				sql.append(" AND DC_NAME=").append("'"+dict.getName()+"'");
				return sql.toString();
			}
			return sql.toString();
		}
		/**
		 * 查询老人的亲属关系
		 * @param oldManMainPo
		 * @return
		 */
		public String queryRelation(Map<String,Object> oldManRelationPo){
			OldManRelationPo oldMan=(OldManRelationPo)oldManRelationPo.get("oldManRelationPo");
			StringBuffer sql=new StringBuffer("SELECT T_OldMan_Relation.FID,T_OldMan_Relation.FOldManID,T_OldMan_Relation.FRelation,T_OldMan_Relation.FRelationName,"
					+ "T_OldMan_Relation.FRelationSex,T_OldMan_Relation.FRelationAge,T_OldMan_Relation.FRelationMobile,T_OldMan_Relation.FRelationPhone,T_OldMan_Relation.FRelationQQ,"
					+ "T_OldMan_Relation.FRelationMM,T_OldMan_Relation.FRelationCompany,T_OldMan_Relation.FRelationAdrress,T_OldMan_Relation.FNursingHomeID,T_OldMan_Relation.FCreatorID,T_OldMan_Relation.FCreateTime FROM T_OldMan_Relation,T_OldMan_Main  WHERE T_OldMan_Relation.FOldManID=T_OldMan_Main.FID AND T_OldMan_Main.FoldManStatusID<>'111' AND T_OldMan_Main.FoldManStatusID<>'195' ");
			if(oldMan!=null){
				if(!StringUtils.isEmpty(oldMan.getfID())){
					sql.append(" AND T_OldMan_Relation.FID='"+oldMan.getfID()+"'");
					return sql.toString();
				}
				if(!StringUtils.isEmpty(oldMan.getfOldManID())){
					sql.append(" AND FOldManID='"+oldMan.getfOldManID()+"'");
					return sql.toString();
				}
				if(!StringUtils.isEmpty(oldMan.getfOldManName())){
					sql.append(" AND FoldManName LIKE '%"+oldMan.getfOldManName()+"%'");
				}
			}else{
				return sql.toString();
			}
			logger.debug("查询老人亲属信息的sql语句为"+sql.toString());
			return sql.toString();
		}
		
		
		/**
		 * 修改老人亲属信息
		 * @param oldManRelationPo
		 * @return
		 */
		public String updateRelation(Map<String,Object> oldManRelationPo){
			OldManRelationPo relation=(OldManRelationPo)oldManRelationPo.get("oldManRelationPo");
			StringBuffer sql=new StringBuffer("UPDATE T_OldMan_Relation SET ");
			if(relation.getfID()!=null&&!StringUtils.isEmpty(relation.getfID())){
				sql.append(" FRelation='"+relation.getfRelation()+"',");
				sql.append("FRelationName='"+relation.getfRelationName()+"',");
				sql.append("FRelationSex='"+relation.getfRelationSex()+"',");
				sql.append("FRelationAge='"+relation.getfRelationAge()+"',");
				sql.append("FRelationMobile='"+relation.getfRelationMobile()+"',");
				sql.append("FRelationPhone='"+relation.getfRelationPhone()+"',");
				sql.append("FRelationQQ='"+relation.getfRelationQQ()+"',");
				sql.append("FRelationMM='"+relation.getfRelationMM()+"',");
				sql.append("FRelationCompany='"+relation.getfRelationCompany()+"',");
				sql.append("FRelationAdrress='"+relation.getfRelationAdrress()+"' ");
				sql.append("WHERE FID='"+relation.getfID()+"'");
			}
			logger.debug("修改老人亲属信息的sql语句为"+sql.toString());
			return sql.toString();
		}
	}

}
