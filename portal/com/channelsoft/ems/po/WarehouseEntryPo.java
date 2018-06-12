package com.channelsoft.ems.po;

/**
 * Created by zhangxin on 2017/1/4.
 */
public class WarehouseEntryPo {
    private String fatherid;//主表id
    private String fid;//入库物品id
    private String fNumber;

    private String  start;//开始时间
    private String  finish;//完成时间

    private String fNursingHomeID;
    private String fNursingHomeName;
    private String fPurchaseDate;
    private String fTel;
    private String fSupplyMome;
    private String fPaymentMode;
    private String fReceivingPlace;
    private String fAuditorID;
    private String fAuditTime;
    private String fCreatorID;
    private String fCreateTime;
    private String fModiFierID;
    private String fModiFicationTime;
    private String fRemarks;

    private String pID;//fID
    private String fPurchaseManID;
    private String fPurchaseManName;

    private String fStoremanID;
    private String fStoremanName;//保管员

    private String fSupplierID;
    private String fSupplierName;

    private String fMaterialID;//物资id
    private String fMaterialName;

    private String fStorageID;//仓库id
    private String fStorageName;

    private String fAmount;//数量
    private String fPrice;//价格
    private String fSum;//金额

    private String fStandard;//规格

    @Override
    public String toString() {
        return "WarehouseEntryPo{" +
                "fatherid='" + fatherid + '\'' +
                ", fid='" + fid + '\'' +
                ", fNumber='" + fNumber + '\'' +
                ", start='" + start + '\'' +
                ", finish='" + finish + '\'' +
                ", fNursingHomeID='" + fNursingHomeID + '\'' +
                ", fNursingHomeName='" + fNursingHomeName + '\'' +
                ", fPurchaseDate='" + fPurchaseDate + '\'' +
                ", fTel='" + fTel + '\'' +
                ", fSupplyMome='" + fSupplyMome + '\'' +
                ", fPaymentMode='" + fPaymentMode + '\'' +
                ", fReceivingPlace='" + fReceivingPlace + '\'' +
                ", fAuditorID='" + fAuditorID + '\'' +
                ", fAuditTime='" + fAuditTime + '\'' +
                ", fCreatorID='" + fCreatorID + '\'' +
                ", fCreateTime='" + fCreateTime + '\'' +
                ", fModiFierID='" + fModiFierID + '\'' +
                ", fModiFicationTime='" + fModiFicationTime + '\'' +
                ", fRemarks='" + fRemarks + '\'' +
                ", pID='" + pID + '\'' +
                ", fPurchaseManID='" + fPurchaseManID + '\'' +
                ", fPurchaseManName='" + fPurchaseManName + '\'' +
                ", fStoremanID='" + fStoremanID + '\'' +
                ", fStoremanName='" + fStoremanName + '\'' +
                ", fSupplierID='" + fSupplierID + '\'' +
                ", fSupplierName='" + fSupplierName + '\'' +
                ", fMaterialID='" + fMaterialID + '\'' +
                ", fMaterialName='" + fMaterialName + '\'' +
                ", fStorageID='" + fStorageID + '\'' +
                ", fStorageName='" + fStorageName + '\'' +
                ", fAmount='" + fAmount + '\'' +
                ", fPrice='" + fPrice + '\'' +
                ", fSum='" + fSum + '\'' +
                ", fStandard='" + fStandard + '\'' +
                '}';
    }

    public String getFatherid() {
        return fatherid;
    }

