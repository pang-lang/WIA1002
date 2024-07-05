/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

import java.util.Stack;

/**
 *
 * @author panglang
 */
public class Q2 {
    public static void main(String[] args) {
        Stack <String> str = new Stack<>();
        String[] s = {"Switch","Motherboard","RAM","SSD", "CPU","GPU","Router"};
        for (int i=0; i<s.length; i++){
            str.add(s[i]);
        }
        System.out.println(str.toString());
        reverse(str);
        System.out.println(str.toString());
        Stack <Integer> i = new Stack<>();
        Integer[] num = {17, 21, 45, 23, 1, 99, 16};
        for (int j=0; j<num.length; j++){
            i.add(num[j]);
        }

        System.out.println(i.toString());
        reverse(i);
        System.out.println(i.toString());
    }
    
    public static <T> void reverse(Stack<T> s){
        if (!s.isEmpty()){
            T top = s.pop();
            reverse(s);
            insert(s,top);
        }
    }
    
    private static <T> void insert(Stack<T> s, T e){
        if(s.isEmpty()){
            s.push(e);
        } else {
            T top = s.pop();
            insert(s,e);
            s.push(top);
        }
    }
}
