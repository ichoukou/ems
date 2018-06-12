package com.channelsoft.ems.service;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManRelationPo;
/**
 * 
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2016年12月21日
 */
public interface OldManRelationService {
	/**
	 * 添加老人亲属信息
	 * @param oldManRelationPo
	 * @return
	 */
	public int addOldManRelation(OldManRelationPo oldManRelationPo,HttpServletRequest request);
	/**
	 * 修改老人家属信息
	 * @param oldManRelationPo
	 * @return
	 */
	public int upateManRelation(OldManRelationPo oldManRelationPo);
	
	/**
	 * 获得回显的家属信息
	 * @return
	 */
	public List<DataDictionaryPo> getRelation(DataDictionaryPo dict) ;
	
	/**
	 * 查询老人的亲属信息
	 * @param oldManMainPo
	 * @return
	 */
	public List<OldManRelationPo> queryRelation(OldManRelationPo oldManRelationPo);
	
	/**
	 * 修改老人健康信息
	 * @param oldManRelationPo
	 * @return
	 */
	public int updateRelation(OldManRelationPo oldManRelationPo);
}
