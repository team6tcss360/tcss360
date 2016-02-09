import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
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
	
	@Before
	public void setUp() {
		String startDate = "02042016";
		String endDate = "02042016";
		String details = "do whatever you want";
		
			
		myJob = new Job(1, startDate, endDate, "South Park", details, 3, 3, 3, new ArrayList<>());
	}
	
	
	@Test
	public void testConstructor() {
		assertEquals(3, myJob.getLightMax());
		assertEquals(3, myJob.getMedMax());
		assertEquals(3, myJob.getHeavyMax());
		assertEquals(0, myJob.getLightCurrent());
		assertEquals(0, myJob.getMedCurrent());
		assertEquals(0, myJob.getHeavyCurrent());
		
		//need to test jobid
		for(int i = 1; i <= 5; i++) {
			Job jobTest = new Job(i, "02" + (04+i) + "2016", 
					"02" + (04+i) + "2016", "South Park", myJob.getJobDetails(), 2, 2, 2, new ArrayList<>());
			assertEquals(i, jobTest.getJobID());
		}
		
	}
	
	@Test
	public void testGetLightCurrent() {
		assertEquals(0, myJob.getCurrentLightNum());
		
		ArrayList<String> v0 = new ArrayList<>();
		ArrayList<String> v1 = new ArrayList<>();
		ArrayList<String> v2 = new ArrayList<>();
		
		v0.add("wshi@uw.edu");
		v0.add("Light");
		myJob.addVolunteer(v0);
		assertEquals(1, myJob.getCurrentLightNum());
		
		v1.add("wowowo@uw.edu");
		v1.add("Light");
		myJob.addVolunteer(v1);
		assertEquals(2, myJob.getCurrentLightNum());
		
		v2.add("hohoho@uw.edu");
		v2.add("Light");
		myJob.addVolunteer(v1);
		assertEquals(3, myJob.getCurrentLightNum());
		
	}
	
	@Test
	public void testGetMedCurrent() {
		assertEquals(0, myJob.getCurrentMedNum());
		
		ArrayList<String> v3 = new ArrayList<>();
		ArrayList<String> v4 = new ArrayList<>();
		ArrayList<String> v5 = new ArrayList<>();
		
		v3.add("whatup@uw.edu");
		v3.add("Medium");
		myJob.addVolunteer(v3);
		assertEquals(1, myJob.getCurrentMedNum());
		
		v4.add("whatup2@uw.edu");
		v4.add("Medium");
		myJob.addVolunteer(v4);
		assertEquals(2, myJob.getCurrentMedNum());
		
		v5.add("whatup3@uw.edu");
		v5.add("Medium");
		myJob.addVolunteer(v5);
		assertEquals(3, myJob.getCurrentMedNum());
		
	}
	
	@Test
	public void testGetHeavyCurret() {
		assertEquals(0, myJob.getCurrentHeavyNum());
		
		ArrayList<String> v6 = new ArrayList<>();
		ArrayList<String> v7 = new ArrayList<>();
		ArrayList<String> v8 = new ArrayList<>();
		
		v6.add("hihihi@uw.edu");
		v6.add("Heavy");
		myJob.addVolunteer(v6);
		assertEquals(1, myJob.getCurrentHeavyNum());
		
		v7.add("hihihi2@uw.edu");
		v7.add("Heavy");
		myJob.addVolunteer(v7);
		assertEquals(2, myJob.getCurrentHeavyNum());
		
		v8.add("hihihi3@uw.edu");
		v8.add("Heavy");
		myJob.addVolunteer(v8);
		assertEquals(3, myJob.getCurrentHeavyNum());
		
	}
	
	
}

