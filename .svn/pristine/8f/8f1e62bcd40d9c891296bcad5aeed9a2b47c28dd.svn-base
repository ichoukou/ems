package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.PerfMaintainPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by 张鑫 on 2016/12/19.
 */
public interface PerfMaintainMapper {
    public static Logger logger = Logger.getLogger(PerfMaintainMapper.class);
    //得到数据字典
    @Select("select DC_ID,DC_NAME,DC_VALUE from DATA_DICTIONARY where DC_NAME='绩效标准'")
    public List<Map<String,String>> getDCname();
    //得到结果
    @Select("select FCoefficient,FAssessmentResult from T_STAFF_PERFORMANCESTANDARD where #{sum} between FLowerLimit and FHighLimit")
    public List<Map<String,String>> getResult(String sum);
    //新增主表
    @Insert("INSERT INTO T_STAFF_PERFORMANCE " +
            "(FNumber,FNursingHomeID,FStaffID,FPerformanceDate,FPerformanceYear,FPerformanceMonth,FTotal,FCoefficient,FPerformanceResult,FCreatorID,FCreateTime) " +
            "values" +
            "(#{fNumber},#{fNursingHomeID},#{fStaffID},#{fPerformanceDate},#{fPerformanceYear},#{fPerformanceMonth},#{fTotal},#{fCoefficient},#{fPerformanceResult},#{fCreatorID},#{fCreateTime})")
    public void addParentTable(PerfMaintainPo maintainPo);
    //查询获得主表ID
    @Select("SELECT FID FROM (select " +
            "a.FID,b.FStaffName,a.FPerformanceYear,a.FPerformanceMonth,a.FPerformanceDate,a.FTotal,a.FCoefficient,a.FPerformanceResult " +
            "from  " +
            "T_STAFF_PERFORMANCE a,T_STAFF_MESSAGE b " +
            "where " +
            "a.FStaffID = b.FID) t order by FID DESC limit 1")
    public String queryFID();
    //新增子表
    @SelectProvider(type=PerfMainProvider.class,method="InsertList")
    public void insertID(@Param("nowFproject") String[] nowFproject ,@Param("nowScore") String nowScore[],@Param("param") PerfMaintainPo param,@Param("fId") String fId);
    //根据FNumber得到子表分数，FID
    @Select("select FID,FScore from T_STAFF_PERFORMANCEENTRY where FNumber = #{fNumber}")
    public List<Map<String,String>> queryScore(String fNumber);
    //查询
    @SelectProvider(type = ChangeProvider.class, method = "queryCount")
    public int queryCount(@Param("param") PerfMaintainPo param);

    @SelectProvider(type = ChangeProvider.class, method = "queryList")
    public List<PerfMaintainPo> queryList(@Param("param") PerfMaintainPo param, @Param(value = "page") int page, @Param(value = "pageSize") int pageSize);

    //更改主表中的数据
    @Update("UPDATE T_STAFF_PERFORMANCE SET " +
            "FNumber=#{fNumber},FNursingHomeID=#{fNursingHomeID},FStaffID=#{fStaffID},FPerformanceDate=#{fPerformanceDate},FPerformanceYear=#{fPerformanceYear},FPerformanceMonth=#{fPerformanceMonth},FTotal=#{fTotal},FCoefficient=#{fCoefficient},FPerformanceResult=#{fPerformanceResult},FCreatorID=#{fCreatorID},FCreateTime=#{fCreateTime} " +
            "where " +
            "FID=#{fID}")
    public void updateMainMaintain(PerfMaintainPo po);

    //批量更改子表中数据
    @SelectProvider(type=MaintainProvider.class,method="updateMaintainList")
    public void updateMaintainList(@Param("fId") String[] fId ,@Param("nowScore") String nowScore[],@Param("param") PerfMaintainPo param,@Param("nowIdFproject") String nowIdFproject[]);

    //删除主表
    @Delete("DELETE  from T_STAFF_PERFORMANCE where FID=#{fID} ")
    public void deleteMaintain(PerfMaintainPo  po);
    //删除子表
    @Delete("DELETE  from T_STAFF_PERFORMANCEENTRY where FNumber = #{fID}")
    public void deleteMaintainEntry(PerfMaintainPo po);

