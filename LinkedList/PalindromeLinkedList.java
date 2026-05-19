// https://leetcode.com/problems/palindrome-linked-list/description/
public class PalindromeLinkedList {
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

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // odd nodes : let right half smaller
        if(fast != null){
            slow = slow.next;
        }

        // Reverse the list from slow to end
        slow = reverseList(slow);
        fast = head; // assign fast back to head to traverse

        while(slow != null){
            if(fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }

        return true;
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
        PalindromeLinkedList pal = new PalindromeLinkedList();

        ListNode list = pal.buildList(new int[]{1, 2, 3, 5, 5, 3, 2, 2});
        pal.printList(list);

        System.out.println("Is linked list palindrom: " +pal.isPalindrome(list));

    }
}
