

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Reads and saves data to files for the Urban Parks application.
 * 
 * TCSS 360, Winter 2016
 * @author Jonathan Hughes
 * @version January 27, 2016
 */
public class FileIO {
    
    /**
     * The file name for the Urban Park Application's data.
     */
    private static final String FILE_NAME = "UrbanParksData.txt";
    
    /**
     * The number of variables in the User class.
     */
    private static final int USER_VARIABLES = 5;

    /**
     * The number of variables in the Job class.  This does not include
     * the volunteers.  They are listed at the end.
     */
    private static final int JOB_VARIABLES = 8;
    
    /**
     * The number of variables in the Park class.
     */
    private static final int PARK_VARIABLES = 4;

    /**
     * The maximum amount of volunteers allowed.
     */
    private static final int MAX_VOLUNTEERS = 30;

    /**
     * The users that Urban Parks application will use.
     */
    private UserList users;

    /**
     * The jobs that Urban Parks application will use.
     */
    private JobList jobs;
    
    /**
     * The parks that Urban Parks application will use.
     */
    private ParkList parks;
    
    /**
     * Constructs an FileIO object.
     * 
     * @param inputFile the String address to the file that contains the Urban 
     * Parks data
     */
    public FileIO() {
        users = new UserList();
        jobs = new JobList();
        parks = new ParkList();
        load();
    }
    
    /**
     * Saves the input users and jobs to file.
     * 
     * @param inputUsers the current state of the UserList object
     * @param inputJobs the current state of the JobList object
     * @param parks 
     */
    public void save(UserList inputUsers, JobList inputJobs, ParkList inputParks) {
        jobs = inputJobs;
        users = inputUsers;
        parks = inputParks;
        // TODO Save stuff
    }
    
    /**
     * Constructs an FileIO object.
     * @param inputFile the file that contains the Urban Parks data
     */
    private void load() {
        //Bring in text file to be read
        InputStream input = getClass().getResourceAsStream(FILE_NAME); 
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        
        String line;
        try { //Read through each line of text file
            while ((line = reader.readLine()) != null) { //While there is another line to read
                //if it starts with S, V, or M - it is a User
                if(line.startsWith("S") | line.startsWith("V") | line.startsWith("M")) {
                    parseUserLine(line);
                } 
                //if it starts with P - it is a Park
                else if(line.startsWith("P")) {
                    parseParkLine(line);
                }
                //if it starts with J - it is a Job
                else if(line.startsWith("J")) {
                    parseJobLine(line);
                }
            }
        } catch (IOException e) { //Catch exceptions caused by reading the file
            System.out.println("Could not read file!");
            e.printStackTrace();
        }
        try {
            reader.close(); //Close file when done reading it
        } catch (IOException e2) { //Catch exceptions caused by closing the file
            e2.printStackTrace();
        }
    }
    
    /**
     * Parses a line with user data, creates a user, and adds it to the users object.
     * 
     * @param input the line with the user data
     */
    private void parseUserLine(String input) {
        //initialize attributes
        String firstName = "";
        String lastName = "";
        String email = "";
        String phone = "";
        int userID = 0; 
        
        String type = input.substring(0, 1); //get user type
        String line = input.substring(2, input.length()); //cut off user type
        int breakPoint = line.indexOf(':'); //finds occurrence of next :
        
        for (int i = 0; i < USER_VARIABLES; i++) { //decode attributes from line
            String attribute = line.substring(0, breakPoint); //get attribute
            line = line.substring(breakPoint + 1, line.length()); //cut off attribute
            breakPoint = line.indexOf(':'); //finds occurrence of next :
            switch (i) { //set appropriate attribute
                case 0:
                    firstName = attribute;
                    break;
                case 1:
                    lastName = attribute;
                    break;
                case 2:
                    email = attribute;
                    break;
                case 3:
                    phone = attribute;
                    break;
                case 4:
                    userID = Integer.parseInt(attribute);
                    break;
            }            
        }
        User user = null;
        switch (type) { //create the user using decoded attributes
            case "S": //Staff member of Urban Parks line
                user = new StaffMember(firstName, lastName, email, phone, userID);  
                break;    
            case "V": //Volunteer line
                user = new Volunteer(firstName, lastName, email, phone, userID);  
                break;
            case "M": //Park Manager line
                user = new ParkManager(firstName, lastName, email, phone, userID);
                break;
        }
        users.add(user); //add to user list
    }
    
