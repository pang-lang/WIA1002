/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q4;

/**
 *
 * @author panglang
 */
public class BST {
    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
         int[] arr = {9,5,20,3,8,12,30};
        
        // Constructing the BST
        Node root = constructBST(arr, 0);
        
        // Creating an instance of BST to access non-static methods
        BST bst = new BST();
        
        System.out.println("Preorder:");
        bst.preorder(root);
        
        System.out.println("\nInorder:");
        bst.inorder(root);
        
        System.out.println("\nPostorder:");
        bst.postorder(root);
    }
        
    public static Node constructBST(int[] arr, int index){
        if (index >= arr.length){
            return null;
        }
        Node root = new Node(arr[index]);
        root.left = constructBST(arr, 2*index+1);
        root.right = constructBST(arr, 2*index+2);
        return root;
    }
        
    public void preorder(Node root){
        if (root == null)
            return;
        
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
       
    public void inorder(Node root){
        if (root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
        
    public void postorder(Node root){
        if (root == null)
            return;
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
}
    
    
