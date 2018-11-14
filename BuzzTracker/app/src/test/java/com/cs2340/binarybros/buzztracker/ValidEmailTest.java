package com.cs2340.binarybros.buzztracker;
import com.cs2340.binarybros.buzztracker.Models.User;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests to see if the method that I use to test for valid emails is correct
 */
public class ValidEmailTest {
    private User user;

    /**
     * Do this before every test
     */
    @Before
    public void setUp() {
        user = new User("Manager", "Daniel", "dannyhtaylor",
                "youStink", "dtaylor87@gatech.edu",
                "AFD Station 4", 0);
    }

    /**
     * Actual test
     */
    @Test
    public void emailValidator() {
        assertFalse(user.emailIsValid(""));
        assertFalse(user.emailIsValid("aklfhl"));
        assertTrue(user.emailIsValid(user.getEmail()));

    }
}
