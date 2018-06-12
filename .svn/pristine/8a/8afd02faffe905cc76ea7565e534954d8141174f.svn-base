package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import com.channelsoft.ems.po.LevelPo;
import org.apache.log4j.Logger;

/**
 * @author wangjs
 */
public interface AssessProjectMapper {
    public Logger logger= Logger.getLogger(AssessProjectMapper.class);

    @SelectProvider(type=AssProProvider.class,method ="queryCount")
    public int queryCount(@Param("param")LevelPo param);

    @SelectProvider(type = AssProProvider.class, method = "queryProList")
    @Results(value = {
            @Result(column = "FLevelID", property = "fLevelID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FLevelNum", property = "fLevelNum", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FEvaluationID", property = "fEvaluationID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLevelName", property = "fLevelName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FEvaluationValue", property = "fEvaluationValue", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FEvaluationDesc", property = "fEvaluationDesc", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FEvaluationStatus", property = "fEvaluationStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursinghomeID", property = "fNursinghomeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTimeateTime", property = "fCreateTimeateTime", javaType = String.class, jdbcType = JdbcType.DATE)})
    public List<LevelPo> queryProList(@Param("project") LevelPo param, @Param("page") int page, @Param("pageSize") int pageSize);

    @SelectProvider(type = AssProProvider.class, method = "getProList")
    @Results(value = {
            @Result(column = "FLevelID", property = "fLevelID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FLevelNum", property = "fLevelNum", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FEvaluationID", property = "fEvaluationID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLevelName", property = "fLevelName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FEvaluationValue", property = "fEvaluationValue", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FEvaluationDesc", property = "fEvaluationDesc", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FEvaluationStatus", property = "fEvaluationStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursinghomeID", property = "fNursinghomeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTimeateTime", property = "fCreateTimeateTime", javaType = String.class, jdbcType = JdbcType.DATE)})
    public List<LevelPo> getProject(@Param("project") LevelPo param);

    @SelectProvider(type = AssProProvider.class, method = "checkAp")
    public int checkAp(@Param("param") LevelPo param);

    @Insert("insert into T_EVALUATION_LEVEL (FEvaluationID,FLevelName,FEvaluationValue,FEvaluationDesc,FNursinghomeID,FCreatorID) values(#{fEvaluationID},#{fLevelName},#{fEvaluationValue},#{fEvaluationDesc},#{fNursinghomeID},#{fCreatorID})")
    public void addProject(LevelPo param);

    @Update("update T_EVALUATION_LEVEL set FEvaluationID=#{fEvaluationID},FLevelName=#{fLevelName},FEvaluationValue=#{fEvaluationValue},FEvaluationDesc=#{fEvaluationDesc} where FLevelID=#{fLevelID}")
    public void updProject(LevelPo param);

    @Delete("delete from T_EVALUATION_LEVEL where FLevelID=#{fLevelID}")
    public void delProject(LevelPo param);

    class AssProProvider {
        public String queryProList(Map<String, Object> params) {
            LevelPo pro = (LevelPo) params.get("project");
            StringBuffer sql = new StringBuffer();
            sql.append("select * from T_EVALUATION_LEVEL where 1=1");
            if (null == pro) {
                return sql.toString();
            } else {
                if (StringUtils.isNotEmpty(pro.getfLevelName())) {
                    sql.append(" AND FLevelName LIKE '%" + pro.getfLevelName() + "%'");
                }
                if(StringUtils.isNotEmpty(pro.getfEvaluationValue())){
                    sql.append(" AND FEvaluationValue LIKE '%" + pro.getfEvaluationValue() + "%'");
                }

            }
            sql.append(" order by FLevelID desc limit #{page},#{pageSize}");
            logger.debug("查询评估项目语句："+sql.toString());
            return sql.toString();
        }

        public String getProList(Map<String, Object> params) {
            LevelPo pro = (LevelPo) params.get("project");
            StringBuffer sql = new StringBuffer();
            sql.append("select * from T_EVALUATION_LEVEL where 1=1");
            if (null == pro) {
                return sql.toString();
            } else {
                if (StringUtils.isNotEmpty(pro.getfLevelName())) {
                    sql.append(" AND FLevelName LIKE '%" + pro.getfLevelName() + "%'");
                }
                if(StringUtils.isNotEmpty(pro.getfEvaluationValue())){
                    sql.append(" AND FEvaluationValue LIKE '%" + pro.getfEvaluationValue() + "%'");
                }

            }
            logger.debug("查询评估项目语句（不带分页）："+sql.toString());
            return sql.toString();
        }

        public String checkAp(Map<String, Object> params) {
            LevelPo ap = (LevelPo) params.get("param");
            StringBuffer sql = new StringBuffer();
            sql.append("select count(*) from T_EVALUATION_LEVEL where 1=1 ");

            if(null != ap) {
                if(StringUtils.isNotEmpty(ap.getfEvaluationID())){
                    sql.append(" and FEvaluationID = '" + ap.getfEvaluationID() + "'");
                }
                if(StringUtils.isNotEmpty(ap.getfLevelName())){
                    sql.append(" and FLevelName = '" + ap.getfLevelName() + "'");
                }
                if(StringUtils.isNotEmpty(ap.getfEvaluationValue())){
                    sql.append(" and FEvaluationValue = '" + ap.getfEvaluationValue() + "'");
                }
                if(StringUtils.isNotEmpty(ap.getfEvaluationDesc())){
                    sql.append(" and FEvaluationDesc = '" + ap.getfEvaluationDesc() + "'");
                }
            }
            logger.debug("查询评估项目语句（验证）："+sql.toString());
            return sql.toString();
        }

        public String queryCount(Map<String,Object> params){
            LevelPo pro = (LevelPo) params.get("param");
            StringBuffer sql=new StringBuffer();
            sql.append("select count(*) from T_EVALUATION_LEVEL where 1=1");
            if (null == pro) {
                return sql.toString();
            } else {
                if (StringUtils.isNotEmpty(pro.getfLevelName())) {
                    sql.append(" AND FLevelName LIKE '%" + pro.getfLevelName() + "%'");
                }
                if(StringUtils.isNotEmpty(pro.getfEvaluationValue())){
                    sql.append(" AND FEvaluationValue LIKE '%" + pro.getfEvaluationValue() + "%'");
                }

            }
            logger.debug("查询评估项目总数语句："+sql.toString());
            return sql.toString();
        }
    }

}
