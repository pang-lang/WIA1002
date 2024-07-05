/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

public class TOH {
    public static void main(String[] args) {
        TOH(3,'A','C','B');
    }
    
    public static void TOH(int n, char from, char to, char aux){
        if (n == 1){
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }
        TOH(n-1, from, aux, to);
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        TOH(n-1, aux, to, from);
    }
}
