package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.PerfMaintainPo;
import com.channelsoft.ems.po.RankPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.PerfMaintainService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by 张鑫 on 2016/12/18.
 */
@Controller
@RequestMapping("/maintain")
public class PerfMaintainController {

    private static Logger logger = Logger.getLogger(PerfMaintainController.class);

    @Autowired
    private PerfMaintainService maintainService;

    @RequestMapping("/perfMaintain")
    public String gotoEmpRewards(HttpServletRequest request, HttpServletResponse response) {
        return "perfMaintain/perfMaintainList";
    }
    /**
     *@Description:查询 分页用
     *@Param:po
     * @Param:page
     * @param:pageSize
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo gotomaintainList(PerfMaintainPo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("gotomaintainList--请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<PerfMaintainPo> maintainList=maintainService.queryList(po,page,pageSize);
        logger.debug("gotomaintainList（）方法");
        int dataCount=maintainService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,maintainList);
    }

    /**
     *@Description:得到数据字典中的信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    @ResponseBody
    @RequestMapping("/showDCName")
    public AjaxResultPo showDCName(RankPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入showDCName方法");
        logger.debug("请求参数: "+ po.toString());
        List<Map<String,String>> list=this.maintainService.getDCname();
        logger.debug("list="+list.size());
        return new AjaxResultPo(true, "success", list.size(), list);
    }
    /**
     *@Description:根据Sum得到结果
     *@Param:request
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    @ResponseBody
    @RequestMapping("/showSum")
    public AjaxResultPo showSum( HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入showSum()方法");
        logger.debug("请求参数: ");
        String sum = request.getParameter("SUM");
        List<Map<String,String>> list= this.maintainService.getResult(sum);
        logger.debug("list:"+list.size());
        return new AjaxResultPo(true, "success",list.size(), list);
    }
    /**
     *@Description:保存信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    @ResponseBody
    @RequestMapping("/addMaintain")
    public AjaxResultPo addMaintain(PerfMaintainPo po, HttpServletRequest request, HttpServletResponse response) {
        logger.debug("进入   addMaintain()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("穿过来的对象"+po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setfNursingHomeID(user.getOldhouse());
        po.setfCreatorID(user.getEmployId());

        int count = Integer.parseInt(request.getParameter("count"));
        logger.debug("count:"+count);
        String fProjectID[]= request.getParameterValues("fProjectID");
        String[] nowFproject = fProjectID[0].split(",");

        String nowfScore[] = request.getParameterValues("fScore");
        String[] laterFscore = nowfScore[0].split(",");

        String idFproject="";
        for(int i=0;i<nowFproject.length;i++){
            idFproject+=nowFproject[i]+',';
        }

        String idScore="";
        for(int i=0;i<laterFscore.length;i++){
            idScore+=laterFscore[i]+',';
        }

        String newFproject = idFproject.substring(0,idFproject.length()-1);
        String newScore = idScore.substring(idScore.length()-(count*2),idScore.length()-1);
        logger.debug("newFproject:"+newFproject);
        logger.debug("newScore:"+newScore);
        String[] nowScore = newScore.split(",");
        try {
            if(this.maintainService.addParentTable(po)==0){
                logger.debug("增加成功");
                String fId=maintainService.queryFID();
                if(this.maintainService.insertID(nowFproject,nowScore,po,fId)==0){
                    logger.debug("增加子表成功");
                    return new AjaxResultPo(true, "success");
                }else {
                    logger.debug("进入增加子表方法,增加失败");
                    request.getSession().setAttribute("dmsg", "增加子表失败");
                    return null;
                }
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
     *@Description:删除
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    @ResponseBody
    @RequestMapping("/deleteMaintain")
    public AjaxResultPo deleteMaintain(PerfMaintainPo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   deleteMaintain()......");
        try {
            if(this.maintainService.deleteMaintain(po)==0){
                logger.debug("成功删除"+po.getfID());
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
     *@Description:查询出每个项目对应的分数
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    @ResponseBody
    @RequestMapping("/queryScore")
    public AjaxResultPo queryScore( HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入queryScore方法");
        String fNumber = request.getParameter("fNumber");
        List<Map<String,String>> fNumberList =this.maintainService.queryScore(fNumber);
        logger.debug("fNumberList:"+fNumberList);
        return new AjaxResultPo(true, "success",fNumberList.size(),fNumberList);
    }
    /**
     *@Description:更新
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    @ResponseBody
    @RequestMapping("/updateMaintain")
    public AjaxResultPo updateMaintain(PerfMaintainPo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   updateMaintain()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("需要更新字段"+po);
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        po.setfNursingHomeID(user.getOldhouse());
        po.setfCreatorID(user.getEmployId());

        int count = Integer.parseInt(request.getParameter("DCCount"));
        logger.debug("count:"+count);
        String fId= request.getParameter("DCID");
        String[] nowFId = fId.split(",");

        String nowfScore = request.getParameter("DCScore");
        String[] laterFscore = nowfScore.split(",");

        String projectID = request.getParameter("DCProjectID");
        String[] laterprojectID = projectID.split(",");

        String idFproject="";
        for(int i=0;i<laterprojectID.length;i++){
            idFproject+=laterprojectID[i]+',';
        }

        String Fproject="";
        for(int i=0;i<nowFId.length;i++){
            Fproject+=nowFId[i]+',';
        }

        String idScore="";
        for(int i=0;i<laterFscore.length;i++){
            idScore+=laterFscore[i]+',';
        }

        String newIdFproject = idFproject.substring(0,idFproject.length()-1);
        String newFproject = Fproject.substring(0,Fproject.length()-1);
        String newScore = idScore.substring(idScore.length()-(count*2),idScore.length()-1);
        logger.debug("newFproject:"+newFproject);
        logger.debug("newScore:"+newScore);
        logger.debug("newIdFproject:"+newIdFproject);
        String[] nowScore = newScore.split(",");
        String[] nowFID = newFproject.split(",");
        String[] nowIdFproject = newIdFproject.split(",");
        try {
            if(this.maintainService.updateMainMaintain(po)==0){
                logger.debug("更新主表成功");
                try{
                if(this.maintainService.updateMaintainList(nowFID,nowScore,po,nowIdFproject)==0){
                    logger.debug("更新子表成功");
                    return new AjaxResultPo(true, "success");
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
}
