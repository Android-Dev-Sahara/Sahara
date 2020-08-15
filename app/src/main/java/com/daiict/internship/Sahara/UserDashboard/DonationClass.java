package com.daiict.internship.Sahara.UserDashboard;

public class DonationClass {
    private String area_name;
    private String no_of_donation;

    public DonationClass(String area_name, String no_of_donation) {
        this.area_name = area_name;
        this.no_of_donation = no_of_donation;
    }

    public String getArea_name() {
        return area_name;
    }

    public String getNo_of_donation() {
        return no_of_donation;
    }
}
