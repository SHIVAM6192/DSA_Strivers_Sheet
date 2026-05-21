package TreeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class BinaryTreeLevelOrderTraversal {
    TreeNode root;

    public BinaryTreeLevelOrderTraversal(){
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

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> current = new ArrayList<>();
            int nodeCount = queue.size();

            for(int i = 0; i < nodeCount; i++){
                root = queue.poll();
                current.add(root.val);

                if(root.left != null){
                    queue.add(root.left);
                }
                if(root.right != null){
                    queue.add(root.right);
                }
            }
            result.add(current);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal lOT = new BinaryTreeInorderTraversal();
        lOT.insert(50);
        lOT.insert(30);
        lOT.insert(20);
        lOT.insert(40);
        lOT.insert(70);
        lOT.insert(60);

        List<List<Integer>> result = levelOrder(lOT.root);
        System.out.println(result.toString());
    }
}
