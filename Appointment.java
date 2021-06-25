import java.util.GregorianCalendar;

public class Appointment implements Comparable<Appointment>{
    /**
     * @param appointment_day holds the time of the appointment
     * @param awake true if the appointment is active
     * @param relatedDoctor is the Doctor of the appointment
     * @param attachedPatient is the Patient of the appointment
     * */
    private GregorianCalendar appointment_day;
    private Boolean awake = true;
    private Doctor relatedDoctor;
    private Patient attachedPatient;


    /**Empty constructor*/
    public Appointment(){
        appointment_day = null;
        relatedDoctor = null;
        attachedPatient = null;
        awake = true;
    }
    /**Constructor without doctor input*/
    public Appointment(Patient input_PATIENT,  GregorianCalendar input_GregorianCalendar){
        // Default Constructor without doctor data
        attachedPatient = input_PATIENT;
        appointment_day = input_GregorianCalendar;
        awake = true;
    }/**Constructor with the GregorianCalender input*/
    public Appointment(Doctor input_DOCTOR, Patient input_PATIENT,  GregorianCalendar input_GregorianCalendar){
        // Default Constructor with GregorianCalendar datatype
        relatedDoctor = input_DOCTOR;
        attachedPatient = input_PATIENT;
        appointment_day = input_GregorianCalendar;
        awake = true;
    }
    /**Constructor with the integer as time inputs*/
    public Appointment(Doctor input_DOCTOR, Patient input_PATIENT, int year, int month, int day, int hour, int minute){
        //  Default constructor with integer inputs
        relatedDoctor = input_DOCTOR;
        attachedPatient = input_PATIENT;
        appointment_day = new GregorianCalendar(year,month,day,hour,minute);
        awake = true;
    }

    /**@return awake*/
    public Boolean isAwake(){
        // Method that will return if appointment is checked out by Patient or by Doctor or not
        return awake;
    }

    /**@return appointment time*/
    public GregorianCalendar getGregorianCalendar(){
        // Returning appointment time
        return appointment_day;
    }
    /**@return doctor*/
    public Doctor getDoctor(){
        // Returning assigned doctor class
        return relatedDoctor;
    }
    /**@return patient*/
    public Patient getPatient(){
        // Returning assigned patient class
        return attachedPatient;
    }
    /**Setting time or editing time of the appointment*/
    public void setGregorianCalendar(GregorianCalendar input_GregorianCalendar) {
        // Setting a new GregorianCalendar
        this.appointment_day = input_GregorianCalendar;
    }

    /**Setting or editing the doctor*/
    public void setDoctor(Doctor doctor) {
        // Setting a new GregorianCalendar
        this.relatedDoctor = doctor;
    }

    /**Setting or editing the doctor*/
    public void setPatient(Patient patient) {
        // Setting a new GregorianCalendar
        this.attachedPatient = patient;
    }

    /**Setting or editing the awake*/
    public void setAwake(Boolean input_B) {
        // Setting a status to appointment
        this.awake = input_B;
    }

    /**@return A string version of the appointment for Doctor class*/
    public String printForDoctor(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Patient: " + this.getPatient().print() + "\n Time: " + this.getGregorianCalendar().getTime());
        return stringBuilder.toString();
    }

    /**A print function to print appointment informations*/
    public void print(){
        GregorianCalendar now = new GregorianCalendar();
        System.out.print("\n"+toString());
        if (awake)
            System.out.print(" Status: Active");
        else if (appointment_day.before(now))
            System.out.print(" Status: Passed");
        else
            System.out.print(" Status: Non-Active");
    }

    /**Overriding to String
     * @return A string version of the appointment
     * */
    @Override
    public String toString(){
        return "Doctor: " + this.getDoctor() + " Patient: " + this.getPatient() + " Time: " + this.getGregorianCalendar().getTime();
    }

    /**
     * Comparing appointment by doctor and time
     * @return 0 if they are equal
     * @return -1 if they are not equal
     * */
    @Override
    public int compareTo(Appointment o) {
        if(o.getDoctor().equals(this.getDoctor())
                &&this.getGregorianCalendar().getTime().getHours() == o.getGregorianCalendar().getTime().getHours()
                &&this.getGregorianCalendar().getTime().getMinutes() == o.getGregorianCalendar().getTime().getMinutes()
                &&this.getGregorianCalendar().getTime().getMonth() == o.getGregorianCalendar().getTime().getMonth()
                &&this.getGregorianCalendar().getTime().getYear() == o.getGregorianCalendar().getTime().getYear()
                &&this.getGregorianCalendar().getTime().getDay() == o.getGregorianCalendar().getTime().getDay()
                ){
            return 0;
        }
        return -1;
    }
}