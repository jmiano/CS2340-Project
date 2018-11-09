package com.cs2340.binarybros.buzztracker.Controllers;

import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.Location;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVFile {
    InputStream inputStream;
    private List<Location> locationList;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public List read(){
        List resultList = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        /* Grab the location list from facade to be populated */
        this.locationList = Database.getInstance().getLocationList(); // Pulls the non-persistent ArrayList of locations
        try {
            String csvLine;
            reader.readLine();
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");

                //Prevents duplicates (adding the same file multiple times)
                if (!locationList.contains(new Location(
                        row[0], row[1], row[2], row[3]
                        , row[4], row[5], row[6], row[7]
                        , row[8], row[9], row[10]))) {
                    resultList.add(new Location(
                            row[0], row[1], row[2], row[3]
                            , row[4], row[5], row[6], row[7]
                            , row[8], row[9], row[10]
                    ));
                }
            }
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                throw new RuntimeException("Error while closing input stream: "+e);
            }
        }
        return resultList;
    }
}