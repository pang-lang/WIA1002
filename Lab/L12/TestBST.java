/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package BST;

/**
 *
 * @author panglang
 */
public class TestBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST <Integer> bst = new BST<>();
        int[] input = {45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14};
        System.out.print("Input data \t: ");
        for (int i=0; i<input.length; i++){
            bst.insert(input[i]);
            System.out.print(input[i] + " ");
        }
        System.out.print("\nInorder (sorted): ");
        bst.inorder();
        System.out.print("\nPostorder \t: ");
        bst.postorder();
        System.out.print("\nPreorder \t: ");
        bst.preorder();
        System.out.println("Height of the BST : " + bst.height());
        System.out.println("Root for BST is : " + bst.root);
        System.out.println("Check whether 10 is in the tree ? " + bst.search(10));
        System.out.println("Delete 53 " + bst.delete(53));
        System.out.print("Updated Inorder data (sorted) : ");
        bst.inorder();
        System.out.println("\nMin Value \t: " + bst.minValue());
        System.out.println("Max Value \t: " + bst.maxValue());
        System.out.println("A path for the root to 6 is : " + bst.path(6));
        
    }
    
}
