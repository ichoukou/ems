package com.channelsoft.ems.mapper;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import com.channelsoft.ems.po.ArrgngHomePo;
import com.channelsoft.ems.po.RangePo;


/** 
 * 
 * 员工排房  
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
public interface ArrgngHomeMapper {


	
	
	
	//安排分房间 总房间
	@Select(" select T_BUILDING.FID Buid, FBuildingName BuName,FFLoorName floorName,FRoomNumber floorNumber ,FRoomName  fRoomName ,FRoomType floorType ,T_ROOM.FID Roomid,"
			+ "T_ROOM.FBedCount bedCount,T_ROOM.FManNumber manNum from T_FLOOR,T_BUILDING,T_ROOM  where T_BUILDING.FID=T_FLOOR.FBuildingID  and T_ROOM.FBuildingID=T_BUILDING.FID and T_ROOM.FFLoorID=T_FLOOR.FID  order by Buid, T_FLOOR.FFLoorName, T_ROOM.FRoomName")
	public List<Map<String,String>> getAllRoom();
	
	@Select(" select T.BuildID,t2.FDepartmentName,t1.FID,t1.FStaffName, T.BuName ,T.floorName ,T.floorNumber,T.floorType,T.Roomid from "
			 +" (select T_ROOM.FBuildingID BuildID ,FBuildingName BuName,FFLoorName floorName,FRoomNumber floorNumber ,FRoomType floorType ,T_ROOM.FID Roomid from T_FLOOR,T_BUILDING,T_ROOM " 
			 +" where T_BUILDING.FID=T_FLOOR.FBuildingID  and T_ROOM.FBuildingID=T_BUILDING.FID "
			 +" and T_ROOM.FFLoorID=T_FLOOR.FID )as T ,T_STAFF_MESSAGE t1, T_DEPARTMENT t2 ,T_ARRGNG_HOME t3 where t2.FID=t1.FDepartmentID and t3.FStaffID=t1.FID and T.Roomid =t3.FHomeID")
	
    @Results(value = {
            @Result(column = "BuildID", property = "fBuildingID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FDepartmentName", property = "fDepartmentName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "FID", property = "fStaffID", javaType = String.class, jdbcType = JdbcType.INTEGER),
            @Result(column = "FStaffName", property = "fStaffName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "BuName", property = "fBuildingName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "floorName", property = "floorName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "floorNumber", property = "floorNumber", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "floorType", property = "floorType", javaType = String.class, jdbcType = JdbcType.VARCHAR),
            @Result(column = "Roomid", property = "fHomeID", javaType = String.class, jdbcType = JdbcType.INTEGER)})
	public List<ArrgngHomePo> getAssHome();

	
	//查询 护理员对应大厦和
	@Select("   select SS.* ,TT.FBuildingName ,TT.FStatus from (select concat(T.DNAME,'-',S.FStaffName) 'admin', S.FID ,S.FBuildingID 'FBuildingID' from T_STAFF_MESSAGE S,( select FID 'DID',FDepartmentName 'DNAME' from T_DEPARTMENT where FAttribute='护理' and FStatus='Y' )\n" +
			" T WHERE S.FDepartmentID=T.DID  ) SS,T_BUILDING TT WHERE SS.FBuildingID=TT.FID and TT.FStatus='11' ")
	@Results(value = {
			@Result(column = "FBuildingID", property = "fBuildingID", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column = "FID", property = "fStaffID", javaType = String.class, jdbcType = JdbcType.INTEGER),
			@Result(column = "FNursinghome", property = "fDepartmentName", javaType = String.class, jdbcType = JdbcType.VARCHAR),
			@Result(column = "admin", property = "fStaffName", javaType = String.class, jdbcType = JdbcType.VARCHAR)
		})
    public List<ArrgngHomePo> getCountSumMan();

	//根据不同员工查询出指定的
	@Select(" SELECT * FROM (select  T.FStaffID 'AFID' ,count(*) 'count' from T_ARRGNG_HOME T where T.FStaffID=#{fStaffID} ) A ,(SELECT * FROM (select  t8.FStaffID FID ,sum(T.FBedCount) 'bedSum',sum(T.FManNumber) 'manSum' from T_ROOM T, T_ARRGNG_HOME t8 where T.FID=t8.FHomeID group by t8.FStaffID\n" +
			") S  where S.FID=#{fStaffID}  ) B WHERE A.AFID=B.FID ")
	public List<Map<String,String>> getCount(ArrgngHomePo po);

	@SelectProvider(type=ArrgHomeProvider.class,method="insertStaffidBuild")
	public void insertArrngHome(@Param("buildId") String[]buildId,@Param("insertID") String insertID[],@Param("empid")String empid,@Param("houser")String houser,@Param("creator")String creator);

	//查询指定的管理员管理的房间  显示出来的房间
    @Select(" select T_ARRGNG_HOME.FStaffID, T_ROOM.FBuildingID BuildID ,FBuildingName BuName,FFLoorName floorName,FRoomNumber floorNumber , FRoomName  fRoomName ,FRoomType floorType ,FBedCount fbedCount,FManNumber fmanNumber,T_ROOM.FID Roomid from T_FLOOR,T_BUILDING,T_ROOM ,T_ARRGNG_HOME"
			+" where T_BUILDING.FID=T_FLOOR.FBuildingID  and T_ROOM.FBuildingID=T_BUILDING.FID  "
			+" and T_ROOM.FFLoorID=T_FLOOR.FID and T_ARRGNG_HOME.FHomeID=T_ROOM.FID order by T_ARRGNG_HOME.FStaffID,T_ROOM.FBuildingID,FRoomNumber+0,FRoomName+0")
    public List <Map<String,String>> getRoomByStaffID();


    //查询管理员对应的 房间id
    @Select(" select FHomeID from  T_ARRGNG_HOME where FStaffID=#{empid} ")
    public List<Map<String,String>> getStaffIDRoomid(String empid);
    
    
    //删除管理员指定房间
    @Delete(" DELETE  FROM T_ARRGNG_HOME WHERE FStaffID=#{empid} AND FHomeID IN(${idSum})")//2,3,4
	public void deleteRoom(@Param("idSum") String idSum,@Param("empid") String empid);
    
    //查出增加的房间指定的大厦编号
    @Select(" select FBuildingID from  T_ROOM where FID IN (${idInsert})  ")
    public List<Map<String,String>> getStaffIDBuildid(@Param("idInsert") String idInsert);
    
    
    //批量插入

	class ArrgHomeProvider{
			
	public String insertStaffidBuild(Map<String,Object> params){
		//@Param("buildId") String[]buildId,@Param("insertID") String insertID[],@Param("empid")String empid
		String[]buildId=(String[])params.get("buildId");
		String[]insertID=(String[])params.get("insertID");
		String empid=(String)params.get("empid");
		String houser=(String)params.get("houser");
		String creator=(String)params.get("creator");

		StringBuffer sql=new StringBuffer("insert into  T_ARRGNG_HOME(`FNUMBER`,`FStaffID`,`FHomeID`,`FNursinghomeID`,`FBuildingID`,`FDate`,`FCreatorID`,`FCreateTime`) values  ");
	   
		for(int i=0;i<buildId.length;i++){			
				sql.append( " (").append("'AA5'").append(",").append("'"+empid+"'").append(",'"+insertID[i]+"'").append(",").append("'"+houser+"',").append("'"+buildId[i]+"'").append(",now(),'"+creator+"',now()").append(") ");
				if(i==buildId.length-1){
					sql.append(";");
				}else{
					sql.append(",");
				}
		
			
			
		}
		System.out.println(sql.toString());
		return sql.toString();
	
	}
   }


   @Select(" SELECT T_ROOM.FID,sum(case when T_BED.FStatus='11' then 1 else 0 end) as 'num' FROM T_ROOM,T_BED WHERE T_ROOM.FID=T_BED.FRoomID GROUP BY T_BED.FRoomID\n ")
   public List<Map<String,String>> getHaveNum();


	@Select(" SELECT F.TID ,sum(case when F.STATUS='11' then 1 else 0 end) 'sum' FROM (select T.FStaffID 'TID' ,T.FHomeID ,  B.FStatus 'STATUS' FROM T_BED B, T_ARRGNG_HOME T where T.FStaffID=#{empid} AND B.FRoomID=T.FHomeID) F  GROUP BY F.TID\n ")
	public List<Map<String,String>> getHave(@Param("empid") String empid);
}
    
    
    
    
    

