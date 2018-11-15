package com.cs2340.binarybros.buzztracker;
import com.cs2340.binarybros.buzztracker.Models.User;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;


/**
 * This class test's user passwords to make sure it's a valid password.
 * The requirements for the password is that is must be between
 * 8 and 16 characters (inclusively).
 */

public class ValidPasswordTest {
    private User goodUser;
    private  User badUser;
    private User uglyUser;

    @Before
    public void setup() {
        goodUser = new User(
                "Admin",
                "Fidel",
                "fidelf",
                "agoodpassword",
                "fcaceres@gatech.edu",
                "Midtown",
                0);

        badUser = new User(
                "Manager",
                "Eddie",
                "eddief",
                "badpass",
                "eddie@gatech.edu",
                "Buckhead",
                1);

        uglyUser = new User(
                "LocationEmployee",
                "David",
                "davidc",
                "averylongpassword",
                "david@gatech.edu",
                "Downtown",
                2);
    }

    @Test
    public void passwordValidator() {
        assertFalse(badUser.passwordIsValid());
        assertFalse(uglyUser.passwordIsValid());
        assertTrue(goodUser.passwordIsValid());
    }

}
