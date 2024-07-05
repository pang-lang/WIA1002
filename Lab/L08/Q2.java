
import java.util.PriorityQueue;


public class Q2 {
    
    public static void main(String[] args) {
        
        String[] a1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
        PriorityQueue <String> pq1 = new PriorityQueue <String> ();
        for (String e : a1){
            pq1.add(e);
        }
        System.out.println("Queue 1: " + pq1.toString());
        
        String[] a2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};
        PriorityQueue <String> pq2 = new PriorityQueue <String> ();
        for (String e : a2){
            pq2.add(e);
        }
        System.out.println("Queue 2: " + pq2.toString());
        
        System.out.println("\nUnion of both priority queue");
        PriorityQueue <String> u = new PriorityQueue <String> (pq1);
        u.addAll(pq2);
        System.out.println(u.toString());
        //union(pq1,pq2);
        
        System.out.println("\nDifference between priority queue 1 and 2");
        PriorityQueue <String> d1 = new PriorityQueue <String> (pq1);
        d1.removeAll(pq2);
        System.out.println(d1.toString());
        //diff(pq1,pq2);
        
        System.out.println("\nDifference between priority queue 2 and 1");
        PriorityQueue <String> d2 = new PriorityQueue <String> (pq2);
        d2.removeAll(pq1);
        System.out.println(d2.toString());
        //diff(pq2,pq1);
        
        System.out.println("\nIntersection between priority queue 1 and 2");
        PriorityQueue <String> i = new PriorityQueue <String> (pq1);
        i.retainAll(pq2);
        System.out.println(i.toString());
    }
    
    public static void union(PriorityQueue <String> q1, PriorityQueue <String> q2){
        PriorityQueue <String> q = new PriorityQueue <String> ();
        for (String e : q1){
            q.add(e);
        }
        for (String e : q2){
            q.add(e);
        }
        System.out.println(q.toString());
    } 
    
    public static void diff(PriorityQueue <String> q1, PriorityQueue <String> q2){
        for (String e : q2){
            if (q1.contains(e))
                q1.remove();
        }
        System.out.println(q1.toString());
    }
    
    public static void intersection(PriorityQueue <String> q1, PriorityQueue <String> q2){
        PriorityQueue <String> q = new PriorityQueue <String> ();
        for (String e : q1){
            if (q2.contains(e))
                q.add(e);
        }
        System.out.println(q.toString());
    }
}
