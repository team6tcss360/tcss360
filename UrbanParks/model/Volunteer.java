package model;

import java.io.Serializable;

/**
 * The class that contains volunteer specific methods.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 28, 2016
 */
public class Volunteer extends User implements Serializable {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 6857145170865256803L;
    
    /**
     * Constructs a Volunteer object from the abstract User Class.
     */
    public Volunteer(String inputFirstName, String inputLastName, 
            String inputEmail, String inputPhone) {
        super(inputFirstName, inputLastName, inputEmail, inputPhone);
    }
}
