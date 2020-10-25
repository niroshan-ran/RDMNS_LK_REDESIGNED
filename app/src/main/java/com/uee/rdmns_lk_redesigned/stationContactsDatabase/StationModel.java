package com.uee.rdmns_lk_redesigned.stationContactsDatabase;

public class StationModel {

    private String stationName;
    private String stationNameSinhala;
    private String phoneNumber;
    private double firstClassPrice;
    private double secondClassPrice;
    private double thirdClassPrice;

    public StationModel() {
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationNameSinhala() {
        return stationNameSinhala;
    }

    public void setStationNameSinhala(String stationNameSinhala) {
        this.stationNameSinhala = stationNameSinhala;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(double firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public double getSecondClassPrice() {
        return secondClassPrice;
    }

    public void setSecondClassPrice(double secondClassPrice) {
        this.secondClassPrice = secondClassPrice;
    }

    public double getThirdClassPrice() {
        return thirdClassPrice;
    }

    public void setThirdClassPrice(double thirdClassPrice) {
        this.thirdClassPrice = thirdClassPrice;
    }
}
