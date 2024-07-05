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
public class StackWithGeneric <E> {
    class Node {
        E element;
        Node next;
    
        public Node(E element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public StackWithGeneric(int size) {
        this.size = 0;
    }

        public boolean isEmpty(){
            return size == 0;
        }
        
        public E peek(){
            if (head == null){
                throw new NoSuchElementException();
            } else {
                return head.element;
            }
        }
        
        public void push(E s){
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
        
        public E pop(){
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
        
        
        public void display(){
            System.out.println("Display stack: ");
            StackWithGeneric <E> temp = new StackWithGeneric<>(size);
            Node current = head;
            while (current != null){
                temp.push(current.element);
                current = current.next;
            }
            
            while (!temp.isEmpty()){
                System.out.println(temp.pop());
            }
        }
        
        public void displayReverse(){
            System.out.println("Display stack in reverse: ");
            Node current = head;

            while (current != null){
                System.out.println(current.element);
                current = current.next;
            }
        }
        
        public static void main(String[] args) {
            StackWithGeneric <String> stack1 = new StackWithGeneric <String> (4) ;
            stack1.push ("one"); 
            stack1.push ("two");
            stack1.push ("three");
            stack1.push ("four");
            System.out.println(stack1.peek());
            stack1.display();
            stack1.displayReverse() ;
            stack1.popAll();
            
            StackWithGeneric<Integer> stack2 = new StackWithGeneric<Integer>(4) ;
            stack2.push(100); 
            stack2.push(200) ;
            stack2.push(300) ;
            stack2.push(400) ;
            System.out.println(stack2.peek()) ;
            stack2.display();
            stack2.displayReverse() ;
            stack2.popAll() ;
    }
}
