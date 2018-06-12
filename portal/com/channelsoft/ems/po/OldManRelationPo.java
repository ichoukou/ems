package com.channelsoft.ems.po;
/**
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2016年12月21日
 */

public class OldManRelationPo {
	//老人家属表主键  自增
	private String fID;
	//老人ID 老人表主键
	private String fOldManID;
	//老人姓名
	private String fOldManName;
	
	//与老人关系
	private String fRelation;
	//回显亲属关系使用(从数据字典中取)
	private String fRelationDict;
	//家属姓名
	private String fRelationName;
	//家属性别
	private String fRelationSex;
	//家属年龄
	private String fRelationAge;
	//家属手机号
	private String fRelationMobile;
	//家属座机
	private String fRelationPhone;
	//家属qq
	private String fRelationQQ;
	//家属微信
	private String fRelationMM;
	//家属所在公司
	private String fRelationCompany;
	//家属住址
	private String fRelationAdrress;
	//养老院ID
	private String fNursingHomeID;
	//创建人ID
	private String fCreatorID;
	//创建时间
	private String fCreateTime;
	
	public OldManRelationPo(){
		
	}
	public OldManRelationPo( String fID,String fOldManID,String fRelation,String fRelationName,String fRelationSex,String fRelationAge,
			String fRelationMobile,String fRelationPhone,String fRelationQQ,String fRelationMM,String fRelationCompany,String fRelationAdrress,
			String fNursingHomeID,String fCreatorID,String fCreateTime){
		this.fID=fID;
		this.fOldManID=fOldManID;
		this.fRelation=fRelation;
		this.fRelationName=fRelationName;
		this.fRelationSex=fRelationSex;
		this.fRelationAge=fRelationAge;
		this.fRelationMobile=fRelationMobile;
		this.fRelationPhone=fRelationPhone;
		this.fRelationQQ=fRelationQQ;
		this.fRelationMM=fRelationMM;
		this.fRelationAdrress=fRelationAdrress;
		this.fRelationCompany=fRelationCompany;
		this.fNursingHomeID=fNursingHomeID;
		this.fCreatorID=fCreatorID;
		this.fCreateTime=fCreateTime;
	}
	
	
	public String toString() {
		
		return "OldManRelation {"+
				"fID="+fID+'\''+
				","+"fOldManID="+fOldManID+'\''+
				","+"fRelation="+fRelation+'\''+
				","+"fRelationName="+fRelationName+'\''+
				","+"fRelationSex="+fRelationSex+'\''+
				","+"fRelationAge="+fRelationAge+'\''+
				","+"fRelationMobile="+fRelationMobile+'\''+
				","+"fRelationPhone="+fRelationPhone+'\''+
				","+"fRelationQQ="+fRelationQQ+'\''+
				","+"fRelationMM="+fRelationMM+'\''+
				","+"fRelationAdrress="+fRelationAdrress+'\''+
				","+"fRelationCompany="+fRelationCompany+'\''+
				","+"fNursingHomeID="+fNursingHomeID+'\''+
				","+"fCreatorID="+fCreatorID+'\''+
				","+"fCreateTime="+fCreateTime+'\''+
				'}';
	}
	public String getfID() {
		return fID;
	}
	public void setfID(String fID) {
		this.fID = fID;
	}
	public String getfOldManID() {
		return fOldManID;
	}
	public void setfOldManID(String fOldManID) {
		this.fOldManID = fOldManID;
	}
	public String getfRelation() {
		return fRelation;
	}
	public void setfRelation(String fRelation) {
		this.fRelation = fRelation;
	}
	public String getfRelationName() {
		return fRelationName;
	}
	public void setfRelationName(String fRelationName) {
		this.fRelationName = fRelationName;
	}
	public String getfRelationSex() {
		return fRelationSex;
	}
	public void setfRelationSex(String fRelationSex) {
		this.fRelationSex = fRelationSex;
	}
	public String getfRelationAge() {
		return fRelationAge;
	}
	public void setfRelationAge(String fRelationAge) {
		this.fRelationAge = fRelationAge;
	}
	public String getfRelationMobile() {
		return fRelationMobile;
	}
	public void setfRelationMobile(String fRelationMobile) {
		this.fRelationMobile = fRelationMobile;
	}
	public String getfRelationPhone() {
		return fRelationPhone;
	}
	public void setfRelationPhone(String fRelationPhone) {
		this.fRelationPhone = fRelationPhone;
	}
	public String getfRelationQQ() {
		return fRelationQQ;
	}
	public void setfRelationQQ(String fRelationQQ) {
		this.fRelationQQ = fRelationQQ;
	}
	public String getfRelationMM() {
		return fRelationMM;
	}
	public void setfRelationMM(String fRelationMM) {
		this.fRelationMM = fRelationMM;
	}
	public String getfRelationCompany() {
		return fRelationCompany;
	}
	public void setfRelationCompany(String fRelationCompany) {
		this.fRelationCompany = fRelationCompany;
	}
	public String getfRelationAdrress() {
		return fRelationAdrress;
	}
	public void setfRelationAdrress(String fRelationAdrress) {
		this.fRelationAdrress = fRelationAdrress;
	}
	public String getfNursingHomeID() {
		return fNursingHomeID;
	}
	public void setfNursingHomeID(String fNursingHomeID) {
		this.fNursingHomeID = fNursingHomeID;
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
	public String getfRelationDict() {
		return fRelationDict;
	}
	public void setfRelationDict(String fRelationDict) {
		this.fRelationDict = fRelationDict;
	}
	public String getfOldManName() {
		return fOldManName;
	}
	public void setfOldManName(String fOldManName) {
		this.fOldManName = fOldManName;
	}
	
	

}
