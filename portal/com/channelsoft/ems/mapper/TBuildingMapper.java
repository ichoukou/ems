package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.TBuildingPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjs on 2016/12/4.
 */
public interface TBuildingMapper {
    public static Logger logger=Logger.getLogger(TBuildingMapper.class);

    @SelectProvider(type=AssProProvider.class,method ="queryCount")
    public int queryCount(@Param("param")TBuildingPo param);

    @SelectProvider(type = AssProProvider.class, method = "queryProList")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FBuildingNumber", property = "fBuildingNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBuildingName", property = "fBuildingName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<TBuildingPo> queryBuilding(@Param("build") TBuildingPo param,@Param(value = "page") int page,@Param(value = "pageSize") int pageSize);

    @SelectProvider(type = AssProProvider.class, method = "getbuildList")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FBuildingNumber", property = "fBuildingNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBuildingName", property = "fBuildingName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<TBuildingPo> getBuilding(@Param("build") TBuildingPo param);

    @Select("select * from T_BUILDING where 1=1")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FBuildingNumber", property = "fBuildingNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBuildingName", property = "fBuildingName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<TBuildingPo> queryTreeBuilding();

    @Insert("insert into T_BUILDING (FNursingHomeID,FAdministratorsID,FBuildingNumber,FBuildingName,FStatus,FExplain) values(#{fNursingHomeID},#{fAdministratorsID},#{fBuildingNumber},#{fBuildingName},#{fStatus},#{fExplain})")
    public void addBuilding(TBuildingPo param);

    @Update("update T_BUILDING set FBuildingName=#{fBuildingName},FStatus=#{fStatus},FExplain=#{fExplain} where FID=#{fID}")
    public void updBuilding(TBuildingPo param);

    @Delete("delete from T_BUILDING where FID=#{fID}")
    public void delBuilding(TBuildingPo param);

    class AssProProvider {
        public String getbuildList(Map<String, Object> params) {
            TBuildingPo build = (TBuildingPo) params.get("build");
            StringBuffer sql = new StringBuffer();
            sql.append("select * from T_BUILDING where 1=1");
            if(null == build) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(build.getfBuildingName())){
                    sql.append(" and FBuildingName = '" + build.getfBuildingName() + "'");
                }
                if(StringUtils.isNotEmpty(build.getfStatus())){
                    sql.append(" and FStatus = '" + build.getfStatus() + "'");
                }
            }
            logger.debug("查询大厦语句（不分页）:"+sql.toString());
            return sql.toString();
        }

        public String queryProList(Map<String, Object> params) {
            TBuildingPo build = (TBuildingPo) params.get("build");
            StringBuffer sql = new StringBuffer();
            sql.append("select * from T_BUILDING where 1=1");
            if(null == build) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(build.getfBuildingName())){
                    sql.append(" and FBuildingName LIKE '%" + build.getfBuildingName() + "%'");
                }
                if(StringUtils.isNotEmpty(build.getfStatus())){
                    sql.append(" and FStatus LIKE '%" + build.getfStatus() + "%'");
                }
            }
            sql.append(" order by FID desc limit #{page},#{pageSize}");
            logger.debug("查询大厦语句:"+sql.toString());
            return sql.toString();
        }

        public String queryCount(Map<String,Object> params){
            TBuildingPo build=(TBuildingPo) params.get("param");
            StringBuffer sb=new StringBuffer();
            sb.append("select count(*) from T_BUILDING where 1=1");
            if(null == build) {
                return sb.toString();
            } {
                if(StringUtils.isNotEmpty(build.getfBuildingName())){
                    sb.append(" and FBuildingName = '" + build.getfBuildingName() + "'");
                }
                if(StringUtils.isNotEmpty(build.getfStatus())){
                    sb.append(" and FStatus = '" + build.getfStatus() + "'");
                }
            }
            logger.debug("查询大厦总数语句:"+sb.toString());
            return sb.toString();
        }
    }
}
