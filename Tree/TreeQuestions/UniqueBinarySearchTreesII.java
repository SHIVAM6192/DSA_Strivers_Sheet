package TreeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/unique-binary-search-trees-ii
public class UniqueBinarySearchTreesII {
    List<TreeNode>[][] memo;

    public List<TreeNode> solve(int start, int end){
        List<TreeNode> res = new ArrayList<>();

        if (start > end){
            res.add(null);
            return res;
        }

        if (memo[start][end] != null){
            return memo[start][end];
        }

        // Iterate through all values from start to end to construct left and
        // right subtree recursively.

        for(int i=start; i<=end; i++){
            List<TreeNode> leftSubTree = solve(start, i-1);
            List<TreeNode> rightSubTree = solve(i+1, end);

            // Loop through all the left and right sub tree and connect them to
            // ith root.

            for (TreeNode left : leftSubTree){
                for (TreeNode right : rightSubTree){
                    TreeNode root = new TreeNode(i, left, right);
                    res.add(root);
                }
            }
        }

        memo[start][end] = res;
        return res;
    }


    public List<TreeNode> generateTrees(int n) {
        memo = new ArrayList[n+1][n+1];
        return solve(1, n);
    }

    void displayTrees(List<TreeNode> trees) {

        int count = 1;

        for (TreeNode root : trees) {

            System.out.print("Tree " + count++ + ": ");

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {

                TreeNode node = q.poll();

                if (node == null) {
                    System.out.print("null ");
                    continue;
                }

                System.out.print(node.val + " ");

                q.add(node.left);
                q.add(node.right);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII ubst = new UniqueBinarySearchTreesII();

        int n = 3;
        List<TreeNode> result = ubst.generateTrees(n);

        ubst.displayTrees(result);
    }
}
