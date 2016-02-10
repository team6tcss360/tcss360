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
     * Contains the parks that Urban Parks application will use.
     */
    private ParkList parks;

	/**
	 * JobList instance
	 */
	private JobList jobs;

	/**
	 * Used for JobID
	 */
	private int countJobs;

	/**
	 * Constructs the Park Manager console for the current user.
	 * 
	 * @param currentUser the user that has logged in
	 */
	public ConsoleParkManager(User currentUser, FileIO inputFileIO) {
		user = currentUser;
		countJobs = 1;
		fileIO = inputFileIO;
		jobs = fileIO.getJobs();
		users = fileIO.getUsers();
		parks = fileIO.getParks();

		
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
			input = scanner.nextLine();
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
		System.out.print("Enter the start date: (ddmmyyyy)");
		String startDate = scanner.nextLine();

		System.out.print("Enter the end date: (ddmmyyyy)");
		String endDate = scanner.nextLine();

		System.out.print("Enter the park name");
		String parkName = scanner.nextLine();

		System.out.print("Enter in the details of the job");
		String details = scanner.nextLine();

		System.out.print("Enter in the number of people for the light job");
		String string_light = scanner.nextLine();
		int light = Integer.parseInt(string_light);
	

		System.out.print("Enter in the number of volunteers of the medium job");
		String string_med = scanner.nextLine();
		int medium = Integer.parseInt(string_med);

		System.out.print("Enter in the number of volunteers for the heavy job");
		String string_hev = scanner.nextLine();
		int heavy = Integer.parseInt(string_hev);

		countJobs++;
		Job job = new Job(countJobs, startDate, endDate, parkName, details, light, medium, heavy);
		jobs.add(job);
		fileIO.save(users, jobs, parks);
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
		Job job = jobs.getJob(jobID);
		if(job == null) {
			System.out.println("Job doesn't exist");
		} else {
			System.out.println("Job exists and we are removing it!");
			jobs.remove(job);
		}
		countJobs--;
		fileIO.save(users, jobs, parks);
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
		Job job = jobs.getJob(jobID);
		if(job == null) {
			System.out.println("Job doesn't exist");
		} else {
			System.out.println("This is the job you chose to edit " + jobs.getJob(jobID).toString());
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
				jobs.getJob(jobID).setStartDate(scanner.nextLine());
				break;
			case "2":
				jobs.getJob(jobID).setEndDate(scanner.next());
				break;
			case "3":
				jobs.getJob(jobID).setParkName(scanner.next());
				break;
			case "4":
				jobs.getJob(jobID).setDetails(scanner.next());
				break;
			case "5":
				jobs.getJob(jobID).setLightMax(scanner.nextInt());
				break;
			case "6":
				jobs.getJob(jobID).setMedMax(scanner.nextInt());
				break;
			case "7":
				jobs.getJob(jobID).setHeavyMax(scanner.nextInt());
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
		fileIO.save(users, jobs, parks);
	}

	public void viewUpcomingJobs() {
		System.out.println(jobs.toString());

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
