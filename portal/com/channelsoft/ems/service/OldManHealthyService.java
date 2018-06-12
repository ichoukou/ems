package com.channelsoft.ems.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.channelsoft.ems.po.OldManHealthyPo;
import com.channelsoft.ems.po.OldManMainPo;
/**
 * 
 * @author lizhu
 *
 */
public interface OldManHealthyService {
	
	/**
	 * 查询老人健康信息
	 * @param oldManHealthy
	 * @return
	 */
	public List<OldManHealthyPo> queryToList(int page,int pageSize,OldManMainPo oldManMainPo);
	
	/**
	 * 得到总数  分页使用
	 * @param oldManMainPo
	 * @return
	 */
	public int getTotal(OldManMainPo oldManMainPo);
	
	/**
	 * 新增
	 * @param oldManHealthy
	 * @return
	 */
	public int addOldManHealthy(OldManHealthyPo oldManHealthy,HttpServletRequest request);
	
	/**
	 * 修改老人健康信息
	 * @param oldManHealthy
	 * @return
	 */
	public int udpateOldManHealthy(OldManHealthyPo oldManHealthy);
	

}
