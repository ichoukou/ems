package com.channelsoft.ems.service;

import com.channelsoft.ems.po.StorageGoodsManagementPo;
import com.channelsoft.ems.po.StorageGoodsSortingPo;

import java.util.List;

/**
 * Created by liuxing on 2016/12/23.
 */
public interface StorageGoodsService {
    /**
     * @description: 获取物品分类页面的全部类别列表
     * @return List<StorageGoodsSortingPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageGoodsSortingPo> getStorageGoodsSortingList();
    /**
     * @description: 获得物品分类子分类
     * @param id
     * @return List<StorageGoodsSortingPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageGoodsSortingPo> getStorageGoodsSortingSonList(String id);
    /**
     * @description: 获取未禁用物品分类类别列表
     * @param id
     * @return List<StorageGoodsSortingPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageGoodsSortingPo> getStorageGoodsSortingTypeList(String id);
    /**
     * @description: 物品管理页面获取全部的物品分类类别列表
     * @param id
     * @return List<StorageGoodsSortingPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageGoodsSortingPo> getStorageGoodsSortingTypeList2(String id);
    /**
     * @description: 更新时的物品分类列表
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int updateStorageGoods (StorageGoodsSortingPo po);
    /**
     * @description: 物品管理的物品更新操作
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int updateStorageGoodsManagement (StorageGoodsManagementPo po);
    /**
     * @description: 物品分类的添加操作
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int addStorageGoods (StorageGoodsSortingPo po);
    /**
     * @description: 物品添加操作
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int addStorageGoodsManagement (StorageGoodsManagementPo po);
    /**
     * @description: 物品分类 的禁用
     * @param id
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int forbiddenStorageGoodsType (String id);
    /**
     * @description: 物品的禁用
     * @param id
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int forbiddenStorageGoodsManagement (String id);
    /**
     * @description: 物品的启用
     * @param id
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int startStorageGoodsManagement (String id);
    /**
     * @description: 禁用物品分类时判断判断是否含有子分类
     * @param id
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int searchStorageGoodsSonCount(String id);
    /**
     * @description: 条件查询物品管理页面获取物品列表（分页）
     * @param po
     * @param page
     * @param pageSize
     * @return List<StorageGoodsManagementPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<StorageGoodsManagementPo> getStorageGoodsManagementList(StorageGoodsManagementPo po,int page,int pageSize);
    /**
     * @description: 条件查询物品管理页面获取物品列表总行数
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int getStorageGoodsManagementCount(StorageGoodsManagementPo po);

}
