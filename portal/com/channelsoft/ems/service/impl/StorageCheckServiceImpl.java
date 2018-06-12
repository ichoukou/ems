package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.StorageCheckMapper;
import com.channelsoft.ems.po.StorageCheckPo;
import com.channelsoft.ems.service.StorageCheckService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxing on 2017/1/6.
 */
@Service

public class StorageCheckServiceImpl  implements StorageCheckService{
    private static Logger logger= Logger.getLogger(StorageCheckServiceImpl.class);

    @Autowired
    private  StorageCheckMapper mapper;


    public List<StorageCheckPo> queryStorageCheckList(StorageCheckPo po, int page, int pageSize) {
        logger.debug("进入 queryStorageCheckList  方法");
        List<StorageCheckPo> list = new ArrayList<StorageCheckPo>();
        list = this.mapper.queryStorageCheckList(po,page,pageSize);
        return list;
    }

    public int  queryStorageCheckCount(StorageCheckPo po) {
        logger.debug("进入 queryStorageCheckCount  方法");
        int count = this.mapper.queryStorageCheckCount(po);
        return count;
    }

    public List<StorageCheckPo> getPrintList(String storageID, String checkDate) {
        logger.debug("进入  getPrintList方法");
        List<StorageCheckPo> list=new ArrayList<StorageCheckPo>();
        list=mapper.getPrintList(storageID,checkDate);
        logger.debug("getPrintList方法获取的结果："+list.toString());
        return list;
    }

    public List<StorageCheckPo> getStorageMaterial(String storageID) {
        logger.debug("进入  getStorageMaterial");
        List<StorageCheckPo> list=new ArrayList<StorageCheckPo>();
        list=mapper.getStorageMaterial(storageID);
        logger.debug("getStorageMaterial方法获取的结果："+list.toString());
        return list;
    }

    public int getStorageMaterialCount(String storageID) {
        logger.debug("进入  getStorageMaterialCount");
        int count=mapper.getStorageMaterialCount(storageID);
        logger.debug("getStorageMaterialCount方法获取的结果："+count);
        return count;
    }

    public List<StorageCheckPo> getCheckManList() {
        logger.debug("进入  getStorageMaterialCount");
        List<StorageCheckPo> list=new ArrayList<StorageCheckPo>();
        list=mapper.getCheckManList();
        return list;
    }

    public int addCheck(List<StorageCheckPo> list) {
        logger.debug("进入 addCheck  方法");
        try {
            logger.debug("进行插入");
            mapper.addCheck(list);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("插入错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}
