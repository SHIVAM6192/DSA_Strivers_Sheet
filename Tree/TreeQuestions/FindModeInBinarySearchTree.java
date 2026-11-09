package TreeQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-mode-in-binary-search-tree/
public class FindModeInBinarySearchTree {
    static int currNum;
    static int currFreq;
    static int maxFreq;
    static List<Integer> result = new ArrayList<>();

    public static void dfs(TreeNode root){
        if (root == null)
            return;

        dfs(root.left);

        if (root.val == currNum){
            currFreq++;
        }
        else {
            currNum = root.val;
            currFreq = 1;
        }

        if (currFreq > maxFreq){
            result.clear();
            maxFreq = currFreq;
        }

        if (maxFreq == currFreq){
            result.add(root.val);
        }

        dfs(root.right);
    }

    public static int[] findMode(TreeNode root) {
        dfs(root);

        int[] resultArray = new int[result.size()];

        for (int i=0; i<result.size(); i++){
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        root.right = node1;

        TreeNode node3 = new TreeNode(1);
        root.left = node3;

        node1.right = new TreeNode(3);

        int[] result = findMode(root);
        System.out.println(Arrays.toString(result));
    }
}
