package com.daiict.internship.Sahara.UserDashboard;

import java.util.ArrayList;

public class AddItemDataClass {

    private String itemname;
    private int noofpersons;
    private float weight;
    private boolean spoilage;

    public AddItemDataClass(String itemname, int noofpersons, float weight, boolean spoilage) {
        this.itemname = itemname;
        this.noofpersons = noofpersons;
        this.weight = weight;
        this.spoilage = spoilage;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getNoofpersons() {
        return noofpersons;
    }

    public void setNoofpersons(int noofpersons) {
        this.noofpersons = noofpersons;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isSpoilage() {
        return spoilage;
    }

    public void setSpoilage(boolean spoilage) {
        this.spoilage = spoilage;
    }

}
