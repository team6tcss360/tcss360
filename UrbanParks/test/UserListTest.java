package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.ParkList;
import model.ParkManager;
import model.StaffMember;
import model.User;
import model.UserList;
import model.Volunteer;

/**
 * A JUnit test class for UserList Object.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 12, 2016
 */

public class UserListTest {
	
	/**UserLists for testing. */
	UserList uList1;
	UserList uList2;
	UserList uList3;
	ParkList pList1;
	
	
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

	/** A StaffMember for testing. */
	private User sm1;
	private String sm1FN;
	private String sm1LN;
	private String sm1EM;
	private String sm1P;
	
	/** A ParkManager for testing */
	private User pm1;
	private String pm1FN;
	private String pm1LN;
	private String pm1EM;
	private String pm1P;
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
		vol1FN = "Weiwei";
    	vol1LN = "Shi";
    	vol1EM = "wshi@uw.edu";
    	vol1P = "(206) 765-4321";
    	
    	vol2FN = "Michael";
    	vol2LN = "Ford";
    	vol2EM = "fordm13@uw.edu";
    	vol2P = "(206) 123-4567";
    	
    	pm1FN = "Chris";
    	pm1LN = "Vishoot";
    	pm1EM = "chris@mail.com";
    	pm1P  = "(206) 187-1492";
    	
    	sm1FN = "Jonathan";
    	sm1LN = "Hughes";
    	sm1EM = "jhughes@uw.edu";
    	sm1P = "(206) 555-5555";
    	
    	vol1 = new Volunteer(vol1FN, vol1LN, vol1EM, vol1P);
        vol2 = new Volunteer(vol2FN, vol2LN, vol2EM, vol2P);
        pm1 = new ParkManager(pm1FN, pm1LN, pm1EM, pm1P);
        sm1 = new StaffMember(sm1FN, sm1LN, sm1EM, sm1P);
        
        uList1 = new UserList();
        uList2 = new UserList();
        uList3 = new UserList();
        pList1 = new ParkList();
        
	}



	/**
	 * Test method for {@link UserList#add(User)}.
	 */
	@Test
	public void testAdd() {
		assertTrue(uList1.getArrayList().size()==0);
		uList1.add(pm1);
		assertTrue(uList1.getArrayList().size()!=0);
		assertTrue(uList1.getArrayList().size()==1);
	}

	/**
	 * Test method for {@link UserList#findFromEmail(java.lang.String)}.
	 */
	@Test
	public void testFindFromEmail() {
		uList1.add(pm1);
		uList1.add(sm1);
		uList1.add(vol1);
		uList1.add(vol2);
		User testUser = uList1.findFromEmail("chris@mail.com");
		assertTrue(testUser.equals(pm1));
		assertFalse(testUser.equals(vol1));
	}

	/**
	 * Test method for {@link UserList#findIndexFromEmail(java.lang.String)}.
	 */
	@Test
	public void testFindIndexFromEmail() {
		uList1.add(pm1);
		uList1.add(sm1);
		uList1.add(vol1);
		uList1.add(vol2);
		int x = uList1.findIndexFromEmail(pm1.getEmail());
		int y = uList1.findIndexFromEmail(vol1.getEmail());
		assertEquals(x,0);
		assertEquals(y,2);
		assertFalse(y==0);
		assertFalse(x==2);
	}


	/**
	 * Test method for {@link UserList#getVolunteerLastNames()}.
	 */
	@Test
	public void testGetVolunteerLastNames() {
		String testString = "No users!";
		assertTrue(uList1.getVolunteerLastNames().equals(testString));
		uList1.add(pm1);
		uList1.add(sm1);
		uList1.add(vol1);
		uList1.add(vol2);
		assertFalse(uList1.getVolunteerLastNames().equals(testString));
		assertTrue(uList1.getVolunteerLastNames().equals("Shi, Ford"));
	}

	/**
	 * Test method for {@link UserList#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		assertTrue(uList1.equals(uList2));
		assertFalse(uList1.equals(pList1));
		uList1.add(pm1);
		uList1.add(sm1);
		uList1.add(vol1);
		uList1.add(vol2);
		uList2.add(pm1);
		uList2.add(sm1);
		uList3.add(pm1);
		uList3.add(sm1);
		assertTrue(uList2.equals(uList3));
		assertFalse(uList2.equals(uList1));
		
	}

	//	/**
	//	 * Test method for {@link UserList#hashCode()}.
	//	 */
	//	@Test
	//	public void testHashCode() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link UserList#UserList()}.
	//	 */
	//	@Test
	//	public void testUserList() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link UserList#UserList(java.util.ArrayList)}.
	//	 */
	//	@Test
	//	public void testUserListArrayListOfUser() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link UserList#size()}.
	//	 */
	//	@Test
	//	public void testSize() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link UserList#getArrayList()}.
	//	 */
	//	@Test
	//	public void testGetArrayList() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link UserList#toString()}.
	//	 */
	//	@Test
	//	public void testToString() {
	//		fail("Not yet implemented"); // TODO
	//	}

}
