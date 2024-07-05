/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author panglang
 */
public class Tester {
    public static void main(String[] args) {
        MyLinkedList <Integer> list1 = new MyLinkedList<>();
        MyLinkedList <Integer> list2 = new MyLinkedList<>();
        MyLinkedList <Integer> newList = new MyLinkedList<>();
        
        list1.addFirst(2);
        list1.addLast(10);
        list1.addLast(38);
        list1.addLast(41);
        list1.addLast(51);
        System.out.println(list1.toString());
        
        list2.addFirst(5);
        list2.addLast(12);
        list2.addLast(18);
        list2.addLast(21);
        list2.addLast(35);
        list2.addLast(41);
        list2.addLast(56);
        System.out.println(list2.toString());
        
        
        System.out.println(newList.combine(list1, list2).toString());
    }
    
}
