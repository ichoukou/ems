package com.channelsoft.ems.service;

import java.util.List;



/** 
 * 
 * 仓库管理
 * @author  wuhl
 * @date 创建时间：2016年12月26日 下午19:13:41 
 * @parameter  
 * @return  
 */
import com.channelsoft.ems.po.StoreHousePo;

public interface StorehouseService {
	public List<StoreHousePo> queryStoreHouse( StoreHousePo param, int page, int pageSize);

    public int queryStoreCount(StoreHousePo param);
    
    public int addStoretHome(StoreHousePo po);

    public int updateStoreHome(StoreHousePo po);    

}
