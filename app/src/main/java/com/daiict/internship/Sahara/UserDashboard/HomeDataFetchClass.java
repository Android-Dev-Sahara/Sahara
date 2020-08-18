package com.daiict.internship.Sahara.UserDashboard;

public class HomeDataFetchClass {
    String ngoname,time,date,city,area;

    public String getNgoname() {
        return ngoname;
    }

    public void setNgoname(String ngoname) {
        this.ngoname = ngoname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public HomeDataFetchClass(String ngoname, String time, String date, String city, String area) {
        this.ngoname = ngoname;
        this.time = time;
        this.date = date;
        this.city = city;
        this.area = area;
    }
}
