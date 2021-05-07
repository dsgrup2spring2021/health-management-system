package proje;
/**
 * class for User
 * @author Ozan Argýt Önçeken
 */
public class UserClass implements UserInterface{
	private PersonalClass person;
	public UserClass() {
		
	}
	/**
	 * @return					returns true if login succesfully happened
	 */
	public boolean login() {
		return true;
	}
	/**
	 * method for login(mail and password sent from driver)
	 * @param mail				mail for set person's mail
	 * @param password			password for person's password
	 * @return					returns true if login succesfully happened
	 */
	public boolean login(String mail,String password) {
		return true;
	}
	/**
	 *	method for register for first time
	 * 
	 */
	public void register() {
		
	}
}
