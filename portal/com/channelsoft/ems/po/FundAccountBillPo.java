package com.channelsoft.ems.po;
/**
 *  收支明细表
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年1月8日
 */
public class FundAccountBillPo {
	//id 主键
	private String fId;
	//养老院id
	private String fnursinghomeID;
	//审核人id
	private String fAuditorID;
	//审核人姓名
	private String fAuditorName;
	//审核时间
	private String fAuditTime;
	//创建人
	private String fCreatorID;
	//创建人姓名
	private String fCreatorName;
	//创建开始时间   查询使用
	private String fStartDate;
	//创建结束时间  查询使用
	private String fEndDate;
	//创建时间
	private String fCreateTime;
	//修改人
	private String fModifierID;
	//修改人姓名
	private String fModifierName;
	//修改时间
	private String fModificationTime;
	//备注
	private String fRemarks;
	//单据编号
	private String fNumber;
	//状态
	private String fStatus;
	//业务类型
	private String fType;
	//金额
	private String fAmount;
	//业务日期
	private String fbizdate;
	//杂项
	private String fPayments;
	//业务项目
	private String fBusinessitem;
	//账户
	private String fFundaccount;
	//账户名称
	private String fName;
	//支付人
	private String fPayment;
	//经办人
	private String fOperator;
	//经办人姓名
	private String fOperatorName;
	//凭据编号
	private String fProofnumber;
	//凭据文件
	private byte[] fProofdoc;
	//页面显示的超链接
	private String fLink;
	public FundAccountBillPo(){
		
	}
	
	public FundAccountBillPo(String fId,String fnursinghomeID,String fAuditorID
			,String fAuditTime,String fCreatorID,String fCreateTime,String fModifierID
			,String fModificationTime,String fRemarks,String fNumber,String fStatus
			,String fType,String fAmount,String fbizdate,String fPayments,String fBusinessitem
			, String fFundaccount,String fPayment,String fOperator,String fProofnumber,byte[] fProofdoc){
		this.fId=fId;
		this.fnursinghomeID=fnursinghomeID;
		this.fAuditorID=fAuditorID;
		this.fAuditTime=fAuditTime;
		this.fCreatorID=fCreatorID;
		this.fCreateTime=fCreateTime;
		this.fModificationTime=fModificationTime;
		this.fModifierID=fModifierID;
		this.fType=fType;
		this.fAmount=fAmount;
		this.fbizdate=fbizdate;
		this.fPayment=fPayment;
		this.fRemarks=fRemarks;
		this.fNumber=fNumber;
		this.fStatus=fStatus;
		this.fBusinessitem=fBusinessitem;
		this.fFundaccount=fFundaccount;
		this.fPayments=fPayments;
		this.fOperator=fOperator;
		this.fProofnumber=fProofnumber;
		this.fProofdoc=fProofdoc;
	}
	
	public String toString(){
		return "FundAccountBillPo["
				+ "fId='"+fId+"',"
				+ "fNursinghomeId='"+fnursinghomeID+"',"
				+ "fAuditorId='"+fAuditorID+"',"
				+ "fAuditTime='"+fAuditTime+"',"
				+ "fCreatorId='"+fCreatorID+"',"
				+ "fCreateTime='"+fCreateTime+"',"
				+ "fModifierId='"+fModifierID+"',"
				+ "fModificationTime='"+fModificationTime+"',"
				+ "fRemarks='"+fRemarks+"',"
				+ "fNumber='"+fNumber+"',"
				+ "fType='"+fType+"',"
				+ "fAmount='"+fAmount+"',"
				+ "fbizdate='"+fbizdate+"',"
				+ "fPayment='"+fPayment+"',"
				+ "fPayments='"+fPayments+"',"
				+ "fFundaccount='"+fFundaccount+"',"
				+ "fStatus='"+fStatus+"',"
				+ "fOperator='"+fOperator+"',"
				+ "fBusinessitem='"+fBusinessitem+"',"
				+ "fProofdoc='"+fProofdoc+","
				+ "fProofnumber='"+fProofnumber+"'']";
	}
	
	public String getfId() {
		return fId;
	}
	public void setfId(String fId) {
		this.fId = fId;
	}
	public String getFnursinghomeID() {
		return fnursinghomeID;
	}
	public void setFnursinghomeID(String fnursinghomeID) {
		this.fnursinghomeID = fnursinghomeID;
	}
	public String getfAuditorID() {
		return fAuditorID;
	}
	public void setfAuditorID(String fAuditorID) {
		this.fAuditorID = fAuditorID;
	}
	public String getfAuditTime() {
		return fAuditTime;
	}
	public void setfAuditTime(String fAuditTime) {
		this.fAuditTime = fAuditTime;
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
	public String getfModifierID() {
		return fModifierID;
	}
	public void setfModifierID(String fModifierID) {
		this.fModifierID = fModifierID;
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
	public String getfType() {
		return fType;
	}
	public void setfType(String fType) {
		this.fType = fType;
	}
	public String getfAmount() {
		return fAmount;
	}
	public void setfAmount(String fAmount) {
		this.fAmount = fAmount;
	}
	public String getFbizdate() {
		return fbizdate;
	}
	public void setFbizdate(String fbizdate) {
		this.fbizdate = fbizdate;
	}
	public String getfPayments() {
		return fPayments;
	}
	public void setfPayments(String fPayments) {
		this.fPayments = fPayments;
	}
	public String getfBusinessitem() {
		return fBusinessitem;
	}
	public void setfBusinessitem(String fBusinessitem) {
		this.fBusinessitem = fBusinessitem;
	}
	public String getfFundaccount() {
		return fFundaccount;
	}
	public void setfFundaccount(String fFundaccount) {
		this.fFundaccount = fFundaccount;
	}
	public String getfPayment() {
		return fPayment;
	}
	public void setfPayment(String fPayment) {
		this.fPayment = fPayment;
	}
	public String getfOperator() {
		return fOperator;
	}
	public void setfOperator(String fOperator) {
		this.fOperator = fOperator;
	}
	public String getfProofnumber() {
		return fProofnumber;
	}
	public void setfProofnumber(String fProofnumber) {
		this.fProofnumber = fProofnumber;
	}

	public byte[] getfProofdoc() {
		return fProofdoc;
	}

	public void setfProofdoc(byte[] fProofdoc) {
		this.fProofdoc = fProofdoc;
	}

	public String getfLink() {
		return fLink;
	}

	public void setfLink(String fLink) {
		this.fLink = fLink;
	}

	public String getfStartDate() {
		return fStartDate;
	}

	public void setfStartDate(String fStartDate) {
		this.fStartDate = fStartDate;
	}

	public String getfEndDate() {
		return fEndDate;
	}

	public void setfEndDate(String fEndDate) {
		this.fEndDate = fEndDate;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfAuditorName() {
		return fAuditorName;
	}

	public void setfAuditorName(String fAuditorName) {
		this.fAuditorName = fAuditorName;
	}

	public String getfCreatorName() {
		return fCreatorName;
	}

	public void setfCreatorName(String fCreatorName) {
		this.fCreatorName = fCreatorName;
	}

	public String getfModifierName() {
		return fModifierName;
	}

	public void setfModifierName(String fModifierName) {
		this.fModifierName = fModifierName;
	}

	public String getfOperatorName() {
		return fOperatorName;
	}

	public void setfOperatorName(String fOperatorName) {
		this.fOperatorName = fOperatorName;
	}

}
