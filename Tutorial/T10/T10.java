
package t10;

public class T10 {
    public static void main(String[] args) {
        System.out.println(reverseString("racecar"));
        System.out.println(reverseString("Hello World"));
        System.out.println(sum(5));
        System.out.println(s(4567));
    }
    
    //1. Explain the problem that occurs when executing the recursive method f(0).
    public static int f(int n) {
        if (n == 1) 
            return n;
        else
            return n * f(n-1);
    }
    /*
    When f(0) is called, the function will keep recursively calling itself with n-1 until n reaches 1, following the 
    logic of the function. But since there's no specific handling for n == 0, the recursion will continue indefinitely, 
    leading to what is known as a "stack overflow" error.
    To fix this issue, you could add a base case for n == 0 and decide what value the function should return in that case. 
    For example, you might choose to return 1 for n == 0, assuming that the factorial of 0 is defined as 1.
    */
    
    //2. Explain the problem that occurs when executing the recursive method f(). 
    public static int ff(int n){
        if (n == 0) 
            return n;
        else
            return f(n+1) + n;
    }
    /*
    When executing the recursive method f() without passing any arguments, it will result in an error. 
    This is because the function f(int n) expects an integer argument n, and calling f() without providing a value for n will 
    lead to a compilation error.
    */
    
    //3. Write a recursive method to reverse a string.
    public static String reverseString(String str){
        if (str == null || str.length() <= 1)
            return str;
        else {
            return reverseString(str.substring(1)) + str.charAt(0);
        } 
    }
    
    //4. Write a recursive method to calculate the following : 5 + 4 + 3 + 2 + 1.
    // State the base case and recursive case. Trace your solution using number, N of 5.
    public static int sum(int n){
        if (n == 1)
            return 1; //base case
        else 
            return n + sum(n-1);
    }
    /*
    sum(1) returns 1.
    sum(2) returns 2 + 1 = 3.
    sum(3) returns 3 + 3 = 6.
    sum(4) returns 4 + 6 = 10.
    sum(5) returns 5 + 10 = 15.
    */
            
    //5. Write a recursive method printDigit that prints an integer argument as its constituent digits, with a blank space 
    // separates each digit with the next. For example, if the argument is 4567, this method will print 4 5 6 7 on the screen.
    public static int s(int n){
        if (n < 10) {
            System.out.print(n + " "); // Print the last digit when n is a single digit
            return n;
        } else {
            int lastDigit = n % 10; // Extract the last digit
            s(n / 10); // Recursive call with the remaining digits
            System.out.print(lastDigit + " "); // Print the last digit
            return lastDigit;
        }
    }

}
