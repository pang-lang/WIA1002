/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Stack s = new Stack();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String input = sc.nextLine();
        
        char[] characters = input.toCharArray();
        for (char c : characters){
            s.push(c);
        }
        while (!s.isStackEmpty()){
            System.out.print(s.pop());
        }
    }
}
    

