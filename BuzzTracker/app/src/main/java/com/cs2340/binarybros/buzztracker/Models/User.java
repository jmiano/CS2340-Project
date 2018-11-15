package com.cs2340.binarybros.buzztracker.Models;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Serializable {

    private String type;
    private String name;
    private String username;
    private String password;
    private String email;
    private String employeeLocation;
    private int employeeID;



    public User(String type, String nameInput, String usernameInput, String passwordInput,
                String emailInput, String employeeLocation, int employeeID) {
        this.type = type;
        this.name = nameInput;
        this.username = usernameInput;
        this.password = passwordInput;
        this.email = emailInput;
        this.employeeLocation = employeeLocation;
        this.employeeID = employeeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setEmployeeLocation(String employeeLocation) {
        this.employeeLocation = employeeLocation; }

    public int getEmployeeNumber() {
        return employeeID;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeID = employeeNumber;
    }

    /*
     * This method checks to see if the email passed in is of a valid format
     */
    public boolean emailIsValid(String email)
    {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-]" +
                "+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);

        if (email.isEmpty()) {
            return false;
        } else if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }


    public boolean passwordIsValid() {
        int min = 8;
        int max = 16;
        int pwdL = password.length();

        if (pwdL >= min && pwdL <= max) {
            return true;
        }
        return false;
    }
}
