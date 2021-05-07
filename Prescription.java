import java.util.ArrayList;
/**
* A class to keep medicine
* information given to the patient
*/
public class Prescription{

	//Data fields
	/**to hold names of the meds*/
	private ArrayList<String> meds;

	//Methods
	/**
	* Constructor
	* to create empty prescription 
	*/
	Prescription(){
		meds = new ArrayList<String>();
	}

	/**
	* Adds medicine to the prescription
	* If this medicine is already on the list, 
	* it will not be added again
	* Only doctors can use this action
	* @param medicineName medicine name as a string
	*/
	protected void addMedicine(String medicineName){
		if( !meds.contains( medicineName ) )
			meds.add(medicineName);
	}

	/**
	* Get the meds list
	* @return meds' names as an ArrayList<String>
	*/
	public ArrayList<String> getMedicineList(){
		return meds;
	}

	@Override
	public String toString(){
		return "The Prescription: " + meds; 
	}
}