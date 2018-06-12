package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.LeavePo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by 张鑫 on 2016/12/14.
 */
public interface EmpLeaveMapper {
    public static Logger logger = Logger.getLogger(EmpLeaveMapper.class);

    @SelectProvider(type = ChangeProvider.class, method = "queryCount")
    public int queryCount(@Param("param") LeavePo param);

    @SelectProvider(type = ChangeProvider.class, method = "queryList")
    public List<LeavePo> queryList(@Param("param") LeavePo param, @Param(value = "page") int page, @Param(value = "pageSize") int pageSize);

    @Insert("INSERT INTO T_LEAVE (FNursinghomeID,FStaffID,FStartTime,FStopTime,FWhenLong,FLeaveReason,FExplain,FCreatorID,FCreateTime) " +
            " VALUES" +
            "(#{fNursinghomeID},#{fStaffId},#{fStartTime},#{fStopTime},#{fWhenLong},#{fLeaveReason},#{fExplain},#{fCreatorID},#{fCreateTime})")
    public int addEmpList(LeavePo leavePo);

    @Delete("DELETE  FROM T_LEAVE WHERE FID=#{fId}")
    public void deleteEmpLeave(String fId);

    @Update("UPDATE T_LEAVE SET FNursinghomeID=#{fNursinghomeID},FCreatorID=#{fCreatorID}, FStaffID=#{fStaffId},FStartTime=#{fStartTime},FStopTime=#{fStopTime},FWhenLong=#{fWhenLong},FLeaveReason=#{fLeaveReason},FExplain=#{fExplain},FCreateTime=#{fCreateTime} where FID=#{fId}")
    public int updateEmpLeaveList(LeavePo leavePo);

    @Select("SELECT FStartTime,FStopTime from T_LEAVE where FStaffId=#{fStaffId}")
    public List<LeavePo> queryAddTime(LeavePo po);

    @Select("SELECT FStartTime,FStopTime from T_LEAVE where FStaffId=#{fStaffId} and FID<>#{fId}")
    public List<LeavePo> queryUpdateTime(LeavePo po);

    class ChangeProvider {
        public String queryList(Map<String, Object> params) {
            LeavePo leavePo = (LeavePo) params.get("param");
            StringBuffer empSql = new StringBuffer();
            empSql.append("select t.*,c.FStaffName FCreatorName " +
                    "from(select b.FID,b.FStaffID,a.FStaffName,b.FStartTime,b.FStopTime,b.FLeaveReason,b.FExplain,b.FCreatorID " +
                    "from T_STAFF_MESSAGE a,T_LEAVE b where a.FID=b.FStaffID) t,T_STAFF_MESSAGE c " +
                    "where t.FCreatorID = c.FID");
            if (null == leavePo) {
                return empSql.toString();
            } else {
                if (StringUtils.isNotEmpty(leavePo.getfStaffId())) {
                    empSql.append(" and t.FStaffID = '" + leavePo.getfStaffId() + "'");
                }
                if (StringUtils.isNotEmpty(leavePo.getfStartTime())&&leavePo.getfStartTime().length()==7) {
                    empSql.append(" and t.FStartTime like( '" + leavePo.getfStartTime() + "%')");
                }else if (StringUtils.isNotEmpty(leavePo.getfStartTime())&&leavePo.getfStartTime().length()!=7&&leavePo.getfStartTime().length()!=4){
                    empSql.append(" and quarter(t.FStartTime ) = quarter('"+leavePo.getfStartTime()+"')");
                }else if (StringUtils.isNotEmpty(leavePo.getfStartTime())&&leavePo.getfStartTime().length()==4){
                    empSql.append(" and t.FStartTime like( '" + leavePo.getfStartTime() + "%')");
                }
            }
            empSql.append(" limit #{page},#{pageSize}");
            logger.debug(empSql.toString());
            return empSql.toString();
        }

        public String queryCount(Map<String, Object> params) {
            LeavePo leavePo = (LeavePo) params.get("param");
            StringBuffer sb = new StringBuffer();
            sb.append("select count(*) from ( " +
                    "select t.*,c.FStaffName FCreatorName " +
                    "from(select b.FID,b.FStaffID,a.FStaffName,b.FStartTime,b.FStopTime,b.FLeaveReason,b.FExplain,b.FCreatorID " +
                    "from T_STAFF_MESSAGE a,T_LEAVE b where a.FID=b.FStaffID) t,T_STAFF_MESSAGE c " +
                    "where t.FCreatorID = c.FID) t1"+
                    " where 1=1 ");
            if (null == leavePo) {
                return sb.toString();
            } else {
                if (StringUtils.isNotEmpty(leavePo.getfStaffId())) {
                    sb.append(" and FStaffID = '" + leavePo.getfStaffId() + "'");
                }
                if (StringUtils.isNotEmpty(leavePo.getfStartTime())&&leavePo.getfStartTime().length()==7) {
                    sb.append(" and FStartTime like( '" + leavePo.getfStartTime() + "%')");
                }else if (StringUtils.isNotEmpty(leavePo.getfStartTime())&&leavePo.getfStartTime().length()!=7&&leavePo.getfStartTime().length()!=4){
                    sb.append(" and quarter(FStartTime) = quarter('"+leavePo.getfStartTime()+"')");
                }else if (StringUtils.isNotEmpty(leavePo.getfStartTime())&&leavePo.getfStartTime().length()==4){
                    sb.append(" and FStartTime like( '" + leavePo.getfStartTime() + "%')");
                }
            }
            logger.debug(sb.toString());
            return sb.toString();
        }
    }
}
