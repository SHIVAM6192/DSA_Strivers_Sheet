// https://leetcode.com/problems/minimum-moves-to-equal-array-elements
public class MinimumMovesToEqualArrayElements {
    public static int minMoves(int[] nums) {
        int n = nums.length;

        long sum = 0;
        int minEl = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;
            minEl = Math.min(minEl, num);
        }

        return (int) (sum - (long) n * minEl);
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(minMoves(nums));
    }
}
