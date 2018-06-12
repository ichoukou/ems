package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.*;
import com.channelsoft.ems.service.ArrgngHomeService;
import com.channelsoft.ems.service.FNursingService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
 * 
 * 养老院管理
 * @author  wuhl
 * @date 创建时间：2017年2月14日 下午9:13:41
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/nursing")
public class FNursingController {

private Logger logger=Logger.getLogger(FNursingController.class);
	
	@Autowired
	private FNursingService fNursingService;
	
	@RequestMapping("/nursing")
	public String gotodataFNursing(HttpServletRequest request ,HttpServletResponse response){
	
		return "fNursingManage/fNursingList";
	}
	
	
	/** 
	 * 
	 * 查询所有养老院
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */

	@ResponseBody
	@RequestMapping("/query") 
	public AjaxResultPo queryNursing(FNursingPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response)throws UnsupportedEncodingException {
	  logger.debug("进入查询controller获取养老院信息.......");
		po.setfNursingName(new String(po.getfNursingName().getBytes("ISO-8859-1"), "utf-8"));
		po.setfLeader(new String(po.getfLeader().getBytes("ISO-8859-1"), "utf-8"));
		po.setfStatus(new String(po.getfStatus().getBytes("ISO-8859-1"), "utf-8"));
		po.setfLeaderPhone(new String(po.getfLeaderPhone().getBytes("ISO-8859-1"), "utf-8"));

		List<FNursingPo> list=this.fNursingService.queryFNursing(po, page, pageSize);

		int count=this.fNursingService.queryFNursingCount(po);
		return new AjaxResultPo(true, "success", count, list);

	}

	/**
	 * @Method: getNusingHomeById
	 * @Description: 根据ID查询养老院信息
	 * @Para: [FNursingPo]
	 * @Retun: AjaxResultPo
	 * @Author: wangjs
	 * @Date: 2017/3/13
	 */
	@ResponseBody
	@RequestMapping("/getNusingHomeById")
	public AjaxResultPo getNusingHomeById(FNursingPo po, HttpServletRequest request , HttpServletResponse response)throws UnsupportedEncodingException {
	  logger.debug("进入查询FNursingController.getNusingHomeById()方法获取养老院信息");
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfID(user.getOldhouse());
		List<FNursingPo> list=this.fNursingService.getNusingHomeById(po);
		return new AjaxResultPo(true, "success", list.size(), list);

	}
	/** 
	 * 
	 * 删除养老院
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/deleteFNursing")
	public AjaxResultPo deleteFNursing(FNursingPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   deleteFNursing()......");
		logger.debug("请求参数: "+ po.toString());

		try {
			if(this.fNursingService.delete(po)==0){

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
	
	/** 
	 * 
	 * 启用养老院
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */

	@ResponseBody
	@RequestMapping("/startFNursing")
	public AjaxResultPo startFNursing(FNursingPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   startFNursing()......");
		logger.debug("请求参数: "+ po.toString());


		try {
			if(this.fNursingService.start(po)==0){

				return new AjaxResultPo(true, "success");

			}else{
				logger.debug("进入启用方法,启用失败");
				request.getSession().setAttribute("dmsg", "启用失败");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("dmsg", "启用异常");
			logger.debug("异常:"+e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	/** 
	 * 
	 * 增加养老院
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/addFNursing")
	public AjaxResultPo addFNursing(FNursingPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   addFNursing()......");
		logger.debug("请求参数: "+ po.toString());


		try {
			if(this.fNursingService.addFBursing(po)==0){

				return new AjaxResultPo(true, "success");

			}else{
				logger.debug("进入增加方法,增加失败");
				request.getSession().setAttribute("dmsg", "增加失败");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("dmsg", "增加异常");
			logger.debug("增加:"+e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	/** 
	 * 
	 * 查询所有养老院的收费模式
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/showFNursing")
	public AjaxResultPo showFNursing(HttpServletRequest request , HttpServletResponse response)throws UnsupportedEncodingException {
		logger.debug("进入查询controller获取养老院信息收费模式.......");

		List<Map<String,String>> list=this.fNursingService.showFursing();

		return new AjaxResultPo(true, "success", list.size(), list);

	}

	/** 
	 * 查询所有开启养老院
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */

	@ResponseBody
	@RequestMapping("/queryStartFNursing")
	public AjaxResultPo queryStartFNursing(HttpServletRequest request , HttpServletResponse response)throws UnsupportedEncodingException {
		logger.debug("进入查询controller获取所有启用的养老院.......");

		List<FNursingPo> list=this.fNursingService.queryStartFNursing();

		return new AjaxResultPo(true, "success", list.size(), list);

	}
	/** 
	 * 
	 * 查询所有养老院
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/queryAllFNursing")
	public AjaxResultPo queryAllFNursing(HttpServletRequest request , HttpServletResponse response)throws UnsupportedEncodingException {
		logger.debug("进入查询controller获取所有养老院信息.......");

		List<FNursingPo> list=this.fNursingService.queryAllFNursing();

		return new AjaxResultPo(true, "success", list.size(), list);

	}

	/** 
	 *   增加验证 
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */
	@RequestMapping("/check")
    @ResponseBody
    public String check(FNursingPo fNursingPo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.debug("传进来的参数为"+fNursingPo);
        int result=this.fNursingService.check(fNursingPo);
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
	 *  更新验证 
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */
    @RequestMapping("/updateCheck")
    @ResponseBody
    public String updateCheck(FNursingPo fNursingPo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.debug("传进来的参数为"+fNursingPo);
        int result=this.fNursingService.updateCheck(fNursingPo);
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
	 *增加养老院
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */

    @ResponseBody
    @RequestMapping("/addFNursingPo")
    public AjaxResultPo addFNursingPo(FNursingPo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   addFNursingPo()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("穿过来的对象"+po);

        try {
            if(this.fNursingService.addFBursing(po)==0){
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
	 *  更新养老院
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/updateFNursingPo")
	public AjaxResultPo updateFNursingPo(FNursingPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   updateFNursingPo()......");
		logger.debug("请求参数: "+ po.toString());
		logger.debug("穿过来的对象"+po);

		try {
			if(this.fNursingService.updateFBursing(po)==0){
				logger.debug("更新成功");
				return new AjaxResultPo(true, "success");
			}else{
				logger.debug("进入更新方法,增加失败");
				request.getSession().setAttribute("dmsg", "更新失败");
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


}
