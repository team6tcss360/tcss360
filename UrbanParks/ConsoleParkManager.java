import java.util.Scanner;

/**
 * Runs the Park Manager's console screen for the Urban Parks application.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class ConsoleParkManager {

    /**
     * A scanner to use for console input.
     */
    private static final Scanner scanner = new Scanner(System.in);
    
    /**
     * The user that is currently logged in.
     */
    private User user;
    /**
     * JobList instance
     */
    private JobList myJobs;
    
    /**
     * Used for JobID
     */
    private int countJobs;
    
    
    /**
     * Constructs the Park Manager console for the current user.
     * 
     * @param currentUser the user that has logged in
     */
    public ConsoleParkManager(User currentUser) {
        user = currentUser;
        countJobs = 0;
        myJobs = new JobList();
    }
    
    
    
    /**
     * Runs the Park Manager console screen.
     */
    public void run() {
        System.out.println("Login Success!");
        System.out.println("Welcome: ");
        System.out.println("Park Manager: " + user.getFirstName() + " " + user.getLastName());
        System.out.println();
        System.out.println("Please Enter a Command:");
        System.out.println("1) Submit new job");
        System.out.println("2) Delete a job");
        System.out.println("3) Edit a job");
        System.out.println("4) View upcoming jobs in my parks");
        System.out.println("5) Back");
        System.out.println("6) Exit");  
        System.out.print(">> ");
        String input = scanner.next();
        System.out.println(input);
        switch(input) {
        case "1":
        	submitJob();
        	break;
        case "2":
        	deleteJob();
        	break;
        case "3":
        	editJob();
        	break;
        case "4":
        	viewUpcomingJobs();
        	break;
        }
    }
    /**
     *  public Job(int inputJobID, String inputStartDate, String inputEndDate, String inputParkName, 
            String inputDetails, int inputLightMax, int inputMedMax, int inputHeavyMax, 
            String[] inputVolunteerList) {
     */
    
    //So I made this catered towards the current Job constructor. Shouldn't we cater this for the user story that we 
    //Implemented for the last sprint?
    public void submitJob() {
    	System.out.println("Enter the start date");
    	String startDate = scanner.nextLine();
    	System.out.println("Enter the end date");
    	String endDate = scanner.nextLine();
    	System.out.println("Enter the park name");
    	String parkName = scanner.nextLine();
    	System.out.println("Enter the number of volunteers you want");
    	int numOfVolunteers = Integer.parseInt(scanner.nextLine());
    	int index = 0;
    	Volunteer myVolunteers[] = new Volunteer[numOfVolunteers];
//    	do {
//    		System.out.println("Enter in the volunteer name, and type in -1 when finished");
//    		myVolunteers[index] = scanner
//    	}

    }
    public void deleteJob() {
    	
    }
    public void editJob() {
    	
    }
    public void viewUpcomingJobs() {
    	
    }
}
