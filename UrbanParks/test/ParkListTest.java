package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Park;
import model.ParkList;

/**
 * A JUnit test class for ParkList Object.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 12, 2016
 */

public class ParkListTest {

	
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
	
	private ParkList pList1;
	
	private ParkList pList2;
	
	private ParkList pList3;
	
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

		park1 = new Park(park1Name, park1Location, park1FirstName, park1LastName);
		park2 = new Park(park2Name, park2Location, park2FirstName, park2LastName);
		
		pList1 = new ParkList();
		pList2 = new ParkList();
		pList3 = new ParkList();
	}

	/**
	 * Test method for {@link ParkList#add(Park)}.
	 */
	@Test
	public void testAdd() {
		assertTrue(pList1.getArrayList().size()==0);
		pList1.add(park1);
		pList1.add(park2);
		assertFalse(pList1.getArrayList().size()==0);
		assertTrue(pList1.getArrayList().size()==2);
	}

	/**
	 * Test method for {@link ParkList#findIndex(Park)}.
	 */
	@Test
	public void testFindIndex() {
		pList1.add(park1);
		pList1.add(park2);
		int x = pList1.findIndex(park1);
		assertEquals(x, 0);
		int y = pList1.findIndex(park2);
		assertEquals(y, 1);
	}

	/**
	 * Test method for {@link ParkList#getPark(java.lang.String)}.
	 */
	@Test
	public void testGetPark() {
		
		pList1.add(park1);
		pList1.add(park2);
		Park newPark = pList1.getPark(park1Name);
		assertTrue(park1.equals(newPark));
		assertFalse(park2.equals(newPark));
	}

	/**
	 * Test method for {@link ParkList#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		pList1.add(park1);
		pList1.add(park2);
		pList2.add(park1);
		pList3.add(park1);
		pList3.add(park2);
		
		assertTrue(pList1.equals(pList3));
		assertFalse(pList1.equals(pList2));
	}
}
