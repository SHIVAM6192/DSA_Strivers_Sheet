package TreeQuestions;

// https://leetcode.com/problems/minimum-absolute-difference-in-bst
public class MinimumAbsoluteDifferenceInBST {
    static int minValue;
    static TreeNode prev;

    public static void solve(TreeNode root){
        if (root == null)
            return;

        solve(root.left);
        if (prev != null)
            minValue = Math.min(minValue, root.val - prev.val);

        prev = root;
        solve(root.right);
    }

    public static int getMinimumDifference(TreeNode root) {
        minValue = Integer.MAX_VALUE;
        prev = null;
        solve(root);
        return minValue;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(7);
        TreeNode node = new TreeNode(5, left, right);

        System.out.println(getMinimumDifference(node));
    }
}
