package com.channelsoft.ems.po;

import com.channelsoft.ems.common.Constants;

/**
 * Created by wuhl 2017/2/14
 */
public class FNursingPo {

    private String fID;
    private String fNursingName;
    private String fLeader;

    private String fLeaderPhone;
    private String fDate;
    private String fNursingAdd;
    private String fStatus;
    private String fFreeDays;
    private String fChargeModeID;
    private String fChargeModeName;

    private String fFirstFee;
    private String fLastFee;
    private String fBedFree;
    private String fServiceFree;
    private String fMealFree;

    private String fCreatorID;
    private String fCreateTime;
    private String fRemarks;

    @Override
    public String toString() {
        return "FNursingPo{" +
                "fID='" + fID + '\'' +
                ", fNursingName='" + fNursingName + '\'' +
                ", fLeader='" + fLeader + '\'' +
                ", fLeaderPhone='" + fLeaderPhone + '\'' +
                ", fDate='" + fDate + '\'' +
                ", fNursingAdd='" + fNursingAdd + '\'' +
                ", fStatus='" + fStatus + '\'' +
                ", fFreeDays='" + fFreeDays + '\'' +
                ", fChargeModeID='" + fChargeModeID + '\'' +
                ", fChargeModeName='" + fChargeModeName + '\'' +
                ", fFirstFee='" + fFirstFee + '\'' +
                ", fLastFee='" + fLastFee + '\'' +
                ", fBedFree='" + fBedFree + '\'' +
                ", fServiceFree='" + fServiceFree + '\'' +
                ", fMealFree='" + fMealFree + '\'' +
                ", fCreatorID='" + fCreatorID + '\'' +
                ", fCreateTime='" + fCreateTime + '\'' +
                ", fRemarks='" + fRemarks + '\'' +
                '}';
    }

    public void setfID(String fID) {
        this.fID = fID;
    }

    public void setfNursingName(String fNursingName) {
        this.fNursingName = fNursingName;
    }

    public void setfLeader(String fLeader) {
        this.fLeader = fLeader;
    }

    public void setfLeaderPhone(String fLeaderPhone) {
        this.fLeaderPhone = fLeaderPhone;
    }

    public void setfDate(String fDate) {
        this.fDate = fDate;
    }

    public void setfNursingAdd(String fNursingAdd) {
        this.fNursingAdd = fNursingAdd;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus;
    }

    public void setfFreeDays(String fFreeDays) {
        this.fFreeDays = fFreeDays;
    }

    public void setfChargeModeID(String fChargeModeID) {
        this.fChargeModeID = fChargeModeID;
    }

    public void setfChargeModeName(String fChargeModeName) {
        this.fChargeModeName = fChargeModeName;
    }

    public void setfFirstFee(String fFirstFee) {
        this.fFirstFee = fFirstFee;
    }

    public void setfLastFee(String fLastFee) {
        this.fLastFee = fLastFee;
    }

    public void setfBedFree(String fBedFree) {
        this.fBedFree = fBedFree;
    }

    public void setfServiceFree(String fServiceFree) {
        this.fServiceFree = fServiceFree;
    }

    public void setfMealFree(String fMealFree) {
        this.fMealFree = fMealFree;
    }

    public void setfCreatorID(String fCreatorID) {
        this.fCreatorID = fCreatorID;
    }

    public void setfCreateTime(String fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public void setfRemarks(String fRemarks) {
        this.fRemarks = fRemarks;
    }

    public String getfID() {
        return fID;
    }

    public String getfNursingName() {
        return fNursingName;
    }

    public String getfLeader() {
        return fLeader;
    }

    public String getfLeaderPhone() {
        return fLeaderPhone;
    }

    public String getfDate() {
        return fDate;
    }

    public String getfNursingAdd() {
        return fNursingAdd;
    }

    public String getfStatus() {
        return fStatus;
    }

    public String getfFreeDays() {
        return fFreeDays;
    }

    public String getfChargeModeID() {
        return fChargeModeID;
    }

    public String getfChargeModeName() {
        return fChargeModeName;
    }

    public String getfFirstFee() {
        return fFirstFee;
    }

    public String getfLastFee() {
        return fLastFee;
    }

    public String getfBedFree() {
        return fBedFree;
    }

    public String getfServiceFree() {
        return fServiceFree;
    }

    public String getfMealFree() {
        return fMealFree;
    }

    public String getfCreatorID() {
        return fCreatorID;
    }

    public String getfCreateTime() {
        return fCreateTime;
    }

    public String getfRemarks() {
        return fRemarks;
    }

    public FNursingPo(){

    }
    public FNursingPo(String fID, String fNursingName, String fLeader, String fLeaderPhone, String fDate, String fNursingAdd, String fStatus, String fFreeDays, String fChargeModeID, String fChargeModeName, String fFirstFee, String fLastFee, String fBedFree, String fServiceFree, String fMealFree, String fCreatorID, String fCreateTime, String fRemarks) {
        this.fID = fID;
        this.fNursingName = fNursingName;
        this.fLeader = fLeader;
        this.fLeaderPhone = fLeaderPhone;
        this.fDate = fDate;
        this.fNursingAdd = fNursingAdd;
        this.fStatus = fStatus;
        this.fFreeDays = fFreeDays;
        this.fChargeModeID = fChargeModeID;
        this.fChargeModeName = fChargeModeName;
        this.fFirstFee = fFirstFee;
        this.fLastFee = fLastFee;
        this.fBedFree = fBedFree;
        this.fServiceFree = fServiceFree;
        this.fMealFree = fMealFree;
        this.fCreatorID = fCreatorID;
        this.fCreateTime = fCreateTime;
        this.fRemarks = fRemarks;
    }
}
