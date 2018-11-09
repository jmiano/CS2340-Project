package com.cs2340.binarybros.buzztracker.Models;

import java.io.Serializable;
import java.util.Random;

@SuppressWarnings("MagicNumber")
public class Donation implements Serializable {
    private String title;
    private String timestamp;
    private String location;
    private String category;
    private String price;
    private String shortdescription;
    private String longdescription;
    private int id;

    public Donation(String title, String timestampInput, String locationInput, String categoryInput,
                    String priceInput, String shortdescriptionInput, String longdescriptionInput) {
        this.title = title;
        this.timestamp = timestampInput;
        this.category = categoryInput;
        this.price = priceInput;
        this.location = locationInput;
        this.shortdescription = shortdescriptionInput;
        this.longdescription = longdescriptionInput;
    }

    //This constructor is to only be used for the custom InventoryListViewAdapter
    public Donation(String title, String category,String location, String price) {
        this.title = title;
        this.timestamp = "";
        this.category = category;
        this.price = price;
        this.location = location;
        this.shortdescription = "";
        this.longdescription = "";

    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setShortdescription(String shortdescription) {
        this.shortdescription = shortdescription;
    }

    public void setLongdescription(String longdescription) {
        this.longdescription = longdescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }
    public String getPrice(){
        return price;
    }

    public String getShortdescription() {
        return shortdescription;
    }
    public String getLongdescription(){
        return longdescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
