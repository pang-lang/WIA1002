/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

import java.util.NoSuchElementException;

/**
 *
 * @author panglang
 */
public class Queue {
    class Node {
        String element;
        Node next;
        
        public Node(String element) {
            this.element = element;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;

    public Queue(int size){
        this.size = 0;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void peek(){
        if (head == null){
            throw new NoSuchElementException("Element does not exist");
        } else {
            System.out.println("Peek(): " + head.element);
        }
    }
    
    public void enqueue(String s){
        Node newNode = new Node(s);
        if (head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        System.out.println("Data " + s + " inserted");
        size++;
    }
    
    public void dequeue(){
        if (head == null){
            throw new NoSuchElementException("Element does not exist.");
        } else {
            String removed = head.element;
            head = head.next;
            if (head == null){
                tail = null;
            }
            System.out.println("Data " + removed + " has been removed");
        }
        size--;
    }
    
    public void display(){
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        Node current = head;
        
        System.out.println("-".repeat(50));
        str1.append("|");
        for (int i=0; i<size; i++){
            str1.append(" " + i + " |");
        }
        System.out.println(str1.toString());
        System.out.println("-".repeat(50));
        str2.append("|");
        while (current != null){
            str2.append(" " + current.element + " |");
            current = current.next;
        }
        System.out.println(str2.toString());
        System.out.println("-".repeat(50));
    }
    
    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.enqueue("hello");
        q.enqueue("all");
        q.enqueue("who");
        q.enqueue("wants");
        q.enqueue("ice cream");
        q.dequeue();
        q.dequeue();
        q.enqueue("1000");
        q.enqueue("2000");
        q.peek();
        
        q.display();
        
    }
}
