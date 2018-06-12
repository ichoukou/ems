package com.channelsoft.ems.service;

import com.channelsoft.ems.po.MaterialManagePo;
import com.channelsoft.ems.po.WarehouseEntryPo;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxin on 2017/1/5.
 */
public interface ResEnterWarehouseService {
    /**
     *@Description:入库主表的显示
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    public int queryMainCount(WarehouseEntryPo po);
    public List<WarehouseEntryPo> queryMainList(WarehouseEntryPo po, int page, int pageSize);

    public int queryCount(MaterialManagePo po);
    public List<MaterialManagePo> queryList(MaterialManagePo po, int page, int pageSize);
    //物品正式入库
    public int creatStockAccount(WarehouseEntryPo po, List<WarehouseEntryPo> entryList, List<WarehouseEntryPo> stockList);

    //获得仓库中的物资的信息
    public List<Map<String,String>> getUpdateAllMaterial(WarehouseEntryPo po);

    //物品删除
    public int deleteUpdateStock(WarehouseEntryPo po, List<WarehouseEntryPo> stockListDelete);

    //物品更新
    public int updateStockAccount(WarehouseEntryPo po, String[] arr, List<WarehouseEntryPo> stockListDelete);

    //更新主表
    public int updateStock(WarehouseEntryPo po);
}
