import java.util.TreeMap;
/**
 * A class to keep medicine
 * information given to the patient
 */
public class Prescription{
	//Data fields
	/**to hold owner of the prescription*/
	private Patient patient;
	/**to hold doctor of the prescription*/
	private Doctor doctor;
	/**to hold names of the meds*/
	private TreeMap<Integer,Medicine> meds;

	//Methods
	/**
	 * Constructor
	 * to create empty prescription for the patient
	 * @param patient owner of the prescription
	 */
	public Prescription(Patient patient){
		this.patient = patient;
		meds = new TreeMap<>();
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
	public TreeMap<Integer,Medicine> getMedicines(){
		return meds;
	}

	/**
	 * Adds medicine to the prescription
	 * If this medicine is already on the list,
	 * it will not be added again
	 * Only doctors can use this action
	 * @param medicine medicine name as a string
	 */
	protected boolean addMedicine(Medicine medicine){
		if(meds.containsValue(medicine)){
			System.out.println("WARNING: Cannot add. The medicine already exists.");
			return false;
		}
		meds.put(medicine.getId(), medicine);
		return true;
	}

	@Override
	public String toString(){
		Medicine[] sortedMeds = new Medicine[this.getMedicines().size()];
		this.getMedicines().values().toArray(sortedMeds);
		sort(sortedMeds);
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("The patient's information: " + patient + "\nThe Prescription: \n");
		int n = sortedMeds.length;
		for (int i = 0; i < n; ++i)
			stringBuilder.append(sortedMeds[i]+"\n");
		return stringBuilder.toString();
	}

	static public void sort(Medicine[] arr) {
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i);

		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			Medicine temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	static void heapify(Medicine[] arr, int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arr[l].getCost() > arr[largest].getCost())
			largest = l;

		// If right child is larger than largest so far
		if (r < n && arr[r].getCost() > arr[largest].getCost())
			largest = r;

		// If largest is not root
		if (largest != i) {
			Medicine swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;

			// Recursively heapify the affected sub-tree
			heapify(arr, n, largest);
		}
	}
}