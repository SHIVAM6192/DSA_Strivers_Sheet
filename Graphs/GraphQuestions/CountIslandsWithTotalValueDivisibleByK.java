package GraphQuestions;

// https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k
public class CountIslandsWithTotalValueDivisibleByK {
    static int m, n;
    static int count;

    public static long dfs(int[][] grid, int r, int c){
        if(r >= m || r < 0 || c >= n || c < 0){ // out of bound
            return 0;
        }

        if(grid[r][c] == 0){
            return 0;
        }

        long  sum = grid[r][c];
        grid[r][c] = 0;


        sum += dfs(grid, r, c-1);
        sum += dfs(grid, r, c+1);
        sum +=  dfs(grid, r-1, c);
        sum +=  dfs(grid, r+1, c);

        return sum;
    }

    public static int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        count = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] > 0){
                    long valueCount = dfs(grid, i, j);
                    if (valueCount % k ==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 2, 1, 0, 0},
                {0, 5, 0, 0, 5},
                {0, 0, 1, 0, 0},
                {0, 1, 4, 7, 0},
                {0, 2, 0, 0, 8}
        };

        int k=5;

        System.out.println(countIslands(grid, k));

        int[][] grid2 = {
                {3, 0, 3, 0},
                {0, 3, 0, 3},
                {3, 0, 3, 0}
        };
        int k2 = 3;

        System.out.println(countIslands(grid2, k2));

        int[][] grid3 = {
                {0, 0, 9, 19, 0, 0},
                {15, 0, 9, 0, 0, 0},
                {0, 0, 2, 1, 0, 0},
                {12, 0, 0, 0, 0, 11},
                {0, 12, 0, 0, 0, 0},
                {12, 0, 0, 0, 0, 1}
        };

        int k3 =1;
        System.out.println(countIslands(grid3, k3));
    }
}
