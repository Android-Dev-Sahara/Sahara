package com.daiict.internship.Sahara.UserDashboard;

import java.sql.Time;
import java.util.Date;

public class GeneralNotificationClass {
    private String text_data_notification;
    private String date;
    private String time;

    public GeneralNotificationClass(String text_data_notification, String date, String time) {
        this.text_data_notification = text_data_notification;
        this.date = date;
        this.time = time;
    }

    public String getText_data_notification() {
        return text_data_notification;
    }

    public void setText_data_notification(String text_data_notification) {
        this.text_data_notification = text_data_notification;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
