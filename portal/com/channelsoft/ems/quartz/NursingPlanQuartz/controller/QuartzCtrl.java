package com.channelsoft.ems.quartz.NursingPlanQuartz.controller;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.common.ResponseJsonUtil;
import com.channelsoft.ems.po.AjaxResultPo;

import net.sf.json.JSONObject;

/**
 * @author Administrator
 * 
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
@Controller
@RequestMapping("/job/quartz")
public class QuartzCtrl{

	private final static Logger log = Logger.getLogger(QuartzCtrl.class);
	private static String JOB_GROUP_NAME = "PS_JOB_GROUP";

	private static String TRIGGER_GROUP_NAME = "PS_TRIGGER_GROUP_GROUP";

	@Autowired
	private SchedulerFactoryBean scheduler;

	@RequestMapping("basepage")
	public String basePage() {
		return "/quartz/job/add";
	}

	@RequestMapping("edit")
	public String edit() {
		return "/quartz/job/edit";
	}

	@RequestMapping({ "index"})
	public String quartzList() {
		return "/quartz/job/index";
	}
	
	@ResponseBody
	@RequestMapping("data")
	public AjaxResultPo data(HttpServletRequest request, HttpServletResponse response, String jobName) {

		// job 只有手动写分页功能.
		Integer page = new Integer(request.getParameter("page"));
		; // 当前页
		Integer rows = new Integer(request.getParameter("pageSize")); // 每页多少条

		Integer start = page * rows;
		Integer end = (page + 1) * rows - 1;

		// pageParams.setPage(((offset/rows) + 1) + ""); //当前页
		// pageParams.setRows(rows.toString());//每页多少条

		Scheduler sched = scheduler.getScheduler();

		Set<JobKey> jobkeys = new HashSet<JobKey>();
		try {
			jobkeys = sched.getJobKeys(GroupMatcher.jobGroupEquals(JOB_GROUP_NAME));
			log.info(" 共有 " + jobkeys.size() + " 个任务.");
		} catch (SchedulerException e) {
			log.error(" 获取jobkeys异常 : " + e.getMessage());
		}
		List<JSONObject> arrs = new ArrayList<JSONObject>();

		if (StringUtils.isNotBlank(jobName)) {
			for (JobKey jobKey : jobkeys) {
				try {
					JSONObject json = new JSONObject();
					JobDetailImpl jobdetail = (JobDetailImpl) sched.getJobDetail(jobKey);

					if (jobdetail.getName().contains(jobName)) {
						List<Trigger> triggers = (List<Trigger>) sched.getTriggersOfJob(jobKey);

						CronTrigger trigger = (CronTrigger) triggers.get(0);

						jobDetail2Json(sched, json, jobdetail, trigger);

						arrs.add(json);

					}

				} catch (SchedulerException e) {
					log.error(" 获取JobDetail异常 : " + e.getMessage());
				}
			}
			List<JSONObject> result = new ArrayList<JSONObject>();
			// 获取本页显示的数据
			for (int i = start; (i <= end && i < arrs.size()); i++) {
				result.add(arrs.get(i));
			}

			return new AjaxResultPo(true, "success", arrs.size(), result);
		} else {
			for (JobKey jobKey : jobkeys) {
				try {
					JSONObject json = new JSONObject();
					JobDetailImpl jobdetail = (JobDetailImpl) sched.getJobDetail(jobKey);

					List<Trigger> triggers = (List<Trigger>) sched.getTriggersOfJob(jobKey);

					
					Trigger trigger = triggers.get(0);
					
					if(trigger instanceof SimpleTriggerImpl){
						log.error("检测到 SimpleTrigger 参数为 : " + com.alibaba.fastjson.JSONObject.toJSONString(trigger) );
					}else{
						trigger = (CronTrigger) trigger;
					}
					
					jobDetail2Json(sched, json, jobdetail, trigger);

					arrs.add(json);
				} catch (Exception e) {
					log.error(" 获取JobDetail异常 : " + e.getMessage());
				}
			}
			List<JSONObject> result = new ArrayList<JSONObject>();
			// 获取本页显示的数据
			for (int i = start; (i <= end && i < arrs.size()); i++) {
				result.add(arrs.get(i));
			}
			return new AjaxResultPo(true, "success", arrs.size(), result);

		}

	}

	private void jobDetail2Json(Scheduler sched, JSONObject json, JobDetailImpl jobdetail, Trigger trigger) throws SchedulerException {
		json.put("jobdetail", jobdetail);
		json.put("jobname", jobdetail.getName());
		json.put("jobclass", jobdetail.getJobClass());
		json.put("description", jobdetail.getDescription());
		json.put("state", sched.getTriggerState(trigger.getKey()));
		if(jobdetail.getJobDataMap() != null){
			json.put("jobDataMap", "'" + com.alibaba.fastjson.JSONObject.toJSONString(jobdetail.getJobDataMap()) + "'");
		}
		if(trigger instanceof CronTrigger){
			trigger = (CronTrigger)trigger;
			json.put("cronexpression", ((CronTrigger) trigger).getCronExpression());
		}else{
			json.put("cronexpression", "");
		}
		json.put("triggername", trigger.getKey().getName());
	}

	/**
	 * 通过jobname 获取jobdetail
	 * 
	 * @throws SchedulerException
	 */
	@RequestMapping("getByName")
	public void getByName(String jobname, HttpServletRequest request, HttpServletResponse response) throws SchedulerException {
		Scheduler sched = scheduler.getScheduler();
		if (StringUtils.isNotBlank(jobname)) {
			JobKey jobKey = new JobKey(jobname, JOB_GROUP_NAME);
			try {
				JobDetailImpl jobdetail = (JobDetailImpl) sched.getJobDetail(jobKey);
				CronTrigger trigger = (CronTrigger) sched.getTriggersOfJob(jobKey).get(0);
				JSONObject json = new JSONObject();
				jobDetail2Json(sched, json, jobdetail, trigger);
				ResponseJsonUtil.writeResultNoTrans(response, json);
			} catch (SchedulerException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}

	@RequestMapping("change")
	public void change(HttpServletRequest request, HttpServletResponse response) {
		Scheduler sched = scheduler.getScheduler();
		Boolean state = Boolean.valueOf(request.getParameter("state"));
		try {
			if (state) {
				sched.resumeAll(); // 全部重新唤醒
				log.info("唤醒 scheduler");
			} else {
				sched.pauseAll(); // 全部暂停
				log.info("暂停 scheduler");
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据key暂停job
	 */
	@RequestMapping("pausebykey")
	public void pauseByKey(HttpServletRequest request, HttpServletResponse response) {
		Scheduler sched = scheduler.getScheduler();
		String key = request.getParameter("key");
		JobKey jobKey = new JobKey(key, JOB_GROUP_NAME);
		try {
			sched.pauseJob(jobKey);
			log.info("暂停job : " + jobKey+",成功");
		} catch (SchedulerException e) {
			log.error("暂停job失败 失败key为 : " + jobKey);
			log.error("暂停job失败 异常信息  : " + e.getMessage());
		}
	}

	/**
	 * 根据key启动job
	 */
	@RequestMapping("startbykey")
	public void startByKey(HttpServletRequest request, HttpServletResponse response) {
		Scheduler sched = scheduler.getScheduler();
		String key = request.getParameter("key");
		JobKey jobKey = new JobKey(key, JOB_GROUP_NAME);
		try {
			sched.resumeJob(jobKey);
			log.info("启动job : " + jobKey+",成功");
		} catch (SchedulerException e) {
			log.error("启动job失败 失败key为 : " + jobKey);
			log.error("启动job失败 异常信息  : " + e.getMessage());
		}
	}

	/**
	 * 修改时间表达式
	 */
	@ResponseBody
	@RequestMapping("change_exp")
	public AjaxResultPo changeExp(HttpServletRequest request, HttpServletResponse response) {
		Scheduler sched = scheduler.getScheduler();

		String key = request.getParameter("edit_jobname");

		JobKey jobKey = new JobKey(key, JOB_GROUP_NAME);

		String cronexpression = request.getParameter("edit_cronexpression");

		TriggerKey triggerKey = new TriggerKey("");

		// 验证表达式是否正确
		try {
			CronScheduleBuilder.cronSchedule(cronexpression);
		} catch (Exception e) {
			return new AjaxResultPo(false, "修改时间表达式失败.表达式不正确!");
		}

		try {
			List<Trigger> triggers = (List<Trigger>) sched.getTriggersOfJob(jobKey);

			triggerKey = triggers.get(0).getKey();

			CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
			// trigger已存在，则更新相应的定时设置
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronexpression);
			// 按新的cronExpression表达式重新构建trigger
			trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
			// 按新的trigger重新设置job执行
			sched.rescheduleJob(triggerKey, trigger);
			return new AjaxResultPo(true, "修改成功");
		} catch (SchedulerException e) {
			log.error("修改时间表达式 失败的trigger key为 : " + triggerKey);
			log.error("修改时间表达式 异常信息  : " + e.getMessage());
			return new AjaxResultPo(false, "修改时间表达式失败.表达式不正确!");
		}
	}

	/**
	 * 添加任务
	 */
	@ResponseBody
	@RequestMapping("add")
	public AjaxResultPo addJob(HttpServletRequest request, HttpServletResponse response) {
		Scheduler sched = scheduler.getScheduler();

		String jobname = request.getParameter("add_jobname");
		String cronexpression = request.getParameter("add_cronexpression");
		String triggername = request.getParameter("add_triggername");
		String jobclass = request.getParameter("add_jobclass");
		String description = request.getParameter("add_description");
		description = StringUtils.isBlank(description) ? "" : description;

		// 验证任务是否重名
		JobKey jobKey = new JobKey(jobname, JOB_GROUP_NAME);
		try {
			JobDetail jobDetail = sched.getJobDetail(jobKey);
			if (jobDetail != null) {
				return new AjaxResultPo(false, "该任务名已存在,请修改任务名!");
			}
		} catch (SchedulerException e) {
			return new AjaxResultPo(false, "该任务名已存在,请修改任务名!");
		}

		// 验证表达式是正确
		try {
			CronScheduleBuilder.cronSchedule(cronexpression);
		} catch (Exception e) {
			return new AjaxResultPo(false, "时间表达式不正确,请修改时间表达式!");
		}

		// 验证触发器是否存在
		TriggerKey triggerKey = new TriggerKey(triggername, TRIGGER_GROUP_NAME);
		try {
			Trigger trigger = sched.getTrigger(triggerKey);
			if (trigger != null) {
				return new AjaxResultPo(false, "该触发器名已存在,请修改触发器名!");
			}
		} catch (SchedulerException e) {
			return new AjaxResultPo(false, "该触发器名已存在,请修改触发器名!");
		}

		// 验证调用类是否存在
		try {
			Class<? extends Job> clazz = (Class<? extends Job>) Class.forName(jobclass);
			if (!Job.class.isAssignableFrom(clazz)) {
				return new AjaxResultPo(false, "该执行类没有实现Job接口,请实现Job接口!");
			}
		} catch (ClassNotFoundException e) {
			return new AjaxResultPo(false, "该执行类不存在,请修改执行类(需加上包路径如 com.job.HelloJob)!");
		}

		try {
			Class clazz = Class.forName(jobclass);
			JobDetail jobDetail = newJob(clazz).withIdentity(jobname, JOB_GROUP_NAME).withDescription(description).build();
			// 表达式调度构建器 如果并发时放弃该任务
			CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronexpression).withMisfireHandlingInstructionDoNothing();
			// 按新的表达式构建一个新的trigger
			Trigger trigger = newTrigger().withIdentity(triggername, TRIGGER_GROUP_NAME).withSchedule(scheduleBuilder).build();

			
			sched.scheduleJob(jobDetail, trigger);
			log.info("添加job : " + jobKey+",成功");
			return new AjaxResultPo(true, "添加任务成功.");
		} catch (Exception e) {
			log.error(" 添加任务失败 : " + e.getMessage());
			return new AjaxResultPo(false, "添加任务失败,失败原因请查阅日志信息.");
		}

	}

	/**
	 * 根据任务名和触发器名删除任务以及触发器
	 */
	@ResponseBody
	@RequestMapping("del")
	public AjaxResultPo delJob(HttpServletRequest request, HttpServletResponse response) {
		String jobname = request.getParameter("jobname");
		String triggername = request.getParameter("triggername");

		TriggerKey triggerKey = new TriggerKey(triggername, TRIGGER_GROUP_NAME);
		JobKey jobKey = new JobKey(jobname, JOB_GROUP_NAME);

		Scheduler sched = scheduler.getScheduler();
		try {
			// 停止触发器
			sched.pauseTrigger(triggerKey);
			// 移除触发器
			sched.deleteJob(jobKey);
			// 删除任务
			sched.unscheduleJob(triggerKey);
			return new AjaxResultPo(true, "删除任务成功.");
		} catch (SchedulerException e) {
			log.error(" 删除任务失败 : " + e.getMessage());
			return new AjaxResultPo(false, "删除任务失败.");
		}
	}

	// 开启所有任务
	@RequestMapping("startAll")
	public void startAll(HttpServletRequest request, HttpServletResponse response) {
		Scheduler sched = scheduler.getScheduler();

		Set<JobKey> jobkeys = new HashSet<JobKey>();
		try {
			jobkeys = sched.getJobKeys(GroupMatcher.jobGroupEquals(JOB_GROUP_NAME));
			log.info(" 共有 " + jobkeys.size() + " 个任务.");
		} catch (SchedulerException e) {
			log.error(" 获取jobkeys异常 : " + e.getMessage());
		}

		for (JobKey jobKey : jobkeys) {
			try {
				sched.resumeJob(jobKey);
			} catch (SchedulerException e) {
				log.error("启动job失败 失败key为 : " + jobKey);
				log.error("启动job失败 异常信息  : " + e.getMessage());
			}
		}
	}

	// 暂停所有任务
	@RequestMapping("stopAll")
	public void stopAll(HttpServletRequest request, HttpServletResponse response) {
		Scheduler sched = scheduler.getScheduler();

		Set<JobKey> jobkeys = new HashSet<JobKey>();
		try {
			jobkeys = sched.getJobKeys(GroupMatcher.jobGroupEquals(JOB_GROUP_NAME));
			log.info(" 共有 " + jobkeys.size() + " 个任务.");
		} catch (SchedulerException e) {
			log.error(" 获取jobkeys异常 : " + e.getMessage());
		}

		for (JobKey jobKey : jobkeys) {
			try {
				sched.pauseJob(jobKey);
			} catch (SchedulerException e) {
				log.error("暂停job失败 失败key为 : " + jobKey);
				log.error("暂停job失败 异常信息  : " + e.getMessage());
			}
		}
	}

	/**
	 * 立刻执行一次job
	 */
	@ResponseBody
	@RequestMapping("invoke_job")
	public AjaxResultPo invokeJob(HttpServletRequest request, HttpServletResponse response) {
		String keys =request.getParameter("keys"); 
		if (StringUtils.isNotBlank(keys)) {
			String[] keyArr = keys.split(",");
			Scheduler sched = scheduler.getScheduler();

			for (String string : keyArr) {
				JobKey jobKey = new JobKey(string, JOB_GROUP_NAME);

				try {
					sched.triggerJob(jobKey);
				} catch (SchedulerException e) {
					log.error(string + "执行失败!", e);
				}
			}

			return new AjaxResultPo(true, "");
		} else {
			return new AjaxResultPo(false, "没有可执行的任务!");
		}
	}

	public Double div(Double dividend, Double divisor, Integer scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(dividend));
		BigDecimal b2 = new BigDecimal(Double.toString(divisor));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public Double div(Double dividend, Double divisor) {
		return div(dividend, divisor, 3);
	}

}
