package model;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * A JUnit test class for Park Object.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 12, 2016
 */
public class ParkTest {

	/** A Park object for testing. */
	private Park park1;
	private String park1Name;
	private String park1Location;
	private String park1FirstName;
	private String park1LastName;

	/** A second Park object for testing. */
	private Park park2;
	private String park2Name;
	private String park2Location;
	private String park2FirstName;
	private String park2LastName;

	/** A third Park object for testing. */
	private Park park3;

	/** A User object for testing. */
	private User pm1;
	private String pm1FN;
	private String pm1LN;
	private String pm1EM;
	private String pm1P;

	/** A second park manager for testing. */
	private User pm2;
	private String pm2FN;
	private String pm2LN;
	private String pm2EM;
	private String pm2P;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		park1Name = "Point Defiance";
		park1Location = "Tacoma";
		park1FirstName = "Weiwei";
		park1LastName = "Shi";

		park2Name = "Discovery";
		park2Location = "Seattle";
		park2FirstName = "Michael";
		park2LastName = "Ford";

		pm1FN = "Chris";
		pm1LN = "Vishoot";
		pm1EM = "chris@mail.com";
		pm1P  = "(206) 187-1492";

		pm2FN = "Michael";
		pm2LN = "Ford";
		pm2EM = "fordm13@uw.edu";
		pm2P = "(206) 123-4567";		


		park1 = new Park(park1Name, park1Location, park1FirstName, park1LastName);
		park2 = new Park(park2Name, park2Location, park2FirstName, park2LastName);
		park3 = new Park(park1Name, park1Location, park1FirstName, park1LastName);
		pm1 = new ParkManager(pm1FN, pm1LN, pm1EM, pm1P);
		pm2 = new ParkManager(pm2FN, pm2LN, pm2EM, pm2P);
	}





	/**
	 * Test method for {@link Park#isParkManager(User)}.
	 */
	@Test
	public void testIsParkManager() {
		assertFalse(park1.isParkManager(pm1));
		System.out.println(park2.getParkManagerFirstName()+" "+ park2.getParkManagerLastName());
		assertTrue(park2.isParkManager(pm2));
	}

	/**
	 * Test method for {@link Park#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		assertTrue(park1.equals(park3));
		assertFalse(park1.equals(park2));
	}

	//	/**
	//	 * Test method for {@link Park#hashCode()}.
	//	 */
	//	@Test
	//	public void testHashCode() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link Park#toString()}.
	//	 */
	//	@Test
	//	public void testToString() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link Park#Park(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	//	 */
	//	@Test
	//	public void testPark() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link Park#setParkName(java.lang.String)}.
	//	 */
	//	@Test
	//	public void testSetParkName() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link Park#setLastName(java.lang.String)}.
	//	 */
	//	@Test
	//	public void testSetLastName() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link Park#setParkManagerFirstName(java.lang.String)}.
	//	 */
	//	@Test
	//	public void testSetParkManagerFirstName() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link Park#setParkManagerLastName(java.lang.String)}.
	//	 */
	//	@Test
	//	public void testSetParkManagerLastName() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link Park#getParkName()}.
	//	 */
	//	@Test
	//	public void testGetParkName() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link Park#getLocation()}.
	//	 */
	//	@Test
	//	public void testGetLocation() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link Park#getParkManagerFirstName()}.
	//	 */
	//	@Test
	//	public void testGetParkManagerFirstName() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link Park#getParkManagerLastName()}.
	//	 */
	//	@Test
	//	public void testGetParkManagerLastName() {
	//		fail("Not yet implemented"); // TODO
	//	}
}
