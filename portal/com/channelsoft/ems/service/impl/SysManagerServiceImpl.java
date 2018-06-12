package com.channelsoft.ems.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.SysManagerMapper;
import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.service.SysManagerService;

@Service
public class SysManagerServiceImpl implements SysManagerService{

	private static Logger logger = Logger.getLogger(SysManagerServiceImpl.class);
	
	@Autowired
	private SysManagerMapper mapper;

	/**
	 * @Method: queryCount
	 * @Description: 查询数据字典总数
	 * @Para: [DataDictionaryPo]
	 * @Retun: int
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public int queryCount(DataDictionaryPo po){
		int dataCount=mapper.queryCount(po);
		logger.debug("数据字典总数："+dataCount);
		return dataCount;
	}

	/**
	 * @Method: queryDcList
	 * @Description: 分页查询数据字典
	 * @Para: [DataDictionaryPo po,int page,int pageSize,String sortName,String sortOrder]
	 * @Retun: List<DataDictionaryPo>
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public List<DataDictionaryPo> queryDcList(DataDictionaryPo po,int page,int pageSize,String sortName,String sortOrder){
		logger.debug("进入SysManagerServiceImpl.queryDcList()");
		logger.debug("查询参数: " + po.toString());
		List<DataDictionaryPo> dcList = mapper.queryDcList(po,page,pageSize,sortName,sortOrder);
		logger.debug("数据字典，查询得到: " + dcList.size()+" 条数据");
		return dcList;
	}

	/**
	 * @Method: getDcList
	 * @Description: 查询数据字典
	 * @Para: [DataDictionaryPo]
	 * @Retun: List<DataDictionaryPo>
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public List<DataDictionaryPo> getDcList(DataDictionaryPo po){
		logger.debug("进入SysManagerServiceImpl.getDcList()方法");
		logger.debug("查询参数: " + po.toString());
		List<DataDictionaryPo> dcList = mapper.getDcList(po);
		logger.debug("数据字典（不分页），查询得到: " + dcList.size()+" 条数据");
		return dcList;
	}

	/**
	 * @Method: checkDc
	 * @Description: 验证数据字典
	 * @Para: [DataDictionaryPo]
	 * @Retun: int
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public int checkDc(DataDictionaryPo po){
		logger.debug("进入SysManagerServiceImpl.checkDc()......");
		logger.debug("查询参数: " + po.toString());
		int result = mapper.checkDc(po);
		logger.debug("数据字典，查询结果："+result);
		return result;
	}

	/**
	 * @Method: addData
	 * @Description: 添加数据字典
	 * @Para: [DataDictionaryPo]
	 * @Retun: void
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public void addData(DataDictionaryPo po){
		logger.debug("进入SysManagerServiceImpl.addData()方法");
		try{
			mapper.addData(po);
			logger.debug("添加数据字典成功");
		}catch (Exception e){
			logger.error("添加数据字典异常:"+e.getMessage());
		}
	}

	/**
	 * @Method: updData
	 * @Description: 更新数据字典
	 * @Para: [DataDictionaryPo]
	 * @Retun: void
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public void updData(DataDictionaryPo po){
		logger.debug("进入SysManagerServiceImpl.updData()方法");
		try{
			mapper.updData(po);
			logger.debug("更新数据字典成功");
		}catch (Exception e){
			logger.error("更新数据字典异常:"+e.getMessage());
		}
	}

	/**
	 * @Method: updDcStatus
	 * @Description: 禁用数据字典
	 * @Para: [DataDictionaryPo]
	 * @Retun: void
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public void updDcStatus(DataDictionaryPo po){
		logger.debug("进入SysManagerServiceImpl.delData()方法");
		try{
			mapper.updDcStatus(po);
			logger.debug("禁用数据字典成功");
		}catch (Exception e){
			logger.error("禁用数据字典异常:"+e.getMessage());
		}
	}
}
