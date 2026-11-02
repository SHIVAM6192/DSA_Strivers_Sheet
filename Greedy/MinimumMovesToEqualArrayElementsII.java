import java.util.Arrays;

// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
public class MinimumMovesToEqualArrayElementsII {
    public static int minMoves2(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int mid = nums[n/2];

        int moves = 0;
        for(int i=0; i<n/2; i++){
            moves += Math.abs(mid - nums[i]);
            moves += Math.abs(mid - nums[n - i - 1]);
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] nums = {1,10,2,9};
        System.out.println(minMoves2(nums));
    }
}
