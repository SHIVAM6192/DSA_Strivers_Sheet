import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/n-queens
public class NQueens {
    static boolean isSafe(List<StringBuilder> board, int row, int col, int n){
        // Check horizontally
        for(int j = 0; j<n; j++){
            if(board.get(row).charAt(j) == 'Q'){
                return false;
            }
        }

        // vertical
        for(int i = 0; i<n; i++){
            if(board.get(i).charAt(col) == 'Q'){
                return false;
            }
        }

        // left diagonal
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        // right diagonal
        for(int i=row, j=col; i>=0 && j<n; i--, j++){
            if(board.get(i).charAt(j) == 'Q'){
                return false;
            }
        }

        return true;
    }

    static void nQueens(List<StringBuilder> board, int row, int n, List<List<String>> ans){
        if(row == n){
            List<String> result = new ArrayList<>();

            for (StringBuilder s : board) {
                result.add(s.toString());
            }

            ans.add(result);
            return;
        }

        for(int j = 0; j<n; j++){
            if(isSafe(board, row, j, n)){
                board.get(row).setCharAt(j, 'Q');
                nQueens(board, row+1, n, ans);
                board.get(row).setCharAt(j, '.');
            }
        }
    }



    public static List<List<String>> solveNQueens(int n) {
        List<StringBuilder> board = new ArrayList<>();
        // Create a row string with 'n' dots
        char[] dots = new char[n];
        Arrays.fill(dots, '.');
        String rowString = new String(dots);

        for(int i=0; i<n; i++){
            board.add(new StringBuilder(rowString));
        }
        List<List<String>> ans = new ArrayList<>();

        nQueens(board, 0, n, ans);

        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
}
