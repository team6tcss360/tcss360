import java.io.Serializable;

/**
 * Contains information for an Urban Parks park.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class Park implements Serializable {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = -5745395721282726488L;

    /**
     * The park's name.
     */
    private String parkName;
    
    /**
     * The park's location.
     */
    private String location;
    
    /**
     * The park manager's first name.
     */
    private String parkManagerFirstName;
    
    /**
     * The park manager's last name.
     */
    private String parkManagerLastName;
  
    /**
     * Construct's a Park object.
     * 
     * @param inputParkName The park's name.
     * @param inputLocation The park's location.
     * @param inputParkManagerFirstName The park manager's first name.
     * @param inputParkManagerLastName The park manager's last name.
     */
    public Park(String inputParkName, String inputLocation, String inputParkManagerFirstName, 
            String inputParkManagerLastName) {
        parkName = inputParkName;
        location = inputLocation;
        parkManagerFirstName = inputParkManagerFirstName;
        parkManagerLastName = inputParkManagerLastName;
    }

    /**
     * Sets the park's name.
     * @param inputParkName the new park name
     */
    public void setParkName(String inputParkName) {
        parkName = inputParkName;
    }
    
    /**
     * Sets the park's location.
     * @param inputLocation the new location
     */
    public void setLastName(String inputLocation) {
        location = inputLocation;
    }
    
    /**
     * Sets the park manager's first name.
     * @param inputParkManagerFirstName the new first name
     */
    public void setParkManagerFirstName(String inputParkManagerFirstName) {
        parkManagerFirstName = inputParkManagerFirstName;
    }
    
    /**
     * Sets the park manager's last name.
     * @param inputParkManagerLastName the new last name
     */
    public void setParkManagerLastName(String inputParkManagerLastName) {
        parkManagerLastName = inputParkManagerLastName;
    }
    
    /**
     * Gets the park's name.
     */
    public String getParkName() {
        return parkName;
    }
    
    /**
     * Gets the park's location.
     */
    public String getLocation() {
        return location;
    }
    
    /**
     * Gets the park manager's first name.
     */
    public String getParkManagerFirstName() {
        return parkManagerFirstName;
    }
    
    /**
     * Gets the park manager's last name.
     */
    public String getParkManagerLastName() {
        return parkManagerLastName;
    }
}
