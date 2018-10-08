package com.cs2340.binarybros.buzztracker.Models;

import java.util.ArrayList;

/**
 * This is a singleton class that acts like a local data base. This is not persistent, but it holds information
 * as long as the app is running
 */
public class Database {
    private static Database INSTANCE = null;

    //ArrayList that stores the user credential that are registered to login.
    private static ArrayList<User> userList;

    //ArrayList that stores the locations that are entered
    private static ArrayList<Location> locationList;

    /**
     * The constructor is private, because it I only want 1 instance of it
     */
    private Database() {}

    /**
     * This method returns the only instance of Database
     * @return Our local Database
     */
    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
            initialize();
        }
        return(INSTANCE);
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(ArrayList<Location> locationList) {
        Database.locationList = locationList;
    }

    public static void initialize() {
        userList = new ArrayList<>(10);
        locationList = new ArrayList<>(10);
    }
}
