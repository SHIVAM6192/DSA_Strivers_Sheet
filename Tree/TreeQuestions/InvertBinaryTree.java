package TreeQuestions;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/invert-binary-tree/
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            final TreeNode node = queue.poll();

            // swap the child nodes
            final TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null)  queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

        return root;
    }
    public static void main(String[] args) {

    }
}
