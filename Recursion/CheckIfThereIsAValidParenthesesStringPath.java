import java.util.Arrays;
// https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path
public class CheckIfThereIsAValidParenthesesStringPath {
    static int m, n;
    static int[][][] t;

    public static boolean solve(int i, int j, int openCount, char[][] grid){

        openCount += grid[i][j] == '(' ? 1 : -1;

        if(openCount < 0)
            return false;

        if(t[i][j][openCount] != -1)
            return t[i][j][openCount] == 1;

        // Destination
        if(i == m-1 && j == n-1){
            if (openCount == 0) {
                t[i][j][openCount] = 1;
                return true;
            } else {
                t[i][j][openCount] = 0;
                return false;
            }
        }

        // Down
        if(i+1 < m){
            if(solve(i+1, j, openCount, grid)){
                t[i][j][openCount] = 1;
                return true;
            }
        }

        // Right
        if(j+1 < n){
            if(solve(i, j+1, openCount, grid)){
                t[i][j][openCount] = 1;
                return true;
            }
        }

        // Calculated and false
        t[i][j][openCount] = 0;
        return false;
    }

    public static boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if(grid[0][0] == ')' || grid[m-1][n-1] == '(')
            return false;

        // If the length from grid[0][0] to grid[m][n] is odd then it
        // will never be the balanced
        if((m+n-1) % 2 == 1)
            return false;

        t = new int[101][101][201];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }

        return solve(0, 0, 0, grid);
    }
    public static void main(String[] args) {
        char[][] grid = {
                {'(', '(', '('},
                {')', '(', ')'},
                {'(', '(', ')'},
                {'(', '(', ')'}
        };
        System.out.println(hasValidPath(grid));

        char[][] grid1 = {
                {')', ')'},
                {'(', '('}
        };

        System.out.println(hasValidPath(grid1));
    }
}
