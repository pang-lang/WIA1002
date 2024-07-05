/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BST;

/**
 *
 * @author panglang
 */
public class TreeNode <E extends Comparable <E>>{
    E element;
    TreeNode left;
    TreeNode right;

    public TreeNode(E element) {
        this.element = element;
    }
}
