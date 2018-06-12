package com.channelsoft.ems.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.OldManHosingMapper;
import com.channelsoft.ems.mapper.OrderManageMapper;
import com.channelsoft.ems.po.OrderPo;
import com.channelsoft.ems.service.OrderManageService;
/** 
 * 
 * 居家服务订单
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午19:13:41 
 * @parameter  
 * @return  
 */
@Service
public class OrderServiceImpl implements OrderManageService {
   
	private Logger logger=Logger.getLogger(OrderServiceImpl.class);
    
	@Autowired
    private OrderManageMapper mapper;

	
	

	public List<Map<String, String>> getData_dic() {
		// TODO Auto-generated method stub
		logger.debug("进入查询订单的OrderServiceImpl....查询数据字典");
		return this.mapper.getDATA_DIC();
	}


	public List<Map<String, String>> getServiceType(OrderPo po) {
		// TODO Auto-generated method stub
		logger.debug("进入查询订单的OrderServiceImpl....查询服务类型");
		return this.mapper.getServiceType(po);
	}


	public List<Map<String, String>> getServiceItemName(OrderPo po) {
		// TODO Auto-generated method stub
		logger.debug("进入查询订单的OrderServiceImpl....查询服务种类");
		return this.mapper.getServiceItemName(po);
	}


	public List<Map<String, String>> getStaffMessage() {
		// TODO Auto-generated method stub
		logger.debug("进入查询订单的OrderServiceImpl....查询员工信息");
		return this.mapper.getStaffMessage();
	}


	public int addOrder(OrderPo po) {
		// TODO Auto-generated method stub
		   try {
	            logger.debug("进入增加" + po);
	            this.mapper.addOrder(po);
	        } catch (Exception e) {
	            // TODO: handle exception
	            logger.debug("添加错误" + e.getMessage());
	            e.printStackTrace();
	            return 1;
	        }
	        return 0;
	}


	public int updateOrder(OrderPo Po) {
		// TODO Auto-generated method stub
		   try {
	            logger.debug("进入更新" + Po);
	            this.mapper.updateOrder(Po);
	        } catch (Exception e) {
	            // TODO: handle exception
	            logger.debug("更新错误" + e.getMessage());
	            e.printStackTrace();
	            return 1;
	        }
	        return 0;
	}


	public int deleteOrder(OrderPo Po) {
		// TODO Auto-generated method stub
		try {
            logger.debug("进入删除" + Po);
            this.mapper.deleteOrder(Po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("删除错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
	}


	public int evalOrder(OrderPo po) {
		// TODO Auto-generated method stub
		try {
            logger.debug("进入评价订单" + po);
            this.mapper.evalOrder(po);
        } catch (Exception e) {
            // TODO: handle exception
            logger.debug("评价错误" + e.getMessage());
            e.printStackTrace();
            return 1;
        }
        return 0;
	}


	public List<Map<String, String>> getForderNo(OrderPo po) {
		// TODO Auto-generated method stub
		return this.mapper.getForderNo(po);
	}


	public List<OrderPo> queryOrder(OrderPo param, int page, int pageSize) {
		// TODO Auto-generated method stub
		return this.mapper.queryOrder(param, page, pageSize);
	}


	public int queryOrderCount(OrderPo param) {
		// TODO Auto-generated method stub
		return this.mapper.queryOrderCount(param);
	}


	public List<OrderPo> lastFid(OrderPo po) {
		// TODO Auto-generated method stub
		return this.mapper.lastFid(po);
	}

}
