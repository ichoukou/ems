package com.channelsoft.ems.nursing.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.channelsoft.ems.common.IdGen;
import com.channelsoft.ems.nursing.nursingPlan.po.PublicServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlan.po.PublicServicePlanPo;
import com.channelsoft.ems.nursing.nursingPlan.po.RoomPo;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanPublicService;
import com.channelsoft.ems.nursing.nursingPlan.service.PublicServicePlanService;
import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;
import com.channelsoft.ems.nursing.nursingProject.service.NursingProjectService;

@Component
public class PublicPlanCreateUtils {
	@Autowired
	private NursingPlanPublicService nursingPlanPublicService;
	
	@Autowired
	private NursingProjectService nursingProjectService;
	
	@Autowired
	private PublicServicePlanService publicServicePlanService;
	/**
	 * 按照业务逻辑生成 公共项目计划
	 * @param params
	 * @return
	 */
	public Map<String, Object> publicPlanCreate(Map<String, Object> params) {
		Map<String, Object> result=new HashMap<String, Object>();
		/**
		 * 1-查询出所有需要生成计划的公共
		 * 2-循环公共 查询出每个公共需要生成计划的项目
		 * 3-判断每个项目是否符合生成计划的条件
		 * 4-生成公共计划（往公共项目计划表t_kfgl_publicserviceplan插入数据）
		 * 5-在公共项目表（t_kfgl_publicserviceitem）反写 下次生成的日期和周期
		 */
		//查询符合条件的公共
		List<RoomPo> rooms=nursingPlanPublicService.getAllRoom();
		for (RoomPo roomPo : rooms) {
			//根据公共查询出所有符合条件的公共服务项目
			String roomId=roomPo.getFid();
			//查询公共的启用状态的 公共服务项目
			PublicServiceItemPo po=new PublicServiceItemPo();
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			String nowDate=sdf.format(new Date());
			
			po.setNowDate(nowDate);
			po.setFroomid(roomId);
			List<PublicServiceItemPo> publicServiceItems=nursingPlanPublicService.getPublicServiceItems(po);
			
			//公共最终符合生成服务计划的服务项目list
			List<PublicServiceItemPo> publicServiceItemsEffectived=new ArrayList<PublicServiceItemPo>();
			
			/**
			 * 判断 公共服务项目的 服务开始日期，服务结束日期，和当前时间比较
			 * 服务开始时间<= 当前时间 and 服务结束时间 >=当前时间
			 */
			for (PublicServiceItemPo publicServiceItemPo : publicServiceItems) {
				//服务项目禁用时间
				Date fEndDate=publicServiceItemPo.getfEndDate();
				
				/**
				 * 服务结束时间(目前启用状态的公共服务项目的结束时间是置为空了的)
				 * 服务结束时间 不为空的时候，则服务项目状态是 禁用的
				 * 所以个人觉得 这个服务结束时间 可以不做判断条件
				 */
				Date fserviceenddate = publicServiceItemPo.getFserviceenddate();
				/**
				 * 下次生成计划的时间与当前时间比较，若时间相等，则表示 应该本次生成计划
				 * 反之 不应该本次生成
				 */
				Date fsecplanExcluddate=publicServiceItemPo.getFsecplanExcluddate();
				
				//当前系统时间
				Date now=new Date();
				if(fEndDate==null){
					if(fsecplanExcluddate==null){
						publicServiceItemsEffectived.add(publicServiceItemPo);
					}else if(fsecplanExcluddate.getTime()-now.getTime()==0){
						publicServiceItemsEffectived.add(publicServiceItemPo);
					}
				}else{
					if(fEndDate.getTime()-now.getTime()>=0){
						if(fsecplanExcluddate==null){
							publicServiceItemsEffectived.add(publicServiceItemPo);
						}else if(fsecplanExcluddate.getTime()-now.getTime()==0){
							publicServiceItemsEffectived.add(publicServiceItemPo);
						}
					}
				}
			}
			
			/**
			 * 循环 最终符合生成服务计划的服务项目list,生成计划
			 * 并回显下次 生成时间和周期
			 */
			for (PublicServiceItemPo publicServiceItemPo : publicServiceItemsEffectived) {
				//根据公共服务项目ID 获取 服务项目的信息
				NursingProjectPo nursingProjectPo=nursingProjectService.getNursingProjectPoByFid(publicServiceItemPo.getFserviceitemid());
				
				PublicServicePlanPo publicServicePlanPo=new PublicServicePlanPo();
				String fid=IdGen.getRandomNoYMS("LRXMJH",4);
				String fnursingHomeid=nursingProjectPo.getfNursingHomeID();
			     String fauditorid="111";

			     Date faudittime=new Date();

			     String fcreatorid="222";

			     Date fcreatetime=new Date();

			     String fmodifierid="333";

			     Date fmodificationtime=new Date();

			     String fnumber=IdGen.getRandomNoYMS("LRXMJHN", 4);;

			     String fpublicserviceitemid=publicServiceItemPo.getFid();

			     String froomid=publicServiceItemPo.getFroomid();

			     String fstatus="1";

			     String fservicetype="1";
			     Integer fplancount=0;
			     if(nursingProjectPo.getfExecuteQty() !=null && !"".equals(nursingProjectPo.getfExecuteQty())){
			    	 fplancount=Integer.parseInt(nursingProjectPo.getfExecuteQty());
			     }
			     
			     Integer fexcludcount=0;
			     
			     publicServicePlanPo.setFid(fid);
			     publicServicePlanPo.setFnursingHomeid(fnursingHomeid);
			     publicServicePlanPo.setFauditorid(fauditorid);
			     publicServicePlanPo.setFaudittime(faudittime);
			     publicServicePlanPo.setFcreatorid(fcreatorid);
			     publicServicePlanPo.setFcreatetime(fcreatetime);
			     publicServicePlanPo.setFmodifierid(fmodifierid);
			     publicServicePlanPo.setFmodificationtime(fmodificationtime);
			     publicServicePlanPo.setFnumber(fnumber);
			     publicServicePlanPo.setFpublicserviceitemid(fpublicserviceitemid);
			     publicServicePlanPo.setFroomid(froomid);
			     publicServicePlanPo.setFstatus(fstatus);
			     publicServicePlanPo.setFservicetype(fservicetype);
			     publicServicePlanPo.setFplancount(fplancount);
			     publicServicePlanPo.setFexcludcount(fexcludcount);
			     
			     //项目周期
			     String fexecutecycle=nursingProjectPo.getfExecutecycle();
			     //下次计划生成时间
			     Date fsecplanExcluddate=getFsecplanExcluddate(fexecutecycle);
			     
			     publicServicePlanPo.setFserviceexecuteplandate(fsecplanExcluddate);
			     
			   //在生成新的计划时，将房间该项目的已有的计划全部置为关闭状态
			     publicServicePlanService.updatePlanStatus(publicServicePlanPo);
			     
			     publicServicePlanService.insertSelective(publicServicePlanPo);
			     
			     /**
			      * 保存完 公共项目计划后 反写  公共护理项目表下次生成时间和周期
			      */
			     
			     PublicServiceItemPo tempPo=new PublicServiceItemPo();
			     tempPo.setFid(publicServiceItemPo.getFid());
			     tempPo.setFexecutecycle(fexecutecycle);
			     tempPo.setFsecplanExcluddate(fsecplanExcluddate);
			     
			     nursingPlanPublicService.updateByPrimaryKeySelective(tempPo);
			}
			
		}
		
		
		return result;
	}
	
	private Date getFsecplanExcluddate(String fexecutecycle) {
		Date fsecplanExcluddate=new Date();
		try{
			SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
			Date beginDate = new Date();
			Calendar date = Calendar.getInstance();
			date.setTime(beginDate);
			date.set(Calendar.DATE, date.get(Calendar.DATE) + Integer.parseInt(fexecutecycle));
			Date endDate = dft.parse(dft.format(date.getTime()));
			fsecplanExcluddate=endDate;
		}catch(Exception e){
			e.printStackTrace();
		}
		return fsecplanExcluddate;
	}
}
