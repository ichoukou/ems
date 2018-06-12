package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.StorageGoodsManagementPo;
import com.channelsoft.ems.po.StorageGoodsSortingPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 * Created by liuxing on 2016/12/23.
 */
public interface StorageGoodsMapper {

    @Update("update T_MATERIAL set FStatus='0' where FID = #{id}")
    public void forbiddenStorageManagement(String id);
    @Update("update T_MATERIAL set FStatus='1' where FID = #{id}")
    public void startStorageManagement(String id);
    @Update("update T_MATERIAL_CATEGORY set FStatus='0' where FID = #{id}")
    public void forbiddenStorageGoodsType(String id);
    @Update("update T_MATERIAL_CATEGORY set FCategoryName= #{typeName},FHigherUpID=#{fatherID},FRemarks=#{remark} where FID=#{id}")
    public void updateStorageGoodsSorting(StorageGoodsSortingPo po);
    @Update("update T_MATERIAL set FMaterialName=#{name},FStandard=#{standard},FUnit=#{unit},FLowStock=#{lowStock},FRemarks=#{remark},FCategoryID=#{typeID},FPrice=#{price},FEnterTime=#{enterTime}  where FID=#{id}")
    public void updateStorageGoodsManagement(StorageGoodsManagementPo po);


    @Insert("insert into T_MATERIAL_CATEGORY(FCategoryNumber,FCategoryName,FHigherUpID,FRemarks,FStatus)  values(#{typeNumber},#{typeName},#{fatherID},#{remark},'1')")
    public void addStorageGoodsSorting(StorageGoodsSortingPo po);
    @Insert("insert into T_MATERIAL(FMmaterialNumber,FCategoryID,FMaterialName,FStandard,FUnit,FLowStock,FRemarks,FEnterTime,FPrice,FStatus)  values(#{number},#{typeID},#{name},#{standard},#{unit},#{lowStock},#{remark},#{enterTime},#{price},'1')")
    public void addStorageGoodsManagement(StorageGoodsManagementPo po);

    @Select("select count(*) from T_MATERIAL_CATEGORY where FHigherUpID = #{id} and FStatus='1'")
    public int searchStorageGoodsSunCount(@Param("id") String id);

    @Select("select * from T_MATERIAL_CATEGORY where FHigherUpID = 0 and FStatus='1'")
    @Results(value = {
            @Result(column = "FID", property = "id", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FCategoryNumber", property = "typeNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCategoryName", property = "typeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FHigherUpID", property = "fatherID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FRemarks", property = "remark", javaType = String.class, jdbcType = JdbcType.VARCHAR),
           })
    public List<StorageGoodsSortingPo> getStorageGoodsSorting();

    @Select("select * from T_MATERIAL_CATEGORY where FHigherUpID = #{id} and FStatus='1'")
    @Results(value = {
            @Result(column = "FID", property = "id", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FCategoryNumber", property = "typeNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCategoryName", property = "typeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FHigherUpID", property = "fatherID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FRemarks", property = "remark", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    public List<StorageGoodsSortingPo> getStorageGoodsSortingSon(@Param("id") String id);

    @Select("select * from T_MATERIAL_CATEGORY where FID <> #{id} and FStatus='1'")
    @Results(value = {
            @Result(column = "FID", property = "id", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FCategoryName", property = "typeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FHigherUpID", property = "fatherID", javaType = String.class, jdbcType = JdbcType.INTEGER),
    })
    public List<StorageGoodsSortingPo> getStorageGoodsSortingTypeList(@Param("id") String id);

    @Select("select * from T_MATERIAL_CATEGORY where FID <> #{id} ")
    @Results(value = {
            @Result(column = "FID", property = "id", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FCategoryName", property = "typeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FHigherUpID", property = "fatherID", javaType = String.class, jdbcType = JdbcType.INTEGER),
    })
    public List<StorageGoodsSortingPo> getStorageGoodsSortingTypeList2(@Param("id") String id);


    @SelectProvider(type = StorageGoods.class,method = "queryStorageGoodsManagementItem")
    @Results(value = {
            @Result(column = "FID", property = "id", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FMaterialName", property = "name", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStandard", property = "standard", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FUnit", property = "unit", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FLowStock", property = "lowStock", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FRemarks", property = "remark", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FCategoryName", property = "type", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPrice", property = "price", javaType = String.class, jdbcType = JdbcType.DECIMAL),
            @Result(column = "FCategoryID", property = "typeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FStatus", property = "status", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStatus", property = "typeStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR)
    })
    public List<StorageGoodsManagementPo> queryStorageGoodsManagementList(@Param("param") StorageGoodsManagementPo po, @Param("page") int page, @Param("pageSize") int pageSize);

    @SelectProvider(type = StorageGoods.class,method = "queryStorageGoodsManagementItemcount")
    public int queryStorageGoodsManagementItemcount(@Param("param") StorageGoodsManagementPo po);

    class StorageGoods{
        public String queryStorageGoodsManagementItem(Map<String, Object> params){
            StorageGoodsManagementPo po= (StorageGoodsManagementPo) params.get("param");
            String itemName = po.getName();
            String itemType = po.getType();
            String itemStatus = po.getStatus();
            StringBuffer sql = new StringBuffer();
            sql.append("select goods.FPrice,goods.FID,goods.FMaterialName,goods.FStandard,goods.FUnit,goods.FLowStock,goods.FRemarks,type.FCategoryName,goods.FCategoryID,goods.FStatus,type.FStatus as typeStatus " +
                    "from T_MATERIAL goods,T_MATERIAL_CATEGORY type " +
                    "where goods.FCategoryID=type.FID  ");
            if((itemName !=null )&&( itemName.length() !=0))
            {
                sql.append(" and goods.FMaterialName = '"+itemName+"'");
            }
            if((itemType !=null )&& (itemType.length() != 0))
            {
                sql.append(" and type.FID in "+itemType);
            }
            if((itemStatus !=null )&& (itemStatus.length() != 0))
            {
                sql.append(" and goods.FStatus = '"+itemStatus+"'");
            }
            sql.append("   limit #{page},#{pageSize}");
            return sql.toString();
        }
        public String queryStorageGoodsManagementItemcount(Map<String, Object> params){
            StorageGoodsManagementPo po= (StorageGoodsManagementPo) params.get("param");
            String itemName = po.getName();
            String itemType = po.getType();
            String itemStatus = po.getStatus();
            StringBuffer sql = new StringBuffer();
            sql.append("select count(*) from T_MATERIAL goods,T_MATERIAL_CATEGORY type where goods.FCategoryID=type.FID  ");
            if((itemName !=null )&&( itemName.length() !=0))
            {
                sql.append(" and goods.FMaterialName = '"+itemName+"'");
            }
            if((itemType !=null )&& (itemType.length() != 0))
            {
                sql.append(" and type.FID in "+itemType);
            }
            if((itemStatus !=null )&& (itemStatus.length() != 0))
            {
                sql.append(" and goods.FStatus = '"+itemStatus+"'");
            }
            return sql.toString();
        }
    }
}
