import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
* A class of Receptionist
* @author Emine Sultan Savran
*/


public class Receptionist extends User{

	//Methods
	/**
	* Constructor
	*/
	Receptionist(PersonalClass person, Hospital hospital){
		super(person, hospital);
		//Create new receptionist	
	}
	
	public boolean addPatient(Patient patient){
		/*zaten var olan hasta tekrar eklenmek istenirse -> false*/
		if( getHospital().getPatients().contains(patient) ){
			System.out.println("WARNING: Cannot add. The patient already exists.");
			return false;
		}
		getHospital().getPatients().add(patient);
		return true;
	}

	public boolean addAppointment(Appointment appointment){
		/*dolu olan bi tarihe eklenmek istenirse -> false*/
		if( getHospital().getAppointments().contains(appointment) ){
			System.out.println("WARNING: Cannot add. The appointment is full.");
			return false;
		}
		getHospital().getAppointments().offer(appointment);
		return true;
	}

	public boolean removeAppointment(Appointment appointment){
		/*hastanın böyle bi randevusu yoksa remove da edilemez -> false */
		if( !getHospital().getAppointments().contains(appointment) ){
			System.out.println("WARNING: Cannot remove. The appointment does not exist.");
			return false;
		}
		getHospital().getAppointments().remove(appointment);
		return true;
	}

	public boolean isDoctorAvailable(Doctor doctor, Appointment appointment){
		/*Doktorun bu appointment zamanında başka bir appointmentı
		varsa -> false
		yoksa -> true*/
		Iterator<Appointment> temp = doctor.getAppointments().iterator();
		Appointment t_appointment = null;
		while (temp.hasNext()){
			t_appointment=temp.next();
			if (t_appointment.getGregorianCalendarTime()==appointment.getGregorianCalendarTime()&&t_appointment.isAwake())
				return false;
		}
		return true;
	}

	public boolean showDoctorsTimeSlot(Doctor doctor){
		/*Doktorun boş zamanı yoksa->false*/
		return true;
	}


