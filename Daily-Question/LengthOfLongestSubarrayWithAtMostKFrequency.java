import java.util.HashMap;

// https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency
public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public static int maxSubarrayLength(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(end < n){
            // exp
            // include the element in window
            int num = nums[end];
            map.put(num, map.getOrDefault(num, 0) + 1);
            // if window is invalid, then shrink it
            while(map.get(num)>k){
                int startNum = nums[start];
                map.put(startNum, map.get(startNum) - 1);
                start++;
            }

            maxLen = Math.max(maxLen, end - start+1);
            end++;
        }

        return maxLen;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3,1,2};
        int k = 2;
        System.out.println(maxSubarrayLength(nums, k));
    }
}
