import java.util.Arrays;

// https://leetcode.com/problems/01-matrix
public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                result[i][j] = 10000;
            }
        }

        // First pass : left and top
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (mat[i][j] == 0)
                    result[i][j] = 0;
                else {
                    // Top
                    if (i > 0)
                        result[i][j] = Math.min(result[i][j], result[i-1][j]+1);

                    // Left
                    if (j > 0)
                        result[i][j] = Math.min(result[i][j], result[i][j-1]+1);
                }
            }
        }

        // Second pass: right and bottom
        for (int i=rows-1; i>=0; i--){
            for (int j=cols-1; j>=0; j--){
                if (result[i][j] != 0){
                    // Bottom
                    if (i < rows-1){
                        result[i][j] = Math.min(result[i][j], result[i+1][j]+1);
                    }
                    // Right
                    if (j < cols-1){
                        result[i][j] = Math.min(result[i][j], result[i][j+1]+1);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Matrix01 obj = new Matrix01();
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        int[][] result = obj.updateMatrix(mat);

        for (int[] arr : result)
            System.out.println(Arrays.toString(arr));
    }
}
