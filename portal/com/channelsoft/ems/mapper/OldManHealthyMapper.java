package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import com.channelsoft.ems.po.OldManHealthyPo;
import com.channelsoft.ems.po.OldManMainPo;

/**
 * 老人健康管理mapper
 * @author lizhu
 *
 */
public interface OldManHealthyMapper {
	
	/**
	 * 查询老人健康信息 
	 * @param oldManHealthy
	 * @return List<OldManHealthy>
	 */
	@SelectProvider(type=OldManHeathySelProvier.class,method="queryToList")
	@Results(value={
			@Result(column="FID",property="fID",javaType=Integer.class,jdbcType=JdbcType.INTEGER),
			@Result(column="FOldManID",property="fOldManID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FOldManName",property="fOldManName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FHealthyCondition",property="fHealthyCondition",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FMedicalHistory",property="fMedicalHistory",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FDietTrait",property="fDietTrait",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FHobby",property="fHobby",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FAttention",property="fAttention",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FNursingHomeID",property="fNursingHomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreatorID",property="fCreatorID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCreateTime",property="fCreateTime",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	})
	public List<OldManHealthyPo> queryAll(@Param("page") int page,@Param("pageSize") int pageSize,@Param("oldManMainPo")OldManMainPo oldManMainPo);
	
	@SelectProvider(type=OldManHeathySelProvier.class,method="getTotal")
	public int getTotal(@Param("oldManMainPo")OldManMainPo oldManMainPo);
	
	@Insert("INSERT INTO T_OldMan_Healthy (FOldManID,FHealthyCondition,FMedicalHistory,FDietTrait,FHobby,FAttention,FNursingHomeID,FCreatorID,FCreateTime) VALUES(#{fOldManID},#{fHealthyCondition},#{fMedicalHistory},#{fDietTrait},#{fHobby},#{fAttention},#{fNursingHomeID},#{fCreatorID},#{fCreateTime})")
	public int addOldManHealthy(OldManHealthyPo oldManHealthy);
	
	@UpdateProvider(type=OldManHeathySelProvier.class,method="update")
	public int updateOldManHealthy(@Param("oldManHealthyPo")OldManHealthyPo oldManHealthyPo); 
	
	class OldManHeathySelProvier{
		Logger logger=Logger.getLogger(OldManHealthyMapper.class);
		/**
		 *返回查询语句 
		 * @param oldManHealthy
		 * @return
		 */
		public String queryToList(Map<String,Object> oldManMainPo){
			OldManMainPo oldManMain=(OldManMainPo)oldManMainPo.get("oldManMainPo");
			int page=(Integer)oldManMainPo.get("page");
			int pageSize=(Integer)oldManMainPo.get("pageSize");
			StringBuffer sql=new StringBuffer("SELECT T_OldMan_Healthy.FID,T_OldMan_Healthy.FOldManID,T_OldMan_Healthy.FHealthyCondition,T_OldMan_Healthy.FMedicalHistory,T_OldMan_Healthy.FDietTrait,T_OldMan_Healthy.FHobby, T_OldMan_Healthy.FAttention ,T_OldMan_Main.FoldManName FROM T_OldMan_Healthy,T_OldMan_Main WHERE T_OldMan_Healthy.FOldManID=T_OldMan_Main.FID AND T_OldMan_Main.FoldManStatusID<>'111' AND T_OldMan_Main.FoldManStatusID<>'195' ");
			if(oldManMain!=null){
				if(!StringUtils.isEmpty(oldManMain.getfID())){
					sql.append(" AND T_OldMan_Main.FID='"+oldManMain.getfID()+"' LIMIT 0,1");
					logger.debug("根据老人id查询健康信息的sql语句为"+sql.toString());
					return sql.toString();
				}
				if(!StringUtils.isEmpty(oldManMain.getFoldManName())){
					sql.append(" AND T_OldMan_Main.FoldManName LIKE '%"+oldManMain.getFoldManName()+"%'");
				}
			}else{
				return sql.toString();
			}
			sql.append(" LIMIT "+page+","+pageSize+"");
			logger.debug("查询健康信息的sql语句为"+sql.toString());
			return sql.toString();
		}
		
		/**
		 * 得到总条数
		 * @return
		 */
		public String getTotal(Map<String,Object> oldManMainPo){
			OldManMainPo oldManMain=(OldManMainPo)oldManMainPo.get("oldManMainPo");
			StringBuffer sql=new StringBuffer("SELECT COUNT(*) FROM T_OldMan_Healthy,T_OldMan_Main WHERE T_OldMan_Healthy.FOldManID=T_OldMan_Main.FID AND T_OldMan_Main.FoldManStatusID<>'111' AND T_OldMan_Main.FoldManStatusID<>'195' ");
			if(oldManMain!=null){
				if(!StringUtils.isEmpty(oldManMain.getfID())){
					sql.append(" AND T_OldMan_Main.FID='"+oldManMain.getfID()+"' LIMIT 0,1");
					logger.debug("根据老人id查询健康信息的sql语句为"+sql.toString());
					return sql.toString();
				}
				if(!StringUtils.isEmpty(oldManMain.getFoldManName())){
					sql.append(" AND T_OldMan_Main.FoldManName LIKE '%"+oldManMain.getFoldManName()+"%'");
				}
			}else{
				return sql.toString();
			}
			logger.debug("查询健康信息总数的sql语句为"+sql.toString());
			return sql.toString();
		}
		
		/**
		 * 老人健康信息的修改
		 * @param oldManHealthyPo
		 * @return
		 */
		public String update(Map<String,Object> oldManHealthyPo){
			OldManHealthyPo oldManHealthy=(OldManHealthyPo)oldManHealthyPo.get("oldManHealthyPo");
			StringBuffer sql=new StringBuffer("UPDATE T_OldMan_Healthy SET");
			if(oldManHealthy!=null){
				sql.append(" FHealthyCondition='"+oldManHealthy.getfHealthyCondition()+"',");
				sql.append("FMedicalHistory='"+oldManHealthy.getfMedicalHistory()+"',");
				sql.append("FDietTrait='"+oldManHealthy.getfDietTrait()+"',");
				sql.append("fHobby='"+oldManHealthy.getfHobby()+"',");
				sql.append("fAttention='"+oldManHealthy.getfAttention()+"'");
				sql.append(" WHERE FOldManId='"+oldManHealthy.getfOldManID()+"'");
				logger.debug("修改老人健康信息的sql语句为"+sql.toString());
				return sql.toString();
			}else{
				return null;
			}
		}
	}
}
