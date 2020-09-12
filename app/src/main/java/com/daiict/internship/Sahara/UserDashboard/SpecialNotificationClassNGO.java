package com.daiict.internship.Sahara.UserDashboard;

public class SpecialNotificationClassNGO {
    private String donationId;
    private String donorName;
    private String location;
    private String noOfPerson;
    private String pickUpTime;

    public SpecialNotificationClassNGO() {}

    public SpecialNotificationClassNGO(String donationId, String donorName, String location, String noOfPerson, String pickUpTime) {
        this.donationId = donationId;
        this.donorName = donorName;
        this.location = location;
        this.noOfPerson = noOfPerson;
        this.pickUpTime = pickUpTime;
    }

    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNoOfPerson() {
        return noOfPerson;
    }

    public void setNoOfPerson(String noOfPerson) {
        this.noOfPerson = noOfPerson;
    }

    public String getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(String pickUpTime) {
        this.pickUpTime = pickUpTime;
    }
}
