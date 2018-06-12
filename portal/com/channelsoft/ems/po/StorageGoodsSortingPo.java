package com.channelsoft.ems.po;

/**
 * Created by liuxing on 2016/12/23.
 */
public class StorageGoodsSortingPo {
    private String id;
    private String typeNumber;
    private String typeName;
    private String fatherID;
    private String remark;

    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public StorageGoodsSortingPo() {
        super();
    }

    public StorageGoodsSortingPo(String id, String typeNumber, String typeName, String fatherID, String remark) {
        this.id = id;
        this.typeNumber = typeNumber;
        this.typeName = typeName;
        this.fatherID = fatherID;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(String typeNumber) {
        this.typeNumber = typeNumber;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getFatherID() {
        return fatherID;
    }

    public void setFatherID(String fatherID) {
        this.fatherID = fatherID;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "StorageGoodsSortingPo{" +
                "id='" + id + '\'' +
                ", typeNumber='" + typeNumber + '\'' +
                ", typeName='" + typeName + '\'' +
                ", fatherID='" + fatherID + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
