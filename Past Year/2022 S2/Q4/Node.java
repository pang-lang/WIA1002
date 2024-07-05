/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author panglang
 */
public class Node <E> {
    E element;
    Node<E> next;
    
    public Node(E element) {
        this.element = element;
    }
    
    public String toString(){
        return element.toString();
    }
}
