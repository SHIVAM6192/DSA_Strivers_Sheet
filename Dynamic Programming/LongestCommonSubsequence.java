// https://leetcode.com/problems/longest-common-subsequence/description/
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int text1Length = text1.length();
        int text2Length = text2.length();
        // construct the dp matrix
        int[][] dp = new int[text1Length + 1][text2Length +1];

        // Iterate over each cell and update the values
        for(int i = 1; i <= text1Length; i++){
            for(int j = 1; j <= text2Length; j++){

                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1Length][text2Length];
    }
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("Longest common subsequence: " + lcs.longestCommonSubsequence(text1, text2));
    }
}
