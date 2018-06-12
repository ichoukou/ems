package com.channelsoft.ems.common;

import java.util.Date;
/**
 * 公共字段类
 * @author lwj
 * @Date 2017年2月15日15:36:10
 */
public class BasePo extends PagePo{
	private String fid;
	private String fCreatorID;
	private Date fCreateTime; 
	private String fModifierID;
	private Date fModifierTime;
	private String fRemarks;
	private String fstatus;
	
	public Date getfCreateTime() {
		return fCreateTime;
	}
	public void setfCreateTime(Date fCreateTime) {
		this.fCreateTime = fCreateTime;
	}
	public String getfModifierID() {
		return fModifierID;
	}
	public void setfModifierID(String fModifierID) {
		this.fModifierID = fModifierID;
	}
	public Date getfModifierTime() {
		return fModifierTime;
	}
	public void setfModifierTime(Date fModifierTime) {
		this.fModifierTime = fModifierTime;
	}
	public String getfRemarks() {
		return fRemarks;
	}
	public void setfRemarks(String fRemarks) {
		this.fRemarks = fRemarks;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFstatus() {
		return fstatus;
	}
	public void setFstatus(String fstatus) {
		this.fstatus = fstatus;
	}
	public String getfCreatorID() {
		return fCreatorID;
	}
	public void setfCreatorID(String fCreatorID) {
		this.fCreatorID = fCreatorID;
	}
}
