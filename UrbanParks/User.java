import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * The abstract class that contains shared methods for all user types.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public abstract class User implements Serializable {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 8520622463070772155L;

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
     * Creates a User based upon input data.
     * 
     * @param firstName user's first name
     * @param lastName user's last name
     * @param email user's email address
     * @param phone user's phone number
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
     * Gets the user's first name.
     */
    public String getFirstName() {
        return firstName;
    }
    
    /**
     * Gets the user's last name.
     */
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Gets the user's email.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Gets the user's phone number.
     */
    public String getPhone() {
        return phone;
    }
    
    /**
     * This is the default implementation of writeObject.
     */
    private void writeObject(ObjectOutputStream aOutputStream) 
            throws IOException {
        //perform the default serialization for all non-transient, non-static fields
        aOutputStream.defaultWriteObject();
    }
    
    @Override
    public String toString(){
		String toReturn = "Name: "+ firstName+ " "+ lastName + "\nE-Mail: " + email + "\nPhone: " + phone;
		return toReturn;
    	
    }
}
