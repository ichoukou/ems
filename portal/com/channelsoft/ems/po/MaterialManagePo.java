package com.channelsoft.ems.po;

import java.io.Serializable;

/**
 * Created by zhangxin on 2017/1/5.
 */
public class MaterialManagePo implements Serializable {
    private String fID;
    private String name;
    private String standard;
    private String unit;
    private String lowStock;
    private String getCount;
    private String purchasePrice;
    private String fCategoryID;
    private String materialType;

    public MaterialManagePo() {
    }

    public MaterialManagePo(String fID, String name, String standard, String unit, String lowStock, String getCount, String purchasePrice, String fCategoryID, String materialType) {
        this.fID = fID;
        this.name = name;
        this.standard = standard;
        this.unit = unit;
        this.lowStock = lowStock;
        this.getCount = getCount;
        this.purchasePrice = purchasePrice;
        this.fCategoryID = fCategoryID;
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return "MaterialManagePo{" +
                "fID='" + fID + '\'' +
                ", name='" + name + '\'' +
                ", standard='" + standard + '\'' +
                ", unit='" + unit + '\'' +
                ", lowStock='" + lowStock + '\'' +
                ", getCount='" + getCount + '\'' +
                ", purchasePrice='" + purchasePrice + '\'' +
                ", fCategoryID='" + fCategoryID + '\'' +
                ", materialType='" + materialType + '\'' +
                '}';
    }

    public String getfID() {
        return fID;
    }

    public void setfID(String fID) {
        this.fID = fID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getGetCount() {
        return getCount;
    }

    public void setGetCount(String getCount) {
        this.getCount = getCount;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getfCategoryID() {
        return fCategoryID;
    }

    public void setfCategoryID(String fCategoryID) {
        this.fCategoryID = fCategoryID;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
}