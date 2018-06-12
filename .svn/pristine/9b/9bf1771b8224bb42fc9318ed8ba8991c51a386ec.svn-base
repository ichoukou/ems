package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.StandardPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by 张鑫 on 2016/12/18.
 */
public interface PerfStandardMapper {

    public static Logger logger = Logger.getLogger(PerfStandardMapper.class);

    @Insert("INSERT INTO T_STAFF_PERFORMANCESTANDARD  " +
            "(FNursingHomeID,FHighLimit,FLowerLimit,FCoefficient,FAssessmentResult,FCreatorID,FCreateTime) " +
            "VALUES " +
            "(#{fNursingHomeID},#{fHighLimit},#{fLowerLimit},#{fCoefficient},#{fAssessmentResult},#{fCreatorID},#{fCreateTime})")
    public int addStandard(StandardPo standardPo);

    @Delete("DELETE  FROM T_STAFF_PERFORMANCESTANDARD WHERE FID=#{fID}")
    public void deleteStandard(String fID);

    @Update("UPDATE T_STAFF_PERFORMANCESTANDARD SET  " +
            "FNursingHomeID=#{fNursingHomeID},FHighLimit=#{fHighLimit},FLowerLimit=#{fLowerLimit},FCoefficient=#{fCoefficient},FAssessmentResult=#{fAssessmentResult},FCreatorID=#{fCreatorID},FCreateTime=#{fCreateTime}" +
            "where FID=#{fID}")
    public int updatePerfStandardList(StandardPo standardPo);

    @Select("select count(*) from(select " +
            "FID,FNursingHomeID,FHighLimit,FLowerLimit,FCoefficient,FAssessmentResult " +
            "from " +
            "T_STAFF_PERFORMANCESTANDARD) t")
    public int  queryCount();

    @Select("select " +
            "FID,FNursingHomeID,FHighLimit,FLowerLimit,FCoefficient,FAssessmentResult " +
            "from  " +
            "T_STAFF_PERFORMANCESTANDARD  limit #{0},#{1}")
    public List<StandardPo>  queryList(Integer page, Integer pageSize);

}
