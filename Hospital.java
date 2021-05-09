import java.util.*;

/**
 * 
 * @author Atakan ALTIN
 *
 */
public class Hospital {
	
	private String hospitalName;
	private Admin admin;
	private ArrayList<Doctor> doctors;
	private ArrayList<Patient> patients;
	private ArrayList<Receptionist> receptionists;
	private ArrayList<Pharmacist> pharmacists;
	private ArrayList<Prescription> prescriptions; 
	private BinarySearchTree<UserInterface> allUsers;
	private PriorityQueue<Appointment> appointments;
	private ArrayList<DailyHistory> dailyHistory;
	
	public Hospital(String name) {
		this.hospitalName=name;
		//to be continued
	}
	public String getName() {
		return this.hospitalName;
	}
	
	public void setName(String name) {
		this.hospitalName=name;
	}
	public Admin getAdmin() {
		return this.admin;
	}
	
	public ArrayList<Doctor> getDoctors(){
		return this.doctors;
	}
	
	public ArrayList<Patient> getPatients(){
		return this.patients;
	}
	
	public ArrayList<Receptionist> getReceptionists(){
		return this.receptionists;
	}
	
	public ArrayList<Pharmacist> getPharmacists(){
		return this.pharmacists;
	}
	
	public ArrayList<Prescription> getPrescriptions(){
		return this.prescriptions;
	}
	
	public PriorityQueue<Appointment> getAppointments(){
		return this.appointments;
	}
	
	public ArrayList<DailyHistory> getDailyHistory() {
		return this.dailyHistory;
	}
	
	public BinarySearchTree<UserInterface> getAllUsers() {
		return this.allUsers;
	}
	public User getUserByID(String id){
		return null;
	}
	
}
