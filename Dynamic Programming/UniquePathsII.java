// https://leetcode.com/problems/unique-paths-ii/description/
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {0,0,0},
                {0,0,0}};

        System.out.println(uniquePathsWithObstacles(grid));
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1){
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        // First column
        for (int i = 1; i < m; i++){
            if (obstacleGrid[i][0] == 0){
                dp[i][0] = dp[i - 1][0];
            }
        }

        // First row
        for (int i = 1; i < n; i++){
            if (obstacleGrid[0][i] == 0){
                dp[0][i] = dp[0][i - 1];
            }
        }

        // Remaining cell
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 0){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
