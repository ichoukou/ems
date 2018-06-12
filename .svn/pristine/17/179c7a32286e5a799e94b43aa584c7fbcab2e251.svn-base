package com.channelsoft.ems.service.impl;

import java.util.List;
/** 
 * 
 * 物品入库
 * @author  wuhl
 * @date 创建时间：2016年12月8日 下午16:13:41 
 * @parameter  
 * @return  
 */



import java.util.Map;

import com.channelsoft.ems.po.StockMaterialPo;
import com.channelsoft.ems.po.StorageGoodsManagementPo;
import com.channelsoft.ems.po.StorageOutDetailedEntryPo;
import org.apache.log4j.Logger;


import com.channelsoft.ems.mapper.InStorageMapper;
import com.channelsoft.ems.po.InStoragePo;
import com.channelsoft.ems.service.InStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class InStorageServiceImpl implements InStorageService {

	private Logger logger=Logger.getLogger(InStorageServiceImpl.class);

	@Autowired
	private InStorageMapper inStorageMapper;
	
	public List<InStoragePo> queryInStorage(InStoragePo param, int page,
			int pageSize) {
		// TODO Auto-generated method stub
		logger.debug("查询物品入库....进入InStorageServiceImpl方法里面...查询物品");
		
		return inStorageMapper.queryInStorage(param, page, pageSize);
	}

	public int queryInStorageCount(InStoragePo param) {
		// TODO Auto-generated method stub
		logger.debug("查询物品入库....进入InStorageServiceImpl方法里面...查询数量");

		return this.inStorageMapper.queryInStorageCount(param);
	}

	public List<Map<String, String>> getFMaterialName() {
		// TODO Auto-generated method stub
		return this.inStorageMapper.getFMaterialName();
	}

	public List<Map<String, String>> getFStoreHouseName() {
		// TODO Auto-generated method stub
		return this.inStorageMapper.getFStoreHouseName();
	}

	public List<Map<String, String>> getFStandard() {
		// TODO Auto-generated method stub
		return this.inStorageMapper.getFStandard();
	}

	public List<StockMaterialPo> getAllFMaterial(StockMaterialPo po, int page, int pageSize) {
		return this.inStorageMapper.getAllFMaterial(po, page, pageSize);
	}

	public int getAllFMaterialCount(StockMaterialPo po) {
		return this.inStorageMapper.getAllFMaterialCount(po);
	}


	public List<Map<String, String>> getHouse() {

		return this.inStorageMapper.getHouse();

	}


	//简单更新父亲表
	public int updateStock(InStoragePo po){
		try {
			//更新主表
			this.inStorageMapper.updateStock(po);

		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("添加错误" + e.getMessage());
			e.printStackTrace();
			return 1;
		}
		return 0;
	}


	//删除父亲表 字表
	public int deleteUpdateStock(InStoragePo po, List<InStoragePo> stockListDelete){
		try {
			//更新主表
			this.inStorageMapper.deleteStorage(po);

			//删除从表
			this.inStorageMapper.deleteStorage_entryByFather(po);



			//更仓库表
			for (InStoragePo stock:stockListDelete) {


						List<Map<String,String>> list=this.inStorageMapper.getDistictStick(stock);

						if(String.valueOf(list.get(0).get("NUM")).equals("1")){

							logger.debug(Integer.parseInt(String.valueOf(list.get(0).get("FStockAmount"))));
							logger.debug(Integer.parseInt( stock.getfQty()));

							stock.setFid(String.valueOf(list.get(0).get("FID")));
							stock.setfQty(String.valueOf(Integer.parseInt(String.valueOf(list.get(0).get("FStockAmount")))-Integer.parseInt( stock.getfQty())));
							this.inStorageMapper.updateStockAccout(stock);
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
	public int updateStockAccount(InStoragePo po, String[] arr, List<InStoragePo> stockListDelete) {

		try {
             //更新主表
			this.inStorageMapper.updateStock(po);

			//删除从表
			for(int i=0;i<arr.length;i++){
				po.setFid(String.valueOf(arr[i]));
				this.inStorageMapper.deleteStorage_entry(po);

			}


			//更仓库表
			for (InStoragePo stock:stockListDelete) {

				for(int i=0;i<arr.length;i++){
					if(stock.getFid().equals(String.valueOf(arr[i]))){
						List<Map<String,String>> list=this.inStorageMapper.getDistictStick(stock);

						if(String.valueOf(list.get(0).get("NUM")).equals("1")){

							logger.debug(Integer.parseInt(String.valueOf(list.get(0).get("FStockAmount"))));
							logger.debug(Integer.parseInt( stock.getfQty()));

							stock.setFid(String.valueOf(list.get(0).get("FID")));
							stock.setfQty(String.valueOf(Integer.parseInt(String.valueOf(list.get(0).get("FStockAmount")))-Integer.parseInt( stock.getfQty())));
							this.inStorageMapper.updateStockAccout(stock);
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



	@Transactional(rollbackFor=Exception.class)
	public int creatStockAccount(InStoragePo po, List<InStoragePo> entryList, List<InStoragePo> stockList) {

		try {
			if(po.getFid()==null){
             //增加方法
              //插入主表
				this.inStorageMapper.insertInStorgage(po);

				int FID=this.inStorageMapper.getInStorageInsertID();

				for (InStoragePo entry:entryList) {
					entry.setFatherid(Integer.toString(FID));
				}
				//插入子表
				this.inStorageMapper.insertInStorageEntry(entryList);

			}else{
             //更新方法

				//更新主表
				this.inStorageMapper.updateStock(po);

				String FID=po.getFid();

				for (InStoragePo entry:entryList) {
					entry.setFatherid(FID);
				}
				//插入子表
				this.inStorageMapper.insertInStorageEntry(entryList);//插入新的数据

			}



			//插入和更仓库表
			for (InStoragePo stock:stockList) {
				List<Map<String,String>> list=this.inStorageMapper.getDistictStick(stock);

				if(String.valueOf(list.get(0).get("NUM")).equals("0")){
					this.inStorageMapper.insertStockAccout(stock);
				}else if(String.valueOf(list.get(0).get("NUM")).equals("1")){
                    stock.setFid(String.valueOf(list.get(0).get("FID")));
					stock.setfQty(String.valueOf(Integer.parseInt( stock.getfQty())+Integer.parseInt(String.valueOf(list.get(0).get("FStockAmount")))));
                   this.inStorageMapper.updateStockAccout(stock);
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

	//根据指定编号查询 子表数据
	public List<Map<String,String>> getUpdateAllMaterial(InStoragePo po){

		return this.inStorageMapper.getUpdateAllMaterial(po);

	};


}
