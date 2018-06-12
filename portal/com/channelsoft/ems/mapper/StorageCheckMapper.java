package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.StorageCheckPo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

/**
 * Created by liuxing on 2017/1/6.
 */
public interface StorageCheckMapper {

    @InsertProvider(type = StorageCheck.class,method = "addCheck")
    public void addCheck(@Param("param") List<StorageCheckPo> list);

    @Select("select FID,FStaffName from T_STAFF_MESSAGE where FStaffStatus = '在职' and FState='1'")
    @Results(value = {
            @Result(column = "FID", property = "checkManID", javaType = String.class, jdbcType = JdbcType.DATE),
            @Result(column = "FStaffName", property = "checkMan", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    public List<StorageCheckPo> getCheckManList();


    @Select("select material.FID,material.FMmaterialNumber,material.FMaterialName,stock.FStockAmount,stock.FNursingHomeID,stock.FStorageID,tstorage.FStoremanID from  STOCK_ACCOUNT stock,T_MATERIAL material,T_STOREHOUSE tstorage where stock.FMaterialID=material.FID and tstorage.FID=stock.FStorageID and stock.FStorageID=#{storageID} ")
    @Results(value = {
            @Result(column = "FID", property = "materialID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FMmaterialNumber", property = "fnumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMaterialName", property = "material", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStockAmount", property = "paperNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FNursingHomeID", property = "nursingHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FStorageID", property = "storageID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FStoremanID", property = "storageManID", javaType = String.class, jdbcType = JdbcType.INTEGER),
    })

    public List<StorageCheckPo> getStorageMaterial(@Param("storageID") String storageID);
    @Select("select count(*) from  STOCK_ACCOUNT stock,T_MATERIAL material,T_STOREHOUSE tstorage where stock.FMaterialID=material.FID and tstorage.FID=stock.FStorageID and stock.FStorageID=#{storageID}  ")
    public int getStorageMaterialCount(@Param("storageID") String storageID);

    @SelectProvider(type =StorageCheck.class ,method ="queryStorageCheckList" )
    @Results(value = {
            @Result(column = "FCheckDate", property = "checkDate", javaType = String.class, jdbcType = JdbcType.DATE),
            @Result(column = "FStaffName", property = "checkMan", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStoreHouseName", property = "storage", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FRemarks", property = "remarks", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStorageID", property = "storageID", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    public List<StorageCheckPo> queryStorageCheckList(@Param("param") StorageCheckPo po,@Param("page") int page,@Param("pageSize") int pageSize);

    @Select("select tcheck.FNumber,material.FMaterialName,material.FStandard,tcheck.FPaperNumber,tcheck.FCheckNumber,tcheck.FDifference,tcheck.FStatus,tcheck.FExplain from T_CHECK  tcheck,T_MATERIAL material where tcheck.FMaterialID=material.FID and FCheckDate= #{checkDate} and FStorageID = #{storageID}")
    @Results(value = {
            @Result(column = "FNumber", property = "fnumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FMaterialName", property = "material", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FStandard", property = "storage", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FPaperNumber", property = "paperNumber", javaType = String.class, jdbcType = JdbcType.DECIMAL),
            @Result(column = "FCheckNumber", property = "checkNumber", javaType = String.class, jdbcType = JdbcType.DECIMAL),
            @Result(column = "FDifference", property = "difference", javaType = String.class, jdbcType = JdbcType.DECIMAL),
            @Result(column = "FStatus", property = "status", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FExplain", property = "explain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    public List<StorageCheckPo> getPrintList(@Param("storageID") String storageID,@Param("checkDate") String checkDate);

    @SelectProvider(type =StorageCheck.class ,method ="queryStorageCheckCount" )
    public int queryStorageCheckCount(@Param("param") StorageCheckPo po);


    class StorageCheck
    {
        public String queryStorageCheckList(Map<String,Object> params){
            StorageCheckPo po= (StorageCheckPo) params.get("param");
            String storage = po.getStorage();
            String Edate = po.getEdate();
            String Ldate = po.getLdate();
            StringBuffer sql = new StringBuffer();
            sql.append("select distinct tcheck.FStorageID,tcheck.FCheckDate,staff.FStaffName,house.FStoreHouseName,tcheck.FRemarks  from T_CHECK  tcheck,T_STAFF_MESSAGE staff,T_STOREHOUSE house where tcheck.FStorageID = house.FID and tcheck.FCheckManID=staff.FID");
            if((storage !=null )&&( storage.length() !=0))
            {
                sql.append(" and tcheck.FStorageID = "+storage);
            }
            if((Edate !=null )&& (Edate.length() != 0))
            {
                sql.append(" and tcheck.FCheckDate >= '"+Edate+"'");
            }
            if((Ldate !=null )&& (Ldate.length() != 0))
            {
                sql.append(" and tcheck.FCheckDate <= '"+Ldate+"'");
            }
            sql.append(" order by tcheck.FCheckDate desc  limit #{page},#{pageSize}");
            System.out.println(sql.toString());
            return sql.toString();
        }
        public String queryStorageCheckCount(Map<String,Object> params){
            StorageCheckPo po= (StorageCheckPo) params.get("param");
            String storage = po.getStorage();
            String Edate = po.getEdate();
            String Ldate = po.getLdate();
            StringBuffer sql = new StringBuffer();
            sql.append("select count(distinct tcheck.FStorageID,tcheck.FCheckDate,staff.FStaffName,house.FStoreHouseName,tcheck.FRemarks)  from T_CHECK  tcheck,T_STAFF_MESSAGE staff,T_STOREHOUSE house where tcheck.FStorageID = house.FID and tcheck.FCheckManID=staff.FID");
            if((storage !=null )&&( storage.length() !=0))
            {
                sql.append(" and tcheck.FStorageID = "+storage);
            }
            if((Edate !=null )&& (Edate.length() != 0))
            {
                sql.append(" and tcheck.FCheckDate >= '"+Edate+"'");
            }
            if((Ldate !=null )&& (Ldate.length() != 0))
            {
                sql.append(" and tcheck.FCheckDate <= '"+Ldate+"'");
            }
            System.out.println(sql.toString());
            return sql.toString();
        }
        public String addCheck(Map<String,Object> params){
            List<StorageCheckPo> list= (List<StorageCheckPo>) params.get("param");
            StringBuffer sql = new StringBuffer();
            sql.append("insert into T_CHECK(FNumber,FNursingHomeID,FCheckDate,FStoremanID,FStorageID,FCheckManID,FMaterialID,FPaperNumber,FCheckNumber,FDifference,FStatus,FExplain,FCreatorID,FCreateTime,FRemarks) values ");
            for (StorageCheckPo po:list) {
                sql.append("('"+po.getFnumber()+"','"+
                        po.getNursingHomeID()+"','"+
                        po.getCheckDate()+"','"+
                        po.getStorageManID()+"','"+
                        po.getStorageID()+"','"+
                        po.getCheckManID()+"','"+
                        po.getMaterialID()+"','"+
                        po.getPaperNumber()+"','"+
                        po.getCheckNumber()+"','"+
                        po.getDifference()+"','"+
                        po.getStatus()+"','"+
                        po.getExplain()+"','"+
                        po.getCreatorID()+"','"+
                        po.getCreateTime()+"','"+
                        po.getRemarks()+"'),"
                );
            }
            String sqll=sql.substring(0,(sql.length()-1));
            System.out.println(sqll);
            return sqll;
        }
    }
}
