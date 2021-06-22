public class Patient extends User{
    /**
     *
     * @author Mustafa Furkan Ergin
     *
     */

    private int age;
    private int weight;
    private int height;
    private String bloodType;
    private Doctor doc;
    private Appointment myApp;

    public Patient(int age, int weight, int height, String bloodType) {
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.bloodType = bloodType;
    }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age;}

    public int getWeight() { return weight; }

    public void setWeight(int weight) { this.weight = weight; }

    public int getHeight() { return height; }

    public void setHeight(int height) { this.height = height; }

    public String getBloodType() { return bloodType; }

    public void setBloodType(String bloodType) { this.bloodType = bloodType; }



    public void makeAppointment(Appointment appointment) {
    	myApp=new Appointment();
    }

    public boolean chooseDoctor(Doctor doctor) { 
    	this.doc=doctor;
    	return true; 
    }

    public void showFreeTime(Doctor doctor) {
    	doctor.showFreeTime();
    }

    public void enterInformations(){
    	//scanner kullanmayacaksak buranın pek bi anlamı kalmadı
    }

    public boolean appointmentHistory() {
        return false;
    }

    //public void showTestResults(){ }

    /**
    * sees a specific user's suggestions
    * @param user the user(doctor or pharmacist)
    */
    public void showSuggestions(User user){
        if(user instanceof Doctor || user instanceof Pharmacist)
            System.out.println(getHospital().getRelatedUsers().print(user));
        else
            throw new IllegalArgumentException();
    }
}
