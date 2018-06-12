
package com.channelsoft.ems.quartz.NursingPlanQuartz.job;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;

import com.channelsoft.ems.nursing.util.OldManPlanCreateUtils;

@DisallowConcurrentExecution
@SuppressWarnings("unchecked")
public class OldManPlanCreateJob implements Job{

	Logger log = Logger.getLogger(OldManPlanCreateJob.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ApplicationContext applicationContext = null;
		
		try {
			applicationContext = (ApplicationContext) context.getScheduler().getContext().get("applicationContext");
			OldManPlanCreateUtils utils = (OldManPlanCreateUtils) applicationContext.getBean("oldManPlanCreateUtils");;
			//传入参数的map,目前无需参数传递
			Map<String, Object> params = new HashMap<String, Object>();
			
			//生成老人项目计划
			Map<String, Object> all=utils.oldManPlanCreate(params);
			
			
			
		} catch (SchedulerException e) {
			log.error("获取applicationContext异常....", e);
			throw new JobExecutionException(e);
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			throw new JobExecutionException(e);
		}
		
		
	}
	
}
