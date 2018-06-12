package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.ArrgngHomePo;
import com.channelsoft.ems.po.PublicServicePlanPo;
import com.channelsoft.ems.po.ServiceItemPo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by wangjs on 2017/3/6.
 */
public interface PublicServicePlanMapper {
    public static Logger logger=Logger.getLogger(PublicServicePlanMapper.class);

    @Select("select t_arrgng_home.FHomeID from t_arrgng_home where t_arrgng_home.FStaffID=#{userId}")
    @Results(value = {
            @Result(column = "FHomeID", property = "fHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER)})
    public List<ArrgngHomePo> getRoomByUserId(String userId);

    @Select("select t_kfgl_publicserviceplan.Fstatus,t_room.FRoomName,t_room.FID from t_kfgl_publicserviceplan,t_room where t_kfgl_publicserviceplan.FroomID=t_room.FID and t_kfgl_publicserviceplan.FroomID=#{roomId}")
    @Results(value = {
            @Result(column = "Fstatus", property = "fstatus", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FID", property = "fID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "fplancount", property = "fplancount", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "fexcludcount", property = "fexcludcount", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FroomID", property = "froomID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FRoomName", property = "fRoomName", javaType = String.class, jdbcType = JdbcType.INTEGER)})
    public List<PublicServicePlanPo> getPublicServicePlan(String roomId);

    @Select("select t_kfgl_serviceitem.Fname,t_kfgl_publicserviceplan.FID,t_kfgl_publicserviceplan.fplancount," +
            "t_kfgl_publicserviceplan.fexcludcount " +
            "from t_kfgl_publicserviceplan,t_kfgl_serviceitem " +
            "where t_kfgl_publicserviceplan.FpublicserviceitemID=t_kfgl_serviceitem.FID " +
            "and t_kfgl_publicserviceplan.FroomID=#{roomId}")
    public List<ServiceItemPo> getServiceItem(String roomId);

    @Select("select t_kfgl_publicserviceplan.FID,t_kfgl_publicserviceplan.fplancount,t_kfgl_publicserviceplan.fexcludcount " +
            "from t_kfgl_publicserviceplan " +
            "where t_kfgl_publicserviceplan.FID=#{fId}")
    public ServiceItemPo getPublicServicePlanByFid(String fId);

    @Update("update t_kfgl_publicserviceplan set fexcludcount=#{fexcludcount} where FID=#{fID}")
    public void staffHomeDetailPerform(ServiceItemPo po);

}
