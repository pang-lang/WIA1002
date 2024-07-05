/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author panglang
 */
public interface StackInterface <E> {
    
    public int size();
    
    public E peek();
    
    public E pop();
    
    public void push(E o);
    
    public boolean isEmpty();
    
    
}
