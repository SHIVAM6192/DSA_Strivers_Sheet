// https://leetcode.com/problems/minimum-size-subarray-sum
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int i=0, j=0;
        int n = nums.length;
        int sum = 0;
        int minL = Integer.MAX_VALUE;

        while (j < n){
            sum += nums[j];
            while (sum >= target){
                minL = Math.min(minL, j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }

        return minL == Integer.MAX_VALUE ? 0 : minL;
    }
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(target, nums));
    }
}
