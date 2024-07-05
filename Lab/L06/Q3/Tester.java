
package Q3;

import java.util.Stack;

public class Tester {
    public static void main(String[] args) {
        Stack <Integer> s = new Stack<>();
        int randNum;
        for (int i=0; i<10; i++){
            randNum = (int)(Math.random()*100);
            System.out.print(randNum + " ");
            s.push(randNum);
        }
        System.out.println("\nSum of these numbers: " + findSum(s));
    }
    
    public static int findSum(Stack <Integer> s){
        int sum = 0;
        
        while (!s.isEmpty()) {
            sum += s.pop();
        }
        
        return sum;
    }
    
}
