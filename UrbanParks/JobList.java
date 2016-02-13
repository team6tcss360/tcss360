import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Contains a collection of Urban Parks jobs.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class JobList {

	//Constant
	public static final int MAX_JOBS = 30;
	
	public static final int MAX_JOBS_IN_WEEK = 5;
	
	public static final int MAX_DURATION = 2;
	
	public static final int MAX_POST_TIME = 3;
	
	/**
     * The format to use on dates.
     */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yy h:mma");

	/**
	 * An Array of Jobs.
	 */
	ArrayList<Job> jobs;

	/**
	 * Construct an empty job list.
	 */
	public JobList() {
		jobs = new ArrayList<Job>();
	}

	/**
	 * Reconstructs the JobList from the inputArray.
	 */
	public JobList(ArrayList<Job> inputArray) {
		jobs = inputArray;
	}

	/**
     * @param job to add to the ArrayList
     */
	public void add(Job job) {
		if(job == null) {
			System.out.println("Invalid Job yo!");
		}
		jobs.add(job);
	}

	/**
	 * @param job to remove from the ArrayList
	 */
	public void remove(Job job) {
		int index = findIndex(job);
		if(index == -1) {
			System.out.println("Job doesn't exist");
		} else {
			jobs.remove(index);
		}
	}

	/**
	 * @return the Job's index in the ArrayList.
	 */
	public int findIndex(Job job) {
		for(int i = 0; i < jobs.size(); i++) {
			if(jobs.get(i).equals(job)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * @param inputJobID of the Job object
	 * @return the Job object that contains the input jobID
	 */
	public Job getJob(int inputJobID) {
		for(int i = 0; i < jobs.size(); i++) {
			if(jobs.get(i).getJobID() == inputJobID) {
				return jobs.get(i);
			}
		}
		return null;
	}

	/**
	 * @return current number of jobs
	 */
	public int size(){
		return jobs.size();
	}

	/**
	 * @param inputIndex of job
	 * @return Job object at the index
	 */
	public Job getJobAt(int inputIndex){
		return jobs.get(inputIndex);
	}
	
	/**
     * Gets summaries for all the jobs.
     */
    public String getSummaries() {
        String str = "";
        for(int i = 0; i < jobs.size(); i++) {
            str += jobs.get(i).getSummary() + "\n";
        }
        return str;
    }
    
    /**
     * Gets a list of summaries only for parks that the User is Park Manager of.
     * 
     * @param inputParks the ParkList for parks to check
     * @param inputUser the User that is the Park Manager
     * @return summaries for parks that the User is Park Manager of.
     */
    public String getSummariesMyParks(ParkList inputParks, ParkManager inputUser) {
        String str = "";
        for(int i = 0; i < jobs.size(); i++) {
            Job currentJob = jobs.get(i);
            //check if they are park manager for that job
            if (currentJob.isParkManager(inputParks, inputUser)) {
                str += jobs.get(i).getSummary() + "\n"; //add job if they are
            }
        }
        return str;
    }
    
    /**
     * Gets a list of summaries only for jobs that the User is signed up for.
     * 
     * @param inputUser the User to get jobs for
     * @return summaries for jobs that the User is signed up for.
     */
    public String getSummariesMyVolunteerJobs(Volunteer inputUser) {
        String str = "";
        for(int i = 0; i < jobs.size(); i++) {
            Job currentJob = jobs.get(i);
            //check if they are volunteered for that job
            if (currentJob.isVolunteer(inputUser)) {
                str += jobs.get(i).getSummary() + "\n"; //add job if they are
            }
        } 
        if (str.compareTo("") == 0) {
            str = "You are not signed up for any jobs. \n";
        }
        return str;
    }

    /**
     * @return An ArrayList of all jobs in the JobList.
     */
	public ArrayList<Job> getArrayList() {
		return jobs;
	}

	//Business rule #1
	/**
	 * Business rule #1: A job may not be added if the total number of pending job is currently 30.
	 */
	public boolean hasMaxJobs() {		
		return  jobs.size() == MAX_JOBS;
	}

    //Business rule #2
	/**
	 * Checks if there is already the maximum number of jobs during the week of the proposed
	 * start and end dates.  
	 * @return true if max jobs in week is already met
	 */
	public boolean hasMaxJobsInWeek(String inputStartDate, String inputEndDate) 
	        throws ParseException {
	    int jobsInWeek = 0;
	    GregorianCalendar left = convertToCalender(inputStartDate);
	    GregorianCalendar right = convertToCalender(inputEndDate);
	    left.add(Calendar.DAY_OF_MONTH, -3);
	    zeroOutTime(left);
	    right.add(Calendar.DAY_OF_MONTH, 4);
	    zeroOutTime(right);
	    for (int i = 0; i < jobs.size(); i++) {
	        Job currentJob = jobs.get(i);
	        if (currentJob.getEndDate().after(left)
	                && currentJob.getStartDate().before(right)) {
	            jobsInWeek++;
	        }
	    }
	    if (jobsInWeek >= MAX_JOBS_IN_WEEK) {
	        return true;
	    }
        return false;
	}
	
//	/**
//	 * Business rule #4: A job may not be scheduled that lasts more than two days
//	 */
//	public boolean hasValidDuration(Job inputJob) {
//		GregorianCalendar invalid = (GregorianCalendar) inputJob.getStartDate().clone();
//		invalid.add(GregorianCalendar.DATE, MAX_DURATION);
//		
//		return inputJob.getEndDate().before(invalid);
//	}
//	
//	/**
//	 * Business rule #5 part B: A job may not be added that is in the more than 3 months for the future. 
//	 */
//	public boolean future3MonthTest(Job inputJob) {
//		GregorianCalendar then = new GregorianCalendar();
//		then.add(GregorianCalendar.MONTH, MAX_POST_TIME);
//		
//		return inputJob.getStartDate().before(then);
//	}
	
//	/**
//	 * Business rule #6: A volunteer may not sign up for a job that has passed.
//	 */
//	public boolean hasPastDate(Job inputJob) {
//		if (inputJob.isInPast()) {
//			return false;
//		}
//		return true;
//	}
	
	/**
	 * Business rule #7: A volunteer may not sign for two jobs on the same day.
	 */
	public boolean hasJobOnSameDay(Volunteer inputVolunteer, Job inputJob) {
		GregorianCalendar startDate = (GregorianCalendar) inputJob.getStartDate().clone();
		GregorianCalendar endDate = (GregorianCalendar) inputJob.getEndDate().clone();
		//zero out time, because we only care if they are on the same day
		zeroOutTime(startDate);
		zeroOutTime(endDate);
		
		for (int i = 0; i < jobs.size(); i++) { //test every job
		    Job testJob = jobs.get(i);
		    if(testJob.isVolunteer(inputVolunteer)) { //check if they are signed up
    		    //if they are signed up, get the dates for that job
		        GregorianCalendar testStartDate = (GregorianCalendar) testJob.getStartDate().clone();
    	        GregorianCalendar testEndDate = (GregorianCalendar) testJob.getEndDate().clone();
    	        zeroOutTime(testStartDate);
    	        zeroOutTime(testEndDate);
    	        
    	        //test if any start date or end date matches a job they are signed up for
    	        if (startDate.equals(testStartDate) || startDate.equals(testEndDate) 
    	                || endDate.equals(testStartDate) || endDate.equals(testEndDate)) {
    	            return true;
    	        }
		    }
		}
		return false;
	}
	 
	/**
	 * Checks if the jobID is already taken.
	 * @return true if yes, false if no
	 */
    public boolean isJobIDtaken(int inputJobID) {
        for(int i = 0; i < jobs.size(); i++) { //check each job by toString
            int myJobID = jobs.get(i).getJobID();
            if (myJobID == inputJobID) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Convert a string date to a GregorianCalender object.
     * @param theDate, MM-dd-yy h:mma (March 1st, 2016 at 9am is 03-01-16 9:00AM)
     * @return GregorianCalender formatted date.
     * @throws ParseException if invalid date format
     */
    public GregorianCalendar convertToCalender(String inputDate) throws ParseException {
        Date parsed = DATE_FORMAT.parse(inputDate);
        GregorianCalendar newCalendar = new GregorianCalendar();
        newCalendar.setTime(parsed);
        return newCalendar;     
    }
    
    /**
     * Sets the input calendar's hour, minute, second, and ms to 0.
     */
    protected void zeroOutTime(GregorianCalendar inputCalendar) {
        inputCalendar.set(Calendar.HOUR_OF_DAY, 0);
        inputCalendar.set(Calendar.MINUTE, 0);
        inputCalendar.set(Calendar.SECOND, 0);
        inputCalendar.set(Calendar.MILLISECOND, 0);
    }
	
	/**
     * @return full details for every job.
     */
    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < jobs.size(); i++) {
            str += jobs.get(i).toString() + "\n";
        }
        return str;
    }
    /**
     * @return Compares each job's toString methods in array's order.
     */
    @Override
    public boolean equals(Object inputJobs) {
        if (inputJobs == null) { //check null
            return false;
        }
        if (this.getClass() != inputJobs.getClass()) { //check class
            return false;
        }
        JobList otherJobList = (JobList) inputJobs;
        ArrayList<Job> otherJobs = otherJobList.getArrayList();
        if (jobs.size() != otherJobs.size()) { //check size
            return false;
        }
        for(int i = 0; i < jobs.size(); i++) { //check each job by toString
            String myJob = jobs.get(i).toString();
            String otherJob = otherJobs.get(i).toString();
            if (myJob.compareTo(otherJob) != 0) {
                return false;
            }
        }
        return true;
    }
    
	/**
     * @return all the jobs' toString's hashCode
     */
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
