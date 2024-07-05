/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author panglang
 */
public class Node <E extends Comparable <E>> {
    E element;
    Node next;
    
    public Node(E element){
        this.element = element;
    }
}
