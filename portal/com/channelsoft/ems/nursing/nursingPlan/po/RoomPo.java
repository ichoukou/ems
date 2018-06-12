package com.channelsoft.ems.nursing.nursingPlan.po;

import com.channelsoft.ems.common.PagePo;

public class RoomPo extends PagePo{
    private String fid;
    private String fNursingHomeID;
    private String fBuildingID;
    private String fBuildingName;

    private String fFLoorID;
    private String fFLoorName;
    
    private String fRoomNumber;
    private String fRoomName;
    private String fRoomType;
    private String fRoomOrientation;
    private String fRoomPrice;
    private String fBedCount;
    private String fManNumber;
    private String fStatus;
    private String fExplain;
    private String fRemarks;
    
	private String fcurUserID ;    //当前登录人Id 
    
	public String getfNursingHomeID() {
		return fNursingHomeID;
	}
	public void setfNursingHomeID(String fNursingHomeID) {
		this.fNursingHomeID = fNursingHomeID;
	}
	public String getfBuildingID() {
		return fBuildingID;
	}
	public void setfBuildingID(String fBuildingID) {
		this.fBuildingID = fBuildingID;
	}
	public String getfBuildingName() {
		return fBuildingName;
	}
	public void setfBuildingName(String fBuildingName) {
		this.fBuildingName = fBuildingName;
	}
	public String getfFLoorID() {
		return fFLoorID;
	}
	public void setfFLoorID(String fFLoorID) {
		this.fFLoorID = fFLoorID;
	}
	public String getfFLoorName() {
		return fFLoorName;
	}
	public void setfFLoorName(String fFLoorName) {
		this.fFLoorName = fFLoorName;
	}
	public String getfRoomNumber() {
		return fRoomNumber;
	}
	public void setfRoomNumber(String fRoomNumber) {
		this.fRoomNumber = fRoomNumber;
	}
	public String getfRoomName() {
		return fRoomName;
	}
	public void setfRoomName(String fRoomName) {
		this.fRoomName = fRoomName;
	}
	public String getfRoomType() {
		return fRoomType;
	}
	public void setfRoomType(String fRoomType) {
		this.fRoomType = fRoomType;
	}
	public String getfRoomOrientation() {
		return fRoomOrientation;
	}
	public void setfRoomOrientation(String fRoomOrientation) {
		this.fRoomOrientation = fRoomOrientation;
	}
	public String getfRoomPrice() {
		return fRoomPrice;
	}
	public void setfRoomPrice(String fRoomPrice) {
		this.fRoomPrice = fRoomPrice;
	}
	public String getfBedCount() {
		return fBedCount;
	}
	public void setfBedCount(String fBedCount) {
		this.fBedCount = fBedCount;
	}
	public String getfManNumber() {
		return fManNumber;
	}
	public void setfManNumber(String fManNumber) {
		this.fManNumber = fManNumber;
	}
	public String getfStatus() {
		return fStatus;
	}
	public void setfStatus(String fStatus) {
		this.fStatus = fStatus;
	}
	public String getfExplain() {
		return fExplain;
	}
	public void setfExplain(String fExplain) {
		this.fExplain = fExplain;
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
	public String getFcurUserID() {
		return fcurUserID;
	}
	public void setFcurUserID(String fcurUserID) {
		this.fcurUserID = fcurUserID;
	}
}
