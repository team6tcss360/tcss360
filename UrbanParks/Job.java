import java.util.List;

/**
 * Contains information for an Urban Parks job.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class Job {

    /**
     * A job's ID number.
     */
    private int jobID;
    
    /**
     * A job's start date.
     */
    private String startDate;
    
    /**
     * A job's end date.
     */
    private String endDate;
    
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
    
    /**
     * 
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
            String[] inputVolunteerList) {
        jobID = inputJobID;
        startDate = inputStartDate;
        endDate = inputEndDate;
        parkName = inputParkName;
        details = inputDetails;
        lightMax = inputLightMax;
        lightCurrent = 0;
        medMax = inputMedMax;
        medCurrent = 0;
        heavyMax = inputHeavyMax;
        heavyCurrent = 0;
        //TODO input is currently an array of Strings with first name, then last name, then next first name, etc.
//        List<Volunteer> volunteerList  = inputVolunteerList;
    }
    public int getID() {
    	return this.jobID;
    }
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getLightMax() {
		return lightMax;
	}
	public void setLightMax(int lightMax) {
		this.lightMax = lightMax;
	}
	public int getLightCurrent() {
		return lightCurrent;
	}
	public void setLightCurrent(int lightCurrent) {
		this.lightCurrent = lightCurrent;
	}
	public int getMedMax() {
		return medMax;
	}
	public void setMedMax(int medMax) {
		this.medMax = medMax;
	}
	public int getMedCurrent() {
		return medCurrent;
	}
	public void setMedCurrent(int medCurrent) {
		this.medCurrent = medCurrent;
	}
	public int getHeavyMax() {
		return heavyMax;
	}
	public void setHeavyMax(int heavyMax) {
		this.heavyMax = heavyMax;
	}
	public int getHeavyCurrent() {
		return heavyCurrent;
	}
	public void setHeavyCurrent(int heavyCurrent) {
		this.heavyCurrent = heavyCurrent;
	}
	public List<Volunteer> getVolunteerList() {
		return volunteerList;
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
    
}
