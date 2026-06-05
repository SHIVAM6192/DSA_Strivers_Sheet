
// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
public class FlattenAMultilevelDoublyLL {
    public static void main(String[] args) {

    }

    public MLNode flatten(MLNode head) {
        if(head == null) return head;

        MLNode current = head;

        while (current != null){
            if(current.child != null){
                MLNode next = current.next;
                current.next = flatten(current.child);
                current.next.prev = current;
                current.child = null;

                while (current.next != null){
                    current = current.next;
                }

                if (next != null){
                    current.next = next;
                    next.prev = current;
                }
            }
            current = current.next;
        }

        return head;
    }
}

class MLNode {
    public int val;
    public MLNode prev;
    public MLNode next;
    public MLNode child;
}
