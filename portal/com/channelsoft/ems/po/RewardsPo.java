package com.channelsoft.ems.po;

import java.io.Serializable;

/**
 * Created by 张鑫 on 2016/12/15.
 */
public class RewardsPo implements Serializable {
    private String fID;
    private String fNumber;
    private String fNursingHomeID;
    private String fStaffID;
    private String fStaffName;
    private String fRewardDate;
    private String fRewardType;
    private String fRewardReason;
    private String fRewardMoney;
    private String fExplain;
    private String fAuditorID;
    private String fAuditTime;
    private String fCreatorID;
    private String fCreatorName;
    private String fCreateTime;

    @Override
    public String toString() {
        return "RewardsPo{" +
                "fID='" + fID + '\'' +
                ", fNumber='" + fNumber + '\'' +
                ", fNursingHomeID='" + fNursingHomeID + '\'' +
                ", fStaffID='" + fStaffID + '\'' +
                ", fStaffName='" + fStaffName + '\'' +
                ", fRewardDate='" + fRewardDate + '\'' +
                ", fRewardType='" + fRewardType + '\'' +
                ", fRewardReason='" + fRewardReason + '\'' +
                ", fRewardMoney='" + fRewardMoney + '\'' +
                ", fExplain='" + fExplain + '\'' +
                ", fAuditorID='" + fAuditorID + '\'' +
                ", fAuditTime='" + fAuditTime + '\'' +
                ", fCreatorID='" + fCreatorID + '\'' +
                ", fCreatorName='" + fCreatorName + '\'' +
                ", fCreateTime='" + fCreateTime + '\'' +
                '}';
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

    public String getfNursingHomeID() {
        return fNursingHomeID;
    }

    public void setfNursingHomeID(String fNursingHomeID) {
        this.fNursingHomeID = fNursingHomeID;
    }

    public String getfStaffID() {
        return fStaffID;
    }

    public void setfStaffID(String fStaffID) {
        this.fStaffID = fStaffID;
    }

    public String getfStaffName() {
        return fStaffName;
    }

    public void setfStaffName(String fStaffName) {
        this.fStaffName = fStaffName;
    }

    public String getfRewardDate() {
        return fRewardDate;
    }

    public void setfRewardDate(String fRewardDate) {
        this.fRewardDate = fRewardDate;
    }

    public String getfRewardType() {
        return fRewardType;
    }

    public void setfRewardType(String fRewardType) {
        this.fRewardType = fRewardType;
    }

    public String getfRewardReason() {
        return fRewardReason;
    }

    public void setfRewardReason(String fRewardReason) {
        this.fRewardReason = fRewardReason;
    }

    public String getfRewardMoney() {
        return fRewardMoney;
    }

    public void setfRewardMoney(String fRewardMoney) {
        this.fRewardMoney = fRewardMoney;
    }

    public String getfExplain() {
        return fExplain;
    }

    public void setfExplain(String fExplain) {
        this.fExplain = fExplain;
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

    public String getfCreatorName() {
        return fCreatorName;
    }

    public void setfCreatorName(String fCreatorName) {
        this.fCreatorName = fCreatorName;
    }

    public String getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(String fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public RewardsPo() {
    }

    public RewardsPo(String fID, String fNumber, String fNursingHomeID, String fStaffID, String fStaffName, String fRewardDate, String fRewardType, String fRewardReason, String fRewardMoney, String fExplain, String fAuditorID, String fAuditTime, String fCreatorID, String fCreatorName, String fCreateTime) {
        this.fID = fID;
        this.fNumber = fNumber;
        this.fNursingHomeID = fNursingHomeID;
        this.fStaffID = fStaffID;
        this.fStaffName = fStaffName;
        this.fRewardDate = fRewardDate;
        this.fRewardType = fRewardType;
        this.fRewardReason = fRewardReason;
        this.fRewardMoney = fRewardMoney;
        this.fExplain = fExplain;
        this.fAuditorID = fAuditorID;
        this.fAuditTime = fAuditTime;
        this.fCreatorID = fCreatorID;
        this.fCreatorName = fCreatorName;
        this.fCreateTime = fCreateTime;
    }
}
