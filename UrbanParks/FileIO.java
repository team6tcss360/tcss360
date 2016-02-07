
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

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
    private String fileName;

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
    public FileIO(String inputFile) {
        fileName = inputFile;
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
     * @param inputParks the current state of the ParkList object
     */
    public void save(UserList inputUsers, JobList inputJobs, ParkList inputParks) {
       try { // write objects to file
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(inputUsers.getArrayList()); //write users
            oos.writeObject(inputJobs.getArrayList()); //write jobs
            oos.writeObject(inputParks.getArrayList()); //write parks
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new Error(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error(e);
        }
    }
    
    /**
     * Loads the FileIO object with the class that was saved to file.
     * 
     * @param inputFile the file that contains the Urban Parks data
     */
    @SuppressWarnings("unchecked") //they are the object types in save method
    protected void load() {
        try {
            // read object from file
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = new UserList((ArrayList<User>) ois.readObject());
            jobs = new JobList((ArrayList<Job>) ois.readObject());
            parks = new ParkList((ArrayList<Park>) ois.readObject());
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new Error(e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Error(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new Error(e);
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
