package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.InComeMonthPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxin on 2017/3/3.
 */
public interface InMonthMapper {
    public static Logger logger = Logger.getLogger(InMonthMapper.class);

    @SelectProvider(type = ChangeProvider.class, method = "queryCount")
    public int queryCount(@Param("param") InComeMonthPo param);

    @SelectProvider(type = ChangeProvider.class, method = "queryList")
    @Results(value = {
            @Result(column="FID",property="fID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FcontractNo",property="fContant",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FoldManIdCard",property="fIdCard",javaType=String.class,jdbcType=JdbcType.INTEGER),
            @Result(column="FoldManName",property="fOldName",javaType=String.class,jdbcType=JdbcType.INTEGER),
            @Result(column="FBeginAmount",property="fBeginAmount",javaType=String.class,jdbcType=JdbcType.INTEGER),
            @Result(column="FEndAmount",property="fEndAmount",javaType=String.class,jdbcType=JdbcType.INTEGER),
            @Result(column="FArAmount",property="fArAmount",javaType=String.class,jdbcType=JdbcType.INTEGER),
            @Result(column="FApAmount",property="fApAmount",javaType=String.class,jdbcType=JdbcType.INTEGER),
            @Result(column="rPayYearAmount",property="fRpayYear",javaType=String.class,jdbcType=JdbcType.INTEGER),
            @Result(column="payYearAmount",property="fPayYear",javaType=String.class,jdbcType=JdbcType.INTEGER),
            @Result(column="YSFnumber",property="fArFnumber",javaType=String.class,jdbcType=JdbcType.INTEGER),
            @Result(column="SSFnumber",property="fApFnumber",javaType=String.class,jdbcType=JdbcType.INTEGER),
    })
    public List<InComeMonthPo> OldmanList(@Param("param") InComeMonthPo param, @Param(value = "page") int page, @Param(value = "pageSize") int pageSize);

    class ChangeProvider {
        public String queryList(Map<String, Object> params) {
            InComeMonthPo monthPo = (InComeMonthPo) params.get("param");
            StringBuffer empSql = new StringBuffer();
            empSql.append("select b.Fnumber YSFnumber,e.Fnumber SSFnumber,c.FoldManName,c.FID,c.FcontractNo,c.FoldManIdCard,d.FEndAmount,d.FBeginAmount,d.FArAmount,d.FApAmount,b.FPaymentDate, " +
                    "sum(a.FArPaymentAmount) rPayYearAmount,sum(b.FAmount) payYearAmount " +
                    "from t_fygl_rpaymententry a, t_fygl_payment b,t_oldman_main c,t_fygl_oldmanblance d,t_fygl_rpayment e  " +
                    "where c.FID = b.FoldmanID and c.FID = e.FoldmanID and e.FID = a.FParentid and c.FID = e.FoldmanID ");
            if (null == monthPo) {
                return empSql.toString();
            } else {
                if (StringUtils.isNotEmpty(monthPo.getfPaymentDate())) {
                    empSql.append(" and b.FPaymentDate like '" + monthPo.getfPaymentDate() + "%'");
                }
            }
            empSql.append(" GROUP BY b.FPeriod limit #{page},#{pageSize}");
            logger.debug(empSql.toString());
            return empSql.toString();
        }

        public String queryCount(Map<String, Object> params) {
            InComeMonthPo monthPo = (InComeMonthPo) params.get("param");
            StringBuffer sb = new StringBuffer();
            sb.append("select count(*) from( " +
                    "select c.FID,c.FcontractNo,c.FoldManIdCard,d.FEndAmount,d.FBeginAmount,d.FArAmount,d.FApAmount,b.FPaymentDate, " +
                    "sum(a.FArPaymentAmount) rPayYearAmount,sum(b.FAmount) payYearAmount " +
                    "from t_fygl_rpaymententry a, t_fygl_payment b,t_oldman_main c,t_fygl_oldmanblance d,t_fygl_rpayment e " +
                    "where c.FID = b.FoldmanID and c.FID = e.FoldmanID and e.FID = a.FParentid and c.FID = e.FoldmanID " +
                    "GROUP BY b.FPeriod)t where 1=1 ");
            if (null == monthPo) {
                return sb.toString();
            } else {
                if (StringUtils.isNotEmpty(monthPo.getfPaymentDate())) {
                    sb.append(" and FPaymentDate like '" + monthPo.getfPaymentDate() + "%'");
                }
            }
            logger.debug(sb.toString());
            return sb.toString();
        }
    }
}
