package com.channelsoft.ems.po;

/**
 * Created by liuxing on 2017/1/6.
 */
public class StorageCheckPo {
    private String id;
    private String fnumber;

    private String nursingHomeID;
    private String nursingHome;

    private String storemanID;
    private String storeman;

    private String storageID;
    private String storage;

    private String storageManID;
    private String storageMan;

    private String checkManID;//盘点人
    private String checkMan;//盘点人

    private String materialID;
    private String material;

    private String paperNumber;//账面数量
    private String checkNumber;//盘点数量
    private String difference;//差异数量

    private String status;
    private String cause;
    private String explain;

    private String auditorID;
    private String auditor;

    private String creatorID;
    private String creator;

    private String Edate;
    private String Ldate;
    private String checkDate;
    private String batch;
    private String auditorTime;
    private String createTime;
    private String modifierID;
    private String modificationTime;
    private String remarks;

    @Override
    public String toString() {
        return "StorageCheckPo{" +
                "id='" + id + '\'' +
                ", fnumber='" + fnumber + '\'' +
                ", nursingHomeID='" + nursingHomeID + '\'' +
                ", nursingHome='" + nursingHome + '\'' +
                ", storemanID='" + storemanID + '\'' +
                ", storeman='" + storeman + '\'' +
                ", storageID='" + storageID + '\'' +
                ", storage='" + storage + '\'' +
                ", storageManID='" + storageManID + '\'' +
                ", storageMan='" + storageMan + '\'' +
                ", checkManID='" + checkManID + '\'' +
                ", checkMan='" + checkMan + '\'' +
                ", materialID='" + materialID + '\'' +
                ", material='" + material + '\'' +
                ", paperNumber='" + paperNumber + '\'' +
                ", checkNumber='" + checkNumber + '\'' +
                ", difference='" + difference + '\'' +
                ", status='" + status + '\'' +
                ", cause='" + cause + '\'' +
                ", explain='" + explain + '\'' +
                ", auditorID='" + auditorID + '\'' +
                ", auditor='" + auditor + '\'' +
                ", creatorID='" + creatorID + '\'' +
                ", creator='" + creator + '\'' +
                ", Edate='" + Edate + '\'' +
                ", Ldate='" + Ldate + '\'' +
                ", checkDate='" + checkDate + '\'' +
                ", batch='" + batch + '\'' +
                ", auditorTime='" + auditorTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", modifierID='" + modifierID + '\'' +
                ", modificationTime='" + modificationTime + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFnumber() {
        return fnumber;
    }

    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }

    public String getNursingHomeID() {
        return nursingHomeID;
    }

    public void setNursingHomeID(String nursingHomeID) {
        this.nursingHomeID = nursingHomeID;
    }

    public String getNursingHome() {
        return nursingHome;
    }

    public void setNursingHome(String nursingHome) {
        this.nursingHome = nursingHome;
    }

    public String getStoremanID() {
        return storemanID;
    }

    public void setStoremanID(String storemanID) {
        this.storemanID = storemanID;
    }

    public String getStoreman() {
        return storeman;
    }

    public void setStoreman(String storeman) {
        this.storeman = storeman;
    }

    public String getStorageID() {
        return storageID;
    }

    public void setStorageID(String storageID) {
        this.storageID = storageID;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getStorageManID() {
        return storageManID;
    }

    public void setStorageManID(String storageManID) {
        this.storageManID = storageManID;
    }

    public String getStorageMan() {
        return storageMan;
    }

    public void setStorageMan(String storageMan) {
        this.storageMan = storageMan;
    }

    public String getCheckManID() {
        return checkManID;
    }

    public void setCheckManID(String checkManID) {
        this.checkManID = checkManID;
    }

    public String getCheckMan() {
        return checkMan;
    }

    public void setCheckMan(String checkMan) {
        this.checkMan = checkMan;
    }

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPaperNumber() {
        return paperNumber;
    }

    public void setPaperNumber(String paperNumber) {
        this.paperNumber = paperNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getAuditorID() {
        return auditorID;
    }

    public void setAuditorID(String auditorID) {
        this.auditorID = auditorID;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(String creatorID) {
        this.creatorID = creatorID;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getAuditorTime() {
        return auditorTime;
    }

    public void setAuditorTime(String auditorTime) {
        this.auditorTime = auditorTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifierID() {
        return modifierID;
    }

    public void setModifierID(String modifierID) {
        this.modifierID = modifierID;
    }

    public String getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(String modificationTime) {
        this.modificationTime = modificationTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public StorageCheckPo(String id, String fnumber, String nursingHomeID, String nursingHome, String storemanID, String storeman, String storageID, String storage, String storageManID, String storageMan, String checkManID, String checkMan, String materialID, String material, String paperNumber, String checkNumber, String difference, String status, String cause, String explain, String auditorID, String auditor, String creatorID, String creator, String edate, String ldate, String checkDate, String batch, String auditorTime, String createTime, String modifierID, String modificationTime, String remarks) {
        this.id = id;
        this.fnumber = fnumber;
        this.nursingHomeID = nursingHomeID;
        this.nursingHome = nursingHome;
        this.storemanID = storemanID;
        this.storeman = storeman;
        this.storageID = storageID;
        this.storage = storage;
        this.storageManID = storageManID;
        this.storageMan = storageMan;
        this.checkManID = checkManID;
        this.checkMan = checkMan;
        this.materialID = materialID;
        this.material = material;
        this.paperNumber = paperNumber;
        this.checkNumber = checkNumber;
        this.difference = difference;
        this.status = status;
        this.cause = cause;
        this.explain = explain;
        this.auditorID = auditorID;
        this.auditor = auditor;
        this.creatorID = creatorID;
        this.creator = creator;
        Edate = edate;
        Ldate = ldate;
        this.checkDate = checkDate;
        this.batch = batch;
        this.auditorTime = auditorTime;
        this.createTime = createTime;
        this.modifierID = modifierID;
        this.modificationTime = modificationTime;
        this.remarks = remarks;
    }

    public StorageCheckPo() {super();
    }
}
