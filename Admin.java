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

	public void menu(){
		System.out.println("\n Welcome Admin ");
	}
}
