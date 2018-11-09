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
    private String shortDescription;
    private String longDescription;
    private int id;

    public Donation(String title, String timestampInput, String locationInput, String categoryInput,
                    String priceInput, String shortDescriptionInput, String longDescriptionInput) {
        this.title = title;
        this.timestamp = timestampInput;
        this.category = categoryInput;
        this.price = priceInput;
        this.location = locationInput;
        this.shortDescription = shortDescriptionInput;
        this.longDescription = longDescriptionInput;
    }

    //This constructor is to only be used for the custom InventoryListViewAdapter
    public Donation(String title, String category,String location, String price) {
        this.title = title;
        this.timestamp = "";
        this.category = category;
        this.price = price;
        this.location = location;
        this.shortDescription = "";
        this.longDescription = "";

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

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
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

    public String getShortDescription() {
        return shortDescription;
    }
    public String getLongDescription(){
        return longDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
