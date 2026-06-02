package TreeQuestions;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/balance-a-binary-search-tree/description/
public class BalanceBinarySearchTree {
    public static void main(String[] args) {

    }
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> sortedNodes = new ArrayList<>();
        inOrderTraversal(root, sortedNodes);
        return buildBalancedBST(sortedNodes, 0, sortedNodes.size() - 1);
    }

    public void inOrderTraversal(TreeNode node, List<TreeNode> sortedNodes){
        if(node == null){
            return;
        }

        inOrderTraversal(node.left, sortedNodes);
        sortedNodes.add(node);
        inOrderTraversal(node.right, sortedNodes);
    }

    public TreeNode buildBalancedBST(List<TreeNode> sortedNodes, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = sortedNodes.get(mid);
        node.left = buildBalancedBST(sortedNodes, start, mid - 1);
        node.right = buildBalancedBST(sortedNodes, mid + 1, end);

        return node;
    }
}
