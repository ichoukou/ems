package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.OldManChargePo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjs on 2016/12/21.
 */
public interface OldManChargeMapper {

    public Logger logger= Logger.getLogger(OldManChargeMapper.class);
    @SelectProvider(type=OldManChargeProvider.class,method ="queryCount")
    public int queryCount(@Param("param")OldManChargePo param);


    @SelectProvider(type=OldManChargeProvider.class, method = "queryList")
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FOldManID", property = "fOldManID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManName", property = "foldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeType", property = "fChrgeType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeName", property = "fChrgeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FManChargeID", property = "fManChargeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FOldChargeStatus", property = "fOldChargeStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChargePrice", property = "fChargePrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChargeStartTime", property = "fChargeStartTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChargeEndTime", property = "fChargeEndTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FOldManName", property = "fOldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<OldManChargePo> queryList(@Param("param") OldManChargePo po,@Param("page")int page,@Param("pageSize")int pageSize);

    @SelectProvider(type=OldManChargeProvider.class,method = "getOldManCharge")
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FOldManID", property = "fOldManID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeType", property = "fChrgeType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeName", property = "fChrgeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FManChargeID", property = "fManChargeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FOldChargeStatus", property = "fOldChargeStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChargePrice", property = "fChargePrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChargeStartTime", property = "fChargeStartTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChargeEndTime", property = "fChargeEndTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FOldManName", property = "fOldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<OldManChargePo> getOldManCharge(@Param("param") OldManChargePo po);

    @SelectProvider(type=OldManChargeProvider.class,method = "getList")
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FOldManID", property = "fOldManID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeType", property = "fChrgeType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeName", property = "fChrgeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FManChargeID", property = "fManChargeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FOldChargeStatus", property = "fOldChargeStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChargePrice", property = "fChargePrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChargeStartTime", property = "fChargeStartTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChargeEndTime", property = "fChargeEndTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FOldManName", property = "fOldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursingHomeID", property = "fNursingHomeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR)})
    public List<OldManChargePo> getList(@Param("param") OldManChargePo po);

    @Insert("insert into T_OldMan_Charge (FOldChargeStatus,FOldManID,FManChargeID,FChargePrice," +
            "FChargeStartTime,FOldManName,FNursingHomeID,FCreatorID) values(#{fOldChargeStatus},#{fOldManID}," +
            "#{fManChargeID},#{fChargePrice},#{fChargeStartTime},#{fOldManName},#{fNursingHomeID},#{fCreatorID})")
    public void addOldManCharge(OldManChargePo po);

    @Delete("delete from T_OldMan_Charge where FID=#{fID}")
    public void delOldManCharge(OldManChargePo po);

    @Insert("insert into T_OldMan_Charge (FOldManID,FManChargeID,FChargePrice,FChargeStartTime,FOldManName,FNursingHomeID) values(#{fOldManID}," +
            "#{fManChargeID},#{fChargePrice},#{fChargeStartTime},#{fOldManName},#{fNursingHomeID})")
    public int addOldManChargeArr(@Param("fOldManID")String fOldManID,@Param("fManChargeID")String fManChargeID,
                                   @Param("fChargePrice")String fChargePrice,@Param("fNursingHomeID")String fNursingHomeID,
                                   @Param("fChargeStartTime")String fChargeStartTime,@Param("fOldManName")String fOldManName);

    @UpdateProvider(type = OldManChargeProvider.class,method = "updChargeStatus")
