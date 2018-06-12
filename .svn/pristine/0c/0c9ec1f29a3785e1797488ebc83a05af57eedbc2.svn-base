package com.channelsoft.ems.service;

import com.channelsoft.ems.po.StockMaterialPo;
import com.channelsoft.ems.po.StorageOutDetailedEntryPo;

import java.util.List;

/**
 * Created by liuxing on 2016/12/27.
 */
public interface StorageOutDetailedService {
    /**
     * @description: 获得库存物品名称列表
     * @return List<StorageOutDetailedEntryPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageOutDetailedEntryPo> getStorageOutDetialedMaterialList();
    /**
     * @description: 获取经办人列表
     * @return List<StorageOutDetailedEntryPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageOutDetailedEntryPo> getOutOperatorList();
    /**
     * @description: 获取物品规格列表
     * @return List<String>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<String> getStorageOutStandardList();
    /**
     * @description: 获取仓库列表
     * @return List<StorageOutDetailedEntryPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageOutDetailedEntryPo> getStorageOutStoreHouseList();
    /**
     * @description: 条件查询出库单信息(分页)
     * @param po
     * @param page
     * @param pageSize
     * @return List<StorageOutDetailedEntryPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageOutDetailedEntryPo> queryStorageOutDetailedList(StorageOutDetailedEntryPo po,int page,int pageSize);
    /**
     * @description: 条件查询出库单信息行总数
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int queryStorageOutDetailedCount(StorageOutDetailedEntryPo po);
    /**
     * @description: 条件查询仓库中可出库物品信息(分页)
     * @param po
     * @param page
     * @param pageSize
     * @return List<StockMaterialPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StockMaterialPo> queryOutMaterial(StockMaterialPo po,int page,int pageSize);
    /**
     * @description: 条件查询仓库中可出库物品行总数
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int queryOutMaterialCount(StockMaterialPo po);
    /**
     * @description: 保存出库单操作
     * @param po
     * @param entryList
     * @param stockList
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int creatStockAccount(StorageOutDetailedEntryPo po,List<StorageOutDetailedEntryPo> entryList,List<StockMaterialPo> stockList);
    /**
     * @description: 加载物品名称列表
     * @param outNumber
     * @return List<StorageOutDetailedEntryPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageOutDetailedEntryPo> loadMaterialNameList(String outNumber);
    /**
     * @descriptidon: 更新出库单操作
     * @param delctFid
     * @param deleteEntryList
     * @param entryList
     * @param po
     * @param stockList
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int updateStockAccount(StorageOutDetailedEntryPo po,List<StorageOutDetailedEntryPo> entryList,List<StockMaterialPo> stockList,String delctFid,List<StorageOutDetailedEntryPo> deleteEntryList);
    /**
     * @description: 删除出库单
     * @param fnumber
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int deleteOutDetail(String fnumber);
}
