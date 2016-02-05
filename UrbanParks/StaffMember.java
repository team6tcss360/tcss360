

/**
 * The class that contains Urban Parks staff member specific methods.
 * 
 * @author Group 6, TCSS 360, Winter 2016
 * @author Jonathan Hughes, Michael Ford, Weiwei Shi, Chris Vishoot
 * @version February 4, 2016
 */
public class StaffMember extends User {

	/**
	 * Creates a StaffMember through the User constructor.
	 */
	public StaffMember(String inputFirstName, String inputLastName, String inputEmail, String inputPhone,
			int inputUserID) {
		super(inputFirstName, inputLastName, inputEmail, inputPhone, inputUserID);
	}

	/**
	 * Gets a list of volunteer last names. 
	 * 
	 * @return A list of volunteer last names as a String.
	 */
	public String getVolunteerLastNames(UserList<User> inputList){
		StringBuilder lastNames = new StringBuilder();
		if(inputList.size()==0){
			lastNames.append("No users!");
		}else{
			for(int i = 0; i< inputList.size(); i++){
				if(i==inputList.size()-1){
					lastNames.append(inputList.get(i).getLastName());
				}else{
					lastNames.append(inputList.get(i).getLastName()+", ");
				}	
			}
		}


		return lastNames.toString();

	}
}
