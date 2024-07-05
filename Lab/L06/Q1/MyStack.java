
package Q1;

import java.util.ArrayList;

public class MyStack <E> {
    private ArrayList <E> list = new ArrayList<>();

    public void push(E o){
        list.add(o);
    }
    
    public E pop(){
        E o = list.getLast();
        list.remove(o);
        return o;
    }
    
    //[size-1]
    public E peek(){
        return list.getLast();
    }
    
    //size == array.length
    public int getSize(){
        return list.size();
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public String toString(){
        return "stack: " + list.toString();
    }
    
    public boolean search(E o){
        return list.contains(o);
    }
}
