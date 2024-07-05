/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Q4;

public class SinglyLinkedListFinals {
    class Node {
        int element;
        Node next;
        
        public Node(int element) {
            this.element = element;
        }
    }
    
    Node head;
    Node tail;
    int size;

    private void add(int i) {
        System.out.println("Adding: " + i);
        Node newNode = new Node(i);
        if (head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    private void addAfter(int e, int i) {
        System.out.println("Adding " + e + " after " + i);
        Node current = head;
        while (current != null && current.element != i){
            current = current.next;
        } 
        if (current != null){
            Node newNode = new Node(e);
            newNode.next = current.next;
            current.next = newNode;
            if (current == tail){
                tail = newNode;
            }
        }
        size++;
    }

    private void traverse() {
        System.out.println("\nShowing the content of my linked list: ");
        Node current = head;
        while (current != null){
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println("");
    }

    private void deleteFront() {
        System.out.print("\nDeleting front : ");
        if (head == null){
            return;
        } else {
            int removed = head.element;
            head = head.next;
            if (head == null){
                tail = null; 
            }
            size--;
            System.out.print(removed);
        }
        System.out.println("");
    }

    private void deleteAfter(int i) {
        System.out.println("\nTesting deleteAfter: ");
        Node current = head;
        while (current != null && current.element != i){
            current = current.next;
        } 
        if (current != null && current.next != null){
            Node removed = current.next;
            current.next = removed.next;
            if (removed == tail){
                tail = current;
            }
            System.out.println("After " + i + " is " + removed.element + ". Deleting " + removed.element);
        } else {
            System.out.println("Element (" + i + ") not found...");
        }
    }
    
    public static void main(String[] args) {
        SinglyLinkedListFinals sl = new SinglyLinkedListFinals();
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
