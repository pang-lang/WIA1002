/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

import java.util.ArrayList;

/**
 *
 * @author panglang
 */
public class Queue <E> {
    private ArrayList <E> queue;

    public Queue() {
        queue = new ArrayList<>();
    }
    
    public Queue(E[] items) {
        queue = new ArrayList<>();
        for (E i : items){
           enqueue(i);
       }
    }
    
    public void enqueue(E e){
        queue.addLast(e);
    }
    
    public E dequeue(){
        if (queue.isEmpty())
            return null;
        E removed = queue.getFirst();
        queue.removeFirst();
        return removed;
    }
    
    public E getElement(int i){
        if (i<0 || i > getSize())
            return null;
        return queue.get(i);
    }
    
    public int getSize(){
        return queue.size();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    public String toString(){
        return queue.toString();
    }
}
