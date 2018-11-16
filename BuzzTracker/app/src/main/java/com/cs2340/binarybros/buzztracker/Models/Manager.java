package com.cs2340.binarybros.buzztracker.Models;

/**
 * Manager class. Child of user
 */
public class Manager extends User {

    /**
     * constructor for a manager
     * @param type type
     * @param nameInput name
     * @param usernameInput username
     * @param passwordInput password
     * @param emailInput email
     * @param employeeLocation employee location
     * @param employeeID employee id
     */
    public Manager(String type, String nameInput, String usernameInput, String passwordInput,
                   String emailInput,
                   String employeeLocation, int employeeID) {
        super(type, nameInput, usernameInput, passwordInput, emailInput, employeeLocation,
                employeeID);

    }
}
