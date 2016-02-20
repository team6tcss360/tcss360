/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Job;
import model.Park;
import model.ParkList;
import model.ParkManager;
import model.Volunteer;

/**
 * A JUnit test class for the Job Class
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 19, 2016
 */
public class JobTest {

	/**
	 * Job object for testing.
	 */
	private Job job1;
	private Job job2;
	private Job job3;
	private Job job4;

	/**
	 * JobList for testing.
	 */
	private ParkList parks;

	/**
	 * Volunteer object for testing.
	 */
	private Volunteer v0;
	private Volunteer v1;
	private Volunteer v2;

	/**
	 * Park object for testing
	 */
	private Park park1;

	/**
	 * ParkManger object for testing.
	 */
	private ParkManager pm1;

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
		v0 = new Volunteer("Michael", "Ford", "fordm13@uw.edu", "2061234567");
		v1 = new Volunteer("Weiwei", "Shi", "shi@uw.edu", "2061552535");
		v2 = new Volunteer("Chris", "Vishoot", "vishoot@uw.edu", "2535556253");
		job1 = new Job(1, "02-01-16 2:00PM", "02-01-16 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);
		job2 = new Job(1, "03-08-16 2:00PM", "03-08-16 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);
		job3 = new Job(3, "03-01-17 2:00PM", "03-01-17 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);
		job4 = new Job(1, "02-01-16 2:00PM", "02-01-16 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);

		parks = new ParkList();

		park1 = new Park("Point Defiance", "5400 N Pearl St, Tacoma, WA 98407", "Peter", "Parker");
		parks.add(park1);
		pm1 = new ParkManager("Peter","Parker","p@p.com","9876547590");
	}





	/**
	 * Test method for {@link model.Job#addLightVolunteer(model.Volunteer)}.
	 */
	@Test
	public void testAddLightVolunteer() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link model.Job#addMedVolunteer(model.Volunteer)}.
	 */
	@Test
	public void testAddMedVolunteer() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link model.Job#addHeavyVolunteer(model.Volunteer)}.
	 */
	@Test
	public void testAddHeavyVolunteer() {
		fail("Not yet implemented"); // TODO
	}



	/**
	 * Test method for {@link model.Job#volunteerListToString()}.
	 */
	@Test
	public void testVolunteerListToString() {
		fail("Not yet implemented"); // TODO
	}



	/**
	 * Test method for {@link model.Job#isParkManager(model.ParkList, model.User)}.
	 */
	@Test
	public void testIsParkManager() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link model.Job#isVolunteer(model.Volunteer)}.
	 */
	@Test
	public void testIsVolunteer() {
		job1.addLightVolunteer(v0);
		job1.addLightVolunteer(v1);
		assertFalse(job1.isVolunteer(v2));
		assertTrue(job1.isVolunteer(v1));
	}

	/**
	 * Test method for {@link model.Job#isInPast()}.
	 */
	@Test
	public void testIsInPast() {

		assertFalse(job2.isInPast());
		assertTrue(job1.isInPast());
	}

	/**
	 * Test method for {@link model.Job#hasVolunteers()}.
	 */
	@Test
	public void testHasVolunteers() {
		assertFalse(job1.hasVolunteers());
		job1.addLightVolunteer(v1);
		assertTrue(job1.hasVolunteers());
	}



	/**
	 * Test method for {@link model.Job#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		assertTrue(job1.equals(job4));
		assertFalse(job1.equals(job2));
	}

	//	/**
	//	 * Test method for {@link model.Job#hashCode()}.
	//	 */
	//	@Test
	//	public void testHashCode() {
	//		fail("Not yet implemented"); // TODO
	//	}

	//	/**
	//	 * Test method for {@link model.Job#Job(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int)}.
	//	 */
	//	@Test
	//	public void testJob() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#setLightMax(int)}.
	//	 */
	//	@Test
	//	public void testSetLightMax() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#setMedMax(int)}.
	//	 */
	//	@Test
	//	public void testSetMedMax() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#setHeavyMax(int)}.
	//	 */
	//	@Test
	//	public void testSetHeavyMax() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#setStartDate(java.lang.String)}.
	//	 */
	//	@Test
	//	public void testSetStartDate() {
	//		fail("Not yet implemented");
	//	}

	//	/**
	//	 * Test method for {@link model.Job#setEndDate(java.lang.String)}.
	//	 */
	//	@Test
	//	public void testSetEndDate() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#setParkName(java.lang.String)}.
	//	 */
	//	@Test
	//	public void testSetParkName() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#setDetails(java.lang.String)}.
	//	 */
	//	@Test
	//	public void testSetDetails() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#getJobID()}.
	//	 */
	//	@Test
	//	public void testGetJobID() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#getStartDate()}.
	//	 */
	//	@Test
	//	public void testGetStartDate() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#getEndDate()}.
	//	 */
	//	@Test
	//	public void testGetEndDate() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#getParkName()}.
	//	 */
	//	@Test
	//	public void testGetParkName() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#getJobDetails()}.
	//	 */
	//	@Test
	//	public void testGetJobDetails() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#getLightMax()}.
	//	 */
	//	@Test
	//	public void testGetLightMax() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#getMedMax()}.
	//	 */
	//	@Test
	//	public void testGetMedMax() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#getHeavyMax()}.
	//	 */
	//	@Test
	//	public void testGetHeavyMax() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#getSummary()}.
	//	 */
	//	@Test
	//	public void testGetSummary() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#getDateFormat()}.
	//	 */
	//	@Test
	//	public void testGetDateFormat() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#getVolunteerList()}.
	//	 */
	//	@Test
	//	public void testGetVolunteerList() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#hasLightMax()}.
	//	 */
	//	@Test
	//	public void testHasLightMax() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#hasMedMax()}.
	//	 */
	//	@Test
	//	public void testHasMedMax() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#hasHeavyMax()}.
	//	 */
	//	@Test
	//	public void testHasHeavyMax() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#convertToCalender(java.lang.String)}.
	//	 */
	//	@Test
	//	public void testConvertToCalender() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#formatDate(java.util.GregorianCalendar)}.
	//	 */
	//	@Test
	//	public void testFormatDate() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.Job#toString()}.
	//	 */
	//	@Test
	//	public void testToString() {
	//		fail("Not yet implemented"); // TODO
	//	}
}
