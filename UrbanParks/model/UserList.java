package model;

import java.util.ArrayList;

/**
 * Contains a collection of Urban Parks users.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 3, 2016
 */
public class UserList {
   
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
     * Constructs a UserList from an Array.
     */
    public UserList(ArrayList<User> inputArrayList) {
        users = inputArrayList;
    }
    
    /**
     * Adds a user to the collection.
     */
    public void add(User user) {
        users.add(user);
    }

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
    public int findIndexFromEmail(String inputEmail) {
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
            	if(users.get(i) instanceof Volunteer){
            		if(i==users.size()-1){
                        lastNames.append(users.get(i).getLastName());
                    }else{
                        lastNames.append(users.get(i).getLastName()+", ");
                    }
            	}  
            }
        }
        return lastNames.toString();
    }
    
    /**
     * @return An ArrayList of Users contained in this class.
     */
    public ArrayList<User> getArrayList() {
        return users;
    }
    
    /**
     * @return Each user's toString method on their own lines.
     */
    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i < users.size(); i++) {
            str += users.get(i).toString() + "\n";
        }
        return str;
    }
    
    /**
     * @return Compares each user's toString methods in array's order.
     */
    @Override
    public boolean equals(Object inputUsers) {
        if (inputUsers == null) { //check null
            return false;
        }
        if (this.getClass() != inputUsers.getClass()) { //check class
            return false;
        }
        UserList otherUserList = (UserList) inputUsers;
        ArrayList<User> otherUsers = otherUserList.getArrayList();
        if (users.size() != otherUsers.size()) { //check size
            return false;
        }
        for(int i = 0; i < users.size(); i++) { //check each park by toString
            String myUser = users.get(i).toString();
            String otherUser = otherUsers.get(i).toString();
            if (myUser.compareTo(otherUser) != 0) {
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
