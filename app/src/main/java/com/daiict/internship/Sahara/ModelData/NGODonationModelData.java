package com.daiict.internship.Sahara.ModelData;

public class NGODonationModelData {
    private String donationId;
    private String ngoName;
    private String isRawFood;
    private String deliveryTime;
    private String location;
    private String createDate;
    private String status;
    private String assignTo;

    public NGODonationModelData() {}

    public NGODonationModelData(String donationId, String ngoName, String isRawFood, String deliveryTime, String location, String createDate, String status, String assignTo) {
        this.donationId = donationId;
        this.ngoName = ngoName;
        this.isRawFood = isRawFood;
        this.deliveryTime = deliveryTime;
        this.location = location;
        this.createDate = createDate;
        this.status = status;
        this.assignTo = assignTo;
    }

    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    public String getIsRawFood() {
        return isRawFood;
    }

    public void setIsRawFood(String isRawFood) {
        this.isRawFood = isRawFood;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }
}
