package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
import org.junit.Before;
import org.junit.Test;

import model.Job;
import model.Park;
import model.ParkManager;
import model.Volunteer;


/**
 * Testing Job Class
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 4, 2016
 */

public class JobTest {

	/**
	 * Job object for testing.
	 */
	private Job myJob;
	private Job myJob2;
	private Job myJob3;

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
	 * @throws ParseException
	 */
	@Before
	public void setUp() throws ParseException {

		myJob = new Job(1, "03-01-16 2:00PM", "03-01-16 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);
		myJob2 = new Job(1, "03-01-16 2:00PM", "03-01-16 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);
		myJob3 = new Job(3, "03-01-17 2:00PM", "03-01-16 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);

		park1 = new Park("Point Defiance", "5400 N Pearl St, Tacoma, WA 98407", "Peter", "Parker");

		pm1 = new ParkManager("Peter","Parker","p@p.com","9876547590");


	}

//	@Test
//	public void testConstructor() {
//		assertEquals(3, myJob.getLightMax());
//		assertEquals(3, myJob.getMedMax());
//		assertEquals(3, myJob.getHeavyMax());
//	}

	//Here we also tested addLightVolunteer method.
	/**
	 * Test hasLightMax() method, to check if the max number of  light jobs has been reached.
	 */
	@Test
	public void testHasLightMax() {
		v0 = new Volunteer("Weiwei", "Shi", "wshi@uw.edu", "911");
		v1 = new Volunteer("Weiwei2", "Shi2", "wshi2@uw.edu", "912");
		v2 = new Volunteer("Weiwei3", "Shi3", "wshi3@uw.edu", "913");

		myJob.addLightVolunteer(v0);
		//right now light type doesn't reach the max, return false
		assertFalse(myJob.hasLightMax());

		myJob.addLightVolunteer(v1);
		myJob.addLightVolunteer(v2);
		//current light type reaches the max, return true
		assertTrue(myJob.hasLightMax());		
	}

	//Here we also tested addMedVolunteer method
	/**
	 * Test hasMedMax() method, to check if the max number of  medium jobs has been reached.
	 */
	@Test
	public void testHasMedMax() {
		v0 = new Volunteer("Josh", "Teneburg", "jos@kk.com", "2899833");
		v1 = new Volunteer("Josh", "Ten", "jt@ke.edu", "472238648");
		v2 = new Volunteer("jojo", "Wees", "jw3@uw.edu", "389493");
		myJob.addMedVolunteer(v0);
		//right now medium type doesn't reach the max, return false
		assertFalse(myJob.hasMedMax());

		myJob.addMedVolunteer(v1);
		myJob.addMedVolunteer(v2);
		//current medium type reaches the max, return true
		assertTrue(myJob.hasMedMax());		
	}

	//Here we also tested addHeavyVolunteer method
	/**
	 * Test hasHeavyMax() method, to check if the max number of  heavy jobs has been reached.
	 */
	@Test
	public void testHasHeavyMax() {
		v0 = new Volunteer("kk", "Woweo", "wi@uw.edu", "28937");
		v1 = new Volunteer("Richard", "Wie", "Ri2@uw.edu", "43444899");
		v2 = new Volunteer("Jack", "Wong", "Jwong@uw.edu", "399849783");
		myJob.addHeavyVolunteer(v0);
		//right now heavy type doesn't reach the max, return false

		myJob.addHeavyVolunteer(v1);
		myJob.addHeavyVolunteer(v2);
		assertTrue(myJob.hasHeavyMax());

	}

	/**
	 * Test if the job is in past.
	 */
	@Test
	public void testIsInPast(){
		assertFalse(myJob.isInPast());	
	}

	/**
	 * Test getSummary() method, it should get the detail of the job been selected.
	 */
	@Test
	public void testGetSummary() {
		assertEquals("Job: " + "1" + " | Park: " + "South Park" + 
				" | Start: " + "03-01-16 2:00PM" + " | End: " 
				+ "03-01-16 4:00PM", myJob.getSummary());
	}


	/**
	 * Test if the User is the park manager for this job.
	 */
	@Test
	public void testIsParkManager() {
		assertEquals("Peter Parker, Point Defiance", park1.getParkManagerFirstName() + " " 
				+ park1.getParkManagerLastName() + ", "
				+ park1.getParkName());

	}

	/**
	 * Test if a volunteer is currently signed up for this job.
	 */
	@Test
	public void testIsVolunteer() {
		v0 = new Volunteer("Weiwei", "Shi", "wshi@uw.edu", "911");
		v1 = new Volunteer("Weiwei2", "Shi2", "wshi2@uw.edu", "912");
		myJob.addLightVolunteer(v0);

		assertTrue(myJob.isVolunteer(v0));
		assertFalse(myJob.isVolunteer(v1));
	}

	/**
	 * Test equals() method, to test two objects if they are equal. 
	 */
	@Test
	public void testEquals() {
		assertTrue(myJob.equals(myJob2));
		assertFalse(myJob.equals(myJob3));

	}







}

