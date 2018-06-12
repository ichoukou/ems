package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.WareHouseMapper;
import com.channelsoft.ems.po.MaterialManagePo;
import com.channelsoft.ems.po.WarehouseEntryPo;
import com.channelsoft.ems.service.ResEnterWarehouseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangxin on 2017/1/5.
 */
@Service
public class ResEnterWarehouseServiceImpl implements ResEnterWarehouseService{
    private Logger logger = Logger.getLogger(ResEnterWarehouseServiceImpl.class);
    @Autowired
    private WareHouseMapper houseMapper;


    public int queryMainCount(WarehouseEntryPo po) {
        logger.debug("进入queryMainCount方法");
        int dataCount=this.houseMapper.queryMainCount(po);
        logger.debug("dataCount"+dataCount);
        return dataCount;
    }

    public List<WarehouseEntryPo> queryMainList(WarehouseEntryPo po, int page, int pageSize) {
        logger.debug("进入queryMainList方法");
        logger.debug("查询参数："+po.toString()+"page:"+page+"pageSize:"+pageSize);
        List<WarehouseEntryPo> houseList=this.houseMapper.queryMainList(po,page,pageSize);
        logger.debug("查询结果："+houseList.size());
        return houseList;
    }


    public int queryCount(MaterialManagePo po) {
        logger.debug("进入queryCount方法");
        int dataCount=this.houseMapper.queryCount(po);
        logger.debug("dataCount"+dataCount);
        return dataCount;
    }

    public List<MaterialManagePo> queryList(MaterialManagePo po, int page, int pageSize) {
        logger.debug("进入queryList方法");
        logger.debug("查询参数："+po.toString()+"page:"+page+"pageSize:"+pageSize);
        List<MaterialManagePo> houseList=this.houseMapper.queryList(po,page,pageSize);
        logger.debug("查询结果："+houseList.size());
        return houseList;
    }

    //主表子表的插入，仓库表的修改
    @Transactional(rollbackFor=Exception.class)
    public int creatStockAccount(WarehouseEntryPo po, List<WarehouseEntryPo> entryList, List<WarehouseEntryPo> stockList) {
        try {
            if(po.getFid()==null){
                //插入主表
                this.houseMapper.insertInStorgage(po);

                int FID=this.houseMapper.getInStorageInsertID();

                for (WarehouseEntryPo entry:entryList) {
                    entry.setpID(Integer.toString(FID));
                }
                //插入字表
                this.houseMapper.insertInStorageEntry(entryList);
            }else{
                this.houseMapper.updateStock(po);

                String FID=po.getFid();

                for (WarehouseEntryPo entry:entryList) {
                    entry.setpID(FID);
                }
                //插入子表
                this.houseMapper.insertInStorageEntry(entryList);//插入新的数据
            }
            //插入和更仓库表
            for (WarehouseEntryPo stock:stockList) {
                List<Map<String,String>> list=this.houseMapper.getDistictStick(stock);

                if(String.valueOf(list.get(0).get("NUM")).equals("0")){
                    this.houseMapper.insertStockAccout(stock);
                }else if(String.valueOf(list.get(0).get("NUM")).equals("1")){
                    stock.setFid(String.valueOf(list.get(0).get("FID")));
                    stock.setfAmount(String.valueOf(Integer.parseInt( stock.getfAmount())+Integer.parseInt(String.valueOf(list.get(0).get("FStockAmount")))));
                    this.houseMapper.updateStockAccout(stock);
                }else{
                    throw new Exception("查询库存表异常");
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    //获取库存物资
    public List<Map<String,String>> getUpdateAllMaterial(WarehouseEntryPo po){
        logger.debug("进入getUpdateAllMaterial方法");
        return this.houseMapper.getUpdateAllMaterial(po);
    };

    //删除父亲表 字表
    public int deleteUpdateStock(WarehouseEntryPo po, List<WarehouseEntryPo> stockListDelete){
        try {
            //更新主表
            this.houseMapper.deleteStorage(po);

            //删除从表
            this.houseMapper.deleteStorage_entryByFather(po);

            //更仓库表
            for (WarehouseEntryPo stock:stockListDelete) {
                List<Map<String,String>> list=this.houseMapper.getDistictStick(stock);
                if(String.valueOf(list.get(0).get("NUM")).equals("1")){
                    logger.debug(Integer.parseInt(String.valueOf(list.get(0).get("FStockAmount"))));
                    logger.debug(Integer.parseInt( stock.getfAmount()));
                    stock.setFid(String.valueOf(list.get(0).get("FID")));
                    stock.setfAmount(String.valueOf(Integer.parseInt(String.valueOf(list.get(0).get("FStockAmount")))-Integer.parseInt( stock.getfAmount())));
                    this.houseMapper.updateStockAccout(stock);
                }else{
                    throw new Exception("删除库存表异常");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    //更新原来数据
    @Transactional(rollbackFor=Exception.class)
    public int updateStockAccount(WarehouseEntryPo po, String[] arr, List<WarehouseEntryPo> stockListDelete) {
        try {
            //更新主表
            this.houseMapper.updateStock(po);
            //删除从表
            for(int i=0;i<arr.length;i++){
                po.setFid(String.valueOf(arr[i]));
                this.houseMapper.deleteStorage_entry(po);
            }
            //更仓库表
            for (WarehouseEntryPo stock:stockListDelete) {
                for(int i=0;i<arr.length;i++){
                    if(stock.getFid().equals(String.valueOf(arr[i]))){
                        List<Map<String,String>> list=this.houseMapper.getDistictStick(stock);
                        if(String.valueOf(list.get(0).get("NUM")).equals("1")){
                            logger.debug(Integer.parseInt(String.valueOf(list.get(0).get("FStockAmount"))));
                            logger.debug(Integer.parseInt( stock.getfAmount()));

                            stock.setFid(String.valueOf(list.get(0).get("FID")));
                            stock.setfAmount(String.valueOf(Integer.parseInt(String.valueOf(list.get(0).get("FStockAmount")))-Integer.parseInt( stock.getfAmount())));
                            this.houseMapper.updateStockAccout(stock);
                        }else{
                            throw new Exception("更新库存表异常");
                        }
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    //简单更新父亲表
    public int updateStock(WarehouseEntryPo po){
        try {
            //更新主表
            this.houseMapper.updateStock(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("添加错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
    }
}