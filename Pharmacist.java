/**
 *
 * @author Omer F. Akduman
 * Date: 9.6.21
 *
 */


import java.util.ArrayList;

public class Pharmacist extends User{

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
		System.out.print(getHospital().getRelatedUsers().print(this));
	}

	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Pharmacist | " + super.toString());
		return stringBuilder.toString();
	}
}