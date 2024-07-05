/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;

/**
 *
 * @author panglang
 */
public class Tester {
    public static void main(String[] args) {
        QueueB <Integer> q = new QueueB<>();
        int[] arr = {10,20,30,40,50,60,70,80,90};
        for (Integer a : arr){
            q.enqueue(a);
        }
        System.out.println(q.toString());
        q.ChangeOrder(4);
        System.out.println(q.toString());
    }
    
}
