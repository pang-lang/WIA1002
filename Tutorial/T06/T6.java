/*
1) Name four everyday examples of a queue other than those discussed during lecture.
   - Supermarket Checkout: Customers waiting in line to check out at a supermarket form a queue. 
     Each customer joins the end of the line (enqueue) and is served in the order they arrived (dequeue).
   - Ticket Counter: People waiting to purchase tickets at a movie theater or a train station typically form a queue. 
     Each person waits in line until it's their turn to buy tickets.
   - Customer Support Hotline: When calling customer support, callers are placed in a queue until an agent becomes available to assist them. 
     The calls are handled in a first-come, first-served manner.
   - Traffic Intersection: Vehicles waiting at a traffic light intersection form a queue. 
     Cars line up behind each other and move forward when the light changes, following the first-in-first-out (FIFO) principle.

2) What is the difference between a queue and stack?
   - Stack follows a Last In, First Out (LIFO) arrangement, meaning the last entered data is processed first, where removal and insertion occur at the same end.. 
     Queue follows a First In, First Out (FIFO) arrangement, meaning the first entered data is processed first, but removal and insertion happen at different ends.
   - Stack uses a single pointer, the top, to keep track of the most recently added element.
     Queue uses two pointers, the front and the rear, to keep track of the first and last inserted elements respectively.
   - Stack uses push and pop operations for insertion and deletion respectively.
     Queue uses enqueue and dequeue operations for insertion and deletion respectively.

3) Use the following code segment to answer parts (a) through (c):
        Queue<Integer> q = new Queue<Integer>(); 
        Scanner keyIn = new Scanner(System.in); 
        for (int i = 1; i <= 5; i++){
            if (keyIn.nextBoolean())
                System.out.print(i + " ");
            else
                q.enqueue(i);
            } 
        }
        while (!q.isEmpty())
           System.out.print(q.dequeue() + " ");
        System.out.println();

    (a) What is the output for the following input sequence?
            true  false  false  true  true
        1 4 5 2 3

    (b) Is it possible to have output: 1 3 5 4 2? 
        If yes, give an input sequence that produces the output; or else, provide justification to your answer.
        No, it's not possible to have the output "1 3 5 4 2" with the given code.
        The loop runs from 1 to 5, inclusive. If keyIn.nextBoolean() returns true, it prints the current number (i) and moves to the next iteration. 
        If it returns false, it enqueues the current number (i) into the queue.
        However, the output "1 3 5 4 2" implies that odd numbers are printed first, followed by the even numbers in reverse order. 
        This isn't possible with the given code because it doesn't have logic to manipulate the order of output based on the input.

    (c) Give at least three input sequences that produce the output: 1 2 3 4 5
        true true true true true
        true true true true false
        true true true false false
        true false true false true
        false false false false false true true true true true

4) Hand trace a queue X through the following operations:
          X.enqueue(new Integer(14));
          X.enqueue(new Integer(3));
          X.enqueue(new Integer(5));

                X contains [14, 3, 5].

          Object Y = X.dequeue();
          X.enqueue(new Integer(7));
          X.enqueue(new Integer(9));

                X contains [3, 5, 7, 9].

          Y = X.dequeue();
          X.enqueue(new Integer(2));
          X.enqueue(new Integer(4));

                X contains [5, 7, 9, 2, 4].

    Given the resulting queue X above, what would be the result of each of the following?
    a) X.front();
        5
    b) Y = X.dequeue(); X.enqueue(new Integer(10)); X.front();
        7, 9, 2, 4, 10
        7
    c) Y = X.dequeue();
        7
    d) X.front();
        9

5) Provide and explain three operations / functions of Linked List based Queue that you can add to the GenericQueue class, 
   other than those discussed in the lecture (i.e., enqueue, dequeue and getSize – from Slide 10 in the lecture slide).

    -   peek():
        This function retrieves, but does not remove, the element at the front of the queue.
        It can be helpful when you want to examine the element at the front without actually dequeuing it.
        The implementation would simply return the value of the first node in the linked list.
    -   isEmpty():
        This function checks if the queue is empty or not.
        It returns true if the queue contains no elements, and false otherwise.
        Implementation involves checking if the head of the linked list is null.
    -   clear():
        This function removes all elements from the queue, leaving it empty.
        It can be useful when you want to reset the queue or free up memory.
        Implementation involves setting the head and tail pointers to null, effectively unlinking all nodes in the linked list.

*/


    