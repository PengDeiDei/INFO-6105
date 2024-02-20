/*
 * @author: Haonan Peng
 * @email: peng.haon@northeastern.edu
 *
 * This class is to test the MyBag class.
 */
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyBag<Integer> myBag = new MyBag<>();
        Random rand = new Random();

        for(int i  = 0; i < 10; i++){
            myBag.add(rand.nextInt(10)+1);
        }
        System.out.println("The size of the bag: "+myBag.size());

        System.out.println("Randomly pick an element from the bag: " + myBag.grab());

        int randInt = rand.nextInt(10)+1;
        System.out.println("Does the bag contains " +randInt+ "? "+ myBag.contains(randInt));

        Object[] itemsArr = myBag.toArray();
        System.out.println("Turn the bag into an array.");

        for(Object item: itemsArr){
            System.out.print(item+" ");
        }
        System.out.println();

        myBag.add(15);
        System.out.println("Add 15 to the bag.");
        System.out.println("Does the bag contains 15  "+ myBag.contains(15));
        System.out.println("The bag currently contains: "+ myBag);

        System.out.println("Remove 15 from the bag");
        myBag.remove(15);
        System.out.println("Does the bag contains 15? "+ myBag.contains(15));
        System.out.println("The bag currently contains: "+myBag.toString());

        myBag.clear();
        System.out.println("Clear the bag.");
        System.out.println("Is the bag empty? " + myBag.isEmpty());
    }
}