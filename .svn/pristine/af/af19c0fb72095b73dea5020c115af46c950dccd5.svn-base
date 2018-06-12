package com.channelsoft.ems.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.CwglPaymentPo;
import com.channelsoft.ems.po.FundAccountBillPo;
import com.channelsoft.ems.po.FundAccountPo;
import com.channelsoft.ems.po.MessagePo;
import com.channelsoft.ems.service.EmpMessageService;
import com.channelsoft.ems.service.FundAccountBillService;
import com.channelsoft.ems.service.FundAccountService;

/**
 *  账户收入
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年2月14日
 */
@Controller
@RequestMapping("/fundAccountBill")
public class FundAccountBillController {

	@Autowired
	private FundAccountBillService fundAccountBillService;

	private static List<CwglPaymentPo> poList=new ArrayList<CwglPaymentPo>();

	@Autowired
	private FundAccountService fundAccountService;

	@Autowired
	private EmpMessageService empMessageService;

	private Logger logger=Logger.getLogger(FundAccountBillController.class);
	/**
	 * 跳转至列表页
	 * @return
	 */
	@RequestMapping("/getFundAccountBillList")
	public String getFundAccountBillList(){
		return "/fundAccountQuery/fundAccountBillList";
	}

	/**
	 * 跳转至账户收入页面
	 * @return
	 */
	@RequestMapping("/getFundAccountIn")
	public String getFundAccountIn(){
		return "/fundAccountIn/fundAccountIn";
	}

	/**
	 * 跳转至账户支出页面
	 * @return
	 */
	@RequestMapping("/getFundAccountOut")
	public String getFundAccountOut(){
		return "/fundAccountOut/fundAccountOut";
	}

	@RequestMapping("/query")
	@ResponseBody
	public AjaxResultPo queryToList(int page,int pageSize,FundAccountBillPo fundAccountBillPo,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		logger.debug("查询账户明细的参数page为"+page);
		logger.debug("pageSize为"+pageSize);
		request.setCharacterEncoding("UTF-8");
		if(!StringUtils.isEmpty(fundAccountBillPo.getfOperator())){
			fundAccountBillPo.setfOperator(fundAccountBillPo.getfOperator());
		}
		if(fundAccountBillPo!=null){
			logger.debug("fundAccountBillPo"+fundAccountBillPo.toString());
		}
		List<FundAccountBillPo> list=fundAccountBillService.queryFundAccountBill(page, pageSize, fundAccountBillPo);
		for(int i=0;i<list.size();i++){
			FundAccountPo fundAccountPo=new FundAccountPo();
			fundAccountPo.setfId(list.get(i).getfFundaccount());
			List<FundAccountPo> poList=fundAccountService.queryFundAccount(0, 1, fundAccountPo, request, response);
			list.get(i).setfName((poList.get(0).getfName()));

			if(!StringUtils.isEmpty(list.get(i).getfAuditorID())){
				MessagePo po=new  MessagePo();
				po.setfId(list.get(i).getfAuditorID());
				logger.debug(empMessageService.queryList(po, 0, 1).get(0).getfStaffName());
				list.get(i).setfAuditorName(empMessageService.queryList(po, 0, 1).get(0).getfStaffName());
			}
			/*if(!StringUtils.isEmpty(list.get(i).getfModifierID())){
				MessagePo po=new  MessagePo();
				po.setfId(list.get(i).getfModifierID());
				list.get(i).setfModifierName(empMessageService.queryList(po, 0, 1).get(0).getfStaffName());
			}*/
			if(!StringUtils.isEmpty(list.get(i).getfCreatorID())){
				MessagePo po=new  MessagePo();
				po.setfId(list.get(i).getfCreatorID());
				list.get(i).setfCreatorName(empMessageService.queryList(po, 0, 1).get(0).getfStaffName());
			}

		}
		int total=fundAccountBillService.getTotal(fundAccountBillPo);
		return new AjaxResultPo(true,"success",total,list);
	}

