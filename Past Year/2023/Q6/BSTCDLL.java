/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;

/**
 *
 * @author panglang
 */
public class BSTCDLL {
    class Node {
        Node left;
        Node right;
        int data;
        
        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
    
    Node root;

    public BSTCDLL() {
        this.root = null;
    }
    
    public Node concatenate(Node leftList, Node rightList){ 
        // If either of the list is empty, then return the other list 
        if (leftList == null) 
            return rightList; 
        if (rightList == null) 
            return leftList; 
  
        // Store the last Node of the listist 
        Node leftLast = leftList.left; 
        Node rightLast = rightList.left; 
  
        // Connect the last node of Left List with the first Node of the right List 
        leftLast.right = rightList; 
        rightList.left = leftLast; 
  
        // left of first node refers to the last node in the list 
        // right of last node refers to the first node of the list 
        leftList.left = rightLast; 
        rightLast.right = leftList; 

        return leftList; 
    } 
  
    // Method converts a tree to a circular 
    // Link List and then returns the head 
    // of the Link List 
    public Node bTreeToCList(Node root){ 
        if (root == null) 
            return null; 
  
        // Recursively convert left and right subtrees 
        Node left = bTreeToCList(root.left); 
        Node right = bTreeToCList(root.right); 
  
        // Make a circular linked list of single node (or root). To do so, make the right and 
        // left pointers of this node point to itself 
        root.left = root.right = root; 
  
        // Step 1 (concatenate the left list with the list with single node, i.e., current node) 
        // Step 2 (concatenate the returned list with the right List) 
        return concatenate(concatenate(left, root), right); 
    } 
  
    // Display Circular Link List 
    public void display(Node head) { 
        System.out.println("Circular Linked List is :"); 
        Node itr = head; 
        do { 
            System.out.print(itr.data + " "); 
            itr = itr.right; 
        } while (itr != head); 
        System.out.println(); 
    }

    public static void main(String args[]) { 
        // Build the tree 
        BSTCDLL tree = new BSTCDLL(); 
        tree.root = tree.new Node(10); 
        tree.root.left = tree.new Node(12); 
        tree.root.right = tree.new Node(15); 
        tree.root.left.left = tree.new Node(25); 
        tree.root.left.right = tree.new Node(30); 
        tree.root.right.left = tree.new Node(36); 

        // head refers to the head of the Link List 
        Node head = tree.bTreeToCList(tree.root); 
  
        // Display the Circular LinkedList 
        tree.display(head); 
    } 
}