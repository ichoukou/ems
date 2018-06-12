package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.ChargePo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by liuxing on 2017/3/6.
 */
public interface IncomeAnalysisMapper {

    /**
     *护理床位数
     */
    @Select("select count(*) from t_bed")
    public String getBedNumber();
    /**
     *当天已出租的床/晚数
     */
    @Select("select count(*) from T_OLDMAN_MAIN where #{date}<=if(FcheckoutTime is null,#{date},FcheckoutTime) and FcheckinTime<=#{date} and if(#{date}=FcheckoutTime,false,true)")
    public String getTheSameDayBedNumber(@Param("date") String date);
    /**
     *一段时间内出租的床/晚数
     */
//    @Select("select SUM(if((FcheckinTime>#{theLastDay} && FcheckoutTime is null) || (FcheckoutTime<=#{theFirstDay} && FcheckinTime<#{theFirstDay}) || (FcheckoutTime>#{theLastDay} && FcheckinTime>#{theLastDay}),0,(UNIX_TIMESTAMP(if(FcheckoutTime <= #{theLastDay},FcheckoutTime,#{theLastDay}))-UNIX_TIMESTAMP(if(FcheckinTime>=#{theFirstDay},FcheckinTime,#{theFirstDay})))/(60*60*24)+if(FcheckoutTime <=#{theLastDay},0,1)))datee from T_OLDMAN_MAIN ")
    @Select("select SUM(if((FcheckoutTime is not null && FcheckoutTime<#{theFirstDay}) || ( FcheckinTime>#{theLastDay}),0,(UNIX_TIMESTAMP(if(FcheckoutTime is not null && FcheckoutTime <= #{theLastDay},FcheckoutTime,#{theLastDay}))-UNIX_TIMESTAMP(if(FcheckinTime>=#{theFirstDay},FcheckinTime,#{theFirstDay})))/(60*60*24)+if(FcheckoutTime <=#{theLastDay},0,1)))datee from T_OLDMAN_MAIN")
    public String getTheSameMonthBedNumber(@Param("theFirstDay")String theFirstDay,@Param("theLastDay")String theLastDay);
    /**
     *当天护理类型查询
     */
//    @Select("select count(*) from T_OLDMAN_MAIN where #{date}<=if(FcheckoutTime is null,#{date},FcheckoutTime) and FcheckinTime<=#{date} and if(#{date}=FcheckoutTime,false,true) and T_OLDMAN_MAIN.FnursingLevel in(select T_EVALUATION_SCORE.FScoreID from DATA_DICTIONARY,T_EVALUATION_SCORE where T_EVALUATION_SCORE.FLevelID=DATA_DICTIONARY.DC_ID and DATA_DICTIONARY.DC_VALUE=#{type})")
    @Select("select count(*) from (select T_EVALUATION_SCORE.FLevelID,T_OLDMAN_MAIN.FcheckinTime,T_OLDMAN_MAIN.FcheckoutTime from T_OLDMAN_MAIN INNER JOIN T_EVALUATION_SCORE ON T_OLDMAN_MAIN.FnursingLevel=T_EVALUATION_SCORE.FScoreID)AS OLDMAN INNER JOIN DATA_DICTIONARY ON OLDMAN.FLevelID=DATA_DICTIONARY.DC_ID where if(#{date}=FcheckoutTime,false,true) and #{date}<=if(FcheckoutTime is null,#{date},FcheckoutTime) and FcheckinTime<=#{date} and DC_VALUE=#{type}")
    public String getTheSameDayNursingNumber(@Param("date") String date,@Param("type")String type);

    /**
     *一段时间护理类型查询
     */
//    @Select("select SUM(if((FcheckinTime>#{theLastDay} && FcheckoutTime is null) || (FcheckoutTime<=#{theFirstDay} && FcheckinTime<#{theFirstDay}) || (FcheckoutTime>#{theLastDay} && FcheckinTime>#{theLastDay}),0,(UNIX_TIMESTAMP(if(FcheckoutTime <= #{theLastDay},FcheckoutTime,#{theLastDay}))-UNIX_TIMESTAMP(if(FcheckinTime>=#{theFirstDay},FcheckinTime,#{theFirstDay})))/(60*60*24)+if(FcheckoutTime <= #{theLastDay},0,1)))datee from T_OLDMAN_MAIN where T_OLDMAN_MAIN.FnursingLevel in(select T_EVALUATION_SCORE.FScoreID from DATA_DICTIONARY,T_EVALUATION_SCORE where T_EVALUATION_SCORE.FLevelID=DATA_DICTIONARY.DC_ID and DATA_DICTIONARY.DC_VALUE=#{type})")
    @Select("select SUM(if((FcheckoutTime is not null && FcheckoutTime<#{theFirstDay}) || ( FcheckinTime>#{theLastDay}),0,(UNIX_TIMESTAMP(if(FcheckoutTime is not null && FcheckoutTime <= #{theLastDay},FcheckoutTime,#{theLastDay}))-UNIX_TIMESTAMP(if(FcheckinTime>=#{theFirstDay},FcheckinTime,#{theFirstDay})))/(60*60*24)+if(FcheckoutTime <=#{theLastDay},0,1)))datee from (select T_EVALUATION_SCORE.FLevelID,T_OLDMAN_MAIN.FcheckinTime,T_OLDMAN_MAIN.FcheckoutTime from T_OLDMAN_MAIN INNER JOIN T_EVALUATION_SCORE ON T_OLDMAN_MAIN.FnursingLevel=T_EVALUATION_SCORE.FScoreID)AS OLDMAN INNER JOIN DATA_DICTIONARY ON OLDMAN.FLevelID=DATA_DICTIONARY.DC_ID where DC_VALUE=#{type}")
    public String getDaysNursingNumber(@Param("theFirstDay")String theFirstDay,@Param("theLastDay")String theLastDay,@Param("type")String type);
    /**
     * 获得所有收费项目
     */
    @Select("select FID,FChargeCycle,FChrgeType,FChrgeName,FPrice from T_CHARGE_STANDARD")
    @Results(value = {
            @Result(column="FID",property="fID",javaType=String.class,jdbcType= JdbcType.INTEGER),
            @Result(column="FChargeCycle",property="fIsCycleFee",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FChrgeType",property="fChrgeType",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FChrgeName",property="fChrgeName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FPrice",property="fPrice",javaType=String.class,jdbcType=JdbcType.DECIMAL),
    })
    public List<ChargePo> getchargeList();
    /**
     * 获得一段时间内某收费项目的收款金额
     */
//    @Select("select SUM(payentry.FArPaymentAmount) su from T_FYGL_PAYMENT pay,T_FYGL_PAYMENTENTRY payentry where payentry.FParentid=pay.FID and payentry.FitemID=#{type} and pay.FCreateTime>=#{theFirstDay} and pay.FCreateTime<=#{theLastDay}")
    @Select("select SUM(FArPaymentAmount) from (T_FYGL_PAYMENT INNER JOIN T_FYGL_PAYMENTENTRY ON T_FYGL_PAYMENT.FID=T_FYGL_PAYMENTENTRY.FParentid) where FitemID =#{type} and FCreateTime>=#{theFirstDay} and FCreateTime<=#{theLastDay}")
    public String getDaysPayment(@Param("theFirstDay")String theFirstDay,@Param("theLastDay")String theLastDay,@Param("type")String type);
}
