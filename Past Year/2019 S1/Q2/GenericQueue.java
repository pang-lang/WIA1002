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
public class GenericQueue <E> {
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
    private int maxSize;

    public GenericQueue(int size) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.maxSize = size;
    }
    
    public void enqueue(E element){
        Node newNode = new Node(element);
        if (!isFull()){
            if (tail == null){
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            System.out.println("Enqueue: " + newNode.element);
            size++;
        } else {
            System.out.println("Queue is full");
        }
    }
    
    public void enqueueMany(String s){
        String[] string = s.split(",");
        for (String e : string){
            enqueue((E) e.trim());
        }
    }
    
    public E peek(){
        if (head == null){
            throw new NoSuchElementException();
        } else {
            return head.element;
        }
    }

    public void dequeue(){
        if (head == null){
            throw new NoSuchElementException();
        } else {
            Node removed = head;
            head = head.next;
            size--;
            System.out.println("Dequeue: " + removed.element);
        }
    }
    
    public void dequeueAll(){
        System.out.println("There are " + size + " items in the queue. Removing them all ...");
        while (!isEmpty()){
            dequeue();
        }
    }
    
    public void display(){
        if (isEmpty()){
            System.out.println("Nothing to display");
        } else {
            System.out.println("There are " + this.size + " items in the queue. Displaying ...");
            Node current = head;
            while (current != null){
                System.out.println(current.element);
                current = current.next;
            }
        }
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size == maxSize;
    }
}
