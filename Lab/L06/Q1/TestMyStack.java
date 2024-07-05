
package Q1;

import java.util.ArrayList;

public class TestMyStack {
    public static void main(String[] args) {
        System.out.println("Character Stack");
        MyStack <Character> c = new MyStack<>();
        //1) Following the given order, add elements, a b and c in the stack. 
        c.push('a');
        c.push('b');
        c.push('c');

        //2) Print the stack.
        System.out.println(c.toString());
        
        //3) Check if element ‘b’ is in the stack.
        System.out.println("b is in the stack: " + c.search('b'));
        
        //4) Check if element ‘k’ is in the stack.
        System.out.println("k is in the stack: " + c.search('k'));
        
        
        System.out.println("\nInteger Stack");
        MyStack <Integer> i = new MyStack<>();
        //1) Following the given order, add elements, 1 2 and 3 in the stack.
        i.push(1);
        i.push(2);
        i.push(3);
        
        //2) Print the stack.
        System.out.println(i.toString());
        
        //3) Check if element ‘6’ is in the stack.
        System.out.println("6 is in the stack: " + i.search(6));

    }
    
}
