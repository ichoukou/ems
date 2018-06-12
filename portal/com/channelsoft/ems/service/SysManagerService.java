package com.channelsoft.ems.service;

import java.util.List;

import com.channelsoft.ems.po.DataDictionaryPo;

public interface SysManagerService {

	public int queryCount(DataDictionaryPo po);

	public List<DataDictionaryPo> queryDcList(DataDictionaryPo po,int page,int pageSize,String sortName,String sortOrder);

	public List<DataDictionaryPo> getDcList(DataDictionaryPo po);

	public int checkDc(DataDictionaryPo po);

	public void addData(DataDictionaryPo po);

	public void updData(DataDictionaryPo po);

	public void updDcStatus(DataDictionaryPo po);
	
}
