package com.cs2340.binarybros.buzztracker;

public class Admin extends User {

    private int employeeNumber;

    public Admin(int employeeID) {
        super(name, username, password, email);
        employeeNumber = employeeID;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    
}
