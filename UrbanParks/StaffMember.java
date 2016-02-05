/**
 * The class that contains Urban Parks staff member specific methods.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 4, 2016
 */
public class StaffMember extends User {

	/**
     * The serial version UID.
     */
    private static final long serialVersionUID = -6226086983164934745L;

    /**
	 * Creates a StaffMember through the User constructor.
	 */
	public StaffMember(String inputFirstName, String inputLastName, String inputEmail, String inputPhone,
			int inputUserID) {
		super(inputFirstName, inputLastName, inputEmail, inputPhone, inputUserID);
	}
}
