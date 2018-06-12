package com.channelsoft.ems.nursing.nursingPlan.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.common.IdGen;
import com.channelsoft.ems.nursing.nursingPlan.mapper.NursingPlanPublicMapper;
import com.channelsoft.ems.nursing.nursingPlan.po.PublicServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlan.po.RoomPo;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanPublicService;
import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;

/** 
 * 
 * 护理公共计划serviceImpl  
 * @author  lwj
 * @date 创建时间：2017年02月18日 下午14:31:41 
 * @parameter  
 * @return  
 */
@Service
public class NursingPlanPublicServiceImpl implements NursingPlanPublicService{
	
	@Autowired
	private NursingPlanPublicMapper mapper;
	
	public List<PublicServiceItemPo> queryDetailList(PublicServiceItemPo po) {
		return mapper.queryDetailList(po);
	}

	public List<RoomPo> queryRoomList(RoomPo po) {
		return mapper.queryRoomList(po);
	}

	public int queryRoomTotal(RoomPo po) {
		return mapper.queryRoomTotal(po);
	}

	public List<PublicServiceItemPo> queryList(PublicServiceItemPo po) {
		return mapper.queryList(po);
	}
	
	public int getTotalSize(PublicServiceItemPo po) {
		return mapper.getTotalSize(po);
	}

	public void savePublicServiceItem(String[] fids, String froomid) {
		//拼接选中的公共护理项目fid，为了查询使用
		String fidsStr="";
		for(int i=0;i<fids.length;i++){
			if(i==fids.length-1){
				fidsStr+="'"+fids[i]+"'";
			}else{
				fidsStr+="'"+fids[i]+"',";
			}
		}
		PublicServiceItemPo po =new PublicServiceItemPo();
		po.setFids(fidsStr);
		po.setFroomid(froomid);
		//根据选中的项目fid,查询出未被选中的公共护理项目
		List<PublicServiceItemPo> noSelectPublicServiceItems=mapper.getNoSelectPublicServiceItem(po);
		for (PublicServiceItemPo PublicServiceItemPo : noSelectPublicServiceItems) {
			Date fservicestartdate=PublicServiceItemPo.getFservicestartdate();
			if(fservicestartdate !=null){
				/**
				 * 当服务启用时间不为空时，则说明该项目以前被公共使用过，现在取消了
				 * 故修改 其状态为禁用，修改禁用日期为当前时间
				 * 其余启用时间为空时，说明项目未被公共使用过，则不作修改
				 */
				String fid="'"+PublicServiceItemPo.getFserviceitemid()+"'";
				po.setFstatus("2");
				po.setFids(fid);
				po.setFserviceenddate(new Date());
				mapper.updatePublicServiceItem(po);
			}
		}
		
		
		//修改选中的公共护理项目的状态，服务启用日期，清空禁用日期
		PublicServiceItemPo poselect =new PublicServiceItemPo();
		poselect.setFids(fidsStr);
		poselect.setFroomid(froomid);
		poselect.setFservicestartdate(new Date());
		poselect.setFserviceenddate(null);
		poselect.setFstatus("1");
		mapper.updatePublicServiceItem(poselect);
	}

	/**
	 * 获取所有有项目的房间
	 */
	@Override
	public List<RoomPo> getAllRoom() {
		return mapper.getAllRoom();
	}

	@Override
	public List<PublicServiceItemPo> getPublicServiceItems(PublicServiceItemPo po) {
		return mapper.getPublicServiceItems(po);
	}

	@Override
	public void updateByPrimaryKeySelective(PublicServiceItemPo po) {
		mapper.updateByPrimaryKeySelective(po);
	}
	
	/**
	 * 新增房间时，传入房间id和所做项目id，调用方法，存入公共服务项目表
	 * @param froomid
	 * @param serviceItemIds
	 */
	@Override
	public void insertPublicServiceItemByContidtion(String froomid,List<String> serviceItemIds) {
		//1-查询出所有的 房间服务类型 的 服务项目
		List<NursingProjectPo> items=mapper.getAllServiceItem();
		
		/**
		 * 循环将所有服务项目 插入该房间 的房间服务项目表t_kfgl_publicserviceitem
		 * 由于默认全部 公共服务项目均启用
		 */
		for (NursingProjectPo nursingProjectPo : items) {
			PublicServiceItemPo publicServiceItemPo=new PublicServiceItemPo();
			
			/**
			 * 判断房间是否已存在该项目在 t_kfgl_publicserviceitem 表
			 * 若已存在，则只修改 状态和禁用时间
			 * 若不存在，则插入
			 * 此处是为了适用 在修改房间护理项目时
			 */
			boolean flag=checkServiceItemExist(nursingProjectPo.getFid(),froomid);
			if(flag){
				String fid=IdGen.getRandomNoYMS("GGXM", 4);
				String fnursingHomeid=nursingProjectPo.getfNursingHomeID();
				String fnumber=IdGen.getRandomNoYMS("GGXMN", 4);
				String fstatus="1";  //先统一设置成 禁用，再改符合房间级别的的项目为启用
				String fserviceitemid=nursingProjectPo.getFid();
				
				publicServiceItemPo.setFid(fid);
				publicServiceItemPo.setFnursingHomeid(fnursingHomeid);
				publicServiceItemPo.setFnumber(fnumber);
				publicServiceItemPo.setFstatus(fstatus);
				publicServiceItemPo.setFserviceitemid(fserviceitemid);
				publicServiceItemPo.setFroomid(froomid);
				publicServiceItemPo.setFservicestartdate(new Date());
				publicServiceItemPo.setFserviceenddate(null);
				
				mapper.insertSelective(publicServiceItemPo);
			}else{
				String fids="";
				fids="'"+nursingProjectPo.getFid()+"'";
				//修改选中的房间护理项目的状态，服务启用日期，清空禁用日期
				PublicServiceItemPo po =new PublicServiceItemPo();
				po.setFids(fids);
				po.setFstatus("1");
				po.setFserviceenddate(new Date());
				po.setFserviceenddate(null);
				mapper.updatePublicServiceItem(po);
			}
		}

		/*//3-将房间该启用项目的状态 置为 启用 
		for (String fserviceitemid : serviceItemIds) {
			String fids="";
			fids="'"+fserviceitemid+"'";
			//修改选中的房间护理项目的状态，服务启用日期，清空禁用日期
			PublicServiceItemPo poselect =new PublicServiceItemPo();
			poselect.setFids(fids);
			poselect.setFroomid(froomid);
			poselect.setFserviceitemid(fserviceitemid);
			poselect.setFservicestartdate(new Date());
			poselect.setFserviceenddate(null);
			poselect.setFstatus("1");
			mapper.updatePublicServiceItem(poselect);
		}*/
	}

	private boolean checkServiceItemExist(String fserviceitemid, String froomid) {
		boolean flag=true;
		int count =mapper.checkServiceItemExist(fserviceitemid,froomid);
		if(count >0){
			flag=false;
		}
		return flag;
	}

	@Override
	public void insertSelective(PublicServiceItemPo publicServiceItemPo) {
		mapper.insertSelective(publicServiceItemPo);
	}

}
