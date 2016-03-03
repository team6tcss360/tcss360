/**
 * 
 */
package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Job;
import model.JobList;
import model.Park;
import model.ParkList;
import model.ParkManager;
import model.Volunteer;

/**
 * Tests for JobsList class.
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 19, 2016
 */
public class JobListTest {

	private JobList jobList1;
	private JobList jobList2;
	private JobList jobList3;
	private Job j2;
	private Job j1;
	private Job j3;
	private Job j4;
	private Job j5;
	private Job j7;

	private String badStart;
	private String badEnd;
	private String goodStart;
	private String goodEnd;
	private String pastStart;
	private String futureStart;
	private String job1Start;
	private String job1End;
	
	private Job badJob;
	private Job mJob;
	private JobList maxJobs;

	private ParkManager pm1;
	private Park park1;
	private ParkList pList1;
	private Volunteer v1;

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
		badStart = "03-10-16 2:00PM";
		pastStart = "02-27-16 2:00PM";
		futureStart = "12-25-16 2:00PM";
		badEnd = "03-12-16 2:00PM";
		goodStart = badStart;
		goodEnd = "03-11-16 1:00PM";

		jobList1 = new JobList();
		jobList2 = new JobList();
		jobList3 = new JobList();
		maxJobs = new JobList();
		
		
		mJob = new Job(5, "04-12-16 2:00PM", "04-12-16 4:00PM", "South Park", "The volunteers will help clean the beach.", 3, 1, 1);
		Job[] jobArr = new Job[29];
		for(int i = 0; i< 5; i++){
			jobArr[i] = new Job(1, "03-08-16 2:00PM", "03-08-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0);
		}
		for(int i = 5; i<10; i++){
			jobArr[i] = new Job(4, "03-15-16 2:00PM", "03-15-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0);
		}
		
		for(int i = 10; i< 15 ; i++){
			jobArr[i] = new Job(5, "03-22-16 2:00PM", "03-22-16 4:00PM", "South Park", "The volunteers will help clean the beach.", 3, 1, 1);
		}
		
		for(int i = 15; i < 20; i++){
			jobArr[i] = new Job(5, "03-29-16 2:00PM", "03-29-16 4:00PM", "South Park", "The volunteers will help clean the beach.", 3, 1, 1);
		}
		for(int i = 20; i< 25; i++){
			jobArr[i] = new Job(5, "04-05-16 2:00PM", "04-05-16 4:00PM", "South Park", "The volunteers will help clean the beach.", 3, 1, 1);
		}
		
		for(int i = 25; i< 29; i++){
			jobArr[i] = new Job(5, "04-12-16 2:00PM", "04-12-16 4:00PM", "South Park", "The volunteers will help clean the beach.", 3, 1, 1);
		}
		
		badJob = new Job(1, "03-08-16 2:00PM", "03-08-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0);
		
		job1Start = "03-08-16 2:00PM";
		job1End = "03-08-16 4:00PM";
		j1 = new Job(1, job1Start, job1End, "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0);
		j2 = new Job(2, "03-10-16 9:00AM", "03-10-16 5:00PM", "Mount Rainier", "The volunteers will repair a bridge.", 0, 0, 5);
		j3 = new Job(3, "03-11-16 1:00PM", "03-12-16 4:00PM", "Dash Point", "The volunteers will help clean the beach.", 5, 0, 0);
		j4 = new Job(4, "03-13-16 2:00PM", "03-13-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0);
		j5 = new Job(5, "03-22-16 2:00PM", "03-22-16 4:00PM", "South Park", "The volunteers will help clean the beach.", 3, 1, 1);
		j7 = new Job(7, job1Start, job1End, "Mount Rainier", "Volunteers move stuff.", 5,2,3);
//		jobArray= {j1, j2, j3, j4, j5};
		pm1 = new ParkManager("Michael", "Ford", "fordm13@uw.edu", "9494125944");
		
		v1 = new Volunteer("Chris", "Vishoot", "cshoot@uw.edu", "2063456677");
		park1 = new Park("Point Defiance", "Tacoma", "Michael", "Ford");
		pList1 = new ParkList();
		for(int i = 0; i < jobArr.length; i++){
			maxJobs.add(jobArr[i]);
		}
	}



	/**
	 * Test method for {@link model.JobList#add(model.Job)}.
	 * @throws ParseException
	 */
	@Test
	public void testAdd() throws ParseException {
		jobList1.add(j1);
		assertEquals(1, jobList1.getArrayList().size());
		assertFalse(j2.equals(jobList1.getJobAt(0)));
	}



	/**
	 * Test method for {@link model.JobList#passesBusinessRulesEdit(model.Job, java.lang.String, java.lang.String)}.
	 * @throws ParseException 
	 */
	@Test
	public void testPassesBusinessRulesEdit() throws ParseException {
		assertTrue(jobList1.passesBusinessRulesEdit(j1, job1Start, job1End));
		assertFalse(jobList1.passesBusinessRulesEdit(j1, job1End, job1Start));
	}

	/**
	 * Test if a user can remove a job.
	 * @throws ParseException
	 * Test method for {@link model.JobList#remove(model.Job)}.
	 */
	@Test
	public void testRemove() throws ParseException {
		jobList1.add(j1);
		jobList1.add(j3);
		//        for(Job j: jobList1.getArrayList()){
		//        	System.out.println(j.toString());
		//        }
		assertEquals(2, jobList1.getArrayList().size());
		jobList1.remove(j3);
		assertEquals(1, jobList1.getArrayList().size());
	}

	/**
	 * Test method for {@link model.JobList#findIndex(model.Job)}.
	 * @throws ParseException 
	 */
	@Test
	public void testFindIndex() throws ParseException {
		jobList1.add(j2);
		jobList1.add(j1);
		assertEquals(0, jobList1.findIndex(j2));
		assertNotEquals(0, jobList1.findIndex(j1));
	}



	/**
	 * Test method for {@link model.JobList#getJobAt(int)}.
	 * @throws ParseException 
	 */
	@Test
	public void testGetJobAt() throws ParseException {
		jobList1.add(j1);
		jobList1.add(j2);
		jobList1.add(j3);
		jobList1.add(j4);
		assertTrue(jobList1.getJobAt(2).equals(j3));
		assertFalse(jobList1.getJobAt(2).equals(j2));

	}



	/**
	 * Test method for {@link model.JobList#getSummariesMyParks(model.ParkList, model.ParkManager)}.
	 * @throws ParseException 
	 */
	@Test
	public void testGetSummariesMyParks() throws ParseException {
		jobList1.add(j1);
		jobList1.add(j2);
		jobList1.add(j3);
		jobList1.add(j4);
		jobList1.add(j5);
		
		jobList2.add(j1);
		jobList2.add(j2);
		jobList2.add(j3);
		jobList2.add(j4);
		jobList2.add(j5);
		
		
		pList1.add(park1);
		String sum = jobList1.getSummariesMyParks(pList1, pm1);
		String sum2 = jobList2.getSummariesMyParks(pList1, pm1);
		System.out.println(sum);
		
		assertEquals(sum, sum2);
//		fail("not yet implemented");//TODO
	}

	/**
	 * Test method for {@link model.JobList#getSummariesMyVolunteerJobs(model.Volunteer)}.
	 * @throws ParseException 
	 */
	@Test
	public void testGetSummariesMyVolunteerJobs() throws ParseException {
		
		j1.addMedVolunteer(v1);
		
		jobList1.add(j1);
		jobList2.add(j1);
		String summaries = jobList1.getSummariesMyVolunteerJobs(v1);
		assertEquals(summaries, jobList2.getSummariesMyVolunteerJobs(v1));
	}



	/**
	 * Test method for {@link model.JobList#hasMaxJobs()}.
	 * @throws ParseException 
	 */
	@Test
	public void testHasMaxJobs() throws ParseException {
		assertFalse(maxJobs.hasMaxJobs());
		maxJobs.add(mJob);
		assertTrue(maxJobs.hasMaxJobs());
	}

	/**
	 * Test method for {@link model.JobList#hasMaxJobsInWeek(java.lang.String, java.lang.String)}.
	 * @throws ParseException 
	 */
	@Test
	public void testHasMaxJobsInWeek() throws ParseException {
		jobList1.add(j1);
		jobList1.add(j2);
		jobList1.add(j3);
		jobList1.add(j1);
		assertFalse(jobList1.hasMaxJobsInWeek(goodStart, goodEnd));
		jobList1.add(j2);
		assertTrue(jobList1.hasMaxJobsInWeek(goodStart, goodEnd));
	}

	/**
	 * Test method for {@link model.JobList#hasValidDuration(java.lang.String, java.lang.String)}.
	 * @throws ParseException 
	 */
	@Test
	public void testHasValidDuration() throws ParseException {
		assertFalse(jobList1.hasValidDuration(badStart, badEnd));
		assertTrue(jobList1.hasValidDuration(goodStart, goodEnd));
	}

	/**
	 * Test method for {@link model.JobList#hasEndBeforeStart(java.lang.String, java.lang.String)}.
	 * @throws ParseException 
	 */
	@Test
	public void testHasEndBeforeStart() throws ParseException {
		assertTrue(jobList1.hasEndBeforeStart(goodEnd, goodStart));
		assertFalse(jobList1.hasEndBeforeStart(goodStart, goodEnd));
	}

	/**
	 * Test method for {@link model.JobList#isTooFarInFuture(java.lang.String)}.
	 * @throws ParseException 
	 */
	@Test
	public void testIsTooFarInFuture() throws ParseException {
		assertTrue(jobList1.isTooFarInFuture(futureStart));
		assertFalse(jobList1.isTooFarInFuture(goodStart));

	}

	/**
	 * Test method for {@link model.JobList#hasPastDate(java.lang.String)}.
	 * @throws ParseException 
	 */
	@Test
	public void testHasPastDate() throws ParseException {
		assertFalse(jobList1.hasPastDate(goodStart));
		assertTrue(jobList1.hasPastDate(pastStart));
	}

	/**
	 * Test method for {@link model.JobList#hasJobOnSameDay(model.Volunteer, model.Job)}.
	 * @throws ParseException 
	 */
	@Test
	public void testHasJobOnSameDay() throws ParseException {
		
		j1.addLightVolunteer(v1);
		
		jobList1.add(j1);
		assertTrue(jobList1.hasJobOnSameDay(v1, j7));
		assertFalse(jobList1.hasJobOnSameDay(v1, j2));
	}

	/**
	 * Test method for {@link model.JobList#isJobIDtaken(int)}.
	 * @throws ParseException 
	 */
	@Test
	public void testIsJobIDtaken() throws ParseException {

		assertFalse(jobList1.isJobIDtaken(j1.getJobID()));
		jobList1.add(j1);
		assertTrue(jobList1.isJobIDtaken(badJob.getJobID()));
	}


	/**
	 * Test method for {@link model.JobList#equals(java.lang.Object)}.
	 * @throws ParseException 
	 */
	@Test
	public void testEqualsObject() throws ParseException {
		jobList1.add(j1);
		jobList2.add(j1);
		jobList3.add(j2);
		assertTrue(jobList1.equals(jobList2));
		assertFalse(jobList1.equals(jobList3));
	}


	//	/**
	//	 * Test method for {@link model.JobList#formatDate(java.util.GregorianCalendar)}.
	//	 */
	//	@Test
	//	public void testFormatDate() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.JobList#zeroOutTime(java.util.GregorianCalendar)}.
	//	 */
	//	@Test
	//	public void testZeroOutTime() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.JobList#toString()}.
	//	 */
	//	@Test
	//	public void testToString() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.JobList#getJob(int)}.
	//	 */
	//	@Test
	//	public void testGetJob() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.JobList#size()}.
	//	 */
	//	@Test
	//	public void testSize() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.JobList#getSummaries()}.
	//	 */
	//	@Test
	//	public void testGetSummaries() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.JobList#getArrayList()}.
	//	 */
	//	@Test
	//	public void testGetArrayList() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.JobList#hashCode()}.
	//	 */
	//	@Test
	//	public void testHashCode() {
	//		fail("Not yet implemented"); 
	//	}

	//	/**
	//	 * Test method for {@link model.JobList#JobList(java.util.ArrayList)}.
	//	 */
	//	@Test
	//	public void testJobListArrayListOfJob() {
	//		fail("Not yet implemented"); 
	//	}


	//	/**
	//	 * Test method for {@link model.JobList#convertToCalender(java.lang.String)}.
	//	 */
	//	@Test
	//	public void testConvertToCalender() {
	//		fail("Not yet implemented");
	//	}

	//	 /**
	//	  * Test method for {@link model.JobList#passesBusinessRules(java.lang.String, java.lang.String)}.
	//	  */
	//	 @Test
	//	 public void testPassesBusinessRules() {
	//		 fail("Not yet implemented"); 
	//	 }
}
