


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1 {
    public static void main(String[] args) {
        int[] arr = {4, 8, 1, 2, 9, 6, 3, 7};
        PriorityQueue <Integer> pq = new PriorityQueue <>();
        
        for (int e : arr){
            pq.add(e);
        }
        
        System.out.println(pq.toString());
        
        System.out.println("\nPoll: " + pq.poll());
        System.out.println(pq.toString());
        
        pq.add(5);
        System.out.println("\nAdded 5 --- ");
        System.out.println(pq.toString());
        
        Integer[] a = pq.toArray(new Integer[pq.size()]);
        System.out.println(Arrays.toString(a));
        
        System.out.println("\nPeek --- " + pq.peek());
        System.out.println(pq.toString());
        
        System.out.println("\nArray contains number 1: " + pq.contains(1));
        
        System.out.println("\nSize of current array: " + pq.size());
        
        while (!pq.isEmpty()){
            System.out.println(pq.toString());
            pq.remove();
        }
        
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for (int e : arr){
            pQueue.add(e);
        }
        
        System.out.println("\nIn reverse order ---");
        System.out.println(pQueue.toString());
    }
}
    
    