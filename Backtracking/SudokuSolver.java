import java.util.Arrays;

// https://leetcode.com/problems/sudoku-solver
public class SudokuSolver {
    public static boolean isValid(char[][] board, int row, int col, char d){
        // Check row and column
        for(int i = 0; i < 9; i++){
            if(board[row][i] == d)
                return false;

            if(board[i][col] == d)
                return false;
        }

        // Check box
        int start_i = row/3 * 3;
        int start_j = col/3 * 3;

        for(int k = 0; k < 3; k++){
            for(int l = 0; l < 3; l++){
                if(board[start_i + k][start_j + l] == d){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){

                    for(char d = '1'; d <= '9'; d++){
                        if(isValid(board, i, j, d)){
                            board[i][j] = d;  // Do

                            if(solve(board)){ // Explore
                                return true;
                            }

                            board[i][j] = '.'; // Undo
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void solveSudoku(char[][] board) {
        solve(board);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(board);

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
