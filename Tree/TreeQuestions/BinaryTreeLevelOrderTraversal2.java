package TreeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/?envType=problem-list-v2&envId=breadth-first-search
public class BinaryTreeLevelOrderTraversal2 {
    TreeNode root;

    public BinaryTreeLevelOrderTraversal2(){
        this.root = null;
    }
    public void insert(int val){
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode current, int val) {
        if(current == null){
            return new TreeNode(val);
        }
        if(val < current.val){
            current.left = insertRecursive(current.left, val);
        }
        else if(val > current.val){
            current.right = insertRecursive(current.right, val);
        }
        return current;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List result = new ArrayList();

        if (root == null){
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size = q.size();
            // Create a list and add the node value in that by level
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                level.add(node.val);

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            result.add(0, level); // We need to add at first of result
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
