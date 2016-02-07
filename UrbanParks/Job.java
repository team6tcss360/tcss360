import java.util.List;
import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Contains information for an Urban Parks job.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 4, 2016
 */
public class Job implements Serializable {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -2382757831956773518L;

    /**
     * A job's ID number.
     */
    private int jobID;
    
    /**
     * A job's start date.
     */
    private GregorianCalendar startDate;
    
    /**
     * A job's end date.
     */
    private GregorianCalendar endDate;
    
    /**
     * A job's park name.
     */
    private String parkName;
    
    /**
     * A job's details.
     */
    private String details;
    
    /**
     * A job's maximum number of light duty volunteers.
     */
    private int lightMax;
    
    /**
     * A job's current number of light duty volunteers.
     */
    private int lightCurrent;
    
    /**
     * A job's maximum number of medium duty volunteers.
     */
    private int medMax;
    
    /**
     * A job's current number of medium duty volunteers.
     */
    private int medCurrent;
    
    /**
     * A job's maximum number of heavy duty volunteers.
     */
    private int heavyMax;
    
    /**
     * A job's current number of heavy duty volunteers.
     */
    private int heavyCurrent;
    
    /**
     * A list of the job's volunteers.
     */
    private List<Volunteer> volunteerList;
    
    private boolean isPast;
    
    
    //Constructor
    /**
     * Constructor  
     * @param inputJobID
     * @param inputStartDate
     * @param inputEndDate
     * @param inputParkName
     * @param inputDetails
     * @param inputLightMax
     * @param inputMedMax
     * @param inputHeavyMax
     * @param inputVolunteerList
     */
    public Job(int inputJobID, String inputStartDate, String inputEndDate, String inputParkName, 
            String inputDetails, int inputLightMax, int inputMedMax, int inputHeavyMax, 
            List<Volunteer> inputVolunteerList) {
        jobID = inputJobID;
        
        startDate = convertToCalender(inputStartDate);
        endDate = convertToCalender(inputEndDate);
        
        parkName = inputParkName;
        details = inputDetails;
        
        lightMax = inputLightMax;
        lightCurrent = 0;
        
        medMax = inputMedMax;
        medCurrent = 0;
        
        heavyMax = inputHeavyMax;
        heavyCurrent = 0;
        
        isPast = false;
        
        
        //TODO input is currently an array of Strings with first name, then last name, then next first name, etc.
        List<Volunteer> volunteerList  = inputVolunteerList;
    }
   

	/*
     *-----------------------------------------------------------------------------------------------------------
     */
    //Setters
    /**
     * Set the current volunteer numbers for light job.
     * @param inputLightCurrent
     */
    public void setLightCurrent(int inputLightCurrent) {
    	lightCurrent = inputLightCurrent;
    }
    
    /**
     * Set the current volunteer numbers for medium job.
     * @param inputMedCurrent
     */
    public void setMedCurrent(int inputMedCurrent) {
    	medCurrent = inputMedCurrent;
    }
    
    /**
     * Set the current volunteer numbers for heavy job.
     * @param inputHeavyCurrent
     */
    public void setHeavyCurrent(int inputHeavyCurrent) {
    	heavyCurrent = inputHeavyCurrent;
    }
    
    /**
     * Set whether or not the start date is in the past.
     * @param inputIsPast
     */
    public void setIsPast(boolean inputIsPast) {
    	isPast = inputIsPast;
    }
    /**
     * Set the start date
     * @param inputDate
     */
    public void setStartDate(String inputDate) {
    	startDate = convertToCalender(inputDate);
    }
    /**
     * Set the end date
     * @param inputEndDate
     */
    public void setEndDate(String inputEndDate) {
    	endDate = convertToCalender(inputEndDate);
    }
    /**
     * Set the park name
     * @param inputParkName
     */
    public void setParkName(String inputParkName) {
    	parkName = inputParkName;
    }
    /**
     * Set the details of the park
     * @param inputDetails
     */
    public void setDetails(String inputDetails) {
    	details = inputDetails;
    }
    /*
     * -----------------------------------------------------------------------------------------------------------
     */
    //Getters
    /**
     * @return the job ID.
     */
    public int getJobID() {
    	return jobID;
    }
    
    /**
     * @return the start date of the job as a GregorianCalendar
     */
    public GregorianCalendar getStartDate() {
    	return startDate;
    }
    
    /**
     * @return the end date of the job as a GregorianCalendar.
     */
    public GregorianCalendar getEndDate() {
    	return endDate;
    }
    
    /**
     * @return the name of the park.
     */
    public String getParkName() {
    	return parkName;
    }
    
    /**
     * @return the detail of a job.
     */
    public String getJobDetails() {
    	return details;
    }
    
    /**
     * @return the maximum amount of volunteers that can sign up for light job.
     */
    public int getLightMax() {
    	return lightMax;
    }
    
    /**
     * @return the number of volunteers that sign up for light job.
     */
    public int getLightCurrent() {
    	return lightCurrent;
    }
    
    /**
     * @return the number of volunteers that sign up for medium job.
     */
    public int getMedCurrent() {
    	return medCurrent;
    }
    
    /**
     * @return the number of volunteers that sign up for heavy job.
     */
    public int getHeavyCurrent() {
    	return heavyCurrent;
    }
    
    /**
     * 
     * @return the maximum amount of volunteers that can sign up for medium job.
     */
    public int getMedMax() {
    	return medMax;
    }
    
    /**
     * 
     * @return the maximum amount of volunteers that can sign up for heavy job.
     */
    public int getHeavyMax() {
    	return heavyMax;
    }
	public void setVolunteerList(List<Volunteer> volunteerList) {
		this.volunteerList = volunteerList;
	}
	@Override
	public String toString() {
		return "Job jobID=" + jobID + ", startDate=" + startDate + ", endDate=" + endDate + ", parkName=" + parkName
				+ ", details=" + details + ", lightMax=" + lightMax + ", lightCurrent=" + lightCurrent + ", medMax="
				+ medMax + ", medCurrent=" + medCurrent + ", heavyMax=" + heavyMax + ", heavyCurrent=" + heavyCurrent
				+ ", volunteerList=" + volunteerList + "\n ";
	}
    
    /**
     * 
     * @return a list of volunteers for the job
     */
    public List<Volunteer> getVolunteerList() {
    	return volunteerList;
    }
    
    /**
     * 
     * @return if the start date is in the past.
     */
    //Check the start date to see if it's a past date
    public boolean isPast() {
    	return isPast;
    }
    
   
   /*
    * ------------------------------------------------------------------------------------------------------ 
    */
    /**
     * Convert a string date to a GregorianCalender object.
     * @param theDate
     * @return GregorianCalender format date.
     */
    private GregorianCalendar convertToCalender(String theDate) {
    	int myDate = Integer.parseInt(theDate.substring(0, 2));
    	int myMonth = Integer.parseInt(theDate.substring(2,4));
    	int myYear = Integer.parseInt(theDate.substring(4, 8));
    	
    	return new GregorianCalendar(myYear, myDate, myMonth);	  	
    }        
}
