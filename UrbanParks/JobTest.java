import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;
import org.junit.Before;
import org.junit.Test;


/**
 * Testing Job Class
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 4, 2016
 */

public class JobTest {

	private Job myJob;
	private Job myJob2;


	private Volunteer v0;
	private Volunteer v1;
	private Volunteer v2;
	
	private Park park1;
	private ParkManager pm1;
	//check park manager

	@Before
	public void setUp() throws ParseException {

		myJob = new Job(1, "03-01-16 2:00PM", "03-01-16 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);
		myJob2 = new Job(2, "04-02-16 9:00AM", "04-03-16 5:00PM", "Mount Rainier", "The volunteers will repair a bridge.", 0, 0, 5);

		park1 = new Park("Point Defiance", "5400 N Pearl St, Tacoma, WA 98407", "Peter", "Parker");
		
		pm1 = new ParkManager("Peter","Parker","p@p.com","9876547590");
		
		
	}

	@Test
	public void testConstructor() {
		assertEquals(3, myJob.getLightMax());
		assertEquals(3, myJob.getMedMax());
		assertEquals(3, myJob.getHeavyMax());
	}

	//Here we also tested addLightVolunteer method.
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
	
	@Test
	public void testIsInPast(){
		assertFalse(myJob.isInPast());	
	}
	
	@Test
	public void testGetSummary() {
		assertEquals("Job: " + "1" + " | Park: " + "South Park" + 
				" | Start: " + "03-01-16 2:00PM" + " | End: " 
				+ "03-01-16 4:00PM", myJob.getSummary());
	}
	
	
	
	@Test
	public void testIsParkManager() {
		assertEquals("Peter Parker, Point Defiance", park1.getParkManagerFirstName() + " " 
													+ park1.getParkManagerLastName() + ", "
													+ park1.getParkName());
		
	}
	
	
	@Test
	public void testIsVolunteer() {
		v0 = new Volunteer("Weiwei", "Shi", "wshi@uw.edu", "911");
		v1 = new Volunteer("Weiwei2", "Shi2", "wshi2@uw.edu", "912");
		myJob.addLightVolunteer(v0);
		
		assertTrue(myJob.isVolunteer(v0));
		assertFalse(myJob.isVolunteer(v1));
	}
	
	@Test
	public void testEquals() {
		assertFalse(myJob.equals(myJob2));
		
	}
	
	



	

}

