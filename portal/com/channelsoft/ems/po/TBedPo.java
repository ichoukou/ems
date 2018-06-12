package com.channelsoft.ems.po;

/**
 * Created by wangjs on 2016/12/9.
 */
public class TBedPo {

    private String fID;
    private String fBedNumber;
    private String fRoomID;
    private String fRoomName;
    private String fBedPrice;
    private String fPrice;
    private String fStatus;
    private String fAdministratorsID;
    private String fExplain;
    private String fRemarks;

    public String getfID() {
        return fID;
    }

    public void setfID(String fID) {
        this.fID = fID;
    }

    public String getfBedNumber() {
        return fBedNumber;
    }

    public void setfBedNumber(String fBedNumber) {
        this.fBedNumber = fBedNumber;
    }

    public String getfRoomID() {
        return fRoomID;
    }

    public void setfRoomID(String fRoomID) {
        this.fRoomID = fRoomID;
    }

    public String getfRoomName() {
        return fRoomName;
    }

    public void setfRoomName(String fRoomName) {
        this.fRoomName = fRoomName;
    }

    public String getfBedPrice() {
        return fBedPrice;
    }

    public void setfBedPrice(String fBedPrice) {
        this.fBedPrice = fBedPrice;
    }

    public String getfPrice() {
        return fPrice;
    }

    public void setfPrice(String fPrice) {
        this.fPrice = fPrice;
    }

    public String getfStatus() {
        return fStatus;
    }

    public void setfStatus(String fStatus) {
        this.fStatus = fStatus;
    }

    public String getfAdministratorsID() {
        return fAdministratorsID;
    }

    public void setfAdministratorsID(String fAdministratorsID) {
        this.fAdministratorsID = fAdministratorsID;
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

    public TBedPo() {
    }

    public TBedPo(String fID, String fBedNumber, String fRoomID, String fRoomName, String fBedPrice,
                  String fPrice, String fStatus, String fAdministratorsID, String fExplain, String fRemarks) {
        this.fID = fID;
        this.fBedNumber = fBedNumber;
        this.fRoomID = fRoomID;
        this.fRoomName = fRoomName;
        this.fBedPrice = fBedPrice;
        this.fPrice = fPrice;
        this.fStatus = fStatus;
        this.fAdministratorsID = fAdministratorsID;
        this.fExplain = fExplain;
        this.fRemarks = fRemarks;
    }

    @Override
    public String toString() {
        return "TBedPo{" +
                "fID='" + fID + '\'' +
                ", fBedNumber='" + fBedNumber + '\'' +
                ", fRoomID='" + fRoomID + '\'' +
                ", fRoomName='" + fRoomName + '\'' +
                ", fBedPrice='" + fBedPrice + '\'' +
                ", fPrice='" + fPrice + '\'' +
                ", fStatus='" + fStatus + '\'' +
                ", fAdministratorsID='" + fAdministratorsID + '\'' +
                ", fExplain='" + fExplain + '\'' +
                ", fRemarks='" + fRemarks + '\'' +
                '}';
    }
}
