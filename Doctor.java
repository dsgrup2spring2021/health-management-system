import java.util.*;

public class Doctor extends User{
	//Data fields
	/**Doctors can expert a special area*/
	//https://en.wikipedia.org/wiki/Medical_specialty
	private String specialty;
	/**Stores free and appointed times*/
	private PriorityQueue<Appointment> appointments;
	/**False when all the available appointment times are full*/
	private boolean available = true ;
	/**Constructors*/
	public Doctor(PersonalClass person, Hospital hospital, String specialty) {
		super(person, hospital);
		this.specialty = specialty;
		appointments=new PriorityQueue<>();
	}

	public Doctor(String mail, String password){
		super(new PersonalClass(mail, password), new Hospital("Grup 2"));
	}

	/**Doctors can view their patients-patients history and appointment list*/
	public void viewPatientList(){
		PriorityQueue<Appointment> tempAppointments=new PriorityQueue<>();
		while(!appointments.isEmpty()) {

			Appointment x=appointments.poll();
			System.out.println(x);
			tempAppointments.add(x);
		}
		while(!tempAppointments.isEmpty()) {
			appointments.add(tempAppointments.poll());
		}
		return;
	}

	/**Doctors can prescribe to the patient*/
	public void givePrescribe(Patient patient){
		Prescription prescription =new Prescription(patient);

	}

	//bunu eklemem gerekti
	/**Doctors can check and view their free times*/
	public void showFreeTime(){
		ArrayList <Appointment>x=new ArrayList<>();
		while(!appointments.isEmpty()) {
			x.add(appointments.poll());
		}
	}
	/**Function to return speciality*/
	public String getSpecialty() {
		return specialty;
	}

	public PriorityQueue<Appointment> getAppointmens(){
		return appointments;
	}

	/**
	 * add suggestion
	 * @param user the user(doctor or pharmacist)
	 */
	public void addSuggestion(User user) throws IllegalArgumentException{
		if(user instanceof Doctor || user instanceof Pharmacist)
			getHospital().getRelatedUsers().insert(new Edge<User>(this, user));
		else
			throw new IllegalArgumentException();
	}

	/** Returns true if available appointment time exist
	 * false if appointment times are full
	 * */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * remove suggestion
	 * @param user the user(doctor or pharmacist)
	 */
	public void removeSuggestion(User user){
		if(user instanceof Doctor || user instanceof Pharmacist)
			getHospital().getRelatedUsers().remove(new Edge<User>(this, user));
		else
			throw new IllegalArgumentException();
	}

	/**
	 * sees own suggestions
	 */
	public void showSuggestions(){
		System.out.print(getHospital().getRelatedUsers().print(this));
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Doctor | " + super.toString() + " | Specialty: " + this.specialty);
		return stringBuilder.toString();
	}

	public void edit(String mail,String name,String surname,String password){
		getHospital().getAdmin().editUserProfile(this,mail,name,surname,password);
	}

	public void menu(){
		System.out.println("\n Welcome Doctor " + this.getPersonalData().getName() + " " + this.getPersonalData().getSurname());
		//System.out.println("->" + this);
		//showSuggestions();
		String choice = "";
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("\n 1 - View patient&appointment list");
			System.out.println(" 2 - Add diagnosis to the patient");
			System.out.println(" 3 - View history of the patient");
			System.out.println(" 4 - Add prescribe to the patient");
			System.out.println(" 5 - Request for free time");
			System.out.println(" 6 - Edit profile");
			//System.out.println(" 7 - Add free time");
			//System.out.println(" 8 - View appointment list");
			System.out.println(" 9 - Add a suggestion");
			System.out.println("10 - Remove a suggestion");
			System.out.println("11 - View suggestion list");
			System.out.println(" 0 - Log out");
			System.out.print("Please select: ");
			choice = scanner.nextLine();
			switch (choice){
				case "1":
				case "2":
				case "3":
				case "4":
				case "5":
				case "6":
				case "7":
				case "8":
				case "9":
				case "10":
				case "11":
				case "12":
				case "13":
				case "0":
					break;
				default:
					System.out.println(" WARNING: Please enter a valid value.");
					break;
			}

		}while(!choice.equals("0"));
	}

	private void viewApp_Pat(){
		Iterator<Appointment> iter = new this.appointments.iterator();
		Appointment temp;
		while(iter.hasNext()){
			temp = iter.next();
			System.out.println("\nDoctor: " + temp.getDoctor().getName());
			System.out.println("Patient: " + temp.getPatient().getName());
			System.out.println("Appointment time: " + temp.getDate());
		}
	}
}