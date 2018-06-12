package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.OldManServiceplanPo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by wangjs on 2017/3/25.
 */
public interface OldManServiceplanMapper {

    @Select("select t_kfgl_serviceitem.FID,t_kfgl_oldmanserviceplan.FoldmanserviceitemID,t_kfgl_serviceitem.Fname,t_kfgl_oldmanserviceplan.Fstatus,t_kfgl_oldmanserviceplan.Fexcludcount,t_kfgl_oldmanserviceplan.Fplancount,t_oldman_main.FoldManName\n" +
            "from t_kfgl_oldmanserviceplan,t_oldman_main,t_kfgl_serviceitem\n" +
            "where t_kfgl_oldmanserviceplan.FoldManID=t_oldman_main.FID and t_kfgl_serviceitem.FID=t_kfgl_oldmanserviceplan.FoldmanserviceitemID and t_kfgl_oldmanserviceplan.FoldManID=#{oldManId}")
    public List<OldManServiceplanPo> getOldManServicePlan(String oldManId);
}
