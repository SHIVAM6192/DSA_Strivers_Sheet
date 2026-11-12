package ArrayQuestions;

// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray
public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public static int longestMonotonicSubarray(int[] nums) {
        int result = 1;
        int incr = 1;
        int decr = 1;

        for (int i=1; i<nums.length; i++){
            if (nums[i-1] < nums[i]){
                incr++;
                decr = 1;
                result = Math.max(result, incr);
            } else if (nums[i-1] > nums[i]) {
                decr++;
                incr = 1;
                result = Math.max(result, decr);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,3,2};
        System.out.println(longestMonotonicSubarray(nums));
    }
}
