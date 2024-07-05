/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q1;

/**
 *
 * @author panglang
 */
public class Tester {
    public static void main(String[] args) {
        // a. Have an initialize queue items consists of Durian and Blueberry in a fruitQ
        String[] fruitQ = {"Durian","Blueberry"};
        MyQueue <String> q = new MyQueue<>(fruitQ);
        // b. Then add new items in the following order: Apple, Orange, Grapes, Cherry.
        q.enqueue("Apple");
        q.enqueue("Orange");
        q.enqueue("Grapes");
        q.enqueue("Cherry");
        // c. Display the queue.
        System.out.println(q.toString());
        // d. Show the top item.
        System.out.println("Top item: " + q.peek());
        //e. Get the queue size.
        System.out.println("Queue size: " + q.getSize());
        //f. Delete Durian.
        q.dequeue();
        System.out.println("Deleted durian from the queue: " + q.toString());
        //g. Get item in index position of 2
        System.out.println("Item index 2: " + q.getElement(2));
        //h. Check whether the queue consists of Cherry
        System.out.println("Queue contains Cherry: " + q.contains("Cherry"));
        //i. Check whether the queue consists of Durian
        System.out.println("Queue contains Durian: " + q.contains("Durian"));
        //j. Display the queue using the isEmpty() condition.
        while (!q.isEmpty()){
            System.out.print(q.dequeue() + " ");
        }
        
        
        
        
        
    }
    
}
