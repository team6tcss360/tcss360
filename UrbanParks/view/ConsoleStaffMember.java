package view;
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
	@SuppressWarnings("unused") //may need it later
    private ParkList parks;

	/**
	 * Constructs the Staff Member console for the current user.
	 * 
	 * @param inputUser the user that has logged in
	 * @param fileIO 
	 */
	public ConsoleStaffMember(User inputUser, FileIO inputFileIO) {
		scanner.useDelimiter("\\n");
		user = inputUser;
		fileIO = inputFileIO;
		users = fileIO.getUsers();
		jobs = fileIO.getJobs();
		parks = fileIO.getParks();
	}

	/**
	 * Runs the Staff Member console screen.
	 * @throws ParseException if invalid date format
	 */
	public void run() throws ParseException {
		String myInput;
		System.out.println("Login Success!");
		do {
		    System.out.println();
            System.out.println("----------------------Main Menu------------------------");
	        System.out.println("*******************************************************");
	        System.out.println("*                                                     *");
	        System.out.println("*               Urban Parks Staff Menu!               *");
	        System.out.println("*                                                     *");
	        System.out.println("*******************************************************");
		    System.out.println("Urban Parks Staff: " + user.getFirstName() + " " + user.getLastName());
	        System.out.println();
	        System.out.println("Please Enter a Command:");
	        System.out.println("1) Display all volunteers");
			System.out.println("2) Search volunteers by last name");
			System.out.println("3) View a summary of all upcoming jobs");
			
			System.out.println("4) Display summary of a job by job ID");
			System.out.println("5) Logout"); 
			System.out.println("6) Exit Program");  
			System.out.print(">> ");
			myInput = scanner.nextLine(); //Get user input
			int jobID = 0;
			switch(myInput) {
    			case "1":
    				System.out.println("*******************************************************");
    				System.out.println("*                    Display Volunteers               *");
    				System.out.println("*******************************************************");
                    displayVolunteers();
                    break;
                    
    			case "2":
    				System.out.println("*******************************************************");
    				System.out.println("*                    Search for Volunteers            *");
    				System.out.println("*******************************************************");
    				System.out.println("Enter in the last name you are looking for.");
    				System.out.print(">> ");
    	            String lastName = scanner.nextLine();
    				searchVolunteer(lastName);
    				break;
    				
    			case "3":
    				System.out.println("*******************************************************");
    				System.out.println("*                    Display Jobs                     *");
    				System.out.println("*******************************************************");
    				displayJobs();
    				break;

    			case "4":
    				System.out.println("*******************************************************");
    				System.out.println("*                    View Job by ID                   *");
    				System.out.println("*******************************************************");
    				System.out.println("Enter job ID:");
    				System.out.print(">> ");
    				String string_jobID = scanner.nextLine();
    				try {
    				jobID = Integer.parseInt(string_jobID);
    				} catch(NumberFormatException e) {
    					System.out.println("Invalid Input");
    					break;
    				}
    				getJob(jobID);
    				break;
    				
    			case "5":
    				ConsoleMain console = new ConsoleMain();
    				console.run();
    				break;
    				
    			case "6":
    			    System.out.println("Exiting...");
    			    break;
			}
		} while(myInput.compareTo("6") != 0 && myInput.compareTo("5") != 0);
	}

	/**
	 * Displays the job by job ID
	 * @param inputJobID
	 */
	public void getJob(int inputJobID) {
		Job temp = jobs.getJob(inputJobID);
		if(temp == null) {
			System.out.println("Job ID doesn't exist");
		} else {
			System.out.println(temp.toString());
		}
		pause();
	}
	/**
	 * Displays all volunteers
	 */
	public void displayVolunteers() {
	    System.out.println("Volunteers: ");
		for(int i = 0; i < users.size(); i++) {
			if(users.getArrayList().get(i) instanceof Volunteer) {
				System.out.println(users.getArrayList().get(i).toString());
			}
		}
		pause();
	}

	public void displayJobs() {
		System.out.print(jobs.getSummaries());
		pause();
	}
	/**
	 * Searches volunteer by last name
	 * @param inputLastName
	 */
	public void searchVolunteer(String inputLastName) {
		int index = 0;
		boolean isFound = false;
		for(int i = 0; i < users.size(); i++) {
			if(users.getArrayList().get(i) instanceof Volunteer) {
				if (users.getArrayList().get(i).getLastName().toLowerCase().compareTo(inputLastName.toLowerCase()) == 0) {
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
			System.out.println("Volunteer doesn't exist. \n");
		}
		pause();
	}
	
	/**
     * Pause the console until user is ready.
     */
    private void pause() {
        System.out.println("<<Press any key to continue>>");
        scanner.nextLine();        
    }
    /**
     * Ascii Art Penguin
     */

    
}

