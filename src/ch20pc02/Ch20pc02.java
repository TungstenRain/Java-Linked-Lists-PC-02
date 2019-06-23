package ch20pc02;

/**
 * 
 * @author frank
 */
public class Ch20pc02 {

    /**
     * The Main Method
     * @param args String[] The command line arguments
     */
    public static void main(String[] args) {
        // Instantiate GenericLinkedList
        GenericLinkedList linkedList = new GenericLinkedList();
        
        // Add to linkedList
        linkedList.add("Amy");
        linkedList.add("Bob");
        linkedList.add(0, "Al");
        linkedList.add(2, "Beth");
        linkedList.add(4, "Carol");
        
        System.out.println("Welcome to the Linked List Sorting and Reversing program.");
        System.out.println("The members of the list are:");
        System.out.print(linkedList);
        
        // Reverse the linkedList
        linkedList.first = linkedList.reverse(linkedList.first);
        System.out.println("The Members of the list after reversing are:");
        System.out.print(linkedList);
        
        // Sort the linkedList
        linkedList.first = linkedList.SortLinkedList(linkedList.first);
        System.out.println("The members of the list after sorting are:");
        System.out.print(linkedList);
    }
}
