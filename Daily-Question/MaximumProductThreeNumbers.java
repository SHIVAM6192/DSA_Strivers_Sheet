import java.util.Arrays;

public class MaximumProductThreeNumbers {
    public static int maximumProduct(int[] nums) {
        int n = nums.length-1;
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[n], nums[n-2]*nums[n-1]*nums[n]);
    }

    public static void main(String[] args) {
        int[] nums = {-4,-3,-2,-1};
        System.out.println(maximumProduct(nums));
    }
}
