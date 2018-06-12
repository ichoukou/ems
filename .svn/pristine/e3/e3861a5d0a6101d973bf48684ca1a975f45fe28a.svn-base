package com.channelsoft.ems.po;

import com.channelsoft.ems.common.Constants;
/**
 * Created by wangjs on 2016/12/4.
 */
public class TBuildingPo {
    private String fID;
    private String fNursingHomeID;
    private String fBuildingNumber;
    private String fBuildingName;
    private String fAdministratorsID;
    private String fStatus;
    private String fStatusStr;

    private String fExplain;
    private String fRemarks;

    public String getfStatusStr() {
        return Constants.getEnum(fStatus).desc;
    }

    public void setfStatusStr(String fStatusStr) {
        this.fStatusStr = fStatusStr;
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

    public String getfBuildingNumber() {
        return fBuildingNumber;
    }

    public void setfBuildingNumber(String fBuildingNumber) {
        this.fBuildingNumber = fBuildingNumber;
    }

    public String getfBuildingName() {
        return fBuildingName;
    }

    public void setfBuildingName(String fBuildingName) {
        this.fBuildingName = fBuildingName;
    }

    public String getfAdministratorsID() {
        return fAdministratorsID;
    }

    public void setfAdministratorsID(String fAdministratorsID) {
        this.fAdministratorsID = fAdministratorsID;
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

    public TBuildingPo(){
        super();
    }
    public TBuildingPo(String fID,String fNursingHomeID,String fBuildingNumber,
            String fBuildingName, String fAdministratorsID, String fStatus, String fExplain,
            String fRemarks){
        super();
        this.fID=fID;
        this.fNursingHomeID=fNursingHomeID;
        this.fBuildingNumber=fBuildingNumber;
        this.fBuildingName=fBuildingName;
        this.fAdministratorsID=fBuildingName;
        this.fStatus=fStatus;
        this.fExplain=fExplain;
        this.fRemarks=fRemarks;
    }

    @Override
    public String toString() {
        return "[fID="+fID+
                "fNursingHomeID="+fNursingHomeID+
                "fBuildingNumber="+fBuildingNumber+
                "fBuildingName="+fBuildingName+
                "fStatus="+fStatus+
                "fExplain="+fExplain+
                "fRemarks="+fRemarks+
                "]";
    }
}
