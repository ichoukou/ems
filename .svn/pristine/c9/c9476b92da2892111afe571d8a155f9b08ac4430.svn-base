package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.MaterialManagePo;
import com.channelsoft.ems.po.WarehouseEntryPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxin on 2017/1/5.
 */
public interface WareHouseMapper {

    public static Logger logger = Logger.getLogger(WareHouseMapper.class);

    //主表的查询
    @SelectProvider(type = ChangeProvider.class, method = "queryMainCount")
    public int queryMainCount(@Param("param") WarehouseEntryPo param);

    @SelectProvider(type = ChangeProvider.class, method = "queryMainList")
    @Results(value = {
            @Result(column = "FPurchaseDate", property = "fPurchaseDate", javaType = String.class, jdbcType = JdbcType.DATE),
            @Result(column = "FCreatorID", property = "fCreatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStoreHouseName", property = "fStorageName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FID", property = "fatherid", javaType = String.class, jdbcType = JdbcType.INTEGER),
    })
    public List<WarehouseEntryPo> queryMainList(@Param("param") WarehouseEntryPo param, @Param(value = "page") int page, @Param(value = "pageSize") int pageSize);


    //插入主表
    @Insert("insert into `T_PURCHASE` " +
            "(`FNumber`,`FNursingHomeID`,`FPurchaseDate`,`FTel`,`FSupplyMome`,`FPaymentMode`,FRemarks,FReceivingPlace,FCreatorID,`FCreateTime`) " +
            "values  " +
            "( #{fNumber},#{fNursingHomeID},#{fPurchaseDate},#{fTel},#{fSupplyMome},#{fPaymentMode},#{fRemarks},#{fReceivingPlace},#{fCreatorID},NOW()) ")
    public void insertInStorgage(WarehouseEntryPo po);
    //获取主表最新插入数据
    @Select("select max(FID) from T_PURCHASE ")
    public int  getInStorageInsertID();
    //插入字表
    @InsertProvider(type = ChangeProvider.class,method = "insertInStorageEntry")
    public void insertInStorageEntry(@Param("list") List<WarehouseEntryPo> list);

    //查出是否重复
    @Select( " select count(*) 'NUM',FID ,FStockAmount  from STOCK_ACCOUNT where FStorageID=#{fStorageID} and FMaterialID=#{fMaterialID} ")
    public List<Map<String,String>> getDistictStick(WarehouseEntryPo po);
    //更新库存表
    @Update(" update `STOCK_ACCOUNT` set `FStockAmount`=#{fAmount} where `FID`=#{fid} ; ")
    public  void  updateStockAccout(WarehouseEntryPo po);
    //插入库存表
    @Insert(" insert into `STOCK_ACCOUNT`(`FNnumber`,`FNursingHomeID`,`FStorageID`,`FMaterialID`,`FStockAmount`,`FStandard`) values ( #{fNumber},#{fNursingHomeID},#{fStorageID},#{fMaterialID},#{fAmount},#{fStandard}); ")
    public void insertStockAccout(WarehouseEntryPo po);

    //得到库存中的数据
    @Select("SELECT T5.FID Fatherid,T5.FNumber FNumber,T5.FPurchaseDate FPurchaseDate,T5.FCreatorID FCreatorID,T5.FTel,T5.FSupplyMome,T5.FPaymentMode,T5.FReceivingPlace," +
            "T1.FID AID,T1.PID,T1.FPurchaseManID,T1.FStoremanID,T1.FSupplierID,T1.FMaterialID,T1.FStorageID,T1.FAmount,T1.FPrice,T1.FSum,T1.FRemarks," +
            "T2.FStoreHouseName FStoreHouseName,T3.FMaterialName FMaterialName, T3.FStandard FStandard,T4.FStaffName FStoremanName  " +
            "FROM T_PURCHASE_ENTRY T1,T_STOREHOUSE T2 ,T_MATERIAL T3 ,T_STAFF_MESSAGE T4 ,T_PURCHASE T5 " +
            "WHERE T1.FStorageID =T2.FID AND T3.FID=T1.FMaterialID AND T4.FID=T1.FStoremanID AND T5.FID=T1.PID AND T5.FID=#{fatherid}" )
    public List<Map<String,String>> getUpdateAllMaterial(WarehouseEntryPo po);

    //删除
    @Delete("DELETE  from T_PURCHASE_ENTRY where FID=#{fid} ")
    public void deleteStorage_entry( WarehouseEntryPo po);
    //删除子表
    @Delete("DELETE  from T_PURCHASE_ENTRY where PID = #{fid}")
    public void deleteStorage_entryByFather( WarehouseEntryPo po);
    //删除主表
    @Delete("DELETE  from T_PURCHASE where FID=#{fid} ")
    public void deleteStorage( WarehouseEntryPo po);

