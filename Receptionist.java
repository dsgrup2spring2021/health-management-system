import java.util.ArrayList;
import java.util.PriorityQueue;
public class Receptionist extends UserClass{
	
	//Data fields
	/**to add the appointment to doctor's appointment list*/
	private ArrayList<Doctor> doctors;
	/**to add the appointment to patient's appointment list*/
	private ArrayList<Patient> patients;
	/**to see appointment list*/
	private PriorityQueue<Appointment> appointments;	

	//Methods
	/**
	* Constructor
	*/
	Receptionist(){
		//PersonalClass tipinde parametre alabilir belki
		//Create new receptionist	
	}

	public void editProfile(){	
	}
	
	public boolean addPatient(Patient patient){
		/*zaten var olan hasta tekrar eklenmek istenirse -> false*/
		return true;
	}

	public boolean addAppointment(Appointment appointment){
		/*dolu olan bi tarihe eklenmek istenirse -> false*/
		return true;
	}

	public boolean removeAppointment(Appointment appointment){
		/*hastanın böyle bi randevusu yoksa remove da edilemez -> false */
		return true;
	}

	public boolean requestFreeTime(String time){
		/*Free time: Personnel can request time off for specific dates.*/
		/*time için type değişebilir*/
		return true;
	}

	public boolean isDoctorAvailable(Appointment appointment){
		/*Doktorun bu appointment zamanında başka bir appointmentı
		varsa -> false
		yoksa -> true*/
		return true;
	}

	public boolean showDoctorsTimeSlot(){
		/*Doktorun boş zamanı yoksa->false*/
		return true;
	}
}