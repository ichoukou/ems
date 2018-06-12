package com.channelsoft.ems.service.impl;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.RoleManageMapper;
import com.channelsoft.ems.mapper.StoreHomeMapper;
import com.channelsoft.ems.po.OrderPo;
import com.channelsoft.ems.po.StoreHousePo;
import com.channelsoft.ems.service.StorehouseService;
@Service
public class StoreHomeServiceImpl implements StorehouseService {

	   private Logger logger = Logger.getLogger(StoreHomeServiceImpl.class);
	    @Autowired
	    private  StoreHomeMapper mapper;
	
	    
	    public List<StoreHousePo> queryStoreHouse(StoreHousePo param, int page,
			int pageSize) {
		// TODO Auto-generated method stub
	    	logger.debug("进入查询库房的StoreHomeServiceImpl....");
	    	
		return mapper.queryStoreHouse(param, page, pageSize);
	}

	public int queryStoreCount(StoreHousePo param) {
		// TODO Auto-generated method stub
		return this.mapper.queryStoreCount(param);
	}

	public int addStoretHome(StoreHousePo po) {
		// TODO Auto-generated method stub
		
			   try {
		            logger.debug("进入增加仓库方法" + po);
		            this.mapper.addStoretHome(po);
		        } catch (Exception e) {
		            // TODO: handle exception
		            logger.debug("添加仓库错误" + e.getMessage());
		            e.printStackTrace();
		            return 1;
		        }
		        return 0;
		
	}

	public int updateStoreHome(StoreHousePo po) {
		// TODO Auto-generated method stub
		
		   try {
	            logger.debug("进入更新仓库方法updateStoreHome...." + po);
	            this.mapper.updateStoreHome(po);
	        } catch (Exception e) {
	            // TODO: handle exception
	            logger.debug("更新仓库错误" + e.getMessage());
	            e.printStackTrace();
	            return 1;
	        }
	        return 0;
	}

	

}