//    @Update("")
    public int updChargeStatus(@Param("foldChargeStatus")String foldChargeStatus,@Param("fID")String fID,@Param("foldManID")String foldManID,
                               @Param("fChargeStartTime")String fChargeStartTime,
                               @Param("fChargeEndTime")String fChargeEndTime);

    class OldManChargeProvider{

        public String updChargeStatus(Map<String,Object> params){
//            OldManChargePo charge=(OldManChargePo)params.get("param");
            String foldChargeStatus=(String)params.get("foldChargeStatus");
            String fID=(String)params.get("fID");
            String foldManID=(String)params.get("foldManID");
            String fChargeStartTime=(String)params.get("fChargeStartTime");
            String fChargeEndTime=(String)params.get("fChargeEndTime");
            StringBuffer sql=new StringBuffer();
            sql.append("update T_OldMan_Charge set FOldChargeStatus=#{foldChargeStatus}");
            if(fChargeStartTime!=null){
                sql.append("  ,FChargeStartTime=#{fChargeStartTime}");
            }
//            if(fChargeEndTime!=null){
                sql.append("  ,FChargeEndTime=#{fChargeEndTime}");
//            }
            sql.append("  where FOldManID=#{foldManID} and FID=#{fID}");
            logger.debug("修改老人费用语句："+sql.toString());
            return sql.toString();
        }

        public String getOldManCharge(Map<String,Object> params){
            OldManChargePo charge=(OldManChargePo)params.get("param");
            StringBuffer sql=new StringBuffer();
            sql.append("select T_CHARGE_STANDARD.FChrgeType,T_CHARGE_STANDARD.FChrgeName,T_OldMan_Charge.FID,T_OldMan_Charge.FOldManID," +
                    "T_OldMan_Charge.FManChargeID,T_OldMan_Charge.FOldChargeStatus,T_OldMan_Charge.FChargePrice," +
                    "T_OldMan_Charge.FChargeStartTime,T_OldMan_Charge.FChargeEndTime,T_OldMan_Charge.FOldManName," +
                    "T_OldMan_Charge.FNursingHomeID,T_OldMan_Charge.FCreatorID,T_OldMan_Charge.FCreateTime " +
                    "from T_OldMan_Charge,T_CHARGE_STANDARD" +
                    " where T_CHARGE_STANDARD.FID=T_OldMan_Charge.FManChargeID ");
            if(charge==null){
                return sql.toString();
            }else{
                if(StringUtils.isNotEmpty(charge.getfOldManID())){
                    sql.append(" and T_OldMan_Charge.FOldManID = '"+charge.getfOldManID()+"'");
                }
                if(StringUtils.isNotEmpty(charge.getfID())){
                    sql.append(" and T_OldMan_Charge.FID = '"+charge.getfID()+"'");
                }
            }
            return sql.toString();
        }

        public String getList(Map<String,Object> params){
            OldManChargePo charge=(OldManChargePo)params.get("param");
            StringBuffer sql=new StringBuffer();
            sql.append("select T_CHARGE_STANDARD.FChrgeType,T_CHARGE_STANDARD.FChrgeName,T_OldMan_Charge.FID,T_OldMan_Charge.FOldManID," +
                    "T_OldMan_Charge.FManChargeID,T_OldMan_Charge.FOldChargeStatus,T_OldMan_Charge.FChargePrice," +
                    "T_OldMan_Charge.FChargeStartTime,T_OldMan_Charge.FChargeEndTime,T_OldMan_Charge.FOldManName," +
                    "T_OldMan_Charge.FNursingHomeID,T_OldMan_Charge.FCreatorID,T_OldMan_Charge.FCreateTime " +
                    "from T_OldMan_Charge,T_CHARGE_STANDARD" +
                    " where T_CHARGE_STANDARD.FID=T_OldMan_Charge.FManChargeID ");
//            if(charge==null){
//                return sql.toString();
//            }else{
//                if(StringUtils.isNotEmpty(charge.getfOldManID())){
                    sql.append(" and T_OldMan_Charge.FOldManID = '"+charge.getfOldManID()+"'");
//                }
//            }
            return sql.toString();
        }

        public String queryList(Map<String,Object> params){
            OldManChargePo charge=(OldManChargePo)params.get("param");
            StringBuffer sql=new StringBuffer();
            sql.append("select T_OldMan_Main.FoldManName,T_CHARGE_STANDARD.FChrgeType,T_CHARGE_STANDARD.FChrgeName,T_OldMan_Charge.FID,T_OldMan_Charge.FOldManID," +
                    "T_OldMan_Charge.FManChargeID,T_OldMan_Charge.FOldChargeStatus,T_OldMan_Charge.FChargePrice," +
                    "T_OldMan_Charge.FChargeStartTime,T_OldMan_Charge.FChargeEndTime,T_OldMan_Charge.FOldManName," +
                    "T_OldMan_Charge.FNursingHomeID,T_OldMan_Charge.FCreatorID,T_OldMan_Charge.FCreateTime " +
                    "from T_OldMan_Charge,T_CHARGE_STANDARD,T_OldMan_Main" +
                    " where T_CHARGE_STANDARD.FID=T_OldMan_Charge.FManChargeID and T_OldMan_Main.FID=T_OldMan_Charge.FOldManID ");
            if(charge==null){
                return sql.toString();
            }else{
                if(StringUtils.isNotEmpty(charge.getfOldManID())){
                    sql.append(" and FOldManID = '"+charge.getfOldManID()+"'");
                }
            }
            sql.append(" order by T_OldMan_Main.FoldManName limit #{page},#{pageSize}");
            return sql.toString();
        }

        public String queryCount(Map<String,Object> params){
            OldManChargePo charge=(OldManChargePo)params.get("param");
            StringBuffer sql=new StringBuffer();
            sql.append("select count(*) from T_OldMan_Charge,T_CHARGE_STANDARD,T_OldMan_Main" +
                    " where T_CHARGE_STANDARD.FID=T_OldMan_Charge.FManChargeID and T_OldMan_Main.FID=T_OldMan_Charge.FOldManID ");
            if(charge==null){
                return sql.toString();
            }else{
                if(StringUtils.isNotEmpty(charge.getfOldManID())){
                    sql.append(" and FOldManID = '"+charge.getfOldManID()+"'");
                }
            }
            return sql.toString();
        }
    }
}
