/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labtest2;

public class RideWaitingQueue {
    private final int maxSize;
    private final String[] queueArray;
    private int head;
    private int tail;
    private int size;
    
    public RideWaitingQueue() {
        this.maxSize = 10;
        this.queueArray = new String[maxSize];
        this.head = 0;
        this.tail = -1;
        this.size = 0;
    }
    
    //enqueue
    public void joinWaitingLine(String ticketNumber){
        // queue is full
        if (isQueueFull())
            System.out.println("Queue is full.");
        
        // queue is empty
        if (tail == maxSize-1)
            tail = -1;
        
        queueArray[++tail] = ticketNumber;
        size++;
    }
    
    //dequeue
    public String completeRide(){
        if (isQueueEmpty())
            return "Queue is empty.";
        
        String removed = queueArray[0];
        for (int i=0; i<queueArray.length-1; i++){
            queueArray[i] = queueArray[i+1];
        } 
        size--;
        return removed;
    }

    public String viewNextTicketNumber(){
        if (isQueueEmpty())
            return "Queue is empty.";
        
        return queueArray[0];
    }
    
    public boolean isQueueEmpty(){
        return size == 0;
    }
    
    public boolean isQueueFull(){
        return size == maxSize;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i=0; i<queueArray.length; i++){
            if (queueArray[i] != null)
                str.append(queueArray[i] + " ");
        }
        return str.toString();
    }
}



/*
public String completeRide() {
    if (isQueueEmpty())
        return "Queue is empty.";

    String removed = queueArray[front];
    front = (front + 1) % maxSize; // Move front to the next position
    size--;

    return removed;
}
*/