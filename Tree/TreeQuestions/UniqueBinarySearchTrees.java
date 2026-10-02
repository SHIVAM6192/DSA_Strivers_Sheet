package TreeQuestions;

import java.util.Arrays;

// https://leetcode.com/problems/unique-binary-search-trees
public class UniqueBinarySearchTrees {
    // To find the number of unique BST, We consider every number from 1 to n as root number
    // once and calculate there posible left subTree and right subTree count and multiply them

    int[] dp;  // DP array for memorization

    // Recursive solve function
    public int solve(int n){
        if (n <= 1)
            return 1;

        if (dp[n] != -1)
            return dp[n];

        int ans = 0;
        for (int i=1; i<=n; i++){
            // Left subTree count => solve(i-1), Right subTree count => solve(n-i)
            ans += solve(i-1) * solve(n-i);
        }

        return dp[n] = ans;
    }

    public int numTrees(int n) {
        dp = new int[n+1];
        Arrays.fill(dp, -1); // fill dp array with -1
        return solve(n);
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();
        int n = 3;
        System.out.println(ubst.numTrees(n));
    }
}
