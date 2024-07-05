/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

import java.util.ArrayList;

/**
 *
 * @author panglang
 */
public class GenericStack <E> implements StackInterface <E>{
    private ArrayList <E> list = new ArrayList <>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public E peek(){
        if (isEmpty())
            return null;
        return list.getLast();
    }

    @Override
    public E pop() {
        if (isEmpty())
            return null;
        E removed = list.getLast();
        list.removeLast();
        return removed;
    }

    @Override
    public void push(E o){
        list.add(o);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public String toString(){
        if (isEmpty())
            return " ";
        return list.toString();
    }
}
