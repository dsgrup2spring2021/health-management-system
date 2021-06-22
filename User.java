/**
 * class for User
 * @author Ozan Argit Onceken
 */

public abstract class User implements UserInterface, Comparable<User>{
	private PersonalClass person;
	private Hospital hospital;

	User(PersonalClass person, Hospital hospital){
		this.person = person;
		this.hospital = hospital;
	}

	/**
	 * this method is using for editing profile
	 */
	public void editProfile(){
		/*
		System.out.println("Enter the mail for edit");
		Scanner scan=new Scanner(System.in);
		String tempMail=scan.nextLine();
		System.out.println("Enter password for edit");
		PersonalClass temp=new PersonalClass(tempMail,scan.nextLine());
		if(person.compareTo(temp)==0) {
			person.edit();
		}
		*/
	}

	/**
	 * this method takes an user for edit (sets it for existed user)
	 * @param user 			new user for add
	 */
	public void editUserProfile(User user){
	/*
		System.out.println("Enter the mail for edit");
		Scanner scan=new Scanner(System.in);
		String tempMail=scan.nextLine();
		System.out.println("Enter password for edit");
		PersonalClass temp=new PersonalClass(tempMail,scan.nextLine());
		if(person.compareTo(temp)==0) {
			//person=user;
		}
	*/
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

	/**
	 * @param o 			other data for compare
	 * @return				returns 0 if their mail and password are same
	 */
	@Override
	public int compareTo(User o) {
		return person.compareTo(o.getPersonalData());
	}

	@Override
	public String toString(){
		return person.toString();
	}
}
