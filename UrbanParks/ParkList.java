import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains a collection of Urban Parks parks.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class ParkList implements Serializable {
    
	/**
     * The serial version UID.
     */
    private static final long serialVersionUID = 870375065703530912L;
    
    /**
     * Park List.
     */
	List<Park> myParks;
	
	/**
	 * Construct the ParkList Array
	 */
	public ParkList() {
		myParks = new ArrayList<Park>();
	}
	
	/**
	 * Add a park to the system.
	 * @param park The park to be added to our system.
	 */
    public void add(Park park) {
    	if(park == null) {
    		System.out.println("Invalid Park Entry!");
    	}
    	myParks.add(park);
    }
    
    /**
     * Remove a park from the system.
     * @param park Park to be removed
     */
    public void removePark(Park park) {
    	int index = findIndex(park);
    	if(index != -1) {
    		myParks.remove(index);
    	} else {
    		System.out.println("The park you were trying to remove doesn't exist in our system.");
    	}
    }
    /**
     * Find the index of which a park exists in the system
     * @param park Park to be found
     * @return Returns the index of where the park exists inside of the arraylist.
     */
    public int findIndex(Park park) {
    	for(int i = 0; i < myParks.size(); i++) {
    		if(myParks.get(i).equals(park)) {
    			return i;
    		}
    	}
    	return -1;
    }
    /**
     * ToString method for the Array list.
     */
    public String toString() {
    	String str = " ";
    	for(int i = 0; i < myParks.size(); i++) {
    		str += myParks.toString() + "\n";
    	}
    	return str;
    }
    
    /**
     * This is the default implementation of writeObject.
     */
    private void writeObject(ObjectOutputStream aOutputStream) 
            throws IOException {
        //perform the default serialization for all non-transient, non-static fields
        aOutputStream.defaultWriteObject();
    }

}
