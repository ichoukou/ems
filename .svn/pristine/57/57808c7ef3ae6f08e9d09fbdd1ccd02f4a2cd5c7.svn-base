package com.channelsoft.ems.mapper;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxin on 2017/3/1.
 */
public interface BillHistoryMapper {
    public static Logger logger = Logger.getLogger(BillHistoryMapper.class);
    //根据老人ID查询到老人的基本信息
    @Select("SELECT a.*,b.FBuildingName,c.FRoomName FROM T_OLDMAN_MAIN a,T_BUILDING b,T_ROOM c " +
            "WHERE a.FbuildingID=b.FID AND a.FroomID=c.FID  AND a.FID = #{oldManId}")
    public List<Map<String,String>> getOldManMessage(String oldManId);

    @SelectProvider(type = ChangeProvider.class, method = "getList")
    public List<Map<String,String>> getOldManList(@Param("oldManId") String oldManId, @Param("searchEntryDate") String searchEntryDate, @Param("searchEndDate") String searchEndDate);

    class ChangeProvider{
        public String getList(Map<String, Object> params){
            String oldManId = (String) params.get("oldManId");
            String searchEntryDate = (String) params.get("searchEntryDate");
            String searchEndDate = (String)params.get("searchEndDate");
            StringBuffer oldSql = new StringBuffer();
            oldSql.append("SELECT a.FChrgeName,b.FArPaymentAmount,c.FPaymentDate,c.FID " +
                    "FROM T_CHARGE_STANDARD a,t_fygl_paymententry b,t_fygl_payment c " +
                    "WHERE a.FID=b.FCostItem AND b.FParentid = c.FID ");
            if(oldManId==null){
                return oldSql.toString();
            }else{
                if (oldManId!=null){
                    oldSql.append("AND c.FoldmanID = "+oldManId+"");
                }
                if(StringUtils.isNotEmpty(searchEntryDate)&&StringUtils.isNotEmpty(searchEndDate)&&(searchEndDate!=searchEntryDate)){
                    oldSql.append(" and c.FPaymentDate between '" + searchEntryDate+ "' and '" + searchEndDate+ "'");
                }if(StringUtils.isNotEmpty(searchEntryDate)&&!StringUtils.isNotEmpty(searchEndDate)){
                    oldSql.append(" and c.FPaymentDate > '" + searchEntryDate +"'");
                }if(!StringUtils.isNotEmpty(searchEntryDate)&&StringUtils.isNotEmpty(searchEndDate)){
                    oldSql.append(" and c.FPaymentDate < '" + searchEndDate +"'");
                }if(StringUtils.isNotEmpty(searchEntryDate)&&StringUtils.isNotEmpty(searchEndDate)&&(searchEndDate==searchEntryDate)){
                    oldSql.append(" and Date(c.FPaymentDate) = '" + searchEntryDate +"'");
                }
            }
            oldSql.append("order by FPaymentDate");
            logger.debug(oldSql.toString());
            return oldSql.toString();
        }
    }
}
