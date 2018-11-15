package com.cs2340.binarybros.buzztracker.Models;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * This is a singleton class that acts like a local data base. This is not persistent,
 * but it holds information as long as the app is running
 */
public final class Database {
    //Filename for writing and reading data
    public static final String DEFAULT_BINARY_FILE_NAME = "data.bin";

    private static Database INSTANCE;

    //ArrayList that stores the user credential that are registered to login.
    private ArrayList<User> userList;

    //ArrayList that stores the locations that are entered
    private ArrayList<Location> locationList;

    //ArrayList that stores the locations that are entered
    private ArrayList<Donation> donationList;

    //String indicating the current users' type
    private static User currentUser;


    /**
     * The constructor is private, because it I only want 1 instance of it
     */
    private Database() {
    }

    /**
     * This method returns the only instance of Database
     * @return Our local Database
     */
    public static Database getInstance() {
        synchronized(Database.class) {
            if (INSTANCE == null) {
                INSTANCE = new Database();
            }
        }
        return(INSTANCE);
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Location> getLocationList() {
        return locationList;
    }

    public void setLocationList(ArrayList<Location> locationList) {
        this.locationList = locationList;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Database.currentUser = currentUser;
    }

    public ArrayList<Donation> getDonationList() { return donationList; }

    public  void initialize() {
        userList = new ArrayList<>(10);
        locationList = new ArrayList<>(10);
        donationList = new ArrayList<>(10);

    }

    public boolean loadBinary(File file) {
        boolean success = true;
        try {
            /*
              To read, we must use the ObjectInputStream since we want to read our model in with
              a single read.
             */
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // assuming we saved our top level object, we read it back in with one line of code.
            userList = (ArrayList<User>) in.readObject();
            locationList = (ArrayList<Location>) in.readObject();
            donationList = (ArrayList<Donation>) in.readObject();
            in.close();
        } catch (IOException e) {
            Log.e("Database", "Error reading an entry from binary file",e);
            success = false;
        } catch (ClassNotFoundException e) {
            Log.e("Database", "Error casting a class from the binary file",e);
            success = false;
        }

        return success;
    }

    public boolean saveBinary(File file) {
        boolean success = true;
        try {
            /*
               For binary, we use Serialization, so everything we write has to implement
               the Serializable interface.  Fortunately all the collection classes and APi classes
               that we might use are already Serializable.  You just have to make sure your
               classes implement Serializable.

               We have to use an ObjectOutputStream to write objects.

               One thing to be careful of:  You cannot serialize static data.
             */


            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            // We basically can save our entire data model with one write, since this will follow
            // all the links and pointers to save everything.  Just save the top level object.
            out.writeObject(userList);
            out.writeObject(locationList);
            out.writeObject(donationList);
            out.close();

        } catch (IOException e) {
            Log.e("Database", "Error writing an entry from binary file",e);
            success = false;
        }
        return success;
    }
    /*
     * This method checks how many valid user do we have
     */
    public int countUser() {
        int numofuser = 0;
        for (User data: userList) {
            if (data.getUsername()!= null) {
                numofuser++;
            }
        }
        return numofuser;
    }



}
