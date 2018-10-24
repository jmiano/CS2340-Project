package com.cs2340.binarybros.buzztracker.Models;

public class Donation {
    private String timestamp;
    private String location;
    private String category;
    private String price;
    private String shortdescription;
    private String longdescription;

    public Donation(String timestampInput, String locationInput, String categoryInput,
                    String priceInput, String shortdescriptionInput, String longdescriptionInput) {
        this.timestamp = timestampInput;
        this.category = categoryInput;
        this.price = priceInput;
        this.shortdescription = shortdescriptionInput;
        this.longdescription = longdescriptionInput;
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
