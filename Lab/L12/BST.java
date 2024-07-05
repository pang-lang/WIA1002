/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BST;

import java.util.ArrayList;

/**
 *
 * @author panglang
 */
public class BST <E extends Comparable <E>> {
    TreeNode <E> root;
    private int size = 0;
    
    public boolean search(E e){
        TreeNode <E> current = root;
        while (current != null){
            if (e.compareTo(current.element) < 0)
                current = current.left;
            else if (e.compareTo(current.element) > 0)
                current = current.right;
            else 
                return true;
        }
        return false;    
    }
    
    public boolean insert(E e) {
        if (root == null) {
            root = new TreeNode<>(e);
            return true;
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // Duplicate value, insertion fails
                }
            }
            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(e);
            } else {
                parent.right = new TreeNode<>(e);
            }
            size++;
            return true; 
        }
    }
    
    public int getSize(){
        return size;
    }
    
    public int height(){
        return height(root);
    }
    
    private int height(TreeNode<E> node){
        if (node == null){
            return -1;
        } else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    
    public E getRoot() {
        if (root == null)
            return null;
        return root.element;
    }

    public E minValue(){
        if (root == null){
            return null;
        }
        TreeNode <E> current = root;
        while (current.left != null)
            current = current.left;
        
        return current.element;
    }
    

    public E maxValue(){
        if (root == null){
            return null;
        }
        TreeNode <E> current = root;
        while (current.right != null)
            current = current.right;
        
        return current.element;
    }
    
    public ArrayList<E> path(E e){
        ArrayList <E> path = new ArrayList <>();
        TreeNode <E> current = root;
        while (current != null){
            path.add(current.element);
            if (e.compareTo(current.element) < 0)
                current = current.left;
            else if (e.compareTo(current.element) > 0)
                current = current.right;
            else // equal
                return path;
        }
        path.clear(); // e not found, clear the list
        return path;
    }
    
    public boolean delete(E e){
        TreeNode <E> parent = null;
        TreeNode <E> current = root;
        while (current != null){
            if (e.compareTo(current.element) < 0){
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0){
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        
        // element not found
        if (current == null){
            return false;
        }
        
        // Node to be deleted has at most one child
        if (current.left == null){
            // Node to be deleted is the root
            if (parent == null){
                root = current.right;
            } else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        } else {  // Case 3: Node to be deleted has two children, find the rightmost node in the left subtree
            TreeNode <E> parentofRightMost = current;
            TreeNode <E> rightMost = current.left;
            while (rightMost.right != null) {
                parentofRightMost = rightMost;
                rightMost = rightMost.right; 
            }
            current.element = rightMost.element;
            if (parentofRightMost.right == rightMost)
                parentofRightMost.right = rightMost.left; //update the parent's right pointer to point to the left child of the rightmost node
            else //rightmost node is the left child of its parent
                parentofRightMost.left = rightMost.left;     
        }
        size--;
        return true; 
    }
    
    public boolean clear(){
        if (root == null){
            return false;
        }
        root = null;
        size = 0;
        return true;
    }
    
    public void inorder(){
        inorder(root);
    }
    
    protected void inorder(TreeNode<E> root){
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }
    
    public void postorder(){
        postorder(root);
    }
    
    protected void postorder(TreeNode<E> root){
        if (root == null)
            return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }
    
    public void preorder(){
        preorder(root);
    }
    
    protected void preorder(TreeNode<E> root){
        if (root == null)
            return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }
    
}

