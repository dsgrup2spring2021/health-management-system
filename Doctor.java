/**
 *
 * @author Omer F. Akduman
 * Date: 9.6.21
 *
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Doctor extends User{
	//Data fields
	/**stores patientId who is currently appointed*/
	public int currentPatientId =0;
	/**Doctors can expert a special area*/
	private static String specialty;
	/**Stores free and appointed times*/
	private ArrayList<Appointment> times;

	/**Constructors*/
	public Doctor() {
		setCurrentPatientId(0);
		setSpeciality("NoSpeciality");
	}

	public Doctor(int _currentPatientId, String _specialty) {
		setCurrentPatientId(_currentPatientId);
		setSpeciality(_specialty);
	}

	//Setters and getters
	/** get the current id who is currently appointed*/

	public int getCurrentPatientId(){
		return currentPatientId;
	}

	public int setCurrentPatientId(int id){
		this.currentPatientId = id;
	}
	public int setCurrentPatientId(String _speciality){
		this.specialty = _speciality;
	}

	/**Get the next patient*/
	public static int getNextID(){
		currentPatientId++;
		return currentPatientId;
	}


	/**Doctors can view their patients-patients history and appointment list*/
	public void viewPatientList(){
		//Doctors can wiev appointment list
		return;
	}

	/**Doctors can prescribe to the patient*/
	public void givePrescribe(){
		Prescription prescription =new Prescription();
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
}
