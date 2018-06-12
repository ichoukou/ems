package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.FundAccountBillDelRecordPo;
import com.channelsoft.ems.po.FundAccountBillModRecordPo;
import com.channelsoft.ems.service.FundAccountBillDelRecordService;
import com.channelsoft.ems.service.FundAccountBillModRecordService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by liuxing on 2017/2/27.
 */
@Controller
@RequestMapping("/fundModQuery")
public class FundModQueryController {

    private Logger logger=Logger.getLogger(FundModQueryController.class);

    @Autowired
    private FundAccountBillModRecordService fundAccountBillModService;

    @RequestMapping("/gotoFundMod")
    public String gotoFundMod(HttpServletResponse response, HttpServletRequest request)
    {
        logger.debug("进入 gotoFundMod 方法");
        return "fundQuery/fundModQuery";
    }
    /**
     * 财务管理 修改记录查询  带分页
     * @param page
     * @param pageSize
     * @param fOprationer
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/queryFundModRecord")
    @ResponseBody
    public AjaxResultPo queryFundModRecord(String fOprationer,String Ldate,String Edate,int page,int pageSize,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入 queryFundModRecord 方法");
        logger.debug("请求参数为：fOprationer："+fOprationer+" Edate:"+Edate+" Ldata:"+Ldate+" pageSize:"+pageSize+" page:"+page);
        List<FundAccountBillModRecordPo> list=fundAccountBillModService.queryFundAccountBillModRecord(fOprationer,Ldate,Edate,page,pageSize);
        int count=fundAccountBillModService.queryFundAccountBillModRecordCount(fOprationer,Ldate,Edate,page,pageSize);
        return new AjaxResultPo(true,"success",count,list);
    }

}
