import java.util.Arrays;

// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array
public class MaximumProductOfTwoElementsInAnArray {
    public static int maxProduct(int[] nums) {
        int n = nums.length - 1;
        Arrays.sort(nums);
        return ((nums[n] - 1) * (nums[n-1] - 1));
    }
    public static void main(String[] args) {
        int[] nums = {3,4,5,2};
        System.out.println(maxProduct(nums));
    }
}
