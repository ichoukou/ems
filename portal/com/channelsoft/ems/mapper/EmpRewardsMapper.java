package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.RewardsPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;

/**
 * Created by 张鑫 on 2016/12/15.
 */
public interface EmpRewardsMapper {
    public static Logger logger = Logger.getLogger(EmpRewardsMapper.class);

    @Insert("INSERT INTO T_STAFF_REWARD  " +
            "(FNumber,FNursingHomeID,FStaffID,FRewardDate,FRewardType,FRewardReason,FRewardMoney,FExplain,FCreatorID,FCreateTime) " +
            "VALUES " +
            "(#{fNumber},#{fNursingHomeID},#{fStaffID},#{fRewardDate},#{fRewardType},#{fRewardReason},#{fRewardMoney},#{fExplain},#{fCreatorID},#{fCreateTime})")
    public int addEmpRewards(RewardsPo rewardsPo);

    @Delete("DELETE  FROM T_STAFF_REWARD WHERE FID=#{fID}")
    public void deleteEmpRewards(String fID);

    @Update("UPDATE T_STAFF_REWARD " +
            "SET " +
            "FStaffID=#{fStaffID},FNursingHomeID=#{fNursingHomeID},FRewardDate=#{fRewardDate},FRewardType=#{fRewardType},FRewardReason=#{fRewardReason},FRewardMoney=#{fRewardMoney},FExplain=#{fExplain},FCreatorID=#{fCreatorID},FCreateTime=#{fCreateTime} " +
            "where " +
            "FID=#{fID} ")
    public int updateEmpRewards(RewardsPo rewardsPo);

    @SelectProvider(type = ChangeProvider.class, method = "queryCount")
    public int queryCount(@Param("param") RewardsPo param);

    @SelectProvider(type = ChangeProvider.class, method = "queryList")
    public List<RewardsPo> queryList(@Param("param") RewardsPo param, @Param(value = "page") int page, @Param(value = "pageSize") int pageSize);

    class ChangeProvider {
        public String queryList(Map<String, Object> params) {
            RewardsPo rewardsPo = (RewardsPo) params.get("param");
            StringBuffer empSql = new StringBuffer();
            empSql.append("select t.*,c.FStaffName FCreatorName " +
                    "from " +
                    "(select b.FID,b.FStaffID,b.FRewardDate,a.FStaffName,b.FRewardType,b.FRewardReason,b.FRewardMoney,b.FExplain,b.FCreatorID ,b.FCreateTime " +
                    "from " +
                    "T_STAFF_MESSAGE a,T_STAFF_REWARD b " +
                    "where " +
                    "a.FID=b.FStaffID) t,T_STAFF_MESSAGE c " +
                    "where t.FCreatorID = c.FID");
            if (null == rewardsPo) {
                return empSql.toString();
            } else {
                if (StringUtils.isNotEmpty(rewardsPo.getfStaffID())) {
                    empSql.append(" and t.FStaffID = '" + rewardsPo.getfStaffID() + "'");
                }
                if (StringUtils.isNotEmpty(rewardsPo.getfRewardDate())&&rewardsPo.getfRewardDate().length()==7) {
                    empSql.append(" and t.FRewardDate like( '" + rewardsPo.getfRewardDate() + "%')");
                }else if (StringUtils.isNotEmpty(rewardsPo.getfRewardDate())&&rewardsPo.getfRewardDate().length()!=7&&rewardsPo.getfRewardDate().length()!=4){
                    empSql.append(" and quarter(t.FRewardDate) = quarter('"+rewardsPo.getfRewardDate()+"')");
                }else if (StringUtils.isNotEmpty(rewardsPo.getfRewardDate())&&rewardsPo.getfRewardDate().length()==4){
                    empSql.append(" and t.FRewardDate like( '" + rewardsPo.getfRewardDate() + "%')");
                }
                if (StringUtils.isNotEmpty(rewardsPo.getfRewardType())) {
                    empSql.append(" and FRewardType ='" + rewardsPo.getfRewardType() + "'");
                }
            }
            empSql.append(" limit #{page},#{pageSize}");
            logger.debug(empSql.toString());
            return empSql.toString();
        }

        public String queryCount(Map<String, Object> params) {
            RewardsPo rewardsPo = (RewardsPo) params.get("param");
            StringBuffer sb = new StringBuffer();
            sb.append("select count(*) from (select t.*,c.FStaffName FCreatorName " +
                    "from " +
                    "(select b.FID,b.FStaffID,b.FRewardDate,a.FStaffName,b.FRewardType,b.FRewardReason,b.FRewardMoney,b.FExplain,b.FCreatorID ,b.FCreateTime " +
                    "from " +
                    "T_STAFF_MESSAGE a,T_STAFF_REWARD b " +
                    "where " +
                    "a.FID=b.FStaffID) t,T_STAFF_MESSAGE c " +
                    "where t.FCreatorID = c.FID) t1"+
                    " where 1=1 ");
            if (null == rewardsPo) {
                return sb.toString();
            } else {
                if (StringUtils.isNotEmpty(rewardsPo.getfStaffID())) {
                    sb.append(" and FStaffID = '" + rewardsPo.getfStaffID() + "'");
                }
                if (StringUtils.isNotEmpty(rewardsPo.getfRewardDate())&&rewardsPo.getfRewardDate().length()==7) {
                    sb.append(" and FRewardDate like( '" + rewardsPo.getfRewardDate() + "%')");
                }else if (StringUtils.isNotEmpty(rewardsPo.getfRewardDate())&&rewardsPo.getfRewardDate().length()!=7&&rewardsPo.getfRewardDate().length()!=4){
                    sb.append(" and quarter(FRewardDate) = quarter('"+rewardsPo.getfRewardDate()+"')");
                }else if (StringUtils.isNotEmpty(rewardsPo.getfRewardDate())&&rewardsPo.getfRewardDate().length()==4){
                    sb.append(" and  FRewardDate like( '" + rewardsPo.getfRewardDate() + "%')");
                }
                if (StringUtils.isNotEmpty(rewardsPo.getfRewardType())) {
                    sb.append(" and FRewardType = '" + rewardsPo.getfRewardType() + "'");
                }
            }
            logger.debug(sb.toString());
            return sb.toString();
        }
    }
}
