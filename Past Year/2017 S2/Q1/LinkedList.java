/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q1;

/**
 *
 * @author panglang
 */
public class LinkedList{
    class Node {
        Node next; 
        String data;
        int units;

        public Node() {
        }
        
        public Node(String data, int units) {
            this.data = data;
            this.units = units;
        }
    }
    Node head;
    Node tail;
    int size = 0;
    
    public void insertFirstLink(String s, int k){
        if (head == null){
            head = tail = new Node(s,k);
        } else {
            Node newNode = new Node(s,k);
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }
    
    public void addAfter(String s1, String s2, int k){
        int i = 1;
        Node current = head;
        while (current != null && !current.data.equals(s1)){
            current = current.next;
            i++;
        } 
        if (current != null){
            System.out.println("Adding " + s2 + " after " + s1);
            Node newNode = new Node(s2,k);
            newNode.next = current.next;
            current.next = newNode;
        } 
        System.out.println("Found " + s1 + " which is handbag number " + i + " in the linked list");
        size++;
    }
    
    public void removeLink(String s){
        System.out.println("Removing " + s + ".. ");
        
        Node current = head;
        Node previous = null;
        int i = 1;
        boolean found = false;
        
        while (current.next != null){
            if (current.data.equals(s)){
                found = true;
                break;
            }
            previous = current;
            current = current.next; 
            i++;
        }
        
        if (found){
            System.out.println("Found a match.. " + s + " is handbag number " + i + " in the linked list");
            if (previous == null){ // remove head;
                head = current.next;
            } else {
                previous.next = current.next;
                if (current.next == null){
                    tail = previous;
                }
            }
            size--;
        } else {
            System.out.println(s + " not found in the linked list.");
        }
    }
    
    public void display(){
        System.out.println("Displaying the Linked List: " + "*".repeat(40));
        Node current = head;
        while (current != null){
            System.out.println(current.data + ": " + current.units + " Sold");
            current = current.next;
        }
    }
    
    public static void main(String[] args) {
        LinkedList sl = new LinkedList();
        sl.insertFirstLink("Louis Vuitton", 10_000_000);
        sl.insertFirstLink("Chanel", 100_000_000);
        sl.insertFirstLink("Prada", 1_000_000);
        sl.insertFirstLink("Tods", 500_000_000);
        sl.display();
        System.out.println("");
        sl.addAfter("Chanel", "Coach", 10_000_000);
        sl.display();
        System.out.println("");
        sl.addAfter("Coach", "Mulberry", 90_000_000);
        sl.display();
        System.out.println("");
        sl.removeLink("Chanel");
        System.out.println("");
        sl.display();
        System.out.println("");
        sl.removeLink("Coach");
        System.out.println("");
        sl.display();
    }
}
