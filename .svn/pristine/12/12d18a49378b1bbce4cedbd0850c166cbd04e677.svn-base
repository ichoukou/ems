package com.channelsoft.ems.controller;

import com.channelsoft.ems.common.ConstantsMap;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.OldManLeavePo;
import com.channelsoft.ems.po.OldManMainPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.OldManLeaveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by wangjs on 2016/12/26.
 */
@Controller
@RequestMapping("/leave")
public class OldManLeaveController {

    private Logger logger= Logger.getLogger(OldManLeaveController.class);

    @Autowired
    private OldManLeaveService oldManLeaveService;

    @RequestMapping("/omLeave")
    public String getList(HttpServletRequest request, HttpServletResponse response){
        logger.debug("老人请假，已经跳转");
        return "oldManLeave/oldManLeaveList";
    }

    /**
     * @Method: queryOldManLeave
     * @Description: 分页查询老人请假
     * @Para: [OldManLeavePo, page, pageSize]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo queryOldManLeave(OldManLeavePo po,int page,int pageSize,
                                  HttpServletRequest request,HttpServletResponse response) {
        logger.debug("进入OldManLeaveController.queryList()方法");
        try {
            List<OldManLeavePo> getList=oldManLeaveService.queryListByPage(po,page,pageSize);
            int dataCount=oldManLeaveService.queryCount(po);
            return new AjaxResultPo(true,"",dataCount,getList);
        }catch (Exception e){
            logger.error("查询老人请假失败",e);
            return new AjaxResultPo(false,"老人请假失败");
        }

    }

    /**
     * @Method: addOldManLeave
     * @Description: 老人请假
     * @Para: [OldManLeavePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/addOldManLeave")
    public AjaxResultPo addOldManLeave(OldManLeavePo po, HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入OldManLeaveController.addOldManLeave()方法");
        try {
            UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
            po.setfCreatorID(user.getEmployId());
            po.setfNursinghomeID(user.getOldhouse());

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String nowTime=df.format(new Date());// new Date()为获取当前系统时间

            UUID uuid=UUID.randomUUID();
            po.setfNumber(uuid.toString());
            po.setfCreateTime(nowTime);
            oldManLeaveService.addOldManLeave(po);
            return new AjaxResultPo(true,"老人请假成功");
        }catch (Exception e){
            logger.error("老人请假失败",e);
            return new AjaxResultPo(false,"老人请假失败");
        }
    }

    /**
     * @Method: updOldManLeave
     * @Description: 老人销假
     * @Para: [OldManLeavePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/updOldManLeave")
    public AjaxResultPo updOldManLeave(OldManLeavePo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入OldManLeaveController.updOldManLeave()方法");
        logger.debug("请求参数: "+ po.toString());
        try {
            oldManLeaveService.updOldManLeave(po);
            return new AjaxResultPo(true, "老人销假成功");
        }catch (Exception e){
            logger.error("老人销假失败",e);
            return new AjaxResultPo(false, "老人销假失败");
        }
    }

    /**
     * @Method: delOldManLeave
     * @Description: 删除老人请假
     * @Para: [OldManLeavePo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/2/26
     */
    @ResponseBody
    @RequestMapping("/delOldManLeave")
    public AjaxResultPo delOldManLeave(OldManLeavePo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入OldManLeaveController.delOldManLeave()方法");
        logger.debug("请求参数: "+ po.toString());
        try{
            oldManLeaveService.delOldManLeave(po);
            return new AjaxResultPo(true, "删除老人请假成功");
        }catch (Exception e){
            logger.error("删除老人请假失败",e);
            return new AjaxResultPo(false, "删除老人请假失败");
        }

    }


}
