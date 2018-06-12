package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.ChargePo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjs on 2016/12/1.
 */
public interface ChargeStandardMapper {
    public static Logger logger=Logger.getLogger(ChargeStandardMapper.class);

    @SelectProvider(type=ChangeProvider.class,method ="queryCount")
    public int queryCount(@Param("param")ChargePo param);

    @SelectProvider(type=ChangeProvider.class,method = "queryList")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FLevelID", property = "fLevelID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursinghomeID", property = "fNursinghomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FChrgeNumber", property = "fChrgeNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChargeCycle", property = "fChargeCycle", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeType", property = "fChrgeType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeName", property = "fChrgeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursingLevel", property = "fNursingLevel", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPrice", property = "fPrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FUnit", property = "fUnit", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRefundType", property = "fRefundType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeStartDate", property = "fChrgeStartDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeStopDate", property = "fChrgeStopDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FValidityStartDate", property = "fValidityStartDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FValidityEndDate", property = "fValidityEndDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FIsALLFee", property = "fIsALLFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FIsCycleFee", property = "fIsCycleFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRemarks", property = "fRemarks", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    public List<ChargePo> queryList(@Param("param") ChargePo param,@Param(value="page") int page,@Param(value="pageSize") int pageSize,@Param(value="flag")boolean flag);

    @SelectProvider(type=ChangeProvider.class,method = "getCharge")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursinghomeID", property = "fNursinghomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FChrgeNumber", property = "fChrgeNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChargeCycle", property = "fChargeCycle", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeType", property = "fChrgeType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeName", property = "fChrgeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursingLevel", property = "fNursingLevel", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPrice", property = "fPrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FUnit", property = "fUnit", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRefundType", property = "fRefundType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeStartDate", property = "fChrgeStartDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeStopDate", property = "fChrgeStopDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FValidityStartDate", property = "fValidityStartDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FValidityEndDate", property = "fValidityEndDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FIsALLFee", property = "fIsALLFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FIsCycleFee", property = "fIsCycleFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRemarks", property = "fRemarks", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    public List<ChargePo> getCharge(@Param("param") ChargePo param);

