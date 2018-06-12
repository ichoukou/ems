package com.channelsoft.ems.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.channelsoft.ems.po.OrderPo;
/** 
 * 
 * 居家服务订单
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午19:13:41 
 * @parameter  
 * @return  
 */
public interface OrderManageService {

	public List<OrderPo> queryOrder(OrderPo param, int page, int pageSize);

    public int queryOrderCount(OrderPo param);

	public List<Map<String,String>>getData_dic();
	
	public List<Map<String,String>>getServiceType(OrderPo po);
	
	public List<Map<String,String>>getServiceItemName(OrderPo po);
	
	public List<Map<String,String>>getStaffMessage();
	
    public int addOrder(OrderPo po);
    
	public int updateOrder(OrderPo Po);
	
	public int deleteOrder(OrderPo Po);
	
	public int evalOrder(OrderPo po);
	
	public List<Map<String,String>>getForderNo(OrderPo po);

	public List<OrderPo> lastFid(OrderPo po);





 


}
