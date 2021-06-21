/**
 *
 * @author Omer F. Akduman
 * Date: 9.6.21
 *
 */
import java.util.ArrayList;

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

	private void setSpeciality(String inputSpeciality) {
		specialty=inputSpeciality;
	}

	private String getSpeciality() {
		return specialty;
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

	public void setCurrentPatientId(int id){
		this.currentPatientId = id;
	}





	/**Doctors can view their patients-patients history and appointment list*/
	public void viewPatientList(){
		//Doctors can wiev appointment list
		return;
	}

	/**Doctors can prescribe to the patient*/
	public void givePrescribe(String[] medNames, int size){
		Prescription prescription =new Prescription();

		for (int i=0;i< size; i++) {
			prescription.addMedicine(medNames[i]);
		}
		//hastayada eklenebilir

	}

	//bunu eklemem gerekti
	/**Doctors can check and view their free times*/
	public void showFreeTime(){

	}
}
