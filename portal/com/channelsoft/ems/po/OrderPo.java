package com.channelsoft.ems.po;
/** 
 * 
 * 居家服务订单
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午19:13:41 
 * @parameter  
 * @return  
 */
public class OrderPo {
	private String startTime;
	private String overTime;
	private String fid;//序号 
	private String fOrderNo;//工单号 
    private String fObjectName;//老人姓名
    private String fObjectPhone;//联系电话
    private String fServiceObject;//服务对象  数据字典
    private String fServiceUser;//服务人员  员工表
    private String fDealStatus;//处理状态  数据字典
    private String fRequestTime;//要求服务时间   时间表  
    private String fFinishTime;//工单完成时间
    private String fEvaluationOrder;//评价服务
    private String fOrderType;//工单类型
    private String fRecieveDept;//受理部门
    private String fCallPhone;//来电人电话
    private String fServiceProvide;//服务方
    private String fRecieveUser;//接单人
    private String fCallName;//来电人姓名
    private String fRecieveTime;//接单时间
    private String fServiceType;//服务大类
    private String fServiceTypeid;//服务大类的id
    private String fOrderEmergency;//工单紧急程度 
    private String fServiceItem;//服务项目select
	private String fServiceItemName;//服务项目名称
    private String fServiceItemid;//服务id
    private String fPayStyle;// 付款方式select 
    private String fPrice;// 单价  根据服务项目带出//动态带出
    private String fServiceAdd;// 服务地址   input
    private String fNumber;// 数量 input 
    private String fTotal;//金额 input  动态生成
    private String fOrderyExplain;//工单说明
    private String fCreatorID;//创建人
    private String fCreateTime;//默认系统当前时间
	private String funit;//单位
    private String fNursingHomeID;//养老院id

	public OrderPo(String startTime, String overTime, String fid, String fOrderNo, String fObjectName, String fObjectPhone, String fServiceObject, String fServiceUser, String fDealStatus, String fRequestTime, String fFinishTime, String fEvaluationOrder, String fOrderType, String fRecieveDept, String fCallPhone, String fServiceProvide, String fRecieveUser, String fCallName, String fRecieveTime, String fServiceType, String fServiceTypeid, String fOrderEmergency, String fServiceItem, String fServiceItemName, String fServiceItemid, String fPayStyle, String fPrice, String fServiceAdd, String fNumber, String fTotal, String fOrderyExplain, String fCreatorID, String fCreateTime, String funit, String fNursingHomeID) {
		this.startTime = startTime;
		this.overTime = overTime;
		this.fid = fid;
		this.fOrderNo = fOrderNo;
		this.fObjectName = fObjectName;
		this.fObjectPhone = fObjectPhone;
		this.fServiceObject = fServiceObject;
		this.fServiceUser = fServiceUser;
		this.fDealStatus = fDealStatus;
		this.fRequestTime = fRequestTime;
		this.fFinishTime = fFinishTime;
		this.fEvaluationOrder = fEvaluationOrder;
		this.fOrderType = fOrderType;
		this.fRecieveDept = fRecieveDept;
		this.fCallPhone = fCallPhone;
		this.fServiceProvide = fServiceProvide;
		this.fRecieveUser = fRecieveUser;
		this.fCallName = fCallName;
		this.fRecieveTime = fRecieveTime;
		this.fServiceType = fServiceType;
		this.fServiceTypeid = fServiceTypeid;
		this.fOrderEmergency = fOrderEmergency;
		this.fServiceItem = fServiceItem;
		this.fServiceItemName = fServiceItemName;
		this.fServiceItemid = fServiceItemid;
		this.fPayStyle = fPayStyle;
		this.fPrice = fPrice;
		this.fServiceAdd = fServiceAdd;
		this.fNumber = fNumber;
		this.fTotal = fTotal;
		this.fOrderyExplain = fOrderyExplain;
		this.fCreatorID = fCreatorID;
		this.fCreateTime = fCreateTime;
		this.funit = funit;
		this.fNursingHomeID = fNursingHomeID;
	}

	public void setfNursingHomeID(String fNursingHomeID) {
		this.fNursingHomeID = fNursingHomeID;
	}

