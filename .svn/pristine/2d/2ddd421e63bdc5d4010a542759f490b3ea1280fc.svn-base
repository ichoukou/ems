package com.channelsoft.ems.service;

import com.channelsoft.ems.po.HomeServiceItemPo;
import com.channelsoft.ems.po.HomeServiceTypePo;

import java.util.List;

/**
 * Created by liuxing on 2016/12/20.
 */
public interface HomeServiceItemService {
    /**
     * @description: 获取居家服务项目名称列表
     * @return List<String>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<String> getHomeServiceItemNameList(String oldhouse);
    /**
     * @description: 获取居家服务项目类型列表
     * @return List<String>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<String> getHomeServiceItemTypeList(String oldhouse);
    /**
     * @description: 获取居家服务项目单位列表
     * @return List<String>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<String> getHomeServiceItemUnitList();
    /**
     * @description: 获取居家服务项目列表
     * @param po
     * @param pageSize
     * @param page
     * @return List<HomeServiceItemPo>
     * @author liuxing
     * @date 2017年3月10日
     */
    public List<HomeServiceItemPo> getHomeServiceItemList(HomeServiceItemPo po,int page,int pageSize);
    /**
     * @description: 获取居家服务项目列表总数
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int getHomeServiceItemCount(HomeServiceItemPo po);
    /**
     * @description: 居家服务项目更新
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int updateHomeServiceItem(HomeServiceItemPo po);
    /**
     * @description: 居家服务项目添加
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int addHomeServiceItem(HomeServiceItemPo po);
    /**
     * @description: 居家服务项目类型添加
     * @param po
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int addHomeServiceType(HomeServiceTypePo po);
    /**
     * @description: 居家服务项目类型判断是否已存在
     * @param homeID
     * @param typeName
     * @return int
     * @author liuxing
     * @date 2017年3月10日
     */
    public int checkHomeServiceType(String typeName,String homeID);

}
