/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Before;
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
 * @version February 29, 2016
 */
public class JobTest {

	/**
	 * Job object for testing.
	 */
	private Job job1;
	private Job job2;
	private Job job3;

	/**
	 * ParkList for testing.
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
	@Before
	public void setUp() throws Exception {
		v0 = new Volunteer("Michael", "Ford", "fordm13@uw.edu", "2061234567");
		v1 = new Volunteer("Weiwei", "Shi", "shi@uw.edu", "2061552535");
		v2 = new Volunteer("Chris", "Vishoot", "vishoot@uw.edu", "2535556253");

		job1 = new Job(1, "02-01-16 2:00PM", "02-01-16 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);
		job2 = new Job(1, "03-08-16 2:00PM", "03-08-16 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);
		job3 = new Job(1, "02-01-16 2:00PM", "02-01-16 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);

		parks = new ParkList();

		park1 = new Park("Point Defiance", "5400 N Pearl St, Tacoma, WA 98407", "Peter", "Parker");
		parks.add(park1);
		pm1 = new ParkManager("Peter","Parker","p@p.com","9876547590");
	}

	//------------------------------------------------------Test addLightVolunteer() method----------------------------------------------------
	/**
	 * Test method for addLightVolunteer:
	 * Case 1: if not reach the max of light job volunteers, hasLightMax() will return false.
	 */
	@Test
	public void testAddLightVolunteerNotReachMax() {
		job1.addLightVolunteer(v0);
		job1.addLightVolunteer(v1);
		//we add two volunteers to the light job right now, the max volunteer of light job for job1 is 3.
		assertFalse(job1.hasLightMax());
	}

	/**
	 * Test method for addLightVolunteer:
	 * Case 2: if it reaches the max of light job volunteers, hasLightMax() will return true.
	 */
	@Test
	public void testAddLightVolunteerReachMax() {
		job1.addLightVolunteer(v0);
		job1.addLightVolunteer(v1);
		job1.addLightVolunteer(v2);
		//we add 3 volunteers to the light job right now, the max volunteer of light job for job1 is 3.
		assertTrue(job1.hasLightMax());
	}

	//------------------------------------------------------Test addMedVolunteer() method------------------------------------------------------
	/**
	 * Test method for addMedVolunteer:
	 * Case 1: if not reach the max of medium job volunteers, hasMedMax() will return false.
	 */
	@Test
	public void testAddMedVolunteerNotReachMax() {
		job1.addMedVolunteer(v0);
		job1.addMedVolunteer(v1);
		//hasMedMax() will return false since we only have 2 volunteers for med job, the max is 3
		assertFalse(job1.hasMedMax());	
	}

	/**
	 * Test method for addMedVolunteer:
	 * Case 2: if it reaches the max of medium job volunteers, hasMedMax() will return true.
	 */
	@Test
	public void testAddMedVolunteerReachMax() {
		job1.addMedVolunteer(v0);
		job1.addMedVolunteer(v1);
		job1.addMedVolunteer(v2);
		//hasMedMax() will return true since we have 3 volunteers for med job now, the max is 3
		assertTrue(job1.hasMedMax());	
	}

	//------------------------------------------------------Test addHeavyVolunteer() method----------------------------------------------------
	/**
	 * Test method for addHeavyVolunteer:
	 * Case 1: if not reach the max of heavy job volunteers, hasHeavyMax() will return false.
	 */
	@Test
	public void testAddHeavyVolunteerNotReachMax() {
		job1.addHeavyVolunteer(v0);
		job1.addHeavyVolunteer(v1);
		//hasHeavyMax() will return false since we only have 2 volunteers for heavy job, the max is 3
		assertFalse(job1.hasHeavyMax());	
	}

	/**
	 * Test method for addHeavyVolunteer:
	 * Case 2: if it reaches the max of heavy job volunteers, hasHeavyMax() will return true.
	 */
	@Test
	public void testAddHeavyVolunteerReachMax() {
		job1.addHeavyVolunteer(v0);
		job1.addHeavyVolunteer(v1);
		job1.addHeavyVolunteer(v2);
		//hasHeavyMax() will return true since we have 3 volunteers for med job now, the max is 3
		assertTrue(job1.hasHeavyMax());	
	}

