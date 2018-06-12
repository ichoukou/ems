package com.channelsoft.ems.po;

/**
 * Created by wangjs on 2017/3/25.
 */
public class OldManServiceplanPo {

    private String fID;
    private String fstatus;
    private String foldManID;
    private String fplancount;
    private String fexcludcount;

    public String getfID() {
        return fID;
    }

    public void setfID(String fID) {
        this.fID = fID;
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus;
    }

    public String getFoldManID() {
        return foldManID;
    }

    public void setFoldManID(String foldManID) {
        this.foldManID = foldManID;
    }

    public String getFplancount() {
        return fplancount;
    }

    public void setFplancount(String fplancount) {
        this.fplancount = fplancount;
    }

    public String getFexcludcount() {
        return fexcludcount;
    }

    public void setFexcludcount(String fexcludcount) {
        this.fexcludcount = fexcludcount;
    }

    public OldManServiceplanPo() {
    }

    public OldManServiceplanPo(String fID, String fstatus, String foldManID, String fplancount, String fexcludcount) {
        this.fID = fID;
        this.fstatus = fstatus;
        this.foldManID = foldManID;
        this.fplancount = fplancount;
        this.fexcludcount = fexcludcount;
    }

    @Override
    public String toString() {
        return "OldManServiceplanPo{" +
                "fID='" + fID + '\'' +
                ", fstatus='" + fstatus + '\'' +
                ", foldManID='" + foldManID + '\'' +
                ", fplancount='" + fplancount + '\'' +
                ", fexcludcount='" + fexcludcount + '\'' +
                '}';
    }
}
