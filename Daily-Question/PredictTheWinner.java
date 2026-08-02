import java.util.Arrays;

// https://leetcode.com/problems/predict-the-winner
public class PredictTheWinner {
    static int[][] dp = new int[23][23];
    public static int score(int i, int j, int[] nums){
        if (i > j)
            return 0;

        if (i == j)
            return nums[i];

        if (dp[i][j] != -1)
            return dp[i][j];

        int take_i = nums[i] +
                Math.min(score(i+2, j, nums),
                        score(i+1, j-1, nums));

        int take_j = nums[j] +
                Math.min(score(i, j-2, nums),
                        score(i+1, j-1, nums));

        return Math.max(take_i, take_j);
    }
    public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int total_score = 0;
        for (int num : nums) {
            total_score += num;
        }

        for (int i = 0; i < 23; i++) {
            Arrays.fill(dp[i], -1);
        }

        int player1 = score(0, n-1, nums);
        int player2 = total_score - player1;

        return player1 >= player2;
    }
    public static void main(String[] args) {
        int[] nums = {1,5,233,7};
        System.out.println(predictTheWinner(nums));
    }
}
