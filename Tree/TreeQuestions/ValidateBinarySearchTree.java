package TreeQuestions;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/validate-binary-search-tree/?envType=problem-list-v2&envId=tree
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();

        // Populate the tree values in list
        // When we do inorder traversal on BST it will return elements in ascending order
        inorderTreeTraversal(root, inOrderList);

        boolean isBST = true;
        int prev = inOrderList.get(0);
        for(int i = 1; i < inOrderList.size(); i++){

            // Check the new element is smaller than previous element
            // or if the element is duplicate
            if(inOrderList.get(i) <= prev){
                isBST = false;
                return isBST;
            }
            prev = inOrderList.get(i);
        }

        return isBST;
    }

    // This is recursive tree traversal
    public void inorderTreeTraversal(TreeNode root, List<Integer> inOrderList){
        if(root == null){
            return;
        }

        inorderTreeTraversal(root.left, inOrderList);
        inOrderList.add(root.val);
        inorderTreeTraversal(root.right, inOrderList);
    }

    public static void main(String[] args) {

    }
}
