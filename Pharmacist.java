import java.util.ArrayList;

public class Pharmacist extends User{
	//kendi ilaç stoğu olsun

	public Pharmacist(PersonalClass person, Hospital hospital){
		super(person, hospital);
	}

	/**Gives medicine to patients and store this process*/
	public void giveMedicine(){

	}

	/**Set/Arrange medicines in the hospital*/
	public void arrangeMedicines(){}

	/**Shows the medicines*/
	public void showMedicines(){}

	/**
    * add suggestion
    * @param user the user(doctor or pharmacist)
    */
	public void addSuggestion(User user) throws IllegalArgumentException{
		if(user instanceof Doctor || user instanceof Pharmacist)
			getHospital().getRelatedUsers().insert(new Edge<User>(this, user));
		else
			throw new IllegalArgumentException();
	}

    /**
    * remove suggestion
    * @param user the user(doctor or pharmacist)
    */
	public void removeSuggestion(User user){
		if(user instanceof Doctor || user instanceof Pharmacist)
			getHospital().getRelatedUsers().remove(new Edge<User>(this, user));
		else
			throw new IllegalArgumentException();
	}

    /**
    * sees own suggestions
    */
	public void showSuggestions(){
		System.out.println("Your suggetions:");
		System.out.print(getHospital().getRelatedUsers().print(this));
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Pharmacist | " + super.toString());
		return stringBuilder.toString();
	}

	public void menu(){
		System.out.println("\n Welcome Pharmacist " + this.getPersonalData().getName() + " " + this.getPersonalData().getSurname());
	}
}