package com.channelsoft.ems.po;
/**
 *  资金账户PO
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年1月5日
 */
public class FundAccountPo {
	//id  主键自增
	private String fId;
	//养老院id
	private String fNursinghomeId;
	//审核人
	private String fAuditorId;
	//审核时间
	private String fAuditTime;
	//创建人
	private String fCreatorId;
	//创建时间
	private String fCreateTime;
	//修改人
	private String fModifierId;
	//修改时间
	private String fModificationTime;
	//备注
	private String fRemarks;
	//账户号
	private String fNumber;
	//状态
	private String fStatus;
	//状态名称
	private String fStatusName;
	//账户名称
	private String fName;
	//期初金额
	private String fAmount;
	//剩余金额
	private String fRestAmount;
	//负责人
	private String fHeader;
	//负责人姓名
	private String fStaffName;
	//页面显示的超链接
	private String fLink;
	
	public FundAccountPo(){
		
	}
	
	public FundAccountPo(String fId,String fNursinghomeId,String fAuditorId,String fAuditTime
			,String fCreatorId,String fCreateTime,String fModifierId,String fModificationTime,
			String fRemarks,String fNumber,String fStatus,String fName,String fAmount,String fRestAmount,String fHeader){
		this.fId=fId;
		this.fNursinghomeId=fNursinghomeId;
		this.fAuditorId=fAuditorId;
		this.fAuditTime=fAuditTime;
		this.fCreatorId=fCreatorId;
		this.fCreateTime=fCreateTime;
		this.fModifierId=fModifierId;
		this.fModificationTime=fModificationTime;
		this.fRemarks=fRemarks;
		this.fNumber=fNumber;
		this.fStatus=fStatus;
		this.fName=fName;
		this.fAmount=fAmount;
		this.fHeader=fHeader;
		this.fRestAmount=fRestAmount;
	}
	
	public String toString(){
		return "FundAccountPo["
				+ "fId='"+fId+"',"
				+ "fNursinghomeId='"+fNursinghomeId+"',"
				+ "fAuditorId='"+fAuditorId+"',"
				+ "fAuditTime='"+fAuditTime+"',"
				+ "fCreatorId='"+fCreatorId+"',"
				+ "fCreateTime='"+fCreateTime+"',"
				+ "fModifierId='"+fModifierId+"',"
				+ "fModificationTime='"+fModificationTime+"',"
				+ "fRemarks='"+fRemarks+"',"
				+ "fNumber='"+fNumber+"',"
				+ "fStatus='"+fStatus+"',"
				+ "fName='"+fName+"',"
				+ "fAmount='"+fAmount+"',"
				+ "fHeader='"+fHeader+"',"
				+ "fRestAmount='"+fRestAmount+"']";
	}
	
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getfNursinghomeId() {
		return fNursinghomeId;
	}
	public void setfNursinghomeId(String fNursinghomeId) {
		this.fNursinghomeId = fNursinghomeId;
	}
	public String getfAuditorId() {
		return fAuditorId;
	}
	public void setfAuditorId(String fAuditorId) {
		this.fAuditorId = fAuditorId;
	}
	public String getfAuditTime() {
		return fAuditTime;
	}
	public void setfAuditTime(String fAuditTime) {
		this.fAuditTime = fAuditTime;
	}
	public String getfCreatorId() {
		return fCreatorId;
	}
	public void setfCreatorId(String fCreatorId) {
		this.fCreatorId = fCreatorId;
	}
	public String getfCreateTime() {
		return fCreateTime;
	}
	public void setfCreateTime(String fCreateTime) {
		this.fCreateTime = fCreateTime;
	}
	public String getfModifierId() {
		return fModifierId;
	}
	public void setfModifierId(String fModifierId) {
		this.fModifierId = fModifierId;
	}
	public String getfModificationTime() {
		return fModificationTime;
	}
	public void setfModificationTime(String fModificationTime) {
		this.fModificationTime = fModificationTime;
	}
	public String getfRemarks() {
		return fRemarks;
	}
	public void setfRemarks(String fRemarks) {
		this.fRemarks = fRemarks;
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
	
	public String getfStatusName() {
		return fStatusName;
	}

	public void setfStatusName(String fStatusName) {
		this.fStatusName = fStatusName;
	}

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfAmount() {
		return fAmount;
	}
	public void setfAmount(String fAmount) {
		this.fAmount = fAmount;
	}
	public String getfHeader() {
		return fHeader;
	}
	public void setfHeader(String fHeader) {
		this.fHeader = fHeader;
	}

	public String getfLink() {
		return fLink;
	}

	public void setfLink(String fLink) {
		this.fLink = fLink;
	}

	public String getfRestAmount() {
		return fRestAmount;
	}

	public void setfRestAmount(String fRestAmount) {
		this.fRestAmount = fRestAmount;
	}

	public String getfStaffName() {
		return fStaffName;
	}

	public void setfStaffName(String fStaffName) {
		this.fStaffName = fStaffName;
	}
	
	
}