    class MaintainProvider {
        public String updateMaintainList(Map<String, Object> params) {
            PerfMaintainPo maintainPo = (PerfMaintainPo) params.get("param");
            String[] nowScore=(String[])params.get("nowScore");
            String[] fID=(String[])params.get("fId");
            String[] nowIdFproject = (String[])params.get("nowIdFproject");
            StringBuffer sql = new StringBuffer("insert into T_STAFF_PERFORMANCEENTRY (FID,FNumber,FProjectID,FNursingHomeID,FScore,FCreatorID,FCreateTime) " +
                    "values ");

            for (int i=0; i < fID.length;i++) {
                sql.append("(").append("'"+fID[i]+"'").append(",'"+maintainPo.getfID()+"',").append("'"+nowIdFproject[i]+"',").append("'"+maintainPo.getfNursingHomeID()+"',").append("'"+nowScore[i]+"',").append("'"+maintainPo.getfCreatorID()+"',").append("'"+maintainPo.getfCreateTime()+"')");
                if(i==fID.length-1){
                    sql.append(" on duplicate key update FScore=values(FScore),FProjectID=values(FProjectID),FNursingHomeID=values(FNursingHomeID),FNumber=values(FNumber),FCreatorID=values(FCreatorID),FCreateTime=values(FCreateTime);");
                }else{
                    sql.append(",");
                }
            }
//            StringBuffer sql = new StringBuffer();
//            for (int i=0; i < fID.length;i++){
//            sql.append("update T_STAFF_PERFORMANCEENTRY set FID= '"+fID[i]+"',FScore='"+nowScore[i]+"',FCreateTime='"+maintainPo.getfCreateTime()+"'");
//            }
            logger.debug(sql.toString());
            return sql.toString();
        }
    }

    class ChangeProvider {
        public String queryList(Map<String, Object> params) {
            PerfMaintainPo maintainPo = (PerfMaintainPo) params.get("param");
            StringBuffer empSql = new StringBuffer();
            empSql.append("select " +
                    "a.FID,b.FStaffName,a.FPerformanceYear,a.FPerformanceMonth,a.FPerformanceDate,a.FTotal,a.FCoefficient,a.FPerformanceResult " +
                    "from " +
                    "T_STAFF_PERFORMANCE a,T_STAFF_MESSAGE b " +
                    "where " +
                    "a.FStaffID = b.FID");
            if (null == maintainPo) {
                return empSql.toString();
            } else {
                if (StringUtils.isNotEmpty(maintainPo.getfStaffID())) {
                    empSql.append(" and a.FStaffID = '" + maintainPo.getfStaffID() + "'");
                }
                if (StringUtils.isNotEmpty(maintainPo.getfPerformanceMonth())) {
                    empSql.append(" and a.FPerformanceMonth = '" + maintainPo.getfPerformanceMonth() + "'");
                }
                if (StringUtils.isNotEmpty(maintainPo.getfPerformanceYear())) {
                    empSql.append(" and a.FPerformanceYear ='" +maintainPo.getfPerformanceYear() + "'");
                }
            }
            empSql.append(" limit #{page},#{pageSize}");
            logger.debug(empSql.toString());
            return empSql.toString();
        }

        public String queryCount(Map<String, Object> params) {
            PerfMaintainPo maintainPo = (PerfMaintainPo) params.get("param");
            StringBuffer sb = new StringBuffer();
            sb.append("select count(*) from (select " +
                    "b.FStaffName,a.FStaffID,a.FPerformanceYear,a.FPerformanceMonth,a.FPerformanceDate,a.FTotal,a.FCoefficient,a.FPerformanceResult " +
                    "from " +
                    "T_STAFF_PERFORMANCE a,T_STAFF_MESSAGE b " +
                    "where " +
                    "a.FStaffID = b.FID) t "+
                    " where 1=1 ");
            if (null == maintainPo) {
                return sb.toString();
            } else {
                if (StringUtils.isNotEmpty(maintainPo.getfStaffID())) {
                    sb.append(" and FStaffID = '" + maintainPo.getfStaffID() + "'");
                }
                if (StringUtils.isNotEmpty(maintainPo.getfPerformanceMonth())) {
                    sb.append(" and FPerformanceMonth ='" + maintainPo.getfPerformanceMonth() + "'");
                }
                if (StringUtils.isNotEmpty(maintainPo.getfPerformanceYear())) {
                    sb.append(" and FPerformanceYear = '" + maintainPo.getfPerformanceYear() + "'");
                }
            }
            logger.debug(sb.toString());
            return sb.toString();
        }
    }

    class PerfMainProvider{

        public String InsertList(Map<String,Object> params){
            PerfMaintainPo maintainPo = (PerfMaintainPo) params.get("param");
            String[]nowFproject=(String[])params.get("nowFproject");
            String[]nowScore=(String[])params.get("nowScore");
            String fID=(String)params.get("fId");
            StringBuffer sql=new StringBuffer("INSERT INTO T_STAFF_PERFORMANCEENTRY " +
                    "(FNumber,FProjectID,FScore,FNursingHomeID,FCreatorID,FCreateTime) " +
                    "values ");

            for(int i=0;i<nowFproject.length;i++){
                sql.append( " (").append("'"+fID+"'").append(",").append("'"+nowFproject[i]+"'").append(",'"+nowScore[i]+"'").append(",").append("'"+maintainPo.getfNursingHomeID()+"'").append(","+maintainPo.getfCreatorID()+",'"+maintainPo.getfCreateTime()+"'").append(") ");
                if(i==nowFproject.length-1){
                    sql.append(";");
                }else{
                    sql.append(",");
                }
            }
            logger.debug(sql.toString());
            return sql.toString();
        }
    }
}
