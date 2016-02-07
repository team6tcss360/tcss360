import java.io.Serializable;
import java.util.ArrayList;

/**
 * The class that contains volunteer specific methods.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class Volunteer extends User implements Serializable {

	/**
     * The serial version UID.
     */
    private static final long serialVersionUID = 6857145170865256803L;
    
    /**
	 * 
	 */
	private ArrayList<Job> volunteerJobs;
	
    /**
     * Creates a volunteer through the User constructor.
     */
    public Volunteer(String inputFirstName, String inputLastName, 
            String inputEmail, String inputPhone) {
        super(inputFirstName, inputLastName, inputEmail, inputPhone);
        volunteerJobs = new ArrayList<Job>();
    }

    /**
     * Returns a list of jobs that the User is signed up for.
     */
    public String getJobs() {
    	
        return null;
    }
    
    /**
     * Adds a job to Volunteer's list of jobs.
     * 
     * @param inputJob
     */
    public void addJob(Job inputJob) {
    	volunteerJobs.add(inputJob);
    }
    
    /**
     * Removes job from Volunteer's list of jobs
     * 
     * @param inputJob
     */
    public void removeJob(Job inputJob) {
    	if(inputJob==null|| !volunteerJobs.contains(inputJob)) {
    		//can't remove
    	}else {
    		int toRemove = volunteerJobs.indexOf(inputJob);
    		volunteerJobs.remove(toRemove);
    	}
    }
    
    /**
     * Get the jobs that a Volunteer has signed up for
     * 
     * @return ArrayList<Job>
     */
    public ArrayList<Job> getCurrentJobs() {
		return volunteerJobs;
		
    }
    
    /**
     * Returns the amount of jobs a Volunteer is signed up for.
     * @return
     */
    public int jobCount() {
    	return volunteerJobs.size();
    }
    
    
    
    
}
