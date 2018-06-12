package com.channelsoft.ems.po;
/** 
 * 
 * 权限分配
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午19:13:41 
 * @parameter  
 * @return  
 */
public class MenuPo {
 
	private String smenuid;
	private String sparentid;
	private String sname;
	private String surl;
	private String soname;
	
	public String getSoname() {
		return soname;
	}
	public void setSoname(String soname) {
		this.soname = soname;
	}
	public String getSmenuid() {
		return smenuid;
	}
	public void setSmenuid(String smenuid) {
		this.smenuid = smenuid;
	}
	public String getSparentid() {
		return sparentid;
	}
	public void setSparentid(String sparentid) {
		this.sparentid = sparentid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSurl() {
		return surl;
	}
	public void setSurl(String surl) {
		this.surl = surl;
	}
	public MenuPo(){
		
	}
	public MenuPo(String smenuid, String sparentid, String sname, String surl,String soname) {
		super();
		this.smenuid = smenuid;
		this.sparentid = sparentid;
		this.sname = sname;
		this.surl = surl;
		this.soname=soname;
	}
	
	
	@Override
	public String toString() {
		return " [smenuid=" + smenuid +  ",sparentid="+sparentid+",sname="+sname+", surl="
				+ surl +",soname="+soname+"]";
	}
}
