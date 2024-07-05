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
        E element;
        Node next;

        public Node(E element) {
            this.element = element;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;

    public GenericStack(int size) {
        this.size = 0;
    }
    
    public void push(E e){
        Node newNode = new Node(e);
        if (head == null){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        System.out.println("Push: " + newNode.element);
        size++;
    }
    
    public void pushMany(String s){
        String[] string = s.split(",");
        Node newNode = null;
        for (int i=0; i<string.length; i++){
            newNode = new Node((E) string[i].trim());
            if (head == null){
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            System.out.println("Push: " + newNode.element);
            size++;
        }
    }
    
    public void pop(){
        if (head == null){
            throw new NoSuchElementException();
        } else {
            head = head.next;
            size--;
        }
        System.out.println("Pop the top of the stack ...");
    }
    
    public void popH(){
        if (head == null){
            throw new NoSuchElementException();
        } else {
            head = head.next;
            size--;
        }
    }
    
    public E peek(){
        if (head == null){
            return null; 
        } else {
            return head.element;
        }
    }
    
    public void popAll(){
        System.out.println("There are "  + size + " items in the stack. Removing all ...");
        if (head == null){
            return;
        } else {
            Node current = head;
            while (!isEmpty()){
                System.out.println("Removing " + peek() + " ...");
                popH();
            }
        }
    }
    
    
    public boolean isEmpty(){
        return size == 0;
    }
    public void display(){
        if (head == null){
            System.out.println("Stack is empty. Nothing to display.");
        } else {
            System.out.println("There are "  + size + " items in the stack. Displaying ...");
            Node current = head;
            while (current != null){
                System.out.println(current.element);
                current = current.next;
            }
        }
    }
    
    
    
}
