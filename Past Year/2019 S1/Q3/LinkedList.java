/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author panglang
 */
public class LinkedList {
    class Node {
        String course;
        int credit;
        Node next;
        
        public Node(String course, int credit) {
            this.course = course;
            this.credit = credit;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }
    
    public void add(String s, int c){
        Node newNode = new Node(s, c);
        if (head == null){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public void addAfter(String before, String after, int credit){
        System.out.println("\nAdding " + after + " after " + before);
        Node newNode = new Node(after, credit);
        Node current = head;
        while (current != null && !current.course.equals(before)){
            current = current.next;
        }
            
        if (current != null){
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
    
    public void totalCreditHours(){
        int total = 0;
        Node current = head;
        while (current != null){
            total += current.credit;
            current = current.next;
        }
        System.out.println("\nTotal credit hours: " + total);
    }
    
    public void remove(String s, int c){
        System.out.println("\nRemoving " + s + "..");
        if (size == 0)
            return;
        
        if (head.course.equals(s) && head.credit == c){
            head = head.next;
            size--;
        }
        
        Node current = head;
        while (current.next != null){
            if (current.next.course.equals(s) && current.next.credit == c){
                current.next = current.next.next;
                size--;
            }
            current = current.next;
        }
    }
    
    public void display(){
        System.out.println("\nDisplaying the Linked List -------------------\n");
        Node current = head;
        while (current != null){
            System.out.println(current.course + ": " + current.credit + " hours");
            current = current.next;
        }
        
    }
}
