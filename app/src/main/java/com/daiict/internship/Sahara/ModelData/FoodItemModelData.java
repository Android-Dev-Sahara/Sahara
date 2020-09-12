package com.daiict.internship.Sahara.ModelData;

public class FoodItemModelData {
    private String itemname;
    private String noofpersons;
    private String spoilage;
    private String weight;

    FoodItemModelData() {}

    public FoodItemModelData(String itemname, String noofpersons, String spoilage, String weight) {
        this.itemname = itemname;
        this.noofpersons = noofpersons;
        this.spoilage = spoilage;
        this.weight = weight;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getNoofpersons() {
        return noofpersons;
    }

    public void setNoofpersons(String noofpersons) {
        this.noofpersons = noofpersons;
    }

    public String getSpoilage() {
        return spoilage;
    }

    public void setSpoilage(String spoilage) {
        this.spoilage = spoilage;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
