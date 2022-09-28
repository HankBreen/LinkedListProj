import java.util.Scanner;


import java.io.File;
import java.io.FileNotFoundException;

/**
 * Driver class for the CSE 274 HW 2 on linked lists.
 * Takes a file containing addresses and creates address objects,
 * then puts them into a single linked list and uses merge sort 
 * to sort them, then outputs the sorted list to the console.
 * @author hankbreen
 *
 */
public class Driver {
    
    static SingleLinked<Address> list = new SingleLinked<Address>();
    
    public static void main(String[] args) {
        
        // Try catch for file I/O
        try {
            
            // create scanner to read file
            Scanner scn = new Scanner(new File("addresses.txt"));
            System.out.println("The Unsorted List");
            
            // while loop while the txt file has a line,
            // and save each value in the address object
            while (scn.hasNextLine()) {
                String first = scn.nextLine();
                String last = scn.nextLine();
                String addr = scn.nextLine();
                String zip = scn.nextLine();
                String phNum = scn.nextLine();
                Address temp = new Address(last, first, 0, addr, phNum);
                
                // add the temp address object to the linked list
                list.insertFirst(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        
        // Print unsorted list
        list.printList(list.head);
        
        // now that you have printed the unsorted list,
        // mergesort the list so it can be printed.
        list.mergeMethod(list.head);
        
        // print the sorted list
        System.out.println("The Sorted List");
        list.printList(list.head);
    
    }
      
}


