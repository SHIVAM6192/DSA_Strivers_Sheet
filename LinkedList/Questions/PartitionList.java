package Questions;

// https://leetcode.com/problems/partition-list
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);

        ListNode smallPointer = small;
        ListNode largePointer = large;

        while(head != null){
            if(head.val < x){
                smallPointer.next = head;
                smallPointer = smallPointer.next;
            }
            else{
                largePointer.next = head;
                largePointer = largePointer.next;
            }
            head = head.next;
        }

        smallPointer.next = large.next;
        largePointer.next = null;

        return small.next;
    }
}
