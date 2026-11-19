package ArrayQuestions;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-score-by-changing-two-elements
public class MinimumScoreByChangingTwoElements {
    public static int minimizeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int case1 = Math.abs(nums[n-3] - nums[0]);
        int case2 = Math.abs(nums[n-2] - nums[1]);
        int case3 = Math.abs(nums[n-1] - nums[2]);

        return Math.min(case1, Math.min(case2, case3));
    }

    public static void main(String[] args) {
        int[] nums = {1,4,7,8,5};
        System.out.println(minimizeSum(nums));
    }
}
