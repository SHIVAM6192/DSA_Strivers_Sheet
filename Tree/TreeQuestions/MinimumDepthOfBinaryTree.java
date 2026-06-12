package TreeQuestions;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/?envType=problem-list-v2&envId=breadth-first-search
public class MinimumDepthOfBinaryTree {
    TreeNode root;

    public MinimumDepthOfBinaryTree(){
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

    // Minimum depth of binary tree
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();

                // If leaf node is found just return depth
                if(node.left == null && node.right == null){
                    return depth;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
