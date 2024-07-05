/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Q1Q2;

import java.util.LinkedList;

/**
 *
 * @author panglang
 */
public class ExamStack <E> {
    private LinkedList <E> stack;

    public ExamStack() {
        this.stack = new LinkedList<>();
    }
    
    public E peek(){
        if (stack.isEmpty())
            throw new IllegalStateException("Stack is empty");
        return stack.peek();
    }
    
    public E pop(){
        if (stack.isEmpty())
            throw new IllegalStateException("Stack is empty");
        E removed = stack.pop();
        return removed;
    }
    
    public void push(E e){
        stack.push(e);
    }
    
    public int getSize(){
        return stack.size();
    }
    
    public boolean empty(){
        return stack.isEmpty();
    }
    
    public String toString(){
        return stack.toString();
    }
    
}