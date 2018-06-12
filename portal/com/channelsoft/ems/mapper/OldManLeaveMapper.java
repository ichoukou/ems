package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.OldManLeavePo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;


/**
 * Created by wangjs on 2016/12/26.
 */
public interface OldManLeaveMapper {
    public Logger logger= Logger.getLogger(OldManLeaveMapper.class);

    @SelectProvider(type=OldManLeaveProvider.class,method ="queryCount")
    public int queryCount(@Param("param")OldManLeavePo param);

    @SelectProvider(type=OldManLeaveProvider.class, method = "queryList")
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNumber", property = "fNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStaffName", property = "fStaffName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursinghomeID", property = "fNursinghomeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FOldManID", property = "fOldManID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FOldManName", property = "fOldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBuildingName", property = "fBuildingName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomName", property = "fRoomName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveStatus", property = "fLeaveStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStartTime", property = "fStartTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStopTime", property = "fStopTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FDays", property = "fDays", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditorID", property = "fAuditorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditTime", property = "fAuditTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<OldManLeavePo> queryList(@Param("leave")OldManLeavePo po,@Param("page") int page,@Param("pageSize") int pageSize);

    @Insert("insert into T_OldMan_Leave (FNumber,FNursinghomeID,FOldManID,FLeaveStatus,FStartTime," +
            "FExplain,FCreatorID,FCreateTime) " +
            "values (#{fNumber},#{fNursinghomeID},#{fOldManID},#{fLeaveStatus}," +
            "#{fStartTime},#{fExplain},#{fCreatorID},#{fCreateTime})")
    public void addOldManLeave(OldManLeavePo po);

    @Update("update T_OldMan_Leave set FLeaveStatus=#{fLeaveStatus},FExplain=#{fExplain},FStopTime=#{fStopTime},FDays=#{fDays} where FID=#{fID}")
    public void updOldManLeave(OldManLeavePo po);

    @Delete("delete from T_OldMan_Leave where FID=#{fID}")
    public void delOldManLeave(OldManLeavePo po);

    class OldManLeaveProvider{
        public String queryList(Map<String,Object> params){
            OldManLeavePo leave = (OldManLeavePo) params.get("leave");
            StringBuffer sql = new StringBuffer();
            sql.append("select T_STAFF_MESSAGE.FStaffName,T_OldMan_Main.FoldManName,T_BUILDING.FBuildingName," +
                    "T_ROOM.FRoomName,T_OldMan_Leave.FID,T_OldMan_Leave.FNumber,T_OldMan_Leave.FNursinghomeID," +
                    "T_OldMan_Leave.FOldManID,T_OldMan_Leave.FLeaveStatus,T_OldMan_Leave.FStartTime," +
                    "T_OldMan_Leave.FStopTime,T_OldMan_Leave.FDays,T_OldMan_Leave.FExplain,T_OldMan_Leave.FAuditorID," +
                    "T_OldMan_Leave.FAuditTime,T_OldMan_Leave.FCreatorID,T_OldMan_Leave.FCreateTime " +
                    "from T_OldMan_Leave,T_OldMan_Main,T_BUILDING,T_ROOM,T_STAFF_MESSAGE " +
                    "where T_OldMan_Leave.FOldManID=T_OldMan_Main.FID and T_STAFF_MESSAGE.FID=T_OldMan_Leave.FCreatorID" +
                    " and T_OldMan_Main.FbuildingID=T_BUILDING.FID and T_OldMan_Main.FroomID=T_ROOM.FID");
            if(null == leave) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(leave.getfOldManName())){
                    sql.append(" and T_OldMan_Main.FoldManName LIKE '%" + leave.getfOldManName() + "%'");
                }
                if(StringUtils.isNotEmpty(leave.getfLeaveStatus())){
                    sql.append(" and FLeaveStatus LIKE '%" + leave.getfLeaveStatus() + "%'");
                }
                if(StringUtils.isNotEmpty(leave.getfStartTime())){
                    sql.append(" and T_OldMan_Leave.FStartTime LIKE '%" + leave.getfStartTime() + "%'");
                }
                if(StringUtils.isNotEmpty(leave.getfStopTime())){
                    sql.append(" and T_OldMan_Leave.FStopTime LIKE '%" + leave.getfStopTime() + "%'");
                }
            }
            sql.append(" order by T_OldMan_Leave.FID desc limit #{page},#{pageSize}");
            logger.debug("查询老人请假语句："+sql.toString());
            return sql.toString();
        }

        public String queryCount(Map<String,Object> params){
            OldManLeavePo leave = (OldManLeavePo) params.get("param");
            StringBuffer sql=new StringBuffer();
            sql.append("select count(*) from T_OldMan_Leave,T_OldMan_Main,T_BUILDING,T_ROOM,T_STAFF_MESSAGE " +
                    "where T_OldMan_Leave.FOldManID=T_OldMan_Main.FID and T_STAFF_MESSAGE.FID=T_OldMan_Leave.FCreatorID" +
                    " and T_OldMan_Main.FbuildingID=T_BUILDING.FID and T_OldMan_Main.FroomID=T_ROOM.FID");
            if(null == leave) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(leave.getfOldManName())){
                    sql.append(" and T_OldMan_Main.FoldManName LIKE '%" + leave.getfOldManName() + "%'");
                }
                if(StringUtils.isNotEmpty(leave.getfLeaveStatus())){
                    sql.append(" and FLeaveStatus LIKE '%" + leave.getfLeaveStatus() + "%'");
                }
                if(StringUtils.isNotEmpty(leave.getfOldManName())){
                    sql.append(" and T_OldMan_Leave.FStartTime LIKE '%" + leave.getfStartTime() + "%'");
                }
                if(StringUtils.isNotEmpty(leave.getfLeaveStatus())){
                    sql.append(" and T_OldMan_Leave.FStopTime LIKE '%" + leave.getfStopTime() + "%'");
                }
            }
            logger.debug("查询老人请假总数语句："+sql.toString());
            return sql.toString();
        }
    }
}
