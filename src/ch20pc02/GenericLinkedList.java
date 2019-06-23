package ch20pc02;

/**
 * 
 * @author frank
 */
public class GenericLinkedList {
    // Fields
    public Node first;
    private Node last;
    
    // Constructor
    public GenericLinkedList() {
        first = null;
        last = null;
    }
    
    // Determine if the field first is empty
    public boolean isEmpty() {
        return first == null;
    }
    
    // Determine the size
    public int size() {
        int count = 0;
        Node p = first;
        while (p != null) {
            count ++;
            p = p.next;
        }
        return count;
    }
    
    // Add a string
    public void add(String e) {
        if (isEmpty()) {
            first = new Node(e);
            last = first;
        } else {
            last.next = new Node(e);
            last = last.next;
        }
    }
    
    // Overload the add with an index and a string
    public void add(int index, String e) {
        if (index < 0 || index > size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        
        if (index == 0) {
            first = new Node(e, first);
            if (last == null) {
                last = first;
            }
            return;
        }
        
        Node pred = first;
        for (int k = 1; k <= index - 1; k++) {
            pred = pred.next;
        }
        
        pred.next = new Node(e, pred.next);
        
        if (pred.next.next == null) {
            last = pred.next;
        }
    }
    
    // Create a private class Node
    private class Node {
        String value;
        Node next;
        
        Node(String val, Node n) {
            value = val;
            next = n;
        }
        
        Node(String val) {
            this(val, null);
        }
    }

    // Reverse the node
    Node reverse(Node node) {
        Node previous = null;
        Node curr = node;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        node = previous;
        return node;
    }
    
    
    // Remove
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        
        String element;
        if (index == 0) {
            element = first.value;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node pred = first;
            for (int k = 1; k <= index -1; k++) {
                pred = pred.next;
            }
            
            element = pred.next.value;
            
            pred.next = pred.next.next;
            if (pred.next == null) {
                last = pred;
            }
        }
        return element;
    }
    
    // Overload Remove
    public boolean remove(String element) {
        if (isEmpty()) {
            return false;
        }
        
        if (element.equals(first.value)) {
            first = first.next;
            if (first == null) {
                last = null;
            }
            return true;
        }
        
        Node pred = first;
        while (pred.next != null && !pred.next.value.equals(element)) {
            pred = pred.next;
        }
        
        if (pred.next == null) {
            return false;
        }
        
        pred.next = pred.next.next;
        if (pred.next == null) {
            last = pred;
        }
        return true;
    }
    
    // Sort the linked list
    public Node SortLinkedList(Node head){
        if(head==null || head.next==null){
            return head;
        }
        
        Node middle = findMiddle(head);
        Node Middle = middle.next;
        middle.next = (null);
        
        Node l = SortLinkedList(head);
        Node r = SortLinkedList(Middle);
        
        Node sorted = merge(l, r);
        return sorted;
    }
    
    // Merge
    private Node merge(Node a, Node b){
        if(a==null) {
            return b;
        }
        
        if(b==null) {
            return a;
        }
        
        Node temp=null;
        
        if(a.value.compareTo(b.value)<0){
            temp=a;
            temp.next = (merge(a.next, b));
        } else {
            temp=b;
            temp.next = (merge(a, b.next));
        }
        return temp;
    }
    
    // Find the middle
    private Node findMiddle(Node head) {
        if(head==null){
            return head;
        }
        
        Node curr=head;
        Node temp=head;
        
        while(temp!=null && temp.next!=null && temp.next.next!=null) {
            curr = curr.next;
            temp = temp.next.next;
        }
        return curr;
    }
    
    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        
        Node p = first;
        while (p != null) {
            strBuilder.append(p.value + "\n");
            p = p.next;
        }
        return strBuilder.toString();
    }
}
