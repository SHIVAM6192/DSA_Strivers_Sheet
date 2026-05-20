public class BinarySearchTree {

    Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(int val){
        root = insertRecursive(root, val);
    }

    // Private helper method that does the actual work recursively
    private Node insertRecursive(Node current, int val) {
        // Base case: If we reach an empty spot, put the new node here!
        if(current == null){
            return new Node(val);
        }
        // If the value is less than the current node's value, go LEFT
        if(val < current.value){
            current.left = insertRecursive(current.left, val);
        }
        // If the value is greater than the current node's value, go RIGHT
        else if(val > current.value){
            current.right = insertRecursive(current.right, val);
        }
        // (If the value is equal, we usually ignore it to avoid duplicates in a BST)
        // Return the unchanged current node pointer back up the call stack
        return current;
    }

    // --- TRAVERSAL (Printing the tree) ---

    // "In-Order" traversal visits the left branch, then the root, then the right branch.
    // In a Binary Search Tree, this conveniently prints the numbers in sorted order!
    public void printInOrder(){
        System.out.println("Tree contains (In-Order): ");
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node current){
        if(current != null){
            // 1. Visit the left child
            inOrderRecursive(current.left);

            // 2. Print the current node's value
            System.out.print(current.value + " ");

            // 3. Visit the right child
            inOrderRecursive(current.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let's build this tree:
                 50
               /    \
             30      70
            /  \    /  \
          20   40  60   80
        */

        System.out.println("Inserting values into the tree...");
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // If we coded this correctly, printing it "In-Order" should
        // output the numbers strictly from smallest to largest.
        tree.printInOrder();
    }

}
