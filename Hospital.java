import java.util.*;

/**
 * Stores all information about hospital and users.
 * @author Atakan ALTIN
 *
 */
public class Hospital {
	
	private String hospitalName;
	private Admin admin;
	private AVLTree<User> allUsers;//AVL
	private ArrayList<Doctor> doctors;//skiplist
	private ArrayList<Patient> patients;//Treeset yapcam
	private ArrayList<Receptionist> receptionists;
	private ArrayList<Pharmacist> pharmacists;
	private ArrayList<Prescription> prescriptions; 
	private PriorityQueue<Appointment> appointments;
	private ArrayList<DailyHistory> dailyHistory;
	private ListGraph<User> relatedUsers;
	
	/**
	 * Creates a hospital with the given name.
	 * @param name Hospital's name
	 */
	public Hospital(String name) {
		this.hospitalName=name;
		admin = new Admin(new PersonalClass("Admin", "Default", "admin@gtu.edu.tr", "1234"), this);
		doctors = new ArrayList<>();
		patients = new ArrayList<>();
		receptionists = new ArrayList<>();
		pharmacists = new ArrayList<>();
		prescriptions = new ArrayList<>();
		allUsers = new AVLTree<>();
		appointments = new PriorityQueue<>();
		dailyHistory = new ArrayList<>();
		relatedUsers = new ListGraph<User>(100, false);
		allUsers.add(admin);
	}
	/**
	 * Hospital name getter.
	 * @return Hospital name
	 */
	public String getName() {
		return this.hospitalName;
	}
	/**
	 * Hospital name setter.
	 * @param name New Hsopital Name
	 */
	public void setName(String name) {
		this.hospitalName=name;
	}
	/**
	 * Admin name getter.
	 */
	public Admin getAdmin() {
		return  admin;
	}
	/**
	 * Doctors getter.
	 * @return All doctors in the hospital.
	 */
	public ArrayList<Doctor> getDoctors(){
		return this.doctors;
	}
	/**
	 * Patients getter.
	 * @return All patients in the hospital.
	 */
	public ArrayList<Patient> getPatients(){
		return this.patients;
	}
	/**
	 * Receptionists getter
	 * @return All receptionists in the hospital.
	 */
	public ArrayList<Receptionist> getReceptionists(){
		return this.receptionists;
	}
	/**
	 * Pharmacists getter
	 * @return All pharmacists in the hospital.
	 */
	public ArrayList<Pharmacist> getPharmacists(){
		return this.pharmacists;
	}
	/**
	 * Prescriptions getter.
	 * @return All prescriptions in the hospital.
	 */
	public ArrayList<Prescription> getPrescriptions(){
		return this.prescriptions;
	}
	/**
	 * Appointments getter.
	 * @return All appointments in the hospital.
	 */
	public PriorityQueue<Appointment> getAppointments(){
		return this.appointments;
	}
	/**
	 * Returns daily history.
	 * @return Daily history.
	 */
	public ArrayList<DailyHistory> getDailyHistory() {
		return this.dailyHistory;
	}
	/**
	 * All users getter.
	 * @return All users in the hospital.
	 */
	public AVLTree<User> getAllUsers() {
		return this.allUsers;
	}
	/**
	 * Finds users by their id.
	 * @param id User id
	 * @return User
	 */
	public User getUserByID(Integer id){
		return findUser(this.getAllUsers(), id);
	}
	/**
	 * Helper function for getUserByID
	 * @param root root of all users.
	 * @param id id for user will be found
	 * @return User
	 */
	private User findUser(BinaryTree<User> root,Integer id){
		if (root==null) {
			return null;
		}
		if (root.getData().getPersonalData().getId()==id) {
			return root.getData();
		}
		else if (root.getData().getPersonalData().getId()<id) {
			return findUser(root.getLeftSubtree(), id);
		}
		else
			return findUser(root.getRightSubtree(), id);
	}
	/**
	 * Related users getter.
	 * @return All related users in the hospital.
	 */
	public ListGraph<User> getRelatedUsers(){
		return relatedUsers;
	}
	/**
	 * Login to the hospital's system
	 * @param mail mail of the user
	 * @param password password of the user
	 * @return true if there exists user,
	 * 			otherwise false
	 */
	public boolean login(String mail, String password){
		//System.out.println("see all: " + getAllUsers());
		if(this.getAllUsers().size()==0){
			System.out.println("WARNING: Empty hospital.");
			return false;
		}
		User user = findUser(this.getAllUsers(), mail, password);
		if( user == null ){
			System.out.println("WARNING: The system does not have a user with this information.");
			return false;
		}
		user.menu();
		return true;
	}

	/**
	 * Function to find user with mail and password
	 * @param root root of all users.
	 * @param mail mail for the user will be found
	 * @param password password for the user will be found
	 * @return User
	 */
	private User findUser(BinaryTree<User> root, String mail, String password){
		if (root==null) {
			return null;
		}
		if (root.getData().getPersonalData().getMail().equals(mail) &&
				root.getData().getPersonalData().getPassword().equals(password)) {
			return root.getData();
		}
		else if (root.getData().getPersonalData().getMail().compareTo(mail)<0) {
			return findUser(root.getLeftSubtree(), mail, password);
		}
		else
			return findUser(root.getRightSubtree(), mail, password);
	}
}