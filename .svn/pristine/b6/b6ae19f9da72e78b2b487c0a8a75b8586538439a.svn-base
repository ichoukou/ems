package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.StockMaterialPo;
import com.channelsoft.ems.po.StorageGoodsSortingPo;
import com.channelsoft.ems.service.StockAccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxing on 2017/1/4.
 */
@Controller
@RequestMapping("/StockAccount")
public class StockAccountController {
    private static Logger logger=Logger.getLogger(StockAccountController.class);

    @Autowired
    private StockAccountService stockAccountService;

    @RequestMapping("/salist")
    public String gotoStockAccountList(){
        logger.debug("gotoStockAccountList已跳转");
        return "stockAccount/stockAccountList";
    }
    /**
     * @description: 查询库存所有物品信息
     * @param page
     * @param pageSize
     * @param po
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/queryStockAccountList")
    public AjaxResultPo queryStockAccountList(StockMaterialPo po, int page, int pageSize, HttpServletResponse response, HttpServletRequest request){
        logger.debug("进入   queryStockAccountList  方法");
        logger.debug("请求参数：po"+po.toString()+"page:"+page+"pageSize:" + pageSize);
        List<StockMaterialPo> list= new ArrayList<StockMaterialPo>();
        int count = stockAccountService.queryStockMaterialCount(po);
        list = stockAccountService.queryStockMaterialList(po,page,pageSize);
        return new AjaxResultPo(true,"success",count,list);
    }


}
