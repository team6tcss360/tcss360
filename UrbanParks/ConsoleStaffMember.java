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
		scanner.useDelimiter("\\n");
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
		String myInput;
		System.out.println("Login Success!");
		System.out.println("Welcome: ");
		System.out.println("Urban Parks Staff: " + user.getFirstName() + " " + user.getLastName());
		System.out.println();
		do {
			System.out.println("Please Enter a Command:");
			System.out.println("1) Search volunteers by last name");
			System.out.println("2) View a summary of all upcoming jobs.");
			System.out.println("3) Display All Volunteers");
			System.out.println("4) Display summary of a job by it's Job ID");
			System.out.println("4) Back"); 
			System.out.println("5) Exit");  
			System.out.print(">> ");
			myInput = scanner.nextLine(); //Get user input

			switch(myInput) {
			case "1":
				System.out.println("Enter in the last name you are looking for.");
				String lastName = scanner.next();
				searchVolunteer(lastName);
				break;
			case "2":
				displayJobs();
				break;
			case "3":
				displayVolunteers();
				break;
			case "4":
				System.out.println("Enter in job ID:");
				int jobID = scanner.nextInt();
				getJob(jobID);
				break;
			}
		} while(myInput.compareTo("5") != 0);
	}

	
	public void getJob(int inputJobID) {
		Job temp = jobs.getJob(inputJobID);
		if(temp == null) {
			System.out.println("Job ID doesn't exist");
		} else {
			System.out.println(temp.toString());
		}
	}
	
	public void displayVolunteers() {
		for(int i = 0; i < users.size(); i++) {
			if(users.getArrayList().get(i) instanceof Volunteer) {
				System.out.println(users.getArrayList().get(i).toString());
			}
		}
	}

	public void displayJobs() {
		for(int i = 0; i < jobs.size(); i++) {
			System.out.println(jobs.toString());
		}
	}
	public void searchVolunteer(String inputName) {
		int index = 0;
		boolean isFound = false;
		for(int i = 0; i < users.size(); i++) {
			if(users.getArrayList().get(i) instanceof Volunteer) {
				if (users.getArrayList().get(i).getLastName().toLowerCase().compareTo(inputName.toLowerCase()) == 0) {
					System.out.println("Volunteer found!");
					index = i;
					isFound = true;
					break;
				}
			}
		}
		if(isFound) {
			System.out.println(users.getArrayList().get(index));

		} else {
			System.out.println("Volunteer doesn't exist");
		}
	}

}
