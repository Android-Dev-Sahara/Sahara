package com.daiict.internship.Sahara.UserDashboard;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class ItemDataClass {
    private Date donationdate;
    private boolean isRaw;
    private boolean isSelfDonor;
    private Time pickuptime;
    private ArrayList<AddItemDataClass> list;

    public ItemDataClass(Date donationdate, boolean isRaw, boolean isSelfDonor, Time pickuptime, ArrayList<AddItemDataClass> additem) {
        this.donationdate = donationdate;
        this.isRaw = isRaw;
        this.isSelfDonor = isSelfDonor;
        this.pickuptime = pickuptime;
        this.list = additem;
    }

    public Date getDonationdate() {
        return donationdate;
    }

    public void setDonationdate(Date donationdate) {
        this.donationdate = donationdate;
    }

    public boolean isRaw() {
        return isRaw;
    }

    public void setRaw(boolean raw) {
        isRaw = raw;
    }

    public boolean isSelfDonor() {
        return isSelfDonor;
    }

    public void setSelfDonor(boolean selfDonor) {
        isSelfDonor = selfDonor;
    }

    public Time getPickuptime() {
        return pickuptime;
    }

    public void setPickuptime(Time pickuptime) {
        this.pickuptime = pickuptime;
    }

    public ArrayList<AddItemDataClass> getList() {
        return list;
    }

    public void setList(ArrayList<AddItemDataClass> list) {
        this.list = list;
    }

}
