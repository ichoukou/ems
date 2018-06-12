package com.channelsoft.ems.service;

import java.util.List;
import java.util.Map;

import com.channelsoft.ems.po.StockMaterialPo;
import com.channelsoft.ems.po.StorageGoodsManagementPo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.channelsoft.ems.po.InStoragePo;
/** 
 * 
 * 物品入库
 * @author  wuhl
 * @date 创建时间：2016年12月8日 下午16:13:41 
 * @parameter  
 * @return  
 */
public interface InStorageService {

	public List<InStoragePo> queryInStorage( InStoragePo param, int page, int pageSize);

    public int queryInStorageCount( InStoragePo param);
     
    //进行查询遍历select
    public List<Map<String,String>> getFMaterialName();

    public List<Map<String,String>> getFStoreHouseName();
    
    public List<Map<String,String>> getFStandard();

    //添加物资
    public List<StockMaterialPo> getAllFMaterial(StockMaterialPo po, int page, int pageSize);

    public int getAllFMaterialCount(StockMaterialPo po);

    //获取仓库信息
    public List<Map<String ,String>>getHouse();

    //物品正式入库
    public int creatStockAccount(InStoragePo po,List<InStoragePo> entryList,List<InStoragePo> stockList);

    //物品更新
    public int updateStockAccount(InStoragePo po, String[] arr, List<InStoragePo> stockListDelete);

    //物品删除
    public int deleteUpdateStock(InStoragePo po, List<InStoragePo> stockListDelete);

        //根据指定单号查询 子表
    public List<Map<String,String>> getUpdateAllMaterial(InStoragePo po);

    //更新主表
    public int updateStock(InStoragePo po);






    }
