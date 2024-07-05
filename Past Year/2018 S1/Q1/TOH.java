/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author panglang
 */
public class TOH {
    public static void main(String[] args) {
        TOH(2,'1','3','2');
    }
    
    public static void TOH(int n, char from, char to, char aux){
        if (n==0){
            return;
        }
        TOH(n-1,from, aux, to);
        
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);
        
        TOH(n-1,aux,to,from);
    }
}
