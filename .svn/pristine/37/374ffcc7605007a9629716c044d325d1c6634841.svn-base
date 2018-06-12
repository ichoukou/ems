package com.channelsoft.ems.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import com.channelsoft.ems.po.*;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.channelsoft.ems.service.StorageGoodsService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.service.InStorageService;
/** 
 * 
 * 物品入库
 * @author  wuhl
 * @date 创建时间：2016年12月8日 下午16:13:41 
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/InStorage")
public class InStorageController {

	private static Logger logger = Logger.getLogger(OrderManageController.class);
	private static String poType;
	@Autowired
	 private InStorageService inStorageService;

	@Autowired
	 private StorageGoodsService storageGoodsService;
	@RequestMapping("/inStorage")
	public String gotodataOrderManager(HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入后端跳转到显示页");

		return "InStorage/InStorageList";
	}
	
	/** 
	 * 
	 * 查询入库单据
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/query") 
	public AjaxResultPo queryInStorage( InStoragePo po,int page,int pageSize,HttpServletRequest request ,HttpServletResponse response)throws UnsupportedEncodingException {
	    logger.debug("进入queryInStorage查询物料信息......");

        po.setfNumber(new String(po.getfNumber().getBytes("ISO-8859-1"), "utf-8"));
        po.setfMaterialName(new String(po.getfMaterialName().getBytes("ISO-8859-1"), "utf-8"));
		po.setfStoreHouseName(new String(po.getfStoreHouseName().getBytes("ISO-8859-1"), "utf-8"));
		po.setfStandard(new String(po.getfStandard().getBytes("ISO-8859-1"), "utf-8"));
		List<InStoragePo> list=this.inStorageService.queryInStorage(po, page, pageSize);
     
	    int count=this.inStorageService.queryInStorageCount(po);
	    return new AjaxResultPo(true, "success", count, list);
	}

	/** 
	 *   查询物品
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/queryList")
	public AjaxResultPo queryList( InStoragePo po,int page,int pageSize,HttpServletRequest request ,HttpServletResponse response) {
		logger.debug("进入查询物料信息......");


		List<InStoragePo> list=this.inStorageService.queryInStorage(po, page, pageSize);

		int count=this.inStorageService.queryInStorageCount(po);
		return new AjaxResultPo(true, "success", count, list);
	}

	/** 
	 * 
	 * 查询物品种类 
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/queryFMaterialName") 
	public AjaxResultPo queryFMaterialName( HttpServletRequest request ,HttpServletResponse response){
	    logger.debug("进入查询物料信息......");          
	    List<Map<String,String>> list=this.inStorageService.getFMaterialName();
	   
	    return new AjaxResultPo(true, "success", list.size(), list);
	}
	
	
	/** 
	 * 
	 * 查询物仓库保管员 
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/queryFStoreHouseName") 
	public AjaxResultPo queryFStoreHouseName(HttpServletRequest request ,HttpServletResponse response){
	    logger.debug("进入查询仓库名称信息......");
	    List<Map<String,String>> list=  this.inStorageService.getFStoreHouseName();
	    
		return new AjaxResultPo(true, "success", list.size(), list);
	}
	
	/** 
	 * 
	 * 进入查询标准信息 
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/queryFStandard") 
	public AjaxResultPo queryFStandard( HttpServletRequest request ,HttpServletResponse response){
	    logger.debug("进入查询标准信息......");
	    List<Map<String,String>> list = this.inStorageService.getFStandard();     
	   
	    return new AjaxResultPo(true, "success", list.size(), list);
	}
	/** 
	 * 
	 * 查询仓库信息
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/queryGetHouse")
	public AjaxResultPo queryGetHouse(HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入查询仓库信息......");

		List<Map<String,String>> list=this.inStorageService.getHouse();

	   return new AjaxResultPo(true, "success", list.size(), list);
	}

	/** 
	 * 
	 * 更新仓库的种类
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/getUpdateAllMaterial")
	public AjaxResultPo getUpdateAllMaterial(InStoragePo po,HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入查询仓库信息......");

		List<Map<String,String>> list=this.inStorageService.getUpdateAllMaterial(po);

		return new AjaxResultPo(true, "success", list.size(), list);
	}

	/** 
	 * 
	 * 查询子节点的物料
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/querySonMaterial")
	public AjaxResultPo querySonMaterial(StockMaterialPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
		logger.debug("进入查询标准信息......");

		if(StringUtils.isNotEmpty(po.getMaterialTypeID()))
		{
			List<StorageGoodsSortingPo> listFirst= new ArrayList<StorageGoodsSortingPo>();
			listFirst = storageGoodsService.getStorageGoodsSortingTypeList("");
			poType="(0";
			getType(listFirst,po.getMaterialTypeID());
			poType=poType+")";
			po.setMaterialTypeID(poType);
		}

		List<StockMaterialPo> list=this.inStorageService.getAllFMaterial(po,page,pageSize);

		logger.debug("查询出相应物品数量....");
		int  count=this.inStorageService.getAllFMaterialCount(po);


		return new AjaxResultPo(true, "success", count, list);
	}

	public static void getType(List<StorageGoodsSortingPo> list,String type){
		poType=poType+","+type;
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getFatherID().equals(type))
			{
				getType(list,list.get(i).getId());
			}
		}
	}

	/** 
	 * 增加物品 入库单
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/addInStorage")
	public AjaxResultPo addOrder(InStoragePo po, String inStorageEntrySql,String stockAccountSql,HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入addOrder()......");
		logger.debug("请求参数: "+ po.toString());
		logger.debug("主表参数"+po);
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfNursingHomeID(user.getOldhouse());
		po.setfCreatorID(user.getEmployId());
		String fNursingHomeID=user.getOldhouse();
        String fCreatorID=user.getEmployId();

		String[] str;

      //仓库id  数量  备注  物料id  保管员id
		List<InStoragePo> list =new ArrayList<InStoragePo>();
		String[] strlist=inStorageEntrySql.split("_");
		InStoragePo po2;
		for(int i=1;i<strlist.length;i++){
			po2=new InStoragePo();
			str=strlist[i].split("=");
			po2.setfStoreID(str[0]);
			po2.setfQty(str[1]);
			po2.setfRemarks(str[2]);
			po2.setfMaterialID(str[3]);
			po2.setfStoremanID(str[4]);
			po2.setfNursingHomeID(fNursingHomeID);
			po2.setfCreatorID(fCreatorID);
			list.add(po2);
		}

		//仓库id  物料id 数量 规格
		List<InStoragePo> list1 =new ArrayList<InStoragePo>();
		String[] strlist1=stockAccountSql.split("_");
		InStoragePo po3;
		for(int i=1;i<strlist.length;i++){
			po3=new InStoragePo();
			str=strlist1[i].split("=");
			po3.setfStoreID(str[0]);
			po3.setfMaterialID(str[1]);
			po3.setfQty(str[2]);
			po3.setfStandard(str[3]);
			po3.setfNursingHomeID(fNursingHomeID);
			po3.setfCreatorID(fCreatorID);
			list1.add(po3);
		}
		try {
			if(this.inStorageService.creatStockAccount(po,list,list1)==0){
				logger.debug("增加成功");
				return new AjaxResultPo(true, "success");
			}else{
				logger.debug("进入增加方法,增加失败");
				request.getSession().setAttribute("dmsg", "增加失败");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("dmsg", "增加异常");
			logger.debug("异常:"+e.getMessage());
			e.printStackTrace();
			return null;
		}

	
	}
	/** 
	 * 
	 * 更新物品入库单
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */

    @ResponseBody
    @RequestMapping("/updateInStorage")
    public AjaxResultPo updateOrder(InStoragePo po, String inStorageEntrySql,String inStorageEntrySqlDelect,String stockAccountSql,String stockAccountSqlDelect,HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入updateOrder()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("主表参数"+po);
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfNursingHomeID(user.getOldhouse());
		po.setfCreatorID(user.getEmployId());
		String fNursingHomeID=user.getOldhouse();
		String fCreatorID=user.getEmployId();
        String[] str;
        String arr1[]=request.getParameterValues("arr1");
        String []arr=arr1[0].split(",");
		String[] arr2=null;
		if(!inStorageEntrySqlDelect.equals("")){
			 arr2=inStorageEntrySqlDelect.substring(1,inStorageEntrySqlDelect.length()).split("_");

		}

        logger.debug(inStorageEntrySql.equals("")&&stockAccountSql.equals(""));

        logger.debug("删除全部 并且更新");
		logger.debug("如果原来的数据全都删除："+arr2==null);

		logger.debug("删除全部 并且更新111");


		if(arr2==null){
          //如果所有的原来数据都删除了  先删除全部 再添加
          if(inStorageEntrySql.equals("")&&stockAccountSql.equals("")){
              logger.debug("直接全删除"+po.getfNumber());
              logger.debug(arr2==null);
          }else{
              logger.debug("全删除并且 增加新的数据");


			  //仓库id  物料id 数量 规格 需要进行修改的数据
              List<InStoragePo> list2 =new ArrayList<InStoragePo>();
              String[] strlist2=stockAccountSqlDelect.split("_");
              InStoragePo po4;
              for(int i=1;i<strlist2.length;i++){
                  po4=new InStoragePo();
                  str=strlist2[i].split("=");
                  po4.setfStoreID(str[0]);
                  po4.setfMaterialID(str[1]);
                  po4.setfQty(str[2]);
                  po4.setfStandard(str[3]);
                  po4.setFid(str[4]);
				  po4.setfNursingHomeID(fNursingHomeID);
				  po4.setfCreatorID(fCreatorID);
                  list2.add(po4);
              }

             logger.debug("全部删除---部分添加");
              //还需要增加：
			  //仓库id  数量  备注  物料id  保管员id
			  List<InStoragePo> list =new ArrayList<InStoragePo>();
			  String[] strlist=inStorageEntrySql.split("_");
			  InStoragePo po2;
			  for(int i=1;i<strlist.length;i++){
				  po2=new InStoragePo();
				  str=strlist[i].split("=");
				  po2.setfStoreID(str[0]);
				  po2.setfQty(str[1]);
				  po2.setfRemarks(str[2]);
				  po2.setfMaterialID(str[3]);
				  po2.setfStoremanID(str[4]);
				  po2.setfNursingHomeID(fNursingHomeID);
				  po2.setfCreatorID(fCreatorID);
				  list.add(po2);
			  }

			  //仓库id  物料id 数量 规格
			  List<InStoragePo> list1 =new ArrayList<InStoragePo>();
			  String[] strlist1=stockAccountSql.split("_");
			  InStoragePo po3;
			  for(int i=1;i<strlist.length;i++){
				  po3=new InStoragePo();
				  str=strlist1[i].split("=");
				  po3.setfStoreID(str[0]);
				  po3.setfMaterialID(str[1]);
				  po3.setfQty(str[2]);
				  po3.setfStandard(str[3]);
				  po3.setfNursingHomeID(fNursingHomeID);
				  po3.setfCreatorID(fCreatorID);
				  list1.add(po3);
			  }



              logger.debug("删除数据id:"+arr+""+stockAccountSqlDelect);
              logger.debug("新增的数据："+""+inStorageEntrySql+" "+stockAccountSql);


			  try {

				  String id=po.getFid();
				  if((this.inStorageService.updateStockAccount(po,arr,list2)==0)){

					  logger.debug("删除原来数据");
					  po.setFid(id);//更新时候存值

					  if(this.inStorageService.creatStockAccount(po,list,list1)==0){
						  logger.debug("更新成功");
						  return new AjaxResultPo(true, "success");

					  }else{
						  logger.debug("进入更新方法,更新失败");
						  request.getSession().setAttribute("dmsg", "更新失败");
						  return null;
					  }




				  }else{
					  logger.debug("进入更新方法,更新失败");
					  request.getSession().setAttribute("dmsg", "更新失败");
					  return null;
				  }
			  } catch (Exception e) {
				  // TODO: handle exception
				  request.getSession().setAttribute("dmsg", "更新异常");
				  logger.debug("异常:"+e.getMessage());
				  e.printStackTrace();
				  return null;
			  }



          }

      }else if(arr.length==arr2.length){
          logger.debug("没有删除只有更新");
          if(inStorageEntrySql.equals("")&&stockAccountSql.equals("")){
              logger.debug("不进行添加");
			  try {
				  if(this.inStorageService.updateStock(po)==0){

					  logger.debug("更新成功");
					  return new AjaxResultPo(true, "success");
				  }else{
					  logger.debug("进入更新方法,更新失败");
					  request.getSession().setAttribute("dmsg", "更新失败");
					  return null;
				  }
			  } catch (Exception e) {
				  // TODO: handle exception
				  request.getSession().setAttribute("dmsg", "更新异常");
				  logger.debug("异常:"+e.getMessage());
				  e.printStackTrace();
				  return null;
			  }

          }else{
              //仓库id  数量  备注  物料id  保管员id
              List<InStoragePo> list =new ArrayList<InStoragePo>();
              String[] strlist=inStorageEntrySql.split("_");
              InStoragePo po2;
              for(int i=1;i<strlist.length;i++){
                  po2=new InStoragePo();
                  str=strlist[i].split("=");
                  po2.setfStoreID(str[0]);
                  po2.setfQty(str[1]);
                  po2.setfRemarks(str[2]);
                  po2.setfMaterialID(str[3]);
                  po2.setfStoremanID(str[4]);
				  po2.setfNursingHomeID(fNursingHomeID);
				  po2.setfCreatorID(fCreatorID);


				  list.add(po2);
              }

              //仓库id  物料id 数量 规格
              List<InStoragePo> list1 =new ArrayList<InStoragePo>();
              String[] strlist1=stockAccountSql.split("_");
              InStoragePo po3;
              for(int i=1;i<strlist.length;i++){
                  po3=new InStoragePo();
                  str=strlist1[i].split("=");
                  po3.setfStoreID(str[0]);
                  po3.setfMaterialID(str[1]);
                  po3.setfQty(str[2]);
                  po3.setfStandard(str[3]);
				  po3.setfNursingHomeID(fNursingHomeID);
				  po3.setfCreatorID(fCreatorID);
                  list1.add(po3);
              }

              try {
          if(this.inStorageService.creatStockAccount(po,list,list1)==0){

                logger.debug("更新成功");
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入更新方法,更新失败");
                request.getSession().setAttribute("dmsg", "更新失败");
                return null;
            }
               } catch (Exception e) {
                   // TODO: handle exception
                   request.getSession().setAttribute("dmsg", "更新异常");
                   logger.debug("异常:"+e.getMessage());
                   e.printStackTrace();
                   return null;
               }

          }

      }else{
			logger.debug("既有删除又有更新");
			String delete[]=deff(arr,arr2);
			logger.debug(stockAccountSqlDelect);


			if(inStorageEntrySql.equals("")&&stockAccountSql.equals("")){
				//仓库id  物料id 数量 规格 需要进行修改的数据
				List<InStoragePo> list2 =new ArrayList<InStoragePo>();
				String[] strlist2=stockAccountSqlDelect.split("_");
				InStoragePo po4;
				for(int i=1;i<strlist2.length;i++){
					po4=new InStoragePo();
					str=strlist2[i].split("=");
					po4.setfStoreID(str[0]);
					po4.setfMaterialID(str[1]);
					po4.setfQty(str[2]);
					po4.setfStandard(str[3]);
					po4.setFid(str[4]);
					po4.setfNursingHomeID(fNursingHomeID);
					po4.setfCreatorID(fCreatorID);
					list2.add(po4);
				}
				try {

						if(this.inStorageService.updateStockAccount(po,delete,list2)==0){

						logger.debug("更新成功");
						return new AjaxResultPo(true, "success");
					}else{
						logger.debug("进入更新方法,更新失败");
						request.getSession().setAttribute("dmsg", "更新失败");
						return null;
					}
				} catch (Exception e) {
					// TODO: handle exception
					request.getSession().setAttribute("dmsg", "更新异常");
					logger.debug("异常:"+e.getMessage());
					e.printStackTrace();
					return null;
				}

			}else{

				 //4 2
				//仓库id  物料id 数量 规格 需要进行修改的数据
				List<InStoragePo> list2 =new ArrayList<InStoragePo>();
				String[] strlist2=stockAccountSqlDelect.split("_");
				InStoragePo po4;
				for(int i=1;i<strlist2.length;i++){
					po4=new InStoragePo();
					str=strlist2[i].split("=");
					po4.setfStoreID(str[0]);
					po4.setfMaterialID(str[1]);
					po4.setfQty(str[2]);
					po4.setfStandard(str[3]);
					po4.setFid(str[4]);
					po4.setfNursingHomeID(fNursingHomeID);
					po4.setfCreatorID(fCreatorID);
					list2.add(po4);
				}

				//进行增加的
				//仓库id  数量  备注  物料id  保管员id
				List<InStoragePo> list =new ArrayList<InStoragePo>();
				String[] strlist=inStorageEntrySql.split("_");
				InStoragePo po2;
				for(int i=1;i<strlist.length;i++){
					po2=new InStoragePo();
					str=strlist[i].split("=");
					po2.setfStoreID(str[0]);
					po2.setfQty(str[1]);
					po2.setfRemarks(str[2]);
					po2.setfMaterialID(str[3]);
					po2.setfStoremanID(str[4]);
					po2.setfNursingHomeID(fNursingHomeID);
					po2.setfCreatorID(fCreatorID);
					list.add(po2);
				}

				//仓库id  物料id 数量 规格
				List<InStoragePo> list1 =new ArrayList<InStoragePo>();
				String[] strlist1=stockAccountSql.split("_");
				InStoragePo po3;
				for(int i=1;i<strlist.length;i++){
					po3=new InStoragePo();
					str=strlist1[i].split("=");
					po3.setfStoreID(str[0]);
					po3.setfMaterialID(str[1]);
					po3.setfQty(str[2]);
					po3.setfStandard(str[3]);
					po3.setfNursingHomeID(fNursingHomeID);
					po3.setfCreatorID(fCreatorID);
					list1.add(po3);
				}

				try {

					String id=po.getFid();
					if((this.inStorageService.updateStockAccount(po,delete,list2)==0)){

						logger.debug("删除原来数据");
						po.setFid(id);//更新时候存值

						if(this.inStorageService.creatStockAccount(po,list,list1)==0){
							logger.debug("更新成功");
							return new AjaxResultPo(true, "success");

						}else{
							logger.debug("进入更新方法,更新失败");
							request.getSession().setAttribute("dmsg", "更新失败");
							return null;
						}




					}else{
						logger.debug("进入更新方法,更新失败");
						request.getSession().setAttribute("dmsg", "更新失败");
						return null;
					}
				} catch (Exception e) {
					// TODO: handle exception
					request.getSession().setAttribute("dmsg", "更新异常");
					logger.debug("异常:"+e.getMessage());
					e.printStackTrace();
					return null;
				}



			}





           //需要进行添加的数据

		}













        try {
          /* if(this.inStorageService.creatStockAccount(po,list,list1)==0){
                logger.debug("增加成功");
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入增加方法,增加失败");
                request.getSession().setAttribute("dmsg", "增加失败");
                return null;
            }*/
              return null;
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "增加异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return null;
        }


    }
    
    
    
    /** 
	 * 
	 * 删除物品单据
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */

	@ResponseBody
	@RequestMapping("/deleteInStorage")
	public AjaxResultPo deleteOrder(InStoragePo po,String stockAccountSqlDelect,HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入delectOrder()......");
		logger.debug("请求参数: "+ po.toString());
		logger.debug("主表参数"+po);
		String[] str;
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfNursingHomeID(user.getOldhouse());
		po.setfCreatorID(user.getEmployId());
		String fNursingHomeID=user.getOldhouse();
		String fCreatorID=user.getEmployId();

		List<InStoragePo> list2 =new ArrayList<InStoragePo>();
		String[] strlist2=stockAccountSqlDelect.split("_");
		InStoragePo po4;
		for(int i=1;i<strlist2.length;i++){
			po4=new InStoragePo();
			str=strlist2[i].split("=");
			po4.setfStoreID(str[0]);
			po4.setfMaterialID(str[1]);
			po4.setfQty(str[2]);
			po4.setfStandard(str[3]);
			po4.setFid(str[4]);
			po4.setfNursingHomeID(fNursingHomeID);
			po4.setfCreatorID(fCreatorID);
			list2.add(po4);
		}

		try {
			if(this.inStorageService.deleteUpdateStock(po,list2)==0){
				logger.debug("删除成功");
				return new AjaxResultPo(true, "success");
			}else{
				logger.debug("进入删除方法,删除失败");
				request.getSession().setAttribute("dmsg", "删除失败");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("dmsg", "删除异常");
			logger.debug("异常:"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	//判断出需要批量增加  批量删除的房间
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
