
// https://leetcode.com/problems/unique-paths/description/
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];

        // Iterate over the grid
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){

                // If we are at the first row or first column,
                // there is only one way to reach that cell
                if (i == 0 || j == 0)
                    grid[i][j] = 1;
                else {
                    // Memorize the number of ways to reach that cell
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }

        // Return the number of ways to reach tha last cell
        return grid[m - 1][n - 1];
    }
}
