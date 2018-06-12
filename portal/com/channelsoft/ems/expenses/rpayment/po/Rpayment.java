package com.channelsoft.ems.expenses.rpayment.po;

import java.math.BigDecimal;
import java.util.Date;

import com.channelsoft.ems.common.PagePo;

public class Rpayment extends PagePo{
    private String fid;

    private String fnursingHomeid;

    private String fauditorid;

    private Date faudittime;

    private String fcreatorid;

    private Date fcreatetime;

    private String fmodifierid;

    private Date fmodificationtime;

    private String fremarks;

    private String fnumber;

    private String fstatus;

    private String foldmanid;

    private Date fpaymentdate;

    private Integer fperiod;

    private Integer fmoun;
    
    private String fcostitem;
    
    private BigDecimal fArPaymentAmount;
    
    private BigDecimal FPayMentAmount;
    
    private String fbiztype;
    
    private String fparentid;
    
    private String foldmanName;
    
    private String foldmanNumber;
    
	private String foldmanStatus;
	
    private String foldmanRoom;
    
    private String foldmanType;
    
    private String foldmanSex;
    
    private String period;
    
    private Date fcheckinTime;
    
    private String paymentType;
    
    //查询条件字段 start
    private String roomName;	
    private String nursingLevel;
    private String chargeStandardId;
    private String startDate;      //老人入住时间
    private String endDate;
    private String startDateOut;  //老人退住时间
    private String endDateOut;
    //查询条件字段 end
    
    public Date getFcheckinTime() {
		return fcheckinTime;
	}

	public void setFcheckinTime(Date fcheckinTime) {
		this.fcheckinTime = fcheckinTime;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getFoldmanName() {
		return foldmanName;
	}

	public void setFoldmanName(String foldmanName) {
		this.foldmanName = foldmanName;
	}

	public String getFoldmanNumber() {
		return foldmanNumber;
	}

	public void setFoldmanNumber(String foldmanNumber) {
		this.foldmanNumber = foldmanNumber;
	}

	public String getFoldmanStatus() {
		return foldmanStatus;
	}

	public void setFoldmanStatus(String foldmanStatus) {
		this.foldmanStatus = foldmanStatus;
	}

	public String getFoldmanRoom() {
		return foldmanRoom;
	}

	public void setFoldmanRoom(String foldmanRoom) {
		this.foldmanRoom = foldmanRoom;
	}



    public String getFcostitem() {
		return fcostitem;
	}

	public void setFcostitem(String fcostitem) {
		this.fcostitem = fcostitem;
	}

	public BigDecimal getfArPaymentAmount() {
		return fArPaymentAmount;
	}

	public void setfArPaymentAmount(BigDecimal fArPaymentAmount) {
		this.fArPaymentAmount = fArPaymentAmount;
	}

	public BigDecimal getFPayMentAmount() {
		return FPayMentAmount;
	}

	public void setFPayMentAmount(BigDecimal fPayMentAmount) {
		FPayMentAmount = fPayMentAmount;
	}

	public String getFparentid() {
		return fparentid;
	}

	public void setFparentid(String fparentid) {
		this.fparentid = fparentid;
	}

	public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFnursingHomeid() {
        return fnursingHomeid;
    }

    public void setFnursingHomeid(String fnursingHomeid) {
        this.fnursingHomeid = fnursingHomeid == null ? null : fnursingHomeid.trim();
    }

    public String getFauditorid() {
        return fauditorid;
    }

    public void setFauditorid(String fauditorid) {
        this.fauditorid = fauditorid == null ? null : fauditorid.trim();
    }

    public Date getFaudittime() {
        return faudittime;
    }

    public void setFaudittime(Date faudittime) {
        this.faudittime = faudittime;
    }

    public String getFcreatorid() {
        return fcreatorid;
    }

    public void setFcreatorid(String fcreatorid) {
        this.fcreatorid = fcreatorid == null ? null : fcreatorid.trim();
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public String getFmodifierid() {
        return fmodifierid;
    }

    public void setFmodifierid(String fmodifierid) {
        this.fmodifierid = fmodifierid == null ? null : fmodifierid.trim();
    }

    public Date getFmodificationtime() {
        return fmodificationtime;
    }

    public void setFmodificationtime(Date fmodificationtime) {
        this.fmodificationtime = fmodificationtime;
    }

    public String getFremarks() {
        return fremarks;
    }

    public void setFremarks(String fremarks) {
        this.fremarks = fremarks == null ? null : fremarks.trim();
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus == null ? null : fstatus.trim();
    }

    public String getFoldmanid() {
        return foldmanid;
    }

    public void setFoldmanid(String foldmanid) {
        this.foldmanid = foldmanid == null ? null : foldmanid.trim();
    }

    public Date getFpaymentdate() {
        return fpaymentdate;
    }

    public void setFpaymentdate(Date fpaymentdate) {
        this.fpaymentdate = fpaymentdate;
    }

    public Integer getFperiod() {
        return fperiod;
    }

    public void setFperiod(Integer fperiod) {
        this.fperiod = fperiod;
    }

    public Integer getFmoun() {
        return fmoun;
    }

    public void setFmoun(Integer fmoun) {
        this.fmoun = fmoun;
    }

	public String getFoldmanType() {
		return foldmanType;
	}

	public void setFoldmanType(String foldmanType) {
		this.foldmanType = foldmanType;
	}

	public String getFoldmanSex() {
		return foldmanSex;
	}

	public void setFoldmanSex(String foldmanSex) {
		this.foldmanSex = foldmanSex;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getFbiztype() {
		return fbiztype;
	}

	public void setFbiztype(String fbiztype) {
		this.fbiztype = fbiztype;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getNursingLevel() {
		return nursingLevel;
	}

	public void setNursingLevel(String nursingLevel) {
		this.nursingLevel = nursingLevel;
	}

	public String getChargeStandardId() {
		return chargeStandardId;
	}

	public void setChargeStandardId(String chargeStandardId) {
		this.chargeStandardId = chargeStandardId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDateOut() {
		return startDateOut;
	}

	public void setStartDateOut(String startDateOut) {
		this.startDateOut = startDateOut;
	}

	public String getEndDateOut() {
		return endDateOut;
	}

	public void setEndDateOut(String endDateOut) {
		this.endDateOut = endDateOut;
	}
}