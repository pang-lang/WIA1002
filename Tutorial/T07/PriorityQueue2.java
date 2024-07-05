/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t8;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author panglang
 */
public class PriorityQueue2 {
    public static void main(String... args ){
        PriorityQueueComparator pqc = new PriorityQueueComparator(); 
        PriorityQueue<String> pq=new PriorityQueue<String>(5,pqc); 
        pq.add("Jason");
        pq.add("Ali");
        pq.add("Muhamad"); 
        for(String s : pq){
            System.out.println(s); 
        }
    }

    public static class PriorityQueueComparator implements Comparator<String>{ 
        public int compare(String s1, String s2) {
            if (s1.length() < s2.length()) {
                return -1; 
            }
            if (s1.length() > s2.length()) {
                return 1; 
            }
        return 0; 
        }
    }
}
/*
a) What is the purpose of the PriorityQueueComparator in the code? 
     to determine when one item of a given data type should come before another item of the same data type.
b) What is the output for the code?
    Ali
    Jason
    Muhamad
*/