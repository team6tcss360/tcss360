import java.util.ArrayList;

/**
 * Contains a collection of Urban Parks jobs.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class JobList {
     
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
    	String str = " ";
    	for(int i = 0; i < jobs.size(); i++) {
    		str += jobs.get(i).toString() + "\n";
    	}
    	return str;
    }

    public ArrayList<Job> getArrayList() {
        // TODO Auto-generated method stub
        return jobs;
    }
}
