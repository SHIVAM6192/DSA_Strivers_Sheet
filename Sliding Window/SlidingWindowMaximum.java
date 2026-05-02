import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] outArr = maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(outArr));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n - k + 1];

        for(int i = 0; i < k; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        result[0] = nums[dq.peekFirst()];

        for(int i = k; i < n; i++){
            if(dq.peekFirst() <= i - k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            result[i - k + 1] = nums[dq.peekFirst()];
        }

        return result;
    }

    // Brute force approach
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        int size = n - (k - 1);
//        int[] out = new int[size];
//        for(int i = 0; i < size; i++){
//            int max = 0;
//            for(int j = i; j < i + k; j++){
//                max = Math.max(max, nums[j]);
//            }
//            out[i] = max;
//        }
//        return out;
//    }
}
