import java.util.Date;

/**
 * 
 * @author Atakan ALTIN
 *
 */
public class Admin extends User{
	private final Hospital hospital;
	private PersonalClass adminData;
	public Admin(PersonalClass data, Hospital hospital) {
		super(data, hospital);
		this.hospital = hospital;
		this.adminData = data;
	}
	/**
	 * Adds given doctor to the system.
	 * @param doctor Doctor
	 * @return Always True
	 */
	public boolean addDoctor(Doctor doctor) {
		return hospital.getAllUsers().add(doctor) && hospital.getDoctors().add(doctor);
	}
	/**
	 * Adds given patient to the system.
	 * @param patient Patient
	 * @return
	 */
	public boolean addPatient(Patient patient) {
		return hospital.getAllUsers().add(patient) && hospital.getPatients().add(patient);
	}
	
	public boolean addPharmacist(Pharmacist pharmacist) {
		hospital.getAllUsers().add(pharmacist);
		hospital.getPharmacists().add(pharmacist);
		return true;
	}
	
	public boolean addPrescription(Prescription prescription) {
		hospital.getPrescriptions().add(prescription);
		return true;
	}
	
	public boolean addReceptionist(Receptionist receptionist) {
		hospital.getAllUsers().add(receptionist);
		hospital.getReceptionists().add(receptionist);
		return true;
	}

	public boolean addAppointment(Appointment appointment) {
		hospital.getAppointments().add(appointment);
		return true;
	}
	
	public boolean removeDoctor(Doctor doctor) {
		return hospital.getAllUsers().remove(doctor) && hospital.getDoctors().remove(doctor);
	}
	
	public boolean removePatient(Patient patient) {

		return hospital.getAllUsers().remove(patient) && hospital.getPatients().remove(patient);
	}
	
	public boolean removePharmacist(Pharmacist pharmacist) {

		return hospital.getAllUsers().remove(pharmacist) && hospital.getPharmacists().remove(pharmacist);
	}
	
	public boolean removePrescription(Prescription prescription) {
		return hospital.getPrescriptions().remove(prescription);
	}
	
	public boolean removeReceptionist(Receptionist receptionist) {
		return hospital.getAllUsers().remove(receptionist) && hospital.getReceptionists().remove(receptionist);
	}

	public boolean removeAppointment(Appointment appointment) {
		return hospital.getAppointments().remove(appointment);
	}
	
	public void editUserProfile(User user,String mail,String name,String surname,String password) {
		user.getPersonalData().setMail(mail);
		user.getPersonalData().setName(name);
		user.getPersonalData().setPassword(password);
		user.getPersonalData().setSurname(surname);
		System.out.println(" The profile is edited.");
	}
	
	public void editAppointment(Appointment appointment,Date appday,Doctor doctor,Patient patient) {
		appointment.setDate(appday);
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
	}
	
	public void doctorList() {
		for (Doctor doctor: hospital.getDoctors() ) {
			System.out.println(doctor);
		}
	}
	
	public void patientList() {
		for (Patient patient: getHospital().getPatients()) {
			System.out.println(patient);
		}
	}
	
	public void appointmentList() {
		if (hospital.getAppointments().size()==0)
			System.out.println("There are no appointments right now!");
		for (Appointment appointment: hospital.getAppointments()) 
			System.out.println(appointment);	
	}
	
	public void prescriptionList() {
		if (hospital.getPrescriptions().size()==0) 
			System.out.println("There are no prescriptions in the hospital depo!");
		for (int i = 0; i < hospital.getPrescriptions().size();i++) 
			System.out.println(hospital.getPrescriptions().get(i));
	}
	
	public void showFreeTime(Doctor doctor) {
		if (doctor.getAppointments().size()==0)
			System.out.println("This doctor does not have any free time!");
		for(Appointment itr: doctor.getAppointments()){
			System.out.println(itr);
		}
	}
	
	public void showPatientHistoryData(Patient patient) {
		System.out.println("Patient information: ");
		System.out.println(patient);
		System.out.println("Patient's appointment history: ");
		System.out.println(patient.appointmentHistory());
	}
	@Override
	public String toString() {
		return String.format("\nName: %s\nSurname: %s\nMail: %s\nUser ID: %d\n",
				adminData.getName(),adminData.getSurname(),adminData.getMail(),adminData.getId());
	}


	/**
	 * menu for admin
	 */
	public void menu(){
		System.out.println("\n Welcome Admin " + this.getPersonalData().getName() + " " + this.getPersonalData().getSurname());
		
		String choice = "";
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("\n 1 - Add patient");
			System.out.println(" 2 - Remove patient ");
			System.out.println(" 3 - Add doctor");
			System.out.println(" 4 - Remove doctor");
			System.out.println(" 5 - Add Pharmacist");
			System.out.println(" 6 - Remove Pharmacist");
			System.out.println(" 7 - Edit personel data");
			System.out.println(" 0 - Log out");
			System.out.print("Please select: ");
			choice = scanner.nextLine();
			switch (choice){
				case "1":{
					System.out.println("Enter the patient age weight height bloodtype");
					int age=0;
					if(scanner.hasNext())
						age=scanner.nextInt();
					System.out.println("Enter the patient weight");
					int weight=0;
					if(scanner.hasNext())
						weight=scanner.nextInt();
					System.out.println("Enter the patient height");
					int height=0;
					if(scanner.hasNext())
						height=scanner.nextInt();
					System.out.println("Enter the patient blood type");
					this.addPatient(new Patient(age,weight,height,scanner.nextLine()));
				}
				case "2":{
					System.out.println("Enter the patient age weight height bloodtype");
					int age=0;
					if(scanner.hasNext())
						age=scanner.nextInt();
					System.out.println("Enter the patient weight");
					int weight = 0;
					if(scanner.hasNext())
						weight=scanner.nextInt();
					System.out.println("Enter the patient height");
					int height=0;
					if(scanner.hasNext())
						height=scanner.nextInt();
					System.out.println("Enter the patient blood type");
					this.removePatient(new Patient(age,weight,height,scanner.nextLine()));
				}
				case "3":{
					System.out.println("Enter the Speciality of doctor");
					this.addDoctor(new Doctor(createPersonalData(),createHospital(),scanner.nextLine()));
				}
				case "4":{
					System.out.println("Enter the Speciality of doctor");
					this.addDoctor(new Doctor(createPersonalData(),createHospital(),scanner.nextLine()));					
				}
				case "5":{
					this.addPharmacist(new Pharmacist(createPersonalData(),createHospital()));
				}
				case "6":{
					this.removePharmacist(new Pharmacist(createPersonalData(),createHospital()));
				}
				case "7":{
					this.editProfile();
				}
				case "0":
					break;
				default:
					System.out.println(" WARNING: Please enter a valid value.");
					break;
			}

		}while(!choice.equals("0"));
	}

	/*
	 * helper method for menu 
	 *
	 *	@return 			creates and returns Hospital
	 */
	private Hospital createHospital() {
		System.out.println("Enter the hospital name");

		Scanner scanner = new Scanner(System.in);
		return new Hospital(scanner.nextLine());
	}
	/*
	 * helper method for menu 
	 *
	 *	@return 			creates and returns person
	 */
	private PersonalClass createPersonalData() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the patient name");
		String name=scanner.nextLine();
		System.out.println("Enter the patient surname");
		String surname=scanner.nextLine();
		System.out.println("Enter the patient mail");
		String mail=scanner.nextLine();
		System.out.println("Enter the patient password");
		return new PersonalClass(name,surname,mail,scanner.nextLine());
	}
}
