package TreeQuestions;

// https://leetcode.com/problems/binary-tree-maximum-path-sum
public class BinaryTreeMaximumPathSum {
    int maxSum;

    public int solve(TreeNode root){
        if (root == null)
            return 0;

        int l = solve(root.left);
        int r = solve(root.right);

        int neeche_hi_milgaya_answer = l + r + root.val;
        int koi_ek_accha = Math.max(l, r) + root.val;
        int only_root_accha = root.val;

        maxSum = Math.max(maxSum, Math.max(neeche_hi_milgaya_answer, Math.max(koi_ek_accha, only_root_accha)));

        // return max between (koi_ek_accha, only_root_accha)
        return Math.max(koi_ek_accha, only_root_accha);
    }

    public int maxSum(TreeNode root){
        maxSum = Integer.MIN_VALUE;
        solve(root);

        return maxSum;
    }

    public static void main(String[] args) {

    }
}
