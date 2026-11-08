package ArrayQuestions;

// https://leetcode.com/problems/count-servers-that-communicate
public class CountServersThatCommunicate {

    // Brute Force approach
//    public static int countServers(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int count = 0;
//
//        for (int i=0; i<m; i++){
//            for (int j=0; j<n; j++){
//                if (grid[i][j] == 1){
//                    boolean hasServer = false;
//
//                    // Check in row that server present
//                    for (int col=0; col<n; col++){
//                        if (grid[i][col] == 1 && col != j){
//                            hasServer = true;
//                            break;
//                        }
//                    }
//
//                    if (hasServer){
//                        count++;
//                        continue;
//                    }
//
//                    // Check in col that server present
//                    for (int row=0; row<m; row++){
//                        if (grid[row][j] == 1 && row != i){
//                            hasServer = true;
//                            break;
//                        }
//                    }
//
//                    if (hasServer)
//                        count++;
//                }
//            }
//        }
//
//        return count;
//    }

    // Optimal Approach
    public static int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        int[] indexRowCount = new int[m];
        int[] indexColCount = new int[n];

        for (int r=0; r<m; r++){
            for (int c=0; c<n; c++){
                if (grid[r][c] == 1){
                    indexRowCount[r] += 1;
                    indexColCount[c] += 1;
                }
            }
        }

        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == 1){
                    if (indexRowCount[i] > 1 || indexColCount[j] > 1)
                        count++;
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(countServers(grid));
    }
}
