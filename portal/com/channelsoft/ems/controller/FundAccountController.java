package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.FundAccountPo;
import com.channelsoft.ems.service.FundAccountService;
import com.channelsoft.ems.service.OldManRecordService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  资金账户管理controller
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年1月5日
 */
@Controller
@RequestMapping("/fundAcc")
public class FundAccountController {
	
	private Logger logger=Logger.getLogger(FundAccountController.class);
	
	@Autowired
	private FundAccountService fundAccountService;
	
	@Autowired
	private OldManRecordService oldManRecordService;
	@RequestMapping("/getFundAccList")
	public String getFundAccList(){
		logger.debug("开始跳转。。");
		return "fundAccount/fundAccountList";
	}
	
	@RequestMapping("/query")
	@ResponseBody
	/**
	 * 查询资金账户  带分页
	 * @param page
	 * @param pageSize
	 * @param fundAccountPo
	 * @param request
	 * @param response
	 * @return
	 */
	public AjaxResultPo queryFundAccount(int page,int pageSize,FundAccountPo fundAccountPo,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		logger.debug("传进来的page="+page);
		logger.debug("传进来的pageSize="+pageSize);
		logger.debug("传进来的参数"+fundAccountPo.toString());
		request.setCharacterEncoding("UTF-8");
		if(!StringUtils.isEmpty(request.getParameter("fName"))){
			fundAccountPo.setfName(request.getParameter("fName"));
		}
		if(!StringUtils.isEmpty(request.getParameter("fHeader"))){
			fundAccountPo.setfHeader(request.getParameter("fHeader"));
		}
		List<FundAccountPo> fundAccountPoList=fundAccountService.queryFundAccount(page, pageSize, fundAccountPo, request, response);
		for(int i=0;i<fundAccountPoList.size();i++){
			//得到数据库中的状态  如果为0就是使用中 1就是禁用
			String status=fundAccountPoList.get(i).getfStatus();
			//放入链接组
			if(status.equals("0")){
				fundAccountPoList.get(i).setfStatusName("使用中");
				//点击超链将当前最状态和次超链接的id传给changestatus方法 然后封装po
				String fLink="<a href=\"javascript:void(0)\" onclick=\"changeStatus('0','"+fundAccountPoList.get(i).getfId()+"')\">禁用</a>";
				fundAccountPoList.get(i).setfLink(fLink);
			}/*else if(status.equals("1")){
				fundAccountPoList.get(i).setfStatusName("禁止使用");
				String fLink="<a href=\"javascript:void(0)\" onclick=\"changeStatus('1','"+fundAccountPoList.get(i).getfId()+"')\">还原</a>";
				fundAccountPoList.get(i).setfLink(fLink);
			}*/
		}
		int count=fundAccountService.getCount(fundAccountPo);
		return new AjaxResultPo(true,"success",count,fundAccountPoList);
	}

	@RequestMapping("/queryIgnoreStatus")
	@ResponseBody
	/**
	 * 查询资金账户  带分页
	 * @param page
	 * @param pageSize
	 * @param fundAccountPo
	 * @param request
	 * @param response
	 * @return
	 */
	public AjaxResultPo queryFundAccountIgnoreStatus(int page,int pageSize,FundAccountPo fundAccountPo,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		logger.debug("传进来的page="+page);
		logger.debug("传进来的pageSize="+pageSize);
		logger.debug("传进来的参数"+fundAccountPo.toString());
		request.setCharacterEncoding("UTF-8");
		if(!StringUtils.isEmpty(request.getParameter("fName"))){
			fundAccountPo.setfName(request.getParameter("fName"));
		}
		if(!StringUtils.isEmpty(request.getParameter("fHeader"))){
			fundAccountPo.setfHeader(request.getParameter("fHeader"));
		}
		List<FundAccountPo> fundAccountPoList=fundAccountService.queryIgnoreStatus(page, pageSize, fundAccountPo, request, response);
		for(int i=0;i<fundAccountPoList.size();i++){
			//得到数据库中的状态  如果为0就是使用中 1就是禁用
			String status=fundAccountPoList.get(i).getfStatus();
			//放入链接组
			if(status.equals("0")){
				fundAccountPoList.get(i).setfStatusName("使用中");
				//点击超链将当前最状态和次超链接的id传给changestatus方法 然后封装po
				String fLink="<a href=\"javascript:void(0)\" onclick=\"changeStatus('0','"+fundAccountPoList.get(i).getfId()+"')\">禁用</a>";
				fundAccountPoList.get(i).setfLink(fLink);
			}else if(status.equals("1")){
				fundAccountPoList.get(i).setfStatusName("禁止使用");
				String fLink="<a href=\"javascript:void(0)\" onclick=\"changeStatus('1','"+fundAccountPoList.get(i).getfId()+"')\">还原</a>";
				fundAccountPoList.get(i).setfLink(fLink);
			}
		}
		int count=fundAccountService.getCountIgnoreStatus(fundAccountPo);
		return new AjaxResultPo(true,"success",count,fundAccountPoList);
	}


