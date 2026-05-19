public class ReverseLinkedList {

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

    // https://leetcode.com/problems/reverse-linked-list/submissions/
    // google, apple, amazon, microsoft
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }


    public ListNode reverseBetween(ListNode head, int left, int right){
        if(left == right){
            return head;
        }

        // create a dummy node to mark the head of this list
        ListNode dummy = new ListNode();
        dummy.next = head;

        // make markers for currentNode and for the node before reversing
        ListNode leftPrev = dummy;
        ListNode current = head;

        for(int i = 0; i < left - 1; i++){
            leftPrev = leftPrev.next;
            current = current.next;
        }

        // leftPrev -> this will the before node pointer from where we will start reversing
        // current -> this will pointer from where we will start actually reversing the list

        // make a marker to node where we start reversing
        ListNode subListHead = current;

        // Now we will reverse the list
        ListNode preNode = null;
        for (int i = 0; i <= right - left; i++){
            ListNode nextNode = current.next;
            current.next = preNode;
            preNode = current;
            current = nextNode;
        }

        // Join the pieces
        leftPrev.next = preNode;
        subListHead.next = current;

        return dummy.next;
    }


    public static void main(String[] args) {
        ReverseLinkedList rev = new ReverseLinkedList();

        ListNode list = rev.buildList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

//        rev.printList(list);
//        list = rev.reverseList(list);
//        rev.printList(list);

        // left and right are the position between we want to reverse the list
        list = rev.reverseBetween(list, 2, 7);
        rev.printList(list);
    }
}
