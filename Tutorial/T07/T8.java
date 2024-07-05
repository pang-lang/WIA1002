/*
1. Describe the main difference between Queue and PriorityQueue. 
    - There is no priority attached to elements in a queue, the rule of first-in-first-out(FIFO) is implemented whereas, 
    in a priority queue, the elements have a priority. The elements with higher priority are served first.
    - Queue is a linear data structure.	Priority Queue is an extension of Queue with priority factor embedded.
    - Queue's Enqueue and dequeue done in O(1).	Priority Queue's Enqueue and dequeue done in O(log n) using binary heaps.
    - Queue is used in algorithms such as Breadth First Search.	Priority queue's is used in algorithms such as Dijkstra’s Algorithm, 
    Prim’s Algorithms, CPU Scheduling.     

2. Briefly provide THREE (3) real-life example in using PriorityQueue.
    - Operating systems scheduling processes based on their priority levels.
    - Airport security check-in queues where first-class passengers have higher priority.
    - Emergency room triage in hospitals, where patients with more critical conditions are treated first.
    - Print spooling in computer systems, where documents with higher priority are printed first.
    - Traffic management systems that prioritize emergency vehicles during rush hour.

*/

