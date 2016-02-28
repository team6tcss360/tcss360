package model;

import java.io.Serializable;

/**
 * The class that contains Urban Parks staff member specific methods.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 28, 2016
 */
public class StaffMember extends User implements Serializable {

	/**
     * The serial version UID.
     */
    private static final long serialVersionUID = -6226086983164934745L;

    /**
	 * Constructs a StaffMember Object from the abstract User Class.
	 */
	public StaffMember(String inputFirstName, String inputLastName, String inputEmail, String inputPhone) {
		super(inputFirstName, inputLastName, inputEmail, inputPhone);
	}
}
