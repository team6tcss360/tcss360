import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contains a collection of Urban Parks users.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class UserList implements Serializable {

    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 3928130769659232429L;
   
    /**
     * The collection of users.
     */
    ArrayList<User> users;
    
    /**
     * Constructs an empty UserList.
     */
    public UserList() {
        users = new ArrayList<User>();
    }
    
    /**
     * Adds a user to the collection.
     * 
     * @param user the user to add
     * @return 
     */
    public boolean add(User user) {
        users.add(user);
        //TODO fix below
        return true;
    }
    
//TODO remove?    
//    /**
//     * Removes a user from the collection.
//     * 
//     * @param user the user to remove
//     */
//    public void remove(User user) {
//        int index = findIndexFromEmail(user.getEmail()); //find user index
//        users.remove(index); //remove user at that index
//    }

    /**
     * Finds the user associated with an input email.
     * 
     * @param inputEmail the email to search
     * @return the user associated with the input email
     * @return null if not found
     */
    public User findFromEmail(String inputEmail) {
        int index = findIndexFromEmail(inputEmail); //find user index
        if (index < 0) { //if user not found return null
            return null;
        }
        return users.get(index); //return user if found in array
    }

    /**
     * Finds the index of a User in the ArrayList from an email.
     * 
     * @param inputEmail
     * @return User index if found
     * @return -1 if not found
     */
    protected int findIndexFromEmail(String inputEmail) {
        //iterate through array list to find a match
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getEmail().equals(inputEmail)) {
                return i;
            }
        }
        return -1; //if no match found
    }
    
    /**
     * Returns the size of the UserList.
     */
    public int size(){
    	int size = users.size();
    	return size;
    }
    
    /**
     * Gets a list of volunteer last names. 
     * 
     * @return A list of volunteer last names as a String.
     */
    public String getVolunteerLastNames(){
        StringBuilder lastNames = new StringBuilder();
        if(users.size()==0){
            lastNames.append("No users!");
        }else{
            for(int i = 0; i< users.size(); i++){
                if(i==users.size()-1){
                    lastNames.append(users.get(i).getLastName());
                }else{
                    lastNames.append(users.get(i).getLastName()+", ");
                }   
            }
        }
        return lastNames.toString();
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
