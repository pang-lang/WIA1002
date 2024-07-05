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
        GenericStack <String> stack1 = new GenericStack <String>(5);
        stack1.push("one");
        stack1.display();
        stack1.pushMany("two, three four, five, six seven");
        stack1.display();
        stack1.pop();
        stack1.pop();
        stack1.display() ;
        System.out.println("------------------------------");
        GenericStack <Integer> stack2 = new GenericStack <Integer>(5) ;
        stack2.push(1); 
        stack2.push(2);
        stack2.pushMany("3 4,5, 6 7"); 
        stack2.display(); 
        stack2.popAll();
        stack2.display();
    }
}
