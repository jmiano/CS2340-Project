package com.cs2340.binarybros.buzztracker.Models;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.Serializable;
import java.util.Objects;
/**
 * the location class
 */
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

    /**
     * the constructor of location
     * @param keyInput the key Input
     * @param nameInput the name Input
     * @param latitudeInput the latitude input
     * @param longitudeInput the longitude input
     * @param streetAddressInput the street address
     * @param cityInput the city
     * @param stateInput the state
     * @param zipInput the zip
     * @param typeInput the type
     * @param phoneInput the phone
     * @param websiteInput the website
     */
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
    /**
     * the getter for key
     * @return the key
     */
    public String getKey() {
        return key;
    }
    /**
     * the setter for key
     * @param key the key
     */
    public void setKey(String key) {
        this.key = key;
    }
    /**
     * the getter for name
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * the setter for name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * the getter for latitude
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }
    /**
     * the setter for latitude
     * @param latitude the latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    /**
     * the getter for longitude
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }
    /**
     * the setter for longitude
     * @param longitude the longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    /**
     * the getter for street address
     * @return the street address
     */
    public String getStreetAddress() {
        return streetAddress;
    }
    /**
     * the setter for address
     * @param streetAddress the address for street
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    /**
     * the getter for city
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * the setter for city
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }
    /**
     * the getter for state
     * @return the state
     */
    public String getState() {
        return state;
    }
    /**
     * the setter for state
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }
    /**
     * the getter for zip
     * @return the zip
     */
    public String getZip() {
        return zip;
    }
    /**
     * the setter for zip
     * @param zip the zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
    /**
     * the getter for type
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * the setter for type
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * the getter for phone
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }
    /**
     * the setter for phone
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /**
     * the getter for website
     * @return the website
     */
    public String getWebsite() {
        return website;
    }
    /**
     * the setter for website
     * @param website the website
     */
    public void setWebsite(String website) {
        this.website = website;
    }
    /**
     * the location for map
     * @param loc the location
     * @param mMap the google map
     * @return the map location
     */
    public static LatLng mapLocation(Location loc, GoogleMap mMap) {

        if (loc == null) {
            throw new NullPointerException("Cannot plot null location");
        }

        if (mMap == null) {
            throw new NullPointerException("Map create error, map is null");
        }

        LatLng latLng = new LatLng(Double.parseDouble(loc.getLatitude())
                , Double.parseDouble(loc.getLongitude())); //data is strings so convert to double

        String title = String.format("%s", loc.getName()); //format marker title
        String otherInfo = String.format("%s, Phone: %s",
                loc.getStreetAddress(), loc.getPhone());
        mMap.addMarker(new MarkerOptions().position(latLng)
                .title(title).snippet(otherInfo)); //add marker to map

        return latLng;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Location)) {
            return false;
        }
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

    /**
     * This method checks if the coordinates (lat long) are valid for the given location object
     * @param location the location
     * @return if the coordinate is valid
     */
    public static boolean coordinatesAreValid(Location location) {

        if (location == null) {
            return false;
        }
        if ((location.getLatitude() == null) || (location.getLongitude() == null)) {
            return false;
        }
        try {
            double latitude = Double.parseDouble(location.getLatitude());
            double longitude = Double.parseDouble(location.getLongitude());
            if ((latitude < 0) || (latitude > 90)) {
                return false;
            } else if ((longitude < -180) || (longitude > 180)) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false; //if exception, something went wrong and coordinates are not valid
        }
    }
}

