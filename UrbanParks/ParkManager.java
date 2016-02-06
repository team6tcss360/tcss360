import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
     * Creates a ParkManager through the User constructor.
     */
    public ParkManager(String inputFirstName, String inputLastName, String inputEmail, String inputPhone,
            int inputUserID) {
        super(inputFirstName, inputLastName, inputEmail, inputPhone, inputUserID);
    }

    /**
     * Returns a list of job summaries in the parks that they manage.
     * 
     * @return Summaries of jobs as a String.
     */
    public String getJobs(JobList inputJobList) {
    	StringBuilder jobs = new StringBuilder();
    	for(int i =0; i< inputJobList.size(); i++){
//    		Need to access Job info to see if it matches
//    		if(inputJobList.getJobAt(i).get){
//    			
//    		}
    	}
        return jobs.toString();
    }
}
