
package Q4;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] alphabets = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", 
            "u", "v", "w", "x", "y", "z"
        };
        
        Queue<String> q1 = new Queue<>(alphabets);
        System.out.println("Queue: " + q1.toString());
        Queue<Integer> q2 = new Queue<>();
        for (int i=0; i<27; i++){
            q2.enqueue(i);
        }
        System.out.println("Index: " + q2.toString());
        
        System.out.println("\nHow many times will you enter a number: ");
        System.out.println("(Please enter your number(s) between 0-26.)");
        int freq = sc.nextInt();
        int count = 0;
        Queue <Integer> q = new Queue<>();
        while (count < freq){
            if (count == freq)
                break;
            
            System.out.print("Enter number " + (count+1) + " >> ");
            int no = sc.nextInt();
            q.enqueue(no);
            count++;
        }
        
        System.out.println("The entered numbers are " + q.toString());
        if (count==0){
            System.out.println("The deciphered values are -Cannot decipher. No value was entered.");    
        } else {
            System.out.print("The deciphered values are " );
            while (!q.isEmpty()){
                int indexs = q.dequeue();
                System.out.print(alphabets[indexs]);
            } 
            System.out.println("");
        }
        
    }
    
}
