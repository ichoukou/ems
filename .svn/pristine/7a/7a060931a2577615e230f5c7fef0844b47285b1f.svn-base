package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.MessagePo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;


/**
 * Created by 张鑫 on 2016/12/9.
 */
public interface EmpMessageMapper {

    public static Logger logger = Logger.getLogger(EmpMessageMapper.class);

    @SelectProvider(type = ChangeProvider.class, method = "queryCount")
    public int queryCount(@Param("param") MessagePo param);


    @SelectProvider(type = ChangeProvider.class, method = "queryList")
    @Results(value = {
            @Result(column="FID",property="fId",javaType=String.class,jdbcType=JdbcType.INTEGER),
            @Result(column="FStaffName",property="fStaffName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FSex",property="fSex",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FEntryDate",property="fEntryDate",javaType=String.class,jdbcType=JdbcType.DATE),
            @Result(column="FDismissalDate",property="fDismissalDate",javaType=String.class,jdbcType=JdbcType.DATE),
            @Result(column="FBrith",property="fBrith",javaType=String.class,jdbcType=JdbcType.DATE),
            @Result(column="FLunarBrith",property="fLunarBrith",javaType=String.class,jdbcType=JdbcType.DATE),
            @Result(column="FDepartmentName",property="fDepartmentName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FPost",property="fPost",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FBuildingName",property="fBuildingName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FMobileTel",property="fMobileTel",javaType=String.class,jdbcType = JdbcType.VARCHAR),
            @Result(column="FTitle",property="fTitle",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FSalryType",property="fSalryType",javaType=String.class,jdbcType = JdbcType.VARCHAR),
            @Result(column="FStaffStatus",property="fStaffStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FFnation",property="fFnation",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FNursinghomeID",property="fNursinghomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FIdentityCardID",property="fIdentityCardID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FLunarCalendar",property="fLunarCalendar",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FMaritalStatus",property="fMaritalStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FGraduateSchool",property="fGraduateSchool",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FEducation",property="fEducation",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FMajor",property="fMajor",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FCertificate",property="fCertificate",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FComputerLevel",property="fComputerLevel",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FLanguageLevel",property="fLanguageLevel",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FSalryType",property="fSalryType",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FBankCardID",property="fBankCardID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FHealth",property="fHealth",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FPostcode",property="fPostcode",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FHpisejpldRegister",property="fHpisejpldRegister",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FHomeAddress",property="fHomeAddress",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FPoliticalStatus",property="fPoliticalStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FTel",property="fTel",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FNursinghomeID",property="fNursinghomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FNursingName",property="fNursinghome",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FWechatNumber",property="fWechatNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FRemarks",property="fRemarks",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FState",property="fState",javaType=String.class,jdbcType=JdbcType.INTEGER),
    })
    public List<MessagePo> queryList(@Param("param") MessagePo param, @Param(value = "page") int page, @Param(value = "pageSize") int pageSize);

    @SelectProvider(type = ChangeProvider.class, method = "getList")
    @Results(value = {
            @Result(column="FID",property="fId",javaType=String.class,jdbcType=JdbcType.INTEGER),
            @Result(column="FStaffName",property="fStaffName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FSex",property="fSex",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FEntryDate",property="fEntryDate",javaType=String.class,jdbcType=JdbcType.DATE),
            @Result(column="FDismissalDate",property="fDismissalDate",javaType=String.class,jdbcType=JdbcType.DATE),
            @Result(column="FBrith",property="fBrith",javaType=String.class,jdbcType=JdbcType.DATE),
            @Result(column="FLunarBrith",property="fLunarBrith",javaType=String.class,jdbcType=JdbcType.DATE),
            @Result(column="FDepartmentName",property="fDepartmentName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FPost",property="fPost",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FBuildingName",property="fBuildingName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FMobileTel",property="fMobileTel",javaType=String.class,jdbcType = JdbcType.VARCHAR),
            @Result(column="FTitle",property="fTitle",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FSalryType",property="fSalryType",javaType=String.class,jdbcType = JdbcType.VARCHAR),
            @Result(column="FStaffStatus",property="fStaffStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FFnation",property="fFnation",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FNursinghomeID",property="fNursinghomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FIdentityCardID",property="fIdentityCardID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FLunarCalendar",property="fLunarCalendar",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FMaritalStatus",property="fMaritalStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FGraduateSchool",property="fGraduateSchool",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FEducation",property="fEducation",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FMajor",property="fMajor",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FCertificate",property="fCertificate",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FComputerLevel",property="fComputerLevel",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FLanguageLevel",property="fLanguageLevel",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FSalryType",property="fSalryType",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FBankCardID",property="fBankCardID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FHealth",property="fHealth",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FPostcode",property="fPostcode",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FHpisejpldRegister",property="fHpisejpldRegister",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FHomeAddress",property="fHomeAddress",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FPoliticalStatus",property="fPoliticalStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FTel",property="fTel",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FNursinghomeID",property="fNursinghomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FNursingName",property="fNursinghome",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FWechatNumber",property="fWechatNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FRemarks",property="fRemarks",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FState",property="fState",javaType=String.class,jdbcType=JdbcType.INTEGER),

    })
    public List<MessagePo> getList(@Param("param") MessagePo param);

    @Select("select e.FID,e.FDepartmentName,e.FStatus from T_DEPARTMENT e")
    public List<Map<String,String>> getDepartName();

    @Update("UPDATE S_USER SET u_oldhouse=#{fNursinghomeID} WHERE employ_id=#{fId}")
    public void updateUserMessage(MessagePo po);

    @Update("UPDATE T_STAFF_MESSAGE SET FState=0 WHERE FID=#{fId}")
    public void deleteEmpMessage(String fId);

    @Update("UPDATE T_STAFF_MESSAGE SET FState=1 WHERE FID=#{fId} ")
    public void startState(MessagePo po);

    @Update("UPDATE T_STAFF_MESSAGE SET  " +
            "FStaffID='2',FStaffNumber='B1234' ,FStaffName=#{fStaffName} ,FStaffStatus=#{fStaffStatus},FFnation=#{fFnation},  " +
            "FDepartmentID=#{fDepartmentID} ,FNursinghomeID=#{fNursinghomeID},FPost=#{fPost},FTitle=#{fTitle},FEntryDate=#{fEntryDate}, " +
            "FDismissalDate=#{fDismissalDate} ,FBuildingID=#{fBuildingID},FIdentityCardID=#{fIdentityCardID},FBrith=#{fBrith},FLunarCalendar=#{fLunarCalendar}, " +
            "FLunarBrith=#{fLunarBrith} ,FMaritalStatus=#{fMaritalStatus},FGraduateSchool=#{fGraduateSchool},FEducation=#{fEducation},FMajor=#{fMajor}, " +
            "FCertificate=#{fCertificate} ,FComputerLevel=#{fComputerLevel},FLanguageLevel=#{fLanguageLevel},FSalryType=#{fSalryType},FBankCardID=#{fBankCardID}, " +
            "FHealth=#{fHealth} ,FPostcode=#{fPostcode},FHpisejpldRegister=#{fHpisejpldRegister},FHomeAddress=#{fHomeAddress},FPhotoID=#{fPhotoID}, " +
            "FSex=#{fSex} ,FPoliticalStatus=#{fPoliticalStatus},FTel=#{fTel},FMobileTel=#{fMobileTel},FWechatNumber=#{fWechatNumber}, " +
            "FRemarks=#{fRemarks} " +
            "WHERE FID=#{fId} ")
    public void updateEmpMessage(MessagePo messagePo);

    @Insert("INSERT INTO T_STAFF_MESSAGE " +
            " (FStaffID,FStaffNumber,FStaffName,FStaffStatus,FFnation, " +
            " FDepartmentID,FNursinghomeID,FPost,FTitle,FEntryDate,FDismissalDate,FBuildingID, " +
            " FIdentityCardID,FBrith,FLunarCalendar,FLunarBrith,FMaritalStatus, " +
            " FGraduateSchool,FEducation,FMajor,FCertificate,FComputerLevel,FLanguageLevel, " +
            " FSalryType,FBankCardID,FHealth,FPostcode,FHpisejpldRegister,FHomeAddress,FPhotoID, " +
            " FSex,FPoliticalStatus,FTel,FMobileTel,FWechatNumber,FRemarks,FState) " +
            " VALUES" +
            " ('1','A1234',#{fStaffName},#{fStaffStatus},#{fFnation},#{fDepartmentID},#{fNursinghomeID},#{fPost},#{fTitle}, " +
            " #{fEntryDate},#{fDismissalDate},#{fBuildingID},#{fIdentityCardID},#{fBrith},#{fLunarCalendar}, " +
            " #{fLunarBrith},#{fMaritalStatus},#{fGraduateSchool},#{fEducation},#{fMajor},#{fCertificate}, " +
            " #{fComputerLevel},#{fLanguageLevel},#{fSalryType},#{fBankCardID},#{fHealth},#{fPostcode}, " +
            " #{fHpisejpldRegister},#{fHomeAddress},#{fPhotoID},#{fSex},#{fPoliticalStatus},#{fTel}, " +
            " #{fMobileTel},#{fWechatNumber},#{fRemarks},'1')")
    public void addEmpList(MessagePo messagePo);

    class ChangeProvider {
        public String getList(Map<String, Object> params) {
            MessagePo message = (MessagePo) params.get("param");
            StringBuffer empSql = new StringBuffer();
            empSql.append("select " +
                    "a.FID FID,a.FStaffName FStaffName,d.FNursingName,a.FSex FSex,a.FEntryDate FEntryDate,b.FDepartmentName FDepartmentName,a.FPost FPost, " +
                    "c.FBuildingName FBuildingName,a.FMobileTel FMobileTel,a.FTitle FTitle,a.FSalryType FSalryType,a.FStaffStatus FStaffStatus, " +
                    "a.FFnation,a.FNursinghomeID,a.FIdentityCardID,a.FLunarCalendar,a.FMaritalStatus, a.FLunarBrith,a.FDismissalDate,FBrith, " +
                    "a.FGraduateSchool,a.FEducation,a.FMajor,a.FCertificate,a.FComputerLevel,a.FLanguageLevel,a.FSalryType,a.FBankCardID,a.FHealth, " +
                    "a.FPostcode,a.FPhotoID,a.FHpisejpldRegister,a.FHomeAddress,a.FPoliticalStatus,a.FTel,a.FWechatNumber,a.FRemarks,a.FState,d.FNursingName fNursinghome" +
                    " from  " +
                    "T_STAFF_MESSAGE a,T_DEPARTMENT b,T_BUILDING c,T_SYS_NursingHome d " +
                    "where " +
                    "a.FDepartmentID = b.FID and a.FBuildingID = c.FID and a.FNursinghomeID = d.FID");
            if (null == message) {
                return empSql.toString();
            } else {
                if (StringUtils.isNotEmpty(message.getfId())) {
                    empSql.append(" and a.FID = '" + message.getfId() + "'");
                }
                if (StringUtils.isNotEmpty(message.getfStaffName())) {
                    empSql.append(" and FStaffName like '%" + message.getfStaffName() + "%'");
                }
                if (StringUtils.isNotEmpty(message.getfStaffStatus())) {
                    empSql.append(" and FStaffStatus = '" + message.getfStaffStatus() + "'");
                }
                if (StringUtils.isNotEmpty(message.getfDepartmentID())) {
                    empSql.append(" and FDepartmentID = " + Integer.parseInt(message.getfDepartmentID()));
                }
            }
            logger.debug(empSql.toString());
            return empSql.toString();
        }

        public String queryList(Map<String, Object> params) {
            MessagePo message = (MessagePo) params.get("param");
            StringBuffer empSql = new StringBuffer();
            empSql.append("select " +
                    "a.FID FID,a.FStaffName FStaffName,d.FNursingName,a.FSex FSex,a.FEntryDate FEntryDate,b.FDepartmentName FDepartmentName,a.FPost FPost, " +
                    "c.FBuildingName FBuildingName,a.FMobileTel FMobileTel,a.FTitle FTitle,a.FSalryType FSalryType,a.FStaffStatus FStaffStatus, " +
                    "a.FFnation,a.FNursinghomeID,a.FIdentityCardID,a.FLunarCalendar,a.FMaritalStatus, a.FLunarBrith,a.FDismissalDate,FBrith, " +
                    "a.FGraduateSchool,a.FEducation,a.FMajor,a.FCertificate,a.FComputerLevel,a.FLanguageLevel,a.FSalryType,a.FBankCardID,a.FHealth, " +
                    "a.FPostcode,a.FPhotoID,a.FHpisejpldRegister,a.FHomeAddress,a.FPoliticalStatus,a.FTel,a.FWechatNumber,a.FRemarks,a.FState,d.FNursingName fNursinghome " +
                    "from  " +
                    "T_STAFF_MESSAGE a,T_DEPARTMENT b,T_BUILDING c,T_SYS_NursingHome d " +
                    "where " +
                    "a.FDepartmentID = b.FID and a.FBuildingID = c.FID and a.FNursinghomeID = d.FID");
            if (null == message) {
                return empSql.toString();
            } else {
                if (StringUtils.isNotEmpty(message.getfStaffName())) {
                    empSql.append(" and FStaffName like '%" + message.getfStaffName() + "%'");
                }
                if (StringUtils.isNotEmpty(message.getfStaffStatus())) {
                    empSql.append(" and FStaffStatus = '" + message.getfStaffStatus() + "'");
                }
                if (StringUtils.isNotEmpty(message.getfDepartmentID())) {
                    empSql.append(" and FDepartmentID = " + Integer.parseInt(message.getfDepartmentID()));
                }
                if(StringUtils.isNotEmpty(message.getfId())){
                	empSql.append(" and a.FID= '"+Integer.parseInt(message.getfId())+"'");
                	return empSql.toString();
                }
            }
            empSql.append(" limit #{page},#{pageSize}");
            logger.debug(empSql.toString());
            return empSql.toString();
        }

        public String queryCount(Map<String, Object> params) {
            MessagePo message = (MessagePo) params.get("param");
            StringBuffer sb = new StringBuffer();
            sb.append("select count(*) from (select " +
                    " a.FID,a.FStaffName,a.FSex,a.FEntryDate,a.FDepartmentID FDepartmentID,b.FDepartmentName,a.FPost,c.FBuildingName,a.FMobileTel,a.FTitle,a.FSalryType,a.FStaffStatus " +
                    "from " +
                    " T_STAFF_MESSAGE a,T_DEPARTMENT b,T_BUILDING c " +
                    "where " +
                    " a.FDepartmentID = b.FID and a.FBuildingID = c.FID) t "+
                    " where 1=1 ");
            if (null == message) {
                return sb.toString();
            } else {
                if (StringUtils.isNotEmpty(message.getfStaffName())) {
                    sb.append(" and FStaffName like '%" + message.getfStaffName() + "%'");
                }
                if (StringUtils.isNotEmpty(message.getfStaffStatus())) {
                    sb.append(" and FStaffStatus = '" + message.getfStaffStatus() + "'");
                }
                if (StringUtils.isNotEmpty(message.getfDepartmentID())) {
                    sb.append(" and FDepartmentID = " + Integer.parseInt(message.getfDepartmentID()));
                }
            }
            logger.debug(sb.toString());
            return sb.toString();
        }
    }
}