    public void setFatherid(String fatherid) {
        this.fatherid = fatherid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getfNursingHomeID() {
        return fNursingHomeID;
    }

    public void setfNursingHomeID(String fNursingHomeID) {
        this.fNursingHomeID = fNursingHomeID;
    }

    public String getfNursingHomeName() {
        return fNursingHomeName;
    }

    public void setfNursingHomeName(String fNursingHomeName) {
        this.fNursingHomeName = fNursingHomeName;
    }

    public String getfPurchaseDate() {
        return fPurchaseDate;
    }

    public void setfPurchaseDate(String fPurchaseDate) {
        this.fPurchaseDate = fPurchaseDate;
    }

    public String getfTel() {
        return fTel;
    }

    public void setfTel(String fTel) {
        this.fTel = fTel;
    }

    public String getfSupplyMome() {
        return fSupplyMome;
    }

    public void setfSupplyMome(String fSupplyMome) {
        this.fSupplyMome = fSupplyMome;
    }

    public String getfPaymentMode() {
        return fPaymentMode;
    }

    public void setfPaymentMode(String fPaymentMode) {
        this.fPaymentMode = fPaymentMode;
    }

    public String getfReceivingPlace() {
        return fReceivingPlace;
    }

    public void setfReceivingPlace(String fReceivingPlace) {
        this.fReceivingPlace = fReceivingPlace;
    }

    public String getfAuditorID() {
        return fAuditorID;
    }

    public void setfAuditorID(String fAuditorID) {
        this.fAuditorID = fAuditorID;
    }

    public String getfAuditTime() {
        return fAuditTime;
    }

    public void setfAuditTime(String fAuditTime) {
        this.fAuditTime = fAuditTime;
    }

    public String getfCreatorID() {
        return fCreatorID;
    }

    public void setfCreatorID(String fCreatorID) {
        this.fCreatorID = fCreatorID;
    }

    public String getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(String fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public String getfModiFierID() {
        return fModiFierID;
    }

    public void setfModiFierID(String fModiFierID) {
        this.fModiFierID = fModiFierID;
    }

    public String getfModiFicationTime() {
        return fModiFicationTime;
    }

    public void setfModiFicationTime(String fModiFicationTime) {
        this.fModiFicationTime = fModiFicationTime;
    }

    public String getfRemarks() {
        return fRemarks;
    }

    public void setfRemarks(String fRemarks) {
        this.fRemarks = fRemarks;
    }

    public String getpID() {
        return pID;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public String getfPurchaseManID() {
        return fPurchaseManID;
    }

    public void setfPurchaseManID(String fPurchaseManID) {
        this.fPurchaseManID = fPurchaseManID;
    }

    public String getfPurchaseManName() {
        return fPurchaseManName;
    }

    public void setfPurchaseManName(String fPurchaseManName) {
        this.fPurchaseManName = fPurchaseManName;
    }

    public String getfStoremanID() {
        return fStoremanID;
    }

    public void setfStoremanID(String fStoremanID) {
        this.fStoremanID = fStoremanID;
    }

    public String getfStoremanName() {
        return fStoremanName;
    }

    public void setfStoremanName(String fStoremanName) {
        this.fStoremanName = fStoremanName;
    }

    public String getfSupplierID() {
        return fSupplierID;
    }

    public void setfSupplierID(String fSupplierID) {
        this.fSupplierID = fSupplierID;
    }

    public String getfSupplierName() {
        return fSupplierName;
    }

    public void setfSupplierName(String fSupplierName) {
        this.fSupplierName = fSupplierName;
    }

    public String getfMaterialID() {
        return fMaterialID;
    }

    public void setfMaterialID(String fMaterialID) {
        this.fMaterialID = fMaterialID;
    }

    public String getfMaterialName() {
        return fMaterialName;
    }

    public void setfMaterialName(String fMaterialName) {
        this.fMaterialName = fMaterialName;
    }

    public String getfStorageID() {
        return fStorageID;
    }

    public void setfStorageID(String fStorageID) {
        this.fStorageID = fStorageID;
    }

    public String getfStorageName() {
        return fStorageName;
    }

    public void setfStorageName(String fStorageName) {
        this.fStorageName = fStorageName;
    }

    public String getfAmount() {
        return fAmount;
    }

    public void setfAmount(String fAmount) {
        this.fAmount = fAmount;
    }

    public String getfPrice() {
        return fPrice;
    }

    public void setfPrice(String fPrice) {
        this.fPrice = fPrice;
    }

    public String getfSum() {
        return fSum;
    }

    public void setfSum(String fSum) {
        this.fSum = fSum;
    }

    public String getfStandard() {
        return fStandard;
    }

    public void setfStandard(String fStandard) {
        this.fStandard = fStandard;
    }

    public WarehouseEntryPo() {
    }

    public WarehouseEntryPo(String fatherid, String fid, String fNumber, String start, String finish, String fNursingHomeID, String fNursingHomeName, String fPurchaseDate, String fTel, String fSupplyMome, String fPaymentMode, String fReceivingPlace, String fAuditorID, String fAuditTime, String fCreatorID, String fCreateTime, String fModiFierID, String fModiFicationTime, String fRemarks, String pID, String fPurchaseManID, String fPurchaseManName, String fStoremanID, String fStoremanName, String fSupplierID, String fSupplierName, String fMaterialID, String fMaterialName, String fStorageID, String fStorageName, String fAmount, String fPrice, String fSum, String fStandard) {
        this.fatherid = fatherid;
        this.fid = fid;
        this.fNumber = fNumber;
        this.start = start;
        this.finish = finish;
        this.fNursingHomeID = fNursingHomeID;
        this.fNursingHomeName = fNursingHomeName;
        this.fPurchaseDate = fPurchaseDate;
        this.fTel = fTel;
        this.fSupplyMome = fSupplyMome;
        this.fPaymentMode = fPaymentMode;
        this.fReceivingPlace = fReceivingPlace;
        this.fAuditorID = fAuditorID;
        this.fAuditTime = fAuditTime;
        this.fCreatorID = fCreatorID;
        this.fCreateTime = fCreateTime;
        this.fModiFierID = fModiFierID;
        this.fModiFicationTime = fModiFicationTime;
        this.fRemarks = fRemarks;
        this.pID = pID;
        this.fPurchaseManID = fPurchaseManID;
        this.fPurchaseManName = fPurchaseManName;
        this.fStoremanID = fStoremanID;
        this.fStoremanName = fStoremanName;
        this.fSupplierID = fSupplierID;
        this.fSupplierName = fSupplierName;
        this.fMaterialID = fMaterialID;
        this.fMaterialName = fMaterialName;
        this.fStorageID = fStorageID;
        this.fStorageName = fStorageName;
        this.fAmount = fAmount;
        this.fPrice = fPrice;
        this.fSum = fSum;
        this.fStandard = fStandard;
    }
}
