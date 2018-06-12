package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import com.channelsoft.ems.po.*;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

import com.channelsoft.ems.mapper.OrderManageMapper.OrderMapper;

/** 
 *  物品入库
 * @author  wuhl
 * @date 创建时间：2016年11月13日 上午16:13:41 
 * @parameter  
 * @return  
 */
public interface InStorageMapper {
	/*insert into `T_IN_STORAGE`(`FNumber`,`FNursingHomeID`,`FInStorageDate`,`FOperatorID`,`FExplain`,`FCreatorID`,`FCreateTime`) values ( '1','2',NOW(),'3','sdad',NULL,NULL,'3',now());


	insert into `T_IN_STORAGE_ENTRY`(`FStoreID`,`FQty`,`FPrice`,`FRemarks`,`FMaterialID`,`Famount`,`FParentID`,`FStoremanID`) values ( '4','11','0','订单','3','0','3','12');


	insert into `STOCK_ACCOUNT`(`FNnumber`,`FNursingHomeID`,`FStorageID`,`FMaterialID`,`FStockAmount`,`FStandard`) values ( 'qqq','4','5','2','50','50张/本');

	update `STOCK_ACCOUNT` set `FStockAmount`='50' where `FID`='8';

	select count(*) from STOCK_ACCOUNT where FStorageID='2' and  FMaterialID='2'*/


	public static Logger logger=Logger.getLogger(InStorageMapper.class);


       //insert into `T_IN_STORAGE`(`FNumber`,`FNursingHomeID`,`FInStorageDate`,`FOperatorID`,`FExplain`,`FCreatorID`,`FCreateTime`) values ( '1','2',NOW(),'3','sdad',NULL,NULL,'3',now());

	   //插入主表
	    @Insert(" insert into `T_IN_STORAGE`(`FNumber`,`FNursingHomeID`,`FInStorageDate`,`FOperatorID`,`FExplain`,`FCreatorID`,`FCreateTime`) values ( #{fNumber},#{fNursingHomeID},#{fInStorageDate},#{fOperatorID},#{fExplain},#{fCreatorID},NOW()) ")
	    public void insertInStorgage(InStoragePo po);
       //获取主表最新插入数据
	    @Select("select max(FID) from T_IN_STORAGE ")
	    public int  getInStorageInsertID();
	   //插入字表
	   @InsertProvider(type = InStorage.class,method = "insertInStorageEntry")
	    public void insertInStorageEntry(@Param("list") List<InStoragePo> list);

	    //查出是否重复
	    @Select( " select count(*) 'NUM',FID ,FStockAmount  from STOCK_ACCOUNT where FStorageID=#{fStoreID} and FMaterialID=#{fMaterialID} ")
		public List<Map<String,String>> getDistictStick(InStoragePo po);
       //更新库存表
	    @Update(" update `STOCK_ACCOUNT` set `FStockAmount`=#{fQty} where `FID`=#{fid} ; ")
		public  void  updateStockAccout(InStoragePo po);
	  //插入库存表
		@Insert(" insert into `STOCK_ACCOUNT`(`FNnumber`,`FNursingHomeID`,`FStorageID`,`FMaterialID`,`FStockAmount`,`FStandard`) values ( 'qqq',#{fNursingHomeID},#{fStoreID},#{fMaterialID},#{fQty},#{fStandard}); ")
        public void insertStockAccout(InStoragePo po);

	   //获取现有仓库
	  @Select(" SELECT T1.FID,T1.FStoreHouseName,T2.FID 'Staffid',T2. FStaffName FROM T_STOREHOUSE T1 ,T_STAFF_MESSAGE T2 WHERE T1.FStoremanID=T2.FID ")
	  public List<Map<String ,String>>getHouse();


       @Select(" SELECT  distinct FStandard FROM T_MATERIAL ")
       public List<Map<String,String>> getFStandard();
     
       @Select("  SELECT FMaterialName FROM T_MATERIAL ")
       public List<Map<String,String>> getFMaterialName();
   
