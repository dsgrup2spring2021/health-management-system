import java.util.*;

public class Doctor extends User{
	//Data fields
	/**Doctors can expert a special area*/
	//https://en.wikipedia.org/wiki/Medical_specialty
	private String specialty;
	/**Stores free and appointed times*/
	private PriorityQueue<Appointment> appointments;

	/**Constructors*/
	public Doctor(PersonalClass person, Hospital hospital, String specialty) {
		super(person, hospital);
		this.specialty = specialty;
	}

	public Doctor(String mail, String password){
		super(new PersonalClass(mail, password), new Hospital("gruo2"));
	}

	/**Doctors can view their patients-patients history and appointment list*/
	public void viewPatientList(){
		//Doctors can wiev appointment list
		return;
	}

	/**Doctors can prescribe to the patient*/
	public void givePrescribe(Patient patient){
		Prescription prescription =new Prescription(patient);
		//Doctor eklemek istedigi kadar ekleyecek
		String med1 = "med1";
		String med2 = "med2";

		prescription.addMedicine(med1);
		prescription.addMedicine(med2);

		//hastayada eklenebilir

	}

	//bunu eklemem gerekti
	/**Doctors can check and view their free times*/
	public void showFreeTime(){

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
}