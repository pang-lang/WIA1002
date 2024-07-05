
import java.util.ArrayList;

public class Queue <Item> {
    private ArrayList <Item> list = new ArrayList<>();
    private int size = 0;

    public Queue() {
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public int size(){
        return list.size();
    }
    
    public Item peek(){
        if (list.isEmpty())
            return null;
        return list.getFirst();
    }
    
    public void enqueue(Item e){
        list.addLast(e);
    }
    
    public Item dequeue(){
        Item e = list.removeFirst();
        return e;
    }
    
    public String toString(){
        return list.toString();
    }
    
    public void changeOrder(int k){
        for (int i=1; i<k; i++){
            Item e = dequeue();
            enqueue(e);
        }
    }
    
    public static void main(String[] args) {

        Queue <Integer> q = new Queue<>();
        int[] arr = {10,20,30,40,50,60,70,80,90};
        for (int a : arr){
            q.enqueue(a);
        }
        System.out.println(q.toString());
        q.changeOrder(4);
        System.out.println(q.toString());
    }
}
    
    

