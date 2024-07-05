
package Q4;

import java.util.ArrayList;

public class Palindrome <E> {
    private ArrayList <E> list = new ArrayList<>();

    public void push(E o){
        list.add(o);
    }
    
    public E pop(){
        return list.remove(list.size() - 1);
    }

    
    public E peek(){
        return list.getLast();
    }
    
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
