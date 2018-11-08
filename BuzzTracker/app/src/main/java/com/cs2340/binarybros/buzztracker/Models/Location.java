package com.cs2340.binarybros.buzztracker.Models;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Location implements Serializable {

    private String key;
    private String name;
    private String latitude;
    private String longitude;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String type;
    private String phone;
    private String website;


    public Location(String keyInput, String nameInput, String latitudeInput, String longitudeInput
        , String streetAddressInput, String cityInput, String stateInput, String zipInput
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
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

    public static LatLng mapLocation(Location loc, GoogleMap mMap) {
        ArrayList<Location> locList = Database.getInstance().getLocationList();
        LatLng latLng = new LatLng(Double.parseDouble(loc.getLatitude())
                , Double.parseDouble(loc.getLongitude())); //data is strings so convert to double

        String title = String.format("Marker for %s", loc.getName()); //format marker title
        mMap.addMarker(new MarkerOptions().position(latLng).title(title)); //add marker to map

        return latLng;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return Objects.equals(getKey(), location.getKey()) &&
                Objects.equals(getName(), location.getName()) &&
                Objects.equals(getLatitude(), location.getLatitude()) &&
                Objects.equals(getLongitude(), location.getLongitude()) &&
                Objects.equals(getStreetAddress(), location.getStreetAddress()) &&
                Objects.equals(getCity(), location.getCity()) &&
                Objects.equals(getState(), location.getState()) &&
                Objects.equals(getZip(), location.getZip()) &&
                Objects.equals(getType(), location.getType()) &&
                Objects.equals(getPhone(), location.getPhone()) &&
                Objects.equals(getWebsite(), location.getWebsite());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getKey(), getName(), getLatitude(),
                getLongitude(), getStreetAddress(), getCity(),
                getState(), getZip(), getType(), getPhone(), getWebsite());
    }
}

