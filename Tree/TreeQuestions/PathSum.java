package TreeQuestions;

import java.util.Stack;

// https://leetcode.com/problems/path-sum/
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        // Create to stack for path and sums
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sumPath = new Stack<>();

        path.push(root);
        sumPath.push(root.val);

        while (!path.isEmpty()){
            TreeNode node = path.pop();
            int tempSum = sumPath.pop();

            // If the node is leaf node and targetSum equals to sum, then return true
            if(node.left == null && node.right == null && targetSum == tempSum){
                return true;
            }

            // Check the left node is not null and push the path and value
            if(node.left != null){
                path.push(node.left);
                // We will add the current sum into next node sum
                sumPath.push(node.left.val + tempSum);
            }

            // Check the right node is not null and push the path and value
            if(node.right != null){
                path.push(node.right);
                // We will add the current sum into next node sum
                sumPath.push(node.right.val + tempSum);
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
