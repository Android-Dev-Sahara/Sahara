package com.daiict.internship.Sahara.UserDashboard;

import java.time.*;
import java.util.Calendar;

public class GeneralNotificationClass {
    private String text_data_notification;
    private String date;
    private String time;

    public GeneralNotificationClass(String text_data_notification) {
        Calendar calendar = Calendar.getInstance();
        this.text_data_notification = text_data_notification;
        this.date = calendar.get(Calendar.DATE ) + "/" +  calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR);
        this.time = calendar.get(Calendar.HOUR) + ":" +  calendar.get(Calendar.MINUTE);
        if (calendar.get(Calendar.AM_PM) == Calendar.AM) {
            time = time.concat(" AM");
        } else {
            time = time.concat(" PM");
        }

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
