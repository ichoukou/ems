package com.channelsoft.ems.po;

import java.util.List;

/**
 * Created by wangjs on 2016/12/4.
 */
public class TRoomPo {
    private String fID;
    private String fNursingHomeID;
    private String fBuildingID;
    private String fBuildingName;

    private String fFLoorID;
    private String fFLoorName;

    private String fRoomNumber;
    private String fRoomName;
    private String fRoomType;
    private String fRoomOrientation;
    private String fRoomPrice;
    private String fBedCount;
    private String fManNumber;
    private String fStatus;
    private String fExplain;
    private String fRemarks;

    private String fAdministratorsID;


    private String fBedStatusA;
    private String fBedStatusB;
    private String fBedStatusC;
    private String fBedStatusD;
    private String fBedStatusE;
    private String fBedStatusF;


    public String getfBedStatusA() {
        return fBedStatusA;
    }

    public void setfBedStatusA(String fBedStatusA) {
        this.fBedStatusA = fBedStatusA;
    }

    public String getfBedStatusB() {
        return fBedStatusB;
    }

    public void setfBedStatusB(String fBedStatusB) {
        this.fBedStatusB = fBedStatusB;
    }

    public String getfBedStatusC() {
        return fBedStatusC;
    }

    public void setfBedStatusC(String fBedStatusC) {
        this.fBedStatusC = fBedStatusC;
    }

    public String getfBedStatusD() {
        return fBedStatusD;
    }

    public void setfBedStatusD(String fBedStatusD) {
        this.fBedStatusD = fBedStatusD;
    }

    public String getfBedStatusE() {
        return fBedStatusE;
    }

    public void setfBedStatusE(String fBedStatusE) {
        this.fBedStatusE = fBedStatusE;
    }

    public String getfBedStatusF() {
        return fBedStatusF;
    }

    public void setfBedStatusF(String fBedStatusF) {
        this.fBedStatusF = fBedStatusF;
    }

    private List<TBedPo> bedPo;

    public List<TBedPo> getBedPo() {
        return bedPo;
    }

    public void setBedPo(List<TBedPo> bedPo) {
        this.bedPo = bedPo;
    }

    public String getfID() {
        return fID;
    }

    public void setfID(String fID) {
        this.fID = fID;
    }

    public String getfNursingHomeID() {
        return fNursingHomeID;
    }

    public void setfNursingHomeID(String fNursingHomeID) {
        this.fNursingHomeID = fNursingHomeID;
    }

    public String getfBuildingID() {
        return fBuildingID;
    }

    public void setfBuildingID(String fBuildingID) {
        this.fBuildingID = fBuildingID;
    }

    public String getfBuildingName() {
        return fBuildingName;
    }

    public void setfBuildingName(String fBuildingName) {
        this.fBuildingName = fBuildingName;
    }

    public String getfFLoorID() {
        return fFLoorID;
    }

    public void setfFLoorID(String fFLoorID) {
        this.fFLoorID = fFLoorID;
    }

    public String getfFLoorName() {
        return fFLoorName;
    }

    public void setfFLoorName(String fFLoorName) {
        this.fFLoorName = fFLoorName;
    }

    public String getfRoomNumber() {
        return fRoomNumber;
    }

    public void setfRoomNumber(String fRoomNumber) {
        this.fRoomNumber = fRoomNumber;
    }

    public String getfRoomName() {
        return fRoomName;
    }

    public void setfRoomName(String fRoomName) {
        this.fRoomName = fRoomName;
    }

    public String getfRoomType() {
        return fRoomType;
    }

    public void setfRoomType(String fRoomType) {
        this.fRoomType = fRoomType;
    }

    public String getfRoomOrientation() {
        return fRoomOrientation;
    }

    public void setfRoomOrientation(String fRoomOrientation) {
        this.fRoomOrientation = fRoomOrientation;
    }

    public String getfRoomPrice() {
        return fRoomPrice;
    }

    public void setfRoomPrice(String fRoomPrice) {
        this.fRoomPrice = fRoomPrice;
    }

    public String getfBedCount() {
        return fBedCount;
    }

    public void setfBedCount(String fBedCount) {
        this.fBedCount = fBedCount;
    }

    public String getfManNumber() {
        return fManNumber;
    }

    public void setfManNumber(String fManNumber) {
        this.fManNumber = fManNumber;
    }

    public String getfStatus() {
        return fStatus;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus;
    }

    public String getfExplain() {
        return fExplain;
    }

    public void setfExplain(String fExplain) {
        this.fExplain = fExplain;
    }

    public String getfRemarks() {
        return fRemarks;
    }

    public void setfRemarks(String fRemarks) {
        this.fRemarks = fRemarks;
    }

    public String getfAdministratorsID() {
        return fAdministratorsID;
    }

    public void setfAdministratorsID(String fAdministratorsID) {
        this.fAdministratorsID = fAdministratorsID;
    }

    public TRoomPo() {
    }

    public TRoomPo(String fID, String fNursingHomeID, String fBuildingID, String fBuildingName, String fFLoorID, String fFLoorName, String fRoomNumber, String fRoomName, String fRoomType, String fRoomOrientation, String fRoomPrice, String fBedCount, String fManNumber, String fStatus, String fExplain, String fRemarks, String fAdministratorsID, List<TBedPo> bedPo) {
        this.fID = fID;
        this.fNursingHomeID = fNursingHomeID;
        this.fBuildingID = fBuildingID;
        this.fBuildingName = fBuildingName;
        this.fFLoorID = fFLoorID;
        this.fFLoorName = fFLoorName;
        this.fRoomNumber = fRoomNumber;
        this.fRoomName = fRoomName;
        this.fRoomType = fRoomType;
        this.fRoomOrientation = fRoomOrientation;
        this.fRoomPrice = fRoomPrice;
        this.fBedCount = fBedCount;
        this.fManNumber = fManNumber;
        this.fStatus = fStatus;
        this.fExplain = fExplain;
        this.fRemarks = fRemarks;
        this.fAdministratorsID = fAdministratorsID;
        this.bedPo = bedPo;
    }

    @Override
    public String toString() {
        return "TRoomPo{" +
                "fID='" + fID + '\'' +
                ", fNursingHomeID='" + fNursingHomeID + '\'' +
                ", fBuildingID='" + fBuildingID + '\'' +
                ", fBuildingName='" + fBuildingName + '\'' +
                ", fFLoorID='" + fFLoorID + '\'' +
                ", fFLoorName='" + fFLoorName + '\'' +
                ", fRoomNumber='" + fRoomNumber + '\'' +
                ", fRoomName='" + fRoomName + '\'' +
                ", fRoomType='" + fRoomType + '\'' +
                ", fRoomOrientation='" + fRoomOrientation + '\'' +
                ", fRoomPrice='" + fRoomPrice + '\'' +
                ", fBedCount='" + fBedCount + '\'' +
                ", fManNumber='" + fManNumber + '\'' +
                ", fStatus='" + fStatus + '\'' +
                ", fExplain='" + fExplain + '\'' +
                ", fRemarks='" + fRemarks + '\'' +
                ", fAdministratorsID='" + fAdministratorsID + '\'' +
                ", bedPo=" + bedPo +
                '}';
    }
}
