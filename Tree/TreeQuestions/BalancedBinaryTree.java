package TreeQuestions;

// https://leetcode.com/problems/balanced-binary-tree/description/

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    private int dfsHeight(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftHeight = dfsHeight(node.left);
        if(leftHeight == -1){
            return -1;
        }

        int rightHeight = dfsHeight(node.right);
        if(rightHeight == -1){
            return -1;
        }

        // if Math.abs(leftHeight - rightHeight) > 1 means that node is not balanced
        if(Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }

        // Take the max from left and right height and add 1, that will be
        // the height of that current node
        return Math.max(leftHeight , rightHeight) + 1;
    }
}
