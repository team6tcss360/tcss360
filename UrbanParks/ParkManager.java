/**
 * The class that contains ParkManager specific methods.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class ParkManager extends User {

    /**
     * Creates a ParkManager through the User constructor.
     */
    public ParkManager(String inputFirstName, String inputLastName, String inputEmail, String inputPhone,
            int inputUserID) {
        super(inputFirstName, inputLastName, inputEmail, inputPhone, inputUserID);
    }

    /**
     * Returns a list of job summaries in the parks that they manage.
     * 
     * @return Summaries of jobs as a String.
     */
    public String getJobs() {
        return null;
    }
}
