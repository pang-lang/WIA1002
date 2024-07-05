/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

/**
 *
 * @author panglang
 */
public class LL {
    class Node {
        Node next;
        String title;
        int pages;

        public Node(String title, int pages) {
            this.title = title;
            this.pages = pages;
        }
        
        public String toString(){
            return title + ": " + pages + ",000,000 Sold";
        }
    }
    
    private Node head;
    private Node tail;
    private int size;

    public LL() {
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void createNode(String t, int p){
        Node newNode = new Node(t,p);
        if (head == null){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public void addAfter(String before, String after, int p){
        System.out.println("Adding " + after + " after " + before);
        Node current = head;
        int i=1;
        while (current != null && !current.title.equals(before)){
            current = current.next;
            i++;
        }
        
        if (current != null){
            System.out.println("Found " + before + " which is book number " + i + " in linked list");
            Node newNode = new Node(after, p);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }
    
    public void removeNode(String s) {
        System.out.println("\nRemoving " + s + "...");

        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        if (head.title.equals(s)) {
            head = head.next;
            size--;
            System.out.println(s + " is the first book. Removing " + s + " from the linked list\n");
            return;
        }

        Node current = head;

        while (current.next != null && !current.next.title.equals(s)) {
            current = current.next;
        }

        if (current.next != null && current.next.title.equals(s)) {
            current.next = current.next.next;
            size--;
            System.out.println("Removed the node with title: " + s);
        } else {
            System.out.println("Couldn't find book");
        }
    }

    
    public void display(){
        System.out.println("\nDisplaying the Linked List **************************\n");
        Node current = head;
        while (current != null){
            System.out.println(current.toString());
            current = current.next;
        }
        System.out.println("");
    }
    
}
