package test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import model.ParkManager;
import model.User;
import model.Volunteer;

/**
 * Testing the abstract class that contains shared methods for all user types.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class UserTest {

    private static final String FIRST_NAME = null;
    private static final String LAST_NAME = null;
    private static final String EMAIL = null;
    private static final String PHONE = null;
    
    /** A volunteer for testing. */
    private User vol2;
    private String vol2FN;
    private String vol2LN;
    private String vol2EM;
    private String vol2P;
    
    /** A volunteer for testing. */
    private User vol1;
    private String vol1FN;
    private String vol1LN;
    private String vol1EM;
    private String vol1P;
    
    /** A ParkManager for testing */
    private User pm1;
    private String pm1FN;
    private String pm1LN;
    private String pm1EM;
    private String pm1P;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    	vol1FN = "Michael";
    	vol1LN = "Ford";
    	vol1EM = "fordm13@uw.edu";
    	vol1P = "(206) 123-4567";
    	
    	vol2FN = "Michael";
    	vol2LN = "Ford";
    	vol2EM = "fordm13@uw.edu";
    	vol2P = "(206) 123-4567";
    	
    	pm1FN = "Chris";
    	pm1LN = "Vishoot";
    	pm1EM = "chris@mail.com";
    	pm1P  = "(206) 187-1492";
    	
    	vol1 = new Volunteer(vol1FN, vol1LN, vol1EM, vol1P);
        vol2 = new Volunteer(vol2FN, vol2LN, vol2EM, vol2P);
        pm1 = new ParkManager(pm1FN, pm1LN, pm1EM, pm1P);
    }


    /**
     * Test method for {@link User#equals()}
     */
    @Test
    public void testEquals() {
    	assertTrue(vol1.equals(vol2));
    	assertFalse(pm1.equals(vol1));
//    	fail("Not yet implemented");
    }
    
//  /**
//  * Test method for {@link User#User(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
//  */
// @Test
// public void testUser() {
//     fail("Not yet implemented");
// }

// /**
//  * Test method for {@link User#setFirstName(java.lang.String)}.
//  */
// @Test
// public void testSetFirstName() {
//     fail("Not yet implemented");
// }
//
// /**
//  * Test method for {@link User#setLastName(java.lang.String)}.
//  */
// @Test
// public void testSetLastName() {
//     fail("Not yet implemented");
// }
//
// /**
//  * Test method for {@link User#setEmail(java.lang.String)}.
//  */
// @Test
// public void testSetEmail() {
//     fail("Not yet implemented");
// }
//
// /**
//  * Test method for {@link User#setPhone(java.lang.String)}.
//  */
// @Test
// public void testSetPhone() {
//     fail("Not yet implemented");
// }
//
// /**
//  * Test method for {@link User#setUserID(int)}.
//  */
// @Test
// public void testSetUserID() {
//     fail("Not yet implemented");
// }
//
// /**
//  * Test method for {@link User#getFirstName()}.
//  */
// @Test
// public void testGetFirstName() {
//     fail("Not yet implemented");
// }
//
// /**
//  * Test method for {@link User#getLastName()}.
//  */
// @Test
// public void testGetLastName() {
//     fail("Not yet implemented");
// }
//
// /**
//  * Test method for {@link User#getEmail()}.
//  */
// @Test
// public void testGetEmail() {
//     fail("Not yet implemented");
// }
//
// /**
//  * Test method for {@link User#getPhone()}.
//  */
// @Test
// public void testGetPhone() {
//     fail("Not yet implemented");
// }

//    unneeded since no user ID
//    /**
//     * Test method for {@link User#getUserID()}.
//     */
//    @Test
//    public void testGetUserID() {
//        fail("Not yet implemented");
//    }

}
