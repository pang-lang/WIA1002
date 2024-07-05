/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

import Q2.GenericStack;
import java.util.Scanner;

/**
 *
 * @author panglang
 */
public class TestPileStack {
    public static void main(String[] args) {
        GenericStack <String> stack = new GenericStack<>();
        System.out.println("Create a new stack: an empty pile of books");
        System.out.println("is Empty returns " + stack.isEmpty());
        
        System.out.println("\nPush 3 books to the pile: ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title 1: ");
        String bt1 = sc.nextLine();
        stack.push(bt1);
        System.out.print("Enter book title 2: ");
        String bt2 = sc.nextLine();
        stack.push(bt2);
        System.out.print("Enter book title 3: ");
        String bt3 = sc.nextLine();
        stack.push(bt3);
        
        System.out.println("\nThe new books that you added are: " + stack.toString());
        System.out.println("\nThe pile should not be empty: ");
        System.out.println("isEmpty() returns " + stack.isEmpty());
        System.out.println("The pile has " + stack.size() + " books.");
        
        System.out.println("Get the top book and remove the top book: ");
        System.out.println("\n" + stack.peek() + " is at the top of the pile.");
        System.out.println(stack.pop() + " is removed from the pile.");
        
        System.out.println("\n" + stack.peek() + " is at the top of the pile.");
        System.out.println(stack.pop() + " is removed from the pile.");
        
        System.out.println("\n" + stack.peek() + " is at the top of the pile.");
        System.out.println(stack.pop() + " is removed from the pile.");
        
        System.out.println("The pile should be empty: ");
        System.out.println("isEmpty() returns" + stack.isEmpty());
    }
}
