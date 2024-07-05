package t8;


import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        PriorityQueue<String> pQueue = new PriorityQueue<String>();
        
        pQueue.offer("C++"); 
        pQueue.offer("Python"); 
        pQueue.offer("Java"); 
        pQueue.offer("Fortran");
        
        System.out.println("peek() gives us: "+ pQueue.peek());
        //a peek() gives us: C++
        
        System.out.println("The queue elements:"); 
        Iterator itr = pQueue.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());
        //b The queue elements: C++ Fortran Java Python 
        
        pQueue.poll();
        System.out.println("After poll():"); 
        Iterator<String> itr2 = pQueue.iterator(); 
        while (itr2.hasNext())
            System.out.println(itr2.next());
        //c After poll(): Fortran Python Java
        
        pQueue.remove("Java"); 
        System.out.println("After remove():"); 
        Iterator<String> itr3 = pQueue.iterator(); 
        while (itr3.hasNext())
            System.out.println(itr3.next());
        //d After remove(): Fortran Python
        
        boolean b = pQueue.contains("Ruby");
        System.out.println ( "Priority queue contains Ruby or not?: " + b);
        //e Priority queue contains Ruby or not?: false
        
        Object[] arr = pQueue.toArray();
        System.out.println ( "Value in array: "); 
        for (int i = 0; i<arr.length; i++)
            System.out.println ( "Value: " + arr[i].toString()) ; 
        //f Value in array: Value: Fortran Value: Python 
    }
}
