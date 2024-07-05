package t12;

// BST using recursion
public class BST {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public void insert(int data) {
        root = insertHelper(root, new Node(data));
    }

    private Node insertHelper(Node root, Node node) {
        if (root == null) {
            return node;
        }
        if (node.data < root.data) {
            root.left = insertHelper(root.left, node);
        } else {
            root.right = insertHelper(root.right, node);
        }
        return root;
    }

    public void displayInOrder() {
        System.out.print("In-Order: ");
        displayInOrderHelper(root);
        System.out.println();
    }

    private void displayInOrderHelper(Node root) {
        if (root != null) {
            displayInOrderHelper(root.left);
            System.out.print(root.data + " ");
            displayInOrderHelper(root.right);
        }
    }

    public void displayPreOrder() {
        System.out.print("Pre-Order: ");
        displayPreOrderHelper(root);
        System.out.println();
    }

    private void displayPreOrderHelper(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            displayPreOrderHelper(root.left);
            displayPreOrderHelper(root.right);
        }
    }

    public void displayPostOrder() {
        System.out.print("Post-Order: ");
        displayPostOrderHelper(root);
        System.out.println();
    }

    private void displayPostOrderHelper(Node root) {
        if (root != null) {
            displayPostOrderHelper(root.left);
            displayPostOrderHelper(root.right);
            System.out.print(root.data + " ");
        }
    }

    public boolean search(int data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node root, int data) {
        if (root == null) {
            return false;
        } else if (root.data > data) {
            return searchHelper(root.left, data);
        } else if (root.data < data) {
            return searchHelper(root.right, data);
        } else {
            return true;
        }
    }

    public void remove(int data) {
        if (search(data)) {
            root = removeHelper(root, data);
        } else {
            System.out.println(data + " is not found.");
        }
    }

    private Node removeHelper(Node root, int data) {
        if (root == null) {
            return root;
        } else if (data < root.data) {
            root.left = removeHelper(root.left, data);
        } else if (data > root.data) {
            root.right = removeHelper(root.right, data);
        } else { // node found
            if (root.left == null && root.right == null) { // node to be removed is a leaf node
                return null;
            } else if (root.right != null) { // find a successor to replace this node
                root.data = successor(root);
                root.right = removeHelper(root.right, root.data);
            } else { // find a predecessor to replace this node
                root.data = predecessor(root);
                root.left = removeHelper(root.left, root.data);
            }
        }
        return root;
    }

    private int successor(Node root) { // find the least value below the right child of this root node
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private int predecessor(Node root) {
        root = root.left;
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }

    public static void main(String[] args) {
        int[] arr1 = {50, 30, 25, 71, 80, 99, 40, 1, 7, 5};
        int[] arr2 = {100, 50, 150, 25, 70, 135, 169, 1, 30, 65, 85, 180};

        // BST 1
        BST bst1 = new BST();
        for (int i = 0; i < arr1.length; i++) {
            bst1.insert(arr1[i]);
        }
        System.out.println("BST 1:");
        bst1.displayInOrder();
        bst1.displayPreOrder();
        bst1.displayPostOrder();
        bst1.remove(50);
        System.out.println("After removing 50:");
        bst1.displayInOrder();
        bst1.displayPreOrder();
        bst1.displayPostOrder();

        // BST 2
        BST bst2 = new BST();
        for (int i = 0; i < arr2.length; i++) {
            bst2.insert(arr2[i]);
        }
        System.out.println("BST 2:");
        bst2.displayInOrder();
        bst2.displayPreOrder();
        bst2.displayPostOrder();
        bst2.remove(50);
        System.out.println("After removing 50:");
        bst2.displayInOrder();
        bst2.displayPreOrder();
        bst2.displayPostOrder();
    }
}
