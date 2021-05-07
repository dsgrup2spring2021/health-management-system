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
	private TreeSet<UserInterface> allUsers;
	private PriorityQueue<Appointments> appointments;
	
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
	
	public PriorityQueue<Appointments> getAppointments(){
		return this.appointments;
	}
	
	public User getUserByID(String id){
		return null;
	}
	
}
