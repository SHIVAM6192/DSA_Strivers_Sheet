// https://leetcode.com/problems/minimum-falling-path-sum
public class MinimumFallingPathSum {
    static int minSum;
    static int n;
    static Integer[][] memo;


//    // Simple recursion technique
//    public static void solve(int[][] matrix, int r, int c, int sum){
//        sum += matrix[r][c];
//
//        if (r == n-1)
//            minSum = Math.min(minSum, sum);
//
//        // Bottom left
//        if (r+1 < n && c-1 >= 0){
//            solve(matrix, r+1, c-1, sum);
//        }
//
//        // Bottom
//        if (r+1 < n){
//            solve(matrix, r+1, c, sum);
//        }
//
//        // Bottom right
//        if (r+1 < n && c+1 < n){
//            solve(matrix, r+1, c+1, sum);
//        }
//    }
//
//    public static int minFallingPathSum(int[][] matrix) {
//        n = matrix.length;
//
//        minSum = Integer.MAX_VALUE;
//        for (int i=0; i<n; i++){
//            solve(matrix, 0, i, 0);
//        }
//        return minSum;
//    }

    // DFS
    public static int dfs(int[][] matrix, int r, int c){
        // Check column
        if (c < 0 || c >= n){
            return 1_000_000;
        }

        // Reached at last row
        if (r == n-1){
            return matrix[r][c];
        }

        // Return the previously calculated answer
        if (memo[r][c] != null){
            return memo[r][c];
        }

        int left = dfs(matrix, r+1, c-1);
        int down = dfs(matrix, r+1, c);
        int right = dfs(matrix, r+1, c+1);

        memo[r][c] = matrix[r][c] +
                Math.min(left, Math.min(down, right));

        return memo[r][c];
    }

    // DFS + Memorization
    public static int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        memo = new Integer[n][n];
        minSum = Integer.MAX_VALUE;

        // Call for all values in first row
        for (int c=0; c<n; c++){
            int sum = dfs(matrix, 0, c);
            minSum = Math.min(minSum, sum);
        }

        return minSum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        System.out.println(minFallingPathSum(matrix));
    }
}
