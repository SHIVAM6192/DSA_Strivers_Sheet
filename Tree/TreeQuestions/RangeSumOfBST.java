package TreeQuestions;

// https://leetcode.com/problems/range-sum-of-bst/
public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null)
            return 0;

        // If root.val is in range of low and high
        if (root.val >= low && root.val <= high){
            return root.val + rangeSumBST(root.left, low, high)
                    + rangeSumBST(root.right, low, high);
        }

        // If root.val < low then explore on right
        if (root.val < low){
            return rangeSumBST(root.right, low, high);
        }

        // If both condition fails means root.val > high, then explore in left
        return rangeSumBST(root.left, low, high);
    }

    public static void main(String[] args) {

    }
}
