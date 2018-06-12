package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.TFloorPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjs on 2016/12/4.
 */
public interface TFoorMapper {

    @SelectProvider(type=AssProProvider.class,method ="queryCount")
    public int queryCount(@Param("param")TFloorPo param);

    public static Logger logger= Logger.getLogger(TFoorMapper.class);

    @SelectProvider(type = AssProProvider.class, method = "queryProList")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FBuildingID", property = "fBuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBuildingName", property = "fBuildingName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FFLoorName", property = "fFLoorName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLoorNumber", property = "fLoorNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<TFloorPo> queryFloor(@Param("floor") TFloorPo param,@Param(value = "page") int page,@Param(value = "pageSize") int pageSize);

    @SelectProvider(type = AssProProvider.class, method = "getFloor")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FBuildingID", property = "fBuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FFLoorName", property = "fFLoorName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLoorNumber", property = "fLoorNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<TFloorPo> getFloor(@Param("floor") TFloorPo param);

    @Select("select * from T_FLOOR where 1=1")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FBuildingID", property = "fBuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FFLoorName", property = "fFLoorName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLoorNumber", property = "fLoorNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<TFloorPo> queryTreeFloor();

    @Insert("insert into T_FLOOR (FNursingHomeID,FLoorNumber,FBuildingID,FFLoorName,FAdministratorsID,FStatus,FExplain) values(#{fNursingHomeID},#{fLoorNumber},#{fBuildingID},#{fFLoorName},#{fAdministratorsID},#{fStatus},#{fExplain})")
    public void addFloor(TFloorPo param);

    @Update("update T_FLOOR set FNursingHomeID=#{fNursingHomeID},FLoorNumber=#{fLoorNumber},FBuildingID=#{fBuildingID},FFLoorName=#{fFLoorName},FAdministratorsID=#{fAdministratorsID},FStatus=#{fStatus},FExplain=#{fExplain} where FID=#{fID}")
    public void updFloor(TFloorPo param);

    @Update("update T_FLOOR set FStatus=#{fStatus},FExplain=#{fExplain} where FID=#{fID}")
    public void updStateFloor(TFloorPo param);

    @Delete("delete from T_FLOOR where FID=#{fID}")
    public void delFloor(TFloorPo param);

    class AssProProvider {
        public String getFloor(Map<String, Object> params) {
            TFloorPo floor = (TFloorPo) params.get("floor");
            StringBuffer sql = new StringBuffer();
            sql.append("select * from T_FLOOR where 1=1");
            if(null == floor) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(floor.getfBuildingID())){
                    sql.append(" and FBuildingID = '" + floor.getfBuildingID() + "'");
                }
                if(StringUtils.isNotEmpty(floor.getfFLoorName())){
                    sql.append(" and FFLoorName = '" + floor.getfFLoorName() + "'");
                }
                if(StringUtils.isNotEmpty(floor.getfStatus())){
                    sql.append(" and FStatus = '" + floor.getfStatus() + "'");
                }
            }
            logger.debug("查询楼层(不分页)语句:"+sql.toString());
            return sql.toString();
        }

        public String queryProList(Map<String, Object> params) {
            TFloorPo floor = (TFloorPo) params.get("floor");
            StringBuffer sql = new StringBuffer();
            sql.append("select t_building.FBuildingName,t_floor.FID,t_floor.FLoorNumber,t_floor.FNursingHomeID,t_floor.FBuildingID,t_floor.FFLoorName,t_floor.FAdministratorsID,t_floor.FStatus,t_floor.FExplain,t_floor.FRemarks\n" +
                    " from t_floor,t_building where t_building.FID=t_floor.FBuildingID");
            if(null == floor) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(floor.getfBuildingID())){
                    sql.append(" and t_floor.FBuildingID LIKE '%" + floor.getfBuildingID() + "%'");
                }
                if(StringUtils.isNotEmpty(floor.getfFLoorName())){
                    sql.append(" and t_floor.FFLoorName LIKE '%" + floor.getfFLoorName() + "%'");
                }
                if(StringUtils.isNotEmpty(floor.getfStatus())){
                    sql.append(" and t_floor.FStatus LIKE '%" + floor.getfStatus() + "%'");
                }
            }
            sql.append(" order by t_floor.FID desc limit #{page},#{pageSize}");
            logger.debug("查询楼层语句:"+sql.toString());
            return sql.toString();
        }

        public String queryCount(Map<String,Object> params){
            TFloorPo floor = (TFloorPo) params.get("floor");
            StringBuffer sb=new StringBuffer();
            sb.append("select count(*) from t_floor,t_building where t_building.FID=t_floor.FBuildingID");
            if(null == floor) {
                return sb.toString();
            } else {
                if(StringUtils.isNotEmpty(floor.getfFLoorName())){
                    sb.append(" and t_floor.FFLoorName = '" + floor.getfFLoorName() + "'");
                }
                if(StringUtils.isNotEmpty(floor.getfStatus())){
                    sb.append(" and t_floor.FStatus = '" + floor.getfStatus() + "'");
                }
            }
            logger.debug("查询楼层总数语句:"+sb.toString());
            return sb.toString();
        }

    }
}
