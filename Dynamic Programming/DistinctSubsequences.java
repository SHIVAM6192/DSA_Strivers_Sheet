import java.util.Arrays;

// https://leetcode.com/problems/distinct-subsequences
public class DistinctSubsequences {
    static int[][] dp = new int[1001][1001];
    public static int  solve(int i, int j, String s, String t){
        if(j == t.length()){
            return 1;
        }
        if(i>= s.length()){
            return 0;
        }
        if (dp[i][j] != -1){
            return dp[i][j];
        }
        int curr = 0;
        if (s.charAt(i) == t.charAt(j)){
            curr += solve(i+1, j+1, s, t);
        }
        curr += solve(i+1, j, s, t);
        return dp[i][j] = curr;
    }
    public static int numDistinct(String s, String t) {
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 0, s, t);
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";
        System.out.println("Number of distinct subsequence : " + numDistinct(s, t));
    }
}
