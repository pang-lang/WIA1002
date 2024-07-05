/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

import java.util.ArrayList;

public class Queue <Item> {
    private ArrayList <Item> list;

    public Queue() {
        this.list = new ArrayList<>();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public int size(){
        return list.size();
    }
    
    public Item peek(){
        return list.getFirst();
    }
    
    public void enqueue(Item o){
        list.add(o);
    }
    
    public Item dequeue(){
        Item removed = list.getFirst();
        list.removeFirst();
        return removed;
    }
    
    public String toString(){
        return list.toString();
    }
    
    public void ChangeOrder(int k){
        for (int i=0; i<k-1; i++){
            Item element = dequeue();
            enqueue(element);
        }
    }
    
    
}
