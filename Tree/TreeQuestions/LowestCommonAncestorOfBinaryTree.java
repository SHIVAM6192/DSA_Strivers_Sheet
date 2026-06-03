package TreeQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorOfBinaryTree {

    TreeNode root;

    public LowestCommonAncestorOfBinaryTree(){
        this.root = null;
    }
    // Method to insert level by level (fills left to right)
    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Check if left is empty; if so, insert and exit
            if (current.left == null) {
                current.left = new TreeNode(val);
                break;
            } else {
                queue.add(current.left);
            }

            // Check if right is empty; if so, insert and exit
            if (current.right == null) {
                current.right = new TreeNode(val);
                break;
            } else {
                queue.add(current.right);
            }
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        else if(left != null){
            return left;
        }
        else {
            return right;
        }
    }

    // NEW HELPER METHOD: Finds the actual node object in the tree
    public TreeNode findTree(TreeNode current, int val){
        if(current == null) return null;
        if(current.val == val) return current;

        TreeNode leftSearch = findTree(current.left, val);
        if (leftSearch != null) return leftSearch;

        return findTree(current.right, val);
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfBinaryTree lca = new LowestCommonAncestorOfBinaryTree();

        lca.insert(3);
        lca.insert(5);
        lca.insert(1);
        lca.insert(6);
        lca.insert(2);
        lca.insert(7);
        lca.insert(4);
        lca.insert(0);
        lca.insert(8);

        // find node to search ancestor
        TreeNode p = lca.findTree(lca.root,5);
        TreeNode q = lca.findTree(lca.root,1);

        TreeNode ancestor = lca.lowestCommonAncestor(lca.root, p, q);

        // Added a null check just in case the values aren't in the tree
        if (ancestor != null) {
            System.out.println("The LCA is: " + ancestor.val);
        } else {
            System.out.println("One or both nodes were not found in the tree.");
        }
    }


}
