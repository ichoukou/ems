package com.channelsoft.ems.service;

import java.util.List;

import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManMainPo;

public interface OldManQuitService {
	
	public List<OldManMainPo> query(OldManMainPo oldManMainPo,int page,int pageSize);
	public int getCount(OldManMainPo oldManMainPo);
	public String getBed(String bedId);
	public String getLeaveTypeName(String typeId);
	public List<DataDictionaryPo> queryLeaveType(String typeName);
	/**
	 * 添加退住信息
	 * @param oldManMainPo
	 * @return
	 * @throws Exception
	 */
	public int addLeave(OldManMainPo oldManMainPo) throws Exception;
	public List<OldManMainPo> queryByFId(OldManMainPo oldManMainPo);
	public int deleteLeave(OldManMainPo oldManMainPo);
}
