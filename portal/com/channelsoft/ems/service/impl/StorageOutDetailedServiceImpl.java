package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.StorageOutDetailedMapper;
import com.channelsoft.ems.po.StockMaterialPo;
import com.channelsoft.ems.po.StorageOutDetailedEntryPo;
import com.channelsoft.ems.service.StorageOutDetailedService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxing on 2016/12/27.
 */
@Service
public class StorageOutDetailedServiceImpl implements StorageOutDetailedService {

    private static Logger logger= Logger.getLogger(StorageOutDetailedServiceImpl.class);
    @Autowired
    private StorageOutDetailedMapper mapper;



    public List<StorageOutDetailedEntryPo> getStorageOutDetialedMaterialList() {
        logger.debug("进入  getStorageOutDetialedMaterialList  方法 ");
        List<StorageOutDetailedEntryPo> list= new ArrayList<StorageOutDetailedEntryPo>();
        list= mapper.getStorageOutDetailedMaterialList();
        logger.debug("getStorageOutDetialedMaterialList 获取数据："+list.toString());
        return list;
    }

    public List<StorageOutDetailedEntryPo> getOutOperatorList() {
        logger.debug("进入  getOutOperatorList  方法 ");
        List<StorageOutDetailedEntryPo> list= new ArrayList<StorageOutDetailedEntryPo>();
        list= mapper.getOutOperatorList();
        logger.debug(" getOutOperatorList获得的结果："+list.toString());
        return list;
    }

    public List<String> getStorageOutStandardList() {
        logger.debug("进入  getStorageOutDetialedMaterialList  方法 ");
        List<String> list= new ArrayList<String>();
        list= mapper.getStorageOutStandardList();
        logger.debug(" getStorageOutStandardList获取数据："+list.toString());
        return list;
    }

    public List<StorageOutDetailedEntryPo> getStorageOutStoreHouseList() {
        logger.debug("进入  getStorageOutStoreHouseList  方法 ");
        List<StorageOutDetailedEntryPo> list= new ArrayList<StorageOutDetailedEntryPo>();
        list= mapper.getStorageOutStoreHouseList();
        logger.debug("getStorageOutStoreHouseList获取数据："+list.toString());
        return list;
    }

    public List<StorageOutDetailedEntryPo> queryStorageOutDetailedList(StorageOutDetailedEntryPo po, int page, int pageSize) {
        logger.debug("进入  queryStorageOutDetailedList  方法 ");
        logger.debug(" 请求参数：po: "+po.toString()+"Page:"+page+"pageSize:" + pageSize);
        List<StorageOutDetailedEntryPo> list= new ArrayList<StorageOutDetailedEntryPo>();
        list= mapper.getStorageOutDetailedList(po,page,pageSize);
        logger.debug("queryStorageOutDetailedList :获取结果："+list.toString());
        return list;
    }

    public int queryStorageOutDetailedCount(StorageOutDetailedEntryPo po) {
        logger.debug("进入  queryStorageOutDetailedList  方法 ");
        int count = mapper.getStorageOutDetailedCount(po);
        logger.debug("获取结果：count："+count);
        return count;
    }

    public List<StockMaterialPo> queryOutMaterial(StockMaterialPo po, int page, int pageSize) {
        logger.debug("进入  queryOutMaterial  方法 ");
        logger.debug(" 请求参数：po: "+po.toString()+"Page:"+page+"pageSize:" + pageSize);
        List<StockMaterialPo> list= new ArrayList<StockMaterialPo>();
        list= mapper.getStockMaterial(po,page,pageSize);
        logger.debug("queryOutMaterial :获取结果："+list.toString());
        return list;
    }

    public int queryOutMaterialCount(StockMaterialPo po) {
        logger.debug("进入  queryOutMaterialCount  方法 ");
        int count = mapper.getStockMaterialCount(po);
        logger.debug("获取结果：count："+count);
        return count;
    }

    @Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,readOnly=false,rollbackFor=Exception.class)
    public int creatStockAccount(StorageOutDetailedEntryPo po, List<StorageOutDetailedEntryPo> entryList, List<StockMaterialPo> stockList) {
        logger.debug("进入 creatStockAccount  方法");

        try {
            logger.debug("进行插入");
            this.mapper.insertOutStorage(po);
            int FID=this.mapper.getOutStorageInsertID();
            for (StorageOutDetailedEntryPo entry:entryList) {
                entry.setFpid(Integer.toString(FID));
            }
            mapper.insertOutStorageEntry(entryList);
            mapper.updateStockAccountList(stockList);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("插入错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public List<StorageOutDetailedEntryPo> loadMaterialNameList(String outNumber) {
        logger.debug("进入 loadMaterialNameList  方法");
        List<StorageOutDetailedEntryPo> list=new ArrayList<StorageOutDetailedEntryPo>();
        list=mapper.loadMaterialNameList(outNumber);
        return list;
    }
    @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false,rollbackFor=Exception.class)
    public int updateStockAccount(StorageOutDetailedEntryPo po, List<StorageOutDetailedEntryPo> entryList, List<StockMaterialPo> stockList, String delctFid,List<StorageOutDetailedEntryPo> deleteEntryList) {
            logger.debug("进入 updateStockAccount  方法");
            try {
                logger.debug("进行修改");
                for (StorageOutDetailedEntryPo entry: deleteEntryList) {
                    this.mapper.deleteupdateStockAccount(entry);
                }
                this.mapper.deleteOutStorageEntry(delctFid);
                this.mapper.updateOutStorage(po);

                if(entryList.size()>0)
                {
                    this.mapper.insertOutStorageEntry(entryList);
                    this.mapper.updateStockAccountList(stockList);
                }
            } catch (Exception e) {
                // TODO: handle exception
                logger.debug("修改错误"+e.getMessage());
                e.printStackTrace();
                return 1;
            }
        return 0;
    }
    @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,readOnly=false,rollbackFor=Exception.class)
    public int deleteOutDetail(String fnumber) {
        logger.debug("进入 deleteOutDetail  方法");
        try {
            logger.debug("进行删除");
            List<StorageOutDetailedEntryPo> poList=new ArrayList<StorageOutDetailedEntryPo>();
            poList=this.mapper.loadMaterialNameList(fnumber);
            String delctFid="(0";
            for (StorageOutDetailedEntryPo entry: poList) {
                this.mapper.deleteupdateStockAccount(entry);
                delctFid=delctFid+","+entry.getFid();
            }
            delctFid=delctFid+")";
            this.mapper.deleteOutStorageEntry(delctFid);
            this.mapper.deleteOutStorage(fnumber);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("修改错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int updateStockAccount(List<StockMaterialPo> list) {
        logger.debug("进入 insertStockAccount  方法");
        for (StockMaterialPo po: list) {
            mapper.updateStockAccount(po);
        }
        return 1;
    }
}
