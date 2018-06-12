package com.channelsoft.ems.nursing.nursingProject.po;

import java.util.Date;

import com.channelsoft.ems.common.BasePo;

/** 
 * 
 * 护理项目Po  
 * @author  lwj
 * @date 创建时间：2017年02月09日 下午14:31:41
 * @parameter  
 * @return  
 */
public class NursingProjectPo extends BasePo{
	private String fNursingHomeID;
	private String fAuditorID;
	private Date fAuditTime;
	private String fNumber;
	private String fName;
	private String fServiceGroupID;
	private String fExecuteType;
	private String fExecutecycle;
	private String fExecuteQty;
	private String fExecutetime;
	private String fStarteDate; 
	private String fEndDate;
	private String fExcludtime;
	
	/**
	 * 执行周期单位 1-天，2-周 3-月-4-年
	 */
	private String fExecutecycleUnit;

	/**
	 * 所属护理级别，仅用来获取一下值
	 */
	private String fserviceLevels;
	
	//查询页面展示用的
	private String serviceGroupName; //护理类型名称
	private String fserviceType;    // 护理类型-项目类型 
	
	public String getfNursingHomeID() {
		return fNursingHomeID;
	}
	public void setfNursingHomeID(String fNursingHomeID) {
		this.fNursingHomeID = fNursingHomeID;
	}
	public String getfAuditorID() {
		return fAuditorID;
	}
	public void setfAuditorID(String fAuditorID) {
		this.fAuditorID = fAuditorID;
	}
	public Date getfAuditTime() {
		return fAuditTime;
	}
	public void setfAuditTime(Date fAuditTime) {
		this.fAuditTime = fAuditTime;
	}
	public String getfNumber() {
		return fNumber;
	}
	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}
	public String getfServiceGroupID() {
		return fServiceGroupID;
	}
	public void setfServiceGroupID(String fServiceGroupID) {
		this.fServiceGroupID = fServiceGroupID;
	}
	public String getfExecuteType() {
		return fExecuteType;
	}
	public void setfExecuteType(String fExecuteType) {
		this.fExecuteType = fExecuteType;
	}
	
	public String getfExecutetime() {
		return fExecutetime;
	}
	public void setfExecutetime(String fExecutetime) {
		this.fExecutetime = fExecutetime;
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getFserviceLevels() {
		return fserviceLevels;
	}
	public void setFserviceLevels(String fserviceLevels) {
		this.fserviceLevels = fserviceLevels;
	}
	public String getfExecutecycleUnit() {
		return fExecutecycleUnit;
	}
	public void setfExecutecycleUnit(String fExecutecycleUnit) {
		this.fExecutecycleUnit = fExecutecycleUnit;
	}
	public String getServiceGroupName() {
		return serviceGroupName;
	}
	public void setServiceGroupName(String serviceGroupName) {
		this.serviceGroupName = serviceGroupName;
	}
	/*public Date getfStarteDate() {
		return fStarteDate;
	}
	public void setfStarteDate(Date fStarteDate) {
		this.fStarteDate = fStarteDate;
	}
	public Date getfEndDate() {
		return fEndDate;
	}
	public void setfEndDate(Date fEndDate) {
		this.fEndDate = fEndDate;
	}*/
	public String getfExecutecycle() {
		return fExecutecycle;
	}
	public void setfExecutecycle(String fExecutecycle) {
		this.fExecutecycle = fExecutecycle;
	}
	public String getfExecuteQty() {
		return fExecuteQty;
	}
	public void setfExecuteQty(String fExecuteQty) {
		this.fExecuteQty = fExecuteQty;
	}
	public String getfExcludtime() {
		return fExcludtime;
	}
	public void setfExcludtime(String fExcludtime) {
		this.fExcludtime = fExcludtime;
	}
	public String getFserviceType() {
		return fserviceType;
	}
	public void setFserviceType(String fserviceType) {
		this.fserviceType = fserviceType;
	}
	public String getfStarteDate() {
		return fStarteDate;
	}
	public void setfStarteDate(String fStarteDate) {
		this.fStarteDate = fStarteDate;
	}
	public String getfEndDate() {
		return fEndDate;
	}
	public void setfEndDate(String fEndDate) {
		this.fEndDate = fEndDate;
	}
}