	public String getfNursingHomeID() {
		return fNursingHomeID;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getOverTime() {
		return overTime;
	}

	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getfOrderNo() {
		return fOrderNo;
	}

	public void setfOrderNo(String fOrderNo) {
		this.fOrderNo = fOrderNo;
	}

	public String getfObjectName() {
		return fObjectName;
	}

	public void setfObjectName(String fObjectName) {
		this.fObjectName = fObjectName;
	}

	public String getfObjectPhone() {
		return fObjectPhone;
	}

	public void setfObjectPhone(String fObjectPhone) {
		this.fObjectPhone = fObjectPhone;
	}

	public String getfServiceObject() {
		return fServiceObject;
	}

	public void setfServiceObject(String fServiceObject) {
		this.fServiceObject = fServiceObject;
	}

	public String getfServiceUser() {
		return fServiceUser;
	}

	public void setfServiceUser(String fServiceUser) {
		this.fServiceUser = fServiceUser;
	}

	public String getfDealStatus() {
		return fDealStatus;
	}

	public void setfDealStatus(String fDealStatus) {
		this.fDealStatus = fDealStatus;
	}

	public String getfRequestTime() {
		return fRequestTime;
	}

	public void setfRequestTime(String fRequestTime) {
		this.fRequestTime = fRequestTime;
	}

	public String getfFinishTime() {
		return fFinishTime;
	}

	public void setfFinishTime(String fFinishTime) {
		this.fFinishTime = fFinishTime;
	}

	public String getfEvaluationOrder() {
		return fEvaluationOrder;
	}

	public void setfEvaluationOrder(String fEvaluationOrder) {
		this.fEvaluationOrder = fEvaluationOrder;
	}

	public String getfOrderType() {
		return fOrderType;
	}

	public void setfOrderType(String fOrderType) {
		this.fOrderType = fOrderType;
	}

	public String getfRecieveDept() {
		return fRecieveDept;
	}

	public void setfRecieveDept(String fRecieveDept) {
		this.fRecieveDept = fRecieveDept;
	}

	public String getfCallPhone() {
		return fCallPhone;
	}

	public void setfCallPhone(String fCallPhone) {
		this.fCallPhone = fCallPhone;
	}

	public String getfServiceProvide() {
		return fServiceProvide;
	}

	public void setfServiceProvide(String fServiceProvide) {
		this.fServiceProvide = fServiceProvide;
	}

	public String getfRecieveUser() {
		return fRecieveUser;
	}

	public void setfRecieveUser(String fRecieveUser) {
		this.fRecieveUser = fRecieveUser;
	}

	public String getfCallName() {
		return fCallName;
	}

	public void setfCallName(String fCallName) {
		this.fCallName = fCallName;
	}

	public String getfRecieveTime() {
		return fRecieveTime;
	}

	public void setfRecieveTime(String fRecieveTime) {
		this.fRecieveTime = fRecieveTime;
	}

	public String getfServiceType() {
		return fServiceType;
	}

	public void setfServiceType(String fServiceType) {
		this.fServiceType = fServiceType;
	}

	public String getfServiceTypeid() {
		return fServiceTypeid;
	}

	public void setfServiceTypeid(String fServiceTypeid) {
		this.fServiceTypeid = fServiceTypeid;
	}

	public String getfOrderEmergency() {
		return fOrderEmergency;
	}

	public void setfOrderEmergency(String fOrderEmergency) {
		this.fOrderEmergency = fOrderEmergency;
	}

	public String getfServiceItem() {
		return fServiceItem;
	}

	public void setfServiceItem(String fServiceItem) {
		this.fServiceItem = fServiceItem;
	}

	public String getfServiceItemid() {
		return fServiceItemid;
	}

	public void setfServiceItemid(String fServiceItemid) {
		this.fServiceItemid = fServiceItemid;
	}

	public String getfPayStyle() {
		return fPayStyle;
	}

	public void setfPayStyle(String fPayStyle) {
		this.fPayStyle = fPayStyle;
	}

	public String getfPrice() {
		return fPrice;
	}

	public void setfPrice(String fPrice) {
		this.fPrice = fPrice;
	}

	public String getfServiceAdd() {
		return fServiceAdd;
	}

	public void setfServiceAdd(String fServiceAdd) {
		this.fServiceAdd = fServiceAdd;
	}

	public String getfNumber() {
		return fNumber;
	}

	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}

	public String getfTotal() {
		return fTotal;
	}

	public void setfTotal(String fTotal) {
		this.fTotal = fTotal;
	}

	public String getfOrderyExplain() {
		return fOrderyExplain;
	}

	public void setfOrderyExplain(String fOrderyExplain) {
		this.fOrderyExplain = fOrderyExplain;
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

	public String getFunit() {
		return funit;
	}

	public void setFunit(String funit) {
		this.funit = funit;
	}

	public String getfServiceItemName() {
		return fServiceItemName;
	}

	public void setfServiceItemName(String fServiceItemName) {
		this.fServiceItemName = fServiceItemName;
	}

	@Override
	public String toString() {
		return "OrderPo{" +
				"startTime='" + startTime + '\'' +
				", overTime='" + overTime + '\'' +
				", fid='" + fid + '\'' +
				", fOrderNo='" + fOrderNo + '\'' +
				", fObjectName='" + fObjectName + '\'' +
				", fObjectPhone='" + fObjectPhone + '\'' +
				", fServiceObject='" + fServiceObject + '\'' +
				", fServiceUser='" + fServiceUser + '\'' +
				", fDealStatus='" + fDealStatus + '\'' +
				", fRequestTime='" + fRequestTime + '\'' +
				", fFinishTime='" + fFinishTime + '\'' +
				", fEvaluationOrder='" + fEvaluationOrder + '\'' +
				", fOrderType='" + fOrderType + '\'' +
				", fRecieveDept='" + fRecieveDept + '\'' +
				", fCallPhone='" + fCallPhone + '\'' +
				", fServiceProvide='" + fServiceProvide + '\'' +
				", fRecieveUser='" + fRecieveUser + '\'' +
				", fCallName='" + fCallName + '\'' +
				", fRecieveTime='" + fRecieveTime + '\'' +
				", fServiceType='" + fServiceType + '\'' +
				", fServiceTypeid='" + fServiceTypeid + '\'' +
				", fOrderEmergency='" + fOrderEmergency + '\'' +
				", fServiceItem='" + fServiceItem + '\'' +
				", fServiceItemName='" + fServiceItemName + '\'' +
				", fServiceItemid='" + fServiceItemid + '\'' +
				", fPayStyle='" + fPayStyle + '\'' +
				", fPrice='" + fPrice + '\'' +
				", fServiceAdd='" + fServiceAdd + '\'' +
				", fNumber='" + fNumber + '\'' +
				", fTotal='" + fTotal + '\'' +
				", fOrderyExplain='" + fOrderyExplain + '\'' +
				", fCreatorID='" + fCreatorID + '\'' +
				", fCreateTime='" + fCreateTime + '\'' +
				", funit='" + funit + '\'' +
				", fNursingHomeID='" + fNursingHomeID + '\'' +
				'}';
	}

	public OrderPo(){
		
	}

}
