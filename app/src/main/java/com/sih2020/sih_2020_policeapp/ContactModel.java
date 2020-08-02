package com.sih2020.sih_2020_policeapp;

public class ContactModel {
    String name, phone,lat,lon,blood;

    public ContactModel(String name, String phone,String lat,String lon,String blood) {
        this.name = name;
        this.phone = phone;
        this.lat = lat;
        this.lon = lon;
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}