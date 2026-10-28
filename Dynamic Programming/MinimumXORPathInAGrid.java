// https://leetcode.com/problems/minimum-xor-path-in-a-grid
public class MinimumXORPathInAGrid {
    static int m, n;
    static int minXor;
    static boolean[][][] visited;

    public static void dfs(int[][] grid, int r, int c, int xor){
        xor ^= grid[r][c];

        if (minXor == 0){
            return;
        }

        if (visited[r][c][xor]){
            return;
        }

        visited[r][c][xor] = true;

        // Destination reached
        if (r == m-1 && c ==n-1){
            minXor = Math.min(minXor, xor);
            return;
        }

        // Move right
        if (c+1 < n){
            dfs(grid, r, c+1, xor);
        }

        // Move Down
        if (r+1 < m){
            dfs(grid, r+1, c, xor);
        }
    }

    public static int minCost(int[][] grid) {
        minXor = 1024;
        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n][1024];

        dfs(grid, 0, 0, 0);
        return minXor;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2},
                {3, 4}
        };

        System.out.println(minCost(grid));
    }
}
