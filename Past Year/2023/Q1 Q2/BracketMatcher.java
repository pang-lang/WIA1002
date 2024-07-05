/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1Q2;

import Q1Q2.ExamStack;
import java.util.Scanner;

/**
 *
 * @author panglang
 */
public class BracketMatcher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expression to evaluate: ");
        String exp = sc.nextLine();
        System.out.println(evaluateExpression(exp));
    }

    private static double evaluateExpression(String expression) {
        char[] tokens = expression.toCharArray();

        ExamStack<Double> values = new ExamStack<>();
        ExamStack<Character> operators = new ExamStack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sb.append(tokens[i++]);
                values.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (tokens[i] == '(')
                operators.push(tokens[i]);
            else if (tokens[i] == ')') {
                while (operators.peek() != '(')
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                operators.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!operators.empty() && hasPrecedence(tokens[i], operators.peek()))
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                operators.push(tokens[i]);
            }
        }

        while (!operators.empty())
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));

        return values.pop();
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        return (op1 == '*' || op1 == '/') || (op2 == '+' || op2 == '-');
    }

    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new ArithmeticException("Division by zero");
                return a / b;
        }
        return 0;
    }
}

/*
5-3+4
2+4*5-(9+7*6)
9-2*(5/2-3/5+2)/6
*/
    
