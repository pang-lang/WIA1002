/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Q6;
/*
Inorder   : 12 18 27 29 31 33 34 36 38 40 56 64 66 99 100 
Preorder  : 34 27 12 18 31 29 33 56 36 40 38 66 64 100 99 
Postorder : 18 12 29 33 31 27 38 40 36 64 99 100 66 56 34 
 */
public class BST <E extends Comparable <E>>{
    static class Node {
        Node left;
        Node right; 
        int data;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        
    }
    
    static class BinarySearchTree {
        Node root;

        public BinarySearchTree() {
            this.root = null;
        }
        
        public void add(int data){
            root = addHelper(root, data);
        }
        
        private Node addHelper(Node node, int data){
            if (node == null){
                return new Node(data);
            }
            if (data < node.data){
                node.left = addHelper(node.left, data);
            } else if (data > node.data){
                node.right = addHelper(node.right, data);
            }
            return node;
        }
    
        public void printInOrder(Node node){
            if (node != null){
                printInOrder(node.left);
                System.out.print(node.data + " ");
                printInOrder(node.right);
            }
        }

        public void printPreOrder(Node node){
            if (node != null){ 
                System.out.print(node.data + " ");
                printPreOrder(node.left);
                printPreOrder(node.right);
            }
        }

        public void printPostOrder(Node node){
            if (node != null){
                printPostOrder(node.left);
                printPostOrder(node.right);
                System.out.print(node.data + " ");
            }
        }
        
        public boolean delete(Node o){
            Node parent = null;
            Node current = root;
            while (current != null){
                if (o.compareTo(current.data) < 0){
                    parent = current;
                    current = current.left;
                } else if (o.compareTo(current.data) > 0){
                    parent = current;
                    current = current.right;
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
                    if (o.compareTo(parent.data) < 0){
                        parent.left = current.right;
                    } else {
                        parent.right = current.right;
                    }
                }
            } else {
                Node parentOfLeftMost = current;
                Node leftmost = current.right;
                while (leftmost.left != null){
                    parentOfLeftMost = leftmost;
                    leftmost = leftmost.left;
                }
                current.data = leftmost.data;
                if (parentOfLeftMost.left == leftmost){
                    parentOfLeftMost.left = leftmost.right;
                } else {
                    parentOfLeftMost.right = leftmost.right;
                }
            }
            return false;
            }
        }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] arr = {34,27,56,12,31,36,66,18,29,33,40,64,100,38,99};
        for (int i=0; i<arr.length; i++){
            bst.add(arr[i]);
        }

        bst.printInOrder(bst.root);
        System.out.println("");
        bst.printPreOrder(bst.root);
        System.out.println("");
        bst.printPostOrder(bst.root);
        
    }
    

}
