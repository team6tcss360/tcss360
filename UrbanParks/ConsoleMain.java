import java.util.Scanner;

/**
 * Runs the Console main screen for the Urban Parks application.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class ConsoleMain {
    
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
     */
    public ConsoleMain() {
        manualData();
        FileIO fileIO = new FileIO();         //create fileIO object
        fileIO.save(users, jobs, parks);
        
    }
    
    /**
     * Adds manual data to the user, job, and park lists.
     */
    private void manualData() {
        users = new UserList();
        jobs = new JobList();  
        parks = new ParkList(); 
        users.add(new Volunteer("Mary","Williams","mwilliams@gmail.com","1234567899",2));
        users.add(new StaffMember("John","Smith","johnsmith@gmail.com","1234567890",1));
        users.add(new ParkManager("George","Wilson","geogew@gmail.com","9876543210",3));
        parks.add(new Park("Point Defiance", "5400 N Pearl St, Tacoma, WA 98407", "George", "Wilson"));
        jobs.add(new Job(1, "20160301", "20160301", "Point Defiance", "The volunteers will help pickup trash on the trails.", 5, 5, 0, null));
    }

    /**
     * Begins the ConsoleMain console interface.
     */
    public void run() {
        System.out.println("*******************************************************");
        System.out.println("*                                                     *");
        System.out.println("*      Welcome to the Urban Parks Application!        *");
        System.out.println("*                                                     *");
        System.out.println("*******************************************************");
        System.out.println();
        System.out.println("Please enter your email: ");
        String input = scanner.nextLine().trim(); //Get user input
        User currentUser = (User) users.findFromEmail(input); //Find user associated with email
        
        //if they enter an email that is not found, keep asking
        while (currentUser == null) { 
            System.out.println("That is not a valid email!");
            System.out.println();
            System.out.println("Please enter your email: ");
            input = scanner.nextLine().trim(); //Get user input
            currentUser = (User) users.findFromEmail(input); //Find user associated with email            
        }
        
        //if user is a Volunteer, switch to Volunteer screen
        if (currentUser instanceof Volunteer) { 
            ConsoleVolunteer console = new ConsoleVolunteer(currentUser);
            console.run();
        } 
        //if user is a ParkManager, switch to ParkManager screen
        else if (currentUser instanceof ParkManager) {
            ConsoleParkManager console = new ConsoleParkManager(currentUser);
            console.run();
        }
        //if user is a StaffMember, switch to StaffMember screen
        else if (currentUser instanceof StaffMember) {
            ConsoleStaffMember console = new ConsoleStaffMember(currentUser);
            console.run();
        } 
    }    
}
