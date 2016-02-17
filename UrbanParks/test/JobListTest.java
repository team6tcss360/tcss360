package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.List;

//import java.util.ArrayList;
//import java.util.List;
import org.junit.Before;
import org.junit.Test;

import model.Job;
import model.JobList;
import model.Volunteer;


/**
 * Testing JobList Class
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Weiwei Shi
 * @version February 11, 2016
 */

public class JobListTest {

	/**
	 * Contains the jobs that Urban Parks application will use.
	 */
	private JobList myJobList;
	private JobList myJobList2;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		myJobList = new JobList();
		myJobList2 = new JobList();

	}

	

	/**
	 * Test add() method, to check if user can add a job.
	 * @throws ParseException
	 */
	@Test
	public void testAdd() throws ParseException {
		//Job j1 = new Job(1, "03-01-16 2:00PM", "03-01-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0);
		myJobList.add(myJobList.getJob(1));
		assertEquals(1, myJobList.size());
	}

	/**
	 * Test if a user can remove a job.
	 */
	@Test
	public void testRemove() {
		myJobList.remove(myJobList.getJob(1));
		assertEquals(0, myJobList.size());
	}

	/**
	 * Test if a user can find index of a job.
	 * @throws ParseException
	 */
	@Test
	public void testFindIndex() throws ParseException {
		Job j2 = new Job(2, "04-02-16 9:00AM", "04-03-16 5:00PM", "Mount Rainier", "The volunteers will repair a bridge.", 0, 0, 5);
		myJobList.add(j2);
		assertEquals(0, myJobList.findIndex(j2));
	}

	/**
	 * Test the size of a job list.
	 * @throws ParseException
	 */
	@Test
	public void testSize() throws ParseException {
		assertEquals(0, myJobList.size());
		myJobList.add(new Job(3, "02-22-16 1:00PM", "02-22-16 4:00PM", "Dash Point", "The volunteers will help clean the beach.", 5, 0, 0));
		assertEquals(1, myJobList.size()); 	
	}

	//    /**
	//     * Test if the user can get a summary of the job list.
	//     * @throws ParseException
	//     */
	//    @Test
	//    public void testGetSummaries() throws ParseException {
	//    	Job j3 = new Job(3, "02-22-16 1:00PM", "02-22-16 4:00PM", "Dash Point", "The volunteers will help clean the beach.", 5, 0, 0);
	//    	myJobList.add(j3);	
	//    	//assertEquals("Job: " + "3" + " | Park: " + "Dash Point" + " | Start: " + "02-22-16 1:00PM" + " | End: " + "02-22-16 4:00PM", myJobList.getSummaries());
	//    	assertEquals(myJobList.getJob(3).getSummary(), myJobList.getSummaries());
	//    }

	/**
	 * Test if a job ID been taken.
	 * @throws ParseException
	 */
	@Test
	public void TestIsJobIDTaken() throws ParseException {
		Job j4 = new Job(4, "03-01-16 2:00PM", "03-01-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0);
		myJobList.add(j4);
		assertTrue(myJobList.isJobIDtaken(j4.getJobID()));
		Job j5 = new Job(4, "03-22-16 2:00PM", "03-22-16 4:00PM", "South Park", "The volunteers will help clean the beach.", 3, 1, 1);
		myJobList.add(j5);
		assertTrue(myJobList.isJobIDtaken(j5.getJobID()));
	}

	//    @Test 
	//    public void testGetSummariesMyPark() {
	//    	
	//    }
	//    
	//    @Test
	//    public void testGetSummariesMyVolunteerJobs() {
	//    	
	//    }
	//    
	/**
	 * Test Business Rule 1: A job may not be added if the total number of pending job is currently 30.
	 * @throws ParseException
	 */
	@Test
	public void testHasMaxJobs() throws ParseException {

		//Test if the job list is less than 30

		myJobList.add(new Job(1, "03-01-16 2:00PM", "03-01-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0));

		for (int i = 2; i <= 30; i++) {
			myJobList.add(new Job(i, "03-01-16 2:00PM", "03-01-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0));
		}

		assertTrue(myJobList.hasMaxJobs());

		//Test if the job list is more than 30
		myJobList.add(new Job(31, "03-01-16 2:00PM", "03-01-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0));
		assertFalse(myJobList.hasMaxJobs());
	}

	/**
	 * Test Business Rule #2:
	 * Test if there is already the maximum number of jobs during the week of the proposed
	 * @throws ParseException 
	 */
	@Test
	public void testHasMaxJobsInWeek() throws ParseException {
		
		myJobList.add(new Job(1, "03-01-16 2:00PM", "03-01-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0));
		myJobList.add(new Job(2, "03-01-17 2:00PM", "03-01-17 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0));
		myJobList.add(new Job(3, "03-01-18 2:00PM", "03-01-18 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0));
		myJobList.add(new Job(4, "03-01-19 2:00PM", "03-01-19 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0));
		myJobList.add(new Job(5, "03-01-20 2:00PM", "03-01-20 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0));
		//add another job between this five days should return false
		myJobList.add(new Job(6, "03-01-17 3:00PM", "03-01-17 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0));
		assertFalse(myJobList.hasMaxJobsInWeek("03-01-17 3:00PM", "03-01-17 4:00PM"));
	}

	/**
	 * Test Business Rule #7: A volunteer may not sign for two jobs on the same day.
	 * @throws ParseException
	 */
	@Test
	public void testHasJobOnSameDay() throws ParseException {
		Volunteer v0 = new Volunteer("Weiwei", "Shi", "wshi@uw.edu", "911");
		Job job0 = new Job(1, "03-01-16 2:00PM", "03-01-16 4:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);
		job0.addLightVolunteer(v0);
		myJobList.add(job0);
		assertTrue(myJobList.hasJobOnSameDay(v0, job0));

		Job job1 = new Job(1, "03-01-16 3:00PM", "03-01-16 5:00PM", "South Park", "The volunteers will help pickup trash on the trails.", 3, 3, 3);
		job1.addLightVolunteer(v0);
		myJobList.add(job1);
		assertTrue(myJobList.hasJobOnSameDay(v0, job1));
	}

	/**
	 * Test two objects if there are the same.
	 * @throws ParseException
	 */
	@Test
	public void testEquals() throws ParseException {
		Job j1 = new Job(1, "03-01-16 2:00PM", "03-01-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0);
		myJobList.add(j1);
		Job j2 = new Job(1, "03-01-16 2:00PM", "03-01-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0);
		myJobList2.add(j2);
		assertTrue(myJobList.equals(myJobList2));

	}


}
