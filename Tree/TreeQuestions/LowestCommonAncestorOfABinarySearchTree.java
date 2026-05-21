package TreeQuestions;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            // If values are less then go in left subtree
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }

            // If values are greater then go in right subtree
            else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }

            // if both the conditions are false then the root is the ancestor of p & q
            else {
                return root;
            }
        }
        return null;
    }
}
