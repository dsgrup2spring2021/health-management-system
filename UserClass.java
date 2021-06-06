/**
 * class for User
 * @author Ozan Argit Onceken
 */
import java.util.Scanner;

public class UserClass implements UserInterface{
	private PersonalClass person;
	public UserClass() {
	}
	/**
	 * @return					returns true if login succesfully happened
	 */
	public boolean login(BinarySearchTree<UserInterface> users) {
		person=new PersonalClass(true);//sets a temporary person
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter mail:");
		person.setMail(scan.nextLine());

		System.out.println("Enter password:");
		person.setMail(scan.nextLine());
		
		scan.close();
		if(users.find(person)==null)
			return false;
		else
			return true;
	}
	/**
	 * method for login(mail and password sent from driver)
	 * @param mail				mail for set person's mail
	 * @param password			password for person's password
	 * @return					returns true if login succesfully happened
	 */
	public boolean login(BinarySearchTree<UserInterface> users,String mail,String password) {
		person.setMail(mail);
		person.setPassword(password);
		if(users.find(person)==null)
			return false;
		else
			return true;
	}
	/**
	 *	method for register for first time
	 * 
	 */
	public void register() {
		person=new PersonalClass();
	}
}
