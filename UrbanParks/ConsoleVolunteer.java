import java.text.ParseException;
import java.util.Scanner;

/**
 * Runs the volunteer's console screen for the Urban Parks application.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class ConsoleVolunteer {

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
	 * Constructs the volunteer console for the current user.
	 * 
	 * @param currentUser the user that has logged in
	 * @param fileIO 
	 */
	public ConsoleVolunteer(User currentUser, FileIO inputFileIO) {
		scanner.useDelimiter("\\n");
		user = currentUser;
		fileIO = inputFileIO;
		users = fileIO.getUsers();
		jobs = fileIO.getJobs();
		parks = fileIO.getParks();
	}

	/**
	 * Runs the volunteer console screen.
	 * @throws ParseException if invalid date format
	 */
	public void run() throws ParseException {
		String input;
		System.out.println("Login Success!");
		System.out.println("Welcome: ");
		System.out.println("Volunteer: " + user.getFirstName() + " " + user.getLastName());
		do {
			System.out.println();
			System.out.println("Please Enter a Command:");
			System.out.println("1) View Upcoming Jobs");
			System.out.println("2) View Jobs by Job ID");
			System.out.println("3) Volunteer for a job");
			System.out.println("4) View jobs you signed up for");
			System.out.println("5) Back");
			System.out.println("6) Exit");  
			System.out.print(">> ");
			input = scanner.nextLine(); //Get user input
			int jobID = 0;
			switch(input) {
			case "1":
				viewAllJobs();
				//				System.out.println(users.getVolunteerLastNames());
				break;
			case "2":
				System.out.println("Enter in the job ID that you want to view");
				String string_jobID = scanner.nextLine();
				try {
					jobID = Integer.parseInt(string_jobID);
				} catch(NumberFormatException e) {
					System.out.println("Invalid input");
					break;
				}
				viewJobID(jobID);
				break;
			case "3":
				System.out.println("Enter in the job ID that you want to volunteer for.");
				string_jobID = scanner.nextLine();
				try {
					jobID = Integer.parseInt(string_jobID);
				} catch(NumberFormatException e) {
					System.out.println("Invalid input");
					break;
				}
				signUpForJob(jobID);
				break;
			case "4":
				viewMyJobs();
				break;
			case "5":
				ConsoleMain console = new ConsoleMain();
				console.run();
			case "6":
				break;
			}


		} while(input.compareTo("5") != 0 && input.compareTo("6") != 0);

	}
	/**
	 * Allows the volunteer to view all the current jobs
	 */
	public void viewAllJobs() {
	    System.out.println(jobs.toString());
	}
	/**
	 * Allows the Volunteer to view a job based off of it's unique ID
	 * @param inputJobID
	 */
	public void viewJobID(int inputJobID) {
		Job temp = jobs.getJob(inputJobID);
		if(temp == null) {
			System.out.println("Job doesn't exist");
		} else {
			System.out.println(temp.toString());
		}
	}

	//TODO need to ask for category (light, etc.)
	public void signUpForJob(int inputJobID) {
		Job temp = jobs.getJob(inputJobID);
		String level = "";
		if(temp == null) {
			System.out.println("Job doesn't exist");
		} else if (temp != null){
			System.out.println("What level of difficulty would you like?");
			System.out.println("Light, Medium, or Heavy?");
			level = scanner.nextLine().toLowerCase();
			switch(level) {
			//This is still returning a null pointer exception....
			case "light":
				System.out.println(jobs.getJob(inputJobID).toString());
				//jobs.getJob(inputJobID).addLightVolunteer((Volunteer) user); 
				break;
			case "medium":
				jobs.getJob(inputJobID).addMedVolunteer((Volunteer) user);
			case "heavy":
				jobs.getJob(inputJobID).addHeavyVolunteer((Volunteer) user);
			}

		}
		fileIO.save(users, jobs, parks);

	}
	public void viewMyJobs() {
		//System.out.println(jobs.getJobAt(0).getVolunteerList().get(0));
	}

}
