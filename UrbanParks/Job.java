import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
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
	private ArrayList<Volunteer> volunteerList;

	private boolean isPast;

	//private int spotTaken;


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
			String inputDetails, int inputLightMax, int inputMedMax, int inputHeavyMax) {

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

		//spotTaken = 0;

		//TODO input is currently an array of Strings with first name, then last name, then next first name, etc.
		volunteerList  = new ArrayList<Volunteer>();
	}


	/*
	 *-----------------------------------------------------------------------------------------------------------
	 */
	//Setters
	/**
	 * Set the current volunteer numbers for light job.
	 *
	 */
	public void setLightMax(int inputLightMax) {
		lightMax = inputLightMax;
	}

	/**
	 * Set the current volunteer numbers for medium job.
	 * 
	 */
	public void setMedMax(int inputMedMax) {
		medMax = inputMedMax;
	}

	/**
	 * Set the current volunteer numbers for heavy job.
	 * 
	 */
	public void setHeavyMax(int inputHeavyMax) {
		heavyCurrent = inputHeavyMax;
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

	/**
	 * add the volunteers to the volunteer list
	 * @param inputVolunteer
	 */
	public void addLightVolunteer(Volunteer inputLightVolunteer) {
		if(!hasLightMax()){
			lightCurrent++;
			volunteerList.add(inputLightVolunteer);
		}
	}

	public void addMedVolunteer(Volunteer inputMedVolunteer) {
		if(!hasMedMax()){
			medCurrent++;
			volunteerList.add(inputMedVolunteer);
		}
	}

	public void addHeavyVolunteer(Volunteer inputHeavyVolunteer) {
		if(!hasHeavyMax()) {
			heavyCurrent++;
			volunteerList.add(inputHeavyVolunteer);
		}
	}



	@Override
	public String toString() {
		return "Job jobID=" + jobID + ", startDate=" + startDate + ", endDate=" + endDate + ", parkName=" + parkName
				+ ", details=" + details + ", "
				+ ", lightCurrent=" + lightCurrent + "/" + "lightMax=" + lightMax 
				+ ", medCurrent=" + medCurrent + "/" + ", medMax="+ medMax 
				+ ", heavyCurrent=" + heavyCurrent + "/" + ", heavyMax=" + heavyMax 
				+ ", volunteerList=" + volunteerList + "\n ";
	}

	/**
	 * 
	 * @return a list of volunteers for the job
	 */
	public ArrayList<Volunteer> getVolunteerList() {
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
	 *------------------------------------------------------------------------------------------------------
	 */
	//helper classes
	//    /**
	//     * Fill the number of spots that been taken in certain type
	//     * @param inputType
	//     * @return
	//     */
	//    public int getSpotNumber(String inputType) {
	//    	int spotTaken = 0;
	//    	
	//    	for (Volunteer myVolunteer : volunteerList) {
	//    		if (myVolunteer.get.equals(inputType)) {
	//    			spotTaken++;
	//    		}
	//    	}
	//    	return spotTaken;
	//    }

	/**
	 * Get the available light jobs numbers.
	 * @return
	 */
	public boolean hasLightMax() {

		return lightMax == lightCurrent;
	}

	/**
	 * Get the available med jobs numbers.
	 * @return
	 */
	public boolean hasMedMax() {

		return medMax == medCurrent;
	}

	/**
	 * Get the available heavy jobs numbers.
	 * @return
	 */
	public boolean hasHeavyMax() {

		return heavyMax == heavyCurrent;
	}
	



	/**
	 * Convert a string date to a GregorianCalender object.
	 * @param theDate, mmddyyyy
	 * @return GregorianCalender format date.
	 */
	private GregorianCalendar convertToCalender(String theDate) {
		int myDate = Integer.parseInt(theDate.substring(0, 2));
		int myMonth = Integer.parseInt(theDate.substring(2,4));
		int myYear = Integer.parseInt(theDate.substring(4, 8));

		return new GregorianCalendar( myMonth, myDate, myYear);	  	
	}


	public String getSummary() {
		
		return "Job jobID=" + jobID + ", parkName=" + parkName + ", startDate=" + startDate + ", endDate=" + endDate;
	}  
	
	public boolean equals(Object inputJob) {
		
		return this.toString().compareTo(inputJob.toString()) == 0;
		
	}

}