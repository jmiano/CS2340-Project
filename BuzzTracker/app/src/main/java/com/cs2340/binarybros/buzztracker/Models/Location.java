package com.cs2340.binarybros.buzztracker.Models;

import java.io.Serializable;

public class Location implements Serializable {

    private int key;
    private String name;
    private double latitude;
    private double longitude;
    private String streetAddress;
    private String city;
    private String state;
    private int zip;
    private String type;
    private String phone;
    private String website;


    public Location(int keyInput, String nameInput, double latitudeInput, double longitudeInput
        , String streetAddressInput, String cityInput, String stateInput, int zipInput
        , String typeInput, String phoneInput, String websiteInput) {
        this.key = keyInput;
        this.name = nameInput;
        this.latitude = latitudeInput;
        this.longitude = longitudeInput;
        this.streetAddress = streetAddressInput;
        this.city = cityInput;
        this.state = stateInput;
        this.zip = zipInput;
        this.type = typeInput;
        this.phone = phoneInput;
        this.website = websiteInput;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

