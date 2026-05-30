package TreeQuestions;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
public class MaximumDepthOfBinaryTree {
    TreeNode root;

    public MaximumDepthOfBinaryTree(){
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


    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int numberOfLevel = 0;

        while(true){
            // Maintain a count of node at each level
            int nodeCountAtLevel = queue.size();
            if(nodeCountAtLevel == 0){
                // If we found no node at level, it means tree has ended, so return
                return numberOfLevel;
            }

            // Deque all the node present a particular level and add it to queue
            while(nodeCountAtLevel > 0){
                TreeNode node = queue.poll();

                if(node != null && node.left != null){
                    queue.add(node.left);
                }
                if(node != null && node.right != null){
                    queue.add(node.right);
                }
                nodeCountAtLevel--;
            }
            numberOfLevel++;
        }

    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree maxDepthOfTree = new MaximumDepthOfBinaryTree();
        maxDepthOfTree.insert(50);
        maxDepthOfTree.insert(30);
        maxDepthOfTree.insert(20);
        maxDepthOfTree.insert(40);
        maxDepthOfTree.insert(70);
        maxDepthOfTree.insert(60);

        System.out.println(maxDepthOfTree.maxDepth(maxDepthOfTree.root));
    }
}
