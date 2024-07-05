/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;

/**
 *
 * @author panglang
 */
public class BinarySearchTree <E extends Comparable <E>>{
    class Node <E> {
        Node <E> left;
        Node <E> right;
        E data;

        public Node(E data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
    
    Node <E> root;
    int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }
    
    public boolean insert(E e){
        Node <E> newNode = new Node<>(e);
        if (root == null){
            root = newNode;
        } else {
            Node <E> parent = null;
            Node <E> current = root;
            while (current != null){
                if (e.compareTo(current.data) > 0){
                    parent = current;
                    current = current.right;
                } else if (e.compareTo(current.data) < 0){
                    parent = current;
                    current = current.left;
                } else {
                    return false;
                }
            }
            
            if (e.compareTo(parent.data) > 0){
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
        }
        size++;
        return true;
    }
    
    // using rightmost of the left child
    public boolean delete(E e){
        Node <E> parent = null;
        Node <E> current = root;
        while (current != null){
            if (e.compareTo(current.data) > 0){
                parent = current;
                current = current.right;
            } else if (e.compareTo(current.data) < 0){
                parent = current;
                current = current.left;
            } else {
                break;
            }
        }
        
        if (current == null){
            return false;
        } 
        
        if (current.left == null){
            if (parent == null){
                root = current.right;
            } else {
                if (e.compareTo(parent.data) > 0){
                    parent.right = current.right;
                } else {
                    parent.left = current.right;
                }
            }
        } else if (current.right == null){
            if (parent == null){
                root = current.left;
            } else {
                if (e.compareTo(parent.data) > 0){
                    parent.right = current.left;
                } else {
                    parent.left = current.left;
                }
            }
        } else {
            Node <E> parentOfRightMost = current;
            Node <E> rightMost = current.left;
            while (rightMost.right != null){
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }
            current.data = rightMost.data;
            if (e.compareTo(parentOfRightMost.data) > 0){
                parentOfRightMost.right = rightMost.left;
            } else {
                parentOfRightMost.left = rightMost.left;
            }
        }
        size--;
        return true;
    }
    
    // using leftmost of right child
    public boolean delete2(E e){
        Node <E> parent = null;
        Node <E> current = root;
        while (current != null){
            if (e.compareTo(current.data) > 0){
                parent = current;
                current = current.right;
            } else if (e.compareTo(current.data) < 0){
                parent = current;
                current = current.left;
            } else {
                break;
            }
        }
        
        if (current == null){
            return false;
        } 
        
        if (current.left == null){
            if (parent == null){
                root = current.right;
            } else {
                if (e.compareTo(parent.data) > 0){
                    parent.right = current.right;
                } else {
                    parent.left = current.right;
                }
            }
        } else if (current.right == null){
            if (parent == null){
                root = current.left;
            } else {
                if (e.compareTo(parent.data) > 0){
                    parent.right = current.left;
                } else {
                    parent.left = current.left;
                }
            }
        } else {
            Node <E> parentOfLeftMost = current;
            Node <E> leftMost = current.right;
            while (leftMost.left != null){
                parentOfLeftMost = leftMost;
                leftMost = leftMost.left;
            }
            current.data = leftMost.data;
            if (e.compareTo(parentOfLeftMost.data) > 0){
                parentOfLeftMost.right = leftMost.right;
            } else {
                parentOfLeftMost.left = leftMost.right;
            }
        }
        size--;
        return true;
    }
    
    public void inOrder(){
        inOrderHelper(root);
        System.out.println("");
    }
    
    private void inOrderHelper(Node root){
        if (root != null){
            inOrderHelper(root.left);
            System.out.print(root.data + " ");
            inOrderHelper(root.right);
        }
    }
    
    
    public static void main(String[] args) {
        BinarySearchTree <Integer> tree = new BinarySearchTree<>();
        int[] arr = {12, 18, 27, 29, 31, 33, 34, 36, 38, 40, 56, 64, 66, 99, 100};
        for (int i : arr){
            tree.insert(i);
        }
        tree.inOrder();
        tree.delete(12);
        tree.delete(34);
        tree.delete2(12);
        tree.delete2(34);
        tree.inOrder();
    }
}
    

