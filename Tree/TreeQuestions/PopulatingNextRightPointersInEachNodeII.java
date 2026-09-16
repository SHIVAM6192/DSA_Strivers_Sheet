package TreeQuestions;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii
public class PopulatingNextRightPointersInEachNodeII {
    public TreeNode connect(TreeNode root) {
        TreeNode newRoot = root;

        while(root != null){
            TreeNode dummy = new TreeNode(0);
            TreeNode temp = dummy;

            while(root != null){
                if(root.left != null){
                    dummy.next = root.left;
                    dummy = dummy.next;
                }
                if(root.right != null){
                    dummy.next = root.right;
                    dummy = dummy.next;
                }
                root = root.next;
            }
            root = temp.next;
        }
        return newRoot;
    }
}
