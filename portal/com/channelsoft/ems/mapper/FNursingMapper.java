package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.ArrgngHomePo;
import com.channelsoft.ems.po.FNursingPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Map;


/** 
 * 
 * 养老院管理
 * @author  wuhl
 * @date 创建时间：2017年2月14日 下午10:13:41
 * @parameter  
 * @return  
 */
public interface FNursingMapper {

	public static Logger logger=Logger.getLogger(FNursingPo.class);


	//查询不被禁用的养老院id 登陆时候使用
	@Select(" SELECT FID ,FNursingName FROM T_SYS_NursingHome WHERE FStatus='1' ")
	public List<FNursingPo> queryStartFNursing( );

	//查询所有养老院
	@Select(" SELECT FID ,FNursingName FROM T_SYS_NursingHome ")
	public List<FNursingPo> queryAllFNursing( );




	//收费标准
	@Select(" SELECT * FROM DATA_DICTIONARY WHERE DC_NAME='收费模式' ")
	public List<Map<String,String>> showFursing();


	 //新增养老院
	 @Insert(" INSERT INTO `T_SYS_NursingHome`(`FNursingName`,`FLeader`,`FLeaderPhone`,`FDate`,`FNursingAdd`,`FStatus`,`FFreeDays`,`FChargeModeID`,`FFirstFee`,`FLastFee`,`FBedFree`,`FServiceFree`,`FMealFree`,`FCreatorID`,`FCreateTime`,`FRemarks`)" +
			 " values ( #{fNursingName},#{fLeader},#{fLeaderPhone},#{fDate},#{fNursingAdd},#{fStatus},#{fFreeDays},#{fChargeModeID},#{fFirstFee},#{fLastFee},#{fBedFree},#{fServiceFree},#{fMealFree},'当前对应员工id',now(),#{fRemarks}); ")
      public void addFBursing(FNursingPo param);

	//验证养老院名字不能重复
	@Select (" SELECT COUNT(*) FROM T_SYS_NursingHome WHERE FNursingName=#{fNursingName} ")
	public int check(FNursingPo po);

	@Select(" SELECT COUNT(*) FROM T_SYS_NursingHome WHERE FNursingName=#{fNursingName} and FID<>#{fID}")
	public int updateCheck(FNursingPo po);

	//更新养老院
    @Update("  UPDATE `T_SYS_NursingHome` set `FNursingName`=#{fNursingName},`FLeader`=#{fLeader},`FLeaderPhone`=#{fLeaderPhone},`FDate`=#{fDate},`FNursingAdd`=#{fNursingAdd}," +
			"`FStatus`=#{fStatus},`FFreeDays`=#{fFreeDays},`FChargeModeID`=#{fChargeModeID},`FFirstFee`=#{fFirstFee},`FLastFee`=#{fLastFee},`FBedFree`=#{fBedFree},`FServiceFree`=#{fServiceFree},`FMealFree`=#{fMealFree},`FCreatorID`='登录人id'," +
			"`FCreateTime`=now(),`FRemarks`=#{fRemarks} " +
			"where `FID`=#{fID} \n")
	public void updateFBursing(FNursingPo po);

	//启用养老院
	 @Update("  UPDATE `T_SYS_NursingHome` SET `FStatus`='1' where `FID`=#{fID} ")
	 public void start(FNursingPo param);
	//停用养老院
	 @Update(" UPDATE `T_SYS_NursingHome` SET `FStatus`='0' where `FID`=#{fID} ")
     public void delete(FNursingPo param);


	//带分页查询
	@SelectProvider(type=FNursing.class,method = "queryFNursingCount")
	public int queryFNursingCount(@Param("param") FNursingPo param);

	//带分页查询
	@SelectProvider(type=FNursing.class,method = "getNusingHomeById")
	public List<FNursingPo> getNusingHomeById(@Param("param") FNursingPo param);

	@SelectProvider(type=FNursing.class,method = "queryFNursing")
	public List<FNursingPo> queryFNursing(@Param("param") FNursingPo param,@Param(value="page") int page,@Param(value="pageSize") int pageSize);


	class FNursing {
		public String getNusingHomeById(Map<String, Object> params) {

			FNursingPo inPo = (FNursingPo) params.get("param");

			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT * FROM T_SYS_NursingHome WHERE 1=1 ");

			if (null == inPo) {
				return sql.toString();
			} else {
				if (StringUtils.isNotEmpty(inPo.getfNursingName())) {
					sql.append(" and T.FID = '" + inPo.getfID() + "'");
				}
			}
			logger.debug("查询养老院语句：" + sql.toString());
			return sql.toString();
		}

		public String queryFNursing(Map<String, Object> params) {

			FNursingPo inPo = (FNursingPo) params.get("param");

			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT T.*,D.DC_VALUE 'FChargeModeName' FROM T_SYS_NursingHome T ,DATA_DICTIONARY D " +
					   " WHERE  D.DC_NAME='收费模式' AND T.FChargeModeID=D.DC_ID ");

			if (null == inPo) {
				return sql.toString();
			} else {
				if (StringUtils.isNotEmpty(inPo.getfNursingName())) {
					sql.append(" and T.FNursingName = '" + inPo.getfNursingName() + "'");
				}
				if (StringUtils.isNotEmpty(inPo.getfLeader())) {

					sql.append(" and T.FLeader = '" + inPo.getfLeader() + "'");
				}
				if (StringUtils.isNotEmpty(inPo.getfLeaderPhone())) {
					sql.append(" and  T.FLeaderPhone = '" + inPo.getfLeaderPhone() + "'");
				}
				if (StringUtils.isNotEmpty(inPo.getfStatus())) {
					sql.append(" and  T.FStatus = '" + inPo.getfStatus() + "'");

				}

			}


			sql.append("  order by T.FID  desc limit #{page},#{pageSize}");
			logger.debug("查询养老院语句：" + sql.toString());


			return sql.toString();
		}

		public String queryFNursingCount(Map<String, Object> params) {

			FNursingPo inPo = (FNursingPo) params.get("param");

			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT COUNT(*) FROM T_SYS_NursingHome T ,DATA_DICTIONARY D " +
					" WHERE  D.DC_NAME='收费模式' AND T.FChargeModeID=D.DC_ID  ");

			if (null == inPo) {
				return sql.toString();
			} else {
				if (StringUtils.isNotEmpty(inPo.getfNursingName())) {
					sql.append(" and T.FNursingName = '" + inPo.getfNursingName() + "'");
				}
				if (StringUtils.isNotEmpty(inPo.getfLeader())) {

					sql.append(" and T.FLeader = '" + inPo.getfLeader() + "'");
				}
				if (StringUtils.isNotEmpty(inPo.getfLeaderPhone())) {
					sql.append(" and  T.FLeaderPhone = '" + inPo.getfLeaderPhone() + "'");
				}
				if (StringUtils.isNotEmpty(inPo.getfStatus())) {
					sql.append(" and  T.FStatus = '" + inPo.getfStatus() + "'");

				}

			}


			logger.debug("查询养老院总数：" + sql.toString());


			return sql.toString();
		}

	}
	

}   
    
    
    
    
    

