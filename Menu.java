import java.util.Random;

public class Menu {

	public static void main(String args[]) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 5;
		Random random = new Random();
    AVLTree<User> avlHolder=new AVLTree<User>();
    BinarySearchTree<User> binaryHolder=new BinarySearchTree<User><User>();
    
		StringBuilder buffer = new StringBuilder();
		StringBuilder last = new StringBuilder();
    for(int j=0;j<10000;j++){
      
		     for   (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) 
            (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
            if(j==9999)
              last.append(buffer);
		  }
      avlHolder.add(new User(buffer,buffer));
      binaryHolder.add(new User(buffer,buffer));
    }
		String generatedString = buffer.toString();

		System.out.println(generatedString);
		double start=0,end=0;
		start=System.currentTimeMillis();
    binaryHolder.find(User(last,last));
    end=System.currentTimeMillis();
    
		System.out.println("Last item found in Binary tree in "+(end-start)+" seconds");
    
		start=System.currentTimeMillis();
    avlHolder.find(User(last,last));
    end=System.currentTimeMillis();
    
    
		System.out.println("Last item found in AVL tree in "+(end-start)+" seconds");
		
	}
}
