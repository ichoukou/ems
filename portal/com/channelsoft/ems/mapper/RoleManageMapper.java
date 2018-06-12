package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.RolePo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Role;

import java.util.List;
import java.util.Map;

/**
 * 张鑫
 * Created by Administrator on 2016/12/1.
 */
public interface RoleManageMapper {

    @Select("SELECT count(*) FROM (SELECT s.r_id,s.r_name,s.r_attr,t.FNursingName FROM S_ROLE s,T_SYS_NursingHome t WHERE s.r_oldhouse = t.FID) r")
    public int  getRolecount();

    @Select("SELECT s.r_id,s.r_name,s.r_attr,t.FNursingName,s.r_oldhouse oldHouseId,s.r_state FROM S_ROLE s,T_SYS_NursingHome t WHERE s.r_oldhouse = t.FID order by r_id desc limit #{0},#{1}")
    @Results(value = {
            @Result(column="r_id",property="id",javaType=String.class,jdbcType= JdbcType.INTEGER),
            @Result(column="r_name",property="name",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="r_attr",property="attr",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="r_state",property="state",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="FNursingName",property="oldHouse",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="r_oldhouse",property="oldHouseId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
    })
    public List<RolePo>  getFenRoleList(Integer page,Integer pageSize);

    @Insert("INSERT INTO S_ROLE (r_name,r_attr,r_oldhouse,r_state) VALUES(#{name},#{attr},#{oldHouseId},1)")
    @Results(value = {
            @Result(column="r_name",property="name",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="r_attr",property="attr",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="r_oldhouse",property="oldHouseId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
    })
    public int addRoleList(RolePo rolePo);

    @Update("UPDATE S_ROLE SET r_name=#{name},r_attr=#{attr} ,r_oldhouse=#{oldHouseId} ,r_state=1 WHERE r_id=#{id}")
    @Results(value = {
            @Result(column="r_id",property="id",javaType=String.class,jdbcType= JdbcType.INTEGER),
            @Result(column="r_name",property="name",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="r_attr",property="attr",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="r_oldhouse",property="oldHouseId",javaType=String.class,jdbcType=JdbcType.VARCHAR),
            @Result(column="r_state",property="state",javaType=String.class,jdbcType=JdbcType.INTEGER),
    })
    public int updateRoleList(RolePo rolePo);

    @Update("UPDATE S_ROLE SET r_state=0 WHERE r_id=#{id}")
    public int updateState(String id);

    @Update("UPDATE S_ROLE SET r_state=1 WHERE r_id=#{id} ")
    public void startState(RolePo po);

    @SelectProvider(type=roleProvider.class,method="check")
    public int check(@Param("rolePo")RolePo rolePo);

    @Select(" SELECT COUNT(*) FROM S_ROLE WHERE r_name=#{name} and r_id<>#{id}")
    public int updateCheck(RolePo po);

    class roleProvider {
        private Logger logger = Logger.getLogger(roleProvider.class);

        /**
         * 校验是否存在
         *
         * @param map
         * @return
         */
        public String check(Map<String, Object> map) {
            RolePo rolePo = (RolePo) map.get("rolePo");
            StringBuffer sql = new StringBuffer("SELECT COUNT(*) FROM S_ROLE WHERE 1=1 ");
            if (rolePo.getName() != null) {
                sql.append("AND r_name = '" + rolePo.getName() + "'");
            }
            logger.debug("校验的sql语句为" + sql.toString());
            return sql.toString();
        }
    }
}
