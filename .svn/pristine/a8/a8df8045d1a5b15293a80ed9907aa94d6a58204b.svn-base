package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.TBedPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjs on 2016/12/12.
 */
public interface TeBedMapper {

    public static Logger logger= Logger.getLogger(TRoomMapper.class);

    @SelectProvider(type=AssProProvider.class,method ="queryCount")
    public int queryCount(@Param("param")TBedPo param);

    @SelectProvider(type = AssProProvider.class, method = "queryBed")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FRoomID", property = "fRoomID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomName", property = "fRoomName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedNumber", property = "fBedNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedPrice", property = "fBedPrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPrice", property = "fPrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<TBedPo> queryBed(@Param("bed") TBedPo param, @Param("page") int page, @Param("pageSize")int pageSize);

    @SelectProvider(type = AssProProvider.class, method = "getBed")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FRoomID", property = "fRoomID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedNumber", property = "fBedNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedPrice", property = "fBedPrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<TBedPo> getBed(@Param("bed") TBedPo param);

    @SelectProvider(type = AssProProvider.class, method = "queryBedByRoom")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FRoomID", property = "fRoomID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedNumber", property = "fBedNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedPrice", property = "fBedPrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<TBedPo> queryBedByRoom(@Param("bed") TBedPo param);

    @Select("select * from T_BED where FRoomID=#{roomId}")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FAdministratorsID", property = "fAdministratorsID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FRoomID", property = "fRoomID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedNumber", property = "fBedNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedPrice", property = "fBedPrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<TBedPo> getBedByRoom(String roomId);

    @Insert("insert into T_BED (FBedNumber,FBedPrice,FAdministratorsID,FStatus,FExplain,FRoomID)" +
            " values(#{fBedNumber},#{fBedPrice},#{fAdministratorsID},#{fStatus},#{fExplain},#{fRoomID})")
    public void addBed(TBedPo param);

    @Update("update T_BED set FStatus=#{fStatus} where FID=#{fID}")
    public void updBedState(TBedPo param);

    @Update("update T_BED set FStatus=#{fStatus} where FRoomID=#{fRoomID}")
    public void updBedStateByRoom(TBedPo param);

    @Update("update T_BED set FStatus=#{fStatus},FBedNumber=#{fBedNumber},FBedPrice=#{fBedPrice}," +
            "FAdministratorsID=#{fAdministratorsID},FExplain=#{fExplain},FRoomID=#{fRoomID} where FID=#{fID}")
    public void updBed(TBedPo param);

    @Delete("delete from T_BED where FRoomID=#{fRoomID}")
    public void delBed(TBedPo param);

    class AssProProvider {
        public String queryBed(Map<String, Object> params) {
            TBedPo bed = (TBedPo) params.get("bed");
            StringBuffer sql = new StringBuffer();
            sql.append("select T_ROOM.FRoomName,T_BED.FID,T_BED.FBedNumber," +
                    "T_BED.FRoomID,T_BED.FBedPrice,T_BED.FStatus,T_BED.FAdministratorsID,T_BED.FExplain," +
                    "T_BED.FRemarks from T_BED,T_ROOM " +
                    "where T_ROOM.FID=T_BED.FRoomID ");
            if(null == bed) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(bed.getfRoomID())){
                    sql.append(" and T_BED.FRoomID LIKE '%" + bed.getfRoomID() + "%'");
                }
                if(StringUtils.isNotEmpty(bed.getfStatus())){
                    sql.append(" and T_BED.FStatus LIKE '%" + bed.getfStatus() + "%'");
                }
            }
            sql.append(" order by T_BED.FID desc limit #{page},#{pageSize}");
            logger.debug("查询床位语句:"+sql.toString());
            return sql.toString();
        }

        public String queryBedByRoom(Map<String, Object> params) {
            TBedPo bed = (TBedPo) params.get("bed");
            StringBuffer sql = new StringBuffer();
            sql.append("select * from T_BED where 1=1");

            if(null == bed) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(bed.getfRoomID())){
                    sql.append(" and FRoomID = '" + bed.getfRoomID() + "'");
                }
                if(StringUtils.isNotEmpty(bed.getfBedNumber())){
                    sql.append(" and FBedNumber = '" + bed.getfBedNumber() + "'");
                }
                if(StringUtils.isNotEmpty(bed.getfID())){
                    sql.append(" and FID = '" + bed.getfID() + "'");
                }
                if(StringUtils.isNotEmpty(bed.getfStatus())){
                    sql.append(" and FStatus = '" + bed.getfStatus() + "'");
                }
            }
            logger.debug("查询床位语句:"+sql.toString());
            return sql.toString();
        }

        public String getBed(Map<String, Object> params) {
            TBedPo bed = (TBedPo) params.get("bed");
            StringBuffer sql = new StringBuffer();
            sql.append("select * from T_BED where 1=1");

            if(null == bed) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(bed.getfRoomID())){
                    sql.append(" and FRoomID = '" + bed.getfRoomID() + "'");
                }
                if(StringUtils.isNotEmpty(bed.getfStatus())){
                    sql.append(" and FStatus = '" + bed.getfStatus() + "'");
                }
            }
            logger.debug("查询床位(不分页)语句:"+sql.toString());
            return sql.toString();
        }

        public String queryCount(Map<String,Object> params){

            TBedPo bed = (TBedPo) params.get("param");
            StringBuffer sql = new StringBuffer();
            sql.append("select count(*) from T_BED,T_ROOM " +
                    "where T_ROOM.FID=T_BED.FRoomID");

            if(null == bed) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(bed.getfBedNumber())){
                    sql.append(" and FRoomName = '" + bed.getfBedNumber() + "'");
                }
                if(StringUtils.isNotEmpty(bed.getfStatus())){
                    sql.append(" and FStatus = '" + bed.getfStatus() + "'");
                }
                if(StringUtils.isNotEmpty(bed.getfRoomID())){
                    sql.append(" and T_BED.FRoomID LIKE '%" + bed.getfRoomID() + "%'");
                }
            }
            logger.debug("查询房间总数语句:"+sql.toString());
            return sql.toString();
        }


    }
}
