import java.util.Random;
import java.util.Scanner;

public class Main{
	public static void main( String args[] ){
		/*Create hospital*/
		Hospital hospital = new Hospital("Group 2");
		System.out.println("\nWelcome to " + hospital.getName() + " Hospital Management System");
		System.out.println("---------------------------------------------");
		/*Get the hospital's admin*/
		Admin admin = hospital.getAdmin();
		/*Create hospital's datas*/
		/*Create doctors*/
		PersonalClass p1 = new PersonalClass("ddedededeeeeeeeee","dedede","e","s");
		PersonalClass p2 = new PersonalClass("emine","sultan","s","dsds");
		PersonalClass p3 = new PersonalClass("minnoş","savran","dssd","jfdkljfld");
		Doctor doctor1 = new Doctor(p1,hospital,"kalp");
		Doctor doctor2 = new Doctor(p2,hospital,"kalp");
		Doctor doctor3 = new Doctor(p3,hospital,"kalp");
		admin.addDoctor(doctor1);
		admin.addDoctor(doctor2);
		admin.addDoctor(doctor3);
		/*Create patients*/
		PersonalClass p4 = new PersonalClass("a","a","a","a");
		PersonalClass p5 = new PersonalClass("b","b","b","b");
		PersonalClass p6 = new PersonalClass("c","c","c","c");
		Patient patient1 = new Patient(p4,hospital);
		Patient patient2 = new Patient(p5,hospital);
		Patient patient3 = new Patient(p6,hospital);
		admin.addPatient(patient1);
		admin.addPatient(patient2);
		admin.addPatient(patient3);
		/*Create pharmacists*/
		PersonalClass p7 = new PersonalClass("a","a","d","a");
		PersonalClass p8 = new PersonalClass("b","b","e","b");
		PersonalClass p9 = new PersonalClass("c","c","f","c");
		Pharmacist pharmacist1 = new Pharmacist(p7,hospital);
		Pharmacist pharmacist2 = new Pharmacist(p8,hospital);
		Pharmacist pharmacist3 = new Pharmacist(p9,hospital);
		admin.addPharmacist(pharmacist1);
		admin.addPharmacist(pharmacist2);
		admin.addPharmacist(pharmacist3);
		/*Create receptionist*/
		PersonalClass p10 = new PersonalClass("a","a","g","a");
		PersonalClass p11 = new PersonalClass("b","b","l","b");
		PersonalClass p12 = new PersonalClass("c","c","m","c");
		Receptionist receptionist1 = new Receptionist(p10,hospital);
		Receptionist receptionist2 = new Receptionist(p11,hospital);
		Receptionist receptionist3 = new Receptionist(p12,hospital);
		admin.addReceptionist(receptionist1);
		admin.addReceptionist(receptionist2);
		admin.addReceptionist(receptionist3);

		/*
		try{
			doctor1.addSuggestion(receptionist1);
		} catch (Exception e){
			System.out.println("sadece doktor ya da eczacı eklenebilir");
		}

		*/
		Prescription pres1 = new Prescription(patient1);
		pres1.addMedicine(new Medicine("Nurofen", 15, 1));
		pres1.addMedicine(new Medicine("Arveles",8,2));
		pres1.addMedicine(new Medicine("Parol", 5, 1));
		pres1.addMedicine(new Medicine("Deloday",21,1));
		//System.out.println(pres1);

		/*Main menu*/
		String mail = "";
		String password = "";
		int selection;
		Scanner scanner = new Scanner(System.in);
		boolean exit = true;
		while(exit){
			System.out.println("\n 1 - Login");
			System.out.println(" 0 - Exit");
			System.out.print("Please enter: ");
			selection = scanner.nextInt();
			switch (selection){
				case 1:
					System.out.print("Email: ");
					mail = scanner.nextLine();
					mail = scanner.nextLine();
					System.out.print("Password: ");
					password = scanner.nextLine();
					hospital.login(mail, password);
					break;
				case 0:
					exit = false;
					break;
				default:
					System.out.println(" WARNING: Wrong command.");
					break;
			}
		}


/*
		Doctor d1 = new Doctor(p1,h1,"kalp");
		Doctor d2 = new Doctor(p2,h1,"dahiliye");
		Pharmacist pharmacist1 = new Pharmacist(p3, h1);
		System.out.println("suggestion hiç eklenmemiş:");
		
		d1.showSuggestions();
		d1.addSuggestion(d2);
		System.out.println("Zaten var olan birini tekrar eklemek:");
		d1.addSuggestion(d2);
		d1.addSuggestion(pharmacist1);
		d2.addSuggestion(pharmacist1);
		//eğer d1 d2yi eklediyse d2 d1'i ekleyemiyor
		d2.addSuggestion(d1);

		System.out.println(" -> d1: " + d1.getPersonalData().getId());
		d1.showSuggestions();
		System.out.println("after remove:");
		d1.removeSuggestion(d2);
		d1.showSuggestions();
		System.out.println(" -> d2: " + d2.getPersonalData());
		d2.showSuggestions();
		System.out.println(" -> pharmacist1: " + pharmacist1.getPersonalData().getId());

		//deneme();
*/
	}



    public static void deneme() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 3;
        Random random = new Random();
    	AVLTree<User> avlHolder=new AVLTree<>();
    	BinarySearchTree<User> binaryHolder=new BinarySearchTree<>();
    	BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        StringBuilder last = new StringBuilder(targetStringLength);
    	int j = 0;
    	for(j=0;j<10000;j++){
    	    bst.add(j);
    	    /*
    	    buffer = new StringBuilder(targetStringLength);
            for(int i = 0; i < targetStringLength; i++) {

            	int randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit + 1));

            	buffer.append((char) randomLimitedInt);

            	
			}
			if(j==9999)
			  	last.append(buffer);
			 */
		//	avlHolder.add(new Doctor(j.toString(),j.toString()));
	    //  	binaryHolder.add(new Doctor(j.toString(),j.toString()));
       		
       	//	System.out.println(j.toString());
    	}
        String generatedString = buffer.toString();

        //System.out.println(generatedString);
        double start=0,end=0;
        start=System.nanoTime();
    	binaryHolder.find(new Doctor(last.toString(),last.toString()));
   	 	end=System.nanoTime();

        System.out.println("Last item found in Binary tree in "+(end-start)+" nanoseconds");

        start=System.nanoTime();
    	avlHolder.find(new Doctor(last.toString(),last.toString()));
    	end=System.nanoTime();


        System.out.println("Last item found in AVL tree in "+(end-start)+" nanoseconds");

    //    System.out.println(avlHolder);

   	//    System.out.println(avlHolder);


    }

}