

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Reads and saves data to files for the Urban Parks application.
 * 
 * TCSS 360, Winter 2016
 * @author Jonathan Hughes
 * @version January 27, 2016
 */
public class FileIO {
    
    /**
     * Contains the users that Urban Parks application will use.
     */
    private UserList users;

    /**
     * Contains the jobs that Urban Parks application will use.
     */
    private JobList jobs;
    
    /**
     * Contains the parks that Urban Parks application will use.
     */
    private ParkList parks;

    /**
     * Contains the file name of the Urban Parks data.
     */
    private String file;
    
    /**
     * Constructs an FileIO object.
     * 
     * @param inputFile the String address to the file that contains the Urban 
     * Parks data
     */
    public FileIO(String inputFile) {
        file = inputFile;
        users = new UserList();
        jobs = new JobList();
        parks = new ParkList();
        load(file);
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
    private void load(String inputFile) {
        //Bring in text file to be read
        InputStream input = getClass().getResourceAsStream(inputFile); 
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        
        int iterator = 0;
        String line;
        try { //Read through each line of text file
            while ((line = reader.readLine()) != null) { //While there is another line to read
                if(line.startsWith("U")) {
                    parseUserLine(line);
                } 
                else if(line.startsWith("J")) {
                    parseJobLine(line);
                }
                iterator++; //Iterate array, so next line is put at next index
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
        //TODO stuff
        //User user = new User();
    }
    
    /**
     * Parses a line with job data, creates a job, and adds it to the jobs object.
     * 
     * @param input the line with the job data
     */
    private void parseJobLine(String input) {
        //TODO stuff
        Job job = new Job();
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
