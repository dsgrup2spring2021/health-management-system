/**
 * 
 * @author Atakan ALTIN
 *
 */
public class Admin extends User{
	
	public Admin(PersonalClass data,Hospital hospital) {
		
	}
	public boolean addDoctor(Doctor doctor) {
		return true;
	}
	
	public boolean addPatient(Patient patient) {
		return true;
	}
	
	public boolean addPharmacist(Pharmacist pharmacist) {
		return true;
	}
	
	public boolean addPrescription(Prescription prescription) {
		return true;
	}
	
	public boolean addReceptionist(Receptionist receptionist) {
		return true;
	}

	public boolean addAppointment(Appointment appointment) {
		return true;
	}
	
	public boolean removeDoctor(Doctor doctor) {
		return true;
	}
	
	public boolean removePatient(Patient patient) {
		return true;
	}
	
	public boolean removePharmacist(Pharmacist pharmacist) {
		return true;
	}
	
	public boolean removePrescription(Prescription prescription) {
		return true;
	}
	
	public boolean removeReceptionist(Receptionist receptionist) {
		return true;
	}

	public boolean removeAppointment(Appointment appointment) {
		return true;
	}
	
	public void editUserProfile(User user) {
		
	}
	
	public void editAppointment(Appointment appointment) {
		
	}
	
	public boolean doctorList() {
		return false;
	}
	
	public boolean patientList() {
		return false;
	}
	
	public boolean appointmentList() {
		return false;
	}
	
	public boolean prescriptionList() {
		return false;
	}
	
	public void showFreeTime(Doctor doctor) {
		
	}
	
	public void showPatientHistoryData(Patient patient) {
		
	}
}
