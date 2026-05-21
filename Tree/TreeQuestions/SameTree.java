package TreeQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    TreeNode root;

    public SameTree(){
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while(!queue.isEmpty()){
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();

            if(first == null && second == null){
                continue;
            }
            else if(first == null || second == null || first.val != second.val){
                return false;
            }
            queue.add(first.left);
            queue.add(second.left);
            queue.add(first.right);
            queue.add(second.right);
        }

        return true;
    }

    public static void main(String[] args) {
        SameTree st1 = new SameTree();
        st1.insert(50);
        st1.insert(30);
        st1.insert(20);
        st1.insert(40);
        st1.insert(70);
        st1.insert(60);
        st1.insert(80);

        SameTree st2 = new SameTree();
        st2.insert(50);
        st2.insert(30);
        st2.insert(20);
        st2.insert(40);
        st2.insert(70);
        st2.insert(60);
        st2.insert(80);

        System.out.println(st1.isSameTree(st1.root, st2.root));
    }
}
