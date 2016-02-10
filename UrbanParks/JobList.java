import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

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
	
	public static final int MAX_DURATION = 2;
	
	public static final int MAX_POST_TIME = 3;
	
	/**
	 * An Array of Jobs.
	 */
	ArrayList<Job> jobs;

	public JobList() {
		jobs = new ArrayList<Job>();
	}

	public JobList(ArrayList<Job> inputArray) {
		jobs = inputArray;
	}

	public void add(Job job) {
		if(job == null) {
			System.out.println("Invalid Job yo!");
		}
		jobs.add(job);
	}

	public void remove(Job job) {
		int index = findIndex(job);
		if(index == -1) {
			System.out.println("Job doesn't exist");
		} else {
			jobs.remove(index);
		}
	}


	public int findIndex(Job job) {
		for(int i = 0; i < jobs.size(); i++) {
			if(jobs.get(i).equals(job)) {
				return i;
			}
		}
		return -1;
	}

	public Job getJob(int jobID) {
		for(int i = 0; i < jobs.size(); i++) {
			if(jobs.get(i).getJobID() == jobID) {
				return jobs.get(i);
			}
		}
		return null;
	}

	public int size(){
		return jobs.size();
	}

	public Job getJobAt(int inputIndex){
		return jobs.get(inputIndex);
	}

	/**
	 * ToString method for the Array list.
	 */
	public String toString() {
		String str = "";
		for(int i = 0; i < jobs.size(); i++) {
			str += jobs.get(i).getSummary() + "\n";
		}
		return str;
	}

	public ArrayList<Job> getArrayList() {
		// TODO Auto-generated method stub
		return jobs;
	}

	//Business rule #1
	/**
	 * Business rule #1: A job may not be added if the total number of pending job is currently 30.
	 */
	public boolean hasMaxJobs(JobList inputJobList) {		
		return  inputJobList.size() < MAX_JOBS;
	}

	//Business rule #2
	//public boolean hasMaxJobsInWeek(){

	//}
	
	/**
	 * Business rule #4: A job may not be scheduled that lasts more than two days
	 */
	public boolean hasValidDuration(Job inputJob) {
		GregorianCalendar invalid = (GregorianCalendar) inputJob.getStartDate().clone();
		invalid.add(GregorianCalendar.DATE, MAX_DURATION);
		
		return inputJob.getEndDate().before(invalid);
	}
	
	/**
	 * Business rule #5 part A: A job may not be added that is in the past more than 3 months.
	 */
	public boolean past3MonthTest(Job inputJob) {
		
		GregorianCalendar now = new GregorianCalendar();
		if (inputJob.getStartDate().before(now)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Business rule #5 part B: A job may not be added that is in the more than 3 months for the future. 
	 */
	public boolean future3MonthTest(Job inputJob) {
		GregorianCalendar then = new GregorianCalendar();
		then.add(GregorianCalendar.MONTH, MAX_POST_TIME);
		
		return inputJob.getStartDate().before(then);
	}
	
	/**
	 * Business rule #6: A volunteer may not sign up for a job that has passed.
	 */
	public boolean hasPastDate(Job inputJob) {
		if (inputJob.isPast()) {
			return false;
		}
		return true;
	}
	
//	/**
//	 * Business rule #7: A volunteer may not sign for two jobs on the same day.
//	 */
//	public boolean hasJobOnSameDay(String inputEmail, Job inputJob, JobList inputJobList) {
//		GregorianCalendar startDate = inputJob.getStartDate();
//		GregorianCalendar endDate = inputJob.getEndDate();
//		
//		for(Job tempJob : inputJobList.getArrayList()) {
//			for(Volunteer tempVolunter : tempJob.getVolunteerList()) {
//				if(tempVolunter.get(0).equals(inputEmail)){
//					if(startDate.equals(tempJob.getStartDate())) {
//						return true;
//					}
//					if(startDate.equals(tempJob.getEndDate())) {
//						return true;
//					}
//					if(endDate.equals(tempJob.getStartDate())) {
//						return true;
//					}
//					if(endDate.equals(tempJob.getEndDate()) {
//						
//					}
//				}
//			}
//		}
//		
//	}
	
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
        String allJobs = "";
        for(int i = 0; i < jobs.size(); i++) { //check each job by toString
            allJobs += jobs.get(i).toString();
        }
        return allJobs.hashCode();
    }
}