	/**
	 * 回显日常行为类型
	 * @param dc
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getStatus")
	@ResponseBody
	public AjaxResultPo getStatus(String dcName,HttpServletRequest request,HttpServletResponse response){
		logger.debug("传进来的值为"+dcName);
		List<DataDictionaryPo> dcList = oldManRecordService.getType(dcName);
		return new AjaxResultPo(true, "success", dcList.size(), dcList);
	}
	/**
	 * 点击禁用和启用的超链接的时候，ajax传来请求 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/changeStatus")
	@ResponseBody
	public AjaxResultPo changeStatus(HttpServletRequest request,HttpServletResponse response){
		String fStatus=null;
		String fId=null;
		if(request.getParameter("fStatus")!=null){
			fStatus=request.getParameter("fStatus").toString();
		}
		if(request.getParameter("fId")!=null){
			fId=request.getParameter("fId").toString();
		}
		logger.debug("传进来的参数为fStatus="+fStatus+"fId="+fId);
		if(fStatus!=null&&fId!=null){
			int result=fundAccountService.changeStatus(fId, fStatus);
			if(result==1){
				return new AjaxResultPo(true,"success");
			}
			return new AjaxResultPo(true,"error");
		}else{
			return new AjaxResultPo(true,"error");
		}
	}
	/**
	 * 校验账户信息是否存在   账户名和账户号都不能重复 这里使用的是bootstrap自带的校验
	 * bootstrap远程检验的时候需要的返回值形式为 result:{"valid",true or false}
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/check")
	@ResponseBody
	public String checkFundAccount(FundAccountPo fundAccountPo,HttpServletRequest request,HttpServletResponse response) throws IOException{
		logger.debug("传进来的参数为"+fundAccountPo.toString());
		int result=fundAccountService.check(fundAccountPo);
		logger.debug("结果result"+result);
		boolean bol = true;
		if(result!=0){
			bol=false;
		}
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("valid", bol);
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
	 * 添加账户信息
	 * @param fundAccountPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public AjaxResultPo addFundAccount(FundAccountPo fundAccountPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("添加穿进来的参数为"+fundAccountPo.toString());
		int result;
		try {
			result = fundAccountService.addFundAccount(fundAccountPo,request);
			//添加成功则返回success 否则返回error
			if(result>0){
				return new AjaxResultPo(true, "success");
			}else{
				return new AjaxResultPo(true, "error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResultPo(true, "error");
		}
	}
	/**
	 * 修改账户信息
	 * 当账户余额表中存在该账户信息时  账户余额不可修改可修改的为账户名称和负责人
	 * @param fundAccountPo
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/update")
	@ResponseBody
	public AjaxResultPo updateFundAccount(FundAccountPo fundAccountPo,HttpServletRequest request,HttpServletResponse response) throws Exception{
		logger.debug("修改账户信息传进来的参数为"+fundAccountPo.toString());
		int result=fundAccountService.updateFundAccount(fundAccountPo,request);
		if(result>0){
			return new AjaxResultPo(true, "success");
		}else{
			return new AjaxResultPo(true, "error");
		}
	}
	
	/**
	 *转账 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/transfer")
	@ResponseBody
	public AjaxResultPo transferFundAccount(HttpServletRequest request,HttpServletResponse response){
		int result=0;
		try{
			result=fundAccountService.transfer(request, response);
		}catch(Exception e){
			logger.debug("执行事务失败....");
		}
		
		if(result>0){
			return new AjaxResultPo(true, "success");
		}else{
			return new AjaxResultPo(true, "error");
		}
	}
}
