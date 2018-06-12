package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.CwglPaymentPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by wangjs on 2017/1/12.
 */
public interface CwglPaymentMapper {


    @Select("select * from T_CWGL_Payments where Ftype=#{flag} and Fparentid='0'")
    @Results(value = {
            @Result(column = "Fid", property = "fid", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FnursinghomeID", property = "fnursinghomeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditorID", property = "fAuditorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditTime", property = "fAuditTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FModifierID", property = "fModifierID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FModificationTime", property = "fModificationTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRemarks", property = "fRemarks", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fnumber", property = "fnumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ffstatus", property = "ffstatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fname", property = "fname", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fparentid", property = "fparentid", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ftype", property = "ftype", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    public List<CwglPaymentPo> queryPayList(@Param("param") CwglPaymentPo param, @Param("flag")String flag);

    @Select("select * from T_CWGL_Payments where Ftype=#{id}")
    @Results(value = {
            @Result(column = "Fid", property = "fid", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FnursinghomeID", property = "fnursinghomeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditorID", property = "fAuditorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditTime", property = "fAuditTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FModifierID", property = "fModifierID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FModificationTime", property = "fModificationTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRemarks", property = "fRemarks", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fnumber", property = "fnumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ffstatus", property = "ffstatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fname", property = "fname", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fparentid", property = "fparentid", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ftype", property = "ftype", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    public List<CwglPaymentPo> getPayList(@Param("id") String id);

    @Select("SELECT b.Fname ParentName,a.Fid,a.FnursinghomeID,a.FAuditorID,a.FAuditTime,a.FCreatorID,a.FCreateTime," +
            "a.FModifierID,a.FModificationTime,a.FRemarks,a.Fnumber,a.Fstatus,a.Fname,a.Fparentid,a.Ftype " +
            "FROM T_CWGL_Payments a LEFT JOIN T_CWGL_Payments b " +
            "ON a.Fparentid=b.Fid where a.Ftype=#{flag} and a.Fparentid=#{id}")
    @Results(value = {
            @Result(column = "Fid", property = "fid", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FnursinghomeID", property = "fnursinghomeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditorID", property = "fAuditorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditTime", property = "fAuditTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FModifierID", property = "fModifierID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FModificationTime", property = "fModificationTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRemarks", property = "fRemarks", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fnumber", property = "fnumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ffstatus", property = "ffstatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fname", property = "fname", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "ParentName", property = "parentName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fparentid", property = "fparentid", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Ftype", property = "ftype", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    public List<CwglPaymentPo> queryPaySonList(@Param("id") String parentId,@Param("flag")String flag);

    @Insert("insert into T_CWGL_Payments (Fid,FnursinghomeID,Fname,Fparentid,Ftype) values (#{fid},#{fnursinghomeID},#{fname},#{fparentid},#{ftype})")
    public void addPayment(CwglPaymentPo param);


    @Update("update T_CWGL_Payments set FnursinghomeID=#{fnursinghomeID},Fname=#{fname},Fparentid=#{fparentid},Ftype=#{ftype} where Fid=#{fid}")
    public void updateCwglPayment(CwglPaymentPo po);

    @Select("select count(*) from T_CWGL_Payments where Fparentid = #{id}")
    public int searchCwglPayment(@Param("id") String id);

    @Delete("delete from T_CWGL_Payments where Fid = #{id}")
    public void deleteCwglPayment(String id);
}
