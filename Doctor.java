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
	//Methods
	/**Constructors*/
	public Doctor(PersonalClass person, Hospital hospital, String specialty) {
		super(person, hospital);
		this.specialty = specialty;
		appointments=new PriorityQueue<>();
	}

	public Doctor(String mail, String password){
		super(new PersonalClass(mail, password), new Hospital("Grup 2"));
	}
	
	
	public Doctor() {
		setCurrentPatientId(0);
		setSpeciality("NoSpeciality");
	}

	/**
	 * Function to return speciality
	 * @return specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * Function to return appointments
	 * @return appointments
	 */
	public PriorityQueue<Appointment> getAppointments(){
		return appointments;
	}

	/**
	 * Add an appointment to the doctor's appointment list
	 */
	public void addAppointment(Appointment appointment){
		if(appointments.contains(appointment)){
			System.out.println(" -> There already exists this appointment. Cannot add.");
			return;
		}
		appointments.offer(appointment);
	}

	/**
	 * Doctors can view active appointment list
	 */
	public void viewAppointmentList(){
		PriorityQueue<Appointment> activeAppointments = new PriorityQueue<>();
		int index = 0;
		while(appointments.size()>index) {
			index++;
			Appointment appointment = appointments.peek();
			if( appointment.isAwake() )
				activeAppointments.offer(appointment);
		}
		if(activeAppointments.isEmpty()){
			System.out.println(" -> WARNING: There is no active appointment");
			return;
		}
		for(Appointment appointment: activeAppointments){
			System.out.println(" - " + appointment.printForDoctor());
		}
	}

	/**
	 * Doctors can view active appointment list
	 */
	public boolean viewPatientList(){
		PriorityQueue<Appointment> activeAppointments = new PriorityQueue<>();
		int index = 0;
		while(appointments.size()>index) {
			index++;
			Appointment appointment = appointments.peek();
			if( appointment.isAwake() )
				activeAppointments.offer(appointment);
		}
		if(activeAppointments.isEmpty()){
			System.out.println(" -> WARNING: There is no active appointment");
			return false;
		}
		for(Appointment appointment: activeAppointments){
			System.out.print(" -> " + appointment.getPatient().print());
		}
		return true;
	}

	public Patient searchPatient(int patientID){
		for(Appointment appointment: appointments){
			if(appointment.getPatient().getPersonalData().getId() == patientID)
				return appointment.getPatient();
		}
		return null;
	}

	public void addDisease(Patient patient, String disease){
		if(!patient.getDiseases().contains(disease)){
			patient.getDiseases().add(disease);
			System.out.println(" -> The disease is added.");
			return;
		}
		System.out.println(" -> WARNING: The disease already exists. Cannot add.");
	}

	public void viewPatientHistory(Patient patient){
		patient.showHistory();
	}

	/**Doctors can prescribe to the patient*/
	public void addPrescription(Prescription prescription, Medicine medicine){
		if(prescription.getMedicines().containsKey(medicine.getId())){
			System.out.println(" -> WARNING: The medicine already exists. Cannot add.");
			return;
		}
		prescription.getMedicines().put(medicine.getId(), medicine);
		System.out.println(" -> The medicine is added.");
	}

	//bunu eklemem gerekti
	/**Doctors can check and view their free times*/
	public void showFreeTime(){
		ArrayList <Appointment>x=new ArrayList<>();
		while(!appointments.isEmpty()) {
			x.add(appointments.poll());
		}
	}

	/**
	 * add suggestion
	 * @param user the user(doctor or pharmacist)
	 */
	public void addSuggestion(User user) throws IllegalArgumentException{
		if(this.getHospital().getRelatedUsers().isEdge(this, user)){
			System.out.println(" -> The suggestion already exists");
			return;
		}
		if(user instanceof Doctor || user instanceof Pharmacist){
			getHospital().getRelatedUsers().insert(new Edge<User>(this, user));
			System.out.println(" -> The suggestion is added.");
		}
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
		if(user instanceof Doctor || user instanceof Pharmacist){
			getHospital().getRelatedUsers().remove(new Edge<User>(this, user));
			System.out.println(" -> The suggestion is removed.");
		}
		else
			throw new IllegalArgumentException();
	}

	/**
	 * sees own suggestions
	 */
	public boolean showSuggestions(){
		String print = getHospital().getRelatedUsers().print(this);
		if(print.equals("There is no suggestion.\n")){
			System.out.print(print);
			return false;
		}
		System.out.print(print);
		return true;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Doctor | " + super.toString() + " | Specialty: " + this.specialty);
		return stringBuilder.toString();
	}

	public void menu(){
		System.out.println("\n Welcome Doctor " + this.getPersonalData().getName() + " " + this.getPersonalData().getSurname());
		String choice = "";
		boolean exit = true;
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("\n 1 - View patient&appointment list");
			System.out.println(" 2 - Add a disease&prescription to the patient");
			System.out.println(" 3 - View history of the patient");
			System.out.println(" 4 - Request for free time");
			System.out.println(" 5 - Edit profile");
			System.out.println(" 6 - Add a suggestion");
			System.out.println(" 7 - Remove a suggestion");
			System.out.println(" 8 - View suggestion list");
			System.out.println(" 0 - Log out");
			System.out.print("Please select: ");
			choice = scanner.nextLine();
			switch (choice){
				case "1":
					System.out.println();
					this.viewAppointmentList();
					break;
				case "2":
					exit = true;
					while(exit) {
						System.out.println();
						if (!this.viewPatientList()) {
							break;
						}
						System.out.println();
						System.out.print("Please enter the patient ID: ");
						String patientID = scanner.nextLine();
						Patient patient = this.searchPatient(Integer.parseInt(patientID));
						if (patient != null) {
							System.out.print("Please enter a disease: ");
							String disease = scanner.nextLine();
							this.addDisease(patient, disease);
							boolean exit2 = true;
							Prescription prescription = new Prescription(this, patient);
							boolean checkPrescription = false;
							while (exit2) {
								System.out.println("\n 1 - Add a medicine");
								System.out.println(" 0 - Return back");
								System.out.print("Selection: ");
								String selection = scanner.nextLine();
								switch (selection) {
									case "1":
										//viewMedicine();
										System.out.print("Please enter medicine ID: ");
										String medicineID = scanner.nextLine();
										System.out.print("Please enter medicine name: ");
										String medicineName = scanner.nextLine();
										System.out.print("Please enter quantity: ");
										String quantity = scanner.nextLine();
										try {
											this.addPrescription(prescription,
													new Medicine(Integer.parseInt(medicineID), medicineName, Integer.parseInt(quantity)));
											checkPrescription = true;
										} catch (Exception e) {
											System.out.println("Please try again and enter valid value.");
										}
										break;
									case "0":
										exit2 = false;
										break;
									default:
										System.out.println("Please enter valid value.");
										break;
								}
								if (checkPrescription)
									patient.getPrescriptions().add(prescription);
							}
							for (Appointment appointment : this.appointments) {
								if (appointment.getPatient().equals(patient) &&
										appointment.getDoctor().equals(this)) {
									appointment.setAwake(false);
									break;
								}
							}
							exit = false;
						} else {
							System.out.println(" ! Invalid Patient ID.");
						}
					}
					break;
				case "3":
					exit = true;
					while(exit){
						System.out.println();
						if(!this.viewPatientList()){
							break;
						}
						System.out.println();
						System.out.print("Please enter the patient ID: ");
						String patientID = scanner.nextLine();
						Patient patient = this.searchPatient(Integer.parseInt(patientID));
						if(patient != null){
							this.viewPatientHistory(patient);
							exit = false;
						} else{
							System.out.println(" ! WARNING: Invalid Patient ID.");
						}
					}
					break;
				case "4":
					//request free time
					break;
				case "5":
					System.out.print("Enter new name: ");
					String name = scanner.nextLine();
					System.out.print("Enter new surname: ");
					String surname = scanner.nextLine();
					System.out.print("Enter new mail: ");
					String mail = scanner.nextLine();
					System.out.print("Enter new password: ");
					String password = scanner.nextLine();
					this.editProfile(this,mail,name,surname,password);
					break;
				case "6":
					exit = true;
					while(exit){
						System.out.println();
						System.out.println(" * Doctors * ");
						for (Doctor doctor: this.getHospital().getDoctors()) {
							if(!doctor.equals(this)){
								System.out.println(" -> " + doctor);
							}
						}
						System.out.println(" * Pharmacists * ");
						for (Pharmacist pharmacist: this.getHospital().getPharmacists()) {
							System.out.println(" -> " + pharmacist);
						}
						System.out.print("Please enter the ID: ");
						String ID = scanner.nextLine();
						User user = null;
						try{
							for(Doctor doctor: this.getHospital().getDoctors()){
								if(doctor.getPersonalData().getId() == Integer.parseInt(ID)
									&& this.getPersonalData().getId() != Integer.parseInt(ID)){
									user = doctor;
									break;
								}
							}
							if(user == null ){
								for(Pharmacist pharmacist: this.getHospital().getPharmacists()){
									if(pharmacist.getPersonalData().getId() == Integer.parseInt(ID)){
										user = pharmacist;
										break;
									}
								}
							}
							if(user != null){
								this.addSuggestion(user);
								exit = false;
							} else{
								System.out.println(" ! Invalid ID.");
							}
						} catch (Exception e){
							System.out.println("Please try again and enter valid value.");
						}
					}
					break;
				case "7":
					exit = true;
					while(exit){
						if(this.showSuggestions()){
							System.out.print("Please enter the ID: ");
							String ID = scanner.nextLine();
							User user = null;
							try{
								for( Doctor doctor: this.getHospital().getDoctors()){
									if(doctor.getPersonalData().getId() == Integer.parseInt(ID)
											&& this.getPersonalData().getId() != Integer.parseInt(ID)){
										user = doctor;
										break;
									}
								}
								if(user == null ){
									for(Pharmacist pharmacist: this.getHospital().getPharmacists()){
										if(pharmacist.getPersonalData().getId() == Integer.parseInt(ID)){
											user = pharmacist;
											break;
										}
									}
								}
								if(user != null &&
										this.getHospital().getRelatedUsers().isEdge(this, user)){
									this.removeSuggestion(user);
									exit = false;
								} else{
									System.out.println(" ! Invalid ID.");
								}
							} catch (Exception e){
								System.out.println("Please try again and enter valid value.");
							}
						} else{
							exit = false;
						}
					}
					break;
				case "8":
					this.showSuggestions();
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
}
