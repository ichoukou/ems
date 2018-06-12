package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.ProviderPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxin on 2016/12/27.
 */
public interface ProviderManagerMapper {
    public static Logger logger = Logger.getLogger(ProviderManagerMapper.class);

    @Insert("INSERT INTO T_SUPPLIER_INFO " +
            "(FSupplierNumber,FSupplierName,FContactsName,FMailingAddress,FMobileTel,FBank,FAccountNumber,FDutyParagraph,FTel,FQqID,FWechatNumber,STATUS) " +
            "VALUES " +
            "(#{fSupplierNumber},#{fSupplierName},#{fContactsName},#{fMailingAddress},#{fMobileTel},#{fBank},#{fAccountNumber},#{fDutyParagraph},#{fTel},#{fQqID},#{fWechatNumber},1)")
    public void addProviderManager(ProviderPo providerPo);
    //禁用
    @Update("UPDATE T_SUPPLIER_INFO SET STATUS=0 WHERE FID=#{fID}")
    public void deleteProviderManager(String fID);

    //启用
    @Update("UPDATE T_SUPPLIER_INFO SET STATUS=1 WHERE FID=#{fID} ")
    public void startState(ProviderPo po);

    @Update("UPDATE T_SUPPLIER_INFO " +
            "SET " +
            "FSupplierName=#{fSupplierName},FContactsName=#{fContactsName},FMailingAddress=#{fMailingAddress},FMobileTel=#{fMobileTel},FBank=#{fBank},FAccountNumber=#{fAccountNumber},FDutyParagraph=#{fDutyParagraph},FTel=#{fTel},FQqID=#{fQqID},FWechatNumber=#{fWechatNumber} " +
            "where " +
            "FID=#{fID} ")
    public void updateProviderManager(ProviderPo providerPo);

    @SelectProvider(type = ChangeProvider.class, method = "queryCount")
    public int queryCount(@Param("param") ProviderPo param);

    @SelectProvider(type = ChangeProvider.class, method = "queryList")
    public List<ProviderPo> queryList(@Param("param") ProviderPo param, @Param(value = "page") int page,@Param(value = "pageSize") int pageSize);

    class ChangeProvider {
        public String queryList(Map<String, Object> params) {
            ProviderPo providerPo = (ProviderPo) params.get("param");
            StringBuffer empSql = new StringBuffer();
            empSql.append("select * "+
                    "from " +
                    "T_SUPPLIER_INFO where 1=1 ");
            if (null == providerPo) {
                return empSql.toString();
            } else {
                if (StringUtils.isNotEmpty(providerPo.getfSupplierName())) {
                    empSql.append(" and FSupplierName like '%" + providerPo.getfSupplierName() + "%'");
                }
                if(StringUtils.isNotEmpty(providerPo.getfContactsName())){
                    empSql.append(" and FContactsName like '%" + providerPo.getfContactsName() + "%'");
                }
                if(StringUtils.isNotEmpty(providerPo.getfMobileTel())){
                    empSql.append(" and FMobileTel like '%" + providerPo.getfMobileTel() + "%'");
                }
            }
            empSql.append(" limit #{page},#{pageSize}");
            logger.debug(empSql.toString());
            return empSql.toString();
        }

    public String queryCount(Map<String, Object> params) {
        ProviderPo providerPo = (ProviderPo) params.get("param");
        StringBuffer sb = new StringBuffer();
        sb.append("select count(*) from (select " +
                "FID,FSupplierName,FContactsName,FMailingAddress,FMobileTel " +
                "from " +
                "T_SUPPLIER_INFO ) t where 1=1");
        if (null == providerPo) {
            return sb.toString();
        } else {
            if (StringUtils.isNotEmpty(providerPo.getfSupplierName())) {
                sb.append(" and FSupplierName like '%" + providerPo.getfSupplierName() + "%'");
            }
            if(StringUtils.isNotEmpty(providerPo.getfContactsName())){
                sb.append(" and  FContactsName like '%" + providerPo.getfContactsName() + "%'");
            }
            if(StringUtils.isNotEmpty(providerPo.getfMobileTel())){
                sb.append(" and FMobileTel like '%" + providerPo.getfMobileTel() + "%'");
            }
        }
        logger.debug(sb.toString());
        return sb.toString();
    }
}
}
