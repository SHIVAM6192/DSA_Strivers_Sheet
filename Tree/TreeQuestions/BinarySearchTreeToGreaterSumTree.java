package TreeQuestions;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
public class BinarySearchTreeToGreaterSumTree {
    static int sum;

    public static void solve(TreeNode root){
        if(root == null)
            return;

        solve(root.right);
        sum += root.val;
        root.val = sum;
        solve(root.left);
    }

    public static TreeNode bstToGst(TreeNode root) {
        sum = 0;

        solve(root);
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            System.out.print(node.val + " ");

            if (node.left != null)
                queue.offer(node.left);

            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        root.left.right.right = new TreeNode(3);

        root.right.right.right = new TreeNode(8);

        bstToGst(root);
        printTree(root);

    }
}
