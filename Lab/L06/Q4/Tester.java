
package Q4;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
         if (s.length() > 15){
                System.out.println("Stack is full.");
        } else {
            isPalindrome(s);
            System.out.println("String " + s + " is palindrome: " + isPalindrome(s));
        }
    }
    
    public static boolean isPalindrome(String str){
        // Convert the input string to a list of characters
        Palindrome <Character> stack = new Palindrome<>();
        
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        
        String reversed = "";
        while (!stack.isEmpty() && stack.getSize() < 15){
            reversed += stack.pop();
        }

        return str.equalsIgnoreCase(reversed);
    }
}
