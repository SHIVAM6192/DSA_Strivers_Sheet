import java.util.Arrays;

// https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings
public class MaximumNumberOfNonOverlappingPalindromeSubstrings {
    static int n;
    static boolean[][] isPalindrome;

    public static int solve(String s, int k, int i, int j, int[][] t){
        if(i>=n || j>=n)  return 0;

        if(t[i][j] != -1){
            return t[i][j];
        }

        if(isPalindrome[i][j]){
            int take = 1 + solve(s, k, j+1, j+k, t);
            int grow = solve(s, k, i, j+1, t);
            int slide = solve(s, k, i+1, j+1, t);

            return t[i][j] = Math.max(take, Math.max(grow, slide));
        }

        int grow = solve(s, k, i, j+1, t);
        int slide = solve(s, k, i+1, j+1, t);

        return t[i][j] = Math.max(grow, slide);
    }

    public static int maxPalindromes(String s, int k) {
        n = s.length();
        if(k == 1){
            return n;
        }

        isPalindrome = new boolean[n+1][n+1];
        // Find all palindromic string in O(N) time to improve the performance
        for(int L=1; L<=n; L++){
            for(int i=0; i+L<=n; i++){
                int j = i+L-1;

                if(i == j){
                    isPalindrome[i][j] = true;
                }
                else if(i+1 == j){
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else{
                    isPalindrome[i][j] = ((s.charAt(i) == s.charAt(j)) &&
                            isPalindrome[i+1][j-1]);
                }
            }
        }

        int[][] t = new int[n+1][n+1];
        for(int i=0; i<=n; i++)
            Arrays.fill(t[i], -1);

        return solve(s, k, 0, k-1, t);
    }
    public static void main(String[] args) {
        String s = "abaccdbbd";
        int k = 3;
        System.out.println(maxPalindromes(s, k));
    }
}
