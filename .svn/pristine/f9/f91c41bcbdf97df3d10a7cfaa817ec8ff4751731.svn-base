package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.OldManFreePo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjs on 2016/12/29.
 */
public interface OldManFreeMapper {

    public Logger logger= Logger.getLogger(OldManLeaveMapper.class);

    @SelectProvider(type=OldManFreeProvider.class,method ="queryCount")
    public int queryCount(@Param("param")OldManFreePo param,@Param("startTime") String startTime,@Param("stopTime") String stopTime);

    @SelectProvider(type=OldManFreeProvider.class, method = "queryList")
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "ChargeId", property = "chargeId", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FChrgeName", property = "fChrgeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStaffName", property = "fStaffName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNumber", property = "fNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursinghomeID", property = "fNursinghomeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FOldManID", property = "fOldManID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FOldManName", property = "fOldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FFreeItem", property = "fFreeItem", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FFreePrice", property = "fFreePrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FUnit", property = "fUnit", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FFreeNumber", property = "fFreeNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FFreeTotal", property = "fFreeTotal", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPaymentID", property = "fPaymentID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditorID", property = "fAuditorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditTime", property = "fAuditTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<OldManFreePo> queryList(@Param("free")OldManFreePo po, @Param("page") int page, @Param("pageSize") int pageSize,
                                      @Param("startTime") String startTime,@Param("stopTime") String stopTime);

    @Select("select * from T_OldMan_Free order by FID desc Limit 0,1")
    public List<OldManFreePo> queryLastFree(@Param("free")OldManFreePo po);

    @Insert("insert into T_OldMan_Free (FNumber,FOldManID,FFreeItem," +
            "FFreePrice,FUnit,FFreeNumber,FFreeTotal,FStatus,FPaymentID,FExplain," +
            "FCreatorID,FCreateTime,FNursinghomeID) " +
            "values (#{fNumber},#{fOldManID},#{fFreeItem}," +
            "#{fFreePrice},#{fUnit},#{fFreeNumber},#{fFreeTotal},#{fStatus}," +
            "#{fPaymentID},#{fExplain},#{fCreatorID},#{fCreateTime},#{fNursinghomeID})")
    public int addOldManFree(OldManFreePo po);

    @Update("update T_OldMan_Free set FNursinghomeID=#{fNursinghomeID},FOldManID=#{fOldManID},FFreeItem=#{fFreeItem}," +
            "FFreePrice=#{fFreePrice},FUnit=#{fUnit},FFreeNumber=#{fFreeNumber},FFreeTotal=#{fFreeTotal},FStatus=#{fStatus}," +
            "FExplain=#{fExplain} where FID=#{fID}")
    public int updOldManFree(OldManFreePo po);

    @Delete("delete from T_OldMan_Free where FID=#{fID}")
    public int delOldManFree(OldManFreePo po);

    class OldManFreeProvider{
        public String queryList(Map<String,Object> params){
            OldManFreePo free = (OldManFreePo) params.get("free");
            StringBuffer sql = new StringBuffer();
            sql.append("select t_staff_message.FStaffName,T_OldMan_Free.FOldManID,T_OldMan_Main.FoldManName,T_CHARGE_STANDARD.FID as ChargeId,T_CHARGE_STANDARD.FChrgeName," +
                    "T_OldMan_Free.FID,T_OldMan_Free.FNumber,T_OldMan_Free.FNursinghomeID,T_OldMan_Free.FFreeItem," +
                    "T_OldMan_Free.FFreePrice,T_OldMan_Free.FUnit,T_OldMan_Free.FFreeNumber,T_OldMan_Free.FFreeTotal,T_OldMan_Free.FStatus," +
                    "T_OldMan_Free.FPaymentID,T_OldMan_Free.FExplain,T_OldMan_Free.FAuditorID,T_OldMan_Free.FAuditTime," +
                    "T_OldMan_Free.FCreatorID,T_OldMan_Free.FCreateTime " +
                    "from T_OldMan_Free,T_CHARGE_STANDARD,T_OldMan_Main,t_staff_message " +
                    "where T_OldMan_Free.FFreeItem=T_CHARGE_STANDARD.FID and T_OldMan_Main.FID=T_OldMan_Free.FOldManID and t_staff_message.FID=T_OldMan_Free.FCreatorID");
            String startTime=(String)params.get("startTime");
            String stopTime=(String)params.get("stopTime");
            if(null == free) {
                return sql.toString();
            } else {
                if(StringUtils.isNotEmpty(free.getfOldManName())){
                    sql.append(" and FOldManName LIKE '%" + free.getfOldManName() + "%'");
                }
            }
            if(startTime!=null&&!startTime.equals("")){
                sql.append(" and T_OldMan_Free.FCreateTime >= '" + startTime + "'");
            }
            if(stopTime!=null&&!stopTime.equals("")){
                sql.append(" and T_OldMan_Free.FCreateTime <= '" + stopTime + "'");
            }
            sql.append(" order by T_OldMan_Free.FID desc limit #{page},#{pageSize}");
            logger.debug("查询减免单据语句："+sql.toString());
            return sql.toString();
        }

        public String queryCount(Map<String,Object> params){
            OldManFreePo free=(OldManFreePo) params.get("param");
            StringBuffer sb=new StringBuffer();
            sb.append("select count(*) from T_OldMan_Free,T_CHARGE_STANDARD,T_OldMan_Main,t_staff_message " +
                    "where T_OldMan_Free.FFreeItem=T_CHARGE_STANDARD.FID and T_OldMan_Main.FID=T_OldMan_Free.FOldManID " +
                    " and t_staff_message.FID=T_OldMan_Free.FCreatorID");
            String startTime=(String)params.get("startTime");
            String stopTime=(String)params.get("stopTime");
            if(null == free) {
                return sb.toString();
            } else {
                if(StringUtils.isNotEmpty(free.getfOldManName())){
                    sb.append(" and FOldManName LIKE '%" + free.getfOldManName() + "%'");
                }
            }
            if(startTime!=null&&!startTime.equals("")){
                sb.append(" and T_OldMan_Free.FCreateTime >= '" + startTime + "'");
            }
            if(stopTime!=null&&!stopTime.equals("")){
                sb.append(" and T_OldMan_Free.FCreateTime <= '" + stopTime + "'");
            }
            logger.debug("查询减免单据总数语句："+sb.toString());
            return sb.toString();
        }
    }
}
