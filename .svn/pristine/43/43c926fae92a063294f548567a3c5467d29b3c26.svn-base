package com.channelsoft.ems.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManRecordPo;

/**
 * ；老人日常行为记录的
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年1月3日
 */
public interface OldManRecordService {
	/**
	 * 查询所有日常记录 带分页
	 * @param page
	 * @param pageSize
	 * @param oldManRecordPo
	 * @return
	 */
	public List<OldManRecordPo> queryRecord(int page,int pageSize,OldManRecordPo oldManRecordPo);
	/**
	 * 获得总条数  分页用
	 * @param oldManRecordPo
	 * @return
	 */
	public int getCount(OldManRecordPo oldManRecordPo);
	/**
	 * 回显使用的
	 * @param dc
	 * @return
	 */
	public List<DataDictionaryPo> getType(String dcName);
	/**
	 * 根据字典id得到字典名称
	 * @param id
	 * @return
	 */
	public String getTypeNameById(String id);
	/**
	 * 根据职工id得到职工名字  回显使用
	 * @param id
	 * @return
	 */
	public String getStaffNameById(String id);
	
	/**
	 * 添加老人日常管理信息
	 * @param oldManRecordPo
	 * @return
	 */
	public int addRecord(OldManRecordPo oldManRecordPo,HttpServletRequest request,HttpServletResponse response);
	/**
	 * 删除老人日产行为记录
	 * @param oldManRecordPo
	 * @return
	 */
	public int deleteRecord(OldManRecordPo oldManRecordPo);
	/**
	 * 修改老人日常行为记录
	 * @param oldManRecordPo
	 * @return
	 */
	public int updateRecord(OldManRecordPo oldManRecordPo);
	

}
