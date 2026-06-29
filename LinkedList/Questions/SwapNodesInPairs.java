package Questions;

// https://leetcode.com/problems/swap-nodes-in-pairs
public class SwapNodesInPairs {
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

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode point = dummy;

        // Ensure nodes we are swaping are not null
        while(point.next != null && point.next.next != null){

            // Identify nodes to swap
            ListNode swap1 = point.next;
            ListNode swap2 = point.next.next;

            // Actually swap
            swap1.next = swap2.next;
            swap2.next = swap1;

            // Prepare for next
            point.next = swap2;
            point = swap1;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapPairNode = new SwapNodesInPairs();
        int[] arr = {1,2,3,4};

        ListNode head = swapPairNode.buildList(arr);
        ListNode newHead = swapPairNode.swapPairs(head);
        swapPairNode.printList(newHead);
    }
}
