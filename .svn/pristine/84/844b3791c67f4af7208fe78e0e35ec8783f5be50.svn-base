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
import com.channelsoft.ems.nursing.nursingPlan.po.OldManPo;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManServicePlanPo;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanOldManService;
import com.channelsoft.ems.nursing.nursingPlan.service.OldManServicePlanService;
import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;
import com.channelsoft.ems.nursing.nursingProject.service.NursingProjectService;

@Component
public class OldManPlanCreateUtils {
	@Autowired
	private NursingPlanOldManService nursingPlanOldManService;
	
	@Autowired
	private NursingProjectService nursingProjectService;
	
	@Autowired
	private OldManServicePlanService oldManServicePlanService;
	/**
	 * 按照业务逻辑生成 老人项目计划
	 * @param params
	 * @return
	 */
	public Map<String, Object> oldManPlanCreate(Map<String, Object> params) {
		Map<String, Object> result=new HashMap<String, Object>();
		/**
		 * 1-查询出所有需要生成计划的老人
		 * 2-循环老人 查询出每个老人需要生成计划的项目
		 * 3-判断每个项目是否符合生成计划的条件
		 * 4-生成老人计划（往老人项目计划表t_kfgl_oldmanserviceplan插入数据）
		 * 5-在老人项目表（t_kfgl_oldmanserviceitem）反写 下次生成的日期和周期
		 */
		//查询符合条件的老人
		List<OldManPo> oldMans=nursingPlanOldManService.getAllOldMan();
		for (OldManPo oldManPo : oldMans) {
			//根据老人查询出所有符合条件的老人服务项目
			String oldManId=oldManPo.getFid();
			//查询老人的启用状态的 老人服务项目
			OldManServiceItemPo po=new OldManServiceItemPo();
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			String nowDate=sdf.format(new Date());
			
			po.setNowDate(nowDate);
			po.setFoldmanid(oldManId);
			List<OldManServiceItemPo> oldManServiceItems=nursingPlanOldManService.getOldManServiceItems(po);
			
			//老人最终符合生成服务计划的服务项目list
			List<OldManServiceItemPo> oldManServiceItemsEffectived=new ArrayList<OldManServiceItemPo>();
			
			/**
			 * 判断 老人服务项目的 服务开始日期，服务结束日期，和当前时间比较
			 * 服务开始时间<= 当前时间 and 服务结束时间 >=当前时间
			 */
			for (OldManServiceItemPo oldManServiceItemPo : oldManServiceItems) {
				//服务项目禁用时间
				Date fEndDate=oldManServiceItemPo.getfEndDate();
				
				/**
				 * 服务结束时间(目前启用状态的老人服务项目的结束时间是置为空了的)
				 * 服务结束时间 不为空的时候，则服务项目状态是 禁用的
				 * 所以个人觉得 这个服务结束时间 可以不做判断条件
				 */
				Date fserviceenddate = oldManServiceItemPo.getFserviceenddate();
				/**
				 * 下次生成计划的时间与当前时间比较，若时间相等，则表示 应该本次生成计划
				 * 反之 不应该本次生成
				 */
				Date fsecplanExcluddate=oldManServiceItemPo.getFsecplanExcluddate();
				
				//当前系统时间
				Date now=new Date();
				if(fEndDate==null){
					if(fsecplanExcluddate==null){
						oldManServiceItemsEffectived.add(oldManServiceItemPo);
					}else if(fsecplanExcluddate.getTime()-now.getTime()==0){
						oldManServiceItemsEffectived.add(oldManServiceItemPo);
					}
				}else{
					if(fEndDate.getTime()-now.getTime()>=0){
						if(fsecplanExcluddate==null){
							oldManServiceItemsEffectived.add(oldManServiceItemPo);
						}else if(fsecplanExcluddate.getTime()-now.getTime()==0){
							oldManServiceItemsEffectived.add(oldManServiceItemPo);
						}
					}
				}
			}
			
			/**
			 * 循环 最终符合生成服务计划的服务项目list,生成计划
			 * 并回显下次 生成时间和周期
			 */
			for (OldManServiceItemPo oldManServiceItemPo : oldManServiceItemsEffectived) {
				//根据老人服务项目ID 获取 服务项目的信息
				NursingProjectPo nursingProjectPo=nursingProjectService.getNursingProjectPoByFid(oldManServiceItemPo.getFserviceitemid());
				
				OldManServicePlanPo oldManServicePlanPo=new OldManServicePlanPo();
				String fid=IdGen.getRandomNoYMS("LRXMJH",4);
				String fnursingHomeid=nursingProjectPo.getfNursingHomeID();
			     String fauditorid="111";

			     Date faudittime=new Date();

			     String fcreatorid="222";

			     Date fcreatetime=new Date();

			     String fmodifierid="333";

			     Date fmodificationtime=new Date();

			     String fnumber=IdGen.getRandomNoYMS("LRXMJHN", 4);;

			     String foldmanserviceitemid=oldManServiceItemPo.getFid();

			     String foldmanid=oldManServiceItemPo.getFoldmanid();

			     String fstatus="1";

			     String fservicetype="1";
			     Integer fplancount=0;
			     if(nursingProjectPo.getfExecuteQty() !=null && !"".equals(nursingProjectPo.getfExecuteQty())){
			    	 fplancount=Integer.parseInt(nursingProjectPo.getfExecuteQty());
			     }
			     
			     Integer fexcludcount=0;
			     
			     oldManServicePlanPo.setFid(fid);
			     oldManServicePlanPo.setFnursingHomeid(fnursingHomeid);
			     oldManServicePlanPo.setFauditorid(fauditorid);
			     oldManServicePlanPo.setFaudittime(faudittime);
			     oldManServicePlanPo.setFcreatorid(fcreatorid);
			     oldManServicePlanPo.setFcreatetime(fcreatetime);
			     oldManServicePlanPo.setFmodifierid(fmodifierid);
			     oldManServicePlanPo.setFmodificationtime(fmodificationtime);
			     oldManServicePlanPo.setFnumber(fnumber);
			     oldManServicePlanPo.setFoldmanserviceitemid(foldmanserviceitemid);
			     oldManServicePlanPo.setFoldmanid(foldmanid);
			     oldManServicePlanPo.setFstatus(fstatus);
			     oldManServicePlanPo.setFservicetype(fservicetype);
			     oldManServicePlanPo.setFplancount(fplancount);
			     oldManServicePlanPo.setFexcludcount(fexcludcount);
			     
			     //项目周期
			     String fexecutecycle=nursingProjectPo.getfExecutecycle();
			     //下次计划生成时间
			     Date fsecplanExcluddate=getFsecplanExcluddate(fexecutecycle);
			     
			     oldManServicePlanPo.setFserviceexecuteplandate(fsecplanExcluddate);
			     
			   //在生成新的计划时，将老人该项目的已有的计划全部置为关闭状态
			     oldManServicePlanService.updatePlanStatus(oldManServicePlanPo);
			     
			     oldManServicePlanService.insertSelective(oldManServicePlanPo);
			     
			     /**
			      * 保存完 老人项目计划后 反写  老人护理项目表下次生成时间和周期
			      */
			     
			     OldManServiceItemPo tempPo=new OldManServiceItemPo();
			     tempPo.setFid(oldManServiceItemPo.getFid());
			     tempPo.setFexecutecycle(fexecutecycle);
			     tempPo.setFsecplanExcluddate(fsecplanExcluddate);
			     
			     nursingPlanOldManService.updateByPrimaryKeySelective(tempPo);
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