       @Select("  SELECT FStoreHouseName FROM T_STOREHOUSE ")
       public List<Map<String,String>> getFStoreHouseName();
     
     //查询一次入库的物品种类
     @Select("  select T1.* , T2.FMaterialName ,T2.FUnit from T_IN_STORAGE_ENTRY AS T1 , T_MATERIAL AS T2 WHERE T2.FID=T1.FMaterialID AND T1.PID='IN1213' ")
     public List<Map<String,String>> getSonMaterial();
     
    @SelectProvider(type=InStorage.class,method = "queryInStorage")
 	public List<InStoragePo> queryInStorage(@Param("param") InStoragePo param,@Param(value="page") int page,@Param(value="pageSize") int pageSize);

    @SelectProvider(type=InStorage.class,method = "queryInStorageCount")
    public int queryInStorageCount(@Param("param") InStoragePo param);

    @Delete("  delete  from T_IN_STORAGE_ENTRY where FID=#{fid} ")
    public void deleteStorage_entry( InStoragePo po);

	@Delete("  delete  from T_IN_STORAGE_ENTRY where FParentID=#{fid} ")
	public void deleteStorage_entryByFather( InStoragePo po);

    @Delete("  delete  from T_IN_STORAGE where FID=#{fid} ")
    public void deleteStorage( InStoragePo po);

    @Update(" update `T_IN_STORAGE` SET `FInStorageDate`=#{fInStorageDate} ,FNursingHomeID=#{fNursingHomeID},`FOperatorID`=#{fOperatorID},FCreatorID=#{fCreatorID},`FExplain`=#{fExplain}  where `FID`=#{fid} ")
	public  void  updateStock(InStoragePo po);


	//查询指定单号的字表数据

	@Select("  SELECT T6.*,T7.FStaffName 'FOperatorName' FROM  "
			+ "  (SELECT T5.FExplain , T5.FID 'Fatherid',T5.FNumber 'FNumber',T5.FInStorageDate 'FInStorageDate',T5.FOperatorID 'FOperatorID',T1.*,T2.FStoreHouseName 'FStoreHouseName' , "
			+ "  T3.FMaterialName , T3.FStandard 'FStandard',T4.FStaffName 'FStoreName'FROM T_IN_STORAGE_ENTRY T1,T_STOREHOUSE T2 ,T_MATERIAL T3 ,T_STAFF_MESSAGE T4 , "
			+ "  T_IN_STORAGE T5 WHERE T1.FStoreID =T2.FID AND T3.FID=T1.FMaterialID AND T4.FID=T1.FStoremanID AND T5.FID=T1.FParentID  "
			+ "  )T6,T_STAFF_MESSAGE T7 WHERE T7.FID=T6.FOperatorID  and Fatherid=#{fatherid} " )
	public List<Map<String,String>> getUpdateAllMaterial(InStoragePo po);


