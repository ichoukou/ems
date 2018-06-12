package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.StockAccountMapper;
import com.channelsoft.ems.po.StockMaterialPo;
import com.channelsoft.ems.service.StockAccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxing on 2017/1/4.
 */
@Service
public class StockAccountServiceImpl implements StockAccountService{
    private static Logger logger= Logger.getLogger(StockAccountServiceImpl.class);

    @Autowired
    private StockAccountMapper mapper;

    public List<StockMaterialPo> queryStockMaterialList(StockMaterialPo po, int page, int pageSize) {
        logger.debug("进入    queryStockMaterialList  方法");
        List<StockMaterialPo> list = new ArrayList<StockMaterialPo>();
        list = mapper.queryStockAccountList(po,page,pageSize);
        return list;
    }

    public int queryStockMaterialCount(StockMaterialPo po) {
        logger.debug("进入    queryStockMaterialCount  方法");
        int count = mapper.queryStockAccountCount(po);
        return count;
    }
}
