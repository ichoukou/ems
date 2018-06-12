package com.channelsoft.ems.nursing.nursingPlanExcute.po;

import java.util.Date;

import com.channelsoft.ems.common.PagePo;

public class PublicServiceExecutePo extends PagePo{
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

    private String fpublicserviceitemid;

    private String fserviceplanid;

    private Date fserviceexecutedate;

    private String fexecuteretun;

    private String froomid;
    
    private String fName;   //护理项目名称
    private String fServiceGroupID;
    
    private String fserviceLevels;
    
	private String fExecuteType;
	private String fExecutecycle;
	private String fExecuteQty;
	private String fExecutetime;
	private String fExcludtime;
    
	/**
	 * 执行周期单位 1-天，2-周 3-月-4-年
	 */
	private String fExecutecycleUnit;
    
	//查询页面展示用的
	private String serviceGroupName; //护理类型名称
	private String fserviceType;    // 护理类型-项目类型 
	
	 private Integer fexcludcount; //实际执行次数
	 private Integer fplancount;  //项目周期次数

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
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

    public String getFpublicserviceitemid() {
        return fpublicserviceitemid;
    }

    public void setFpublicserviceitemid(String fpublicserviceitemid) {
        this.fpublicserviceitemid = fpublicserviceitemid == null ? null : fpublicserviceitemid.trim();
    }

    public String getFserviceplanid() {
        return fserviceplanid;
    }

    public void setFserviceplanid(String fserviceplanid) {
        this.fserviceplanid = fserviceplanid == null ? null : fserviceplanid.trim();
    }

    public Date getFserviceexecutedate() {
        return fserviceexecutedate;
    }

    public void setFserviceexecutedate(Date fserviceexecutedate) {
        this.fserviceexecutedate = fserviceexecutedate;
    }

    public String getFexecuteretun() {
        return fexecuteretun;
    }

    public void setFexecuteretun(String fexecuteretun) {
        this.fexecuteretun = fexecuteretun == null ? null : fexecuteretun.trim();
    }

    public String getFroomid() {
        return froomid;
    }

    public void setFroomid(String froomid) {
        this.froomid = froomid == null ? null : froomid.trim();
    }

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfServiceGroupID() {
		return fServiceGroupID;
	}

	public void setfServiceGroupID(String fServiceGroupID) {
		this.fServiceGroupID = fServiceGroupID;
	}

	public String getFserviceLevels() {
		return fserviceLevels;
	}

	public void setFserviceLevels(String fserviceLevels) {
		this.fserviceLevels = fserviceLevels;
	}

	public String getfExecuteType() {
		return fExecuteType;
	}

	public void setfExecuteType(String fExecuteType) {
		this.fExecuteType = fExecuteType;
	}

	public String getfExecutecycle() {
		return fExecutecycle;
	}

	public void setfExecutecycle(String fExecutecycle) {
		this.fExecutecycle = fExecutecycle;
	}

	public String getfExecuteQty() {
		return fExecuteQty;
	}

	public void setfExecuteQty(String fExecuteQty) {
		this.fExecuteQty = fExecuteQty;
	}

	public String getfExecutetime() {
		return fExecutetime;
	}

	public void setfExecutetime(String fExecutetime) {
		this.fExecutetime = fExecutetime;
	}

	public String getfExcludtime() {
		return fExcludtime;
	}

	public void setfExcludtime(String fExcludtime) {
		this.fExcludtime = fExcludtime;
	}

	public String getfExecutecycleUnit() {
		return fExecutecycleUnit;
	}

	public void setfExecutecycleUnit(String fExecutecycleUnit) {
		this.fExecutecycleUnit = fExecutecycleUnit;
	}

	public String getServiceGroupName() {
		return serviceGroupName;
	}

	public void setServiceGroupName(String serviceGroupName) {
		this.serviceGroupName = serviceGroupName;
	}

	public String getFserviceType() {
		return fserviceType;
	}

	public void setFserviceType(String fserviceType) {
		this.fserviceType = fserviceType;
	}

	public Integer getFexcludcount() {
		return fexcludcount;
	}

	public void setFexcludcount(Integer fexcludcount) {
		this.fexcludcount = fexcludcount;
	}

	public Integer getFplancount() {
		return fplancount;
	}

	public void setFplancount(Integer fplancount) {
		this.fplancount = fplancount;
	}
}