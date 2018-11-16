package com.cs2340.binarybros.buzztracker.Models;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * the user class
 */
public class User implements Serializable {

    private String type;
    private String name;
    private String username;
    private String password;
    private String email;
    private String employeeLocation;
    private int employeeID;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 8;



    /**
     * the constructor of user
     * @param type the type
     * @param nameInput the name
     * @param usernameInput the username
     * @param passwordInput the password
     * @param emailInput the email
     * @param employeeLocation the employee
     * @param employeeID the ID of the employee
     */
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
    /**
     * the getter of type
     * @return the type
     */
    public String getType() {
        return type;
    }
    /**
     * the setter of the type
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * the getter of the name
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * the setter of the name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * the getter of the username
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    /**
     * the setter of the username
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * the getter of the password
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    /**
     * the setter of the password
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * the getter of the email
     * @return the email
     */
    public String getEmail() {
        return email;
    }
    /**
     * the setter of the email
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * the getter of the location of employee
     * @return the employee location
     */
    public String getEmployeeLocation() { return this.employeeLocation;}
    /**
     * the setter of the employeeLocation
     * @param employeeLocation the location for the employee
     */
    public void setEmployeeLocation(String employeeLocation) {
        this.employeeLocation = employeeLocation; }
    /**
     * the getter of the employee number
     * @return the employee number
     */
    public int getEmployeeNumber() {
        return employeeID;
    }
    /**
     * the setter of the employee number
     * @param employeeNumber the number for employee
     */
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeID = employeeNumber;
    }

    /**
     * This method checks to see if the email passed in is of a valid format
     * @param email the email
     * @return if the email is valid
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

    /**
     * This method checks to see if the password passed in is of a valid format
     * @return if the password is valid
     */
    public boolean passwordIsValid() {
        int pwdL = password.length();

        if ((pwdL >= MIN_PASSWORD_LENGTH) && (pwdL <= MAX_PASSWORD_LENGTH)) {
            return true;
        }
        return false;
    }
}
