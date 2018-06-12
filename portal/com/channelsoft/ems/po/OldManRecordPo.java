package com.channelsoft.ems.po;
/**
 *   老人日常记录表PO类
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2016年12月30日
 */
public class OldManRecordPo {
	//老人主键
	private String fID;
	//单据号
	private String fNumber;
	//养老院id
	private String fNursinghomeId;
	//老人id
	private String fOldManId;
	//日常记录类型
	private String fRecordType;
	//类型名称
	private String fRecordName;
	//日常记录日期
	private String fRecordDate;
	//责任人
	private String fKeeper;
	//责任人姓名
	private String fKeeperName;
	//原因
	private String fExplain;
	//创建人id
	private String fCreatorID;
	//创建时间
	private String fCreateTime;
	//老人姓名
	private String foldManName;
	
	public OldManRecordPo(){
		
	}
	public OldManRecordPo(String fID,String fNumber,String fNursingHomeId, String fOldManId,
			String fRecordType,String fRecordDate,String fKeeper,String fExplain,
			String fCreatorID,String fCreateTime){
		super();
		this.fID=fID;
		this.fNumber=fNumber;
		this.fNursinghomeId=fNursingHomeId;
		this.fOldManId=fOldManId;
		this.fRecordType=fRecordType;
		this.fRecordDate=fRecordDate;
		this.fKeeper=fKeeper;
		this.fExplain=fExplain;
		this.fCreatorID=fCreatorID;
		this.fCreateTime=fCreateTime;
	}
	@Override
		public String toString() {
			return "OldManRecordPo [fID=" + fID + ", fNumber=" + fNumber
					+ ", fNursingHomeId=" + fNursinghomeId + ", fOldManId="
					+ fOldManId + ", fRecordType=" + fRecordType
					+ ", fRecordDate=" + fRecordDate + ", fKeeper="
					+ fKeeper + ", fExplain=" + fExplain
					+ ", fCreatorID=" + fCreatorID + ", fCreateTime="
					+ fCreateTime 
					+ "]";
	}
	public String getfID() {
		return fID;
	}
	public void setfID(String fID) {
		this.fID = fID;
	}
	public String getfNumber() {
		return fNumber;
	}
	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}
	public String getfNursingHomeId() {
		return fNursinghomeId;
	}
	public void setfNursingHomeId(String fNursingHomeId) {
		this.fNursinghomeId = fNursingHomeId;
	}
	public String getfOldManId() {
		return fOldManId;
	}
	public void setfOldManId(String fOldManId) {
		this.fOldManId = fOldManId;
	}
	public String getfRecordType() {
		return fRecordType;
	}
	public void setfRecordType(String fRecordType) {
		this.fRecordType = fRecordType;
	}
	public String getfRecordName() {
		return fRecordName;
	}
	public void setfRecordName(String fRecordName) {
		this.fRecordName = fRecordName;
	}
	public String getfRecordDate() {
		return fRecordDate;
	}
	public void setfRecordDate(String fRecordDate) {
		this.fRecordDate = fRecordDate;
	}
	public String getfKeeper() {
		return fKeeper;
	}
	public void setfKeeper(String fKeeper) {
		this.fKeeper = fKeeper;
	}
	public String getfExplain() {
		return fExplain;
	}
	public void setfExplain(String fExplain) {
		this.fExplain = fExplain;
	}
	public String getfCreatorID() {
		return fCreatorID;
	}
	public void setfCreatorID(String fCreatorID) {
		this.fCreatorID = fCreatorID;
	}
	public String getfCreateTime() {
		return fCreateTime;
	}
	public void setfCreateTime(String fCreateTime) {
		this.fCreateTime = fCreateTime;
	}
	public String getFoldManName() {
		return foldManName;
	}
	public void setFoldManName(String foldManName) {
		this.foldManName = foldManName;
	}
	public String getfKeeperName() {
		return fKeeperName;
	}
	public void setfKeeperName(String fKeeperName) {
		this.fKeeperName = fKeeperName;
	}
}
