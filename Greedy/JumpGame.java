// https://leetcode.com/problems/jump-game
public class JumpGame {
    public static boolean canJump(int[] nums) {
        // Initially the final position is last index
        int finalPosition = nums.length - 1;

        // start with the second last index
        for(int idx=nums.length - 2; idx>=0; idx--){
            // If you can reach the final position from its previous
            // means this index then update the final position flag
            if(idx+nums[idx] >= finalPosition){
                finalPosition = idx;
            }
        }

        // if we reach the first index, then we can
        // make the jump possible
        // finalPosition == 0 means we rach to the first index
        // means we can make possible jumps
        return finalPosition == 0;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(canJump(arr));

        int[] arr1 = {3,2,1,0,4};
        System.out.println(canJump(arr1));
    }
}
