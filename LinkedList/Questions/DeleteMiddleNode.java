package Questions;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description
public class DeleteMiddleNode {
    public ListNode buildList(int[] values) {
        if (values == null || values.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Prints the linked list
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode prev = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;

        return head;
    }

    public static void main(String[] args) {
        DeleteMiddleNode deleteMiddleNode = new DeleteMiddleNode();

        int[] items = {1,3,4,7,1,2,6};
        ListNode head = deleteMiddleNode.buildList(items);

        deleteMiddleNode.printList(head);
        deleteMiddleNode.deleteMiddle(head);
        System.out.println("After deleting middle node");
        deleteMiddleNode.printList(head);
    }
}
