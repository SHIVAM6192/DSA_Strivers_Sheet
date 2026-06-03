package TreeQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            int lastValue = 0;

            for (int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                lastValue = node.val;

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            result.add(lastValue);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
