// https://leetcode.com/problems/edit-distance/description/
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Construct the dp matrix
        int[][] dp = new int[m + 1][n + 1];

        // We are here finding the minimum number of operation to match strings
        // that's why we initialize the dp matrix first row and first column
        // row
        for (int i = 1; i <= m; i++)  dp[i][0] = i;
        // column
        for (int j = 1; j <= n; j++)  dp[0][j] = j;

        // Iterate over matrix and strings
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    int digonalLeft = dp[i - 1][j - 1];
                    int left = dp[i][j - 1];
                    int top = dp[i - 1][j];

                    dp[i][j] = 1 + Math.min(digonalLeft, Math.min(left, top));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";

        EditDistance ed = new EditDistance();
        System.out.println("Minimum operations: " + ed.minDistance(word1, word2));
    }
}
