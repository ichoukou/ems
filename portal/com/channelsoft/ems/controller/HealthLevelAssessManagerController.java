package com.channelsoft.ems.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.channelsoft.ems.po.UserPo;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.common.ConstantsMap;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.LevelPo;
import com.channelsoft.ems.service.IAssessProject;
/**
 *
 * @author wangjs
 * @date :2016/11/23 13:18
 * @parameter
 * @return
 */

@Controller
@RequestMapping("/health")
public class HealthLevelAssessManagerController {

	private static Logger logger=Logger.getLogger(HealthLevelAssessManagerController.class);

	@Autowired
	private IAssessProject assessProject;

	@RequestMapping("/level")
	public String gotoAssessProject(HttpServletRequest request,HttpServletResponse response){
		logger.debug("评估项目，已经跳转");
		return "healthLevel/assessProjectList";
	}

	/**
	 * @Method: gotoLevelList
	 * @Description: 分页查询评估项目
	 * @Para: [LevelPo po,int page,int pageSize,]
	 * @Retun: AjaxResultPo
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	@ResponseBody
	@RequestMapping("/query")
	public AjaxResultPo	gotoLevelList(LevelPo po,int page,int pageSize,
							 HttpServletRequest request,HttpServletResponse response) {
		logger.debug("进入HealthLevelAssessManagerController.query评估项目传递参数："+po.toString()+"page"+page+"pageSize"+pageSize);
		List<LevelPo> list=assessProject.queryProject(po,page,pageSize);

		for(int i=0;i<list.size();i++){
			DataDictionaryPo dataPo=ConstantsMap.dataDictionaryMap.get(list.get(i).getfEvaluationID());
			list.get(i).setfEvaluationName(dataPo.getValue());
		}
		int dataCount= assessProject.queryCount(po);
		return new AjaxResultPo(true,"success",dataCount,list);
	}

	/**
	 * @Method: check
	 * @Description: 验证评估项目
	 * @Para: [LevelPo]
	 * @Retun: String
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	@ResponseBody
	@RequestMapping("/check")
	public String getList(LevelPo po,HttpServletRequest request ,HttpServletResponse response)
			throws IOException {
		logger.debug("进入HealthLevelAssessManagerController.check（）方法 ");
		boolean flag = true;
		int result = assessProject.checkAp(po);
		if(result>0){
			flag = false;
		}

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("valid", flag);
		ObjectMapper mapper = new ObjectMapper();
		String resultString = "";
		try {
			resultString = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return resultString;
	}

	/**
	 * @Method: addAssessProject
	 * @Description: 添加评估项目
	 * @Para: [LevelPo]
	 * @Retun: AjaxResultPo
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	@ResponseBody
	@RequestMapping("/addpro")
	public AjaxResultPo addAssessProject(LevelPo po,HttpServletRequest request,HttpServletResponse response){
		logger.debug("进入HealthLevelAssessManagerController.addAssessProject（）方法");
		try{
			UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
			po.setfCreatorID(user.getEmployId());
			po.setfNursinghomeID(user.getOldhouse());
			assessProject.addProject(po);
//			List<LevelPo> list=assessProject.getProject(new LevelPo());
//			for(int i=0;i<list.size();i++){
//				DataDictionaryPo dataPo=ConstantsMap.dataDictionaryMap.get(list.get(i).getfEvaluationID());
//				list.get(i).setfEvaluationName(dataPo.getValue());
//			}
			return new AjaxResultPo(true,"评估项目添加成功");
//			return new AjaxResultPo(true,"评估项目添加成功",list.size(),list);
		}catch (Exception e){
			logger.error("评估项目添加失败",e);
			return new AjaxResultPo(false,"评估项目添加失败");
		}
	}

	/**
	 * @Method: updAssessProject
	 * @Description: 更新评估项目
	 * @Para: [LevelPo]
	 * @Retun: AjaxResultPo
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	@ResponseBody
	@RequestMapping("updatePro")
	public AjaxResultPo updAssessProject(LevelPo po,HttpServletRequest request,HttpServletResponse response){
		logger.debug("进入HealthLevelAssessManagerController.updAssessProject()方法");
		try{
			assessProject.updProject(po);
			List<LevelPo> list=assessProject.getProject(new LevelPo());
			for(int i=0;i<list.size();i++){
				DataDictionaryPo dataPo=ConstantsMap.dataDictionaryMap.get(list.get(i).getfEvaluationID());
				list.get(i).setfEvaluationName(dataPo.getValue());
			}
			return new AjaxResultPo(true,"修改评估项目成功",list.size(),list);
		}catch (Exception e){
			logger.error("修改评估项目失败",e);
			return new AjaxResultPo(false,"修改评估项目失败");
		}
	}

	/**
	 * @Method: deleteAssessProject
	 * @Description: 删除评估项目
	 * @Para: [LevelPo]
	 * @Retun: AjaxResultPo
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	@ResponseBody
	@RequestMapping("/deletePro")
	public AjaxResultPo deleteAssessProject(LevelPo po,HttpServletRequest request,HttpServletResponse response){
		logger.debug("进入HealthLevelAssessManagerController.deleteAssessProject()方法");
		try{
			assessProject.delProject(po);
			List<LevelPo> list=assessProject.getProject(new LevelPo());
			for(int i=0;i<list.size();i++){
				DataDictionaryPo dataPo=ConstantsMap.dataDictionaryMap.get(list.get(i).getfEvaluationID());
				list.get(i).setfEvaluationName(dataPo.getValue());
			}
			return new AjaxResultPo(true,"删除评估项目成功",list.size(),list);
		}catch (Exception e){
			logger.error("删除评估项目失败",e);
			return new AjaxResultPo(false,"删除评估项目失败");
		}
	}

}