	//----------------------------------------------------Test volunteerListToString() method--------------------------------------------------
	/**
	 * Test method for volunteerListToString()
	 * Case 1: if no volunteer be added to the job, it will print "None"
	 */
	@Test
	public void testVolunteerListToStringNull() {
		assertEquals("Volunteers: None", job1.volunteerListToString());
	}

	/**
	 * Test method for volunteerListToString()
	 * Case 2: if there is a volunteer added to the job, it will return a list of volunteer.
	 */
	@Test
	public void testVolunteerListToStringNotNull() {
		job1.addLightVolunteer(v0);
		assertEquals("Volunteers: Michael Ford", job1.volunteerListToString());
	}

	/**
	 * Test method for volunteerListToString()
	 * Case 3: if there is more than one volunteer added to the job, it will return a list of volunteer with
	 * "," between two volunteers.
	 */
	@Test
	public void testVolunteerListToStringNotNullMoreThan1() {
		job1.addLightVolunteer(v0);
		job1.addLightVolunteer(v1);
		assertEquals("Volunteers: Michael Ford, Weiwei Shi", job1.volunteerListToString());
	}


	//------------------------------------------------------Test isParkManager() method-------------------------------------------------------
	/**
	 * Test method for isParkManager():
	 * Case 1: if the user is the park manger of the park: isParkManger will return true
	 * 
	 */
	@Test
	public void testIsParkManager() {
		parks.getPark("Point Defiance");
		assertTrue(park1.isParkManager(pm1));
	}

	/**
	 * Test method for isParkManager():
	 * Case 2: if the user is not the park manger of the park: isParkManger will return false
	 * 
	 */
	@Test
	public void testIsNotParkManager() {
		parks.getPark("Point Defiance");
		assertFalse(park1.isParkManager(v0));
	}

	//------------------------------------------------------Test isVolunteer() method---------------------------------------------------------
	/**
	 * Test method for isVolunteer():
	 * Case 1: if the volunteer signed up for the job, isVolunteer() will return true.
	 */
	@Test
	public void testIsVolunteer() {
		job1.addLightVolunteer(v0);
		assertTrue(job1.isVolunteer(v0));
	}

	/**
	 * Test method for isVolunteer():
	 * Case 2: if the volunteer didn't sign up for the job, isVolunteer() will return false.
	 */
	@Test
	public void testIsNotVolunteer() {
		job1.addLightVolunteer(v0);
		assertFalse(job1.isVolunteer(v1));
	}

	//------------------------------------------------------Test isInPast() method------------------------------------------------------------
	/**
	 * Test method for isInPast():
	 * Case 1: if the job is in the past, isInPast() will return true.
	 */
	@Test
	public void testIsInPast() {
		assertTrue(job1.isInPast());
	}

	/**
	 * Test method for isInPast():
	 * Case 2: if the job is not in the past, isInPast() will return false.
	 */
	@Test
	public void testIsNotInPast() {
		assertFalse(job2.isInPast());
	}

	//------------------------------------------------------Test hasVolunteers() method-------------------------------------------------------
	/**
	 * Test method for hasVolunteers():
	 * Case 1: is the size of the volunteerList > 0, hasVolunteer() will return true
	 */
	@Test
	public void testHasVolunteers() {
		job1.addLightVolunteer(v1);
		assertTrue(job1.hasVolunteers());
	}

	/**
	 * Test method for hasVolunteers():
	 * Case 2: is the size of the volunteerList = 0, hasVolunteer() will return false
	 * Case 3: is the size of the volunteerList < 0, it doesn't make sense to test this case.
	 */
	@Test
	public void testHasZeroVolunteers() {
		assertFalse(job1.hasVolunteers());
	}

	//------------------------------------------------------Test equals() method--------------------------------------------------------------
	/**
	 * Test method for equals():
	 * Case 1: compare to two same object, equals() will return true.
	 */
	@Test
	public void testEquals() {
		assertTrue(job1.equals(job3));
	}

	/**
	 * Test method for equals():
	 * Case 1: compare to different object, equals() will return false.
	 */
	@Test
	public void testNotEquals() {
		assertFalse(job1.equals(job2));
	}
}
