package com.cs2340.binarybros.buzztracker;
import com.cs2340.binarybros.buzztracker.Models.Database;
import com.cs2340.binarybros.buzztracker.Models.User;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
/**
 * the test for count user
 */
public class NumberOfUserTest {
    private Database database;
    /**
     * Do this before every test
     */
    @Before
    public void setUp() {
        ArrayList<User> userList1 = new ArrayList<>(10);
        userList1.add(new User("LocationEmployee","Fan",
                "geniusguy","111","er@gatech.edu",
                "AFD Station 4",14));
        database = Database.getInstance();
        database.setUserList(userList1);
    }

    /**
     * Actual test for counting number of user
     */
    @Test
    public void countUserNumber() {
        assertFalse(2==database.countUser());
        assertTrue(1==database.countUser());
        assertEquals(1,database.countUser());

    }
}
