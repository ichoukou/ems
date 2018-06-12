package com.channelsoft.ems.service;

import com.channelsoft.ems.po.OldManServiceplanPo;
import com.channelsoft.ems.po.PublicServicePlanPo;
import com.channelsoft.ems.po.ServiceItemPo;

import java.util.List;

/**
 * Created by wangjs on 2017/3/6.
 */
public interface CaregiversService {

    public List<List<PublicServicePlanPo>> getRoomCleanState(String UserId);

    public List<List<PublicServicePlanPo>> getAllRoomCleanState();

    public List<List<OldManServiceplanPo>> getOldManService(String UserId);

    public List<ServiceItemPo> getServiceItem(String roomId);

    public List<ServiceItemPo> getOldManServiceItem(String roomId);

    public void staffHomeDetailPerform(String []arr);

    public void staffHomeDetailCancelPerform(String []arr);
}
