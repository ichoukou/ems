package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.FundAccountBillDelRecordPo;
import com.channelsoft.ems.service.FundAccountBillDelRecordService;
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
@RequestMapping("/fundDelQuery")
public class FundDelQueryController {

    private Logger logger=Logger.getLogger(FundDelQueryController.class);

    @Autowired
    private FundAccountBillDelRecordService fundAccountBillDelService;

    @RequestMapping("/gotoFundDel")
    public String gotoFundDel(HttpServletResponse response, HttpServletRequest request)
    {
        logger.debug("进入 gotoFundDel 方法");
        return "fundQuery/fundDelQuery";
    }
    /**
     * 财务管理 删除记录查询  带分页
     * @param page
     * @param pageSize
     * @param fOprationer
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/queryFundDelRecord")
    @ResponseBody
    public AjaxResultPo queryFundDelRecord(String fOprationer,String Ldate,String Edate,int page,int pageSize,HttpServletRequest request,HttpServletResponse response){
        logger.debug("进入 queryFundDelRecord 方法");
        logger.debug("请求参数为：fOprationer："+fOprationer+" Edate:"+Edate+" Ldata:"+Ldate+" pageSize:"+pageSize+" page:"+page);
        List<FundAccountBillDelRecordPo> list=fundAccountBillDelService.queryFundAccountBillDelRecord(fOprationer,Ldate,Edate,page,pageSize);
        int count=fundAccountBillDelService.queryFundAccountBillDelRecordCount(fOprationer,Ldate,Edate,page,pageSize);
        return new AjaxResultPo(true,"success",count,list);
    }

}