    @SelectProvider(type=ChangeProvider.class,method = "queryChargeMess")
    @Results(value = {
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNursinghomeID", property = "fNursinghomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FChrgeNumber", property = "fChrgeNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FValue", property = "fValue", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FChrgeType", property = "fChrgeType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeName", property = "fChrgeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursingLevel", property = "fNursingLevel", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPrice", property = "fPrice", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FUnit", property = "fUnit", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRefundType", property = "fRefundType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeStartDate", property = "fChrgeStartDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FChrgeStopDate", property = "fChrgeStopDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FValidityStartDate", property = "fValidityStartDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FValidityEndDate", property = "fValidityEndDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FIsALLFee", property = "fIsALLFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FIsCycleFee", property = "fIsCycleFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "fStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "fExplain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRemarks", property = "fRemarks", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    public List<ChargePo> queryChargeMess(@Param("param") String[] param);

    @Insert("insert into T_CHARGE_STANDARD(FNursinghomeID,FChrgeNumber,FChrgeType,FChrgeName,FNursingLevel," +
            "FPrice,FUnit,FRefundType,FStatus,FExplain,FChargeCycle,FValidityStartDate,FValidityEndDate" +
            ",FIsALLFee,FIsCycleFee,FChrgeStartDate,FChrgeStopDate) values(#{fNursinghomeID},#{fChrgeNumber}" +
            ",#{fChrgeType},#{fChrgeName},#{fNursingLevel},#{fPrice},#{fUnit},#{fRefundType},#{fStatus}" +
            ",#{fExplain},#{fChargeCycle},#{fValidityStartDate},#{fValidityEndDate},#{fIsALLFee}" +
            ",#{fIsCycleFee},#{fChrgeStartDate},#{fChrgeStopDate});")
    public void addStandard(ChargePo param);

    @Update("update T_CHARGE_STANDARD set FNursinghomeID=#{fNursinghomeID},FChrgeNumber=#{fChrgeNumber}," +
            "FChrgeType=#{fChrgeType},FChrgeName=#{fChrgeName},FNursingLevel=#{fNursingLevel},FPrice=#{fPrice},FUnit=#{fUnit}," +
            "FRefundType=#{fRefundType},FChrgeStartDate=#{fChrgeStartDate},FChrgeStopDate=#{fChrgeStopDate},FStatus=#{fStatus}," +
            "FExplain=#{fExplain},FChargeCycle=#{fChargeCycle},FValidityStartDate=#{fValidityStartDate},FValidityEndDate=#{fValidityEndDate}," +
            "FIsALLFee=#{fIsALLFee},FIsCycleFee=#{fIsCycleFee} where FID=#{fID}")
    public void updStandard(ChargePo param);

    @Update("update T_CHARGE_STANDARD set FStatus="+10+" where FID=#{fID}")
    public void delStandard(ChargePo param);

    class ChangeProvider{

        public String queryList(Map<String,Object> params){
            ChargePo charge = (ChargePo) params.get("param");
            StringBuffer chargeSql=new StringBuffer();
            chargeSql.append("select * from t_charge_standard where 1=1");

            String flag="#{flag}";

            if(null == charge) {
                return chargeSql.toString();
            } else {
                if(StringUtils.isNotEmpty(charge.getfChrgeName())){
                    chargeSql.append(" and FChrgeName LIKE '%" + charge.getfChrgeName() + "%'");
                }
                if(StringUtils.isNotEmpty(charge.getfChrgeType())){
                    chargeSql.append(" and FChrgeType LIKE '%" + charge.getfChrgeType() + "%'");
                }
                if(StringUtils.isNotEmpty(charge.getfStatus())){
                    chargeSql.append(" and FStatus LIKE '%" + charge.getfStatus() + "%'");
                }
            }
//            if(false) {
                chargeSql.append(" order by FID desc limit #{page},#{pageSize}");
//            }
            logger.debug("查询收费标准语句："+chargeSql.toString());
            return chargeSql.toString();
        }

        public String getCharge(Map<String,Object> params){
            ChargePo oldManCharge = (ChargePo) params.get("param");
            StringBuffer chargeSql=new StringBuffer();
            chargeSql.append("select * from T_CHARGE_STANDARD where 1=1");

            if(null == oldManCharge) {
                return chargeSql.toString();
            } else {
                if(StringUtils.isNotEmpty(oldManCharge.getfID())){
                    chargeSql.append(" and FID = '" + oldManCharge.getfID() + "'");
                }
                if(StringUtils.isNotEmpty(oldManCharge.getfPrice())){
                    chargeSql.append(" and FPrice = '" + oldManCharge.getfPrice() + "'");
                }
                if(StringUtils.isNotEmpty(oldManCharge.getfChrgeType())){
                    chargeSql.append(" and FChrgeType = '" + oldManCharge.getfChrgeType() + "'");
                }
                if(StringUtils.isNotEmpty(oldManCharge.getfNursingLevel())){
                    chargeSql.append(" and FNursingLevel = '" + oldManCharge.getfNursingLevel() + "'");
                }
                if(StringUtils.isNotEmpty(oldManCharge.getfStatus())){
                    chargeSql.append(" and FStatus = '" + oldManCharge.getfStatus() + "'");
                }
            }
            logger.debug("根据条件======查询收费标准语句："+chargeSql.toString());
            return chargeSql.toString();
        }

        public String queryChargeMess(Map<String,String[]> params){
            String[] arr = params.get("param");
            StringBuffer chargeSql=new StringBuffer();
            chargeSql.append("select * from T_CHARGE_STANDARD ");

            if(arr.length<=0) {
                return chargeSql.toString();
            } else {
                for(int i=0;i<arr.length;i++){
                    if(i==0){
                        chargeSql.append("where FID = '" + arr[i] + "'");
                    }else {
                        chargeSql.append(" or FID = '" + arr[i] + "'");
                    }
                }
            }
            logger.debug("根据条件,查询老人所有收费标准语句："+chargeSql.toString());
            return chargeSql.toString();
        }

        public String queryCount(Map<String,Object> params){
            ChargePo charge=(ChargePo) params.get("param");
            StringBuffer sb=new StringBuffer();
            sb.append("select count(*) from t_charge_standard where 1=1");
            if(null == charge) {
                return sb.toString();
            } else {
                if(StringUtils.isNotEmpty(charge.getfChrgeName())){
                    sb.append(" and FChrgeName = '" + charge.getfChrgeName() + "'");
                }
                if(StringUtils.isNotEmpty(charge.getfChrgeType())){
                    sb.append(" and FChrgeType = '" + charge.getfChrgeType() + "'");
                }
                if(StringUtils.isNotEmpty(charge.getfStatus())){
                    sb.append(" and FStatus = '" + charge.getfStatus() + "'");
                }
            }
            logger.debug("查询收费标准总数语句："+sb.toString());
            return sb.toString();
        }

    }
}
