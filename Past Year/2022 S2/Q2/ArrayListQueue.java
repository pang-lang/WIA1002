/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q2;
import java.util.ArrayList ; 

public class ArrayListQueue<E> { 
    private int size=10;
    private int front=0; //head
    private int end =0;  //tail
    private ArrayList<E> list= new ArrayList<E>(size);
    
    public boolean enqueue (E o) { 
        boolean success = false; 
        if (end < size) { 
            success=list.add(o);
            end++;
        }
        return success; 
    }

    public E dequeue () { 
        if (front == size){
            return null;
        } else {
            E removed = list.get(front);
            front++;
            return removed;
        }
    }
    
    public String queueToString() { 
        StringBuilder str = new StringBuilder();
        for (int i=front; i<end; i++){
            str.append(list.get(i)).append(" ");
        }
        return str.toString();
    }

    public String allToString() { 
        return " ALL : " + list.toString();
    }
    
    public static void main(String[] args) {
        ArrayListQueue<String> queue1 = new ArrayListQueue<>();
        queue1.enqueue("Switch");
        queue1.enqueue("Motherboard");
        queue1.enqueue("RAM");
        queue1.enqueue("SSD");
        queue1.enqueue("CPU");
        queue1.enqueue("GPU");
        queue1.enqueue("Router");

        System.out.println("Queue 1: " + queue1.queueToString());
        System.out.println("Dequeue: " + queue1.dequeue());
        System.out.println("Queue 1 after dequeue: " + queue1.queueToString());
        System.out.println(queue1.allToString());

        ArrayListQueue<Integer> queue2 = new ArrayListQueue<>();
        queue2.enqueue(17);
        queue2.enqueue(21);
        queue2.enqueue(45);
        queue2.enqueue(23);
        queue2.enqueue(1);
        queue2.enqueue(99);
        queue2.enqueue(16);

        System.out.println("\nQueue 2: " + queue2.queueToString());
        System.out.println("Dequeue: " + queue2.dequeue());
        System.out.println("Queue 2 after dequeue: " + queue2.queueToString());
        System.out.println(queue2.allToString());
    }
}
