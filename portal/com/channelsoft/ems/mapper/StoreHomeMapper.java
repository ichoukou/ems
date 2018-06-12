package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import com.channelsoft.ems.po.StoreHousePo;

/** 
 * 
 * 仓库管理
 * @author  wuhl
 * @date 创建时间：2016年12月26日 下午19:13:41 
 * @parameter  
 * @return  
 */
public interface StoreHomeMapper {
	
    public static Logger logger=Logger.getLogger(StoreHomeMapper.class);

	 @SelectProvider(type=HomeMapper.class,method = "queryHomeMapper")
		@Results(value = {  
				@Result(column="FID",property="fid",javaType=String.class,jdbcType=JdbcType.INTEGER),
				@Result(column="FNursingHomeID",property="fNursingHomeID",javaType=String.class,jdbcType=JdbcType.VARCHAR),	
				@Result(column="FStoreHouseNumber",property="fStoreHouseNumber",javaType=String.class,jdbcType=JdbcType.VARCHAR),
				@Result(column="FStoreHouseName",property="fStoreHouseName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
				@Result(column="FStoremanID",property="fStoremanID",javaType=String.class,jdbcType=JdbcType.INTEGER),
				@Result(column="FStaffName",property="fStoremanName",javaType=String.class,jdbcType=JdbcType.VARCHAR),
				@Result(column="FTel",property="fTel",javaType=String.class,jdbcType=JdbcType.VARCHAR),
				@Result(column="FAddress",property="fAddress",javaType=String.class,jdbcType=JdbcType.VARCHAR),
				@Result(column="FRemarks",property="fRemarks",javaType=String.class,jdbcType=JdbcType.VARCHAR),

		        }) 
		public List<StoreHousePo> queryStoreHouse(@Param("param") StoreHousePo param,@Param(value="page") int page,@Param(value="pageSize") int pageSize);
		
	    @SelectProvider(type=HomeMapper.class,method = "queryHomeCount")
	    public int queryStoreCount(@Param("param") StoreHousePo param);

	    @Insert(" insert into `T_STOREHOUSE`(`FNursingHomeID`,`FStoreHouseNumber`,`FStoreHouseName`,`FStoremanID`,`FTel`,`FAddress`,`FRemarks`) "
	          +"values ( #{fNursingHomeID},#{fStoreHouseNumber},#{fStoreHouseName},#{fStoremanID},#{fTel},#{fAddress},#{fRemarks})")
	    public void addStoretHome(StoreHousePo po);
	    
	    @Update("  update `T_STOREHOUSE` set `FStoreHouseNumber`=#{fStoreHouseNumber},FNursingHomeID=#{fNursingHomeID},`FStoreHouseName`=#{fStoreHouseName},`FStoremanID`=#{fStoremanID},`FTel`=#{fTel},`FAddress`=#{fAddress},`FRemarks`=#{fRemarks} where `FID`=#{fid} ")
        public void updateStoreHome(StoreHousePo po);    
	
	    class HomeMapper{
	        public String queryHomeMapper(Map<String, Object> params){
	     
	        	StoreHousePo homePo = (StoreHousePo) params.get("param");
	            
	            StringBuffer sql=new StringBuffer();
	            sql.append(" select T1.FID ,T1.FNursingHomeID,T1.FStoreHouseNumber,T1.FStoreHouseName,T1.FStoremanID, T2.FStaffName ,T1.FTel,T1.FAddress,T1.FRemarks FROM T_STOREHOUSE T1 ,T_STAFF_MESSAGE T2 WHERE T1.FStoremanID=T2.FID ");
	            if(null == homePo) {
	                return sql.toString();
	            } else {
	                if(StringUtils.isNotEmpty(homePo.getfStoreHouseName())){
	                    sql.append(" and FStoreHouseName = '" + homePo.getfStoreHouseName() + "'");
	                }
	                if(StringUtils.isNotEmpty(homePo.getfStoremanID())){
	                    sql.append(" and FStoremanID = '" + homePo.getfStoremanID() + "'");
	                }
	                if(StringUtils.isNotEmpty(homePo.getfTel())){
	                    sql.append(" and T1.FTel = '" + homePo.getfTel() + "'");
	                }
	                
	            }
	       
	            sql.append("    order by FStoreHouseNumber desc  limit #{page},#{pageSize}");
	            logger.debug("查询仓库语句："+sql.toString());
	       
	     
	            return sql.toString();
	        }
	        
	        

	   	 public String queryHomeCount(Map<String,Object> params){

	   		   	StoreHousePo homePo = (StoreHousePo) params.get("param");
	               
	               StringBuffer sql=new StringBuffer();
	               sql.append(" select count(*) FROM T_STOREHOUSE T1 ,T_STAFF_MESSAGE T2 WHERE T1.FStoremanID=T2.FID ");
	               if(null == homePo) {
	                   return sql.toString();
	               } else {
	                   if(StringUtils.isNotEmpty(homePo.getfStoreHouseName())){
	                       sql.append(" and FStoreHouseName = '" + homePo.getfStoreHouseName() + "'");
	                   }
	                   if(StringUtils.isNotEmpty(homePo.getfStoremanID())){
	                       sql.append(" and FStoremanID = '" + homePo.getfStoremanID() + "'");
	                   }
	                   if(StringUtils.isNotEmpty(homePo.getfTel())){
	                       sql.append(" and T1.FTel = '" + homePo.getfTel() + "'");
	                   }
	                   
	               }
	           
	              logger.debug("查询仓库总数："+sql.toString());
	       
	     
	            return sql.toString();
	           }
	         }
	    
	        }
 
