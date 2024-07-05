/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

import java.util.NoSuchElementException;

/**
 *
 * @author panglang
 */
public class GenericStack <E> {
    class Node {
        Node next;
        E element;

        public Node(E element) {
            this.element = element;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    private int maxCapacity;

    public GenericStack(int size) {
        this.size = 0;
        this.maxCapacity = size;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size == maxCapacity;
    }
    
    public E peek(){
        if (head == null){
            throw new NoSuchElementException();
        } else {
            return head.element;
        }
    }
    
    public void push(E e){
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + e);
            return;
        }
        System.out.println("Push: " + e);
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void pushMany(String s){
        System.out.println("Push many into stack...");
        String[] ss = s.split(",");
        for (int i=0; i<ss.length; i++){
            push((E) ss[i].trim());
        }
    }
    
    public E pop(){
        if (head == null){
            throw new NoSuchElementException();
        } else {
            E removed = head.element;
            head = head.next;
            size--;
            return removed;
        }
    }
    
    public E popMiddle(){
        if (size % 2 == 0){
            System.out.println("Current count stack is even number, so no middle index");
            return null;
        } else {
            int middle = size / 2;
            // middle is head
            if (middle == 0){
                return pop();
            }
            Node current = head;
            for (int i=0; i<middle-1; i++){
                current = current.next;
            }
            E removed = current.next.element;;
            if (current != null){
                current.next = current.next.next;
                size--;
            }
            return removed;
        }
    }
    
    public void popAll(){
        System.out.println("There are " + size + " items in the stack. Pop all... ");
        while (!isEmpty()){
            if (head == null){
                throw new NoSuchElementException();
            } else {
                E removed = head.element;
                head = head.next;
                size--;
                System.out.println("Removing " + removed + "..");
            }
        }
    }
    
    public void display(){
        if (isEmpty()){
            System.out.println("\nStack is empty, nothing to display...");
        } else {
            System.out.println("\nThere are " + size + " items in the stack. Displaying...");
            Node current = head;
            while (current != null){
                System.out.println(current.element);
                current = current.next;
            }
        }
        System.out.println("");
    }
    
    
    
}
