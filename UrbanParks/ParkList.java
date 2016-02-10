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
	 * Construct the ParkList
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
     * @return Park object with given park name. Null if not found.
     */
    public Park getPark(String inputParkName){
        for(int i = 0; i < parks.size(); i++) {
            Park myPark = parks.get(i);
            String myParkName = myPark.getParkName();
            if(myParkName.compareTo(inputParkName) == 0) {
                return myPark;
            }
        }
        return null;
    }
    
    /**
     * @return the ArrayList of Parks stored in this class
     */
    public ArrayList<Park> getArrayList() {
        return parks;
    }
    
    /**
     * @return Each park's toString method on their own lines.
     */
    @Override
    public String toString() {
    	String str = "";
    	for(int i = 0; i < parks.size(); i++) {
    		str += parks.get(i).toString() + "\n";
    	}
    	return str;
    }
    
    /**
     * @return Compares each park's toString methods in array's order.
     */
    @Override
    public boolean equals(Object inputParks) {
        if (inputParks == null) { //check null
            return false;
        }
        if (this.getClass() != inputParks.getClass()) { //check class
            return false;
        }
        ParkList otherParkList = (ParkList) inputParks;
        ArrayList<Park> otherParks = otherParkList.getArrayList();
        if (parks.size() != otherParks.size()) { //check size
            return false;
        }
        for(int i = 0; i < parks.size(); i++) { //check each park by toString
            String myPark = parks.get(i).toString();
            String otherPark = otherParks.get(i).toString();
            if (myPark.compareTo(otherPark) != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * @return toString's hashCode
     */
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
