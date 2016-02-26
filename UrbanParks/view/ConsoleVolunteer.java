package view;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import data.FileIO;
import model.Job;
import model.JobList;
import model.ParkList;
import model.User;
import model.UserList;
import model.Volunteer;

/**
 * Runs the volunteer's console screen for the Urban Parks application.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 26, 2016
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
	 * @param inputUser the user that has logged in
	 * @param fileIO 
	 */
	public ConsoleVolunteer(User inputUser, FileIO inputFileIO) {
		scanner.useDelimiter("\\n");
		user = inputUser;
		fileIO = inputFileIO;
		users = fileIO.getUsers();
		jobs = fileIO.getJobs();
		parks = fileIO.getParks();
	}

	/**
	 * Runs the volunteer console screen.
	 * @throws ParseException if invalid date format
     * @throws FileNotFoundException if provided file was not found
     * @throws IOException if error reading or writing to file
     * @throws ClassNotFoundException if model classes are not found 
	 */
	public void run() throws ParseException, FileNotFoundException, ClassNotFoundException, IOException {
		String input;
		System.out.println("Login Success!");
		do {
			System.out.println();
			System.out.println("----------------------Main Menu------------------------");
			System.out.println("*******************************************************");
			System.out.println("*                                                     *");
			System.out.println("*                    Volunter Menu!                   *");
			System.out.println("*                                                     *");
			System.out.println("*******************************************************");
			System.out.println("Volunteer: " + user.getFirstName() + " " + user.getLastName());
			System.out.println();
			System.out.println("Please Enter a Command:");
			System.out.println("1) View upcoming jobs");
			System.out.println("2) View jobs by job ID");
			System.out.println("3) Volunteer for a job");
			System.out.println("4) View jobs you signed up for");
			System.out.println("5) Logout");
			System.out.println("6) Exit Program");  
			System.out.print(">> ");
			input = scanner.nextLine(); //Get user input
			int jobID = 0;
			switch(input) {
			case "1":
				System.out.println("*******************************************************");
				System.out.println("*                    View All Jobs                    *");
				System.out.println("*******************************************************");
				viewAllJobs();
				//				System.out.println(users.getVolunteerLastNames());
				break;

			case "2":
				System.out.println("*******************************************************");
				System.out.println("*                    View Job by ID                   *");
				System.out.println("*******************************************************");
				System.out.println("Enter the job ID that you want to view:");
				System.out.print(">> ");
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
				System.out.println("*******************************************************");
				System.out.println("*                    Volunteer for a Job              *");
				System.out.println("*******************************************************");
				System.out.println("Enter the job ID that you want to volunteer for:");
				System.out.print(">> ");
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
				System.out.println("*******************************************************");
				System.out.println("*                    View Your Jobs                   *");
				System.out.println("*******************************************************");
				viewMyJobs();
				break;

			case "5":
				ConsoleMain console = new ConsoleMain();
				console.run();

			case "6":
				System.out.println("Exiting...");
				break;
			}
		} while(input.compareTo("5") != 0 && input.compareTo("6") != 0);
	}

	/**
	 * Allows the volunteer to view all the current jobs
	 */
	public void viewAllJobs() {
		System.out.print(jobs.getSummaries());
		pause();
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
		pause();
	}

	/**
	 * Allows a Volunteer to sign up for a job based off of it's unique ID
	 * @param inputJobID
     * @throws FileNotFoundException if provided file was not found
     * @throws IOException if error reading or writing to file
	 */
	public void signUpForJob(int inputJobID) throws FileNotFoundException, IOException {
		String level = "";
		boolean isValid = isValidJob(inputJobID);
		if(isValid){
			System.out.println("What level of difficulty would you like?");
			System.out.println("1) Light");
			System.out.println("2) Medium");
			System.out.println("3) Heavy");
			System.out.print(">> ");
			level = scanner.nextLine();
			switch(level) {
			case "1":
				signUpForLight(inputJobID);
				break;

			case "2":
				signUpForMedium(inputJobID);
				break;

			case "3":
				signUpForHeavy(inputJobID);
				break;

			default: 
				System.out.println("That is not a valid category.");
				break;
			}
		}
		fileIO.save(users, jobs, parks);
		pause();
	}
	/**
	 * Signs the user up for a heavy level job
	 * @param inputJobID
	 */
	public void signUpForHeavy(int inputJobID) {
		if (jobs.getJob(inputJobID).hasHeavyMax()) {
			System.out.println("That category is full!");
		} else {
			jobs.getJob(inputJobID).addHeavyVolunteer((Volunteer) user);
			System.out.println("You signed up for job " + inputJobID 
					+ " in the heavy category!");
		}
	}
	/**
	 * Signs the user up for a medium level job.
	 * @param inputJobID
	 */
	public void signUpForMedium(int inputJobID) {
		if (jobs.getJob(inputJobID).hasMedMax()) {
			System.out.println("That category is full!");
		} else {
			jobs.getJob(inputJobID).addMedVolunteer((Volunteer) user);
			System.out.println("You signed up for job " + inputJobID 
					+ " in the medium category!");
		}
	}
	/**
	 * Signs the user up for a light level job.
	 * @param inputJobID
	 */
	public void signUpForLight(int inputJobID) {
		if (jobs.getJob(inputJobID).hasLightMax()) {
			System.out.println("That category is full!");
		} else {
			jobs.getJob(inputJobID).addLightVolunteer((Volunteer) user); 
			System.out.println("You signed up for job " + inputJobID 
					+ " in the light category!");
		}
	}
	/**
	 * Checks to see if the job ID exists and is a valid job.
	 * @param inputJobID
	 * @return boolean value if job ID actually corresponds to a real job.
	 */
	public boolean isValidJob(int inputJobID) {
		boolean valid = false;
		Job temp = jobs.getJob(inputJobID);
		if(temp == null) {
			System.out.println("Job doesn't exist.");
		} else if (temp.isVolunteer((Volunteer) user)) {
			System.out.println("You are already signed up for this job!");
		} else if (temp.isInPast()) {
			System.out.println("This job already happened!");
		} else if (jobs.hasJobOnSameDay((Volunteer) user, temp)) {
			System.out.println("You are already signed up for a job on that day!");
		} else if (temp != null){
			valid = true;
		}
		
		return valid;
	}
	/**
	 * Displays the jobs that the user is signed up for.
	 */
	public void viewMyJobs() {
		System.out.print(jobs.getSummariesMyVolunteerJobs((Volunteer) user));
		pause();
	}

	/**
	 * Pause the console until user is ready.
	 */
	private void pause() {
		System.out.println("<<Press any key to continue>>");
		scanner.nextLine();        
	}

}
