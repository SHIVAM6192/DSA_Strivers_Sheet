package Questions;

// https://leetcode.com/problems/remove-linked-list-elements
public class RemoveLinkedListElements {
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

    public ListNode removeElements(ListNode head, int val) {
       ListNode dummy = new ListNode(-1);
       dummy.next = head;

       ListNode curr = dummy;
       while (curr.next != null){
           if (curr.next.val == val){
               curr.next = curr.next.next;
           }
           else {
               curr = curr.next;
           }
       }

       return dummy.next;
    }
    public static void main(String[] args) {
        RemoveLinkedListElements list = new RemoveLinkedListElements();
        int[] arr = {1,2,6,3,4,5,6};
        ListNode head = list.buildList(arr);
        list.printList(head);
        int val = 6;
        head = list.removeElements(head, val);
        list.printList(head);
    }
}
