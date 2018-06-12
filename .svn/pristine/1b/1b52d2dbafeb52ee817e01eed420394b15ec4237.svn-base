package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.HomeServiceItemPo;
import com.channelsoft.ems.po.HomeServiceTypePo;
import com.channelsoft.ems.po.MessagePo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;

/**
 * Created by liuxing on 2016/12/20.
 */
public interface HomeServiceItemMapper {
    @Select("select FID from T_HOME_SERVICETYPE where FServiceTypeName=#{serviceTypeName}")
    public String getHomeServiceItemTypeID(String serviceTypeName);

    @Select("select count(*)  from T_HOME_SERVICETYPE where FServiceTypeName = #{typeName} and Fnursing_homeID=#{homeID}")
    public int checkType(@Param("typeName") String typeName,@Param("homeID") String homeID);

    @Select("select distinct FServiceItemName from T_HOME_SERVICEITEM where Fnursing_homeID=#{oldhouse}")
    public List<String> getHomeServiceItemNameList(String oldhouse);



    @Select("select FServiceTypeName from T_HOME_SERVICETYPE where Fnursing_homeID=#{oldhouse}")
    public List<String> getHomeServiceItemTypeList(String oldhouse);

    @Select("select DC_VALUE from DATA_DICTIONARY  where DC_NAME='居家服务项目单位'")
    public List<String> getHomeServiceItemUnitList();

    @Update("update T_HOME_SERVICEITEM " +
            "set " +
            "Fstatus=#{itemStatus}," +
            "FServiceTypeID=#{serviceTypeID}," +
            "FServiceItemName=#{serviceItemName}," +
            "Fprice=#{price}," +
            "Funit=#{itemUnit}," +
            "Fexplain=#{explain} " +
            "where Fnumber=#{number}")
    public void updateHomeServiceItem(HomeServiceItemPo po);

    @Insert("insert into T_HOME_SERVICEITEM(Fnursing_homeID,Fnumber,Fstatus,FServiceTypeID,FServiceItemName,Fprice,Funit,Fexplain) " +
            "values(#{nursing_homeID},#{number},#{itemStatus},#{serviceTypeID},#{serviceItemName},#{price},#{itemUnit},#{explain})")
    public void addHomeServiceItem(HomeServiceItemPo po);

    @Insert("insert into T_HOME_SERVICETYPE(Fnursing_homeID,Fnumber,Fstatus,FServiceTypeName) " +
            "values(#{nursing_homeID},#{number},'1',#{serviceTypeName})")
    public void addHomeServiceType(HomeServiceTypePo po);

    @SelectProvider(type = HomeServiceItem.class,method = "queryItemCount")
    public int getHomeServiceItemCount(@Param("param") HomeServiceItemPo po);


    @SelectProvider(type = HomeServiceItem.class,method = "queryHomeServiceItem")
    @Results(value = {
            @Result(column = "FID", property = "id", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "Fnumber", property = "number", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "Fnursing_homeID", property = "nursing_homeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "Fnumber", property = "number", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fstatus", property = "itemStatus", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FServiceTypeID", property = "serviceTypeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FServiceItemName", property = "serviceItemName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fprice", property = "price", javaType = String.class, jdbcType = JdbcType.DECIMAL),
            @Result(column = "Funit", property = "itemUnit", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Fexplain", property = "explain", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FServiceTypeName", property = "serviceTypeName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
    })
    public List<HomeServiceItemPo> queryHomeServiceItemList(@Param("param") HomeServiceItemPo po,@Param("page") int page,@Param("pageSize") int pageSize);

    class HomeServiceItem{
        public String queryHomeServiceItem(Map<String, Object> params){
            HomeServiceItemPo po= (HomeServiceItemPo) params.get("param");
            String itemName = po.getServiceItemName();
            String itemType = po.getServiceTypeName();
            String itemStatus = po.getItemStatus();
            String itemHouseID = po.getNursing_homeID();
            StringBuffer sql = new StringBuffer();
            sql.append("select " +
                    "item.FID,item.Fnumber,item.Fnursing_homeID,item.Fprice,item.FServiceItemName,item.Fstatus,item.Funit,item.Fexplain,type.FServiceTypeName " +
                    "from " +
                    "T_HOME_SERVICEITEM item,T_HOME_SERVICETYPE type " +
                    " where item.FServiceTypeID = type.FID and item.Fnursing_homeID='"+itemHouseID+"'");
            if((itemName !=null )&&( itemName.length() !=0))
            {
                sql.append(" and item.FServiceItemName = '"+itemName+"'");
            }
            if((itemType !=null )&& (itemType.length() != 0))
            {
                sql.append(" and type.FServiceTypeName = '"+itemType+"'");
            }
            if((itemStatus !=null )&& (itemStatus.length() != 0))
            {
                sql.append(" and item.Fstatus = '"+itemStatus+"'");
            }
            sql.append(" order by  item.Fnumber desc limit #{page},#{pageSize}");
            return sql.toString();
        }
        public String queryItemCount(Map<String, Object> params){
            HomeServiceItemPo po= (HomeServiceItemPo) params.get("param");
            String itemName = po.getServiceItemName();
            String itemType = po.getServiceTypeName();
            String itemStatus = po.getItemStatus();
            String itemHouseID = po.getNursing_homeID();
            StringBuffer sql = new StringBuffer();
            sql.append("select count(*) from T_HOME_SERVICEITEM item,T_HOME_SERVICETYPE type where item.FServiceTypeID = type.FID and item.Fnursing_homeID='"+itemHouseID+"'");
            if((itemName !=null )&&( itemName.length() !=0))
            {
                sql.append(" and item.FServiceItemName = '"+itemName+"'");
            }
            if((itemType !=null )&& (itemType.length() != 0))
            {
                sql.append(" and type.FServiceTypeName = '"+itemType+"'");
            }
            if((itemStatus !=null )&& (itemStatus.length() != 0))
            {
                sql.append(" and item.Fstatus = '"+itemStatus+"'");
            }
            return sql.toString();
        }
    }
}
