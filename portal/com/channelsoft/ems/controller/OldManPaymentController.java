package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.OldManPaymentPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.OldManPaymentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by wangjs on 2016/12/27.
 */
@Controller
@RequestMapping("/pay")
public class OldManPaymentController {
    private static Logger logger = Logger.getLogger(SysManagerController.class);

    @Autowired
    private OldManPaymentService oldManPaymentService;

    /**
     * @Method: queryList
     * @Description: 查询应缴费用
     * @Para: [OldManPaymentPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    @ResponseBody
    @RequestMapping("/queryList")
    public AjaxResultPo queryList(OldManPaymentPo po,HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入OldManPaymentController.queryList()方法");
        List<OldManPaymentPo> list=oldManPaymentService.queryList(po);
        return new AjaxResultPo(true, "success", list.size(), list);
    }

    /**
     * @Method: queryLast
     * @Description: 查询最后一条应缴费用
     * @Para: [OldManPaymentPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    @ResponseBody
    @RequestMapping("/queryLast")
    public AjaxResultPo queryLast(HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入OldManPaymentController.queryLast()方法");
        List<OldManPaymentPo> lastOldManMain=oldManPaymentService.queryLast();
        return new AjaxResultPo(true, "success", lastOldManMain.size(), lastOldManMain);
    }

    /**
     * @Method: addPayment
     * @Description: 添加应缴表
     * @Para: [OldManPaymentPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    @ResponseBody
    @RequestMapping("/omPayment")
    public AjaxResultPo addPayment(OldManPaymentPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入OldManPaymentController.addPayment()方法");
        try{
            UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
            po.setfCreatorID(user.getEmployId());
            po.setFnursing_homeID(user.getOldhouse());

            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式
            String dateTime = dateFormat.format(now);
            po.setfCreateTime(dateTime);

            UUID uuid=UUID.randomUUID();
            po.setFnumber(uuid.toString());
            oldManPaymentService.addPayment(po);
            return new AjaxResultPo(true, "添加应缴费用成功");
        }catch (Exception e){
            logger.error("添加应缴费用失败",e);
            return new AjaxResultPo(false, "添加应缴费用失败");
        }

    }

    /**
     * @Method: updOmPayment
     * @Description: 更新应缴表
     * @Para: [OldManPaymentPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    @ResponseBody
    @RequestMapping("/updOmPayment")
    public AjaxResultPo updOmPayment(OldManPaymentPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入OldManPaymentController.updOmPayment()方法");
        try{
            oldManPaymentService.updOmPayment(po);
            return new AjaxResultPo(true, "修改应缴费用成功");
        }catch (Exception e){
            logger.error("修改应缴费用失败",e);
            return new AjaxResultPo(false, "修改应缴费用失败");
        }
    }

    /**
     * @Method: delOmPayment
     * @Description: 删除应缴费用
     * @Para: [OldManPaymentPo]
     * @Retun: AjaxResultPo
     * @Author: wangjs
     * @Date: 2017/3/13
     */
    @ResponseBody
    @RequestMapping("/delOmPayment")
    public AjaxResultPo delOmPayment(OldManPaymentPo po, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入OldManPaymentController.delOmPayment()方法");
        try{
            oldManPaymentService.delOmPayment(po);
            return new AjaxResultPo(true, "删除应缴费用成功");
        }catch (Exception e){
            logger.error("删除应缴费用失败",e);
            return new AjaxResultPo(false, "删除应缴费用失败");
        }
    }
}
