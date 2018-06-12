package com.channelsoft.ems.expenses.rpayment.po;

import java.math.BigDecimal;

public class Paymententry {
    private String fid;

    private String fparentid;

    private String fcostitem;

    private BigDecimal farpaymentamount;

    private Integer fsourcebillentryid;

    private String fsourcebillid;
    
    private String fitemid;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public String getFparentid() {
        return fparentid;
    }

    public void setFparentid(String fparentid) {
        this.fparentid = fparentid == null ? null : fparentid.trim();
    }

    public String getFcostitem() {
        return fcostitem;
    }

    public void setFcostitem(String fcostitem) {
        this.fcostitem = fcostitem == null ? null : fcostitem.trim();
    }

    public BigDecimal getFarpaymentamount() {
        return farpaymentamount;
    }

    public void setFarpaymentamount(BigDecimal farpaymentamount) {
        this.farpaymentamount = farpaymentamount;
    }

    public Integer getFsourcebillentryid() {
        return fsourcebillentryid;
    }

    public void setFsourcebillentryid(Integer fsourcebillentryid) {
        this.fsourcebillentryid = fsourcebillentryid;
    }

    public String getFsourcebillid() {
        return fsourcebillid;
    }

    public void setFsourcebillid(String fsourcebillid) {
        this.fsourcebillid = fsourcebillid;
    }

	public String getFitemid() {
		return fitemid;
	}

	public void setFitemid(String fitemid) {
		this.fitemid = fitemid;
	}
}