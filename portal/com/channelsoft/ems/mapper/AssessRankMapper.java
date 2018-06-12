package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.RankPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 张鑫
 *
 */
public interface AssessRankMapper {
    //查询数据字典中数据
    @Select("SELECT  distinct d.DC_ID,d.DC_VALUE FROM DATA_DICTIONARY d,T_EVALUATION_LEVEL t WHERE d.DC_ID=t.FEvaluationID order by DC_ID" )
    public List<Map<String,String>> getDicname();
    //查询
    @Select("SELECT * FROM  DATA_DICTIONARY d,T_EVALUATION_LEVEL t WHERE t.FEvaluationID = d.DC_ID order by DC_ID ")
    @Results(value={
            @Result(column="FLevelID",property="levelId",javaType=String.class,jdbcType= JdbcType.INTEGER),
            @Result(column="DC_VALUE",property="dcName",javaType=String.class,jdbcType= JdbcType.VARCHAR),
            @Result(column="FEvaluationValue",property="evaluationValue",javaType=String.class,jdbcType= JdbcType.VARCHAR),
            @Result(column="FLevelName",property="levelName",javaType=String.class,jdbcType= JdbcType.VARCHAR),
    })
    public List<RankPo>  getFlevelNameValue();

    @Select("SELECT S.DC_VALUE,T.FScoreID from T_EVALUATION_SCORE T ,DATA_DICTIONARY S WHERE S.DC_NAME='项目等级' AND S.DC_ID=T.FLevelID AND #{sum} between T.FLevel_Low and T.FLevel_High ")
    public List<Map<String,String>> getStatus(String sum);

    @Insert("INSERT INTO T_EVALUATION_RESULT (FresultSum) VALUES(#{resultSum})")
    public void addSum(RankPo rankPo);


   @Select("select FResultID,FresultSum from T_EVALUATION_RESULT")
   @Results(value = {
            @Result(column="FResultID",property="resultId",javaType=String.class,jdbcType= JdbcType.INTEGER),
            @Result(column="FresultSum",property="resultSum",javaType=Integer.class,jdbcType=JdbcType.INTEGER)
    })
    public List<RankPo>  getFResultSum();

}
