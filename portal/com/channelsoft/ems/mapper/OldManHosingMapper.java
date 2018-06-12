package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.OldManMainPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjs on 2016/12/15.
 */
public interface OldManHosingMapper {

    public Logger logger= Logger.getLogger(OldManHosingMapper.class);

    @SelectProvider(type=OldManProvider.class,method ="queryCount")
    public int queryCount(@Param("param")OldManMainPo param,@Param("startTime") String startTime,@Param("stopTime") String stopTime);


    @SelectProvider(type=OldManProvider.class,method ="queryCountByState")
    public int queryCountByState(@Param("param")OldManMainPo param);

    @SelectProvider(type=OldManProvider.class,method ="queryList" )
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FLevelID", property = "fLevelID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FoldManNum", property = "foldManNum", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBuildingName", property = "fBuildingName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomName", property = "fRoomName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedNumber", property = "fBedNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManStatusID", property = "foldManStatusID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManTypeID", property = "foldManTypeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMediaID", property = "foldManMediaID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManName", property = "foldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManSex", property = "foldManSex", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIdCard", property = "foldManIdCard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBirth", property = "foldManBirth", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIsLunar", property = "foldManIsLunar", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMobile", property = "foldManMobile", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNative", property = "foldManNative", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNationID", property = "foldManNationID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBeliefID", property = "foldManBeliefID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMInsuranceType", property = "fMInsuranceType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManPoliticsID", property = "foldManPoliticsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractNo", property = "fcontractNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractBegin", property = "fcontractBegin", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractEnd", property = "fcontractEnd", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckinTime", property = "fcheckinTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckoutTime", property = "fcheckoutTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveType", property = "fLeaveType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveReason", property = "fLeaveReason", javaType = String.class, jdbcType = JdbcType.VARCHAR),

