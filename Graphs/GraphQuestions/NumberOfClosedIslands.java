package GraphQuestions;

// https://leetcode.com/problems/number-of-closed-islands
public class NumberOfClosedIslands {
    static int m, n;

    public static boolean dfs(int[][] grid, int r, int c){
        if(r >= m || r < 0 || c >= n || c < 0){ // out of bound
            return false;
        }

        if(grid[r][c] == 1){
            return true;
        }

        grid[r][c] = 1;

        boolean left_closed = dfs(grid, r, c-1);
        boolean right_closed = dfs(grid, r, c+1);
        boolean top_closed = dfs(grid, r-1, c);
        boolean bottom_closed = dfs(grid, r+1, c);

        return left_closed && right_closed && top_closed && bottom_closed;
    }

    public static int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    if(dfs(grid, i, j)){
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };

        System.out.println(closedIsland(grid));
    }
}
