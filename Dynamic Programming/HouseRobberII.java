// https://leetcode.com/problems/house-robber-ii/description/
// The only deference from House Robber is in this question
// the array is circular
public class HouseRobberII {

    public int rob(int[] nums) {
        if(nums.length < 2){
            return nums[0];
        }

        // Create 2 new array
        int[] skippedLastHouse = new int[nums.length - 1];
        int[] skippedFirstHouse = new int[nums.length - 1];

        for(int i = 0; i < nums.length - 1; i++){
            skippedLastHouse[i] = nums[i];
            skippedFirstHouse[i] = nums[i + 1];
        }

        // Get the loot from both possibilities
        int lootSkippedLast = robHelper(skippedLastHouse);
        int lootSkippedFirst = robHelper(skippedFirstHouse);

        // Return max of 2 loots
        return Math.max(lootSkippedFirst, lootSkippedLast);
    }

    public int robHelper(int[] nums){
        if(nums.length < 2){
            return nums[0];
        }
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        HouseRobberII hr = new HouseRobberII();
        System.out.println(hr.rob(arr));
    }
}
