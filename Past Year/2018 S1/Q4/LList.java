/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author panglang
 */
public class LList {
    class Node {
        String course;
        int credit;
        Node next;
        
        public Node(String course, int credit) {
            this.course = course;
            this.credit = credit;
        }
        
        public String toString(){
            return course + ": " + credit +" hours";
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public void add(String s, int i){
        Node newNode = new Node(s,i);
        if (head == null){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public void addAfter(String before, String after, int c){
        System.out.println("\nAdding " + after + " after " + before);
        Node current = head;
        int i=1;
        while (current != null && !current.course.equals(before)){
            current = current.next;
            i++;
        } 
        if (current != null){
            System.out.println("Found " + before + " which is book number " + i + " in the linked list");
            Node newNode = new Node(after, c);
            newNode.next = current.next;
            current.next = newNode;
            if (current == tail){
                tail = newNode;
            } 
        }
        size++;
    }
    
    public void remove(String s, int c){
        System.out.println("\nRemoving " + s + "..");
        if (size == 0){
            return;
        } 
        if (head.course.equals(s) && head.credit == c){
            System.out.println("Found " + s + " which is book number " + 1 + " in the linked list");
            head = head.next;
            size--;
            return;
        }
        int i = 2; // Since already checked the head, we start from 2
        Node current = head; 
        while (current.next != null){
            if (current.next.course.equals(s) && current.next.credit == c){
               System.out.println("Found a match ... " + s + " which is book number " + i + " in the linked list");
               current.next = current.next.next;
               size--; 
               return;
            }
            i++;
            current = current.next;
        }
    }
    
    public void totalCreditHours(){
        Node current = head;
        int total = 0;
        while (current != null){
            total += current.credit;
            current = current.next;
        }
        System.out.println("Total credit hours taken: " + total);
    }
    
    public void display(){
        System.out.println("\nDisplaying the Linked List " + "*".repeat(25) + "\n");
        Node current = head;
        while (current != null){
            System.out.println(current.toString());
            current = current.next;
        }    
    }
    
    public static void main(String[] args) {
        
        LList list = new LList();
        list.add("Computing Mathematics 1", 3);
        list.add("Principles of AI", 3);
        list.add("Programming 1", 5); 
        list.add("Data Structure", 5);
        //list.display();
        list.totalCreditHours();
        list.addAfter("Programming 1", "Software Architecture", 4);
        list.addAfter("Software Architecture","Networking", 4);
        //list.display();
        list.remove("Networking", 4);
        //list.display();
        
        list.remove("Principles of AI", 3);
        //list.display();
        list.totalCreditHours();
    }
    
}
