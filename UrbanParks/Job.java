import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	 * The format to use on dates.
	 */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yy h:mma");

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

	//Constructor
	/**
	 * Constructs a Job.
	 * @throws ParseException if invalid date format
	 */
	public Job(int inputJobID, String inputStartDate, String inputEndDate, String inputParkName, 
			String inputDetails, int inputLightMax, int inputMedMax, int inputHeavyMax) throws ParseException {

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
		
		volunteerList = new ArrayList<Volunteer>();
	}

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
	 * Set the start date
	 * @param inputDate
	 * @throws ParseException if invalid date format
	 */
	public void setStartDate(String inputDate) throws ParseException {
		startDate = convertToCalender(inputDate);
	}
	/**
	 * Set the end date
	 * @param inputEndDate
	 * @throws ParseException if invalid date format
	 */
	public void setEndDate(String inputEndDate) throws ParseException {
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
	 * Adds a volunteer to the job and increments the light duty category.
	 */
	public void addLightVolunteer(Volunteer inputLightVolunteer) {
		if(!hasLightMax()){
			lightCurrent++;
			volunteerList.add(inputLightVolunteer);
		}
	}

	/**
     * Adds a volunteer to the job and increments the medium duty category.
     */
	public void addMedVolunteer(Volunteer inputMedVolunteer) {
		if(!hasMedMax()){
			medCurrent++;
			volunteerList.add(inputMedVolunteer);
		}
	}

	/**
     * Adds a volunteer to the job and increments the heavy duty category.
     */
	public void addHeavyVolunteer(Volunteer inputHeavyVolunteer) {
		if(!hasHeavyMax()) {
			heavyCurrent++;
			volunteerList.add(inputHeavyVolunteer);
		}
	}
    
    /**
     * Summarizes a job in a String.
     * @return the job's ID, park, and start date/time
     */
    public String getSummary() {
        return "Job: " + jobID + " | Park: " + parkName + " | Start: " + formatDate(startDate) + " | End: " + formatDate(endDate);
    }  
    
    /**
     * @return the Date Format
     */
    public SimpleDateFormat getDateFormat() { 
        return DATE_FORMAT;
    }

	/**
	 * @return an ArrayList of volunteers that are signed up for the job
	 */
	public ArrayList<Volunteer> getVolunteerList() {
		return volunteerList;
	}
	
	/**
     * @return a String list of volunteers that are signed up for the job
     */
    public String volunteerListToString() {
        String result = "Volunteers: ";
        if (volunteerList.size() == 0) {
            result += "None";
        }
        for (int i = 0; i < volunteerList.size(); i++) {
            Volunteer v = volunteerList.get(i);
            if (i > 0) {
                result += ", ";
            }
            result += v.getFirstName() +" "+ v.getLastName();
        }
        return result;
    }

	/**
     * @return if the maximum number of light duty volunteers is reached
	 */
	public boolean hasLightMax() {
	    return lightMax == lightCurrent;
	}

	/**
	 * @return if the maximum number of medium duty volunteers is reached
	 */
	public boolean hasMedMax() {
	    return medMax == medCurrent;
	}

	/**
	 * @return if the maximum number of heavy duty volunteers is reached
	 */
	public boolean hasHeavyMax() {
	    return heavyMax == heavyCurrent;
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
	protected String formatDate(GregorianCalendar inputCalendar){
	    String formattedDate = DATE_FORMAT.format(inputCalendar.getTime());
	    return formattedDate;
	}
	
	/**
	 * Checks if the User is the park manager for this job.
	 * 
	 * @param inputParks the ParkList that contains all the parks
	 * @param inputUser the User to check
	 * @return true if first name and last name match the park manager's
	 */
	public boolean isParkManager(ParkList inputParks, User inputUser) {
	    Park currentPark = inputParks.getPark(parkName);
	    return currentPark.isParkManager(inputUser);
	}
	
	/**
	 * Checks if a volunteer is currently signed up for this job.
	 * 
	 * @param inputVolunteer the one to check to see if they are signed up
	 * @return true if they are signed up, otherwise false
	 */
    public boolean isVolunteer(Volunteer inputVolunteer) {
        return volunteerList.contains(inputVolunteer);
    }
    
    /**
     * Checks if this job is in the past.
     */
    public boolean isInPast() {
        GregorianCalendar now = new GregorianCalendar();
        return startDate.before(now);
    }
    
    /**
     * Gives a String with full details of the job.
     */
    @Override
    public String toString() {
        return "Job: " + jobID + " | Park: " + parkName + " | Start: " 
                + formatDate(startDate) + " | End: " + formatDate(endDate)
                +"\n"+ "Details: " + details
                +"\n"+ "Positions Taken | Light: " + lightCurrent + "/" + lightMax 
                + " | Medium: " + medCurrent + "/" + medMax 
                + " | Heavy: " + heavyCurrent + "/" + heavyMax 
                +"\n"+ volunteerListToString();
    }
    
	/**
	 * Compares the toString()'s of both jobs.
	 */
	@Override
	public boolean equals(Object inputJob) {
	    if (inputJob == null) {
	        return false;
	    }
	    if (this.getClass() != inputJob.getClass()) {
	        return false;
	    }
		return this.toString().compareTo(inputJob.toString()) == 0;
	}
	
	/**
	 * @return toString's hashCode
	 */
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}