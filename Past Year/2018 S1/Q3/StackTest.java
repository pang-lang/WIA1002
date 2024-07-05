/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

import java.util.NoSuchElementException;

/**
 *
 * @author panglang
 */
public class StackTest {
    class Node {
        String element;
        Node next;
    
        public Node(String element) {
            this.element = element;
        }
    }
    
    private Node head;
    private int size;
    private int capacity;
    
        public StackTest(int capacity){
            this.size = size;
            this.capacity = capacity;
        }
        
        public boolean isEmpty(){
            return size == 0;
        }
        
        public void peek(){
            if (head == null){
                throw new NoSuchElementException();
            } else {
                System.out.println(head.element);
            }
        }
        
        public void push(String s){
            Node newNode = new Node(s);
            if (head == null){
                head = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            System.out.println("Push item onto stack: " + newNode.element);
            size++;
        }
        
        public String pop(){
            if (head == null){
                throw new NoSuchElementException();
            } else {
                Node removed = head;
                head = head.next;
                size--;
                return removed.element;
            }
        }
        
        public void popAll(){
            System.out.println("Pop all item in stack: ");
            Node current = head;
            while (current != null){
                System.out.println("Removing " + pop() + "... ");
                current = current.next;
            }
        }
        
        public void displayReverse(){
            System.out.println("Display stack in reverse: ");
            Node current = head;
            if (current == null){
                for (int i=0; i<capacity; i++){
                    System.out.println("null");
                }
            }
            while (current != null){
                System.out.println(current.element);
                current = current.next;
            }
        }
        
        public static void main(String[] args) {
        
            StackTest stack1 = new StackTest(4);
            stack1.push("one");
            stack1.push("two");
            stack1.push("three");
            stack1.push("four");
            stack1.displayReverse();
            stack1.popAll();
            stack1.displayReverse(); 
    }
}
