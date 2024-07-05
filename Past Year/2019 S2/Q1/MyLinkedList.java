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
public class MyLinkedList <E extends Comparable <E>> {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public int getSize(){
        return size;
    }
    
    public void addFirst(E element){
        Node newNode = new Node(element);
        if (head == null){
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
        
    public void addLast(E element){
        Node newNode = new Node(element);
        if (tail == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public E removeFirst(){
        if (head == null){
            throw new NoSuchElementException(); 
        } else {
            E removed = (E) head.element;
            head = head.next;
            size--;
            return removed;
        }
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[size=" + size + "] >> ");
        Node current = head;
        while (current != null){
            str.append(current.element);
            current = current.next;
            
            if (current != null){
                str.append(" >> ");
            }
        }
        return str.toString();
    }
    
    
    public MyLinkedList <E> combine(MyLinkedList<E> l1, MyLinkedList<E> l2){
        Node current1 = l1.head;
        Node current2 = l2.head;
        MyLinkedList <E> newList = new MyLinkedList <E>();
        
        while (current1 != null && current2 != null){
            if (current1.element.compareTo(current2.element) < 0){
                newList.addLast((E) current1.element);
                current1 = current1.next;
            } else {
                newList.addLast((E) current2.element);
                current2 = current2.next;
            }
        }
        
        while (current1 != null){
            newList.addLast((E) current1.element);
            current1 = current1.next;
        } 
        while (current2 != null){
            newList.addLast((E) current2.element);
            current2 = current2.next;
        }
        return newList;
    }
}
