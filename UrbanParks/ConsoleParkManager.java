import java.util.ArrayList;
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
		scanner.useDelimiter("\\n");
		user = currentUser;
		countJobs = 0;
		myJobs = new JobList();
	}



	/**
	 * Runs the Park Manager console screen.
	 */
	public void run() {
		String input = " ";
		do {
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
			input = scanner.next();
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
		}while(input.compareTo("6") != 0);

	}
	/**
	 *  public Job(int inputJobID, String inputStartDate, String inputEndDate, String inputParkName, 
            String inputDetails, int inputLightMax, int inputMedMax, int inputHeavyMax, 
            String[] inputVolunteerList) {
	 */

	//So I made this catered towards the current Job constructor. Shouldn't we cater this for the user story that we 
	//Implemented for the last sprint?
	/**
	 * public Job(int inputJobID, String inputStartDate, String inputEndDate, String inputParkName, 
            String inputDetails, int inputLightMax, int inputMedMax, int inputHeavyMax, 
            String[] inputVolunteerList)
	 */
	public void submitJob() {

		System.out.print("Enter the start date: ");
		String startDate = scanner.next();

		System.out.print("Enter the end date");
		String endDate = scanner.next();

		System.out.print("Enter the park name");
		String parkName = scanner.next();

		System.out.print("Enter in the details of the job");
		String details = scanner.next();

		System.out.print(startDate + "\n" + endDate + "\n" + parkName + "\n" + details);

		System.out.print("Is it going to be a light weight job? Enter '1' for yes or '0' for no");
		int light = 0;
		try {
			light = Integer.parseInt(scanner.next());

		} catch(NumberFormatException errorMessage) {
			System.out.println("Numbers only, " + light + " is not a number.");
		}

		System.out.print("Is it going to be a medium weight job? Enter '1' for yes or '0' for no");
		int medium = Integer.parseInt(scanner.next());

		System.out.print("Is it going to be a heavy weight job? Enter '1' for yes or '0' for no");
		int heavy = Integer.parseInt(scanner.next());

		System.out.print("Enter the number of volunteers you want");
		int numOfVolunteers = Integer.parseInt(scanner.next());

		int index = 0;
		String myVolunteers[] = new String[numOfVolunteers];


		String firstName = " ";
		//for now this will just make a bunch of dummy volunteers.
		for(int i = 0; i < numOfVolunteers; i++) {
			System.out.println("Enter in the volunteer name");
			firstName = scanner.next();
			if(firstName.compareTo("-1") == 0) {
				break;
			}
			else {
				myVolunteers[index] = firstName;
				index++;
			}

		}
		countJobs++;
		Job job = new Job(countJobs, startDate, endDate, parkName, details, light, medium, heavy, myVolunteers);
		myJobs.add(job);


	}
	public void deleteJob() {
		System.out.println("Enter the job ID you want to delete");
		int jobID = 0;
		try {
			jobID = Integer.parseInt(scanner.next());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, needs to be a number!");
		}
		Job job = myJobs.getJob(jobID);
		if(job == null) {
			System.out.println("Job doesn't exist");
		} else {
			System.out.println("Job exists and we are removing it!");
			myJobs.remove(job);
		}
	}
	public void editJob() {
		

	}
	public void viewUpcomingJobs() {
		System.out.println(myJobs.toString());

	}
}
