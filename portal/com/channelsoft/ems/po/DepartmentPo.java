package com.channelsoft.ems.po;

public class DepartmentPo {

	private String fid;
	private String fDepartmentName;
	private String fDepartmentAttrbute;
    private String fHigherUpID;
	private String fStatus;//是否禁用
	private String fPortalType;//是否排房
	private String fSortNumber;//是否排班
	private String fParameter;//是否排人
	private String father;//父亲菜单
	
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getfDepartmentName() {
		return fDepartmentName;
	}
	public void setfDepartmentName(String fDepartmentName) {
		this.fDepartmentName = fDepartmentName;
	}
	public String getfDepartmentAttrbute() {
		return fDepartmentAttrbute;
	}
	public void setfDepartmentAttrbute(String fDepartmentAttrbute) {
		this.fDepartmentAttrbute = fDepartmentAttrbute;
	}
	public String getfHigherUpID() {
		return fHigherUpID;
	}
	public void setfHigherUpID(String fHigherUpID) {
		this.fHigherUpID = fHigherUpID;
	}
	public String getfStatus() {
		return fStatus;
	}
	public void setfStatus(String fStatus) {
		this.fStatus = fStatus;
	}
	public String getfPortalType() {
		return fPortalType;
	}
	public void setfPortalType(String fPortalType) {
		this.fPortalType = fPortalType;
	}
	public String getfSortNumber() {
		return fSortNumber;
	}
	public void setfSortNumber(String fSortNumber) {
		this.fSortNumber = fSortNumber;
	}
	public String getfParameter() {
		return fParameter;
	}
	public void setfParameter(String fParameter) {
		this.fParameter = fParameter;
	}
	public DepartmentPo(){
		
	};
	
	public DepartmentPo(String fid, String fDepartmentName,
			String fDepartmentAttrbute, String fHigherUpID, String fStatus,
			String fPortalType, String fSortNumber, String fParameter,String father) {
		super();
		this.fid = fid;
		this.fDepartmentName = fDepartmentName;
		this.fDepartmentAttrbute = fDepartmentAttrbute;
		this.fHigherUpID = fHigherUpID;
		this.fStatus = fStatus;
		this.fPortalType = fPortalType;
		this.fSortNumber = fSortNumber;
		this.fParameter = fParameter;
		this.father=father;
	}
	@Override
	public String toString() {
		return "DepartmentPo [fid=" + fid + ", fDepartmentName="
				+ fDepartmentName + ", fDepartmentAttrbute="
				+ fDepartmentAttrbute + ", fHigherUpID=" + fHigherUpID
				+ ", fStatus=" + fStatus + ", fPortalType=" + fPortalType
				+ ", fSortNumber=" + fSortNumber + ", fParameter=" + fParameter
				+ ", father=" + father + "]";
	}
	
	
	
	
}
