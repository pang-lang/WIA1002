
public class LinkedList {
    class Node {
        Node next;
        int element;

        public Node(int element) {
            this.element = element;
        }
    }
    Node head;
    Node tail;
    int size = 0;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = size;
    }
    
    public void add(int i){
        System.out.println("Adding " + i);
        if (tail == null){
            tail = head = new Node(i);
        } else {
            Node newNode = new Node(i);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public void addAfter(int e, int i){
        System.out.println("Adding " + e + " after " + i);
        Node current = head;
        while (current != null && current.element != i){
            current = current.next;
        }
        if (current != null){
            Node newNode = new Node(e);
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
    
    public void deleteFront(){
        System.out.println("\nDeleting front: " + head.element);
        Node current = head;
        head = current.next;
        size--; 
    }
    
    public void deleteAfter(int x){
        System.out.println("\nTesting deleteAfter: ");
        Node current = head;
        while (current != null && current.element != x){
            current = current.next;
        } 
        if (current != null){
            System.out.println("After " + current.element + " is " + current.next.element + ". Deleting " + current.next.element);
            current.next = current.next.next;
            if (current.next == null){
                tail = current;
            } 
        } else {
            System.out.println("Element (" + x + ") not found ...");
        }
        size--;
    }
    
    public void traverse(){
        System.out.println("\nShowing the content of my linked list: ");
        Node current = head;
        while (current != null){
            System.out.print(current.element + " ");
            current = current.next;
        }
    }
    
    public static void main(String[] args) {

        LinkedList sl = new LinkedList();
        sl.add(10);
        sl.add(20);
        sl.add(30);
        sl.add(40);
        sl.add(50);

        sl.addAfter(11, 10);
        sl.addAfter(21, 20);
        sl.addAfter(31, 30);
        sl.addAfter(41, 40);
        sl.addAfter(51, 50);

        sl.traverse();
        sl.deleteFront();
        sl.deleteFront();
        sl.traverse();
        sl.deleteAfter(40);
        sl.deleteAfter(40);
        sl.deleteAfter(31);
        sl.deleteAfter(40);
        sl.traverse();
    }
}

