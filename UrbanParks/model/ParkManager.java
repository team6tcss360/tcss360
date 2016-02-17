package model;

import java.io.Serializable;

/**
 * The class that contains ParkManager specific methods.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class ParkManager extends User implements Serializable {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -5885352666198015690L;
    
    /**
     * Creates a ParkManager through the User constructor.
     */
    public ParkManager(String inputFirstName, String inputLastName, String inputEmail, String inputPhone) {
        super(inputFirstName, inputLastName, inputEmail, inputPhone);
    }    
}
