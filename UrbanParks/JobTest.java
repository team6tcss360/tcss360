import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
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
	private Volunteer myVolunteer;
	private Park myPark;
	
	@Before
	public void setUp() {
		String startDate = "02042016";
		String endDate = "02042016";
		String details = "do whatever you want";
		
		
		myVolunteer = new Volunteer("Weiwei", "Shi", "wshi@uw.edu", "3609903694");
		
		myPark = new Park("South Park", "Olympia", "Josh", "Teneburg");
		
		myJob = new Job(1, startDate, endDate, "North Park", details, 2, 3, 2, new ArrayList<>());
	}
	
	
	@Test
	public void testConstructor() {
		assertEquals(2, myJob.getLightMax());
		assertEquals(3, myJob.getMedMax());
		assertEquals(2, myJob.getHeavyMax());
		assertEquals(0, myJob.getLightCurrent());
		assertEquals(0, myJob.getMedCurrent());
		assertEquals(0, myJob.getHeavyCurrent());
		
		//need to test jobid
		//for(int i = 1; i <= 8; i++) {
			//Job jobtest = new Job(i, "02" + (04+i) + "2016", "02" + (04+i) + "2016", "North Park", "")
		//}
		
	}
	
	@Test
	public void testGetLightCurrent() {
		
	}
	
	@Test
	public void testGetMedCurrent() {
		
	}
	
	@Test
	public void testGetHeavyCurret() {
		
	}
	
	//I want to go sleep now....
}

