package view;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import data.FileIO;
import model.Job;
import model.JobList;
import model.Park;
import model.ParkList;
import model.ParkManager;
import model.User;
import model.UserList;

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
	 * The proper time format when using the Job constructor.
	 */
	private final String TIME_FORMAT_STRING = "Date-Time Format: mm-dd-yy hh:mma (Example 03-25-16 12:30PM)";

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
	 * Constructs the Park Manager console for the current user.
	 * 
	 * @param inputUser the user that has logged in
	 */
	public ConsoleParkManager(User inputUser, FileIO inputFileIO) {
		user = inputUser;
		fileIO = inputFileIO;
		jobs = fileIO.getJobs();
		users = fileIO.getUsers();
		parks = fileIO.getParks();
	}

	/**
	 * Runs the Park Manager console screen.
	 * @throws ParseException if invalid date format
	 */
	public void run() throws ParseException {
		String input = " ";
		System.out.println("Login Success!");

		do {
			System.out.println();
			System.out.println("----------------------Main Menu------------------------");
			System.out.println("*******************************************************");
			System.out.println("*                                                     *");
			System.out.println("*               Park Manager Main Menu!               *");
			System.out.println("*                                                     *");
			System.out.println("*******************************************************");
			System.out.println("Park Manager: " + user.getFirstName() + " " + user.getLastName());
			System.out.println();
			System.out.println("Please Enter a Command:");
			System.out.println("1) Submit new job");
			System.out.println("2) Delete a job");
			System.out.println("3) Edit a job");
			System.out.println("4) View upcoming jobs in my parks");
			System.out.println("5) View Volunteers in a park that I manage");
			System.out.println("6) Logout");  
			System.out.println("7) Exit Program");
			System.out.print(">> ");
			input = scanner.nextLine();
			switch(input) {
			case "1":
				System.out.println("*******************************************************");
				System.out.println("*                    Submit a Job                     *");
				System.out.println("*******************************************************");
				submitJob();
				break;
			case "2":
				System.out.println("*******************************************************");
				System.out.println("*                    Delete a Job                     *");
				System.out.println("*******************************************************");
				deleteJob();
				break;
			case "3":
				System.out.println("*******************************************************");
				System.out.println("*                    Edit a Job                       *");
				System.out.println("*******************************************************");
				editJob();
				break;
			case "4":
				System.out.println("*******************************************************");
				System.out.println("*                    View Upcoming Jobs               *");
				System.out.println("*******************************************************");
				viewUpcomingJobsMyPark();
				break;
			case "5":
				System.out.println("*******************************************************");
				System.out.println("*              View Volunteers In Your Parks          *");
				System.out.println("*******************************************************");
				viewVolunteersInPark();
				break;
			case "6":
				ConsoleMain console = new ConsoleMain();
				console.run();
				break;
			case "7":
				System.out.println("Exiting...");
				break;
			}
		} while(input.compareTo("7") != 0 && input.compareTo("6") != 0);

	}
	/**
	 * Displays the volunteers in the parks that are managed by the current park manager.
	 */
	public void viewVolunteersInPark() {
		System.out.println("Enter the job ID you want to view");
		System.out.print(">> ");
		int jobID = 0;
		try {
			jobID = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, needs to be a number!");
		}
		Job job = jobs.getJob(jobID);
		if(job == null) {
			System.out.println("Job doesn't exist");
		} else if (!job.isParkManager(parks, user)) {
			System.out.println("You are not the park manager.");
		} else {
			System.out.println(job.volunteerListToString());
		}

	}
	/**
	 * Submits a job.
	 * @throws ParseException if invalid date format
	 */
	public void submitJob() throws ParseException {
		if(jobs.hasMaxJobs()) {
			System.out.println("There are already too many total jobs!"); 
		} else {
			System.out.println();
			System.out.println();
			String startDate = getStartDate();
			String endDate = getEndDate(startDate);
			String parkName = getParkName();
			System.out.print("Enter in the details of the job: ");
			String details = scanner.nextLine();
			int light = getLightVolunteers();  
			int medium = getMediumVolunteers();  
			int heavy = getHeavyVolunteers();  
			int jobID = getValidJobID();
			createJob(jobID, startDate, endDate, parkName, details, light, medium, heavy);
		
		}
	}
	/**
	 * 
	 * @param jobID valid job id
	 * @param startDate start date of the job
	 * @param endDate end date of the job
	 * @param parkName park name
	 * @param details details of what the job will do.
	 * @param light number of "light" volunteers required
	 * @param medium number of "medium" volunteers required
	 * @param heavy number of "heavy" volunteers required
	 * @throws ParseException throws the exception if text isn't valid input
	 * Creates a new job and adds it to the file system after all the user input is parsed.
	 */
	public void createJob(int jobID, String startDate, String endDate, String parkName, String details, int light,
			int medium, int heavy) throws ParseException {
		if (!jobs.hasMaxJobsInWeek(startDate, endDate)) {
			//create job and save
			int beforeSize = jobs.size();
			Job job = new Job(jobID, startDate, endDate, parkName, details, light, medium, heavy);
			jobs.add(job);
			fileIO.save(users, jobs, parks);  
			if (jobs.size() > beforeSize) {
				System.out.println("Job successfully added as job number " + jobID +".");
			} else {
				System.out.println("Job creation failed.");
			}
			pause();
		} else {
			System.out.println("There are too many jobs in that week!");
		}
		
	}

	/**
	 * Removes a job from the job list.
	 */
	public void deleteJob() {
		System.out.println("Enter the job ID you want to delete:");
		System.out.print(">> ");
		int jobID = 0;
		try {
			jobID = Integer.parseInt(scanner.next());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, needs to be a number!");
		}
		Job job = jobs.getJob(jobID);
		if (job == null) {
			System.out.println("Job doesn't exist.");
		} else if (job.isParkManager(parks, user)) {
			System.out.println("Job exists and we are removing it!");
			jobs.remove(job);
		} else {
			System.out.println("You are not the park manager.");
		}
		fileIO.save(users, jobs, parks);
		pause();
	}

	/**
	 * Edits a job.
	 */
	public void editJob() {
		System.out.println("Enter the job ID you want to edit");
		System.out.print(">> ");
		int jobID = 0;
		String input = "";
		try {
			jobID = Integer.parseInt(scanner.next());
		} catch (NumberFormatException e) {
			System.out.println("Invalid input, needs to be a number!");
		}
		Job currentJob = jobs.getJob(jobID);
		if(currentJob == null) {
			System.out.println("Job doesn't exist");
		} else if (!currentJob.isParkManager(parks, user)) {
			System.out.println("You are not the park manager.");
		} else if (currentJob.hasVolunteers()) {
			System.out.println("The job has volunteers, you cannot edit it.");
		} else {
			do {
				System.out.println();
				System.out.println("*********************Urban Parks***********************");
				System.out.println("----------------------Edit Menu------------------------");
				System.out.println("This is the job you chose to edit: " 
						+"\n"+ currentJob.toString());
				System.out.println();
				System.out.println("Choose which field to edit");
				System.out.println("1) Start Date");
				System.out.println("2) End Date");
				System.out.println("3) Park Name");
				System.out.println("4) Description");
				System.out.println("5) Light Max");
				System.out.println("6) Medium Max");
				System.out.println("7) Heavy Max");
				System.out.println("8) Logout");
				System.out.print(">> ");
				input = scanner.nextLine();
				switch(input) {
				case "1":
					System.out.println(TIME_FORMAT_STRING);
					System.out.println("Enter the start date & time: ");
					System.out.print(">> ");
					try {
						String startDate = scanner.nextLine();
						String endDate = jobs.formatDate(currentJob.getEndDate());
						if (jobs.passesBusinessRulesEdit(currentJob, startDate, endDate)) {
							currentJob.setStartDate(startDate);
						} else {
							System.out.println("Invalid date.");
						}
					} catch (ParseException e) {
						System.out.println("Invalid date format.  Use:");
						System.out.println(TIME_FORMAT_STRING);
					}
					break;

				case "2":
					System.out.println(TIME_FORMAT_STRING);
					System.out.print("Enter the end date & time: ");
					System.out.print(">> ");
					try {
						String endDate = scanner.nextLine();
						String startDate = jobs.formatDate(currentJob.getStartDate());
						if (jobs.passesBusinessRulesEdit(currentJob, startDate, endDate)) {
							currentJob.setEndDate(endDate);
						} else {
							System.out.println("Invalid date.");
							pause();
						}
					} catch (ParseException e) {
						System.out.println("Invalid date format.  Use:");
						System.out.println(TIME_FORMAT_STRING);
					}
					break;

				case "3":
					System.out.print("Enter the park name: ");
					String parkName = scanner.nextLine();
					Park thePark = parks.getPark(parkName);
					if (thePark == null) {
						System.out.println("Park Not Found.");
					} else if (!thePark.isParkManager(user)) {
						System.out.println("You are not the manager of that park.");
					} else {
						currentJob.setParkName(parkName);
					} 
					break;

				case "4":
					System.out.print("Enter in the details of the job: ");
					currentJob.setDetails(scanner.nextLine());
					break;

				case "5":
					System.out.print("Enter in the number of volunteers of the light category: ");
					try { 
						currentJob.setLightMax(scanner.nextInt());
					} catch (InputMismatchException e) {
						System.out.println("Invalid input.");
					}
					break;

				case "6":
					System.out.print("Enter in the number of volunteers of the medium category: ");
					try { 
						currentJob.setMedMax(scanner.nextInt());
					} catch (InputMismatchException e) {
						System.out.println("Invalid input.");
					}
					break;

				case "7":
					System.out.print("Enter in the number of volunteers of the heavy category: ");
					try { 
						currentJob.setHeavyMax(scanner.nextInt());
					} catch (InputMismatchException e) {
						System.out.println("Invalid input.");
					}
					break;

				case "8":
					break;
				}
			} while(input.compareTo("8") !=0);
		}
		fileIO.save(users, jobs, parks);
	}

	/**
	 * Pause the console until user is ready.
	 */
	private void pause() {
		System.out.println("<<Press any key to continue>>");
		scanner.nextLine();        
	}

	/**
	 * Prints out all of the upcoming jobs in Parks that this User manages.
	 */
	public void viewUpcomingJobsMyPark() {
		System.out.print(jobs.getSummariesMyParks(parks, (ParkManager) user));
		pause();
	}
	public String getStartDate() {
		System.out.println();
		System.out.println();
		String startDate = "";
		while (true) {
			System.out.println(TIME_FORMAT_STRING);
			System.out.print("Enter the start date & time: ");
			try {
				startDate = scanner.nextLine();
				if (jobs.hasPastDate(startDate)) {
					System.out.println("You can't create a job in the past!");
					continue;
				} 
				if (jobs.isTooFarInFuture(startDate)) {
					System.out.println("You can't create a job " 
							+ JobList.MAX_SCHEDULING_IN_FUTURE + "+ days in the future!");
					continue;
				} else {
					break;
				}
			} catch (ParseException e) {
				System.out.println("Invalid date format.  Use:");
				continue;
			}
		}
		return startDate;
	}
	public String getEndDate(String startDate) {
		String endDate = ""; 
		while (true) {
			System.out.println(TIME_FORMAT_STRING);
			System.out.print("Enter the end date & time: ");
			try {
				endDate = scanner.nextLine();
				if (jobs.hasEndBeforeStart(startDate, endDate)) {
					System.out.println("You can't end before the start!");
					continue;
				}
				if (!jobs.hasValidDuration(startDate, endDate)) {
					System.out.println("Your job cannot be more than " + JobList.MAX_JOB_LENGTH + " days!");
					continue;
				} else {
					break;
				}
			} catch (ParseException e) {
				System.out.println("Invalid date format.  Use:");
				continue;
			}
		}
		return endDate;
	}
	/**
	 * Gets the park name
	 * @return the park name for a job
	 */
	public String getParkName() {
		String parkName = "";
		while (true) {
			System.out.print("Enter the park name: ");
			parkName = scanner.nextLine();
			Park thePark = parks.getPark(parkName);
			if (thePark == null) {
				System.out.println("Park Not Found.");
				continue;
			} else if (!thePark.isParkManager(user)) {
				System.out.println("You are not the manager of that park.");
				continue;
			} else {
				break; //valid park is found
			}
		}
		return parkName;
	}
	/**
	 * Gets the number of light level volunteers
	 * @return number of light volunteers
	 */
	public int getLightVolunteers() {
		int light = 0;  
		while (true) {
			System.out.print("Enter in the number of people for the light category: ");
			try {
				String string_light = scanner.nextLine();
				light = Integer.parseInt(string_light);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid number.");
				continue;
			}
		}
		return light;
	}
	public int getMediumVolunteers() {
		int medium = 0;
		while (true) {
			System.out.print("Enter in the number of people for the medium category: ");
			try {
				String string_medium = scanner.nextLine();
				medium = Integer.parseInt(string_medium);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid number.");
				continue;
			}
		}   
		return medium;
	}
	public int getHeavyVolunteers() {
		int heavy = 0;
		while (true) {
			System.out.print("Enter in the number of people for the heavy category: ");
			try {
				String string_heavy = scanner.nextLine();
				heavy = Integer.parseInt(string_heavy);
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid number.");
				continue;
			}
		}
		return heavy;
	}
	public int getValidJobID() {
		int jobID = 1;
		while (true) { //finds next available unique jobID
			if (jobs.isJobIDtaken(jobID)) { //check if taken
				jobID++; //check next int
				continue;
			} else { //found a good one
				break;
			}
		}
		return jobID;
	}
}
