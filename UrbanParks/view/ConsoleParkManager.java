package view;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	private final String TIME_FORMAT_STRING = "Date-Time Format: mm-dd-yy hh:mma (Example 02-25-16 12:30PM)";
	
    /**
     * The format to use on dates.
     */
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM-dd-yy h:mma");

    private static final int MAX_JOB_LENGTH = 2;

    private static final int MAX_SCHEDULING_IN_FUTURE = 90;

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
	 * @param currentUser the user that has logged in
	 */
	public ConsoleParkManager(User currentUser, FileIO inputFileIO) {
		user = currentUser;
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
		System.out.println("Welcome: ");
		
		do {
		    System.out.println();
			System.out.println("Park Manager: " + user.getFirstName() + " " + user.getLastName());
			System.out.println();
			System.out.println("Please Enter a Command:");
			System.out.println("1) Submit new job");
			System.out.println("2) Delete a job");
			System.out.println("3) Edit a job");
			System.out.println("4) View upcoming jobs in my parks");
			System.out.println("5) View Volunteers in a park that I manage");
			System.out.println("6) Back");  
			System.out.println("7) Exit");
			System.out.print(">> ");
			input = scanner.nextLine();
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
    				viewUpcomingJobsMyPark();
    				break;
    			case "5":
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
	 * Submits a job
	 * @throws ParseException if invalid date format
	 */
	public void submitJob() throws ParseException {
	    if(jobs.hasMaxJobs()) {
	        System.out.println("There are already too many total jobs!"); 
	    } else {
    	    String startDate = "";
    	    GregorianCalendar startTemp;
    	    
    	    while (true) {
    		    System.out.println(TIME_FORMAT_STRING);
    	        System.out.print("Enter the start date & time: ");
    			try {
                    startDate = scanner.nextLine();
                    startTemp = convertToCalender(startDate);
                    GregorianCalendar now = new GregorianCalendar();
                    if (startTemp.before(now)) {
                        System.out.println("You can't create a job in the past!");
                        continue;
                    } 
                    now.add(Calendar.DAY_OF_MONTH, MAX_SCHEDULING_IN_FUTURE);
                    if (startTemp.after(now)) {
                        System.out.println("You can't create a job " 
                                + MAX_SCHEDULING_IN_FUTURE + "+ days in the future!");
                        continue;
                    } else {
                        break;
                    }
                } catch (ParseException e) {
                    System.out.println("Invalid date format.  Use:");
                    continue;
                }
            }
    		
    		String endDate = ""; 
    		GregorianCalendar end;
    		while (true) {
    	        System.out.println(TIME_FORMAT_STRING);
    	        System.out.print("Enter the end date & time: ");
    	        try {
    	            endDate = scanner.nextLine();
                    end = convertToCalender(endDate);
                    if (end.before(startTemp)) {
                        System.out.println("You can't end before the start!");
                        continue;
                    }
                    startTemp.set(Calendar.HOUR_OF_DAY, 0);
                    startTemp.set(Calendar.MINUTE, 0);
                    startTemp.set(Calendar.SECOND, 0);
                    startTemp.set(Calendar.MILLISECOND, 0);
                    startTemp.add(Calendar.DAY_OF_MONTH, MAX_JOB_LENGTH);
                    if (end.after(startTemp)) {
                        System.out.println("Your job cannot be more than 2 days!");
                        continue;
                    } else {
                        break;
                    }
    	        } catch (ParseException e) {
    	            System.out.println("Invalid date format.  Use:");
    	            continue;
    	        }
    	    }
    		
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
    
    		System.out.print("Enter in the details of the job: ");
    		String details = scanner.nextLine();
    
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
            
            int jobID = 1; //start search at 1
            while (true) { //finds next available unique jobID
        		if (jobs.isJobIDtaken(jobID)) { //check if taken
        		    jobID++; //check next int
        		    continue;
        		} else { //found a good one
        		    break;
        		}
            }
            
            if (!jobs.hasMaxJobsInWeek(startDate, endDate)) {
                //create job and save
        		Job job = new Job(jobID, startDate, endDate, parkName, details, light, medium, heavy);
                jobs.add(job);
                fileIO.save(users, jobs, parks);  
            } else {
                System.out.println("There are too many jobs in that week!");
            }
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
		System.out.println();
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
		Job job = jobs.getJob(jobID);
		if(job == null) {
			System.out.println("Job doesn't exist");
		} else if (!job.isParkManager(parks, user)) {
            System.out.println("You are not the park manager.");
        } else {
			do {
			    System.out.println();
				System.out.println("This is the job you chose to edit: " 
				        +"\n"+ jobs.getJob(jobID).toString());
				System.out.println();
				System.out.println("Choose which field to edit");
				System.out.println("1) Start Date");
				System.out.println("2) End Date");
				System.out.println("3) Park Name");
				System.out.println("4) Description");
				System.out.println("5) Light Max");
				System.out.println("6) Medium Max");
				System.out.println("7) Heavy Max");
				System.out.println("8) Back");
				System.out.print(">> ");
				input = scanner.nextLine();
				switch(input) {
    				case "1":
    				    System.out.println(TIME_FORMAT_STRING);
    					System.out.println("Enter the start date & time: ");
    					System.out.print(">> ");
    					try {
    					    jobs.getJob(jobID).setStartDate(scanner.nextLine());
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
    					    jobs.getJob(jobID).setStartDate(scanner.nextLine());
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
    					    jobs.getJob(jobID).setParkName(parkName);
                        } 
    					break;
    					
    				case "4":
    					System.out.print("Enter in the details of the job: ");
    					jobs.getJob(jobID).setDetails(scanner.nextLine());
    					break;
    					
    				case "5":
    					System.out.print("Enter in the number of volunteers of the light category: ");
    					try { 
    					    jobs.getJob(jobID).setLightMax(scanner.nextInt());
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input.");
                        }
    					break;
    					
    				case "6":
    					System.out.print("Enter in the number of volunteers of the medium category: ");
    					try { 
                            jobs.getJob(jobID).setMedMax(scanner.nextInt());
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input.");
                        }
    					break;
    					
    				case "7":
    					System.out.print("Enter in the number of volunteers of the heavy category: ");
    					try { 
                            jobs.getJob(jobID).setHeavyMax(scanner.nextInt());
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
	 * Prints out all of the upcoming jobs in Parks that this User manages.
	 */
	public void viewUpcomingJobsMyPark() {
		System.out.print(jobs.getSummariesMyParks(parks, (ParkManager) user));
	}
	
	/**
     * Convert a string date to a GregorianCalender object.
     * @param theDate, MM-dd-yy h:mma (March 1st, 2016 at 9am is 03-01-16 9:00AM)
     * @return GregorianCalender formatted date.
     * @throws ParseException if invalid date format
     */
    public GregorianCalendar convertToCalender(String inputDate) throws ParseException {
        Date parsed = DATE_FORMAT.parse(inputDate);
        GregorianCalendar newCalendar = new GregorianCalendar();
        newCalendar.setTime(parsed);
        return newCalendar;     
    }
}
