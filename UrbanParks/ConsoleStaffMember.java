import java.util.Scanner;

/**
 * Runs the Urban Park staff member's console screen for the Urban Parks 
 * application.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class ConsoleStaffMember {


    /**
     * A scanner to use for console input.
     */
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * The user that is currently logged in.
     */
    private User user;
    
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
     * Constructs the Staff Member console for the current user.
     * 
     * @param currentUser the user that has logged in
     * @param fileIO 
     */
    public ConsoleStaffMember(User currentUser, FileIO inputFileIO) {
        user = currentUser;
        fileIO = inputFileIO;
        users = fileIO.getUsers();
        jobs = fileIO.getJobs();
        parks = fileIO.getParks();
    }

    /**
     * Runs the Staff Member console screen.
     */
    public void run() {
        System.out.println("Login Success!");
        System.out.println("Welcome: ");
        System.out.println("Urban Parks Staff: " + user.getFirstName() + " " + user.getLastName());
        System.out.println();
        System.out.println("Please Enter a Command:");
        System.out.println("1) Search volunteers by last name");
        System.out.println("2) View a summary of all upcoming jobs.");
        System.out.println("3) Back");
        System.out.println("4) Exit");  
        System.out.print(">> ");
        String input = scanner.nextLine().trim(); //Get user input
        input = input.substring(1); //cuts off ">> "
      
        //TODO Stuff
    }

}
