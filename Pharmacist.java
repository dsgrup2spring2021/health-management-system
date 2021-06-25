import java.util.*;

public class Pharmacist extends User{
	//kendi ilaç stoğu olsun
	private String pharmacyName;

	public Pharmacist(PersonalClass person,String pharmacyName ,Hospital hospital){
		super(person, hospital);
		this.pharmacyName=pharmacyName;
	}

	public Pharmacist(PersonalClass person, Hospital hospital){
		super(person, hospital);
	}
	/**
    * add suggestion
    * @param user the user(doctor or pharmacist)
    */
	public void addSuggestion(User user) throws IllegalArgumentException{
		if(this.getHospital().getRelatedUsers().isEdge(this, user)){
			System.out.println(" -> The suggestion already exists");
			return;
		}
		if(user instanceof Doctor){
			getHospital().getRelatedUsers().insert(new Edge<User>(this, user));
			System.out.println(" -> The suggestion is added.");
		}
		else
			throw new IllegalArgumentException();
	}

    /**
    * remove suggestion
    * @param user the user(doctor or pharmacist)
    */
	public void removeSuggestion(User user){
		if(user instanceof Doctor){
			getHospital().getRelatedUsers().remove(new Edge<User>(this, user));
			System.out.println(" -> The suggestion is removed.");
		}
		else
			throw new IllegalArgumentException();
	}

    /**
    * sees own suggestions
    */
	public boolean showSuggestions(){
		String print = getHospital().getRelatedUsers().print(this);
		if(print.equals("There is no suggestion.\n")){
			System.out.print(print);
			return false;
		}
		System.out.print(print);
		return true;
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Pharmacist | " + super.toString());
		return stringBuilder.toString();
	}

	public String getPharmacyName() {
		return this.pharmacyName;
	}

	public void setPharmacyName(String pharmacyName) {
		this.pharmacyName = pharmacyName;
	}
	
	public void menu(){
		boolean exit = true;
		int selection,id;
		Patient p=null;
		Scanner sc = new Scanner(System.in);
		while (exit) {
			System.out.println("\n Welcome " + this.getPersonalData().getName() + " " + this.getPersonalData().getSurname());
			System.out.println("1. Show Prescription");
			System.out.println("2. Add Suggestion");
			System.out.println("3. Remove Suggestion");
			System.out.println("4. Show Suggestions");
			System.out.println("5. Exit");
			System.out.println("Selection: ");
			selection=sc.nextInt();
			switch (selection) {
				case 1:
					for (Patient iter : getHospital().getPatients()) {
						System.out.println("ID: "+iter.getPersonalData().getId()+" NAME: "+getPersonalData().getName()+" "+getPersonalData().getSurname());
					}
					System.out.print("Please enter the Patient ID: ");
					id = sc.nextInt();
					for(Patient patient: this.getHospital().getPatients()){
						if(patient.getPersonalData().getId() == id){
							p = patient;
							break;
						}
					}
					for (int i = 0; i < p.getPrescriptions().size(); i++) {
						System.out.println(p.getPrescriptions().get(i));
					}
					break;
				case 2:
					boolean exit2 = true;
					while(exit2){
						System.out.println();
						System.out.println(" * Doctors * ");
						for (Doctor doctor: this.getHospital().getDoctors()) {
							if(!doctor.equals(this)){
								System.out.println(" -> " + doctor);
							}
						}
						System.out.print("Please enter the ID: ");
						id= sc.nextInt();
						User user = null;
						try{
							for(Doctor doctor: this.getHospital().getDoctors()){
								if(doctor.getPersonalData().getId() == id){
									user = doctor;
									break;
								}
							}
							if(user != null){
								this.addSuggestion(user);
								exit2 = false;
							} else{
								System.out.println(" ! Invalid ID.");
							}
						} catch (Exception e){
							System.out.println("Please try again and enter valid value.");
						}
					}
					break;
				case 3:
					boolean exit3 = true;
					while(exit3){
						if(this.showSuggestions()){
							System.out.print("Please enter the ID: ");
							id = sc.nextInt();
							User user = null;
							try{
								for( Doctor doctor: this.getHospital().getDoctors()){
									if(doctor.getPersonalData().getId() == id){
										user = doctor;
										break;
									}
								}
								if(user != null &&
										this.getHospital().getRelatedUsers().isEdge(this, user)){
									this.removeSuggestion(user);
									exit3 = false;
								} else{
									System.out.println(" ! Invalid ID.");
								}
							} catch (Exception e){
								System.out.println("Please try again and enter valid value.");
							}
						} else{
							exit3 = false;
						}
					}
					break;
				case 4:
					showSuggestions();
					break;
				case 5:
					exit = false;
					break;
				default:
				System.err.println("WARNING: Wrong Command.");
					break;
			}
		}
	}
}
