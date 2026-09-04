package Questions;

// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points
public class DistanceBetweenCriticalPoints {
    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCPI = -1;
        int prevCPI = -1;
        int currentIndex = 1;
        ListNode prev = head;
        ListNode cur = head.next;
        int[] res = new int[2];
        res[0] = Integer.MAX_VALUE;

        while(cur.next != null){
            ListNode nextNode = cur.next;
            if((cur.val < prev.val && cur.val < nextNode.val) ||
                    (cur.val > prev.val && cur.val > nextNode.val)){
                if(prevCPI == -1){
                    firstCPI = currentIndex;
                    prevCPI = currentIndex;
                }
                else{
                    res[0] = Math.min(res[0], currentIndex - prevCPI);
                    prevCPI = currentIndex;
                }
            }
            prev = prev.next;
            cur = cur.next;
            currentIndex++;
        }

        if(firstCPI != -1 && res[0] != Integer.MAX_VALUE)
            res[1] = prevCPI - firstCPI;
        else{
            res[0] = -1;
            res[1] = -1;
        }

        return res;
    }
}
