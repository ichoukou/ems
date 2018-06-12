package com.channelsoft.ems.service.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.OldManQuitMapper;
import com.channelsoft.ems.mapper.OldManRecordMapper;
import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManMainPo;
import com.channelsoft.ems.po.OldManRecordPo;
import com.channelsoft.ems.service.OldManRecordService;
/**
 *  老人日常行为的业务层实现
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年1月3日
 */
@Service
public class OldManRecordServiceImpl implements OldManRecordService {
	
	@Autowired
	private OldManRecordMapper oldManRecordMapper;
	//老人退住
	@Autowired
	private OldManQuitMapper oldManQuitMapper;
	
	private Logger logger=Logger.getLogger(OldManRecordServiceImpl.class);

	public List<OldManRecordPo> queryRecord(int page, int pageSize, OldManRecordPo oldManRecordPo) {
		logger.debug("查询老人日常行为记录queryRecord");
		List<OldManRecordPo> recordList = oldManRecordMapper.queryRecordList(oldManRecordPo, page, pageSize);
		return recordList;
	}

	public int getCount(OldManRecordPo oldManRecordPo) {
		logger.debug("开始查询总条数，分页使用");
		int  result=oldManRecordMapper.getCount(oldManRecordPo);
		return result;
	}

	public List<DataDictionaryPo> getType(String dcName) {
		logger.debug("查询老人日常行为记录的类型getType");
		List<DataDictionaryPo> dcList=oldManRecordMapper.getType(dcName);
		return dcList;
	}

	public String getTypeNameById(String id) {
		String dcValue=oldManRecordMapper.getTypeNameById(id);
		return dcValue;
	}

	public int addRecord(OldManRecordPo oldManRecordPo,HttpServletRequest request,HttpServletResponse response) {
		String fNumber=UUID.randomUUID().toString();
		//因为没做登录 所以此处写死    可以根据id获取其养老院的id
		//String fCreatorId=(String) request.getSession().getAttribute("id");
		String fCreatorId="1";
		String fNursinghomeId="1";
		oldManRecordPo.setfCreatorID(fCreatorId);
		oldManRecordPo.setfNursingHomeId(fNursinghomeId);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String fCreateTime=sdf.format(new Date());
		oldManRecordPo.setfCreateTime(fCreateTime);
		oldManRecordPo.setfNumber(fNumber);
		logger.debug("传递的参数为"+oldManRecordPo.toString());
		//查询老人是否存在  使用老人退住的mapper
		OldManMainPo oldManMainPo=new OldManMainPo();
		oldManMainPo.setfID(oldManRecordPo.getfOldManId());
		 List<OldManMainPo> oldMan=oldManQuitMapper.queryOldManByUserFId(oldManMainPo);
			if(oldMan.size()==0||oldMan==null){
				return 2;
			}
			try{
				int result=oldManRecordMapper.addRecord(oldManRecordPo);
				return result;
			}catch(Exception e){
				return 0;
			}
	}
	
	public String getStaffNameById(String id) {
		String name=oldManRecordMapper.getStaffNameById(id);
		return name;
	}

	public int deleteRecord(OldManRecordPo oldManRecordPo) {
		logger.debug("传进来的参数为"+oldManRecordPo.toString());
		String fId=oldManRecordPo.getfID();
		try{
			int result=oldManRecordMapper.deleteRecord(fId);
			return result;
		}catch(Exception e){
			return 0;
		}
	}

	public int updateRecord(OldManRecordPo oldManRecordPo) {
		logger.debug("传进来的参数为"+oldManRecordPo.toString());
		try{
			int i=oldManRecordMapper.updateRecord(oldManRecordPo);
			return i;
		}catch(Exception e){
			logger.debug("执行修改老人日常行为记录的sql语句失败");
			return 0;
		}
	}
}
