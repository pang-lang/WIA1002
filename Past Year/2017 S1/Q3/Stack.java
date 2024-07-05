/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

import java.util.NoSuchElementException;
// If use node for stack, the element to be removed is head for O(1);
public class Stack {
    class Node {
        char element;
        Node next;
        
        public Node(char element) {
            this.element = element;
        }
    }
    
    Node head;
    Node tail;
    int size;
    
    public void push(char c){
        Node newNode = new Node(c);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public char pop(){
        if (head == null){
            throw new NoSuchElementException("Stack is empty.");
        } else {
            char element = head.element;
            head = head.next;
            size--;
            return element;
        }
    }
    
    public char peek(){
        if (head == null){
            throw new NoSuchElementException("Stack is empty.");
        } else {
            return head.element;
        }
    }
    
    public boolean isStackEmpty(){
        return size == 0;
    } 
}