    /**
     * Parses a line with job data, creates a job, and adds it to the jobs object.
     * 
     * @param input the line with the job data
     */
    private void parseJobLine(String input) {
        //initialize attributes
        int jobID = 0;
        String startDate = "";
        String endDate = "";
        String parkName = "";
        String details = "";
        int lightMax = 0;
        int medMax = 0;
        int heavyMax = 0;
                
        String line = input.substring(2, input.length()); //cut off type
        int breakPoint = line.indexOf(':'); //finds occurrence of next :
        
        //Create list to hold volunteers (they have 2 names each first & last)
        String[] volunteerList = new String[MAX_VOLUNTEERS * 2];
        int volunteer_iterator = 0;
        
        for (int i = 0; i < JOB_VARIABLES; i++) { //decode attributes from line
            String attribute = line.substring(0, breakPoint); //get attribute
            line = line.substring(breakPoint + 1, line.length()); //cut off attribute
            breakPoint = line.indexOf(':'); //finds occurrence of next :
            switch (i) { //set appropriate attribute
                case 0:
                    jobID = Integer.parseInt(attribute);
                    break;
                case 1:
                    startDate = attribute;
                    break;
                case 2:
                    endDate = attribute;
                    break;
                case 3:
                    parkName = attribute;
                    break;
                case 4:
                    details = attribute;
                    break;
                case 5:
                    lightMax = Integer.parseInt(attribute);
                    break;
                case 6:
                    medMax = Integer.parseInt(attribute);
                    break;
                case 7:
                    heavyMax = Integer.parseInt(attribute);
                    break;
                default:
                    volunteerList[volunteer_iterator] = attribute;
                    volunteer_iterator++;
                    break;
            }            
        }
        //add to job list
        jobs.add(new Job(jobID, startDate, endDate, parkName, details, lightMax, 
                medMax, heavyMax, volunteerList)); 
    }
    
    /**
     * Parses a line with park data, creates a park, and adds it to the parks object.
     * 
     * @param input the line with the park data
     */
    private void parseParkLine(String input) {
        //initialize attributes
        String parkName = "";
        String location = "";
        String parkManagerFirstName = "";
        String parkManagerLastName = "";
        
        String line = input.substring(2, input.length()); //cut off type
        int breakPoint = line.indexOf(':'); //finds occurrence of next :
        
        for (int i = 0; i < PARK_VARIABLES; i++) { //decode attributes from line
            String attribute = line.substring(0, breakPoint); //get attribute
            line = line.substring(breakPoint + 1, line.length()); //cut off attribute
            breakPoint = line.indexOf(':'); //finds occurrence of next :
            switch (i) { //set appropriate attribute
                case 0:
                    parkName = attribute;
                    break;
                case 1:
                    location = attribute;
                    break;
                case 2:
                    parkManagerFirstName = attribute;
                    break;
                case 3:
                    parkManagerLastName = attribute;
                    break;
            }            
        }
        //add to park list
        parks.add(new Park(parkName, location, parkManagerFirstName, 
                parkManagerLastName)); 
    }
    
    /**
     * Returns the users.
     * 
     * @return the UserList that the IO loaded
     */
    public UserList getUsers() {
        return users;
    }
    
    /**
     * Returns the jobs.
     * 
     * @return the JobList that the IO loaded
     */
    public JobList getJobs() {
        return jobs;
    }

    /**
     * Returns the parks.
     * 
     * @return the ParkList that the IO loaded
     */
    public ParkList getParks() {
        return parks;
    }    
}
