package TreeQuestions;

// https://leetcode.com/problems/recover-binary-search-tree
public class RecoverBinarySearchTree {
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;

    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);

        // prev.val > root.val means swap happened with prev node
        // Like that we will have another one node as well where swap happened
        if(prev != null && prev.val > root.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }

        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Now swap the first with second to recover the BST
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {

    }
}
