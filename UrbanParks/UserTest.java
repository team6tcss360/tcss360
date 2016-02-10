import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

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
    
    /** A user for testing. */
    private User user;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        user = new Volunteer(FIRST_NAME, LAST_NAME, EMAIL, PHONE);
    }

    /**
     * Test method for {@link User#User(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)}.
     */
    @Test
    public void testUser() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link User#setFirstName(java.lang.String)}.
     */
    @Test
    public void testSetFirstName() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link User#setLastName(java.lang.String)}.
     */
    @Test
    public void testSetLastName() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link User#setEmail(java.lang.String)}.
     */
    @Test
    public void testSetEmail() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link User#setPhone(java.lang.String)}.
     */
    @Test
    public void testSetPhone() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link User#setUserID(int)}.
     */
    @Test
    public void testSetUserID() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link User#getFirstName()}.
     */
    @Test
    public void testGetFirstName() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link User#getLastName()}.
     */
    @Test
    public void testGetLastName() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link User#getEmail()}.
     */
    @Test
    public void testGetEmail() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link User#getPhone()}.
     */
    @Test
    public void testGetPhone() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link User#getUserID()}.
     */
    @Test
    public void testGetUserID() {
        fail("Not yet implemented");
    }

}
