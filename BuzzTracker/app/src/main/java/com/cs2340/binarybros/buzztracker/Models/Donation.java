package com.cs2340.binarybros.buzztracker.Models;

import java.io.Serializable;
/**
 * this is the donation class
 */
public class Donation implements Serializable {
    private String title;
    private String timestamp;
    private String location;
    private String category;
    private String price;
    private String shortDescription;
    private String longDescription;
    private int id;
    /**
     * the constructor of donation
     * @param title the title of donation
     * @param timestampInput the timestamp
     * @param locationInput location
     * @param categoryInput the input of category
     * @param priceInput the price
     * @param shortDescriptionInput the short description
     * @param longDescriptionInput the long description
     */
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
    /**
     * the constructor of donation
     * @param title the title of donation
     * @param category the input of category
     * @param location the location
     * @param price the price
     */
    public Donation(String title, String category,String location, String price) {
        this.title = title;
        this.timestamp = "";
        this.category = category;
        this.price = price;
        this.location = location;
        this.shortDescription = "";
        this.longDescription = "";

    }
    /**
     * the setter of time stamp
     * @param timestamp the time stamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    /**
     * the setter of location
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /**
     * the setter of category
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * the setter of price
     * @param price the price
     */
    public void setPrice(String price) {
        this.price = price;
    }
    /**
     * the setter of short description
     * @param shortDescription the short description
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    /**
     * the setter of long description
     * @param longDescription the long description
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
    /**
     * the getter of title
     * @return title
     */
    public String getTitle() {
        return title;
    }
    /**
     * the setter of title
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * the getter of time stamp
     * @return time stamp
     */
    public CharSequence getTimestamp() {
        return timestamp;
    }
    /**
     * the getter of location
     * @return location
     */
    public String getLocation() {
        return location;
    }
    /**
     * the getter of category
     * @return category
     */
    public String getCategory() {
        return category;
    }
    /**
     * the getter of price
     * @return price
     */
    public String getPrice(){
        return price;
    }
    /**
     * the getter of short description
     * @return short description
     */
    public CharSequence getShortDescription() {
        return shortDescription;
    }
    /**
     * the getter of long description
     * @return long description
     */
    public CharSequence getLongDescription(){
        return longDescription;
    }
    /**
     * the getter of ID
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * the setter of id
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

}
