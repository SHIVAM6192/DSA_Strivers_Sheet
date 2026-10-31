// https://leetcode.com/problems/twisted-mirror-path-count
public class TwistedMirrorPathCount {
    int LEFT = 0; // Arrived at current cell from left cell (it means it was moving right)
    int UP = 1; // Arrived at current cell from up cell (it means it was moving down)
    int MOD = 1_000_000_007;
    int m;  // rows
    int n;  // cols

    //Recursion Memo
    //T.C : O(m*n)
    //S.C : O(m*n)

    int solve(int[][] grid, int i, int j, int cameFrom, int[][][] t){
        if(i >= m || j >= n){
            return 0;
        }

        if(i == m-1 && j == n-1)
            return 1;

        if(t[i][j][cameFrom] != -1)
            return t[i][j][cameFrom];

        if(grid[i][j] == 1){  // Mirror
            if(cameFrom == LEFT){
                return t[i][j][cameFrom] = solve(grid, i+1, j, UP, t);
            }
            else{
                return t[i][j][cameFrom] = solve(grid, i, j+1, LEFT, t);
            }
        }

        int totalPathCount = 0;
        totalPathCount = (totalPathCount + solve(grid, i, j+1, LEFT, t)) % MOD;
        totalPathCount = (totalPathCount + solve(grid, i+1, j, UP, t)) % MOD;

        return t[i][j][cameFrom] = totalPathCount;
    }

    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // t[i][j][LEFT / UP] = -1 initially
        int[][][] t = new int[m][n][2];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                t[i][j][0] = -1;
                t[i][j][1] = -1;
            }
        }

        return solve(grid, 0, 0, LEFT, t);
    }

    public static void main(String[] args) {
        TwistedMirrorPathCount obj = new TwistedMirrorPathCount();
        int[][] grid = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}
        };

        System.out.println(obj.uniquePaths(grid));
    }
}
