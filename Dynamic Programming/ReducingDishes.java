import java.util.Arrays;

// https://leetcode.com/problems/reducing-dishes
public class ReducingDishes {
    static int n;
    static int[][] dp;

    public static int solve(int[] satisfaction, int i, int t){
        if (i >= n)
            return 0;

        if (dp[i][t] != -1)
            return dp[i][t];

        int include = satisfaction[i]*t + solve(satisfaction, i+1, t+1);
        int exclude = solve(satisfaction, i+1, t);

        return dp[i][t] = Math.max(include, exclude);
    }
    public static int maxSatisfaction(int[] satisfaction) {
        n = satisfaction.length;
        Arrays.sort(satisfaction);
        dp = new int[501][501];

        for (int[] arr : dp)
            Arrays.fill(arr, -1);

        return solve(satisfaction, 0, 1);
    }

    public static void main(String[] args) {
        int[] satisfaction = {-1,-8,0,5,-9};

        System.out.println(maxSatisfaction(satisfaction));
    }
}
