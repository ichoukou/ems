package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.HomeServiceItemMapper;
import com.channelsoft.ems.po.HomeServiceItemPo;
import com.channelsoft.ems.po.HomeServiceTypePo;
import com.channelsoft.ems.service.HomeServiceItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxing on 2016/12/20.
 */
@Service
public class HomeServiceItemServiceImpl implements HomeServiceItemService{

    private static Logger logger= Logger.getLogger(HomeServiceItemServiceImpl.class);

    @Autowired
    private HomeServiceItemMapper mapper;

    public List<String> getHomeServiceItemNameList(String oldhouse) {
        logger.debug("进入 getHomeServiceItemNameList 方法");
        List<String> nameList=new ArrayList<String>();
        nameList = mapper.getHomeServiceItemNameList(oldhouse);
        return nameList;
    }

    public List<String> getHomeServiceItemTypeList(String oldhouse) {
        logger.debug("进入 getHomeServiceItemTypeList 方法");
        List<String> typeList=new ArrayList<String>();
        typeList = mapper.getHomeServiceItemTypeList(oldhouse);
        return typeList;
    }

    public List<String> getHomeServiceItemUnitList() {
        logger.debug("进入 getHomeServiceItemUnitList 方法");
        List<String> unitList=new ArrayList<String>();
        unitList=mapper.getHomeServiceItemUnitList();
        return unitList;
    }

    public List<HomeServiceItemPo> getHomeServiceItemList(HomeServiceItemPo po,int page,int pageSize) {
        logger.debug("进入 getHomeServiceItemList 方法");
        logger.debug("请求参数：po:"+po.toString()+"page:"+page+"pageSize:"+pageSize);
        List<HomeServiceItemPo> list =new ArrayList<HomeServiceItemPo>();
        list = mapper.queryHomeServiceItemList(po,page,pageSize);
        return list;
    }


    public int getHomeServiceItemCount(HomeServiceItemPo po) {
        logger.debug("进入 getHomeServiceItemCount 方法");
        int count=mapper.getHomeServiceItemCount(po);
        return count;
    }

    public int updateHomeServiceItem(HomeServiceItemPo po) {
        logger.debug("进入 updateHomeServiceItem  方法");
        try {
            logger.debug("进行更新"+po);
            String id= this.mapper.getHomeServiceItemTypeID(po.getServiceTypeName());
            po.setServiceTypeID(id);
            this.mapper.updateHomeServiceItem(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("更新错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int addHomeServiceItem(HomeServiceItemPo po) {
        logger.debug("进入 addHomeServiceItem  方法");
        try {
            logger.debug("进行添加"+po);
            String id= this.mapper.getHomeServiceItemTypeID(po.getServiceTypeName());
            po.setServiceTypeID(id);
            this.mapper.addHomeServiceItem(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int addHomeServiceType(HomeServiceTypePo po) {
        logger.debug("进入 addHomeServiceType  方法");
        try {
            logger.debug("进行添加"+po);
            this.mapper.addHomeServiceType(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误"+e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public int checkHomeServiceType(String typeName,String homeID) {
        logger.debug("进入 checkHomeServiceType  方法");
        logger.debug("请求参数为：typeName"+typeName+"homeID:"+homeID);
        int result=mapper.checkType(typeName,homeID);
        logger.debug("获得结果：" +result);
        return result;
    }
}
