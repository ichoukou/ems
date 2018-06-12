package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.StockMaterialPo;
import com.channelsoft.ems.po.StorageOutDetailedEntryPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 * Created by liuxing on 2016/12/27.
 */
public interface StorageOutDetailedMapper {
//    @Select("select staff.FStaffName,sout.FCreateTime,sout.FExplain,sout.FID,sout.FNnumber,sout.FOperatorID,sout.FOutStorageDate  from T_OUT_STORAGE sout,T_STAFF_MESSAGE staff where sout.FOperatorID=staff.FID ")

    @Select("select toutentry.FParentID as FPID, toutentry.FID as FID,house.FStoreHouseName,house.FID as HouseID,staff.FStaffName,staff.FID as StaffID,material.FMaterialName,material.FID as MaterialID,material.FStandard,toutentry.FQty,material.FRemarks,material.FLowStock " +
            "from T_OUT_STORAGE tout,T_OUT_STORAGE_ENTRY toutentry,T_STOREHOUSE house,T_STAFF_MESSAGE staff,T_MATERIAL material " +
            "where toutentry.FParentID=tout.FID and material.FID=toutentry.FMaterialID and toutentry.FStoremanID=staff.FID and toutentry.FStorageID=house.FID and tout.FNnumber=#{Fnumber}")
    @Results(value = {
            @Result(column = "FPID", property = "fpid", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FID", property = "fid", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStoreHouseName", property = "storageName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "HouseID", property = "storageID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FStaffName", property = "storageManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "StaffID", property = "storageManID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FMaterialName", property = "materialName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "MaterialID", property = "materialID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FStandard", property = "standard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FQty", property = "qty", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FRemarks", property = "remark", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLowStock", property = "amount", javaType = String.class, jdbcType = JdbcType.INTEGER),
    })
    public List<StorageOutDetailedEntryPo> loadMaterialNameList(@Param("Fnumber")String number);
    @Select("select FID,FMaterialName from T_MATERIAL")
    @Results(value = {
            @Result(column = "FID", property = "materialID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FMaterialName", property = "materialName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    public List<StorageOutDetailedEntryPo> getStorageOutDetailedMaterialList();


    @Insert("insert into T_OUT_STORAGE(FNnumber,FNursingHomeID,FOutStorageDate,FOperatorID,FExplain,FCreatorID,FCreateTime) " +
            "values (#{fnumber},#{nursingHomeID},#{outDate},#{operatorID},#{explain},#{creatorID},#{creatDate})")
    public void insertOutStorage(StorageOutDetailedEntryPo po);
    @Update("update T_OUT_STORAGE set FNursingHomeID=#{nursingHomeID},FOutStorageDate=#{outDate},FOperatorID=#{operatorID},FExplain=#{explain},FModifierID=#{modifierID},FModificationTime=#{modificationTime} " +
            "where FNnumber=#{fnumber}")
    public void updateOutStorage(StorageOutDetailedEntryPo po);
    @Select("select max(FID) from T_OUT_STORAGE")
    public int  getOutStorageInsertID();
    @Delete("delete from T_OUT_STORAGE_ENTRY where FID in ${deleteFid}")
    public void deleteOutStorageEntry(@Param("deleteFid") String deleteFid);

    @Delete("delete from T_OUT_STORAGE where FNnumber=#{fnumber}")
    public void deleteOutStorage(@Param("fnumber") String fnumber);

    @InsertProvider(type = StorageOutDetailed.class,method = "insertOutStorageEntry")
    public void insertOutStorageEntry(@Param("list") List<StorageOutDetailedEntryPo> list);

    @Update("update STOCK_ACCOUNT set FStockAmount=#{stockCount} where FID=#{id}")
    public void updateStockAccount( StockMaterialPo po);
    @Update("update STOCK_ACCOUNT set FStockAmount=FStockAmount+#{qty} where FStorageID=#{storageID} and FMaterialID=#{materialID}")
    public void deleteupdateStockAccount(StorageOutDetailedEntryPo po);

    @UpdateProvider(type=StorageOutDetailed.class,method ="updateStockAccountList")
    public void updateStockAccountList(@Param("param") List<StockMaterialPo> po);

    @Select("select distinct FStandard from T_MATERIAL")
    public List<String> getStorageOutStandardList();

    @Select("select FID,FStaffName from T_STAFF_MESSAGE where FStaffStatus='在职' and FState='1'")
    @Results(value = {
            @Result(column = "FID", property = "operatorID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FStaffName", property = "operator", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    public List<StorageOutDetailedEntryPo> getOutOperatorList();

    @Select("select FID,FStoreHouseName from T_STOREHOUSE ")
    @Results(value = {
            @Result(column = "FID", property = "storageID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FStoreHouseName", property = "storageName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    public List<StorageOutDetailedEntryPo> getStorageOutStoreHouseList();

    @SelectProvider(type = StorageOutDetailed.class,method = "queryStorageOutDetailedList")
    @Results(value = {
            @Result(column = "FID", property = "fid", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FOutStorageDate", property = "outDate", javaType = String.class, jdbcType = JdbcType.DATE),
            @Result(column = "FStoreHouseName", property = "storageName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "storeman", property = "storageManName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "operator", property = "operator", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "remark", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMaterialName", property = "materialName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStandard", property = "standard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FQty", property = "qty", javaType = String.class, jdbcType = JdbcType.DECIMAL),
            @Result(column = "FNnumber", property = "fnumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "operatorID", property = "operatorID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    public List<StorageOutDetailedEntryPo> getStorageOutDetailedList(@Param("param") StorageOutDetailedEntryPo po,@Param("page") int page,@Param("pageSize") int pageSize);

    @SelectProvider(type = StorageOutDetailed.class,method = "queryStorageOutDetailedCount")
    public int  getStorageOutDetailedCount(@Param("param") StorageOutDetailedEntryPo po);


    @SelectProvider(type = StorageOutDetailed.class,method = "queryStockMaterial")
    @Results(value = {
            @Result(column = "FID", property = "id", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FStoreHouseName", property = "storeHouse", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStorageID", property = "storeHouseID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FStaffName", property = "storeMan", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "StaffID", property = "storeManID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FMaterialName", property = "material", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMaterialID", property = "materialID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FStandard", property = "standrad", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStockAmount", property = "stockCount", javaType = String.class, jdbcType = JdbcType.DECIMAL),
            @Result(column = "FLowStock", property = "minStockCount", javaType = String.class, jdbcType = JdbcType.DECIMAL),
            @Result(column = "FUnit", property = "unit", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRemarks", property = "remark", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    public List<StockMaterialPo> getStockMaterial(@Param("param") StockMaterialPo po, @Param("page") int page, @Param("pageSize") int pageSize);

    @SelectProvider(type = StorageOutDetailed.class,method = "queryStockMaterialCount")
    public int  getStockMaterialCount(@Param("param") StockMaterialPo po);


    class StorageOutDetailed {
        public String queryStorageOutDetailedList(Map<String, Object> params) {
            StorageOutDetailedEntryPo po = (StorageOutDetailedEntryPo) params.get("param");
            String materialId = po.getMaterialID();
            String standard = po.getStandard();
            String fnumber = po.getFnumber();
            String storeHouseID = po.getStorageID();
            String Edate = po.getEdate();
            String Ldate = po.getLdate();
            StringBuffer sql = new StringBuffer();
            sql.append("select zout.FID,fout.FNnumber,fout.FOutStorageDate,store.FStoreHouseName,staff1.FStaffName as storeman,staff2.FStaffName as operator,staff2.FID as operatorID,fout.FExplain,material.FMaterialName,zout.FStandard,zout.FQty  " +
                    "from  " +
                    "T_OUT_STORAGE fout,T_OUT_STORAGE_ENTRY zout,T_STOREHOUSE store,T_STAFF_MESSAGE staff1,T_STAFF_MESSAGE staff2,T_MATERIAL material " +
                    "where  " +
                    "fout.FID=zout.FParentID  and  zout.FStorageID=store.FID and zout.FStoremanID=staff1.FID  and fout.FOperatorID=staff2.FID and zout.FMaterialID=material.FID  ");
            if ((materialId != null) && (materialId.length() != 0)) {
                sql.append(" and zout.FMaterialID = '" + materialId + "'");
            }
            if ((fnumber != null) && (fnumber.length() != 0)) {
                sql.append(" and fout.FNnumber = '" + fnumber + "'");
            }
            if ((standard != null) && (standard.length() != 0)) {
                sql.append(" and zout.FStandard = '" + standard + "'");
            }
            if ((storeHouseID != null) && (storeHouseID.length() != 0)) {
                sql.append(" and zout.FStorageID = '" + storeHouseID + "'");
            }
            if ((Edate != null) && (Edate.length() != 0)) {
                sql.append(" and fout.FOutStorageDate >= '" + Edate + "'");
            }
            if ((Ldate != null) && (Ldate.length() != 0)) {
                sql.append(" and fout.FOutStorageDate <= '" + Ldate + "'");
            }
            sql.append(" order by fout.FModificationTime desc,fout.FNnumber desc limit #{page},#{pageSize}");
            return sql.toString();
        }

        public String queryStorageOutDetailedCount(Map<String, Object> params) {
            StorageOutDetailedEntryPo po = (StorageOutDetailedEntryPo) params.get("param");
            String materialId = po.getMaterialID();
            String standard = po.getStandard();
            String fnumber = po.getFnumber();
            String storeHouseID = po.getStorageID();
            String Edate = po.getEdate();
            String Ldate = po.getLdate();
            StringBuffer sql = new StringBuffer();
            sql.append("select count(*)  from  " +
                    "T_OUT_STORAGE fout,T_OUT_STORAGE_ENTRY zout,T_STOREHOUSE store,T_STAFF_MESSAGE staff1,T_STAFF_MESSAGE staff2,T_MATERIAL material " +
                    "where  " +
                    "fout.FID=zout.FParentID  and  zout.FStorageID=store.FID and zout.FStoremanID=staff1.FID  and fout.FOperatorID=staff2.FID and zout.FMaterialID=material.FID  ");
            if ((materialId != null) && (materialId.length() != 0)) {
                sql.append(" and zout.FMaterialID = '" + materialId + "'");
            }
            if ((fnumber != null) && (fnumber.length() != 0)) {
                sql.append(" and fout.FNnumber = '" + fnumber + "'");
            }
            if ((standard != null) && (standard.length() != 0)) {
                sql.append(" and zout.FStandard = '" + standard + "'");
            }
            if ((storeHouseID != null) && (storeHouseID.length() != 0)) {
                sql.append(" and zout.FStorageID = '" + storeHouseID + "'");
            }
            if ((Edate != null) && (Edate.length() != 0)) {
                sql.append(" and fout.FOutStorageDate >= '" + Edate + "'");
            }
            if ((Ldate != null) && (Ldate.length() != 0)) {
                sql.append(" and fout.FOutStorageDate <= '" + Ldate + "'");
            }
            return sql.toString();
        }
        public String queryStockMaterial(Map<String, Object> params) {
            StockMaterialPo po = (StockMaterialPo) params.get("param");
            String FMaterialName = po.getMaterial();
            String typeID = po.getMaterialTypeID();
            String storehouseID = po.getStoreHouseID();
            StringBuffer sql = new StringBuffer();
            sql.append("select  "  +
                    "stock.FID,stock.FStorageID,stock.FMaterialID,store.FStoreHouseName,staff.FStaffName,staff.FID as StaffID,material.FMaterialName,stock.FStandard,stock.FStockAmount,material.FLowStock,material.FUnit,material.FRemarks " +
                    "from STOCK_ACCOUNT stock,T_STOREHOUSE store,T_MATERIAL material,T_STAFF_MESSAGE staff,T_MATERIAL_CATEGORY materialtype   " +
                    " where stock.FStorageID=store.FID and store.FStoremanID=staff.FID and stock.FMaterialID = material.FID and material.FCategoryID=materialtype.FID  and stock.FStockAmount > 0 and material.FStatus='1' ");
            if ((FMaterialName != null) && (FMaterialName.length() != 0)) {
                sql.append(" and material.FMaterialName = '" + FMaterialName + "'");
            }
            if ((typeID != null) && (typeID.length() != 0)) {
                sql.append(" and materialtype.FID in " + typeID );
            }
            if ((storehouseID != null) && (storehouseID.length() != 0)) {
                sql.append(" and store.FID = '" + storehouseID + "'");
            }
            sql.append("  limit #{page},#{pageSize}");
            return sql.toString();
        }

        public String queryStockMaterialCount(Map<String, Object> params) {
            StockMaterialPo po = (StockMaterialPo) params.get("param");
            String materialName = po.getMaterial();
            String typeID = po.getMaterialTypeID();
            String storehouseID = po.getStoreHouseID();
            StringBuffer sql = new StringBuffer();
            sql.append("select  count(*) "  +
                    "from STOCK_ACCOUNT stock,T_STOREHOUSE store,T_MATERIAL material,T_STAFF_MESSAGE staff,T_MATERIAL_CATEGORY materialtype   " +
                    " where stock.FStorageID=store.FID and store.FStoremanID=staff.FID and stock.FMaterialID = material.FID and material.FCategoryID=materialtype.FID  and stock.FStockAmount > 0 and material.FStatus='1' ");
            if ((materialName != null) && (materialName.length() != 0)) {
                sql.append(" and material.FMaterialName = '" + materialName + "'");
            }
            if ((typeID != null) && (typeID.length() != 0)) {
                sql.append(" and materialtype.FID in " + typeID );
            }
            if ((storehouseID != null) && (storehouseID.length() != 0)) {
                sql.append(" and store.FID = '" + storehouseID + "'");
            }
            return sql.toString();
        }
        public String insertOutStorageEntry(Map<String, Object> params){
            List<StorageOutDetailedEntryPo> list = (List<StorageOutDetailedEntryPo>) params.get("list");
            System.out.println(list.toString());
            StringBuffer sql=new StringBuffer();
            sql.append("insert into T_OUT_STORAGE_ENTRY(FParentID,FStorageID,FStoremanID,FMaterialID,FStandard,FQty,FRemarks) values");
            for (StorageOutDetailedEntryPo po:list) {
                sql.append("("+po.getFpid()+","+po.getStorageID()+","+po.getStorageManID()+","+po.getMaterialID()+",'"+po.getStandard()+"',"+po.getQty()+",'"+po.getRemark()+"'),");
            }
            String sqll=sql.substring(0,(sql.length()-1));
            System.out.println(sqll);
            return sqll;
        }
        public String updateStockAccountList(Map<String, Object> params) {
            List<StockMaterialPo> materialPoList= (List<StockMaterialPo>) params.get("param");
            StringBuffer sql = new StringBuffer();
            StringBuffer str = new StringBuffer();
            sql.append("update STOCK_ACCOUNT set FStockAmount = CASE ");
            for (StockMaterialPo po:materialPoList) {
                sql.append(" WHEN FID = "+po.getId()+" THEN "+po.getStockCount());
                str.append(po.getId()+",");
            }
            sql.append(" END WHERE FID IN("+str.substring(0,str.length()-1)+")");
            System.out.println("ssssssql:"+sql.toString());
            return  sql.toString();
        }
    }
}
