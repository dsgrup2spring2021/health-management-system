/**
 * class for User
 * @author Ozan Argit Onceken
 */
import java.util.Scanner;

public abstract class UserClass implements UserInterface, Comparable<User>{
	private PersonalClass person;
	private Hospital hospital;
	public User() {
	}
	

	User(PersonalClass person, Hospital hospital){
		this.person = person;
		this.hospital = hospital;	
	}


	/**
	 * @return					returns true if login succesfully happened
	 */
	public boolean login(BinarySearchTree<User> users) {
		person=new PersonalClass(true);//sets a temporary person
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter mail:");
		person.setMail(scan.nextLine());

		System.out.println("Enter password:");
		person.setMail(scan.nextLine());
		
		scan.close();
//		if(users.find(person)==null)
			return false;
//		else
//			return true;
	}
	/**
	 * method for login(mail and password sent from driver)
	 * @param mail				mail for set person's mail
	 * @param password			password for person's password
	 * @return					returns true if login succesfully happened
	 */
	public boolean login(BinarySearchTree<User> users,String mail,String password) {
		person.setMail(mail);
		person.setPassword(password);
	//	if(users.find(person)==null)
			return false;
	//	else
	//		return true;
	}
	/**
	 *	method for register for first time
	 * 
	 */
	public void register() {
		person=new PersonalClass();
	}
	
	/**
	 * @param o 			other data for compare
	 * @return				returns 0 if their mail and password are same
	 */
    @Override
    public int compareTo(User o) {
        return person.compareTo(o.getPersonalData());
    }

    /**
     * this method is using for editing profile
     */
    public void editProfile(){
		System.out.println("Enter the mail for edit");
		Scanner scan=new Scanner(System.in);
		String tempMail=scan.nextLine();
		System.out.println("Enter password for edit");
		PersonalClass temp=new PersonalClass(tempMail,scan.nextLine());
		if(person.compareTo(temp)==0) {
			person.edit();
		}
		
	}
    /**
     * this method takes a doctor and shows its free time
     * @param doctor		a doctor for show its free time
     */
    public void showFreeTime(Doctor doctor){
		doctor.showFreeTime();
	}
    
    /**
     * this method takes an user for edit (sets it for existed user)
     * @param user 			new user for add 
     */
    public void editUserProfile(User user){
		System.out.println("Enter the mail for edit");
		Scanner scan=new Scanner(System.in);
		String tempMail=scan.nextLine();
		System.out.println("Enter password for edit");
		PersonalClass temp=new PersonalClass(tempMail,scan.nextLine());
		if(person.compareTo(temp)==0) {
			person=user;
		}
	}
    
    /**
    * Getter for personal data
    * @return Hospital object of the user
    */
    public PersonalClass getPersonalData() {
        return person;
    }

    /**
    * Getter for hospital
    * @return Hospital object of the user
    */
    public Hospital getHospital() {
        return hospital;
    }

    /**
    * Setter for hospital
    * @param hospital new hospital object
    */
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
}
