package TreeQuestions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DiameterOfBinaryTree {
    TreeNode root;

    public DiameterOfBinaryTree(){
        this.root = null;
    }

    public void insert(int val){
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode current, int val) {
        if(current == null){
            return new TreeNode(val);
        }
        if(val < current.val){
            current.left = insertRecursive(current.left, val);
        }
        else if(val > current.val){
            current.right = insertRecursive(current.right, val);
        }
        return current;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // In map we will store depth of each node
        Map<TreeNode, Integer> map = new HashMap<>();
        Stack<TreeNode> st = new Stack<>();
        int diameter = 0;

        if(root != null){
            st.push(root);
        }

        while(!st.isEmpty()){
            TreeNode node = st.peek();

            // Fill the stack to perform post order traversal
            if(node.left != null && !map.containsKey(node.left)){
                st.push(node.left);
            }
            else if(node.right != null && !map.containsKey(node.right)){
                st.push(node.right);
            }
            else{
                st.pop();
                int leftDepth = map.getOrDefault(node.left, 0);
                int rightDepth = map.getOrDefault(node.right, 0);

                // Put the max depth at a node in the map
                map.put(node, 1 + (leftDepth + rightDepth));

                // Update the max diameter found so far
                diameter = Math.max(diameter, leftDepth + rightDepth);
            }
        }

        return diameter;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();

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
        tree.insert(81);

        int diameter = tree.diameterOfBinaryTree(tree.root);
        System.out.println("Diameter of tree: " + diameter);
    }
}
