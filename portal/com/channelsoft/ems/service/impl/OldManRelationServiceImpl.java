package com.channelsoft.ems.service.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.OldManRelationMapper;
import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManRelationPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.OldManRelationService;
/**
 * 
 *  老人亲属信息业务层实现类
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2016年12月21日
 */
@Service
public class OldManRelationServiceImpl implements OldManRelationService {
	
	private Logger logger=Logger.getLogger(OldManRelationServiceImpl.class);
	
	@Autowired
	private OldManRelationMapper oldManRelationMapper;
	
	public int addOldManRelation(OldManRelationPo oldManRelationPo,HttpServletRequest request) {
		logger.debug("进入OldManRelationServiceImpl中addOldManRelation方法");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//获取当前时间并按照yyyy-MM-dd格式存储
		oldManRelationPo.setfCreateTime(sdf.format(new Date()));
		//request.getSession.getAtrribute("userid")
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		oldManRelationPo.setfCreatorID(user.getEmployId());
		oldManRelationPo.setfNursingHomeID("1");
			logger.debug("开始调用批量添加的Mapper");
			logger.debug("最终参数为"+oldManRelationPo.toString());
			int result =oldManRelationMapper.addOldManRelation(oldManRelationPo);
			return result;
	}

	public int upateManRelation(OldManRelationPo oldManRelationPo) {
		logger.debug("进入OldManRelationServiceImpl中upateManRelation方法");
		try{
			oldManRelationMapper.updateOldManRelation(oldManRelationPo);
		}catch(Exception e){
			logger.debug("upateManRelation执行失败");
			return 0;
		}
		return 1;
	}

	public List<DataDictionaryPo> getRelation(DataDictionaryPo dict) {
		logger.debug("得到数据字典中的老人关系");
		List<DataDictionaryPo> list=oldManRelationMapper.queryRelationPo(dict);
		return list;
	}

	/**
	 * 根据老人id查询其亲属信息
	 */
	public List<OldManRelationPo> queryRelation(OldManRelationPo oldManRelationPo) {
		logger.debug("开始查询老人亲属信息");
		 List<OldManRelationPo> relationList = oldManRelationMapper.queryRelation(oldManRelationPo);
		 if(relationList.size()>0){
			 return relationList;
		 }
		 return null;
	}

	/**
	 * 修改老人健康信息
	 */
	public int updateRelation(OldManRelationPo oldManRelationPo) {
		logger.debug("开始修改老人亲属信息");
		try{
			int result = oldManRelationMapper.updateRelation(oldManRelationPo);
			return result;
		}catch(Exception e){
			logger.debug("添加失败");
			return 0;
		}
	}
}
