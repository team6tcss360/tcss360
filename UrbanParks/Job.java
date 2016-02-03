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
    
}
