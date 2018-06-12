package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.TRoomPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjs on 2016/12/4.
 */
public interface TRoomMapper {
    public static Logger logger= Logger.getLogger(TRoomMapper.class);

    @SelectProvider(type=AssProProvider.class,method ="queryCount")
    public int queryCount(@Param("room")TRoomPo param);

    @SelectProvider(type = AssProProvider.class, method = "queryRoom")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),

            @Result(column = "FBuildingID", property = "fBuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBuildingName", property = "fBuildingName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FFLoorID", property = "fFLoorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FFLoorName", property = "fFLoorName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomNumber", property = "fRoomNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomName", property = "fRoomName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomType", property = "fRoomType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomOrientation", property = "fRoomOrientation", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomPrice", property = "fRoomPrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedCount", property = "fBedCount", javaType = String.class, jdbcType = JdbcType.INTEGER),

            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),

            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FManNumber", property = "fManNumber", javaType = String.class, jdbcType = JdbcType.INTEGER)})
    public List<TRoomPo> queryRoom(@Param("room") TRoomPo param,@Param("page") int page,@Param("pageSize")int pageSize);

    @SelectProvider(type = AssProProvider.class, method = "getRoom")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),

            @Result(column = "FBuildingID", property = "fBuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FFLoorID", property = "fFLoorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomNumber", property = "fRoomNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomName", property = "fRoomName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomType", property = "fRoomType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomOrientation", property = "fRoomOrientation", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomPrice", property = "fRoomPrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedCount", property = "fBedCount", javaType = String.class, jdbcType = JdbcType.INTEGER),

            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),

            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FManNumber", property = "fManNumber", javaType = String.class, jdbcType = JdbcType.INTEGER)})
    public List<TRoomPo> getRoom(@Param("room") TRoomPo param);

    @Select("select * from T_ROOM order by FID desc Limit 0,1")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),

            @Result(column = "FBuildingID", property = "fBuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FFLoorID", property = "fFLoorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomNumber", property = "fRoomNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomName", property = "fRoomName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomType", property = "fRoomType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomOrientation", property = "fRoomOrientation", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomPrice", property = "fRoomPrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedCount", property = "fBedCount", javaType = String.class, jdbcType = JdbcType.INTEGER),

            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),

            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FManNumber", property = "fManNumber", javaType = String.class, jdbcType = JdbcType.INTEGER)})
    public List<TRoomPo> getLastRoom(TRoomPo param);

    @Insert("insert into T_ROOM (FNursingHomeID,FBuildingID,FFLoorID,FRoomNumber,FRoomName,FRoomType,FRoomOrientation,FRoomPrice,FBedCount,FStatus,FExplain,FManNumber,FAdministratorsID)" +
            " values(#{fNursingHomeID},#{fBuildingID},#{fFLoorID},#{fRoomNumber},#{fRoomName},#{fRoomType},#{fRoomOrientation},#{fRoomPrice},#{fBedCount},#{fStatus},#{fExplain},#{fManNumber},#{fAdministratorsID})")
    public int addRoom(TRoomPo param);

    @Update("update T_ROOM set FNursingHomeID=#{fNursingHomeID},FBuildingID=#{fBuildingID},FFLoorID=#{fFLoorID},FRoomNumber=#{fRoomNumber},FAdministratorsID=#{fAdministratorsID}," +
            "FRoomName=#{fRoomName},FRoomType=#{fRoomType},FRoomOrientation=#{fRoomOrientation},FRoomPrice=#{fRoomPrice},FBedCount=#{fBedCount},FStatus=#{fStatus},FExplain=#{fExplain},FManNumber=#{fManNumber}" +
            " where FID=#{fID}")
    public void updRoom(TRoomPo param);

    @Update("update T_ROOM set FStatus=#{fStatus} where FID=#{fID}")
    public void updRoomState(TRoomPo param);

    @Delete("delete from T_ROOM where FID=#{fID}")
    public void delRoom(TRoomPo param);

    class AssProProvider {
        public String queryRoom(Map<String, Object> params) {
            TRoomPo room = (TRoomPo) params.get("room");
            StringBuffer sql = new StringBuffer();
            sql.append("select T_BUILDING.FBuildingName,T_FLOOR.FFLoorName,T_ROOM.FID,T_ROOM.FNursingHomeID,T_ROOM.FBuildingID,T_ROOM.FFLoorID,T_ROOM.FRoomNumber,T_ROOM.FRoomName,T_ROOM.FAdministratorsID," +
                    "T_ROOM.FRoomType,T_ROOM.FRoomOrientation,T_ROOM.FRoomPrice,T_ROOM.FBedCount,T_ROOM.FManNumber,T_ROOM.FStatus,T_ROOM.FExplain,T_ROOM.FRemarks," +
                    "T_BUILDING.FID,T_FLOOR.FID,T_FLOOR.FStatus,T_BUILDING.FStatus from T_ROOM,T_BUILDING,T_FLOOR where 1=1");
            if(null == room) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(room.getfBuildingID())){
                    sql.append(" and T_ROOM.FBuildingID LIKE '%" + room.getfBuildingID() + "%'");
                }
                if(StringUtils.isNotEmpty(room.getfFLoorID())){
                    sql.append(" and T_ROOM.FFLoorID LIKE '%" + room.getfFLoorID() + "%'");
                }
            }
            sql.append(" and T_ROOM.FBuildingID=T_BUILDING.FID and T_ROOM.FFLoorID=T_FLOOR.FID and T_FLOOR.FStatus='11'" +
                    " and T_BUILDING.FStatus='11' order by T_ROOM.FID desc limit #{page},#{pageSize}");
            logger.debug("查询房间语句:"+sql.toString());
            return sql.toString();
        }

        public String getRoom(Map<String, Object> params) {
            TRoomPo room = (TRoomPo) params.get("room");
            StringBuffer sql = new StringBuffer();
            sql.append("select * from T_ROOM where 1=1");

            if(null == room) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(room.getfBuildingID())){
                    sql.append(" and FBuildingID = '" + room.getfBuildingID() + "'");
                }
                if(StringUtils.isNotEmpty(room.getfFLoorID())){
                    sql.append(" and FFLoorID = '" + room.getfFLoorID() + "'");
                }
                if(StringUtils.isNotEmpty(room.getfID())){
                    sql.append(" and FID = '" + room.getfID() + "'");
                }
                if(StringUtils.isNotEmpty(room.getfRoomName())){
                    sql.append(" and FRoomName = '" + room.getfRoomName() + "'");
                }
                if(StringUtils.isNotEmpty(room.getfStatus())){
                    sql.append(" and FStatus = '" + room.getfStatus() + "'");
                }
            }
            logger.debug("查询房间(不分页)语句:"+sql.toString());
            return sql.toString();
        }

        public String queryCount(Map<String,Object> params){

            TRoomPo room = (TRoomPo) params.get("room");
            StringBuffer sql = new StringBuffer();
            sql.append("select count(*) from T_ROOM,T_BUILDING,T_FLOOR where T_ROOM.FBuildingID=T_BUILDING.FID and T_ROOM.FFLoorID=T_FLOOR.FID and T_FLOOR.FStatus='11'" +
                    " and T_BUILDING.FStatus='11'");

            if(null == room) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(room.getfRoomName())){
                    sql.append(" and FRoomName = '" + room.getfRoomName() + "'");
                }
                if(StringUtils.isNotEmpty(room.getfStatus())){
                    sql.append(" and FStatus = '" + room.getfStatus() + "'");
                }
                if(StringUtils.isNotEmpty(room.getfBuildingID())){
                    sql.append(" and T_ROOM.FBuildingID LIKE '%" + room.getfBuildingID() + "%'");
                }
                if(StringUtils.isNotEmpty(room.getfFLoorID())){
                    sql.append(" and T_ROOM.FFLoorID LIKE '%" + room.getfFLoorID() + "%'");
                }
            }
            logger.debug("查询房间总数语句:"+sql.toString());
            return sql.toString();
        }


    }
}
