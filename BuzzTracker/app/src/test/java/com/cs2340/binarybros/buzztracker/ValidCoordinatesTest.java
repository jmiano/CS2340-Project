package com.cs2340.binarybros.buzztracker;
import com.cs2340.binarybros.buzztracker.Models.Location;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests to see if the method that I use to test for valid coordinates is correct
 */
public class ValidCoordinatesTest {
    private Location location1;
    private Location location2;
    private Location location3;
    private Location location4;
    private Location location5;
    private Location location6;
    private Location location7;
    private Location location8;
    private Location location9;

    /**
     * Do this before every test
     */
    @Before
    public void setUp() {
        location1 = new Location("1", "Loc1",
                "-0.5", "50", "Addr1", "City1",
                "State1", "Zip1", "Type1", "Phone1",
                "Website1");
        location2 = new Location("2", "Loc2",
                "10", "-181", "Addr2", "City2",
                "State2", "Zip2", "Type2", "Phone2",
                "Website2");
        location3 = new Location("3", "Loc3",
                "-10", "-181", "Addr3", "City3",
                "State3", "Zip3", "Type3", "Phone3",
                "Website3");
        location4 = new Location("4", "Loc4",
                "0", "180", "Addr4", "City4",
                "State4", "Zip4", "Type4", "Phone4",
                "Website4");
        location5 = new Location("5", "Loc5",
                "10", "100", "Addr5", "City5",
                "State5", "Zip5", "Type5", "Phone5",
                "Website5");
        location6 = new Location("6", "Loc6",
                null, "100", "Addr6", "City6",
                "State6", "Zip6", "Type6", "Phone6",
                "Website6");
        location7 = new Location("7", "Loc7",
                "40", null, "Addr7", "City7",
                "State7", "Zip7", "Type7", "Phone7",
                "Website7");
        location8 = new Location("8", "Loc8",
                null, null, "Addr8", "City8",
                "State8", "Zip8", "Type8", "Phone8",
                "Website8");
        location9 = null;
    }

    /**
     * Actual test
     */
    @Test
    public void locationValidator() {
        assertFalse(Location.coordinatesAreValid(location1));
        assertFalse(Location.coordinatesAreValid(location2));
        assertFalse(Location.coordinatesAreValid(location3));
        assertTrue(Location.coordinatesAreValid(location4));
        assertTrue(Location.coordinatesAreValid(location5));
        assertFalse(Location.coordinatesAreValid(location6));
        assertFalse(Location.coordinatesAreValid(location7));
        assertFalse(Location.coordinatesAreValid(location8));
        assertFalse(Location.coordinatesAreValid(location9));

    }
}
