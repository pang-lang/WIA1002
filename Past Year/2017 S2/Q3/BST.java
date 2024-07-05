/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q3;

import java.util.Stack;

/**
 *
 * @author panglang
 */
public class BST <E extends Comparable <E>> {
    class Node <E> {
        private E element;
        private Node <E> left;
        private Node <E> right;
        
        public Node(E element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }
    
    private Node <E> root;
    
    public boolean add(Node <E> node, E item){
        if (root == null){
            root = new Node<>(item);
            return true;
        } else {
            Node <E> parent = null;
            Node <E> current = root;
            while (current != null){
                parent = current;
                if (item.compareTo(current.element) < 0){
                    current = current.left;
                } else if (item.compareTo(current.element) > 0){
                    current = current.right;
                } else {
                    return false;
                }
            } 
            if (item.compareTo(parent.element) < 0){
                parent.left = new Node <> (item);
            } else {
                parent.right = new Node<> (item);
            } 
            return true;
        }
    }
    
    public void printTreeInOrder(){
        if (root == null){
            System.out.println("The tree is empty.");
        } else {
            Stack <Node<E>> stack = new Stack<>();
            Node <E> current = root;
            while (current != null || !stack.isEmpty()){
                while (current != null){
                    stack.push(current);
                    current = current.left;
                } 
                current = stack.pop();
                System.out.print(current.element + " ");
                current = current.right;
            }
            System.out.println();
        }
    }
    
    public boolean contains(E item){
        Node <E> current = root;
        while (current != null){
            if (item.compareTo(current.element) < 0){
                current = current.left;
            } else if (item.compareTo(current.element) > 0){
                current = current.right;
            } else{
                return true;
            } 
        }
        return false;
    }
    
    public static void main(String[] args) {
        BST <Integer> bst = new BST<>();
        bst.add(bst.root, 6);
        bst.add(bst.root, 3);
        bst.add(bst.root, 1);
        bst.add(bst.root, 8);
        bst.add(bst.root, 5);
        bst.add(bst.root, 9);
        bst.add(bst.root, 4);
        
        bst.printTreeInOrder();
        System.out.println(bst.contains(2));
        System.out.println(bst.contains(9));
        
    }
}
