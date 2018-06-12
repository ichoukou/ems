package com.channelsoft.ems.po;
/**
 *  账户收支明细删除记录
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年2月20日
 */
public class FundAccountBillDelRecordPo {
	//主键
	private String fId;
	//删除的单据编号
	private String fnumber;
	//单据类型
	private String fName;
	//作废金额
	private String fAmount;
	//作废日期
	private String fDeldate;
	//收支对象
	private String fPayment;
	//操作人
	private String fOprationer;
	//删除说明
	private String fRemark;
	
	public FundAccountBillDelRecordPo(){
		
	}
	
	public FundAccountBillDelRecordPo(String fId,String fnumber,String fName,String fAmount,String fDeldate,String fPayment,String fOprationer,String fRemark){
		this.fId=fId;
		this.fName=fName;
		this.fnumber =fnumber;
		this.fAmount=fAmount;
		this.fDeldate=fDeldate;
		this.fPayment=fPayment;
		this.fOprationer=fOprationer;
		this.fRemark=fRemark;
	}
	
	public String toString(){
		return "FundAccountBillDelRecordPo{"
				+ "fId='"+this.fId+"',"
				+ "fnumber='"+this.fnumber+"',"
				+ "fName='"+this.fName+"',"
				+ "fAmount='"+fAmount+"',"
				+ "fDeldate='"+this.fDeldate+"',"
				+ "fOperationer='"+this.fOprationer+"',"
				+ "fRemark='"+this.fRemark+"'"
				+ "}";
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

	public String getfAmount() {
		return fAmount;
	}

	public void setfAmount(String fAmount) {
		this.fAmount = fAmount;
	}

	public String getfDeldate() {
		return fDeldate;
	}

	public void setfDeldate(String fDeldate) {
		this.fDeldate = fDeldate;
	}

	public String getfPayment() {
		return fPayment;
	}

	public void setfPayment(String fPayment) {
		this.fPayment = fPayment;
	}

	public String getfOprationer() {
		return fOprationer;
	}

	public void setfOprationer(String fOprationer) {
		this.fOprationer = fOprationer;
	}

	public String getfRemark() {
		return fRemark;
	}

	public void setfRemark(String fRemark) {
		this.fRemark = fRemark;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}
	
}
