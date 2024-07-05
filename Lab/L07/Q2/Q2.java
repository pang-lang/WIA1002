
package Q2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
        
public class Q2 {

    public static void main(String[] args) {
        //Write a Java program that uses a Queue to determine if the input string is a palindrome or not.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        System.out.println(s + " is Palindrome: " + isPalindrome(s));
    }
    
    public static boolean isPalindrome(String s){
        Queue <Character> q = new LinkedList<>();
        String p = "";
        for (int i=0; i<s.length(); i++){
            q.add(s.charAt(i));
        }
        while (!q.isEmpty()){
            p += q.remove();
        }
        
        return p.equalsIgnoreCase(s);
    }
}
    
