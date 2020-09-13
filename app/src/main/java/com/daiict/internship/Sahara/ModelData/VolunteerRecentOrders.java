package com.daiict.internship.Sahara.ModelData;

public class VolunteerRecentOrders {
    private String id;
    private String date;
    private String category;
    private String status;
    private String area;
    private String time;

    public VolunteerRecentOrders() {}

    public VolunteerRecentOrders(String id, String date, String category, String status, String area, String time) {
        this.id = id;
        this.date = date;
        this.category = category;
        this.status = status;
        this.area = area;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
