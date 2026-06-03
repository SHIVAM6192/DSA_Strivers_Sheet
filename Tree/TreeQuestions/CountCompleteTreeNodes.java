package TreeQuestions;

// https://leetcode.com/problems/count-complete-tree-nodes/description/
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int rightDepth = rightDepth(root);
        int leftDepth = leftDepth(root);

        if (rightDepth == leftDepth){
            return (int) Math.pow(2, leftDepth) - 1;
        }
        else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    public int rightDepth(TreeNode node){
        int depth = 0;
        while (node != null){
            node = node.right;
            depth++;
        }
        return depth;
    }

    public int leftDepth(TreeNode node){
        int depth = 0;
        while (node != null){
            node = node.left;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {

    }
}
