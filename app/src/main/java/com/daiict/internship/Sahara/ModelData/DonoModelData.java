package com.daiict.internship.Sahara.ModelData;

public class DonoModelData {
    private String userID;
    private String userName;
    private String emailID;
    private String address;
    private String area;
    private String dateOfBirth;
    private String contactNo;
    private String gender;
    private String createDate;
    private String modifyDate;
    private String userIsVerified;

    public DonoModelData() {}  // Default Constructor

    public DonoModelData(String userID, String userName, String emailID, String address, String area, String dateOfBirth, String contactNo, String gender, String createDate, String modifyDate, String userIsVerified) {
        this.userID = userID;
        this.userName = userName;
        this.emailID = emailID;
        this.address = address;
        this.area = area;
        this.dateOfBirth = dateOfBirth;
        this.contactNo = contactNo;
        this.gender = gender;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.userIsVerified = userIsVerified;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
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
