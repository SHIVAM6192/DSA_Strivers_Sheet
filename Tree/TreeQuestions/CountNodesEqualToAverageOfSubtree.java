package TreeQuestions;

// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree
public class CountNodesEqualToAverageOfSubtree {
    static int result;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    // return {sum, count} for every node
    public int[] dfs(TreeNode root){
        if (root == null){
            return new int[]{0,0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = root.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];

        if (sum / count == root.val){
            result++;
        }
        return new int[]{sum, count};
    }
}
