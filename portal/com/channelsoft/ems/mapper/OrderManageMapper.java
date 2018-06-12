package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import com.channelsoft.ems.mapper.ChargeStandardMapper.ChangeProvider;
import com.channelsoft.ems.mapper.HomeServiceItemMapper.HomeServiceItem;
import com.channelsoft.ems.po.ChargePo;
import com.channelsoft.ems.po.HomeServiceItemPo;
import com.channelsoft.ems.po.OrderPo;

/** 
 * 
 * 居家服务订单
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午19:13:41 
 * @parameter  
 * @return  
 */
public interface OrderManageMapper {
	
    public static Logger logger=Logger.getLogger(OrderManageMapper.class);


    @SelectProvider(type=OrderMapper.class,method = "queryOrderMapper")
	@Results(value = {  
			@Result(column="FID",property="fid",javaType=String.class,jdbcType=JdbcType.INTEGER),
			@Result(column="FOrderNo",property="fOrderNo",javaType=String.class,jdbcType=JdbcType.VARCHAR),	
			@Result(column="FObjectName",property="fObjectName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FObjectPhone",property="fObjectPhone",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FServiceObject",property="fServiceObject",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FServiceUser",property="fServiceUser",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FDealStatus",property="fDealStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRequestTime",property="fRequestTime",javaType=String.class,jdbcType = JdbcType.DATE),
			@Result(column="FOrderyExplain",property="fOrderyExplain",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FFinishTime",property="fFinishTime",javaType=String.class,jdbcType = JdbcType.VARCHAR),
			@Result(column="FEvaluationOrder",property="fEvaluationOrder",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPayStyle",property="fPayStyle",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRecieveDept",property="fRecieveDept",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRecieveUser",property="fRecieveUser",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FRecieveTime",property="fRecieveTime",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FOrderEmergency",property="fOrderEmergency",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FDealStatus",property="fDealStatus",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FServiceObject",property="fServiceObject",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCallName",property="fCallName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FCallPhone",property="fCallPhone",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FObjectName",property="fObjectName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FServiceAdd",property="fServiceAdd",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FOrderType",property="fOrderType",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FServiceProvide",property="fServiceProvide",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FServiceUser",property="fServiceUser",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FServiceType",property="fServiceTypeid",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FServiceItem",property="fServiceItemid",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FPrice",property="fPrice",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FNumber",property="fNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FServiceItemName",property="fServiceItemName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FNumber",property="fNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="FTotal",property="fTotal",javaType=String.class,jdbcType=JdbcType.VARCHAR),
			@Result(column="Funit",property="funit",javaType=String.class,jdbcType=JdbcType.VARCHAR)
	        }) 
	public List<OrderPo> queryOrder(@Param("param") OrderPo param,@Param(value="page") int page,@Param(value="pageSize") int pageSize);
	
	
    @SelectProvider(type=OrderMapper.class,method = "queryCountOrder")
    public int queryOrderCount(@Param("param") OrderPo param);
    
	@Select(" SELECT * FROM DATA_DICTIONARY WHERE DC_NAME IN ('受理部门','工单紧急程度','付款方式','处理状态','服务对象','工单类型','服务方')")
	public List<Map<String,String>>getDATA_DIC();


	//查询服务种类 和服务项目
	@Select(" SELECT distinct(T_HOME_SERVICETYPE.FID),  FServiceTypeName FROM T_HOME_SERVICETYPE ,T_HOME_SERVICEITEM  WHERE  T_HOME_SERVICETYPE.FID=T_HOME_SERVICEITEM.FServiceTypeID and T_HOME_SERVICETYPE.Fstatus='1' and T_HOME_SERVICEITEM.Fstatus='1' \n" +
			" and T_HOME_SERVICETYPE.Fnursing_homeID=#{fNursingHomeID} and T_HOME_SERVICEITEM.Fnursing_homeID=#{fNursingHomeID} order by T_HOME_SERVICETYPE.FID  ")
	public List<Map<String,String>>getServiceType(OrderPo po);



	@Select(" SELECT T_HOME_SERVICETYPE.FID 'ItemId',T_HOME_SERVICEITEM.FID ,FServiceItemName,Fprice,Funit FROM T_HOME_SERVICETYPE ,T_HOME_SERVICEITEM  WHERE  T_HOME_SERVICETYPE.FID=T_HOME_SERVICEITEM.FServiceTypeID and T_HOME_SERVICETYPE.Fstatus='1' and T_HOME_SERVICEITEM.Fstatus='1' \n" +
			" and T_HOME_SERVICETYPE.Fnursing_homeID=#{fNursingHomeID} and T_HOME_SERVICEITEM.Fnursing_homeID=#{fNursingHomeID} order by T_HOME_SERVICETYPE.FID ")
	public List<Map<String,String>>getServiceItemName(OrderPo po);
	
	@Select(" SELECT FID,FStaffName FROM T_STAFF_MESSAGE ")
	public List<Map<String,String>>getStaffMessage();
	
	@Select(" select FOrderNo FROM  T_HOME_ORDER where  T_HOME_ORDER.FNursingHomeID=#{fNursingHomeID}")
	public List<Map<String,String>>getForderNo(OrderPo po);

	
	@Select(" select FID FROM T_HOME_ORDER WHERE FOrderNo=#{fOrderNo} ")
	public List<OrderPo> lastFid(OrderPo po);
	
	@Insert(" insert into  T_HOME_ORDER(`FOrderNo`,`FOldManID`,`FRecieveDept`,`FRecieveUser`,`FRecieveTime`,"
			                          + "`FPayStyle`,`FOrderEmergency`,`FDealStatus`,`FServiceObject`,`FCallName`,"
			                          + "`FCallPhone`,`FObjectName`,`FObjectPhone`,`FRequestTime`,`FServiceAdd`,"
			                          + "`FOrderyExplain`,`FOrderType`,`FServiceProvide`,`FServiceUser`,`FServiceType`,"
			                          + "`FServiceItem`,`FPrice`,`FNumber`,`FTotal`,`FNursingHomeID`,"
			                          + "`FCreatorID`,`FCreateTime`,`FFinishTime`,`FEvaluationOrder`) "
                                      + "values ( #{fOrderNo},NULL,#{fRecieveDept},#{fRecieveUser},#{fRecieveTime},"
                                      + "#{fPayStyle},#{fOrderEmergency},#{fDealStatus},#{fServiceObject},#{fCallName},"
                                      + "#{fCallPhone},#{fObjectName},#{fObjectPhone},#{fRequestTime},#{fServiceAdd},"
                                      + "#{fOrderyExplain},#{fOrderType},#{fServiceProvide},#{fServiceUser},#{fServiceTypeid},"
                                      + "#{fServiceItemid},#{fPrice},#{fNumber},#{fTotal},#{fNursingHomeID},"
                                      + "#{fCreatorID},NOW(),NOW(),#{fEvaluationOrder});")
    public void addOrder(OrderPo po);
	
	
	@Update(" update `T_HOME_ORDER` set `FRecieveDept`=#{fRecieveDept},`FRecieveUser`=#{fRecieveUser},`FRecieveTime`=#{fRecieveTime},`FPayStyle`=#{fPayStyle},`FOrderEmergency`=#{fOrderEmergency},`FDealStatus`=#{fDealStatus}, "
			+" `FServiceObject`=#{fServiceObject},`FCallName`=#{fCallName},`FCallPhone`=#{fCallPhone},`FObjectName`=#{fObjectName},`FObjectPhone`=#{fObjectPhone},`FRequestTime`=#{fRequestTime},`FServiceAdd`=#{fServiceAdd}, "
			+" `FOrderyExplain`=#{fOrderyExplain},`FNursingHomeID`=#{fNursingHomeID},`FCreatorID`=#{fCreatorID},`FOrderType`=#{fOrderType},`FServiceProvide`=#{fServiceProvide},`FServiceUser`=#{fServiceUser},`FServiceType`=#{fServiceType},`FServiceItem`=#{fServiceItem},`FPrice`=#{fPrice},`FNumber`=#{fNumber},`FTotal`=#{fTotal} where `FID`=#{fid}")
	public void  updateOrder(OrderPo Po);    
	
	@Update(" UPDATE `T_HOME_ORDER` set `FDealStatus`='禁用' where `FID`=#{fid}")
	public void deleteOrder(OrderPo Po);

	
	@Update(" UPDATE `T_HOME_ORDER` set `FDealStatus`='已完成',`FFinishTime`=#{fFinishTime},`FEvaluationOrder`=#{fEvaluationOrder} where `FID`=#{fid}")
	public void evalOrder(OrderPo po);
	
	
	 class OrderMapper{
	        public String queryOrderMapper(Map<String, Object> params){
	     
	            OrderPo orderPo = (OrderPo) params.get("param");
	            
	            StringBuffer sql=new StringBuffer();
	            sql.append("  SELECT T_HOME_ORDER.FID,FOrderNo,FObjectName,FObjectPhone,FServiceObject,FServiceUser,FDealStatus,FRequestTime,FOrderyExplain,FFinishTime,FEvaluationOrder \n" +
						" ,FPayStyle,FRecieveDept,FRecieveUser,FRecieveTime,FOrderEmergency ,FDealStatus,FServiceObject,FCallName,FCallPhone,FObjectName, \n" +
						" FServiceAdd,FOrderType,FServiceProvide, FServiceUser,FServiceType,FServiceItem,T_HOME_SERVICEITEM.FServiceItemName  ,T_HOME_SERVICEITEM.FPrice, T_HOME_SERVICEITEM.Funit 'Funit',T_HOME_ORDER.FNumber,FTotal\n" +
						" FROM T_HOME_ORDER ,T_HOME_SERVICEITEM  WHERE T_HOME_SERVICEITEM.FID=T_HOME_ORDER.FServiceItem and 1=1  ");
	            if(null == orderPo) {
	                return sql.toString();
	            } else {
                    if(StringUtils.isNotEmpty(orderPo.getfNursingHomeID())){
						sql.append(" and T_HOME_ORDER.FNursingHomeID= '"+ orderPo.getfNursingHomeID()+"'");
					}

					if(StringUtils.isNotEmpty(orderPo.getfOrderNo())){
	                    sql.append(" and FOrderNo = '" + orderPo.getfOrderNo() + "'");
	                }
	                if(StringUtils.isNotEmpty(orderPo.getfObjectName())){
	                    sql.append(" and FObjectName = '" + orderPo.getfObjectName() + "'");
	                }
	                if(StringUtils.isNotEmpty(orderPo.getfObjectPhone())){
	                    sql.append(" and FObjectPhone = '" + orderPo.getfObjectPhone() + "'");
	                }
	                if(StringUtils.isNotEmpty(orderPo.getfServiceObject())){
	                    sql.append(" and FServiceObject = '" + orderPo.getfServiceObject() + "'");
	                    
	                } if(StringUtils.isNotEmpty(orderPo.getfServiceUser())){
	                	sql.append(" and FServiceUser = '" + orderPo.getfServiceUser() + "'");
	                }
	                if(StringUtils.isNotEmpty(orderPo.getfDealStatus())){
	                	sql.append(" and FDealStatus = '" + orderPo.getfDealStatus() + "'");
	                }if(StringUtils.isNotEmpty(orderPo.getStartTime())&&StringUtils.isNotEmpty(orderPo.getOverTime())){
	                	sql.append(" and FRequestTime between '" + orderPo.getStartTime() + "' and '" + orderPo.getOverTime()+ "'");
	                }if(StringUtils.isNotEmpty(orderPo.getStartTime())&&!StringUtils.isNotEmpty(orderPo.getOverTime())){
	                	sql.append(" and FRequestTime > '" + orderPo.getStartTime() +"'");
	                }if(!StringUtils.isNotEmpty(orderPo.getStartTime())&&StringUtils.isNotEmpty(orderPo.getOverTime())){
	                  	sql.append(" and FRequestTime < '" + orderPo.getOverTime() +"'");
	                }
	            }


	            sql.append("  order by FOrderNo desc limit #{page},#{pageSize}");
	            logger.debug("查询订单语句："+sql.toString());
	       
	     
	            return sql.toString();
	        }
	        
	        public String queryCountOrder(Map<String,Object> params){

	            OrderPo orderPo = (OrderPo) params.get("param");
	            
	            StringBuffer sql=new StringBuffer();
	            sql.append(" SELECT count(*) FROM T_HOME_ORDER ,T_HOME_SERVICEITEM  WHERE T_HOME_SERVICEITEM.FID=T_HOME_ORDER.FServiceItem and 1=1  ");
	            if(null == orderPo) {
	                return sql.toString();
	            } else {
					if(StringUtils.isNotEmpty(orderPo.getfNursingHomeID())){
						sql.append(" and T_HOME_ORDER.FNursingHomeID= '"+ orderPo.getfNursingHomeID()+"'");
					}
	                if(StringUtils.isNotEmpty(orderPo.getfOrderNo())){
	                    sql.append(" and FOrderNo = '" + orderPo.getfOrderNo() + "'");
	                }
	                if(StringUtils.isNotEmpty(orderPo.getfObjectName())){
	                    sql.append(" and FObjectName = '" + orderPo.getfObjectName() + "'");
	                }
	                if(StringUtils.isNotEmpty(orderPo.getfObjectPhone())){
	                    sql.append(" and FObjectPhone = '" + orderPo.getfObjectPhone() + "'");
	                }
	                if(StringUtils.isNotEmpty(orderPo.getfServiceObject())){
	                    sql.append(" and FServiceObject = '" + orderPo.getfServiceObject() + "'");
	                    
	                } if(StringUtils.isNotEmpty(orderPo.getfServiceUser())){
	                	sql.append(" and FServiceUser = '" + orderPo.getfServiceUser() + "'");
	                }
	                if(StringUtils.isNotEmpty(orderPo.getfDealStatus())){
	                	sql.append(" and FDealStatus = '" + orderPo.getfDealStatus() + "'");
	                }if(StringUtils.isNotEmpty(orderPo.getStartTime())&&StringUtils.isNotEmpty(orderPo.getOverTime())){
	                	sql.append(" and FRequestTime between '" + orderPo.getStartTime() + "' and '" + orderPo.getOverTime()+ "'");
	                }
	            }
	       
	           
	            logger.debug("查询订单总数："+sql.toString());
	       
	     
	            return sql.toString();
	        }
	 }
	
	 
	 
}
