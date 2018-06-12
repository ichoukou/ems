package com.channelsoft.ems.nursing.nursingPlan.po;

import java.util.Date;

import com.channelsoft.ems.common.BasePo;

/** 
 * 
 * 老人护理项目Po  
 * @author  lwj
 * @date 创建时间：2017年02月18日 下午14:31:41
 * @parameter  
 * @return  
 */
public class OldManServiceItemPo extends BasePo{
	private String id;
	
    private String fnursingHomeid;

    private String fauditorid;

    private Date faudittime;
    
    private String fnumber;
    
    private String fName;   //护理项目名称

    private String fserviceitemid;

    private Date fservicestartdate;

    private Date fserviceenddate;

    private String foldmanid;

    private String fnurselevelid;
    
    private Date fsecplanExcluddate;
    
    private String Fexecutecycle;
    
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
	
	private String fUsedStatus;   //老人项目中是否被老人引用
	
	private String fids;         //老人护理项目fid 拼接的字符串
	
	private String nowDate;        //当前时间，只是在生成计划做参数传递时 使用
	private Date fEndDate;       //服务项目的禁用日期，只为取出禁用日期做业务逻辑判断

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

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber == null ? null : fnumber.trim();
    }

    public String getFserviceitemid() {
        return fserviceitemid;
    }

    public void setFserviceitemid(String fserviceitemid) {
        this.fserviceitemid = fserviceitemid == null ? null : fserviceitemid.trim();
    }

    public Date getFservicestartdate() {
        return fservicestartdate;
    }

    public void setFservicestartdate(Date fservicestartdate) {
        this.fservicestartdate = fservicestartdate;
    }

    public Date getFserviceenddate() {
        return fserviceenddate;
    }

    public void setFserviceenddate(Date fserviceenddate) {
        this.fserviceenddate = fserviceenddate;
    }

    public String getFoldmanid() {
        return foldmanid;
    }

    public void setFoldmanid(String foldmanid) {
        this.foldmanid = foldmanid == null ? null : foldmanid.trim();
    }

    public String getFnurselevelid() {
        return fnurselevelid;
    }

    public void setFnurselevelid(String fnurselevelid) {
        this.fnurselevelid = fnurselevelid == null ? null : fnurselevelid.trim();
    }

	public String getFserviceLevels() {
		return fserviceLevels;
	}

	public void setFserviceLevels(String fserviceLevels) {
		this.fserviceLevels = fserviceLevels;
	}

	public String getfServiceGroupID() {
		return fServiceGroupID;
	}

	public void setfServiceGroupID(String fServiceGroupID) {
		this.fServiceGroupID = fServiceGroupID;
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

	public String getfUsedStatus() {
		return fUsedStatus;
	}

	public void setfUsedStatus(String fUsedStatus) {
		this.fUsedStatus = fUsedStatus;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFids() {
		return fids;
	}

	public void setFids(String fids) {
		this.fids = fids;
	}

	public Date getFsecplanExcluddate() {
		return fsecplanExcluddate;
	}

	public void setFsecplanExcluddate(Date fsecplanExcluddate) {
		this.fsecplanExcluddate = fsecplanExcluddate;
	}

	public String getFexecutecycle() {
		return Fexecutecycle;
	}

	public void setFexecutecycle(String fexecutecycle) {
		Fexecutecycle = fexecutecycle;
	}

	public String getNowDate() {
		return nowDate;
	}

	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}

	public Date getfEndDate() {
		return fEndDate;
	}

	public void setfEndDate(Date fEndDate) {
		this.fEndDate = fEndDate;
	}
}
