import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Q2 {

    public static void main(String[] args) {
        
        try {
            Scanner input = new Scanner(new FileInputStream("BracMatch.txt"));
            while (input.hasNext()) {
                String line = input.nextLine();
                System.out.println(matchBracket(line));
            }
            input.close();
        } catch (IOException e) {
            System.out.println("File not found exception.");
        }
    }
    
    public static String matchBracket(String input) {
        Stack<Character> stack = new Stack<>();
        char[] characters = input.toCharArray();
        boolean hasBracket = false;
        
        for (char c : characters) {
            if (isLeftBracket(c)) {
                stack.push(c);
                hasBracket = true;
            } else if (isRightBracket(c)) {
                hasBracket = true;
                if (stack.isEmpty()) {
                    return "Not all brackets are matched.";
                }
                if ((c == ']' && stack.peek() == '[') || 
                    (c == '}' && stack.peek() == '{') || 
                    (c == ')' && stack.peek() == '(') || 
                    (c == '>' && stack.peek() == '<')) {
                    stack.pop();
                } else {
                    return "Not all brackets are matched.";
                }
            } 
        }
        
        if (!stack.isEmpty()) {
            return "Not all brackets are matched.";
        }
        if (!hasBracket) {
            return "There is no bracket in the input.";
        }
        
        return "YES - all matched!";
    }
    
    public static boolean isLeftBracket(char c) {
        return c == '[' || c == '{' || c == '(' || c == '<';
    }
    
    public static boolean isRightBracket(char c) {
        return c == ']' || c == '}' || c == ')' || c == '>';
    }
}
