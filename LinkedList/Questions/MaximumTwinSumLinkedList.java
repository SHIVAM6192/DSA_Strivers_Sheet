package Questions;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description/
/*
* In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
The twin sum is defined as the sum of a node and its twin.

Given the head of a linked list with even length, return the maximum twin sum of the linked list.
*
* Input: head = [5,4,2,1]
Output: 6
Explanation:
Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
There are no other nodes with twins in the linked list.
Thus, the maximum twin sum of the linked list is 6.
* */
public class MaximumTwinSumLinkedList {
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

    public int pairSum(ListNode head) {
        ListNode p1 = head;
        ListNode mid = findMiddle(head);
        ListNode p2 = reverseList(mid);

        int max = Integer.MIN_VALUE;

        while (p1 != null && p2 != null){
            int current = p1.val + p2.val;
            max = Math.max(max, current);
            p1 = p1.next;
            p2 = p2.next;
        }
        return max;
    }

    public ListNode findMiddle(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head){
        if (head == null){
            return head;
        }

        ListNode prev = null;
        ListNode present = head;
        ListNode next = head.next;

        while (present != null){
            present.next = prev;
            prev = present;
            present = next;
            if (next != null){
                next = next.next;
            }
        }
        return prev;
    }


    public static void main(String[] args) {
        MaximumTwinSumLinkedList obj = new MaximumTwinSumLinkedList();

        ListNode head = obj.buildList(new int[]{47,22,81,46,94,95,90,22,55,91,6,83,49,65,10,32,41,26,83,99,14,85,42,99,89,69,30,92,32,74,9,81,5,9});

//        ListNode mid = obj.findMiddle(head);
//        System.out.println(mid.val);

        int maxTwin = obj.pairSum(head);
        System.out.println(maxTwin);
    }
}
