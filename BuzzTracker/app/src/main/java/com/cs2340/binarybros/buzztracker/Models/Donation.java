package com.cs2340.binarybros.buzztracker.Models;

public class Donation {
    private String title;
    private String timestamp;
    private String location;
    private String category;
    private String price;
    private String shortdescription;
    private String longdescription;

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
        this.category = category;
        this.location = location;
        this.price = price;
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
}
