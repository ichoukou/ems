package com.channelsoft.ems.po;
/**
 * 	资金账户明细修改记录
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年2月20日
 */
public class FundAccountBillModRecordPo {
	//主键
	private String fId;
	//单据编号
	private String fnumber;
	//单据类型
	private String fname;
	//原始金额
	private String fAmount;
	//新金额
	private String fNewAmount;
	//变动差额
	private String fChangeAmount;
	//变动日期
	private String fChangeDate;
	//收支对象
	private String fPayment;
	//操作人
	private String fOperationer;
	//修改说明
	private String fRemark;

	public String toString() {
		return "FundAccountBillModRecordPo{"
				+ "fId='"+this.fId+"',"
				+ "fnumber='"+this.fnumber+"',"
				+ "fname='"+this.fname+"',"
				+ "fAmount='"+this.fAmount+"',"
				+ "fNewAmount='"+this.fNewAmount+"',"
				+ "fChangeAmount='"+this.fChangeAmount+"'"
				+ "fChangeDate='"+this.fChangeDate+"'"
				+ "fPayment='"+this.fPayment+"'"
				+ "fOperationer='"+this.fOperationer+"'"
				+ "fRemark='"+this.fRemark+"'"
				+ "}";
	}
	
	public FundAccountBillModRecordPo(){
		
	}
	
	public FundAccountBillModRecordPo(String fId,String fname,String fnumber,String fAmount,String fNewAmount,String fChangeAmount,String fChangeDate,String fPayment,String fOperationer,String fRemark){
		this.fId=fId;
		this.fname=fname;
		this.fnumber=fnumber;
		this.fAmount=fAmount;
		this.fChangeAmount=fChangeAmount;
		this.fNewAmount=fNewAmount;
		this.fChangeDate=fChangeDate;
		this.fOperationer=fOperationer;
		this.fPayment=fPayment;
		this.fRemark=fRemark;
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	}

	public String getFnumber() {
		return fnumber;
	}

	public void setFnumber(String fnumber) {
		this.fnumber = fnumber;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getfAmount() {
		return fAmount;
	}

	public void setfAmount(String fAmount) {
		this.fAmount = fAmount;
	}

	public String getfNewAmount() {
		return fNewAmount;
	}

	public void setfNewAmount(String fNewAmount) {
		this.fNewAmount = fNewAmount;
	}

	public String getfChangeAmount() {
		return fChangeAmount;
	}

	public void setfChangeAmount(String fChangeAmount) {
		this.fChangeAmount = fChangeAmount;
	}

	public String getfChangeDate() {
		return fChangeDate;
	}

	public void setfChangeDate(String fChangeDate) {
		this.fChangeDate = fChangeDate;
	}

	public String getfPayment() {
		return fPayment;
	}

	public void setfPayment(String fPayment) {
		this.fPayment = fPayment;
	}

	public String getfOperationer() {
		return fOperationer;
	}

	public void setfOperationer(String fOperationer) {
		this.fOperationer = fOperationer;
	}

	public String getfRemark() {
		return fRemark;
	}

	public void setfRemark(String fRemark) {
		this.fRemark = fRemark;
	}
}
