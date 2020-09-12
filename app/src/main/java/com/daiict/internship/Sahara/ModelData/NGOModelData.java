package com.daiict.internship.Sahara.ModelData;

public class NGOModelData {
    private String ngoId;
    private String userName;
    private String emailId;
    private String ngoName;
    private String address;
    private String area;
    private String establishedYear;
    private String contactNo;
    private String membersCount;
    private String createDate;
    private String modifyDate;
    private String userIsVerified;

    public NGOModelData() {}

    public NGOModelData(String ngoId, String userName, String emailId, String ngoName, String address, String area, String establishedYear, String contactNo, String membersCount, String createDate, String modifyDate, String userIsVerified) {
        this.ngoId = ngoId;
        this.userName = userName;
        this.emailId = emailId;
        this.ngoName = ngoName;
        this.address = address;
        this.area = area;
        this.establishedYear = establishedYear;
        this.contactNo = contactNo;
        this.membersCount = membersCount;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.userIsVerified = userIsVerified;
    }

    public String getNgoId() {
        return ngoId;
    }

    public void setNgoId(String ngoId) {
        this.ngoId = ngoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEstablishedYear() {
        return establishedYear;
    }

    public void setEstablishedYear(String establishedYear) {
        this.establishedYear = establishedYear;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(String membersCount) {
        this.membersCount = membersCount;
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

    public String getUserIsVerified() {
        return userIsVerified;
    }

    public void setUserIsVerified(String userIsVerified) {
        this.userIsVerified = userIsVerified;
    }
}
