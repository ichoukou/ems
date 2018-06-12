package com.channelsoft.ems.service;

import com.channelsoft.ems.po.StorageCheckPo;

import java.util.List;

/**
 * Created by liuxing on 2017/1/6.
 */
public interface StorageCheckService {
    /**
     * @description: 盘点列表查询(分页)
     * @param po
     * @param page
     * @param pageSize
     * @return List<StorageCheckPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageCheckPo> queryStorageCheckList(StorageCheckPo po,int page,int pageSize);
    /**
     * @description: 盘点列表总数
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int  queryStorageCheckCount(StorageCheckPo po);
    /**
     * @description: 根据选择的盘点列表行，得到需要打印的列表
     * @param storageID
     * @param checkDate
     * @return List<StorageCheckPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageCheckPo> getPrintList(String storageID,String checkDate);
    /**
     * @description: 根据仓库ID得到该仓库里所有的物品列表
     * @param storageID
     * @return List<StorageCheckPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageCheckPo> getStorageMaterial(String storageID);
    /**
     * @description: 根据仓库ID得到该仓库里所有的物品行总数
     * @param storageID
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int getStorageMaterialCount(String storageID);
    /**
     * @description: 加载checkman  select下拉框
     * @return List<StorageCheckPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageCheckPo> getCheckManList();
    /**
     * @description: 检查表单增加
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int addCheck(List<StorageCheckPo> list);

}
