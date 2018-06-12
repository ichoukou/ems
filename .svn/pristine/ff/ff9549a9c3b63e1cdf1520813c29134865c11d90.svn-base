package com.channelsoft.ems.controller;


import java.io.UnsupportedEncodingException;
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
import com.channelsoft.ems.po.RangePo;
import com.channelsoft.ems.service.EvaluationScoreService;


/** 
 * 
 * 评估等级范围  
 * @author  wuhl
 * @date 创建时间：2016年11月13日 下午16:13:41 
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/rate")
public class RateRangeController {

	private static Logger logger = Logger.getLogger(RateRangeController.class);
	
	@Autowired
	private EvaluationScoreService evaluationScoreService;
	
	@RequestMapping("/range")
	public String gotodataRange(HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入后端跳转到显示页");
 
		return "rateRange/rateRangeList";
	}
	
	
	@ResponseBody
	@RequestMapping("/showName")
	public AjaxResultPo showName( HttpServletRequest request ,HttpServletResponse response){
	    logger.debug("查询连表数据");
		List<Map<String, String>>  list=this.evaluationScoreService.getALLEvalLevel();
	    logger.debug("数据查询完毕");
		return new AjaxResultPo(true, "success", list.size(), list);
	}


    @ResponseBody
    @RequestMapping("/showFLevelID")
    public AjaxResultPo showFLevelID( HttpServletRequest request ,HttpServletResponse response){
        logger.debug("查询连表数据");
        List<Map<String, String>>  list=this.evaluationScoreService.queryFLevelID();
        logger.debug("数据查询完毕");
        return new AjaxResultPo(true, "success", list.size(), list);
    }
	
	
	
	
	@ResponseBody
	@RequestMapping("/query")
	public AjaxResultPo queryEvaluationScore(RangePo po,int page,int pageSize, HttpServletRequest request ,HttpServletResponse response)throws UnsupportedEncodingException {
		logger.debug("range请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
		logger.debug("查询类型："+po);
        po.setClevelName(new String(po.getClevelName().getBytes("ISO-8859-1"), "utf-8"));


        List<RangePo> list= this.evaluationScoreService.getInternListBy(po,page,pageSize);

		int count=this.evaluationScoreService.getInternListByCount(po);
		
		return new AjaxResultPo(true, "success", count, list);
	}
	
	
	@ResponseBody
	@RequestMapping("/addRange")
	public AjaxResultPo addEvaluationScore(RangePo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   addRange()......");
		logger.debug("请求参数: "+ po.toString());
		logger.debug("穿过来的对象"+po);
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfNursinghomeID(user.getOldhouse());
		po.setfCreatorID(user.getEmployId());
	    //数据关联
	//String id=Integer.toString(this.evaluationScoreService.queryIdByName(po.getClevelName()).get(0).get("FLevelID"));

	    logger.debug("等级的id"+po.getClevelId());
		try {
			if(this.evaluationScoreService.addEvalScore(po)==0){
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
	
	
	@ResponseBody
	@RequestMapping("/updateRange")
	public AjaxResultPo updateEvaluationScore(RangePo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   updateRange()......");
		logger.debug("请求参数: "+ po.toString());
		logger.debug("需要更新字段"+po);
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfNursinghomeID(user.getOldhouse());
		po.setfCreatorID(user.getEmployId());
		try {
			if(this.evaluationScoreService.updateEvalLevel(po)==0){
	            logger.debug("更新成功");

	    		return new AjaxResultPo(true, "success");
		        //return new AjaxResultPo(true, "success");
				
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
	
	
	@ResponseBody
	@RequestMapping("/deleteRange")
	public AjaxResultPo deleteEvaluationScore(RangePo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   deleteRange()......");
		logger.debug("请求参数: "+ po.toString());
		
		try {
			if(this.evaluationScoreService.deleteEvalScore(po.getClevelId())==0){
	        logger.debug("成功删除"+po.getClevelId());
	        return new AjaxResultPo(true, "success");
		     //return new AjaxResultPo(true, "success");
				
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
	
}

