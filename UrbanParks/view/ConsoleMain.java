package view;
import java.text.ParseException;
import java.util.Scanner;

import data.FileIO;
import model.Job;
import model.JobList;
import model.Park;
import model.ParkList;
import model.ParkManager;
import model.StaffMember;
import model.User;
import model.UserList;
import model.Volunteer;

/**
 * Runs the Console main screen for the Urban Parks application.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class ConsoleMain {
    
    /**
     * The file name for the Urban Park Application's data.
     */
    private static final String FILE_NAME = "UrbanParks/data/UrbanParksData.txt";
    
    /**
     * A scanner to use for console input.
     */
    private static final Scanner scanner = new Scanner(System.in);
    
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
     * Constructs the ConsoleMain for the Urban Parks application.
     * @throws ParseException if invalid date format
     */
    public ConsoleMain() throws ParseException {
        fileIO = new FileIO(FILE_NAME); //create fileIO object   
        users = fileIO.getUsers();      //initialize users
        jobs = fileIO.getJobs();        //initialize jobs
        parks = fileIO.getParks();      //initialize parks
//        addManualData();
//        fileIO.save(users, jobs, parks);
    }
    
    /**
     * Saves the current state of the application to file.
     */
    protected void save() {
        fileIO.save(users, jobs, parks);
    }

    /**
     * Begins the ConsoleMain console interface.
     * @throws ParseException if invalid date format
     */
    public void run() throws ParseException {
        System.out.println("*******************************************************");
        System.out.println("*                                                     *");
        System.out.println("*      Welcome to the Urban Parks Application!        *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");
        System.out.println();
        System.out.println("Please enter your email: ");
        String input = scanner.nextLine().trim(); //Get user input
        User currentUser = users.findFromEmail(input); //Find user associated with email
        
        //if they enter an email that is not found, keep asking
        while (currentUser == null) { 
            System.out.println("That is not a valid email!");
            System.out.println();
            System.out.println("Please enter your email: ");
            input = scanner.nextLine().trim(); //Get user input
            currentUser = users.findFromEmail(input); //Find user associated with email            
        }
        
        //if user is a Volunteer, switch to Volunteer screen
        if (currentUser instanceof Volunteer) { 
            ConsoleVolunteer console = new ConsoleVolunteer(currentUser, fileIO);
            console.run();
        } 
        //if user is a ParkManager, switch to ParkManager screen
        else if (currentUser instanceof ParkManager) {
            ConsoleParkManager console = new ConsoleParkManager(currentUser, fileIO);
            console.run();
        }
        //if user is a StaffMember, switch to StaffMember screen
        else if (currentUser instanceof StaffMember) {
            ConsoleStaffMember console = new ConsoleStaffMember(currentUser, fileIO);
            console.run();
        } 
    }  
    
    /**
     * Adds manual data to the user, job, and park lists.  In case we want to inject more
     * users, jobs, or parks.
     * @throws ParseException if invalid date format
     */
    @SuppressWarnings("unused") //just in case we want to manually inject data
    private void addManualData() throws ParseException {
        users = new UserList();
        jobs = new JobList();  
        parks = new ParkList(); 
        users.add(new Volunteer("Mary","Williams","mwilliams@gmail.com","1234567899"));
        users.add(new Volunteer("Victor","Volunteereli","v@v.com","1234567854"));
        users.add(new StaffMember("John","Smith","johnsmith@gmail.com","1234567890"));
        users.add(new StaffMember("Steve","Staffy","s@s.com","1234567380"));
        users.add(new ParkManager("George","Wilson","geogew@gmail.com","9876543210"));
        users.add(new ParkManager("Peter","Parker","p@p.com","9876547590"));
        parks.add(new Park("Point Defiance", "5400 N Pearl St, Tacoma, WA 98407", "George", "Wilson"));
        parks.add(new Park("Dash Point", "1500 Beach Dr. N.E. Tacoma, WA 98422", "Peter", "Parker"));
        parks.add(new Park("Mount Rainier", "National Park Inn, Packwood, WA 98361", "Peter", "Parker"));
        jobs.add(new Job(1, "03-01-16 2:00PM", "03-01-16 4:00PM", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0));
        jobs.add(new Job(2, "04-02-16 9:00AM", "04-03-16 5:00PM", "Mount Rainier", "The volunteers will repair a bridge.", 0, 0, 5));
        jobs.add(new Job(3, "02-22-16 1:00PM", "02-22-16 4:00PM", "Dash Point", "The volunteers will help clean the beach.", 5, 0, 0));
    }
}
