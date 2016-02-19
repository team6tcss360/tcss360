package model;
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

	//Constants
	public static final int MAX_JOBS = 30;
	
	public static final int MAX_JOBS_IN_WEEK = 5;

	public static final int MAX_JOB_LENGTH = 2;

	public static final int MAX_SCHEDULING_IN_FUTURE = 90;
	
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
	public JobList(ArrayList<Job> inputArrayList) {
		jobs = inputArrayList;
	}

	/**
     * @param inputJob to add to the ArrayList
	 * @throws ParseException if invalid date format
     */
	public void add(Job inputJob) throws ParseException {
		if(inputJob == null) {
			System.out.println("Invalid Job!");
		}
		String startDate = formatDate(inputJob.getStartDate());
		String endDate = formatDate(inputJob.getStartDate());
		
		//check all business rules before adding job
		if (passesBusinessRules(startDate, endDate)) {
		    jobs.add(inputJob);
		}
	}
	
	/**
	 * @return true if all business rules pass
     * @throws ParseException if invalid date format
     */
	public boolean passesBusinessRules(String inputStartDate, String intputEndDate) throws ParseException {
	    if (!hasMaxJobs() 
	            && !hasMaxJobsInWeek(inputStartDate, intputEndDate) 
	            && hasValidDuration(inputStartDate, intputEndDate) 
                && !hasEndBeforeStart(inputStartDate, intputEndDate) 
                && !isTooFarInFuture(inputStartDate) 
                && !hasPastDate(inputStartDate) ) {
            return true;
        }
	    return false;
	}
	
    /**
     * @return true if all business rules pass for the edit
     * @throws ParseException if invalid date format
     */
    @SuppressWarnings("unchecked")
    public boolean passesBusinessRulesEdit(Job inputJob, String inputStartDate, String inputEndDate) throws ParseException {
        JobList tempJobs = new JobList((ArrayList<Job>) jobs.clone()); //shallow copy
        tempJobs.remove(inputJob); //don't want to double count edited job
        if (!tempJobs.hasMaxJobs() 
                && !tempJobs.hasMaxJobsInWeek(inputStartDate, inputEndDate) 
                && tempJobs.hasValidDuration(inputStartDate, inputEndDate) 
                && !tempJobs.hasEndBeforeStart(inputStartDate, inputEndDate) 
                && !tempJobs.isTooFarInFuture(inputStartDate) 
                && !tempJobs.hasPastDate(inputStartDate) ) {
            return true;
        }
        return false;
    }

	/**
	 * @param inputJob to remove from the ArrayList
	 */
	public void remove(Job inputJob) {
		int index = findIndex(inputJob);
		if(index == -1) {
			System.out.println("Job doesn't exist");
		} else {
			jobs.remove(index);
		}
	}

	/**
	 * @return the Job's index in the ArrayList.
	 */
	public int findIndex(Job inputJob) {
		for(int i = 0; i < jobs.size(); i++) {
			if(jobs.get(i).equals(inputJob)) {
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
     * Gets summaries for all the jobs that are not in the past.
     */
    public String getSummaries() {
        String str = "";
        for(int i = 0; i < jobs.size(); i++) {
            Job currentJob = jobs.get(i);
            if (!currentJob.isInPast()) {
                str += currentJob.getSummary() + "\n";
            }
        }
        return str;
    }
    
    /**
     * Gets a list of summaries only for parks that the User is Park Manager of.
     * 
     * @param inputParkList the ParkList for parks to check
     * @param inputParkManager the User that is the Park Manager
     * @return summaries for parks that the User is Park Manager of.
     */
    public String getSummariesMyParks(ParkList inputParkList, ParkManager inputParkManager) {
        String str = "";
        for(int i = 0; i < jobs.size(); i++) {
            Job currentJob = jobs.get(i);
            //check if they are park manager for that job and it is not in the past
            if (currentJob.isParkManager(inputParkList, inputParkManager) && !currentJob.isInPast()) {
                str += jobs.get(i).getSummary() + "\n"; //add job if they are
            }
        }
        return str;
    }
    
    /**
     * Gets a list of summaries only for jobs that the User is signed up for.
     * 
     * @param inputVolunteer the User to get jobs for
     * @return summaries for jobs that the User is signed up for.
     */
    public String getSummariesMyVolunteerJobs(Volunteer inputVolunteer) {
        String str = "";
        for(int i = 0; i < jobs.size(); i++) {
            Job currentJob = jobs.get(i);
            //check if they are volunteered for that job and it is not in the past
            if (currentJob.isVolunteer(inputVolunteer) && !currentJob.isInPast()) {
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
	 * Business rule #1: A job may not be added if the total number of pending job is currently 30 or more.
	 */
	public boolean hasMaxJobs() {		
		return  jobs.size() >= MAX_JOBS;
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
	
	//Business rule #4
	/**
	 * Business rule #4: A job may not be scheduled that lasts more than two days.
	 * @throws ParseException if invalid date format
	 */
	public boolean hasValidDuration(String inputStartDate, String inputEndDate) throws ParseException {
	    GregorianCalendar startTemp = convertToCalender(inputStartDate);
        GregorianCalendar endTemp = convertToCalender(inputEndDate);
        zeroOutTime(startTemp);
		startTemp.add(Calendar.DAY_OF_MONTH, MAX_JOB_LENGTH);
        if (endTemp.after(startTemp)) {
            return false;
        }
        return true;
	}
	
	/**
     * Business rule #4B: A job may not end before it starts.
	 * @throws ParseException if invalid date format
     */
    public boolean hasEndBeforeStart(String inputStartDate, String inputEndDate) throws ParseException {
        GregorianCalendar startTemp = convertToCalender(inputStartDate);
        GregorianCalendar endTemp = convertToCalender(inputEndDate);
        if (endTemp.before(startTemp)) {
            return true;
        }
        return false;
    }
	
    //Business rule #5
	/**
	 * Business rule #5 A job may not be added that is in the more than 90 days in the future. 
	 * @throws ParseException if invalid date format
	 */
	public boolean isTooFarInFuture(String inputStartDate) throws ParseException {
	    GregorianCalendar startTemp = convertToCalender(inputStartDate);
        GregorianCalendar now = new GregorianCalendar();
		now.add(Calendar.DAY_OF_MONTH, MAX_SCHEDULING_IN_FUTURE);
        if (startTemp.after(now)) {
            return true;
        }
		return false;
	}
	
	//Business rule #6
	/**
	 * Business rule #6: A volunteer may not sign up for a job that has passed.
	 * @throws ParseException if invalid date format
	 */
	public boolean hasPastDate(String inputStartDate) throws ParseException {
	    GregorianCalendar startTemp = convertToCalender(inputStartDate);
        GregorianCalendar now = new GregorianCalendar();
        if (startTemp.before(now)) {
			return true;
		}
		return false;
	}
	
	//Business rule #7
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
     * Converts from GregorianCalendar to an American style date format.
     * 
     * @param inputCalendar
     * @return formatted date as String in MM-dd-yy h:mma format
     */
    public String formatDate(GregorianCalendar inputCalendar){
        String formattedDate = DATE_FORMAT.format(inputCalendar.getTime());
        return formattedDate;
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
    public boolean equals(Object inputJobList) {
        if (inputJobList == null) { //check null
            return false;
        }
        if (this.getClass() != inputJobList.getClass()) { //check class
            return false;
        }
        JobList otherJobList = (JobList) inputJobList;
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
