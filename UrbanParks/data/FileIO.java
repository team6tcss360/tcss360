package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Job;
import model.JobList;
import model.Park;
import model.ParkList;
import model.User;
import model.UserList;

/**
 * Reads and saves data to files for the Urban Parks application.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 26, 2016
 */
public class FileIO {
    
    /** The file name for the file that holds the Urban Parks serial data. */
    private String fileName;

    /** The users that Urban Parks application will use. */
    private UserList users;

    /** The jobs that Urban Parks application will use. */
    private JobList jobs;
    
    /** The parks that Urban Parks application will use. */
    private ParkList parks;
    
    /**
     * Constructs an FileIO object.
     * 
     * @param inputFile the String address to the file that contains the Urban 
     * Parks data
     * @throws FileNotFoundException if provided file was not found
     * @throws IOException if error reading or writing to file
     * @throws ClassNotFoundException if model classes are not found 
     */
    public FileIO(String inputFile) throws FileNotFoundException, ClassNotFoundException, IOException {
        fileName = inputFile;
        users = new UserList();
        jobs = new JobList();
        parks = new ParkList();
        load(); //initializes lists with states that were saved in data file
    }

    /**
     * Saves the input users, jobs, and parks to file.
     * 
     * @param inputUserList the current state of the UserList object
     * @param inputJobList the current state of the JobList object
     * @param inputParkList the current state of the ParkList object
     * @throws FileNotFoundException if provided file was not found
     * @throws IOException if error reading or writing to file
     */
    public void save(UserList inputUserList, JobList inputJobList, ParkList inputParkList) 
            throws FileNotFoundException, IOException {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(inputUserList.getArrayList()); //write users
            oos.writeObject(inputJobList.getArrayList()); //write jobs
            oos.writeObject(inputParkList.getArrayList()); //write parks
            oos.close();
    }
    
    /**
     * Loads the FileIO object with the users, jobs, and parks that were saved to
     * the data file.
     * 
     * @throws FileNotFoundException if provided file was not found
     * @throws IOException if error reading or writing to file
     * @throws ClassNotFoundException if model classes are not found
     */
    @SuppressWarnings("unchecked") //they are the object types in save method
    protected void load() throws FileNotFoundException, IOException, ClassNotFoundException {
        // read object from file
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        users = new UserList((ArrayList<User>) ois.readObject());
        jobs = new JobList((ArrayList<Job>) ois.readObject());
        parks = new ParkList((ArrayList<Park>) ois.readObject());
        ois.close();
    }
    
    /** @return the UserList that the FileIO loaded from its data file. */
    public UserList getUsers() {
        return users;
    }
    
    /** @return the JobList that the FileIO loaded from its data file. */
    public JobList getJobs() {
        return jobs;
    }

    /** @return the ParkList that the FileIO loaded from its data file. */
    public ParkList getParks() {
        return parks;
    }    
}
