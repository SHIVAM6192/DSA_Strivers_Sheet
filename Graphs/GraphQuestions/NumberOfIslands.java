package GraphQuestions;

import java.util.Arrays;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int island = 0;
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];
        for (boolean[] row : vis) {
            Arrays.fill(row, false);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, vis, grid, n, m);
                    island++;
                }
            }
        }

        return island;
    }

    public void dfs(int i, int j, boolean[][] vis, char[][] grid, int n, int m) {

        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] != '1') {
            return;
        }

        vis[i][j] = true;

        // Call to neb
        dfs(i - 1, j, vis, grid, n, m); // top
        dfs(i, j + 1, vis, grid, n, m); // right
        dfs(i + 1, j, vis, grid, n, m); // bottom
        dfs(i, j - 1, vis, grid, n, m); // left
    }


    public static void main(String[] args) {
        NumberOfIslands islands = new NumberOfIslands();

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(islands.numIslands(grid));
    }
}
