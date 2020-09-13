package com.daiict.internship.Sahara.ModelData;

public class NeedyModelData {
    private String userId;
    private String userName;
    private String emailId;
    private String address;
    private String area;
    private String dateOfBirth;
    private String contactNo;
    private String membersCount;
    private String gender;
    private String createDate;
    private String modifyDate;
    private String userIsVerified;

    public NeedyModelData () {}

    public NeedyModelData(String userId, String userName, String emailId, String address, String area, String dateOfBirth, String contactNo, String membersCount, String gender, String createDate, String modifyDate, String userIsVerified) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.address = address;
        this.area = area;
        this.dateOfBirth = dateOfBirth;
        this.contactNo = contactNo;
        this.membersCount = membersCount;
        this.gender = gender;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.userIsVerified = userIsVerified;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
