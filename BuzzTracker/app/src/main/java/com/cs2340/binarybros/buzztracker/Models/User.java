package com.cs2340.binarybros.buzztracker.Models;

public class User {

    private String name;
    private String username;
    private String password;
    private String email;
    private String employeeLocation;
    private int employeeID;


    public User(String nameInput, String usernameInput, String passwordInput, String emailInput,
                String employeeLocation, int employeeID) {
        this.name = nameInput;
        this.username = usernameInput;
        this.password = passwordInput;
        this.email = emailInput;
        this.employeeLocation = employeeLocation;
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployeeLocation() { return this.employeeLocation;}

    public void setEmployeeLocation(String employeeLocation) { this.employeeLocation = employeeLocation;}

    public int getEmployeeNumber() {
        return employeeID;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeID = employeeNumber;
    }


}