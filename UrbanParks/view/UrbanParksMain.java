package view;
import java.text.ParseException;

/**
 * Starts the program for the Urban Parks application.
 *
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class UrbanParksMain {

    /**
     * Main method for the Urban Parks user interface.
     * @param args Command line args
     * @throws ParseException if invalid date format
     */
    public static void main(String[] args) throws ParseException {
        ConsoleMain consoleMain = new ConsoleMain(); //create ConsoleMain
        consoleMain.run();           //run ConsoleMain
    }
}
