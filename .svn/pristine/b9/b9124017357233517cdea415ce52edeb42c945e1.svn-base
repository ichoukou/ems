package com.channelsoft.ems.po;

import com.channelsoft.ems.common.Constants;

public class DataDictionaryPo {

	private String id;
	private String name;
	private String value;
	private String status;
	private String statusStr;

	public String getStatusStr() {
		return Constants.getEnum(status).desc;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public DataDictionaryPo(String id, String name, String value, String status) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.status = status;
	}

	public DataDictionaryPo() {
		super();
	}

	@Override
	public String toString() {
		return "DataDictionaryPo{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", value='" + value + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
