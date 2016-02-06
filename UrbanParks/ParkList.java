import java.util.ArrayList;

/**
 * Contains a collection of Urban Parks parks.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class ParkList {
    
    /**
     * Park List.
     */
    ArrayList<Park> parks;
	
	/**
	 * Construct the ParkList Array
	 */
	public ParkList() {
		parks = new ArrayList<Park>();
	}
	
	   /**
     * Construct the ParkList Array
     */
    public ParkList(ArrayList<Park> inputArray) {
        parks = inputArray;
    }
	
	/**
	 * Add a park to the system.
	 * @param park The park to be added to our system.
	 */
    public void add(Park park) {
    	if(park == null) {
    		System.out.println("Invalid Park Entry!");
    	}
    	parks.add(park);
    }
    
    /**
     * Remove a park from the system.
     * @param park Park to be removed
     */
    public void removePark(Park park) {
    	int index = findIndex(park);
    	if(index != -1) {
    		parks.remove(index);
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
    	for(int i = 0; i < parks.size(); i++) {
    		if(parks.get(i).equals(park)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    /**
     * Returns the size of the ParkList
     * 
     * @return Returns size of ParksList.
     */
    public int size(){
    	return parks.size();
    }
    
    
    /**
     * Returns the Park at a given index in ParkList
     * 
     * @param inputIndex int for index.
     * @return Park at the given index.
     */
    public Park getParkAt(int inputIndex){
    	return parks.get(inputIndex);
    }
    
    /**
     * ToString method for the Array list.
     */
    public String toString() {
    	String str = " ";
    	for(int i = 0; i < parks.size(); i++) {
    		str += parks.toString() + "\n";
    	}
    	return str;
    }

    public ArrayList<Park> getArrayList() {
        // TODO Auto-generated method stub
        return parks;
    }
}
