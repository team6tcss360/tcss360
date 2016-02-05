
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Reads and saves data to files for the Urban Parks application.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class FileIO {
    
    /**
     * The file name for the Urban Park Application's data.
     */
    private static final String FILE_NAME = "UrbanParks/UrbanParksData.txt";

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
//        load();
    }
    
    /**
     * Saves the input users and jobs to file.
     * 
     * @param inputUsers the current state of the UserList object
     * @param inputJobs the current state of the JobList object
     * @param inputParks the current state of the ParkList object
     */
    public void save(UserList inputUsers, JobList inputJobs, ParkList inputParks) {
        jobs = inputJobs;
        users = inputUsers;
        parks = inputParks;
        
        try { // write object to file
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(jobs);
            oos.writeObject(users);
            oos.writeObject(parks);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Loads the FileIO object with the class that was saved to file.
     * 
     * @param inputFile the file that contains the Urban Parks data
     */
    protected void load() {
        //Bring in text file to be read
        InputStream input = getClass().getResourceAsStream(FILE_NAME); 
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        try {
            // read object from file
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (UserList) ois.readObject();
            jobs = (JobList) ois.readObject();
            parks = (ParkList) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
