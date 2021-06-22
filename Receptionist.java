import java.util.ArrayList;
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

	public void editProfile(){	
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
		return true;
	}

	public boolean showDoctorsTimeSlot(Doctor doctor){
		/*Doktorun boş zamanı yoksa->false*/
		return true;
	}

	public void menu(){
		System.out.println("\n Welcome Receptionist " + this.getPersonalData().getName() + " " + this.getPersonalData().getSurname());
	}
}