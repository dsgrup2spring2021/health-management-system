/**
 *
 * @author Omer F. Akduman
 * Date: 7.5.21
 *
 * Feedbacks: Eklenilmesi gereken, silinmesi, degismesi gereken yerler icin feedbacklerinizi bekliyorum
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Doctor extends User{
	//Data fields
	/**stores patientId who is currently appointed*/
	static int currentPatientId =0;
	/**Doctors can expert a special area*/
	private static String specialty;
	/**Stores appointments*/
	private ArrayList<Int/*Appointment*/> appointments;
	/**Stores patient list who is appointed before*/
	private ArrayList<Int/*Patient*/> patients;


	/**Constructors*/
	public Doctor() {
	}

	//Setters and getters
	/** get the current id who is currently appointed*/
	public static int getCurrentPID{
		return currentPatientId;
	}

	public static int getCurrentPID{
		return currentPatientId;
	}

	/**Get the next patient*/
	public static int getNextID(){
		currentPatientId++;
		return currentPatientId;
	}

	/**Adds appointment*/
	public void addAppointment(Appointment app){
		return;
	}

	/**Doctors can view their patients-patients history and appointment list*/
	public void viewPatientList(){
		return;
	}

	/**Doctors can prescribe to the patient*/
	public void givePrescribe(){

	}

}