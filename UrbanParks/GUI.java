/**
 * Runs the GUI for the Urban Parks application.
 * 
 * TCSS 360, Winter 2016
 * @author Group 6: Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version January 21, 2016
 */
public class GUI {
    
    /**
     * The file input/output object.
     */
    private FileIO fileIO;
    
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
     * Constructs the GUI for the Urban Parks application.
     */
    public GUI() {
        fileIO = new FileIO();         //create fileIO object
        users = fileIO.getUsers();     //initialize users
        jobs = fileIO.getJobs();       //initialize jobs
        parks = fileIO.getParks();     //initialize parks
        
        // TODO stuff
    }
    
    /**
     * Saves the current state of the application to file.
     */
    private void save() {
        fileIO.save(users, jobs, parks);
    }

    /**
     * Begins the GUI console interface.
     */
    public void run() {
        // TODO run GUI stuff
        
    }
    
}
