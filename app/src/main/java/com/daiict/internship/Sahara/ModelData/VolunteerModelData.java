package com.daiict.internship.Sahara.ModelData;

public class VolunteerModelData {
    private String volunteerID;
    private String userName;
    private String emailID;
    private String address;
    private String dateOfBirth;
    private String contactNo;
    private String cityName;
    private String isWorkWithNGO;
    private String gender;
    private String volunteerType;
    private String createDate;
    private String modifyDate;
    private String userIsVerified;

    public VolunteerModelData() {}

    public VolunteerModelData(String volunteerID, String userName, String emailID, String address, String dateOfBirth, String contactNo, String cityName, String isWorkWithNGO, String gender, String volunteerType, String createDate, String modifyDate, String userIsVerified) {
        this.volunteerID = volunteerID;
        this.userName = userName;
        this.emailID = emailID;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.contactNo = contactNo;
        this.cityName = cityName;
        this.isWorkWithNGO = isWorkWithNGO;
        this.gender = gender;
        this.volunteerType = volunteerType;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.userIsVerified = userIsVerified;
    }

    public String getVolunteerID() {
        return volunteerID;
    }

    public void setVolunteerID(String volunteerID) {
        this.volunteerID = volunteerID;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getIsWorkWithNGO() {
        return isWorkWithNGO;
    }

    public void setIsWorkWithNGO(String isWorkWithNGO) {
        this.isWorkWithNGO = isWorkWithNGO;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getVolunteerType() {
        return volunteerType;
    }

    public void setVolunteerType(String volunteerType) {
        this.volunteerType = volunteerType;
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
