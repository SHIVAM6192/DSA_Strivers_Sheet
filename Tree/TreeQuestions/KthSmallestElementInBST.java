package TreeQuestions;

public class KthSmallestElementInBST {
    private int k;
    private int ans;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;

        helper(root);
        return ans;
    }

    public void helper(TreeNode node){
        if(node == null){
            return;
        }
        // Do in-order traversal
        helper(node.left);

        this.k--;
        if(this.k == 0){
            ans = node.val;
            return;
        }

        helper(node.right);
    }
}
