package ArrayQuestions;

// https://leetcode.com/problems/create-grid-with-exactly-one-path
public class CreateGridWithExactlyOnePath {
    public static String[] createGrid(int m, int n) {
        String[] grid = new String[m];

        for(int i=0; i<m; i++){
            char[] row = new char[n];
            for (int j=0; j<n; j++){
                if (i == 0 || j == n-1){
                    row[j] = '.';
                }
                else {
                    row[j] = '#';
                }
            }
            grid[i] = new String(row);
        }

        return grid;
    }

    public static void main(String[] args) {
        int m=3, n=3;
        String[] result = createGrid(m,n);
        for (String s : result){
            System.out.println(s + "  ");
        }
    }
}
