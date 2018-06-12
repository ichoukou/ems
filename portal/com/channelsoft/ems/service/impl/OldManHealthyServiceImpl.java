package com.channelsoft.ems.service.impl;

import java.text.SimpleDateFormat;
/**
 * @author lizhu
 */
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.channelsoft.ems.mapper.OldManQuitMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.OldManHealthyMapper;
import com.channelsoft.ems.po.OldManHealthyPo;
import com.channelsoft.ems.po.OldManMainPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.OldManHealthyService;
/**
 * 
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2016年12月21日
 */
@Service
public class OldManHealthyServiceImpl implements OldManHealthyService {
	private Logger logger=Logger.getLogger(OldManHealthyServiceImpl.class);

	@Autowired
	private OldManHealthyMapper oldManHealthyMapper;

	@Autowired
	private OldManQuitMapper oldManQuitMapper;
	
	//@Autowired
	//private OldManHosingMapper oldManHosingMapper;
	
	public int addOldManHealthy(OldManHealthyPo oldManHealthy,HttpServletRequest request) {
		logger.debug("进入OldManHealthyServiceImpl的addOldManHealthy方法");
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");

			oldManHealthy.setfCreatorID(user.getEmployId());
			oldManHealthy.setfNursingHomeID("1");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			oldManHealthy.setfCreateTime(sdf.format(new Date()));
		//查询老人是否存在  使用老人退住的mapper
		OldManMainPo oldManMainPo=new OldManMainPo();
		oldManMainPo.setfID(oldManHealthy.getfOldManID());
		List<OldManMainPo> oldMan=oldManQuitMapper.queryOldManByUserFId(oldManMainPo);
		if(oldMan.size()==0||oldMan==null){
			return 2;
		}
		try{
			int result=oldManHealthyMapper.addOldManHealthy(oldManHealthy);
			return result;
		}catch(Exception e){
			logger.debug("addOldManHealthy出错");
			return 0;
		}

	}

	public int udpateOldManHealthy(OldManHealthyPo oldManHealthy) {
		logger.debug("进入修改的方法，开始修改");
		try{
			int result=oldManHealthyMapper.updateOldManHealthy(oldManHealthy);
			return result;
		}catch(Exception e){
			return 0;
		}
	}

	public List<OldManHealthyPo> queryToList(int page, int pageSize, OldManMainPo oldManMainPo) {
		logger.debug("开始查询健康信息");
		List<OldManHealthyPo> list=oldManHealthyMapper.queryAll(page,pageSize,oldManMainPo);
		return list;
	}

	public int getTotal(OldManMainPo oldManMainPo) {
		logger.debug("开始查询总条数");
		int total =oldManHealthyMapper.getTotal(oldManMainPo);
		return total;
	}
}
