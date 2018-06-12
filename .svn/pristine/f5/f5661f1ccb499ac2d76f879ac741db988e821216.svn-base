package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.OldManPaymentPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 * Created by wangjs on 2016/12/27.
 */
public interface OldManPaymentMapper {

    @SelectProvider(type = PaymentMapper.class,method = "queryList")
    public List<OldManPaymentPo> queryList(@Param("param") OldManPaymentPo po);

    @Select("select * from T_FYGL_RPAYMENT order by FID desc Limit 0,1")
    @Results(value={
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "Fnursing_homeID", property = "fnursing_homeID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditorID", property = "fAuditorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FAuditTime", property = "fAuditTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCreateTime", property = "fCreateTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FModifierID", property = "fModifierID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FModificationTime", property = "fModificationTime", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRemarks", property = "fRemarks", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fnumber", property = "fnumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fstatus", property = "fstatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FoldmanID", property = "foldmanID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPaymentDate", property = "fPaymentDate", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPeriod", property = "fPeriod", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMoun", property = "fMoun", javaType = String.class, jdbcType = JdbcType.VARCHAR),})
    public List<OldManPaymentPo> queryLast();

    @Insert("insert into t_fygl_rpayment (Fnursing_homeID,FCreatorID,FCreateTime,Fnumber,Fstatus,FoldmanID,FPaymentDate,FPeriod,FMoun,FBizType) " +
            "values (#{fnursing_homeID},#{fCreatorID},#{fCreateTime},#{fnumber},#{fstatus},#{foldmanID},#{fPaymentDate},#{fPeriod},#{fMoun},#{fBizType})")
    public void addPayment(OldManPaymentPo po);

    @Update("update T_FYGL_RPAYMENT set Fnursing_homeID=#{fnursing_homeID},Fnumber=#{fnumber},Fstatus=#{fstatus}," +
            "where FID=#{fID}")
    public void updOmPayment(OldManPaymentPo po);

    @Delete("delete from T_FYGL_RPAYMENT where FID=#{fID}")
    public void delOmPayment(OldManPaymentPo po);

    class PaymentMapper{

        public String queryList(Map<String,Object> param){
            OldManPaymentPo payMent=(OldManPaymentPo) param.get("param");
            StringBuffer sql=new StringBuffer();
            sql.append("select * from T_FYGL_RPAYMENT where 1=1");
            if(payMent==null){
                return sql.toString();
            }else{
                if(StringUtils.isNotEmpty(payMent.getFoldmanID())){
                    sql.append(" and FoldmanID = '"+payMent.getFoldmanID()+"'");
                }
                if(StringUtils.isNotEmpty(payMent.getfBizType())){
                    sql.append(" and FBizType = '"+payMent.getfBizType()+"'");
                }
            }
            return sql.toString();
        }
    }
}
