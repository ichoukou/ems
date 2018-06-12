package com.channelsoft.ems.nursing.nursingPlan.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.common.IdGen;
import com.channelsoft.ems.nursing.nursingPlan.mapper.NursingPlanOldManMapper;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManPo;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanOldManService;
import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;

/** 
 * 
 * 护理老人计划serviceImpl  
 * @author  lwj
 * @date 创建时间：2017年02月18日 下午14:31:41 
 * @parameter  
 * @return  
 */
@Service
public class NursingPlanOldManServiceImpl implements NursingPlanOldManService{
	
	@Autowired
	private NursingPlanOldManMapper mapper;
	
	public List<OldManServiceItemPo> queryDetailList(OldManServiceItemPo po) {
		return mapper.queryDetailList(po);
	}

	public List<OldManPo> queryOldManList(OldManPo po) {
		return mapper.queryOldManList(po);
	}

	public int queryOldManTotal(OldManPo po) {
		return mapper.queryOldManTotal(po);
	}

	public List<OldManServiceItemPo> queryList(OldManServiceItemPo po) {
		return mapper.queryList(po);
	}
	
	public int getTotalSize(OldManServiceItemPo po) {
		return mapper.getTotalSize(po);
	}

	public void saveOldManServiceItem(String[] fids, String foldmanid) {
		//拼接选中的老人护理项目fid，为了查询使用
		String fidsStr="";
		for(int i=0;i<fids.length;i++){
			if(i==fids.length-1){
				fidsStr+="'"+fids[i]+"'";
			}else{
				fidsStr+="'"+fids[i]+"',";
			}
		}
		OldManServiceItemPo po =new OldManServiceItemPo();
		po.setFids(fidsStr);
		po.setFoldmanid(foldmanid);
		//根据选中的项目fid,查询出未被选中的老人护理项目
		List<OldManServiceItemPo> noSelectOldManServiceItems=mapper.getNoSelectOldManServiceItem(po);
		for (OldManServiceItemPo oldManServiceItemPo : noSelectOldManServiceItems) {
			Date fservicestartdate=oldManServiceItemPo.getFservicestartdate();
			if(fservicestartdate !=null){
				/**
				 * 当服务启用时间不为空时，则说明该项目以前被老人使用过，现在取消了
				 * 故修改 其状态为禁用，修改禁用日期为当前时间
				 * 其余启用时间为空时，说明项目未被老人使用过，则不作修改
				 */
				String fid="'"+oldManServiceItemPo.getFserviceitemid()+"'";
				po.setFstatus("2");
				po.setFids(fid);
				po.setFserviceenddate(new Date());
				mapper.updateOldManServiceItem(po);
			}
		}
		
		
		//修改选中的老人护理项目的状态，服务启用日期，清空禁用日期
		OldManServiceItemPo poselect =new OldManServiceItemPo();
		poselect.setFids(fidsStr);
		poselect.setFoldmanid(foldmanid);
		poselect.setFservicestartdate(new Date());
		poselect.setFserviceenddate(null);
		poselect.setFstatus("1");
		mapper.updateOldManServiceItem(poselect);
	}
	
	/**
	 * 获取所有有项目的老人
	 */
	@Override
	public List<OldManPo> getAllOldMan() {
		return mapper.getAllOldMan();
	}

	@Override
	public List<OldManServiceItemPo> getOldManServiceItems(OldManServiceItemPo po) {
		return mapper.getOldManServiceItems(po);
	}

	@Override
	public void updateByPrimaryKeySelective(OldManServiceItemPo po) {
		mapper.updateByPrimaryKeySelective(po);
	}
	
	/**
	 * 老人入住时，传入老人和护理等级，调用方法，存入老人服务项目表
	 * @param foldmanid
	 * @param fnursingLevel
	 */
	@Override
	public void insertOldManServiceItemByContidtion(String foldmanid, String fnursingLevel) {
		//1-查询出所有的 老人服务类型 的 服务项目
		List<NursingProjectPo> items=mapper.getAllServiceItem();
		
		//循环将所有服务项目 插入该老人 的老人服务项目表t_kfgl_oldmanserviceitem
		for (NursingProjectPo nursingProjectPo : items) {
			OldManServiceItemPo oldManServiceItemPo=new OldManServiceItemPo();
			/**
			 * 判断房间是否已存在该项目在 t_kfgl_publicserviceitem 表
			 * 若已存在，则只修改 状态和禁用时间
			 * 若不存在，则插入
			 * 此处是为了适用 在修改房间护理项目时
			 */
			boolean flag=checkServiceItemExist(nursingProjectPo.getFid(),foldmanid);
			if(flag){
				String fid=IdGen.getRandomNoYMS("LRXM", 4);
				String fnursingHomeid=nursingProjectPo.getfNursingHomeID();
				String fnumber=IdGen.getRandomNoYMS("LRXMN", 4);
				String fstatus="2";  //先统一设置成 禁用，再改符合老人级别的的项目为启用
				String fserviceitemid=nursingProjectPo.getFid();
				String fnurselevelid=fnursingLevel;
				
				oldManServiceItemPo.setFid(fid);
				oldManServiceItemPo.setFnursingHomeid(fnursingHomeid);
				oldManServiceItemPo.setFnumber(fnumber);
				oldManServiceItemPo.setFstatus(fstatus);
				oldManServiceItemPo.setFserviceitemid(fserviceitemid);
				oldManServiceItemPo.setFoldmanid(foldmanid);
				oldManServiceItemPo.setFnurselevelid(fnurselevelid);
				
				mapper.insertSelective(oldManServiceItemPo);
			}else{
				String fids="";
				fids="'"+nursingProjectPo.getFid()+"'";
				
				OldManServiceItemPo po =new OldManServiceItemPo();
				po.setFoldmanid(foldmanid);
				po.setFstatus("2");
				po.setFids(fids);
				po.setFserviceenddate(new Date());
				mapper.updateOldManServiceItem(po);
			}
		}
		
		//2-根据老人 服务等级 查询出 老人该启用的 服务项目
		List<NursingProjectPo> itemsOwner=mapper.getOwnerServiceItem(fnursingLevel);
		
		//3-将老人该启用项目的状态 置为 启用 
		for (NursingProjectPo nursingProjectPo : itemsOwner) {
			String fserviceitemid=nursingProjectPo.getFid();
			String fids="";
			fids="'"+fserviceitemid+"'";
			//修改选中的老人护理项目的状态，服务启用日期，清空禁用日期
			OldManServiceItemPo poselect =new OldManServiceItemPo();
			poselect.setFids(fids);
			poselect.setFoldmanid(foldmanid);
			poselect.setFservicestartdate(new Date());
			poselect.setFserviceenddate(null);
			poselect.setFstatus("1");
			mapper.updateOldManServiceItem(poselect);
		}
	}

	private boolean checkServiceItemExist(String fserviceitemid, String foldmanid) {
		boolean flag=true;
		int count =mapper.checkServiceItemExist(fserviceitemid,foldmanid);
		if(count >0){
			flag=false;
		}
		return flag;
	}

	@Override
	public List<OldManPo> getLevelOldMan(String levels) {
		return mapper.getLevelOldMan(levels);
	}

	@Override
	public void insertSelective(OldManServiceItemPo oldManServiceItemPo) {
		mapper.insertSelective(oldManServiceItemPo);
	}

	@Override
	public List<OldManPo> queryOldManListNoPage(OldManPo po) {
		// TODO Auto-generated method stub
		return mapper.queryOldManListNoPage(po);
	}
}
