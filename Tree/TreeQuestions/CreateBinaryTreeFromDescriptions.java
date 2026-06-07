package TreeQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://leetcode.com/problems/create-binary-tree-from-descriptions/description/?envType=daily-question&envId=2026-06-07
public class CreateBinaryTreeFromDescriptions {
    public static void main(String[] args) {

    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<Integer> childNodes = new HashSet<>();
        Map<Integer, TreeNode> map = new HashMap<>();

        for(int i = 0; i < descriptions.length; i++){
            int rootVal = descriptions[i][0];
            int childVal = descriptions[i][1];
            int isLeft = descriptions[i][2];

            map.putIfAbsent(rootVal, new TreeNode(rootVal));
            map.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode rootNode = map.get(rootVal);
            TreeNode childNode = map.get(childVal);


            if(isLeft == 1){
                rootNode.left = childNode;
            }
            else {
                rootNode.right = childNode;
            }

            childNodes.add(childVal);
        }

        for(Map.Entry<Integer, TreeNode> entry : map.entrySet()){
            if(!childNodes.contains(entry.getKey())){
                return entry.getValue();
            }
        }

        return null;
    }
}
