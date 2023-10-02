import java.util.NoSuchElementException;

/**
 * Singly Linked list class containing an implementation of
 * merge sort 
 * @author hankbreen
 *
 * @param <E> 
 */
public class SingleLinked  <E extends Comparable<E>>{
    
    public Node<E> head;
    
    public int size;   
    
    /*
     * Creates an empty list.
     */
    public SingleLinked() {
        head = null;
        size = 0;
    }
    
    /*
     * Returns a space-separated list of the elements in the list.
     * If the list contains no elements, return an empty string ""
     */
    public String toString() {
        String str = "";
        
        Node<E> current = head;
        while (current != null) {
            
            str += current.data + " ";
            current = current.next;
        }
        
        return str;
    }
    
    
    /*
     * Returns the first item in the list. If the list is empty,
     * throw a NoSuchElementException.
     */
    public E getFirst() {
        if (head == null) {
            throw new NoSuchElementException(
                    "No such element!");
        }
        return head.data;
    }
    
    /*
     * Returns the last item in the list. If the list is empty,
     * throw a NoSuchElementException.
     */
    public E getLast() {
        if (head == null) {
            throw new NoSuchElementException(
                    "No such element!");           
        }
        return null;
    }
    
    /*
     * Returns the item at the specified index. If the index
     * is not valid, throw an IndexOutOfBoundsException.
     */
    public Node<E> getAt(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException (
                    "Index is out of bounds!");
        }
        Node<E> current = head;
        for (int i = 0 ; i < size - 1; ++i) {
            
            // if the index equals the i value then return the data there
            if (index == i) {
                return current;
            }
            current = current.next;
        }
        return current;
    }
    
    /*
     * Inserts an item at the beginning of the list.
     */
    public void insertFirst(E num) {
        
        Node<E> newNode = new Node<E>(num);
        
        if (head == null) {
            
            // the list is empty
            head = newNode;
          
        } else { // the list is not empty
            
            // swapping them
            newNode.next = head;
            head = newNode;         
        }
        size++;     
    }
    

    
    /*
     * Removes and returns the first element from the list.  If the 
     * list is empty, throw a NoSuchElementException.
     */
    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException(
                    "No such element!");
        } else if (size == 1) {
            // remove head and decrease size
            head = null;
            size--;
        } else {
            
            // save head data in int to return later
            E ans = head.data;
            
            // save head as the second one, then set original to null
            head = head.next;
            size--;
            return ans;
        }
        return null;
    }
    
 
    /*
     * Returns the number of elements in the list.
     */
    public int getSize() {
        return size;
    }
    
    /*
     * Returns true if the list is empty, and false otherwise.
     */
    public boolean isEmpty() {
        // if head and tail are empty
        if (head == null) {
            return true;
        } 
        return false; 
    }
    
    
    // A private Node class.  By making it an inner class, 
    // the outer class can access it easily, but the client cannot. 
    class Node<T extends Comparable <E>> {
        public T data;
        public Node<T> next;

        // Constructs a new node with the specified data
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
     
    /**
     * Merge sort helper method which recursively sorts.
     * @param a
     * @param b
     * @return
     */
     private Node<E> sortedMerge(Node<E> a, Node<E> b) {
         
         Node<E> result = null;
         
         if (a == null) {
             return b;
         }
         if (b == null) {
             return a;
         }
         
         // calls compareTo method to check each node
         if (a.data.compareTo(b.data) < 0) {
             result = a;
             result.next = sortedMerge(a.next, b);
         } else {
             result = b;
             result.next = sortedMerge(b.next, a);
         }
         
         return result;
          
     }
     
     /**
      * Main Merge sort method which calls the other
      * two helper methods along with itself.
      * @param n a node of the list
      * @return a node
      */
     private Node<E> mergeResult(Node<E> n) {
         if (n == null || n.next == null) {
             return n;
         }
         
         Node<E> middle = getMiddle(n);
         
         Node<E> nextMiddle = middle.next;
         middle.next = null;
         
         Node<E> left = mergeResult(n);
         Node<E> right = mergeResult(nextMiddle);
         Node<E> sorted = sortedMerge(left, right);
         return sorted;
          
     }
     
     /**
      * Merge sort helper method to get the middle of the list.
      * @param n a Node
      * @return the middle of the list.
      */
     private Node<E> getMiddle(Node<E> n) {
         if (n == null) {
             return n;
         }
         
         Node<E> slow = n;
         Node<E> fast = n;
         
         while (fast.next != null && fast.next.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }
         
         return slow;
     }
     
     /**
      * public method to call the merge sort.
      * @param h the head of the list.
      */
     public void mergeMethod(Node<E> h) {
         h = mergeResult(h);
     }
     
     
     /**
      * Method that prints a list.
      * @param head the head of the list to be printed.
      */
     public void printList(Node<E> head) {
         Node<E> current = head;
         
         while (current != null) {
             System.out.println(current.data.toString());
             current = current.next;
             System.out.printf("\n");
         }
         
     }
    
    
   
}
