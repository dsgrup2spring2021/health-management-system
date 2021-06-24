import java.util.*;

public class Patient extends User{
    private int age;
    private int weight;
    private int height;
    private String bloodType;
    private Doctor appointments;
    private ArrayList<String> diseases;
    private Stack<Prescription> prescriptions; 
    //geçmiş reçeteler
    //hastalıklar
    public Patient(PersonalClass data, Hospital hospital){
        super(data, hospital);
        this.age=-1;
        this.weight=-1;
        this.height=-1;
        this.bloodType="Unknown";
        prescriptions = new Stack<>();
        diseases = new ArrayList<>(10);
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nSurname: %s\nAge: %d\nWeight: %d\nHeight: %d\nBlood Type: %s\n", 
        getPersonalData().getName(),getPersonalData().getSurname(),
        getAge(),getWeight(),getHeight(),getBloodType());
    }
    public int getAge() { return age; }

    public void setAge(int age) { this.age = age;}

    public int getWeight() { return weight; }

    public void setWeight(int weight) { this.weight = weight; }

    public int getHeight() { return height; }

    public void setHeight(int height) { this.height = height; }

    public String getBloodType() { return bloodType; }

    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    public ArrayList<String> getDiseases(){
        return diseases;
    }

    public Stack<Prescription> getPrescriptions(){
        return prescriptions;
    }

    public String print(){
        return super.toString();
    }

    public void showHistory(){
        System.out.println(" * Personal Data * ");
        System.out.println(this.print());
        System.out.println(" -> Age: " + age);
        System.out.println(" -> Weight: " + weight);
        System.out.println(" -> Height: " + height);
        System.out.println(" -> Blood type: " + bloodType);
        System.out.println(" * Diseases * ");
        if(diseases.isEmpty()){
            System.out.println(" -> The patient does not have any disease.");
        }else{
            for(String disease: diseases){
                System.out.println(" -> " + disease);
            }
        }
        System.out.println(" * Prescriptions * ");
        if(prescriptions.isEmpty()){
            System.out.println(" -> The patient does not have any prescription.");
        }else{
            for(Prescription prescription: prescriptions){
                System.out.println(" -> " + prescription);
            }
        }
    }

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
        boolean exit = true,exit2=true;
        int selection,selection2;
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        String input;
        while (exit) {
            System.out.println("\nWelcome " + this.getPersonalData().getName()+" "+this.getPersonalData().getSurname());
            System.out.println("1. Show Profile");
            System.out.println("2. Edit Profile");
            System.out.println("3. Show Prescriptions");
            System.out.println("4. Take an Appointment");
            System.out.println("5. Show Appointments");
            System.out.println("6. Order Medicine From Pharmacy");
            System.out.println("7. Exit");
            selection=sc1.nextInt();
            switch (selection) {
                case 1:
                    System.out.println(this);
                    break;
                case 2:
                    System.out.println("\nEdit Profile");
                    System.out.print("Name: ");
                    input=sc2.nextLine();
                    getPersonalData().setName(input);
                    System.out.print("Surname: ");
                    input=sc2.nextLine();
                    getPersonalData().setSurname(input);
                    System.out.print("Age: ");
                    input=sc2.nextLine();
                    setAge(Integer.parseInt(input));
                    System.out.print("Weight: ");
                    input=sc2.nextLine();
                    setWeight(Integer.parseInt(input));
                    System.out.print("Height: ");
                    input=sc2.nextLine();
                    setHeight(Integer.parseInt(input));
                    System.out.print("Blood Type: ");
                    input=sc2.nextLine();
                    setBloodType(input);
                    System.out.println("Done!");
                    break;
                case 3:
                    System.out.println("\n");
                    for (int i = 0; i < prescriptions.size(); i++) {
                        System.out.println(prescriptions.get(i));
                    }
                    break;
                case 4:
                    System.out.println("Soon...");
                    break;
                case 5:
                    System.out.println("Soon...");
                    break;
                case 6:
                    int i = 0;
                    while (exit2) {
                        System.out.println("\nPlease select a pharmacy: ");
                        for (i = 0; i < getHospital().getPharmacists().size(); i++) {
                            System.out.println(i+". "+getHospital().getPharmacists().get(i).getPharmacyName());
                        }
                        System.out.println(i+". Exit");
                        System.out.print("Selection: ");
                        selection2=sc1.nextInt();
                        if (selection2==i) {
                            break;
                        }
                        if (prescriptions.size()!=0) {
                            for (i = 0; i < getPrescriptions().size(); i++) {
                                Doctor doc = getPrescriptions().get(i).getDoctor();
                                if (getHospital().getRelatedUsers().isEdge(getHospital().getPharmacists().get(selection2),doc)){
                                    getPrescriptions().get(i).printDiscountedPrescribes();
                                    System.out.println("Since there is an agreement between this pharmacy and the prescribing doctor, you will be able to benefit from a 50% discount.");
                                }else{
                                    System.out.println(getPrescriptions().get(i));
                                }
                            }
                        }
                        else  
                            System.out.println("You do not have any prescription right now!");
                    }
                    break;
                case 7:
                    exit=false;
                    break;
                default:
                System.err.println("WARNING: Wrong Command.");
                    break;
            }
        }
    }
}