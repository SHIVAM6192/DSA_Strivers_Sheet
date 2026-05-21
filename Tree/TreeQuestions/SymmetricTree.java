package TreeQuestions;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/symmetric-tree/description/
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        // Two ques to store node
        Queue<TreeNode> leftTree = new LinkedList<>(); // will store left nodes
        Queue<TreeNode> rightTree = new LinkedList<>();  // will store right nodes

        // Add left of root and right of root
        leftTree.add(root.left);
        rightTree.add(root.right);

        // Traverse till any of these are not empty
        while (!leftTree.isEmpty() && !rightTree.isEmpty()){
            // Pop the left and right node
            TreeNode leftNode = leftTree.poll();
            TreeNode rightNode = rightTree.poll();

            // If both are null then continue
            if(leftNode == null && rightNode == null) {
                continue;
            }

            // If any of null then return false
            if(leftNode == null || rightNode == null){
                return false;
            }

            // If values are not same then return false
            if(leftNode.val != rightNode.val){
                return false;
            }

            // Add left and the right node in leftTree
            leftTree.add(leftNode.left);
            leftTree.add(leftNode.right);

            // Add right and then left in rightTree
            rightTree.add(rightNode.right);
            rightTree.add(rightNode.left);
        }

        return true;
    }
}
