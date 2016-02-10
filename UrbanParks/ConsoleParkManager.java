import java.util.ArrayList;
import java.util.List;
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
	 * The file input/output object.
	 */
	private FileIO fileIO;

	/**
	 * The user that is currently logged in.
	 */
	private User user;

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
	 * JobList instance
	 */
	private JobList myJobs;

	/**
	 * Used for JobID
	 */
	private int countJobs;

	private List<Volunteer> volunteerList;
	/**
	 * Constructs the Park Manager console for the current user.
	 * 
	 * @param currentUser the user that has logged in
	 */
	public ConsoleParkManager(User currentUser, FileIO inputFileIO) {
		scanner.useDelimiter("\\n");
		user = currentUser;
		countJobs = 0;

		myJobs = fileIO.getJobs();
		users = fileIO.getUsers();
		parks = fileIO.getParks();

		/**
		 * scanner.useDelimiter("\\n");
        user = currentUser;
        fileIO = inputFileIO;
        users = fileIO.getUsers();
        jobs = fileIO.getJobs();
        parks = fileIO.getParks();
		 */
	}

	/**
	 * Runs the Park Manager console screen.
	 */
	public void run() {
		String input = " ";
		System.out.println("Login Success!");
		System.out.println("Welcome: ");
		System.out.println("Park Manager: " + user.getFirstName() + " " + user.getLastName());

		do {

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
	 * Submits a job
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

		for(int i = 0; i < numOfVolunteers; i++) {

			volunteerList.add(createVolunteer());
		}	
		countJobs++;
		Job job = new Job(countJobs, startDate, endDate, parkName, details, light, medium, heavy);
		myJobs.add(job);
		//fileIO.save(users, inputJobs, inputParks);
	}
	/**
	 * Removes a job from the job list.
	 */
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
	/**
	 * Edits a job.
	 */
	public void editJob() {
		System.out.println("Enter the job ID you want to edit");
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
			System.out.println("This is the job you chose to edit " + myJobs.getJob(jobID).toString());
			System.out.println("Choose which field to edit");
			System.out.println("1)Start Date");
			System.out.println("2)End Date");
			System.out.println("3)Park Name");
			System.out.println("4)Description");
			System.out.println("5)Light Max");
			System.out.println("6)Medium Max");
			System.out.println("7)Heavy Max");
			System.out.println("8)Volunteer List");
			String input = scanner.next();
			switch(input) {
			case "1":
				myJobs.getJob(jobID).setStartDate(scanner.next());
				break;
			case "2":
				myJobs.getJob(jobID).setEndDate(scanner.next());
				break;
			case "3":
				myJobs.getJob(jobID).setParkName(scanner.next());
				break;
			case "4":
				myJobs.getJob(jobID).setDetails(scanner.next());
				break;
			case "5":
				myJobs.getJob(jobID).setLightMax(scanner.nextInt());
				break;
			case "6":
				myJobs.getJob(jobID).setMedMax(scanner.nextInt());
				break;
			case "7":
				myJobs.getJob(jobID).setHeavyMax(scanner.nextInt());
				break;
			case "8":
				//I will need to fix this later.
				System.out.println("Enter in the number of volunteers");
				int numVolunteers = Integer.parseInt(scanner.next());
				String[] volunterList = new String[numVolunteers];
				for(int i = 0; i < numVolunteers; i++) {
					System.out.println("Enter in the name");
					volunterList[i] = scanner.next();
				}	
			}
		}

	}

	public void viewUpcomingJobs() {
		System.out.println(myJobs.toString());

	}

	public Volunteer createVolunteer() {
		System.out.println("Enter the first name");
		String firstName = scanner.next();
		System.out.println("Enter the last name");
		String lastName = scanner.next();
		System.out.println("Enter the email");
		String email = scanner.next();
		System.out.println("Enter the phone number");
		String phone = scanner.next();
		Volunteer myVolunteer = new Volunteer(firstName, lastName, email, phone);

		return myVolunteer;

	}

}
