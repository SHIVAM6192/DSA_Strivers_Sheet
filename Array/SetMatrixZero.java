public class SetMatrixZero {
    public static void main(String[] args){
        int[][] matrix = {{0,1,2,9},{3,4,5,2},{1,3,8,5}};
        setZero(matrix);
        for(int[] row : matrix){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void setZero(int[][] matrix){
        // Get dimensions of matrix
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row has any zero
        for(int i = 0; i < n; i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }

        // Check if first column has any zero
        for(int j = 0; j < m; j++){
            if(matrix[j][0] == 0){
                firstColZero = true;
                break;
            }
        }

        // Use first row/column as markers
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set cells to zero based on markers
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        // Zero the first row if needed
        if(firstRowZero){
            for(int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }

        // Zero the first column if needed
        if(firstColZero){
            for(int i = 0; i < m; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
