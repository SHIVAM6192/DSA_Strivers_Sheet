package GraphQuestions;

// https://leetcode.com/problems/number-of-enclaves
public class NumberOfEnclaves {
    static int m, n;

    public static void dfs(int[][] grid, int r, int c){
        // Check whether the cell is outside the grid
        if (r >= m || r < 0 || c >= n || c < 0 || grid[r][c] == 0)
            return;

        grid[r][c] = 0;

        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
    }

    public static int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;

        // First col and last col
        for (int row=0; row<m; row++){
            // DFS on first col
            if (grid[row][0] == 1)
                dfs(grid, row, 0);

            // DFS on last col
            if (grid[row][n-1] == 1)
                dfs(grid, row, n-1);
        }

        // First row and last row
        for (int col=0; col<n-1; col++){
            if (grid[0][col] == 1)
                dfs(grid, 0, col);
            if (grid[m-1][col] == 1)
                dfs(grid, m-1, col);
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };

        System.out.println(numEnclaves(grid));
    }
}
