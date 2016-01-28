package Urban_Parks;

/**
 * Starts the program for the Urban Parks user interface.
 * 
 * TCSS 360, Winter 2016
 * @author Group 6: Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version January 21, 2016
 */
public class UrbanParksMain {

    /**
     * The fileName for the Urban Park Application's data.
     */
    private String fileName = "UrbanParksData.txt";
    
    /**
     * The file input/output object.
     */
    private UrbanParksIO io;
    
    /**
     * Contains the users that Urban Parks application will use.
     */
    private UrbanParksUsers users;

    /**
     * Contains the jobs that Urban Parks application will use.
     */
    private UrbanParksJobs jobs;
    
    public static void main(String[] args) {
        io = new UrbanParksIO(fileName);
        users = io.getUsers();
        jobs = io.getJobs();
        
        // TODO stuff
    }
    
    /**
     * Saves the current state of the application to file.
     */
    private void save() {
        io.save(users, jobs);
    }
}