            @Result(column = "FoldManCardNo", property = "foldManCardNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Foccupation", property = "foccupation", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAccidentInsurance", property = "fAccidentInsurance", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPledge", property = "fPledge", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbuildingID", property = "fbuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FroomID", property = "froomID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbedID", property = "fbedID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FisEntire", property = "fisEntire", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FmealFee", property = "fmealFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ftransactor", property = "ftransactor", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fnursing", property = "fnursing", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FnursingLevel", property = "fnursingLevel", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPhoto", property = "fPhoto", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FInstruction", property = "fInstruction", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursing_homeID", property = "fNursing_homeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),})
    public List<OldManMainPo> queryList(@Param("oldMan") OldManMainPo po,@Param("page") int page,@Param("pageSize") int pageSize,
                                        @Param("startTime") String startTime,@Param("stopTime") String stopTime);

    @SelectProvider(type=OldManProvider.class,method ="queryOldManMainByState" )
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FLevelID", property = "fLevelID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FoldManNum", property = "foldManNum", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBuildingName", property = "fBuildingName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRoomName", property = "fRoomName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FBedNumber", property = "fBedNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManStatusID", property = "foldManStatusID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManTypeID", property = "foldManTypeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMediaID", property = "foldManMediaID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManName", property = "foldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManSex", property = "foldManSex", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIdCard", property = "foldManIdCard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBirth", property = "foldManBirth", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIsLunar", property = "foldManIsLunar", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMobile", property = "foldManMobile", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNative", property = "foldManNative", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNationID", property = "foldManNationID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBeliefID", property = "foldManBeliefID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMInsuranceType", property = "fMInsuranceType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManPoliticsID", property = "foldManPoliticsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractNo", property = "fcontractNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractBegin", property = "fcontractBegin", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractEnd", property = "fcontractEnd", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckinTime", property = "fcheckinTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckoutTime", property = "fcheckoutTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveType", property = "fLeaveType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveReason", property = "fLeaveReason", javaType = String.class, jdbcType = JdbcType.VARCHAR),

            @Result(column = "FoldManCardNo", property = "foldManCardNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Foccupation", property = "foccupation", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAccidentInsurance", property = "fAccidentInsurance", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPledge", property = "fPledge", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbuildingID", property = "fbuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FroomID", property = "froomID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbedID", property = "fbedID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FisEntire", property = "fisEntire", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FmealFee", property = "fmealFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ftransactor", property = "ftransactor", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fnursing", property = "fnursing", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FnursingLevel", property = "fnursingLevel", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPhoto", property = "fPhoto", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FInstruction", property = "fInstruction", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursing_homeID", property = "fNursing_homeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),})
    public List<OldManMainPo> queryOldManMainByState(@Param("oldMan") OldManMainPo po,@Param("page") int page,@Param("pageSize") int pageSize,
                                        @Param("startTime") String startTime,@Param("stopTime") String stopTime);

    @SelectProvider(type=OldManProvider.class,method ="getomList" )
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FLevelID", property = "fLevelID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FoldManNum", property = "foldManNum", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FBuildingName", property = "fBuildingName", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FRoomName", property = "fRoomName", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FBedNumber", property = "fBedNumber", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FoldManStatusID", property = "foldManStatusID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManTypeID", property = "foldManTypeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMediaID", property = "foldManMediaID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManName", property = "foldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManSex", property = "foldManSex", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIdCard", property = "foldManIdCard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBirth", property = "foldManBirth", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIsLunar", property = "foldManIsLunar", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMobile", property = "foldManMobile", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNative", property = "foldManNative", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNationID", property = "foldManNationID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBeliefID", property = "foldManBeliefID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMInsuranceType", property = "fMInsuranceType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManPoliticsID", property = "foldManPoliticsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractNo", property = "fcontractNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractBegin", property = "fcontractBegin", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractEnd", property = "fcontractEnd", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckinTime", property = "fcheckinTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckoutTime", property = "fcheckoutTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveType", property = "fLeaveType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveReason", property = "fLeaveReason", javaType = String.class, jdbcType = JdbcType.VARCHAR),

            @Result(column = "FoldManCardNo", property = "foldManCardNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Foccupation", property = "foccupation", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAccidentInsurance", property = "fAccidentInsurance", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPledge", property = "fPledge", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbuildingID", property = "fbuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FroomID", property = "froomID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbedID", property = "fbedID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FisEntire", property = "fisEntire", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FmealFee", property = "fmealFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ftransactor", property = "ftransactor", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fnursing", property = "fnursing", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FnursingLevel", property = "fnursingLevel", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPhoto", property = "fPhoto", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FInstruction", property = "fInstruction", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursing_homeID", property = "fNursing_homeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),})
    public List<OldManMainPo> getomList(@Param("oldMan") OldManMainPo po);

    @Select("select * from T_OldMan_Main where FroomID=#{froomID}")
    public List<OldManMainPo> getOldManRoom(OldManMainPo po);

    @Select("select * from T_OldMan_Main order by FID desc Limit 0,1")
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FoldManNum", property = "foldManNum", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FoldManStatusID", property = "foldManStatusID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManTypeID", property = "foldManTypeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMediaID", property = "foldManMediaID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManName", property = "foldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManSex", property = "foldManSex", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIdCard", property = "foldManIdCard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBirth", property = "foldManBirth", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIsLunar", property = "foldManIsLunar", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMobile", property = "foldManMobile", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNative", property = "foldManNative", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNationID", property = "foldManNationID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBeliefID", property = "foldManBeliefID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMInsuranceType", property = "fMInsuranceType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManPoliticsID", property = "foldManPoliticsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractNo", property = "fcontractNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractBegin", property = "fcontractBegin", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractEnd", property = "fcontractEnd", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckinTime", property = "fcheckinTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckoutTime", property = "fcheckoutTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveType", property = "fLeaveType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveReason", property = "fLeaveReason", javaType = String.class, jdbcType = JdbcType.VARCHAR),

            @Result(column = "FoldManCardNo", property = "foldManCardNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Foccupation", property = "foccupation", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAccidentInsurance", property = "fAccidentInsurance", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPledge", property = "fPledge", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbuildingID", property = "fbuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FroomID", property = "froomID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbedID", property = "fbedID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FisEntire", property = "fisEntire", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FmealFee", property = "fmealFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ftransactor", property = "ftransactor", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fnursing", property = "fnursing", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FnursingLevel", property = "fnursingLevel", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPhoto", property = "fPhoto", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FInstruction", property = "fInstruction", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursing_homeID", property = "fNursing_homeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),})
    public List<OldManMainPo> queryLast();

    @Select("select * from T_OldMan_Main where FID=#{Id}")
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FoldManNum", property = "foldManNum", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FoldManStatusID", property = "foldManStatusID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManTypeID", property = "foldManTypeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMediaID", property = "foldManMediaID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManName", property = "foldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManSex", property = "foldManSex", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIdCard", property = "foldManIdCard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBirth", property = "foldManBirth", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIsLunar", property = "foldManIsLunar", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMobile", property = "foldManMobile", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNative", property = "foldManNative", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNationID", property = "foldManNationID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBeliefID", property = "foldManBeliefID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMInsuranceType", property = "fMInsuranceType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManPoliticsID", property = "foldManPoliticsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractNo", property = "fcontractNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractBegin", property = "fcontractBegin", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractEnd", property = "fcontractEnd", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckinTime", property = "fcheckinTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckoutTime", property = "fcheckoutTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveType", property = "fLeaveType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveReason", property = "fLeaveReason", javaType = String.class, jdbcType = JdbcType.VARCHAR),

            @Result(column = "FoldManCardNo", property = "foldManCardNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Foccupation", property = "foccupation", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAccidentInsurance", property = "fAccidentInsurance", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPledge", property = "fPledge", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbuildingID", property = "fbuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FroomID", property = "froomID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbedID", property = "fbedID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FisEntire", property = "fisEntire", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FmealFee", property = "fmealFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ftransactor", property = "ftransactor", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fnursing", property = "fnursing", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FnursingLevel", property = "fnursingLevel", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPhoto", property = "fPhoto", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FInstruction", property = "fInstruction", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursing_homeID", property = "fNursing_homeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),})
    public OldManMainPo getOldManById(String Id);

    @Select("select * from T_OldMan_Main order by FID desc Limit 0,1")
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FoldManNum", property = "foldManNum", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FoldManStatusID", property = "foldManStatusID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManTypeID", property = "foldManTypeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMediaID", property = "foldManMediaID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManName", property = "foldManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManSex", property = "foldManSex", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIdCard", property = "foldManIdCard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBirth", property = "foldManBirth", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManIsLunar", property = "foldManIsLunar", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManMobile", property = "foldManMobile", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNative", property = "foldManNative", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManNationID", property = "foldManNationID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManBeliefID", property = "foldManBeliefID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMInsuranceType", property = "fMInsuranceType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldManPoliticsID", property = "foldManPoliticsID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractNo", property = "fcontractNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractBegin", property = "fcontractBegin", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcontractEnd", property = "fcontractEnd", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckinTime", property = "fcheckinTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FcheckoutTime", property = "fcheckoutTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveType", property = "fLeaveType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLeaveReason", property = "fLeaveReason", javaType = String.class, jdbcType = JdbcType.VARCHAR),

            @Result(column = "FoldManCardNo", property = "foldManCardNo", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Foccupation", property = "foccupation", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAccidentInsurance", property = "fAccidentInsurance", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPledge", property = "fPledge", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbuildingID", property = "fbuildingID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FroomID", property = "froomID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FbedID", property = "fbedID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FisEntire", property = "fisEntire", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FmealFee", property = "fmealFee", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ftransactor", property = "ftransactor", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fnursing", property = "fnursing", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FnursingLevel", property = "fnursingLevel", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPhoto", property = "fPhoto", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FInstruction", property = "fInstruction", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursing_homeID", property = "fNursing_homeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),})
    public List<OldManMainPo> getOldMan();


    @Insert("insert into T_OldMan_Main (FCreatorID,FNursing_homeID,FoldManNum,FoldManName,FOldManIDnSex,FoldManStatusID,FbuildingID,FroomID,FbedID,FisEntire,\n" +
            "Foccupation,FoldManIdCard,FoldManBirth,FoldManIsLunar,FoldManPoliticsID,FoldManNationID,FoldManMediaID,FcontractNo,\n" +
            "FcontractBegin,FcontractEnd,FMInsuranceType,FoldManCardNo,Ftransactor,Fnursing,FoldManBeliefID,FoldManTypeID,\n" +
            "FoldManMobile,FcheckinTime,FnursingLevel,FAccidentInsurance,FmealFee,FPledge,FoldManNative,FInstruction,FPhoto)\n" +
            "values(#{fCreatorID},#{fNursing_homeID},#{foldManNum},#{foldManName},#{fOldManIDnSex},#{foldManStatusID},#{fbuildingID},#{froomID},#{fbedID},#{fisEntire}," +
            "#{foccupation},#{foldManIdCard},#{foldManBirth},#{foldManIsLunar},#{foldManPoliticsID},#{foldManNationID},#{foldManMediaID},#{fcontractNo}," +
            "#{fcontractBegin},#{fcontractEnd},#{fMInsuranceType},#{foldManCardNo},#{ftransactor},#{fnursing},#{foldManBeliefID},#{foldManTypeID}," +
            "#{foldManMobile},#{fcheckinTime},#{fnursingLevel},#{fAccidentInsurance},#{fmealFee},#{fPledge},#{foldManNative},#{fInstruction},#{fPhoto})")
    public int addBase(OldManMainPo po);

    @Update("update T_OldMan_Main set FoldManNum=#{foldManNum},FoldManName=#{foldManName},FOldManIDnSex=#{fOldManIDnSex}," +
            "FoldManStatusID=#{foldManStatusID},FbuildingID=#{fbuildingID},FroomID=#{froomID},FbedID=#{fbedID}," +
            "FisEntire=#{fisEntire},Foccupation=#{foccupation},FoldManIdCard=#{foldManIdCard},FoldManBirth=#{foldManBirth}," +
            "FoldManIsLunar=#{foldManIsLunar},FoldManPoliticsID=#{foldManPoliticsID},FoldManNationID=#{foldManNationID}," +
            "FoldManMediaID=#{foldManMediaID},FcontractNo=#{fcontractNo},FcontractBegin=#{fcontractBegin}," +
            "FcontractEnd=#{fcontractEnd},FMInsuranceType=#{fMInsuranceType},FoldManCardNo=#{foldManCardNo}," +
            "Ftransactor=#{ftransactor},Fnursing=#{fnursing},FoldManBeliefID=#{foldManBeliefID},FoldManTypeID=#{foldManTypeID}," +
            "FoldManMobile=#{foldManMobile},FcheckinTime=#{fcheckinTime},FnursingLevel=#{fnursingLevel}," +
            "FAccidentInsurance=#{fAccidentInsurance},FmealFee=#{fmealFee},FPledge=#{fPledge}," +
            "FoldManNative=#{foldManNative},FInstruction=#{fInstruction},FPhoto=#{fPhoto} where fID=#{fID}")
    public void updBase(OldManMainPo po);

    @Update("update T_OldMan_Main set FoldManStatusID=#{foldManStatusID} where fID=#{fID}")
    public void updOldManState(OldManMainPo po);

    class OldManProvider{

        public String getomList(Map<String,Object> param){
            OldManMainPo oldMan=(OldManMainPo) param.get("oldMan");
            StringBuffer sql=new StringBuffer();
            sql.append("select T_BUILDING.FBuildingName,T_ROOM.FRoomName,T_OldMan_Main.FID,T_OldMan_Main.FoldManNum," +
                    "T_OldMan_Main.FoldManName,T_OldMan_Main.FOldManIDnSex,T_OldMan_Main.FoldManStatusID," +
                    "T_OldMan_Main.FbuildingID,T_OldMan_Main.FroomID,T_OldMan_Main.FbedID,T_OldMan_Main.FisEntire," +
                    "T_OldMan_Main.Foccupation,T_OldMan_Main.FoldManIdCard,T_OldMan_Main.FoldManBirth," +
                    "T_OldMan_Main.FoldManIsLunar,T_OldMan_Main.FoldManPoliticsID,T_OldMan_Main.FoldManNationID," +
                    "T_OldMan_Main.FoldManMediaID,T_OldMan_Main.FcontractNo,T_OldMan_Main.FcontractBegin," +
                    "T_OldMan_Main.FcontractEnd,T_OldMan_Main.FMInsuranceType,T_OldMan_Main.FoldManCardNo," +
                    "T_OldMan_Main.Ftransactor,T_OldMan_Main.Fnursing,T_OldMan_Main.FoldManBeliefID," +
                    "T_OldMan_Main.FoldManTypeID,T_OldMan_Main.FoldManMobile,T_OldMan_Main.FcheckinTime," +
                    "T_OldMan_Main.FnursingLevel,T_OldMan_Main.FAccidentInsurance,T_OldMan_Main.FmealFee," +
                    "T_OldMan_Main.FPledge,T_OldMan_Main.FoldManNative,T_OldMan_Main.FInstruction,T_OldMan_Main.FPhoto " +
                    "from T_OldMan_Main,T_ROOM,T_BUILDING " +
                    "where T_OldMan_Main.FbuildingID=T_BUILDING.FID and T_OldMan_Main.FroomID=T_ROOM.FID ");
            if(oldMan==null){
                return sql.toString();
            }else{
                if(StringUtils.isNotEmpty(oldMan.getfID())){
                    sql.append(" and T_OldMan_Main.FID LIKE '%"+oldMan.getfID()+"%'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFoldManName())){
                    sql.append(" and T_OldMan_Main.FoldManName LIKE '%"+oldMan.getFoldManName()+"%'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFoldManStatusID())){
                    sql.append(" and T_OldMan_Main.FoldManStatusID LIKE '%"+oldMan.getFoldManStatusID()+"%'");
                }
//                if(startTime!=null){
//                    sql.append(" and FcheckinTime >='%"+startTime+"%'");
//                }
                if(StringUtils.isNotEmpty(oldMan.getFnursing())){
                    sql.append(" and Fnursing LIKE '%"+oldMan.getFnursing()+"%'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFroomID())){
                    sql.append(" and FroomID LIKE '%"+oldMan.getFroomID()+"%'");
                }
//                if(stopTime!=null){
//                    sql.append(" and FcheckinTime <= '%"+stopTime+"%'");
//                }
            }
            logger.debug("查询老人语句（不分页），slq:"+sql);
            return sql.toString();
        }

        public String queryList(Map<String,Object> param){
            OldManMainPo oldMan=(OldManMainPo) param.get("oldMan");
            String startTime=(String) param.get("startTime");
            String stopTime=(String) param.get("stopTime");
            StringBuffer sql=new StringBuffer();
            sql.append("select T_BUILDING.FBuildingName,T_ROOM.FRoomName,T_OldMan_Main.FID,T_OldMan_Main.FoldManNum," +
                    "T_OldMan_Main.FoldManName,T_OldMan_Main.FOldManIDnSex,T_OldMan_Main.FoldManStatusID," +
                    "T_OldMan_Main.FbuildingID,T_OldMan_Main.FroomID,T_OldMan_Main.FbedID,T_OldMan_Main.FisEntire," +
                    "T_OldMan_Main.Foccupation,T_OldMan_Main.FoldManIdCard,T_OldMan_Main.FoldManBirth," +
                    "T_OldMan_Main.FoldManIsLunar,T_OldMan_Main.FoldManPoliticsID,T_OldMan_Main.FoldManNationID," +
                    "T_OldMan_Main.FoldManMediaID,T_OldMan_Main.FcontractNo,T_OldMan_Main.FcontractBegin," +
                    "T_OldMan_Main.FcontractEnd,T_OldMan_Main.FMInsuranceType,T_OldMan_Main.FoldManCardNo," +
                    "T_OldMan_Main.Ftransactor,T_OldMan_Main.Fnursing,T_OldMan_Main.FoldManBeliefID," +
                    "T_OldMan_Main.FoldManTypeID,T_OldMan_Main.FoldManMobile,T_OldMan_Main.FcheckinTime," +
                    "T_OldMan_Main.FnursingLevel,T_OldMan_Main.FAccidentInsurance,T_OldMan_Main.FmealFee," +
                    "T_OldMan_Main.FPledge,T_OldMan_Main.FoldManNative,T_OldMan_Main.FInstruction,T_OldMan_Main.FPhoto " +
                    "from T_OldMan_Main,T_ROOM,T_BUILDING " +
                    "where T_OldMan_Main.FbuildingID=T_BUILDING.FID and T_OldMan_Main.FroomID=T_ROOM.FID ");
            if(oldMan==null){
                return sql.toString();
            }else{
                if(StringUtils.isNotEmpty(oldMan.getFoldManName())){
                    sql.append(" and FoldManName LIKE '%"+oldMan.getFoldManName()+"%'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFoldManStatusID())){
                    sql.append(" and FoldManStatusID LIKE '%"+oldMan.getFoldManStatusID()+"%'");
                }
                if(StringUtils.isNotEmpty(startTime)){
                    sql.append(" and FcheckinTime >='"+startTime+"'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFnursing())){
                    sql.append(" and Fnursing LIKE '%"+oldMan.getFnursing()+"%'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFroomID())){
                    sql.append(" and FroomID LIKE '%"+oldMan.getFroomID()+"%'");
                }
                if(StringUtils.isNotEmpty(stopTime)){
                    sql.append(" and FcheckinTime <= '"+stopTime+"'");
                }
            }
            sql.append(" order by FID desc limit #{page},#{pageSize}");
            logger.debug("查询老人语句，slq:"+sql);
            return sql.toString();
        }

        public String queryOldManMainByState(Map<String,Object> param){
            OldManMainPo oldMan=(OldManMainPo) param.get("oldMan");
            String startTime=(String) param.get("startTime");
            String stopTime=(String) param.get("stopTime");
            StringBuffer sql=new StringBuffer();
            sql.append("select T_BUILDING.FBuildingName,T_ROOM.FRoomName,T_OldMan_Main.FID,T_OldMan_Main.FoldManNum," +
                    "T_OldMan_Main.FoldManName,T_OldMan_Main.FOldManIDnSex,T_OldMan_Main.FoldManStatusID," +
                    "T_OldMan_Main.FbuildingID,T_OldMan_Main.FroomID,T_OldMan_Main.FbedID,T_OldMan_Main.FisEntire," +
                    "T_OldMan_Main.Foccupation,T_OldMan_Main.FoldManIdCard,T_OldMan_Main.FoldManBirth," +
                    "T_OldMan_Main.FoldManIsLunar,T_OldMan_Main.FoldManPoliticsID,T_OldMan_Main.FoldManNationID," +
                    "T_OldMan_Main.FoldManMediaID,T_OldMan_Main.FcontractNo,T_OldMan_Main.FcontractBegin," +
                    "T_OldMan_Main.FcontractEnd,T_OldMan_Main.FMInsuranceType,T_OldMan_Main.FoldManCardNo," +
                    "T_OldMan_Main.Ftransactor,T_OldMan_Main.Fnursing,T_OldMan_Main.FoldManBeliefID," +
                    "T_OldMan_Main.FoldManTypeID,T_OldMan_Main.FoldManMobile,T_OldMan_Main.FcheckinTime," +
                    "T_OldMan_Main.FnursingLevel,T_OldMan_Main.FAccidentInsurance,T_OldMan_Main.FmealFee," +
                    "T_OldMan_Main.FPledge,T_OldMan_Main.FoldManNative,T_OldMan_Main.FInstruction,T_OldMan_Main.FPhoto " +
                    "from T_OldMan_Main,T_ROOM,T_BUILDING " +
                    "where T_OldMan_Main.FbuildingID=T_BUILDING.FID and T_OldMan_Main.FroomID=T_ROOM.FID and T_OldMan_Main.FoldManStatusID in (46,47) ");
            if(oldMan==null){
                return sql.toString();
            }else{
                if(StringUtils.isNotEmpty(oldMan.getFoldManName())){
                    sql.append(" and FoldManName LIKE '%"+oldMan.getFoldManName()+"%'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFoldManStatusID())){
                    sql.append(" and FoldManStatusID LIKE '%"+oldMan.getFoldManStatusID()+"%'");
                }
                if(StringUtils.isNotEmpty(startTime)){
                    sql.append(" and FcheckinTime >='"+startTime+"'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFnursing())){
                    sql.append(" and Fnursing LIKE '%"+oldMan.getFnursing()+"%'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFroomID())){
                    sql.append(" and FroomID LIKE '%"+oldMan.getFroomID()+"%'");
                }
                if(StringUtils.isNotEmpty(stopTime)){
                    sql.append(" and FcheckinTime <= '"+stopTime+"'");
                }
            }
            sql.append(" order by FID desc limit #{page},#{pageSize}");
            logger.debug("查询老人语句，slq:"+sql);
            return sql.toString();
        }

        public String queryCount(Map<String,Object> params){

            OldManMainPo oldMan=(OldManMainPo) params.get("param");
            String startTime=(String) params.get("startTime");
            String stopTime=(String) params.get("stopTime");
            StringBuffer sql=new StringBuffer();
            sql.append("select count(*) from T_OldMan_Main,T_ROOM,T_BUILDING " +
                    "where T_OldMan_Main.FbuildingID=T_BUILDING.FID and T_OldMan_Main.FroomID=T_ROOM.FID ");
            if(oldMan==null){
                return sql.toString();
            }else{
                if(StringUtils.isNotEmpty(oldMan.getFoldManName())){
                    sql.append(" and FoldManName= '"+oldMan.getFoldManName()+"'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFoldManStatusID())){
                    sql.append(" and FoldManStatusID= '"+oldMan.getFoldManStatusID()+"'");
                }
                if(StringUtils.isNotEmpty(startTime)){
                    sql.append(" and FcheckinTime >= '"+startTime+"'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFnursing())){
                    sql.append(" and Fnursing LIKE '%"+oldMan.getFnursing()+"%'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFroomID())){
                    sql.append(" and FroomID LIKE '%"+oldMan.getFroomID()+"%'");
                }
                if(StringUtils.isNotEmpty(stopTime)){
                    sql.append(" and FcheckinTime <= '"+stopTime+"'");
                }
            }
            logger.debug("查询老人总数语句："+sql.toString());
            return sql.toString();
        }
        //46和47是在院和请假
        public String queryCountByState(Map<String,Object> params){
            OldManMainPo oldMan=(OldManMainPo) params.get("param");
            StringBuffer sql=new StringBuffer();
            sql.append("select count(*) from T_OldMan_Main,T_ROOM,T_BUILDING " +
                    "where T_OldMan_Main.FbuildingID=T_BUILDING.FID and T_OldMan_Main.FroomID=T_ROOM.FID and T_OldMan_Main.FoldManStatusID in (46,47) ");
            if(oldMan==null){
                return sql.toString();
            }else{
                if(StringUtils.isNotEmpty(oldMan.getFoldManName())){
                    sql.append(" and FoldManName= '"+oldMan.getFoldManName()+"'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFoldManStatusID())){
                    sql.append(" and FoldManStatusID= '"+oldMan.getFoldManStatusID()+"'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFnursing())){
                    sql.append(" and Fnursing LIKE '%"+oldMan.getFnursing()+"%'");
                }
                if(StringUtils.isNotEmpty(oldMan.getFroomID())){
                    sql.append(" and FroomID LIKE '%"+oldMan.getFroomID()+"%'");
                }
            }
            logger.debug("查询老人总数语句："+sql.toString());
            return sql.toString();
        }
    }
}
