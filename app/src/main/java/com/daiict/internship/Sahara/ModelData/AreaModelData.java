package com.daiict.internship.Sahara.ModelData;

public class AreaModelData {
    private String areaName;
    private String latitude;
    private String longitude;
    private String marker;
    private String noOfDonation;
    private String pincode;
    private String population;

    public AreaModelData() {}

    public AreaModelData(String areaName, String latitude, String longitude, String marker, String noOfDonation, String pincode, String population) {
        this.areaName = areaName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.marker = marker;
        this.noOfDonation = noOfDonation;
        this.pincode = pincode;
        this.population = population;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getNoOfDonation() {
        return noOfDonation;
    }

    public void setNoOfDonation(String noOfDonation) {
        this.noOfDonation = noOfDonation;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
