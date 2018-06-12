package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.StockMaterialPo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 * Created by liuxing on 2017/1/4.
 */
public interface StockAccountMapper {
    @SelectProvider(type =StockAccount.class ,method = "queryStockAccountList" )
    @Results(value = {
            @Result(column = "FID", property = "id", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FNnumber", property = "number", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStandard", property = "standrad", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStockAmount", property = "stockCount", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMaterialName", property = "material", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStoreHouseName", property = "storeHouse", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FLowStock", property = "minStockCount", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursingName", property = "nursingHomeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    public List<StockMaterialPo> queryStockAccountList(@Param("param") StockMaterialPo po,@Param("page") int page,@Param("pageSize") int pageSize);

    @SelectProvider(type = StockAccount.class,method = "queryStockAccountCount")
    public int queryStockAccountCount(@Param("param") StockMaterialPo po);

    class StockAccount
    {
        public String queryStockAccountList(Map<String,Object> params)
        {
            StockMaterialPo po= (StockMaterialPo) params.get("param");
            String mateialID= po.getMaterialID();
            String houseID = po.getStoreHouseID();
            StringBuffer sql = new StringBuffer();
//            sql.append("select " +
//                    "stock.FID,stock.FNnumber,stock.FStandard,stock.FStockAmount,material.FMaterialName,house.FStoreHouseName,material.FLowStock  " +
//                    "from " +
//                    "STOCK_ACCOUNT stock,T_MATERIAL material,T_STOREHOUSE house " +
//                    "where stock.FMaterialID=material.FID and stock.FStorageID=house.FID  and stock.FStockAmount >= 0 ");
            sql.append("select nursinghome.FNursingName,stock.FID,stock.FNnumber,stock.FStandard,stock.FStockAmount,material.FMaterialName,house.FStoreHouseName,material.FLowStock " +
                    "from " +
                    "STOCK_ACCOUNT stock,T_MATERIAL material,T_STOREHOUSE house,T_SYS_NURSINGHOME nursinghome " +
                    "where " +
                    "stock.FMaterialID=material.FID and stock.FStorageID=house.FID and nursinghome.FID=stock.FNursingHomeID");
            if((mateialID !=null )&&( mateialID.length() !=0))
            {
                sql.append(" and stock.FMaterialID = '"+mateialID+"'");
            }
            if((houseID !=null )&& (houseID.length() != 0))
            {
                sql.append(" and stock.FStorageID = '"+houseID+"'");
            }
            sql.append("   limit #{page},#{pageSize}");
            return sql.toString();
        }
        public String queryStockAccountCount(Map<String,Object> params)
        {
            StockMaterialPo po= (StockMaterialPo) params.get("param");
            String mateialID= po.getMaterialID();
            String houseID = po.getStoreHouseID();
            StringBuffer sql = new StringBuffer();
            sql.append("select count(*)" +
                    "from " +
                    "STOCK_ACCOUNT stock,T_MATERIAL material,T_STOREHOUSE house " +
                    "where stock.FMaterialID=material.FID and stock.FStorageID=house.FID  and stock.FStockAmount >= 0 ");
            if((mateialID !=null )&&( mateialID.length() !=0))
            {
                sql.append(" and stock.FMaterialID = '"+mateialID+"'");
            }
            if((houseID !=null )&& (houseID.length() != 0))
            {
                sql.append(" and stock.FStorageID = '"+houseID+"'");
            }
            return sql.toString();
        }
    }
}
