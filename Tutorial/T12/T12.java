/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t12;

/**
 *
 * @author panglang
 */
public class T12 {

}

    /*
    
        1. What is a binary search tree (BST)?
        A Binary Search Tree is a data structure used in computer science for organizing and storing data in a sorted manner. 
        Each node in a Binary Search Tree has at most two children, a left child and a right child, with the left child 
        containing values less than the parent node and the right child containing values greater than the parent node. 

        2. Build a BST based on the input 50, 30, 25, 71, 80, 99, 40, 1, 7, 5. Draw the final tree.
                                50
                        30              71
                    25        40               80
                        1                            99
                            7
                        5  
                    
        3. What is the height of the tree built in Question 2?
        5
        
        
                                        0100
                                 ┌────────┴─────────┐
                               0050                  0150
                          ┌──────┴──────┐       ┌──────┴─────┐
                         0025         0070    0135         0169
                       ┌──┴──┐       ┌──┴──┐               └──┐
                     0001  0030    0065  0085               0180

        4.Given the following BST, list the items in the order of:
        (a) Pre-order traversal 
                0100 0050 0025 0001 0030 0070 0065 0085 0150 0135 0169 0180
        (b) In-Order traversal 
                0001 0025 0030 0050 0065 0070 0085 0100 0135 0150 0169 0180
        (c) Post-order traversal
                0001 0030 0025 0065 0085 0070 0050 0135 0180 0169 0150 0100
        
        5. Using the same BST in Question 4, delete the element `0030’. Draw the resulting tree.
                               0100
                        ┌────────┴─────────┐
                       0050               0150
                  ┌──────┴──────┐    ┌──────┴─────┐
                 0025         0070  0135         0169
               ┌──┘          ┌──┴──┐               └──┐
             0001          0065  0085               0180


        6. Again, using the same BST in Question 3 (i.e., ignoring the deletion of `0030’ in Question 5), 
        delete the element `0050’. Draw the resulting tree.
                                        0100
                                 ┌────────┴─────────┐
                               0030                  0150
                          ┌──────┴──────┐       ┌──────┴─────┐
                         0025         0070    0135         0169
                       ┌──┴          ┌──┴──┐               └──┐
                     0001          0065  0085               0180
*/
  