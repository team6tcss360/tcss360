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
     * Constructs the Park Manager console for the current user.
     * 
     * @param currentUser the user that has logged in
     */
    public ConsoleParkManager(User currentUser) {
        user = currentUser;
    }

    /**
     * Runs the Park Manager console screen.
     */
    public void run() {
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
        String input = scanner.nextLine().trim(); //Get user input
        input = input.substring(3); //cuts off ">> "
        
        //TODO Stuff
    }
}
