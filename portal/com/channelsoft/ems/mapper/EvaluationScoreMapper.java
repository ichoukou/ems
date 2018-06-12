package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.channelsoft.ems.po.RangePo;




/** 
 * EvaluationScore Mapper 评估等级范围  
 * @author  wuhl
 * @date 创建时间：2016年11月13日 上午16:13:41 
 * @parameter  
 * @return  
 */

public interface EvaluationScoreMapper {

	@Insert("INSERT INTO T_EVALUATION_SCORE(FLevelID,FLevel_High,FLevel_Low,FLevelDesc,FNursinghomeID, FCreatorID,FCreateTime) VALUES(#{fLevelID},#{high},#{low},#{desc},#{fNursinghomeID},#{fCreatorID},now() )")
	public void addEvalScore(RangePo rangePo); 
	
	@Delete("DELETE  FROM T_EVALUATION_SCORE WHERE FScoreID=#{FScoreID}")
	public void deleteEvalScore(String fScoreID);
	

    //获取已经有的项目等级编号
    @Select(" select FLevelID ,FLevel_Low ,FLevel_High from T_EVALUATION_SCORE order by FLevel_Low  ")
    public List<Map<String,String>> queryFLevelID();
	
	@Select(" select FScoreID,DC_ID,DC_VALUE,FLevel_High,FLevel_Low,FLevelDesc from DATA_DICTIONARY l,T_EVALUATION_SCORE s where l.DC_ID=s.FLevelID order by s.FScoreID  ")
	@Results(value = {
			@Result(column="DC_ID",property="clevelId",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="FScoreID",property="fLevelID",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="DC_VALUE",property="clevelName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FLevel_High",property="high",javaType=String.class, jdbcType=JdbcType.INTEGER),
			@Result(column="FLevel_Low",property="low",javaType=String.class, jdbcType=JdbcType.INTEGER),
			@Result(column="FLevelDesc",property="desc",javaType=String.class, jdbcType=JdbcType.VARCHAR)		
	        })
	        public List<RangePo> getEvalScore();

	//带分页的查询
	@SelectProvider(type=EvalScoreProvider.class,method="queryRangeBy")
	@Results(value={

			@Result(column="DC_ID",property="clevelId",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="FScoreID",property="fLevelID",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="DC_VALUE",property="clevelName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FLevel_High",property="high",javaType=String.class, jdbcType=JdbcType.INTEGER),
			@Result(column="FLevel_Low",property="low",javaType=String.class, jdbcType=JdbcType.INTEGER),
			@Result(column="FLevelDesc",property="desc",javaType=String.class, jdbcType=JdbcType.VARCHAR)
	})
	 public List<RangePo> getInternListBy(@Param("rangePo")RangePo rangePo,@Param(value="page") int page,@Param(value="pageSize") int pageSize);


	@SelectProvider(type=EvalScoreProvider.class,method = "queryRangeByCount")
	public int getInternListByCount(@Param("rangePo") RangePo rangePo);

	//查询成绩等级名称 从数据字典查出
	@Select("select * from DATA_DICTIONARY where DC_NAME='项目等级'")
	public List<Map<String,String>> getALLEvalLevel();
	
	@Select("select FLevelID from T_EVALUATION_LEVEL where FLevelName=#{name}")
	public List<Map<String,Integer>> queryIdByName(String name);
	                                                                                                                                                        
	@Update("UPDATE T_EVALUATION_SCORE SET  FLevelID=#{fLevelID},FLevel_High=#{high} ,FLevel_Low=#{low} ,FLevelDesc=#{desc} , FNursinghomeID=#{fNursinghomeID}, FCreatorID=#{fCreatorID} WHERE FScoreID=#{clevelId}")
	public void updateEvalLevel(RangePo rangePo);
	
	
	
	class EvalScoreProvider{


		public String queryRangeBy(Map<String,Object> params){
		RangePo rangePo=(RangePo)params.get("rangePo");
		 StringBuffer sb=new StringBuffer(" select FScoreID,DC_ID,DC_VALUE,FLevel_High,FLevel_Low,FLevelDesc from DATA_DICTIONARY l,T_EVALUATION_SCORE s where l.DC_ID=s.FLevelID ");
		 
		 if(StringUtils.isNotEmpty(rangePo.getClevelName())){
			 
			 sb.append(" and l.DC_VALUE=#{rangePo.clevelName} ");
		 }
		 
		    sb.append("  order by s.FScoreID limit #{page},#{pageSize}");

		  return sb.toString();
		 
       }
         public String queryRangeByCount(Map<String,Object> params){

             RangePo rangePo=(RangePo)params.get("rangePo");
             StringBuffer sb=new StringBuffer(" select count(*) from DATA_DICTIONARY l,T_EVALUATION_SCORE s where l.DC_ID=s.FLevelID ");

             if(StringUtils.isNotEmpty(rangePo.getClevelName())){

                 sb.append(" and l.DC_VALUE=#{rangePo.clevelName} ");
             }

             return sb.toString();

		}
	}
}




