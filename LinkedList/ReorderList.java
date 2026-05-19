// https://leetcode.com/problems/reorder-list/description/
public class ReorderList {
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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Split the list into two halves and reverse the second half
        ListNode secondHalf = slow.next;
        slow.next = null; // CRITICAL: Break the link to prevent cycles!
        secondHalf = reverseList(secondHalf); // Reuse your existing helper method

        // Step 3: Merge the two halves alternately
        ListNode firstHalf = head;
        while (secondHalf != null) {
            // Save the next nodes
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            // Link the first half to the second half
            firstHalf.next = secondHalf;
            // Link the second half back to the first half's next node
            secondHalf.next = temp1;

            // Move pointers forward
            firstHalf = temp1;
            secondHalf = temp2;
        }

    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ReorderList pal = new ReorderList();

        ListNode list = pal.buildList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        pal.printList(list);

        pal.reorderList(list);
        pal.printList(list);
    }
}
