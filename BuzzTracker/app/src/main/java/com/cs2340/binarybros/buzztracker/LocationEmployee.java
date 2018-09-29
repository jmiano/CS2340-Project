package com.cs2340.binarybros.buzztracker;

public class LocationEmployee extends User {

    private int employeeNumber;
    private int employeeLocation;

    public LocationEmployee(int employeeID, int locationNumber) {
        super(name, username, password, email);
        employeeNumber = employeeID;
        employeeLocation = locationNumber;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getEmployeeLocation() {
        return employeeLocation;
    }

    public void setEmployeeLocation(int employeeLocation) {
        this.employeeLocation = employeeLocation;
    }
}
