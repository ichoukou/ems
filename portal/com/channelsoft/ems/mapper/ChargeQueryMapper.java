package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.ChargeQueryPo;
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
 * Created by zhangxin on 2017/3/7.
 */
public interface ChargeQueryMapper {
    public static Logger logger = Logger.getLogger(ChargeQueryMapper.class);

    @SelectProvider(type = ChangeProvider.class, method = "queryCount")
    public int queryCount(@Param("param") ChargeQueryPo param);


    @SelectProvider(type = ChangeProvider.class, method = "queryList")
    @Results(value = {
            @Result(column="FID",property="fID",javaType=String.class,jdbcType= JdbcType.INTEGER),
            @Result(column="FChrgeName",property="fCostItemName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FChrgeType",property="fCostItemType",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FoldManName",property="fOldManName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FBedName",property="fBedName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FArPaymentAmount",property="fAmount",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FPaymentDate",property="fPaymentDate",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FExplation",property="fExplation",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="fCostItemTypeName",property="fCostItemTypeName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="fParentID",property="fParentID",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="fNumber",property="fNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
    })
    public List<ChargeQueryPo> queryList(@Param("param") ChargeQueryPo param, @Param(value = "page") int page, @Param(value = "pageSize") int pageSize);

    class ChangeProvider {
        public String queryList(Map<String, Object> params) {
            ChargeQueryPo po = (ChargeQueryPo) params.get("param");
            StringBuffer chargeSql = new StringBuffer();
            /*chargeSql.append("select b.FID,d.FID FCostItemID,d.FChrgeName,d.FChrgeType,c.FoldManName,concat(cast(e.FBuildingName as char),cast(f.FRoomName as char),g.FBedNumber) FBedName," +
                    "b.FArPaymentAmount,a.FPaymentDate,concat(cast(a.FPeriod as char),'年',cast(a.FMoun as char),'月的',d.FChrgeName) FExplation, d.FChrgeName as fCostItemTypeName " +
                    "from t_fygl_payment a,t_fygl_paymententry b,t_oldman_main c,t_charge_standard d,t_building e,t_room f,t_bed g " +
                    "where a.FoldmanID = c.FID and a.FID = b.FParentid and b.FitemID = d.FID and c.FbuildingID=e.FID and c.FroomID = f.FID and c.FbedID = g.FID ");
            */
            chargeSql.append("SELECT b.FParentid, b.FID, d.FID FCostItemID, d.FChrgeName, d.FChrgeType, c.FoldManName, CONCAT(CAST(e.FBuildingName AS CHAR),CAST(f.FRoomName AS CHAR),g.FBedNumber ) fBedName,"+
				      "IFNULL(h.FArPaymentAmount,b.FArPaymentAmount) AS FArPaymentAmount,a.FPaymentDate,CONCAT(CAST(a.FPeriod AS CHAR),'年',CAST(a.FMoun AS CHAR),'月的',d.FChrgeName) FExplation,"+
				      "i.DC_VALUE AS fCostItemTypeName,a.Fnumber "+
					  " FROM t_fygl_payment a INNER JOIN t_fygl_paymententry b ON a.FID = b.FParentid  LEFT OUTER JOIN t_oldman_main c ON a.FoldmanID = c.FID LEFT OUTER JOIN  t_charge_standard d ON b.FitemID = d.FID "+
					  " LEFT OUTER JOIN t_building e ON c.FbuildingID = e.FID LEFT OUTER JOIN t_room f ON c.FroomID = f.FID LEFT OUTER JOIN t_bed g ON  c.FbedID = g.FID "+
					  " LEFT OUTER JOIN t_fygl_rpaymententry h ON b.FsourceBillentryID=h.FID LEFT OUTER JOIN data_dictionary i ON d.FChrgeType=i.DC_ID where 1=1 ");
            if (null == po) {
                return chargeSql.toString();
            } else {
                if (StringUtils.isNotEmpty(po.getfCostItemID())) {
                    chargeSql.append(" and d.FID = '" + po.getfCostItemID() + "'");
                }
                if (StringUtils.isNotEmpty(po.getfOldManName())) {
                    chargeSql.append(" and FoldManName like '%" + po.getfOldManName() + "%'");
                }
                if (StringUtils.isNotEmpty(po.getfCostItemType())) {
                    chargeSql.append(" and FChrgeType = '" + po.getfCostItemType() + "'");
                }
                if (StringUtils.isNotEmpty(po.getfPaymentDate())) {
                    chargeSql.append(" and FPaymentDate like '" + po.getfPaymentDate()+"%'");
                }if(StringUtils.isNotEmpty(po.getfStarDate())&&StringUtils.isNotEmpty(po.getfEndDate())&&(StringUtils.isNotEmpty(po.getfStarDate())!=StringUtils.isNotEmpty(po.getfEndDate()))){
                    chargeSql.append(" and FPurchaseDate between '" + po.getfStarDate()+ "' and '" + po.getfEndDate()+ "'");
                }if(StringUtils.isNotEmpty(po.getfStarDate())&&!StringUtils.isNotEmpty(po.getfEndDate())){
                    chargeSql.append(" and FPurchaseDate > '" + po.getfStarDate() +"'");
                }if(!StringUtils.isNotEmpty(po.getfStarDate())&&StringUtils.isNotEmpty(po.getfEndDate())){
                    chargeSql.append(" and FPurchaseDate < '" + po.getfEndDate() +"'");
                }if(StringUtils.isNotEmpty(po.getfStarDate())&&StringUtils.isNotEmpty(po.getfEndDate())&&(StringUtils.isNotEmpty(po.getfStarDate())==StringUtils.isNotEmpty(po.getfEndDate()))){
                    chargeSql.append(" and Date(FPurchaseDate) = '" + po.getfStarDate() +"'");
                }
            }
            chargeSql.append(" order by Fnumber desc ");
            chargeSql.append(" limit #{page},#{pageSize}");
            logger.debug(chargeSql.toString());
            return chargeSql.toString();
        }

        public String queryCount(Map<String, Object> params) {
            ChargeQueryPo po = (ChargeQueryPo) params.get("param");
            StringBuffer chargeSql = new StringBuffer();
            /*chargeSql.append("select count(*) from ( " +
                    "select b.FID,d.FID FCostItemID,d.FChrgeName,d.FChrgeType,c.FoldManName,concat(cast(e.FBuildingName as char),cast(f.FRoomName as char),g.FBedNumber) fBedName," +
                    "b.FArPaymentAmount,a.FPaymentDate,concat(cast(a.FPeriod as char),'年',cast(a.FMoun as char),'月的',d.FChrgeName) " +
                    "from t_fygl_payment a,t_fygl_paymententry b,t_oldman_main c,t_charge_standard d,t_building e,t_room f,t_bed g " +
                    "where a.FoldmanID = c.FID and a.FID = b.FParentid and b.FitemID = d.FID and c.FbuildingID=e.FID  " +
                    "and c.FroomID = f.FID and c.FbedID = g.FID) t where 1=1 ");*/
            
            chargeSql.append("select count(*) from ( " +
            		  "SELECT b.FParentid, b.FID, d.FID FCostItemID, d.FChrgeName, d.FChrgeType, c.FoldManName, CONCAT(CAST(e.FBuildingName AS CHAR),CAST(f.FRoomName AS CHAR),g.FBedNumber ) fBedName,"+
				      "IFNULL(h.FArPaymentAmount,b.FArPaymentAmount) AS FArPaymentAmount,a.FPaymentDate,CONCAT(CAST(a.FPeriod AS CHAR),'年',CAST(a.FMoun AS CHAR),'月的',d.FChrgeName) FExplation,"+
				      "i.DC_VALUE AS fCostItemTypeName,a.Fnumber "+
					  " FROM t_fygl_payment a INNER JOIN t_fygl_paymententry b ON a.FID = b.FParentid  LEFT OUTER JOIN t_oldman_main c ON a.FoldmanID = c.FID LEFT OUTER JOIN  t_charge_standard d ON b.FitemID = d.FID "+
					  " LEFT OUTER JOIN t_building e ON c.FbuildingID = e.FID LEFT OUTER JOIN t_room f ON c.FroomID = f.FID LEFT OUTER JOIN t_bed g ON  c.FbedID = g.FID "+
					  " LEFT OUTER JOIN t_fygl_rpaymententry h ON b.FsourceBillentryID=h.FID LEFT OUTER JOIN data_dictionary i ON d.FChrgeType=i.DC_ID) t where 1=1 ");
            if (null == po) {
                return chargeSql.toString();
            } else {
                if (StringUtils.isNotEmpty(po.getfCostItemID())) {
                    chargeSql.append(" and FCostItemID = '" + po.getfCostItemID() + "'");
                }
                if (StringUtils.isNotEmpty(po.getfOldManName())) {
                    chargeSql.append(" and FoldManName like '%" + po.getfOldManName() + "%'");
                }
                if (StringUtils.isNotEmpty(po.getfCostItemType())) {
                    chargeSql.append(" and FChrgeType = '" + po.getfCostItemType() + "'");
                }
                if (StringUtils.isNotEmpty(po.getfPaymentDate())) {
                    chargeSql.append(" and FPaymentDate like '" + po.getfPaymentDate()+"%'");
                }if(StringUtils.isNotEmpty(po.getfStarDate())&&StringUtils.isNotEmpty(po.getfEndDate())&&(StringUtils.isNotEmpty(po.getfStarDate())!=StringUtils.isNotEmpty(po.getfEndDate()))){
                    chargeSql.append(" and FPurchaseDate between '" + po.getfStarDate()+ "' and '" + po.getfEndDate()+ "'");
                }if(StringUtils.isNotEmpty(po.getfStarDate())&&!StringUtils.isNotEmpty(po.getfEndDate())){
                    chargeSql.append(" and FPurchaseDate > '" + po.getfStarDate() +"'");
                }if(!StringUtils.isNotEmpty(po.getfStarDate())&&StringUtils.isNotEmpty(po.getfEndDate())){
                    chargeSql.append(" and FPurchaseDate < '" + po.getfEndDate() +"'");
                }if(StringUtils.isNotEmpty(po.getfStarDate())&&StringUtils.isNotEmpty(po.getfEndDate())&&(StringUtils.isNotEmpty(po.getfStarDate())==StringUtils.isNotEmpty(po.getfEndDate()))){
                    chargeSql.append(" and Date(FPurchaseDate) = '" + po.getfStarDate() +"'");
                }
            }
            logger.debug(chargeSql.toString());
            return chargeSql.toString();
        }
    }
}
