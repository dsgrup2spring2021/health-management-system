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



    public void makeAppointment(Appointments appointment) { }

    public boolean chooseDoctor(Doctor doctor) { return true; }

    public void showFreeTime(Doctor doctor) { }

    public void enterInformations(){ }

    public boolean appointmentHistory() {
        return false;
    }

    //public void showTestResults(){ }

}
