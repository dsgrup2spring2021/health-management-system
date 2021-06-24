import java.util.Date;

public class Appointment implements Comparable<Appointment>{
    private Date appday;
    private Boolean awake = true;
    private Doctor relatedDoctor;
    private Patient attachedPatient;

    public Appointment(){
        appday = null;
        relatedDoctor = null;
        attachedPatient = null;
        awake = true;
    }
    public Appointment(Patient input_PATIENT,  Date input_DATE){
        // Default Constructor without doctor data
        attachedPatient = input_PATIENT;
        appday = input_DATE;
    }
    public Appointment(Doctor input_DOCTOR, Patient input_PATIENT,  Date input_DATE){
        // Default Constructor with date datatype
        relatedDoctor = input_DOCTOR;
        attachedPatient = input_PATIENT;
        appday = input_DATE;
    }

    public Appointment(Doctor input_DOCTOR, Patient input_PATIENT, int year, int month, int day, int hour, int minute){
        //  Default constructor with integer inputs
        relatedDoctor = input_DOCTOR;
        attachedPatient = input_PATIENT;
        appday = new Date(year,month,day,hour,minute);
    }

    public Boolean isAwake(){
        // Method that will return if appointment is checked out by Patient or by Doctor or not
        return awake;
    }

    public void checkout(){
        // Method to access awake data
        awake = false;
    }

    public String getDate(){
        // Returning appointment time
        return appday.toString();
    }

    public Doctor getDoctor(){
        // Returning assigned doctor class
        return relatedDoctor;
    }

    public Patient getPatient(){
        // Returning assigned patient class
        return attachedPatient;
    }

    public void setDate(Date input_DATE) {
        // Setting a new date
        this.appday = input_DATE;
    }

    public void setDoctor(Doctor doctor) {
        // Setting a new date
        this.relatedDoctor = doctor;
    }

    public void setPatient(Patient patient) {
        // Setting a new date
        this.attachedPatient = patient;
    }

    public void editDate(int year, int month, int day, int hour, int minute){
        // Editing date of Appointment
        this.appday = new Date(year, month, day, hour, minute);
    }

    public void setAttachedPatient(Patient attachedPatient) {
        // Attaching appointment to a patient
        this.attachedPatient = attachedPatient;
    }

    public void setAwake(Boolean input_B) {
        // Setting a status to appointment
        this.awake = input_B;
    }

    public void setRelatedDoctor(Doctor relatedDoctor) {
        // Setting a related doctor to appointment
        this.relatedDoctor = relatedDoctor;
    }

    public int compareAppointmentbyHour(Appointment appointment2){
        // Comparing two appointment by their Date data
        // Returns 0 if equal or interval in hours
        //long temp =( (appday.getTime() - appointment2.getDate().getTime())
         //       / (1000 * 60 * 60 ) );
        //return temp.intValue();
        //?????????????????????????????????????????????
        return 0;
    }

    public int compareAppointmentbyDay(Appointment appointment2){
        // Comparing two appointment by their Date data
        // Returns 0 if equal or interval in date
        //long temp =( (appday.getTime() - appointment2.getDate().getTime())
        //        / (1000 * 60 * 60 * 24) );
        //return temp.intValue();
        //?????????????????????????????????????????????
        return 0;
    }

    public String printForDoctor(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Patient: " + this.getPatient().print() + "\n Time: " + this.getDate());
        return stringBuilder.toString();
    }

    @Override
    public String toString(){
        return "Doctor: " + this.getDoctor() + " Patient: " + this.getPatient() + " Time: " + this.getDate();
    }

    @Override
    public int compareTo(Appointment o) {
        return this.getDate().compareTo(o.getDate());
    }
}