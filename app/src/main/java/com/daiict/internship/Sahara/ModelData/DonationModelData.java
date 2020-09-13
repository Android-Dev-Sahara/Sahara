package com.daiict.internship.Sahara.ModelData;

public class DonationModelData {
    private String donationId;
    private String isRawFood;
    private String pickUpTime;
    private String donorId;
    private String createDate;
    private String modifyDate;
    private String status;
    private String acceptedBy;
    private String assignTo;

    public DonationModelData() {}

    public DonationModelData(String date, String pickup, String stat, String acceptBy) {
        modifyDate = date;
        pickUpTime = pickup;
        status = stat;
        acceptedBy = acceptBy;
    }

    public DonationModelData(String donationId, String isRawFood, String pickUpTime, String donorId, String createDate, String modifyDate, String status, String acceptedBy) {
        this.donationId = donationId;
        this.isRawFood = isRawFood;
        this.pickUpTime = pickUpTime;
        this.donorId = donorId;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.status = status;
        this.acceptedBy = acceptedBy;
    }

    public DonationModelData(String donationId, String isRawFood, String pickUpTime, String donorId, String createDate, String modifyDate, String status, String acceptedBy, String assignTo) {
        this.donationId = donationId;
        this.isRawFood = isRawFood;
        this.pickUpTime = pickUpTime;
        this.donorId = donorId;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.status = status;
        this.acceptedBy = acceptedBy;
        this.assignTo = assignTo;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }

    public String getIsRawFood() {
        return isRawFood;
    }

    public void setIsRawFood(String isRawFood) {
        this.isRawFood = isRawFood;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(String acceptedBy) {
        this.acceptedBy = acceptedBy;
    }
}
