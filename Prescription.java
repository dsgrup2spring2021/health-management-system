import java.util.ArrayList;
/**
* A class to keep medicine
* information given to the patient
* @author Emine Sultan Savran
*/
public class Prescription{

	//Data fields
	/**to hold owner of the prescription*/
	private Patient patient;
	/**to hold names of the meds*/
	private ArrayList<String> meds;

	//Methods
	/**
	* Constructor
	* to create empty prescription for the patient
	* @param patient owner of the prescription
	*/
	public Prescription(Patient patient){
		this.patient = patient;
		meds = new ArrayList<String>(10);
	}

	/**
	* tells who owns the prescription
	* @return owner of the prescription
	*/
	public Patient getPatient(){
		return patient;
	}

	/**
	* Get the meds list
	* @return meds' names as an ArrayList<String>
	*/
	public ArrayList<String> getMedicineList(){
		return meds;
	}

	/**
	* Adds medicine to the prescription
	* If this medicine is already on the list, 
	* it will not be added again
	* Only doctors can use this action
	* @param medicineName medicine name as a string
	*/
	protected boolean addMedicine(String medicineName){
		if( meds.contains( medicineName ) ){
			System.out.println("WARNING: Cannot add. The medicine already exists.");
			return false;
		}
		meds.add(medicineName);
		return true;
	}

	@Override
	public String toString(){
		return "The patient's information: " + patient + "\nThe Prescription: " + meds;
	}
}