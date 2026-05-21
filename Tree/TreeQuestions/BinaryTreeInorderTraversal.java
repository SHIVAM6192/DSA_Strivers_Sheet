package TreeQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-inorder-traversal/?envType=problem-list-v2&envId=tree
public class BinaryTreeInorderTraversal {
    TreeNode root;

    public BinaryTreeInorderTraversal(){
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

    // We can use stack as well
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        // Using recursion
        // recursiveTreeTraversal(root, res);
        // return res;

        // Using stack
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !st.isEmpty()){
            while (curr != null){
                st.push(curr);
                curr = curr.left;
            }

            curr = st.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }

    // This is recursive tree traversal
    public void recursiveTreeTraversal(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }

        recursiveTreeTraversal(root.left, res);
        res.add(root.val);
        recursiveTreeTraversal(root.right, res);
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal tree = new BinaryTreeInorderTraversal();

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

        List<Integer> res = tree.inorderTraversal(tree.root);
        System.out.println(res.toString());
    }
}
