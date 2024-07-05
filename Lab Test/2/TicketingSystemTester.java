
package labtest2;

public class TicketingSystemTester {
    public static void main(String[] args) {
        EntranceGateStack stack = new EntranceGateStack();
        RideWaitingQueue queue = new RideWaitingQueue();
        
        System.out.println("Is gate empty: " + stack.isStackEmpty());
        System.out.println("Visitor arrival -----");
        stack.assignGate("A01");
        stack.assignGate("B02");
        stack.assignGate("C03");
        stack.assignGate("D04");
        stack.assignGate("E05");

        System.out.println("Stack: " + stack.toString());
        System.out.println("Is gate empty: " + stack.isStackEmpty()); 
        
        
        System.out.println("Top of the stack: " + stack.checkTopGate());
        
        System.out.println("Visitor departure -----");
        System.out.println(stack.releaseGate()); 
        System.out.println(stack.toString());
        
        System.out.println("Visitor waiting -----");
        queue.joinWaitingLine("EA011");
        queue.joinWaitingLine("EA012");
        queue.joinWaitingLine("EA013");
        queue.joinWaitingLine("EA014");
        queue.joinWaitingLine("EA015");
        queue.joinWaitingLine("EA016");
        queue.joinWaitingLine("EA017");
        queue.joinWaitingLine("EA018");
        queue.joinWaitingLine("EA019");
        queue.joinWaitingLine("EA020");
        System.out.println("Line is full: " + queue.isQueueFull());
        
        //queue is full
        queue.joinWaitingLine("EA021");
        System.out.println(queue.toString());
        
        queue.completeRide();
        queue.completeRide();
        System.out.println("Visitor dequeue -----");
        System.out.println(queue.toString());
    }
    
}
