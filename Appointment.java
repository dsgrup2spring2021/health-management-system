import java.util.Date;

public class Appointment {
    private Date appday;
    private Boolean awake=True;


    public Appointment(Doctor input_DOCTOR, Patient input_PATIENT,  Date input_DATE){
        // Default Constructor with date datatype
    }

    public Appointment(Doctor input_DOCTOR, Patient input_PATIENT, int year, int month, int day, int hour){
        //  Default constructor with integer inputs
    }

    public Boolean isAwake(){
        // Method that will return if appointment is checked out by Patient or by Doctor or not
            return awake;
    }

    public void checkout(){
        // Method to access awake data
    }

    public Date getDate(){
        // Returning appointment time
    }

    public Doctor getDoctor(){
        // Returning assigned doctor class
    }

    public Patient getPatient(){
        // Returning assigned patient class
    }

    public int compareAppointmentbyHour(Appointment appointment2){
        // Comparing two appointment by their Date data
        // Returns 0 if equal or interval in hours
    }

    public int compareAppointmentbyDay(Appointment appointment2){
        // Comparing two appointment by their Date data
        // Returns 0 if equal or interval in date
    }


}
