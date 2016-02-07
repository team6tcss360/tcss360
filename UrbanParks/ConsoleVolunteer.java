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
	 */
	public void run() {
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
			System.out.println("4) Exit");  
			System.out.print(">> ");
			input = scanner.next(); //Get user input

			switch(input) {
			case "1":
				viewAllJobs();
				System.out.println(users.getVolunteerLastNames());
				break;
			case "2":
				System.out.println("Enter in the job ID that you want to view");
				int jobID = scanner.nextInt();
				viewJobID(jobID);
				break;
			case "3":
				System.out.println("Enter in the job ID that you want to volunteer for.");
				jobID = scanner.nextInt();
				signUpForJob(jobID);
				break;
			case "4":
				viewMyJobs();
				break;
			}


		} while(input.compareTo("5") != 0);

	}
	public void viewAllJobs() {
		System.out.println(jobs.toString());
	}
	public void viewJobID(int inputJobID) {
		Job temp = jobs.getJob(inputJobID);
		if(temp == null) {
			System.out.println("Job doesn't exist");
		} else {
			System.out.println(temp.toString());
		}
	}
	public void signUpForJob(int inputJobID) {
		Job temp = jobs.getJob(inputJobID);
		if(temp == null) {
			System.out.println("Job doesn't exist");
		} else if (temp != null){
			System.out.println("I am in here!");
			
			
		}
		
	}
	public void viewMyJobs() {
		//System.out.println(jobs.getJobAt(0).getVolunteerList().get(0));
	}
}