	/**
	 * 账户收入
	 * @param fundAccountBillPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/fundAccountIn")
	@ResponseBody
	public AjaxResultPo fundAccountBillIn(FundAccountBillPo fundAccountBillPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("账户收入接受的参数为"+fundAccountBillPo.toString());
		FundAccountPo fundAccountPo=new FundAccountPo();
		fundAccountPo.setfRestAmount(fundAccountBillPo.getfAmount());
		fundAccountPo.setfId(fundAccountBillPo.getfFundaccount());
		try{
			int result =fundAccountService.fundAccountIn(fundAccountPo, fundAccountBillPo,request);
			if(result>0){
				return new AjaxResultPo(true,"success");
			}else{
				return new AjaxResultPo(false,"failed");
			}
		}catch(Exception e){
			logger.debug("账户收入执行失败");
			return new AjaxResultPo(true,"failed");
		}
	}
	/**
	 * 修改账户收入信息
	 * @param fundAccountBillPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updFundAccount")
	@ResponseBody
	public AjaxResultPo updFundAccountBill(FundAccountBillPo fundAccountBillPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("传入updFundAccountBill的参数为"+fundAccountBillPo.toString());
		logger.debug("传进来");
		try {
			int result=fundAccountBillService.updateFundAccountBill(fundAccountBillPo, request);
			if(result>0){
				return new AjaxResultPo(true,"success");
			}else{
				return new AjaxResultPo(true,"falier");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResultPo(true,"failer");
		}
	}

	/**
	 * 删除明细记录
	 * @param fundAccountBillPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/delFundAccount")
	@ResponseBody
	public AjaxResultPo delFundAccountBill(FundAccountBillPo fundAccountBillPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("传入delFundAccountBill的参数为"+fundAccountBillPo.toString());
		try {
			int result=fundAccountBillService.delFundAccountBill(fundAccountBillPo, request);
			if(result>0){
				return new AjaxResultPo(true,"success");
			}else{
				return new AjaxResultPo(true,"falier");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResultPo(true,"failer");
		}
	}

	/**
	 * 账户支出
	 * @param fundAccountBillPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/fundAccountOut")
	@ResponseBody
	public AjaxResultPo fundAccountBillOut(FundAccountBillPo fundAccountBillPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("账户支出接受的参数为"+fundAccountBillPo.toString());
		FundAccountPo fundAccountPo=new FundAccountPo();
		fundAccountPo.setfRestAmount(fundAccountBillPo.getfAmount());
		fundAccountPo.setfId(fundAccountBillPo.getfFundaccount());
		try{
			int result =fundAccountService.fundAccountOut(fundAccountPo, fundAccountBillPo,request);
			if(result>0){
				return new AjaxResultPo(true,"success");
			}else{
				return new AjaxResultPo(false,"failed");
			}
		}catch(Exception e){
			logger.debug("账户收入执行失败");
			return new AjaxResultPo(true,"failed");
		}
	}

	/**
	 * 得到收支杂项
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getPayments")
	@ResponseBody
	public List<CwglPaymentPo> getPayments(String id,HttpServletRequest request,HttpServletResponse response){
		logger.debug("查询杂项传进来的参数id"+id);
		String type=request.getParameter("type");
		List<CwglPaymentPo> list = fundAccountBillService.getPayments(id,type);
		poList.clear();
		 listFormat(list,"0",0);
	     return poList;
	}
	/**
	 * 更改状态
	 * @param fundAccountBillPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/changeStatus")
	@ResponseBody
	public AjaxResultPo changeStatus(FundAccountBillPo fundAccountBillPo,HttpServletRequest request,HttpServletResponse response){
		int result=fundAccountBillService.changeStatus(fundAccountBillPo);
		if(result>0){
			return new AjaxResultPo(true,"success");
		}else{
			return new AjaxResultPo(false,"failed");
		}
	}

	public static void listFormat(List<CwglPaymentPo> list,String id,int level){
		boolean yezi=true;
		int length=poList.size();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getFparentid().equals(id)){
				yezi=false;
				StringBuffer str=new StringBuffer();
				for(int j=0;j<level;j++){
					if(j==(level-1)){
						str.append("&nbsp;&nbsp;"+"▶");
					}else{
						str.append("&nbsp;&nbsp;");
					}
				}
				list.get(i).setFname(str+list.get(i).getFname());
				list.get(i).setfRemarks("0");
				poList.add(list.get(i));
				listFormat(list,list.get(i).getFid(),level+1);
			}
		}
		if(!yezi && !id.equals("0")){
			poList.get(length-1).setfRemarks("1");
		}

	}

}
