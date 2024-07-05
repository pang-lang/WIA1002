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
        Node next;
        E element;

        public Node(E element) {
            this.element = element;
        }
    }
    
    Node head;
    Node tail;
    int size;
    int capacity;

    public GenericQueue(int capacity) {
        this.size = 0;
        this.capacity = capacity;
    }
    
    public boolean isFull(){
        return size == capacity;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public E peep(){
        if (tail == null){
            throw new NoSuchElementException();
        } else {
            return tail.element;
        }
    }
    
    public void enqueue(E e){
        Node newNode = new Node(e);
        if (head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Enqueue: " + e);
        size++;
    }
    
    public void enqueueMany(String s){
        String[] arr = s.split(",");
        for (int i=0; i<arr.length; i++){
            enqueue((E) arr[i]);
        }
    }
    
    public void dequeue(){
        if (head == null){
            throw new NoSuchElementException();
        } else {
            E removed = head.element;
            head = head.next;
            size--;
            System.out.println("Dequeue: " + removed);
        }
    }
    
    public void dequeueAll(){
        System.out.println("There are " + size + " items in the queue. Removing them all...");
        Node current = head;
        while (!isEmpty()){
            dequeue();
        }
    }
    
    public void changeOrder(int k){
        System.out.println("Change queue order...\n");
        for (int i=0; i<k-1; i++){
            E removed = head.element;
            head = head.next;
            size--;
            enqueue(removed);
        }
    }
    public void display(){
        if (isEmpty()){
            System.out.println("\nNothing to display.");
        } else {
            System.out.println("\nThere are " + size + " items in the queue. Displaying ...");
            StringBuilder str = new StringBuilder();
            Node current = head;
            while (current != null){
                str.append(current.element + " | ");
                current = current.next;
            }
            System.out.println(str.toString());
            System.out.println("");
        }
    }
}
