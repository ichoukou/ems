package com.channelsoft.ems.po;

/**
 * Created by liuxing on 2016/12/26.
 */
public class StorageGoodsManagementPo {
    private String id;
    private String name;
    private String type;
    private String standard;
    private String unit;
    private String lowStock;
    private String remark;
    private String typeID;
    private String number;
    private String Edate;
    private String Ldate;
    private String price;
    private String enterTime;
    private String status;
    private String typeStatus;

    public StorageGoodsManagementPo() {
        super();
    }

    public StorageGoodsManagementPo(String id, String name, String type, String standard, String unit, String lowStock, String remark, String typeID, String number, String edate, String ldate, String price, String enterTime, String status, String typeStatus) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.standard = standard;
        this.unit = unit;
        this.lowStock = lowStock;
        this.remark = remark;
        this.typeID = typeID;
        this.number = number;
        Edate = edate;
        Ldate = ldate;
        this.price = price;
        this.enterTime = enterTime;
        this.status = status;
        this.typeStatus = typeStatus;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLowStock() {
        return lowStock;
    }

    public void setLowStock(String lowStock) {
        this.lowStock = lowStock;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEdate() {
        return Edate;
    }

    public void setEdate(String edate) {
        Edate = edate;
    }

    public String getLdate() {
        return Ldate;
    }

    public void setLdate(String ldate) {
        Ldate = ldate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(String enterTime) {
        this.enterTime = enterTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(String typeStatus) {
        this.typeStatus = typeStatus;
    }

    @Override
    public String toString() {
        return "StorageGoodsManagementPo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", standard='" + standard + '\'' +
                ", unit='" + unit + '\'' +
                ", lowStock='" + lowStock + '\'' +
                ", remark='" + remark + '\'' +
                ", typeID='" + typeID + '\'' +
                ", number='" + number + '\'' +
                ", Edate='" + Edate + '\'' +
                ", Ldate='" + Ldate + '\'' +
                ", price='" + price + '\'' +
                ", enterTime='" + enterTime + '\'' +
                ", status='" + status + '\'' +
                ", typeStatus='" + typeStatus + '\'' +
                '}';
    }
}
