package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.RankPo;
import com.channelsoft.ems.service.AssRankService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/assess")

/**
 * 评估定级：张鑫
 */
public class AssessRankController {

private static Logger logger = Logger.getLogger(AssessRankController.class);

	@Autowired
	private AssRankService assRankService;

	@RequestMapping("/rank")
	public String gotoAssRank(HttpServletRequest request ,HttpServletResponse response){
		return "assessRank/assessRankList";
	}
	/**
	*@Description:查询
	*@Param:RankPo ,page, pageSize
	*@return:AjaxResultPo
	*@author:zhangxin
	*@Date:2017/3/13
	*/

	@ResponseBody
	@RequestMapping("/query")
	public AjaxResultPo gotoList(RankPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
		logger.debug("请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
		List<RankPo> list = this.assRankService.getFResultSum();
		return new AjaxResultPo(true, "success", list.size(), list);
	}
	/**
	 *@Description:得到评估项目，和评估项目对应的分数
	 *@Param:RankPo
	 *@return:AjaxResultPo
	 *@author:zhangxin
	 *@Date:2017/3/13
	 */
	@ResponseBody
	@RequestMapping("/showName")
	public AjaxResultPo showName(RankPo po, HttpServletRequest request , HttpServletResponse response){
		logger.debug("进入 showName() 方法");
		logger.debug("请求参数: "+ po.toString());
		List<RankPo>  list=this.assRankService.getFlevelNameValue();
		logger.debug("list"+list);
		return new AjaxResultPo(true, "success", list.size(), list);
	}

	/**
	 *@Description:得到数据字典中的数据
	 *@Param:RankPo
	 *@return:AjaxResultPo
	 *@author:zhangxin
	 *@Date:2017/3/13
	 */
	@ResponseBody
	@RequestMapping("/showDname")
	public AjaxResultPo showDname(RankPo po, HttpServletRequest request , HttpServletResponse response){
		logger.debug("进入 showDname() 方法");
		logger.debug("请求参数: "+ po.toString());
		List<Map<String, String>> list = this.assRankService.getDicname();
		logger.debug("list"+list);
		return new AjaxResultPo(true, "success", list.size(), list);
	}

	/**
	 *@Description:根据分数，得到所对应的评估定级
	 *@Param:RankPo
	 *@return:AjaxResultPo
	 *@author:zhangxin
	 *@Date:2017/3/13
	 */
	@ResponseBody
	@RequestMapping("/showSum")
	public AjaxResultPo showSum(String SUM, HttpServletRequest request , HttpServletResponse response){
		logger.debug("1 进入   获取Sum......");
		logger.debug("请求参数: ");
		List<Map<String,String>> list= assRankService.getStatus(SUM);
		return new AjaxResultPo(true, "success",list.size(),list);
	}
	@ResponseBody
	@RequestMapping("/addAssRank")
	public AjaxResultPo addEvaluationScore(RankPo po, HttpServletRequest request , HttpServletResponse response){
		logger.debug("进入   addRank()......");
		logger.debug("请求参数: "+ po.toString());
		logger.debug("穿过来的对象"+po);

		logger.debug("分值的和："+po.getResultSum());
		try {
			if(this.assRankService.addSum(po)==0){
				logger.debug("增加成功");
				List<RankPo> list = this.assRankService.getFResultSum();
				return new AjaxResultPo(true, "success", list.size(), list);
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
}
