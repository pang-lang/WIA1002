package Q3;

import java.util.NoSuchElementException;

public class Stack<E> {
    class Node {
        E row;
        E column;
        Node next;

        public Node(E row, E column) {
            this.row = row;
            this.column = column;
        }
    }

    Node head;
    int size;

    public Stack() {
        this.head = null;
        this.size = 0;
    }

    public void push(E row, E column) {
        Node newNode = new Node(row, column);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public String pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        E removedR = head.row;
        E removedC = head.column;
        head = head.next;
        size--;
        return "(" + removedR + "," + removedC + ")";
    }

    public String peek() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return "(" + head.row + "," + head.column + ")";
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        if (head == null) {
            return "Oh no!!! Harry couldn't find the Triwizard Cup! \nSomeone quickly gets Professor Dumbledore.";
        } else {
            StringBuilder str = new StringBuilder();
            str.append("Hurray!!! Harry found the Triwizard Cup at ").append(peek())
                    .append("\nThis is the path that Harry has taken: ");
            
            Stack <E> temp = new Stack <>();
            Node current = head;
            while (current != null){
                temp.push(current.row,current.column);
                current = current.next;
            }
            
            
            while (!temp.isEmpty()) {
                str.append(temp.pop());
                if (!temp.isEmpty()) {
                    str.append(" > ");
                }
            }
            return str.toString();
        }
    }

    
}
