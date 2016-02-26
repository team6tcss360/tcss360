package view;
import java.io.FileNotFoundException;
import java.io.IOException;
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
     * 
     * @param args Command line args
     * @throws ParseException if invalid date format
     * @throws FileNotFoundException if provided file was not found
     * @throws IOException if error reading or writing to file
     * @throws ClassNotFoundException if model classes are not found 
     */
    public static void main(String[] args) throws ParseException, FileNotFoundException, ClassNotFoundException, IOException {
        ConsoleMain consoleMain = new ConsoleMain(); //create ConsoleMain
        consoleMain.run();           //run ConsoleMain
    }
}
