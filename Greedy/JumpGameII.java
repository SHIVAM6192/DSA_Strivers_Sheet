
// https://leetcode.com/problems/jump-game-ii/description
public class JumpGameII {
    public static int jump(int[] nums) {
        int totalJump = 0;

        // destination is last index
        int destination = nums.length - 1;

        int coverage = 0, lastJumpIdx = 0;

        // Base case
        if (nums.length == 1) return 0;

        // Greedy strategy: extend coverage as long as possible
        for (int i = 0; i < nums.length; i++){

            coverage = Math.max(coverage, i + nums[i]);

            if (i == lastJumpIdx){
                lastJumpIdx = coverage;
                totalJump++;

                // check if we reached destination already
                if (coverage >= destination){
                    return totalJump;
                }
            }
        }
        return totalJump;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
