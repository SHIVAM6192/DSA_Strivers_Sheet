package TreeQuestions;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {

    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for(int i =0; i < inorder.length; i++){
            inOrderIndexMap.put(inorder[i], i);
        }
        return splitTree(preorder, inOrderIndexMap, 0, 0, inorder.length - 1);
    }

    public TreeNode splitTree(int[] preOrder, Map<Integer, Integer> inOrderIndexMap,
                              int rootIndex, int left, int right){

        TreeNode root = new TreeNode(preOrder[rootIndex]);

        int mid = inOrderIndexMap.get(preOrder[rootIndex]);

        if(mid > left){
            root.left = splitTree(preOrder, inOrderIndexMap, rootIndex + 1, left, mid - 1);
        }

        if(mid < right){
            root.right = splitTree(preOrder, inOrderIndexMap, rootIndex + mid - left + 1, mid + 1, right);
        }

        return root;
    }


}
