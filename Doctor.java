/**
 *
 * @author Omer F. Akduman
 * Date: 8.5.21
 *
 * Feedbacks:
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
	private ArrayList<Int/*Appointment*/> times;

	/**Constructors*/
	public Doctor() {
	}

	//Setters and getters
	/** get the current id who is currently appointed*/
	public int getCurrentPID{
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


	/**Doctors can view their patients-patients history and appointment list*/
	public void viewPatientList(){
		return;
	}

	/**Doctors can prescribe to the patient*/
	public void givePrescribe(){

	}
	//bunu eklemem gerekti
	public void showFreeTime(){

	}
}
