package com.daiict.internship.Sahara.SignUp;

/*
 *   SingleTon Pattern Usage for data transferring in multiple Activities is Efficient Way...
 *   Reason: Shared Preferences may take some storage in Device.....
 */

public class SignUpSingle {
    private static SignUpSingle mInstance = null;

    private SignUpSingle() {
    }       // Private Default Constructor

    public static synchronized SignUpSingle getInstance() {
        if (mInstance == null) {
            mInstance = new SignUpSingle();
        }
        return mInstance;
    }

    private String actor;       // Category container

    // Common Fields for all....
    // Signup1
    private String firstName;
    private String lastName;
    private String emailID;
    private String accPass;
    // SignUp2
    private String addressLine1;
    private String addressLine2;
    private String dateOfBirth_Establishment;
    // SignUp3
    private String contactNo;
    private String gender;

    // NGO specific field
    private String ngoName;

    // Volunteer Specific field
    private String volunteerNgo;
    private String isWorkWithNgo;

    // NGO and Needy Field
    private String membersCount;

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getAccPass() {
        return accPass;
    }

    public void setAccPass(String accPass) {
        this.accPass = accPass;
    }

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
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

    public String getVolunteerNgo() {
        return volunteerNgo;
    }

    public void setVolunteerNgo(String volunteerNgo) {
        this.volunteerNgo = volunteerNgo;
    }

    public String getIsWorkWithNgo() {
        return isWorkWithNgo;
    }

    public void setIsWorkWithNgo(String isWorkWithNgo) {
        this.isWorkWithNgo = isWorkWithNgo;
    }

    public String getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(String membersCount) {
        this.membersCount = membersCount;
    }

    public String getDateOfBirth_Establishment() {
        return dateOfBirth_Establishment;
    }

    public void setDateOfBirth_Establishment(String dateOfBirth_Establishment) {
        this.dateOfBirth_Establishment = dateOfBirth_Establishment;
    }
}