	/**
	 * The menu for the Receptionist class and users
	 * */
	public void menu(){



		System.out.println("\n Welcome Receptionist " + this.getPersonalData().getName() + " " + this.getPersonalData().getSurname());
			String choice = "";
			boolean exit = true;
			Scanner scanner = new Scanner(System.in);
			do{
				System.out.println("\n 1 - View patient list");
				System.out.println(" 2 - Add a patient");
				System.out.println(" 3 - View doctors list");
				System.out.println(" 4 - Create an appointment");
				System.out.println(" 5 - Request for free time");
				System.out.println(" 6 - Edit profile");
				System.out.println(" 0 - Log out");
				System.out.print("Please select: ");
				choice = scanner.nextLine();
				switch (choice){
					case "1":
						System.out.println();
						this.viewPatientList();
						break;
					case "2":
						System.out.print("Enter patient name: ");
						String name = scanner.nextLine();
						System.out.print("Enter patient surname: ");
						String surname = scanner.nextLine();
						System.out.print("Enter patient mail: ");
						String mail = scanner.nextLine();
						System.out.print("Enter patient password: ");
						String password = scanner.nextLine();
						PersonalClass newPatientPersonal = new PersonalClass(name,surname,mail,password);
						Patient newPatient = new Patient(newPatientPersonal,getHospital());
						addPatient(newPatient);
						break;
					case "3":
						System.out.println();
						this.viewDoctorsList();
						break;
					case "4":
						System.out.print("Enter patient id': ");
						String patientID = scanner.nextLine();
						System.out.print("Enter doctor id': ");
						String doctorID = scanner.nextLine();
						GregorianCalendar time=chooseAnAppointmentTime();
						Appointment newApp = new Appointment(searchDoctor(Integer.parseInt(doctorID)),searchPatient(Integer.parseInt(patientID)),time);
						addAppointment(newApp);
						break;
					case "5":
						// Request for free time
						break;

					case "6":
						//Edit profile
						System.out.print("Enter new name: ");
						name = scanner.nextLine();
						System.out.print("Enter new surname: ");
						surname = scanner.nextLine();
						System.out.print("Enter new mail: ");
						mail = scanner.nextLine();
						System.out.print("Enter new password: ");
						password = scanner.nextLine();
						this.editProfile(this,mail,name,surname,password);
						break;
					case "0":
						System.out.println(" --> Log out... <-- ");
						break;
					default:
						System.out.println(" WARNING: Please enter a valid value.");
						break;
				}
			}while(!choice.equals("0"));

	}
	/**
	 * The function to use selecting the appropriate time
	 * for an appointment
	 * @return GregorianCalender after manipulating it's day and hours
	 * within the given interval
	 * */
	private GregorianCalendar chooseAnAppointmentTime() {
		int[][] workhours =  {{9, 0},{9,30},{10,0},{10,30},{11,0},{11,30},{12,0},{12,30},{13,30},{14,0}
				,{14,30},{15,0},{15,30},{16, 0},{16,30}};
		GregorianCalendar now = new GregorianCalendar();
		int year,day,hour,minute;
		Scanner scanner = new Scanner(System.in);
		String choice = null;

		do {
			System.out.println("Please select a day from by entering their code numbers: ");
			for (int i=0 ;i<5;i++){
				now.add(Calendar.DAY_OF_MONTH,1);
				System.out.print(i+"."+now.get(Calendar.DAY_OF_MONTH)+" ");
			}
			choice = scanner.nextLine();
		}while (0<Integer.parseInt(choice)&&Integer.parseInt(choice)<6);

		now = new GregorianCalendar();
		now.add(Calendar.DAY_OF_MONTH,Integer.parseInt(choice));

		do {
			System.out.println("\nPlease select an hour");
			for (int i = 0; i < workhours.length; i++) {
				System.out.print("  " + i + ". " + workhours[i][0] + "  " + workhours[i][1]);
				if (workhours[i][1] == 0) {
					System.out.print('0');
				}
			}
			choice = scanner.nextLine();
		}while (0<Integer.parseInt(choice)&&Integer.parseInt(choice)<16);

		now.set(Calendar.HOUR_OF_DAY,workhours[Integer.parseInt(choice)][0]);
		now.set(Calendar.MINUTE,workhours[Integer.parseInt(choice)][1]);

		return now;
	}
	/**
	 * The function that used for seeing all the registered
	 * doctors of the system
	 * */
	private void viewDoctorsList() {
		ConcurrentSkipListSet<Doctor> temp = new ConcurrentSkipListSet<>();
		Iterator<Doctor> t_iterator = temp.iterator();
		Doctor t_doctor = null;
		while (t_iterator.hasNext()){
			t_doctor=t_iterator.next();
			System.out.println("  "+t_doctor.getPersonalData().getId()+"  "+t_doctor.toString());
		}

		boolean exit = true;
		Scanner scanner = new Scanner(System.in);
		String choice = "";
		t_iterator = temp.iterator();
		t_doctor=null;
		do {
			System.out.println("For search please enter 1," +
					"\nFor viewing searched doctors appointments enter 2"+
					"\nFor exit press  0");
			choice = scanner.nextLine();
			switch (choice){
				case "1":
					System.out.println();
					System.out.print("Please enter the patient ID: ");
					String doctorID = scanner.nextLine();
					t_doctor = this.searchDoctor(Integer.parseInt(doctorID));
					if (t_doctor!=null)
						System.out.print("Doctor is successfully selected.");
					break;
				case "2":
					if(t_doctor!=null){
						viewDoctorHistory(t_doctor);
					}
					break;
				case "0":
					break;
				default:
					System.out.println("For search please enter a valid input");
					break;
			}

		}while (choice != "0");

	}
	/**
	 * This function takes a doctor and prints
	 *	the attached appointments
	 * @param doctor is a a Doctor
	 * */
	private void viewDoctorHistory(Doctor doctor) {
		PriorityQueue<Appointment> temp = this.getHospital().getAppointments();
		Iterator<Appointment> t_iterator = temp.iterator();
		Appointment t_appointment = null;
		GregorianCalendar now = new GregorianCalendar();
		while (t_iterator.hasNext()){
			t_appointment=t_iterator.next();
			if (t_appointment.getDoctor()==doctor&&t_appointment.getGregorianCalendarTime().after(now))
				t_appointment.print();
		}
	}
	/**
	 * This function takes an id of a doctor and returns
	 *	the doctor with the given id number
	 * @param doctorID is an ID of a doctor
	 * @return the doctor if found or null
	 * */
	private Doctor searchDoctor(int doctorID) {
		ConcurrentSkipListSet<Doctor> temp = getHospital().getDoctors();
		Iterator<Doctor> t_iterator = temp.iterator();
		Doctor doctor=null;
		while (t_iterator.hasNext()){
			doctor=t_iterator.next();
			if (doctor.getPersonalData().getId()==doctorID)
				return doctor;
		}
		return null;
	}
	/**
	 * The function that used for seeing all the registered
	 * patients of the system
	 * */
	private void viewPatientList() {
		TreeSet<Patient> temp = getHospital().getPatients();
		Iterator<Patient> t_iterator = temp.iterator();
		Patient patient=null;
		while (t_iterator.hasNext()){
			System.out.println(t_iterator.next().print());
		}

		boolean exit = true;
		Scanner scanner = new Scanner(System.in);
		String choice = "";
		t_iterator = temp.iterator();
		do {
			System.out.println("For search please enter 1," +
					"\nFor viewing searched patients history enter 2"+
					"\nFor exit press  0");
			choice = scanner.nextLine();
			switch (choice){
				case "1":
					System.out.println();
					System.out.print("Please enter the patient ID: ");
					String patientID = scanner.nextLine();
					patient = this.searchPatient(Integer.parseInt(patientID));
					if (patient!=null)
						System.out.print("Patient is successfully selected.");
					break;
				case "2":
					if(patient!=null){
						viewPatientHistory(patient);
					}
					break;
				case "0":
					break;
				default:
					System.out.println("For search please enter a valid input");
					break;
			}

		}while (choice != "0");
	}
	/**
	 * This function takes a patient and prints
	 *	the attached appointments
	 * @param patient is a a patient
	 * */
	private void viewPatientHistory(Patient patient) {
		PriorityQueue<Appointment> temp = this.getHospital().getAppointments();
		Iterator<Appointment> t_iterator = temp.iterator();
		Appointment t_appointment = null;
		while (t_iterator.hasNext()){
			t_appointment=t_iterator.next();
			if (t_appointment.getPatient()==patient)
				t_appointment.print();
		}
	}
	/**
	 * This function takes an id of a patient and returns
	 *	the patient with the given id number
	 * @param patientID is an ID of a patient
	 * @return the patient if found or null
	 * */
	private Patient searchPatient(int patientID) {
		TreeSet<Patient> temp = getHospital().getPatients();
		Iterator<Patient> t_iterator = temp.iterator();
		Patient patient=null;
		while (t_iterator.hasNext()){
			patient=t_iterator.next();
			if (patient.getPersonalData().getId()==patientID)
				return patient;
		}
		return null;
	}
}