    @Update("UPDATE `T_PURCHASE` SET `FNursingHomeID`=#{fNursingHomeID} ,`FPurchaseDate`=#{fPurchaseDate},`FTel`=#{fTel},FSupplyMome=#{fSupplyMome},FPaymentMode=#{fPaymentMode},FReceivingPlace=#{fReceivingPlace},FCreatorID=#{fCreatorID},FCreateTime=now()  where `FID`=#{fid} ")
    public  void  updateStock(WarehouseEntryPo po);

    @SelectProvider(type = ChangeProvider.class, method = "queryCount")
    public int queryCount(@Param("param") MaterialManagePo param);

    @SelectProvider(type = ChangeProvider.class, method = "queryList")
    @Results(value = {
            @Result(column = "FMaterialName", property = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStandard", property = "standard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FUnit", property = "unit", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLowStock", property = "lowStock", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FPrice", property = "purchasePrice", javaType = String.class, jdbcType = JdbcType.DECIMAL),
    })
    public List<MaterialManagePo> queryList(@Param("param") MaterialManagePo param, @Param(value = "page") int page, @Param(value = "pageSize") int pageSize);

    class ChangeProvider {

        public String queryMainList(Map<String, Object> params) {
            WarehouseEntryPo housePo = (WarehouseEntryPo) params.get("param");
            StringBuffer mateSql = new StringBuffer();
            mateSql.append("SELECT T6.*,T7.FStaffName 'FPurchaseManName' FROM" +
                    "(SELECT T5.FID 'Fatherid',T5.FNumber 'FNumber',T5.FPurchaseDate 'FPurchaseDate',T5.FCreatorID 'FCreatorID',T1.*," +
                    "T2.FStoreHouseName 'FStoreHouseName' ,T3.FMaterialName , T3.FStandard 'FStandard',T4.FStaffName 'fStoremanName'" +
                    "FROM T_PURCHASE_ENTRY T1,T_STOREHOUSE T2 ,T_MATERIAL T3 ,T_STAFF_MESSAGE T4 , T_PURCHASE T5 WHERE T1.FStorageID =T2.FID " +
                    "AND T3.FID=T1.FMaterialID AND T4.FID=T1.FStoremanID AND T5.FID=T1.PID)T6,T_STAFF_MESSAGE T7 WHERE T7.FID=T6.FCreatorID ");
            if (null == housePo) {
                return mateSql.toString();
            } else {
                if (StringUtils.isNotEmpty(housePo.getfPurchaseManName())) {
                    mateSql.append(" and T7.FStaffName = '" +housePo.getfPurchaseManName() + "'");
                }
                if(StringUtils.isNotEmpty(housePo.getStart())&&StringUtils.isNotEmpty(housePo.getFinish())&&(StringUtils.isNotEmpty(housePo.getStart())!=StringUtils.isNotEmpty(housePo.getFinish()))){
                    mateSql.append(" and FPurchaseDate between '" + housePo.getStart()+ "' and '" + housePo.getFinish()+ "'");
                }if(StringUtils.isNotEmpty(housePo.getStart())&&!StringUtils.isNotEmpty(housePo.getFinish())){
                    mateSql.append(" and FPurchaseDate > '" + housePo.getStart() +"'");
                }if(!StringUtils.isNotEmpty(housePo.getStart())&&StringUtils.isNotEmpty(housePo.getFinish())){
                    mateSql.append(" and FPurchaseDate < '" + housePo.getFinish() +"'");
                }if(StringUtils.isNotEmpty(housePo.getStart())&&StringUtils.isNotEmpty(housePo.getFinish())&&(StringUtils.isNotEmpty(housePo.getStart())==StringUtils.isNotEmpty(housePo.getFinish()))){
                    mateSql.append(" and Date(FPurchaseDate) = '" + housePo.getStart() +"'");
                }
            }
            mateSql.append(" order by Fatherid desc limit #{page},#{pageSize}");
            logger.debug(mateSql.toString());
            return mateSql.toString();
        }

        public String queryMainCount(Map<String, Object> params) {
            WarehouseEntryPo housePo = (WarehouseEntryPo) params.get("param");
            StringBuffer sb = new StringBuffer();
            sb.append("select count(*) from " +
                    "(SELECT T6.*,T7.FStaffName 'FPurchaseManName' FROM" +
                    "(SELECT T5.FID 'Fatherid',T5.FNumber 'FNumber',T5.FPurchaseDate 'FPurchaseDate',T5.FCreatorID 'FCreatorID',T1.*," +
                    "T2.FStoreHouseName 'FStoreHouseName' ,T3.FMaterialName , T3.FStandard 'FStandard',T4.FStaffName 'FStoreName'" +
                    "FROM T_PURCHASE_ENTRY T1,T_STOREHOUSE T2 ,T_MATERIAL T3 ,T_STAFF_MESSAGE T4 , T_PURCHASE T5 WHERE T1.FStorageID =T2.FID " +
                    "AND T3.FID=T1.FMaterialID AND T4.FID=T1.FStoremanID AND T5.FID=T1.PID)T6,T_STAFF_MESSAGE T7 WHERE T7.FID=T6.FCreatorID ) t where 1=1");
            if (null == housePo) {
                return sb.toString();
            } else {
                if (StringUtils.isNotEmpty(housePo.getfPurchaseManName())) {
                    sb.append(" and t.FPurchaseManName = '" + housePo.getfPurchaseManName()+ "'");
                }
                if(StringUtils.isNotEmpty(housePo.getStart())&&StringUtils.isNotEmpty(housePo.getFinish())&&(StringUtils.isNotEmpty(housePo.getStart())!=StringUtils.isNotEmpty(housePo.getFinish()))){
                    sb.append(" and t.FPurchaseDate between '" + housePo.getStart()+ "' and '" + housePo.getFinish()+ "'");
                }if(StringUtils.isNotEmpty(housePo.getStart())&&!StringUtils.isNotEmpty(housePo.getFinish())){
                    sb.append(" and t.FPurchaseDate > '" + housePo.getStart() +"'");
                }if(!StringUtils.isNotEmpty(housePo.getStart())&&StringUtils.isNotEmpty(housePo.getFinish())){
                    sb.append(" and t.FPurchaseDate < '" + housePo.getFinish() +"'");
                }if(StringUtils.isNotEmpty(housePo.getStart())&&StringUtils.isNotEmpty(housePo.getFinish())&&(StringUtils.isNotEmpty(housePo.getStart())==StringUtils.isNotEmpty(housePo.getFinish()))){
                    sb.append(" and Date(t.FPurchaseDate) = '" + housePo.getStart() +"'");
                }
            }
            logger.debug(sb.toString());
            return sb.toString();
        }

        public String queryList(Map<String, Object> params) {
            MaterialManagePo managePo = (MaterialManagePo) params.get("param");
            StringBuffer mateSql = new StringBuffer();
            mateSql.append("select " +
                    "FID,FStandard,FCategoryID,FUnit,FLowStock,FMaterialName,FPrice " +
                    "from " +
                    "T_MATERIAL " +
                    "where " +
                    "FStatus=1");
            if (null == managePo) {
                return mateSql.toString();
            } else {
                if (StringUtils.isNotEmpty(managePo.getName())) {
                    mateSql.append(" and FMaterialName = '" + managePo.getName() + "'");
                }
                if(StringUtils.isNotEmpty(managePo.getfCategoryID())){
                    mateSql.append(" and FCategoryID in "+ managePo.getfCategoryID() );
                }
                }
            mateSql.append(" limit #{page},#{pageSize}");
            logger.debug(mateSql.toString());
            return mateSql.toString();
        }

        public String queryCount(Map<String, Object> params) {
            MaterialManagePo managePo = (MaterialManagePo) params.get("param");
            StringBuffer sb = new StringBuffer();
            sb.append("select count(*) " +
                    "from(select " +
                    "FStandard,FCategoryID,FUnit,FLowStock,FMaterialName,FPrice " +
                    "from " +
                    "T_MATERIAL mate where FStatus=1) t where 1=1");
            if (null == managePo) {
                return sb.toString();
            } else {
                if (StringUtils.isNotEmpty(managePo.getName())) {
                    sb.append(" and FMaterialName = '" + managePo.getName() + "'");
                }
                if(StringUtils.isNotEmpty(managePo.getfCategoryID())){
                    sb.append(" and FCategoryID in "+ managePo.getfCategoryID());
                }
            }
            logger.debug(sb.toString());
            return sb.toString();
        }

        public String insertInStorageEntry(Map<String, Object> params){
            List<WarehouseEntryPo> list = (List<WarehouseEntryPo>) params.get("list");
            logger.debug(list.toString());
            StringBuffer sql=new StringBuffer();
            sql.append("insert into `T_PURCHASE_ENTRY` " +
                    "(PID,FPurchaseManID,FStoremanID,FSupplierID,FMaterialID,FStorageID,FAmount,FPrice,FSum,FRemarks) values ");
            for (WarehouseEntryPo po:list) {

                sql.append("('"+po.getpID()+"','"+po.getfPurchaseManID()+"','"+po.getfStoremanID()+"','"+po.getfSupplierID()+"','"+po.getfMaterialID()+"','"+po.getfStorageID()+"','"+po.getfAmount()+"','"+po.getfPrice()+"','"+po.getfSum()+"','"+po.getfRemarks()+"'),");

            }
            String sqll=sql.substring(0,(sql.length()-1));
            logger.debug(sqll);
            return sqll;
        }
    }
}
