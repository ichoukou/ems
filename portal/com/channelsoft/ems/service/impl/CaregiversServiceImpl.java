package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.OldManHosingMapper;
import com.channelsoft.ems.mapper.OldManServiceplanMapper;
import com.channelsoft.ems.mapper.PublicServicePlanMapper;
import com.channelsoft.ems.mapper.TRoomMapper;
import com.channelsoft.ems.nursing.nursingPlan.po.RoomPo;
import com.channelsoft.ems.po.*;
import com.channelsoft.ems.service.CaregiversService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjs on 2017/3/6.
 */
@Service
public class CaregiversServiceImpl implements CaregiversService {

    private static Logger logger= Logger.getLogger(CaregiversServiceImpl.class);

    @Autowired
    private PublicServicePlanMapper mapper;

    @Autowired
    private TRoomMapper roomMapper;

    @Autowired
    private OldManHosingMapper oldManHosingMapper;

    @Autowired
    private OldManServiceplanMapper oldManServiceplanMapper;

    public List<List<PublicServicePlanPo>> getRoomCleanState(String UserId){
        //根据登录人id查到给护理员安排的房间
        List<ArrgngHomePo> roomListByUserId=mapper.getRoomByUserId(UserId);

        List<List<PublicServicePlanPo>> publicServicePlanList=new ArrayList<List<PublicServicePlanPo>>();
        List<PublicServicePlanPo> publicServicePlanPoList=new ArrayList<PublicServicePlanPo>();
        for(int i=0;i<roomListByUserId.size();i++){
            String roomId=roomListByUserId.get(i).getfHomeID();
            try{
                publicServicePlanPoList=mapper.getPublicServicePlan(roomId);
                publicServicePlanList.add(publicServicePlanPoList);
            }catch (Exception e){
                logger.error("===============",e);
            }

        }
        return publicServicePlanList;
    }

    public List<List<PublicServicePlanPo>> getAllRoomCleanState(){
        List<TRoomPo> roomList=roomMapper.getRoom(new TRoomPo());
        List<List<PublicServicePlanPo>> publicServicePlanList=new ArrayList<List<PublicServicePlanPo>>();
        for(int i=0;i<roomList.size();i++){
            List<PublicServicePlanPo> publicServicePlan=mapper.getPublicServicePlan(roomList.get(i).getfID());
            publicServicePlanList.add(publicServicePlan);
        }
        return publicServicePlanList;
    }

    public List<List<OldManServiceplanPo>> getOldManService(String UserId){
//        根据护理员ID查出给护理员安排的房间
        List<ArrgngHomePo> roomListByUserId=mapper.getRoomByUserId(UserId);
//        护理员负责房间的老人护理计划
        List<List<OldManServiceplanPo>> oldManServiceplanPoList=new ArrayList<List<OldManServiceplanPo>>();
        try{
            for(int i=0;i<roomListByUserId.size();i++){
                List<OldManMainPo> oldManMainPoList=new ArrayList<OldManMainPo>();
                String roomId=roomListByUserId.get(i).getfHomeID();
                OldManMainPo oldManMainPo=new OldManMainPo();
                oldManMainPo.setFroomID(roomId);
//                根据房间ID查出老人
                oldManMainPoList=oldManHosingMapper.getomList(oldManMainPo);
                for(int j=0;j<oldManMainPoList.size();j++){
//                    根据老人ID查出老人的具体护理计划
                    List<OldManServiceplanPo> OldManServiceplan= oldManServiceplanMapper.getOldManServicePlan(oldManMainPoList.get(j).getfID());
                    oldManServiceplanPoList.add(OldManServiceplan);
                }
            }
        }catch (Exception e){
            logger.error("查询老人护理计划异常：",e);
        }
        return oldManServiceplanPoList;
    }

    public List<ServiceItemPo> getServiceItem(String roomId){
        List<ServiceItemPo> serviceItemList=mapper.getServiceItem(roomId);
        return serviceItemList;
    }

    public List<ServiceItemPo> getOldManServiceItem(String roomId){
        List<ServiceItemPo> serviceItemList=mapper.getServiceItem(roomId);
        return serviceItemList;
    }

    public void staffHomeDetailPerform(String []arr){
        for(int i=0;i<arr.length;i++){
            try{
                ServiceItemPo serviceItem=mapper.getPublicServicePlanByFid(arr[i]);
                String nowExcludcount=serviceItem.getFexcludcount();
                String realExcludcount= (Integer.parseInt(nowExcludcount)+1)+"";
                serviceItem.setFexcludcount(realExcludcount);

                mapper.staffHomeDetailPerform(serviceItem);
            }catch (Exception e){
                logger.error("success====",e);
            }
        }
    }

    public void staffHomeDetailCancelPerform(String []arr){
        for(int i=0;i<arr.length;i++){
            try{
                ServiceItemPo serviceItem=mapper.getPublicServicePlanByFid(arr[i]);
                String nowExcludcount=serviceItem.getFexcludcount();
                String realExcludcount= (Integer.parseInt(nowExcludcount)-1)+"";
                serviceItem.setFexcludcount(realExcludcount);

                mapper.staffHomeDetailPerform(serviceItem);
            }catch (Exception e){
                logger.error("success====",e);
            }
        }
    }
}
