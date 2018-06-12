package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.StorageGoodsMapper;
import com.channelsoft.ems.po.StorageGoodsManagementPo;
import com.channelsoft.ems.po.StorageGoodsSortingPo;
import com.channelsoft.ems.service.StorageGoodsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxing on 2016/12/23.
 */
@Service
public class StorageGoodsServiceImpl implements StorageGoodsService {
    private static Logger logger= Logger.getLogger(StorageGoodsServiceImpl.class);

    @Autowired
    private StorageGoodsMapper mapper;

    public List<StorageGoodsSortingPo> getStorageGoodsSortingList() {
        logger.debug("进入 getStorageGoodsSortingList 方法");
        List<StorageGoodsSortingPo> typeList=new ArrayList<StorageGoodsSortingPo>();
        typeList = mapper.getStorageGoodsSorting();
        return typeList;
    }

    public List<StorageGoodsSortingPo> getStorageGoodsSortingSonList(String id) {
        logger.debug("进入 getStorageGoodsSortingSonList 方法");
        List<StorageGoodsSortingPo> list= new ArrayList<StorageGoodsSortingPo>();
        list=mapper.getStorageGoodsSortingSon(id);
        return list;
    }

    public List<StorageGoodsSortingPo> getStorageGoodsSortingTypeList(String id) {
        logger.debug("进入 getStorageGoodsSortingTypeList 方法");
        List<StorageGoodsSortingPo> list= new ArrayList<StorageGoodsSortingPo>();
        list=mapper.getStorageGoodsSortingTypeList(id);
        return list;
    }
    public List<StorageGoodsSortingPo> getStorageGoodsSortingTypeList2(String id) {
        logger.debug("进入 getStorageGoodsSortingTypeList 方法");
        List<StorageGoodsSortingPo> list= new ArrayList<StorageGoodsSortingPo>();
        list=mapper.getStorageGoodsSortingTypeList2(id);
        return list;
    }

    public int updateStorageGoods(StorageGoodsSortingPo po) {
        logger.debug("进入 updateStorageGoods  方法");
        try {
            logger.debug("进行更新"+po);
            this.mapper.updateStorageGoodsSorting(po) ;
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int updateStorageGoodsManagement(StorageGoodsManagementPo po) {
        logger.debug("进入 updateStorageGoodsManagement  方法");
        try {
            logger.debug("进行更新"+po);
            this.mapper.updateStorageGoodsManagement(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int addStorageGoods(StorageGoodsSortingPo po) {
        logger.debug("进入 addStorageGoods  方法");
        try {
            logger.debug("进行添加"+po);
            this.mapper.addStorageGoodsSorting(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int addStorageGoodsManagement(StorageGoodsManagementPo po) {
        logger.debug("进入 addStorageGoodsManagement  方法");
        try {
            logger.debug("进行添加"+po);
            this.mapper.addStorageGoodsManagement(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int forbiddenStorageGoodsType(String id) {
        logger.debug("进入 deleteStorageGoods  方法");
        try {
            logger.debug("进行禁用"+id);
            this.mapper.forbiddenStorageGoodsType(id);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("禁用错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int forbiddenStorageGoodsManagement(String id) {
        logger.debug("进入 forbiddenStorageGoodsManagement  方法");
        try {
            logger.debug("进行禁用"+id);
            this.mapper.forbiddenStorageManagement(id);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("禁用错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
    public int startStorageGoodsManagement(String id) {
        logger.debug("进入 startStorageGoodsManagement  方法");
        try {
            logger.debug("进行启用"+id);
            this.mapper.startStorageManagement(id);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("启用错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int searchStorageGoodsSonCount(String id) {
        logger.debug("进入 searchStorageGoodsSonCount  方法");
        int count = mapper.searchStorageGoodsSunCount(id);
        return count;
    }

    public List<StorageGoodsManagementPo> getStorageGoodsManagementList(StorageGoodsManagementPo po, int page, int pageSize) {
        logger.debug("进入 getStorageGoodsManagementList  方法");
        List<StorageGoodsManagementPo> list=mapper.queryStorageGoodsManagementList(po,page,pageSize);
        return list;
    }

    public int getStorageGoodsManagementCount(StorageGoodsManagementPo po) {
        logger.debug("进入 getStorageGoodsManagementCount  方法");
        int count = mapper.queryStorageGoodsManagementItemcount(po);
        return count;
    }
}
