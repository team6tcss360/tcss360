import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * The class that contains ParkManager specific methods.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class ParkManager extends User {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -5885352666198015690L;
    
    /**
     * 
     */
    private ArrayList<Job> managerJobs;
    
    /**
     * Creates a ParkManager through the User constructor.
     */
    public ParkManager(String inputFirstName, String inputLastName, String inputEmail, String inputPhone) {
        super(inputFirstName, inputLastName, inputEmail, inputPhone);
        managerJobs = new ArrayList<Job>();
    }

    /**
     * Returns a list of job summaries in the parks that they manage.
     * 
     * @return Summaries of jobs as a String.
     */
    public String getJobs(JobList inputJobList, ParkList inputParkList) {
    	StringBuilder jobs = new StringBuilder();
    	for(int i =0; i< inputJobList.size(); i++){
    		Job currentJob = inputJobList.getJob(i);
    		String parkName = currentJob.getParkName();
    		for(int j = 0; j< inputParkList.size(); j++){
    			
    		}
    	}
        return jobs.toString();
    }
    
    /**
     * Adds a Job to the ParkManager's jobList
     * 
     * @param inputJob Job to be added.
     */
    public void addJob(Job inputJob) {
    	managerJobs.add(inputJob);
    }
    
    /**
     * Removes job from Park Mannager's list of jobs
     * 
     * @param inputJob
     */
    public void removeJob(Job inputJob) {
    	if(inputJob==null || !managerJobs.contains(inputJob)){
    		//can't remove
    	}else{
    		int toRemove = managerJobs.indexOf(inputJob);
        	managerJobs.remove(toRemove);
    	}
    	
    }
    
    /**
     * Get the jobs that a ParkManager has created
     * 
     * @return ArrayList<Job>
     */
    public ArrayList<Job> getCurrentJobs() {
		return managerJobs;	
    }
    
    /**
     * Returns the amount of jobs a Park Manager has created.
     * @return
     */
    public int jobCount() {
    	return managerJobs.size();
    }
    
    
}
