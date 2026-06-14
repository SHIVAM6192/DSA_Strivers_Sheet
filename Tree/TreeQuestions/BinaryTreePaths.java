package TreeQuestions;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-tree-paths/description/?envType=problem-list-v2&envId=depth-first-search
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        String path = root.val + "";
        allPaths(root, "", res);

        return res;
    }

    public void allPaths(TreeNode node, String path, List<String> res){
        if (node.left == null && node.right == null){ // Leaf node
            res.add(path);
            return;
        }

        if (node.left != null){
            allPaths(node.left, path + "->" + node.left.val, res);
        }

        if (node.right != null){
            allPaths(node.right, path + "->" + node.right.val, res);
        }
    }


    public static void main(String[] args) {

    }


}
