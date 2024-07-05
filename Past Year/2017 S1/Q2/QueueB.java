/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author panglang
 */
public class QueueB <Item> {
    class Node {
        Item element;
        Node next;
        
        public Node(Item element) {
            this.element = element;
        }
        
        public String toString(){
            return element.toString();
        }
    }
    
    Node head;
    Node tail;
    int size;
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int size(){
        return size;
    }
    
    public Item peek(){
        if (head == null)
            return null;
        return head.element;
    }
    
    public void enqueue(Item o){
        Node newNode = new Node(o);
        if (size == 0){
            head = tail = newNode;
        } else { 
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    
    public Item dequeue(){
        if (size == 0)
            return null;
        Node removed = head;
        head = head.next;
        size--;
        if (size == 0){
            tail = null;
        }
        return removed.element;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node current = head;
        while (current != null){
            str.append(current);
            current = current.next;
            
            if (current != null)
                str.append(", ");
            else 
                str.append("]");
        }
        return str.toString();    
    }
    
    public void ChangeOrder(int k){
        for (int i=0; i<k-1; i++){
            Item element = dequeue();
            enqueue(element);
        }
    }
}


