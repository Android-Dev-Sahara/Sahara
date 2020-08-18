package com.daiict.internship.Sahara.UserDashboard;

public class DonationCommonClass {
    private String donar_name;
    private String location;
    private String date;
    private String time;
    private String contact_no;
    private Integer no_of_persons;

    public DonationCommonClass(String donar_name, String location, String date, String time, String contact_no, Integer no_of_persons) {
        this.donar_name = donar_name;
        this.location = location;
        this.date = date;
        this.time = time;
        this.contact_no = contact_no;
        this.no_of_persons = no_of_persons;
    }

    public String getDonar_name() {
        return donar_name;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getContact_no() {
        return contact_no;
    }

    public Integer getNo_of_persons() {
        return no_of_persons;
    }

    public void setDonar_name(String donar_name) {
        this.donar_name = donar_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setContact_no(String contact_no) {
        this.contact_no = contact_no;
    }

    public void setNo_of_persons(Integer no_of_persons) {
        this.no_of_persons = no_of_persons;
    }
}
