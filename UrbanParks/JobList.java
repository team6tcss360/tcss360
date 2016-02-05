import java.awt.List;
import java.util.ArrayList;

/**
 * Contains a collection of Urban Parks jobs.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class JobList {
	ArrayList<Job> myJobs;
	public JobList() {
		myJobs = new ArrayList<Job>();
	}
    public void add(Job job) {
    	if(job == null) {
    		System.out.println("Invalid Job yo!");
    	}
    	myJobs.add(job);
    }
    
    public void remove(Job job) {
    	int index = findIndex(job);
    	if(index == -1) {
    		System.out.println("Job doesn't exist");
    	} else {
    		myJobs.remove(index);
    	}
    }
    
    
    public int findIndex(Job job) {
    	for(int i = 0; i < myJobs.size(); i++) {
    		if(myJobs.get(i).equals(job)) {
    			return i;
    		}
    	}
    	return -1;
    }
<<<<<<< HEAD
    public Job getJob(int jobID) {
    	for(int i = 0; i < myJobs.size(); i++) {
    		if(myJobs.get(i).getID() == jobID) {
    			return myJobs.get(i);
    		}
    	}
    	return null;
    }
    public String toString() {
    	String ret = " ";
    	for(int i = 0; i < myJobs.size(); i++) {
    		ret += myJobs.get(i);
    	}
    	return ret;
    }
=======
    
    /**
     * ToString method for the Array list.
     */
    public String toString() {
    	String str = " ";
    	for(int i = 0; i < myJobs.size(); i++) {
    		str += myJobs.toString() + "\n";
    	}
    	return str;
    }
    
>>>>>>> origin/master
}
