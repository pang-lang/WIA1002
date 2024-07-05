/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author panglang
 */
public class SpecialLL<E> {
    Node<E> head, tail;
    int size = 0;
 
    public SpecialLL() {} 

    public int getSize() {
        return size;
    }
    
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); 
        newNode.next = head; 
        head = newNode; 
        size++; 
        if (tail == null) 
            tail = head;
    }
    
    public void addLast(E e) {
        Node<E> newNode = new Node<E>(e); 
        if (tail == null) {
            head = tail = newNode; 
        }
        else {
            tail.next = newNode; 
            tail = tail.next; 
        }
        size++; 
    }
    
    
    public void printOdd(){
        Node current = head;
        while (current != null){
            System.out.print(current.element + " ");
            if (current.next != null){
                current = current.next.next;
            } else {
                break;
            }
        }
    }
    
    public ArrayList<E> getEven(){
        ArrayList <E> list = new ArrayList<>();
        Node current = head;
        while (current != null){
            if (current.next != null){
                list.add((E) current.next.element);
                if (current.next.next != null){
                    current = current.next.next;
                } else {
                    break;
                }
            } else {
                break;
            }     
        }
        Collections.reverse(list);
        return list;
    }
    
    
    public void print() {
        Node<E> current = head;
        for(int i=0; i<size; i++) {
            System.out.print(current.element + " "); 
            current=current.next;
        }
        System.out.println();
    }
}
    
  