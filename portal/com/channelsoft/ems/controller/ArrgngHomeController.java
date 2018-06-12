package com.channelsoft.ems.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.channelsoft.ems.po.UserPo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.ArrgngHomePo;
import com.channelsoft.ems.po.RangePo;
import com.channelsoft.ems.service.ArrgngHomeService;

/** 
 * 
 * 员工排房  
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/arrg")
public class ArrgngHomeController {

private Logger logger=Logger.getLogger(ArrgngHomeController.class);
	
	@Autowired
	private ArrgngHomeService arrgngHomeService;
	
	@RequestMapping("/arrg")
	public String gotodataArrgHome(HttpServletRequest request ,HttpServletResponse response){
	
		return "staffArrgngHome/arrgngHomeList";
	}

	/**
	 *  查询房间 分配房间人数  饱和人数 实际人数
	 * @param po
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/query") 
	public AjaxResultPo queryCountSumMan(ArrgngHomePo po, HttpServletRequest request ,HttpServletResponse response){
	  logger.debug("进入查询controller获取个别合计.......");

		List<ArrgngHomePo> list= this.arrgngHomeService.getCountSumMan();

		for(ArrgngHomePo ll:list){
        List<Map<String,String>> list1= this.arrgngHomeService.getCount(ll);

			if(list1.size()!=0){
				ll.setBedSum(String.valueOf(list1.get(0).get("bedSum")));
				ll.setSum(String.valueOf(list1.get(0).get("count")));
				ll.setManSum(String.valueOf(list1.get(0).get("manSum")));

			}else{
				ll.setBedSum("");
				ll.setSum("");
				ll.setManSum(" ");

			}

		}


		return new AjaxResultPo(true, "success", list.size(), list);
		
	}

	/**
	 * 查询所有的房间
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryAllRoom") 
	public AjaxResultPo queryAllRoom( HttpServletRequest request ,HttpServletResponse response){
	  logger.debug("进入查询controller: 获取所有的房间.......");	

	  List<Map<String, String>> list= this.arrgngHomeService.getAllRoom();
		return new AjaxResultPo(true, "success", list.size(), list);
		
	}
	/**
	 * 查询所有的房间和员工对应关系
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRoom") 
	public AjaxResultPo queryRoomByStaffID( HttpServletRequest request ,HttpServletResponse response){
	  logger.debug("进入查询controller: 查询指定的id.......");	

	  List<Map<String, String>> list= this.arrgngHomeService.getRoomByStaffID();

		return new AjaxResultPo(true, "success", list.size(), list);
		
	}

	/**
	 * 查询被占用的房间数  员工对应房间数
	 * @param request
	 * @param response
	 * @return
	 */

	@ResponseBody
	@RequestMapping("/queryHaveBed")
	public AjaxResultPo queryHaveBed( HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入查询controller: 查询指定的id.......");

		List<Map<String, String>> list= this.arrgngHomeService.getHaveNum();

		return new AjaxResultPo(true, "success", list.size(), list);

	}

	/**
	 *查询被占用的房间数  员工对应房间数 具体某一个员工
	 * @param empid
	 * @param request
	 * @param response
	 * @return
	 */

	@ResponseBody
	@RequestMapping("/queryHave")
	public AjaxResultPo queryHave(String empid, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入查询controller: 查询指定的id.......");

		List<Map<String, String>> list= this.arrgngHomeService.getHave(empid);

		return new AjaxResultPo(true, "success", list.size(), list);

	}

	/**
	 * 对护理员工房间 增加或更新
	 * @param request
	 * @param response
	 * @return
	 */


	@ResponseBody
	@RequestMapping("/addRoom") 
	public AjaxResultPo addRoom( HttpServletRequest request ,HttpServletResponse response){
	  logger.debug("进入查询controller: 查询指定的id.......");	
      String empid=request.getParameter("empid");
      
      String nowCheck[]=request.getParameterValues("nowCheck"); 
      String[] now=nowCheck[0].split(",");
      
      List<Map<String,String>> list=this.arrgngHomeService.getStaffIDRoomid(empid);

      String realyRoom[] = new String[list.size()];
      for(int i=0;i<list.size();i++){
    	  realyRoom[i]=String.valueOf(list.get(i).get("FHomeID"));
      }
      String insertID[]=deff(now,realyRoom);
      String def[]=deff(realyRoom,now);
      String idSum="";
      for(int i=0;i<def.length;i++){
    	  idSum+=def[i]+',';
      }
     String idInsert="";
     for(int i=0;i<insertID.length;i++){
    	 idInsert+=insertID[i]+',';
     }
	 //取出登录人员工id  取出养老院id

		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		String houser=user.getOldhouse();
		String creator=user.getEmployId();


     logger.debug("增加房间id:"+idInsert.substring(0,idInsert.length()-1));
     System.out.println(idInsert.substring(0,idInsert.length()-1).equals(""));
     System.out.println(idSum.substring(0,idSum.length()-1).equals(""));
     if(!idInsert.substring(0,idInsert.length()-1).equals("")){
         List<Map<String,String>> list1=this.arrgngHomeService.getStaffIDBuildid(idInsert.substring(0,idInsert.length()-1));
         String buildId[] = new String[list1.size()];
         for(int i=0;i<list1.size();i++){
       	  buildId[i]=String.valueOf(list1.get(i).get("FBuildingID"));   
       	}
     	if(this.arrgngHomeService.insertArrngHome(buildId, insertID, empid,houser,creator)==0){
       		logger.debug("更新成功");
     }
     }
     if(!idSum.substring(0,idSum.length()-1).equals("")){
    		if(this.arrgngHomeService.deleteRoom(idSum.substring(0,idSum.length()-1),empid)==0){
    			logger.debug("删除成功");
    		}
     }   
		logger.debug("更新房间成功");
		return new AjaxResultPo(true, "success");
       
   
		
	}

	/**
	 *  判断出需要批量增加  批量删除的房间
	 * @param str
	 * @param str1
	 * @return
	 */

	public String[] deff(String[] str,String[] str1){
		StringBuffer sb=new StringBuffer("");
		int flag=0;
		for(int i=0;i<str.length;i++){
			for(int j=0;j<str1.length;j++){
				if(!str[i].equals(str1[j])){
					flag++;
				}
			}
			if(flag==str1.length){
				sb.append(str[i]);
				if(i!=str.length-1){
					sb.append(",");
				}
			}
			flag=0;
		}
		String[] result=sb.toString().split(",");
		return result;
	}
	
	
}
