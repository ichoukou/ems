package com.channelsoft.ems.nursing.nursingProject.po;

import java.util.Date;

import com.channelsoft.ems.common.BasePo;
/**
 * 护理类型PO
 * @author lwj
 * @date 2017年2月11日15:40:58
 */
public class NursingServiceGroupPo extends BasePo{
	private String fid;
	private String fNursingHomeID;
	private String fAuditorID;
	private Date fAuditTime;
	private String fNumber;
	private String fStatus;
	private String fName;
	private String fServiceType;
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
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
	public String getfStatus() {
		return fStatus;
	}
	public void setfStatus(String fStatus) {
		this.fStatus = fStatus;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfServiceType() {
		return fServiceType;
	}
	public void setfServiceType(String fServiceType) {
		this.fServiceType = fServiceType;
	}
	public String getfAuditorID() {
		return fAuditorID;
	}
	public void setfAuditorID(String fAuditorID) {
		this.fAuditorID = fAuditorID;
	}
	public String getfNursingHomeID() {
		return fNursingHomeID;
	}
	public void setfNursingHomeID(String fNursingHomeID) {
		this.fNursingHomeID = fNursingHomeID;
	}
}
