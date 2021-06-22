public class Patient extends User{
    private int age;
    private int weight;
    private int height;
    private String bloodType;
    private Doctor appointments;
    //geçmiş reçeteler
    //hastalıklar
    public Patient(PersonalClass data, Hospital hospital){
        super(data, hospital);
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
        appointment=new Appointment();
    }

    public boolean chooseDoctor(Doctor doctor) { return true; }

    public void showFreeTime(Doctor doctor) {
    }

    public void enterInformations(){
        /*
        Scanner yok parametre yok nasıl kullanalım bilemedim :frowning:
        */
    }

    public boolean appointmentHistory() {
        return false;
    }

    //public void showTestResults(){ }

    /*
     * sees a specific user's suggestions
     * @param user the user(doctor or pharmacist)
     */
    public void showSuggestions(User user){
        if(user instanceof Doctor || user instanceof Pharmacist)
            System.out.println(getHospital().getRelatedUsers().print(user));
        else
            throw new IllegalArgumentException();
    }

    public void menu(){
        System.out.println("\n Welcome Patient " + this.getPersonalData().getName() + " " +this.getPersonalData().getSurname());
    }
}