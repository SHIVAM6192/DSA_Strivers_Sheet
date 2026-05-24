// https://leetcode.com/problems/house-robber/description/
public class HouseRobber {
    public int rob(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }

        // Create array to store maximum loot at each index
        int[] dp = new int[nums.length];

        // Memorize maximum loot at first 2 indexes
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Use memorization to fill remaining array
        for(int i = 2; i < nums.length; i++){
            // Core logic
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {0,0};
        HouseRobber hr = new HouseRobber();

        System.out.println(hr.rob(arr));
    }
}
