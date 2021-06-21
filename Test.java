import java.util.Random;
import java.io.*;

public class Test{
	public static void main( String args[] ){
		ListGraph<Doctor> deneme1 = new ListGraph<Doctor>(3, false);
		ListGraph<Patient> deneme12 = new ListGraph<Patient>(3, false);
		ListGraph<Admin> deneme13 = new ListGraph<Admin>(3, false);

		System.out.println("\nhi ess");

		Hospital h1 = new Hospital("deneme1");
		PersonalClass p1 = new PersonalClass("ess","ess","e","s");
		PersonalClass p2 = new PersonalClass("emine","sultan","s","dsds");
		PersonalClass p3 = new PersonalClass("minnoş","savran","dssd","jfdkljfld");
		//System.out.println(h1.getRelatedUsers());

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

		deneme();

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