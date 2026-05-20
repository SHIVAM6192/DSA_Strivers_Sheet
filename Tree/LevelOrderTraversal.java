import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    Node root;

    public LevelOrderTraversal(){
        this.root = null;
    }
    public void insert(int val){
        root = insertRecursive(root, val);
    }

    private Node insertRecursive(Node current, int val) {
        if(current == null){
            return new Node(val);
        }
        if(val < current.value){
            current.left = insertRecursive(current.left, val);
        }
        else if(val > current.value){
            current.right = insertRecursive(current.right, val);
        }
        return current;
    }

    public static void levelOrderTraversal(Node root){
        Queue<Node> queue = new LinkedList<>();

        // Start with the first/root node
        queue.add(root);

        // Run a loop till this queue is not empty
        while(!queue.isEmpty()){
            Node node = queue.poll();

            // Print the value
            System.out.println(node.value);

            // Add left child to queue
            if(node.left != null)
                queue.add(node.left);

            // Add right child to queue
            if(node.right != null)
                queue.add(node.right);
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversal lOT = new LevelOrderTraversal();
        lOT.insert(50);
        lOT.insert(30);
        lOT.insert(20);
        lOT.insert(40);
        lOT.insert(70);
        lOT.insert(60);

        levelOrderTraversal(lOT.root);
    }
}
