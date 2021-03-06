package model;

import java.io.Serializable;

/**
 * The abstract class that contains shared methods for all user types.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 28, 2016
 */
public abstract class User implements Serializable {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -7256145705696529503L;

    /** 
     * The user's first name.
     */
    private String firstName;
    
    /**
     * The user's last name.
     */
    private String lastName;
    
    /**
     * The user's email address.
     */
    private String email;
    
    /**
     * The user's phone number.
     */
    private String phone;
    
    /**
     * Constructs an abstract User object.
     * 
     * @param firstName the String that will be the User's first name.
     * @param lastName the String that will be the User's last name.
     * @param email the String that will be the User's email address.
     * @param phone the String that will be the User's phone number.
     */
    public User(String inputFirstName, String inputLastName, String inputEmail, 
            String inputPhone) {
        firstName = inputFirstName;
        lastName = inputLastName;
        email = inputEmail;
        phone = inputPhone;
    }
    
    /**
     * Sets the user's first name.
     * @param inputFirstName the new first name
     */
    public void setFirstName(String inputFirstName) {
        firstName = inputFirstName;
    }
    
    /**
     * Sets the user's last name.
     * @param inputFirstName the new last name
     */
    public void setLastName(String inputLastName) {
        lastName = inputLastName;
    }
    
    /**
     * Sets the user's email.
     * @param inputFirstName the new email
     */
    public void setEmail(String inputEmail) {
        email = inputEmail;
    }
    
    /**
     * Sets the user's phone number.
     * @param inputFirstName the new phone number
     */
    public void setPhone(String inputPhone) {
        phone = inputPhone;
    }
    
    /**
     * @return the first name of the User.
     */
    public String getFirstName() {
        return firstName;
    }
    
    /** @return the last name of the User. */
    public String getLastName() {
        return lastName;
    }
    
    /** @return the email address of the User. */
    public String getEmail() {
        return email;
    }
    
   /** @return the phone number of the User. */
    public String getPhone() {
        return phone;
    }
    
    /**
     * An overridden toString.
     */
    @Override
    public String toString(){
		String toReturn = "Name: "+ firstName+ " "+ lastName + " | Email: " + email + " | Phone: " + phone;
		return toReturn;   	
    }
    
    /**
     * Compares the toString()'s of both Users.
     */
    @Override
    public boolean equals(Object inputUser) {
        if (inputUser == null) {
            return false;
        }
        if (this.getClass() != inputUser.getClass()) {
            return false;
        }
        return this.toString().compareTo(inputUser.toString()) == 0;
    }
    
    /** @return toString's hashCode. */
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
