
package Q1;

import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        MyStack <Integer> numList = new MyStack <> ();
        
        //a) Prompt user to enter an integer value.
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = sc.nextInt();
        
        //b) Push the values 1 through the user entered value onto the stack.
        for (int i=1; i<=num; i++){
            numList.push(i);
        }
        
        //c) Print the size of the stack.
        System.out.println("Size of the stack: " + numList.getSize());
        
        //d) Display the contents of the stack by repeatedly calling pop() until the stack is empty.
        while (!numList.isEmpty()){
            System.out.print(numList.pop() + " ");
        }
    }
    
}