	//获取物资类型
	@SelectProvider(type=InStorage.class,method = "queryStorageGoodsManagement")
	@Results(value = {
			@Result(column = "FID", property = "id", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column = "FMaterialName", property = "material", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "typeID", property = "materialTypeID", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column = "FStandard", property = "standrad", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FUnit", property = "unit", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "FRemarks", property = "remark", javaType = String.class, jdbcType = JdbcType.VARCHAR),
	})
	public List<StockMaterialPo> getAllFMaterial(@Param("param") StockMaterialPo po, @Param("page") int page, @Param("pageSize") int pageSize);

	@SelectProvider(type=InStorage.class,method = "queryStorageGoodsManagementCount")
	public int getAllFMaterialCount(@Param("param") StockMaterialPo po);

	class InStorage{
	        public String queryInStorage(Map<String, Object> params){
	     
	        	InStoragePo inPo = (InStoragePo) params.get("param");
	            
	            StringBuffer sql=new StringBuffer();
	            sql.append(" SELECT T6.*,T7.FStaffName 'FOperatorName' FROM  "
	            		+ "  (SELECT T5.FID 'Fatherid',T5.FNumber 'FNumber',T5.FInStorageDate 'FInStorageDate',T5.FOperatorID 'FOperatorID',T1.*,T2.FStoreHouseName 'FStoreHouseName' , "
	            		+ "  T3.FMaterialName , T3.FStandard 'FStandard',T4.FStaffName 'FStoreName'FROM T_IN_STORAGE_ENTRY T1,T_STOREHOUSE T2 ,T_MATERIAL T3 ,T_STAFF_MESSAGE T4 , "
	            		+ "  T_IN_STORAGE T5 WHERE T1.FStoreID =T2.FID AND T3.FID=T1.FMaterialID AND T4.FID=T1.FStoremanID AND T5.FID=T1.FParentID  "
	            		+ "  )T6,T_STAFF_MESSAGE T7 WHERE T7.FID=T6.FOperatorID  ");
	         
	            if(null == inPo) {
	                return sql.toString();
	            } else {
	                if(StringUtils.isNotEmpty(inPo.getfStandard())){
	                    sql.append(" and T6.FStandard = '" + inPo.getfStandard() + "'");
	                }
	                if(StringUtils.isNotEmpty(inPo.getfNumber())){
	                	
	                    sql.append(" and FNumber = '" + inPo.getfNumber() + "'");
	                }
	                if(StringUtils.isNotEmpty(inPo.getfMaterialName())){
	                    sql.append(" and  T6.FMaterialName = '" + inPo.getfMaterialName() + "'");
	                }
	                if(StringUtils.isNotEmpty(inPo.getfStoreHouseName())){
	                    sql.append(" and  T6.FStoreHouseName = '" + inPo.getfStoreHouseName() + "'");

	                }if(StringUtils.isNotEmpty(inPo.getStart())&&StringUtils.isNotEmpty(inPo.getFinish())){
	                	sql.append(" and T6.FInStorageDate between '" + inPo.getStart()+ "' and '" + inPo.getFinish()+ "'");
	                }if(StringUtils.isNotEmpty(inPo.getStart())&&!StringUtils.isNotEmpty(inPo.getFinish())){
	                	sql.append(" and T6.FInStorageDate > '" + inPo.getStart() +"'");
	                }if(!StringUtils.isNotEmpty(inPo.getStart())&&StringUtils.isNotEmpty(inPo.getFinish())){
	                  	sql.append(" and T6.FInStorageDate < '" + inPo.getFinish() +"'");
	                }	                	          
	            }

	       
	            sql.append("  order by T6.FNumber desc limit #{page},#{pageSize}");
	            logger.debug("查询仓库语句："+sql.toString());
	       
	     
	            return sql.toString();
	        }
	        
	   	    public String queryInStorageCount(Map<String,Object> params){

	        	InStoragePo inPo = (InStoragePo) params.get("param");
	               
	               StringBuffer sql=new StringBuffer();
	               sql.append(" SELECT count(*) FROM  "
		            		+ "  (SELECT T5.FID 'Fatherid',T5.FNumber,T5.FInStorageDate 'FInStorageDate',T5.FOperatorID 'FOperatorID',T1.*,T2.FStoreHouseName 'FStoreHouseName' , "
		            		+ "  T3.FMaterialName , T3.FStandard 'FStandard',T4.FStaffName 'FStoreName'FROM T_IN_STORAGE_ENTRY T1,T_STOREHOUSE T2 ,T_MATERIAL T3 ,T_STAFF_MESSAGE T4 , "
		            		+ "  T_IN_STORAGE T5 WHERE T1.FStoreID =T2.FID AND T3.FID=T1.FMaterialID AND T4.FID=T1.FStoremanID AND T5.FID=T1.FParentID  "
		            		+ "  )T6,T_STAFF_MESSAGE T7 WHERE T7.FID=T6.FOperatorID ");
		         
	               if(null == inPo) {
	                   return sql.toString();
	               } else {
	            	   if(StringUtils.isNotEmpty(inPo.getfStandard())){
		                    sql.append(" and T6.FStandard = '" + inPo.getfStandard() + "'");
		                }
		                if(StringUtils.isNotEmpty(inPo.getfNumber())){
		                	
		                    sql.append(" and FNumber = '" + inPo.getfNumber() + "'");
		                }
		                if(StringUtils.isNotEmpty(inPo.getfMaterialName())){
		                    sql.append(" and  T6.FMaterialName = '" + inPo.getfMaterialName() + "'");
		                }
		                if(StringUtils.isNotEmpty(inPo.getfStoreHouseName())){
		                    sql.append(" and  T6.FStoreHouseName = '" + inPo.getfStoreHouseName() + "'");

		                }if(StringUtils.isNotEmpty(inPo.getStart())&&StringUtils.isNotEmpty(inPo.getFinish())){
		                	sql.append(" and T6.FInStorageDate between '" + inPo.getStart()+ "' and '" + inPo.getFinish()+ "'");
		                }if(StringUtils.isNotEmpty(inPo.getStart())&&!StringUtils.isNotEmpty(inPo.getFinish())){
		                	sql.append(" and T6.FInStorageDate > '" + inPo.getStart() +"'");
		                }if(!StringUtils.isNotEmpty(inPo.getStart())&&StringUtils.isNotEmpty(inPo.getFinish())){
		                  	sql.append(" and T6.FInStorageDate < '" + inPo.getFinish() +"'");
		                }	                	          
	                   
	                   
	                   
	               }
	           
	              logger.debug("查询仓库总数："+sql.toString());
	       
	     
	            return sql.toString();
	           }

	        public String queryStorageGoodsManagement(Map<String,Object> params){

				StockMaterialPo inPo = (StockMaterialPo) params.get("param");

				StringBuffer sql=new StringBuffer();
				sql.append(" SELECT FID,FCategoryID,FMaterialName,FStandard,FUnit,FRemarks FROM T_MATERIAL WHERE 1=1 and T_MATERIAL.FStatus='1'");

				if(null == inPo) {
					return sql.toString();
				} else {
					if(StringUtils.isNotEmpty(inPo.getMaterial())){
						sql.append(" and FMaterialName = '" + inPo.getMaterial() + "'");
					}
					if(StringUtils.isNotEmpty(inPo.getMaterialTypeID())){

						sql.append(" and FCategoryID in " + inPo.getMaterialTypeID() );

					}
				}

				sql.append("   limit #{page}  , #{pageSize} ");
				logger.debug("查询物资总数："+sql.toString());
				return sql.toString();
			}

		    public String queryStorageGoodsManagementCount(Map<String,Object> params){

				StockMaterialPo inPo = (StockMaterialPo) params.get("param");

				StringBuffer sql=new StringBuffer();
				sql.append(" SELECT count(*) FROM T_MATERIAL WHERE 1=1 and T_MATERIAL.FStatus='1' ");

				if(null == inPo) {
					return sql.toString();
				} else {
					if(StringUtils.isNotEmpty(inPo.getMaterial())){
						sql.append(" and FMaterialName = '" + inPo.getMaterial() + "'");
					}
					if(StringUtils.isNotEmpty(inPo.getMaterialTypeID())){

						sql.append(" and FCategoryID in " + inPo.getMaterialTypeID() );

					}
				}
				logger.debug("查询物资种类："+sql.toString());
				return sql.toString();
			}

			//批量插入物品入库字表
			public String insertInStorageEntry(Map<String, Object> params){
				List<InStoragePo> list = (List<InStoragePo>) params.get("list");
				logger.debug(list.toString());
				StringBuffer sql=new StringBuffer();
				sql.append(" insert into `T_IN_STORAGE_ENTRY`(`FStoreID`,`FQty`,`FPrice`,`FRemarks`,`FMaterialID`,`Famount`,`FParentID`,`FStoremanID`) values");
				for (InStoragePo po:list) {

                 sql.append("('"+po.getfStoreID()+"','"+po.getfQty()+"','0','"+po.getfRemarks()+"','"+po.getfMaterialID()+"','0','"+po.getFatherid()+"','"+po.getfStoremanID()+"'),");

				}
				String sqll=sql.substring(0,(sql.length()-1));
				logger.debug(sqll);
				return sqll;
			}
	         }	    
}
