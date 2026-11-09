import java.util.Arrays;

// https://leetcode.com/problems/uncrossed-lines/
public class UncrossedLines {
    static int m, n;
    static int[][] memo;

    public static int solve(int i, int j, int[] nums1, int[] nums2){
        if (i >= m || j >= n)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (nums1[i] == nums2[j]) {
            return memo[i][j] = 1 + solve(i+1, j+1, nums1, nums2);
        }
        else{
            int increaseI = solve(i+1, j, nums1, nums2);
            int increaseJ = solve(i, j+1, nums1, nums2);

            return memo[i][j] = Math.max(increaseI, increaseJ);
        }
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;

        memo = new int[501][501];
        for (int[] arr : memo)
            Arrays.fill(arr, -1);

        return solve(0, 0, nums1, nums2);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,4,2};
        int[] nums2 = {1,2,4};

        System.out.println(maxUncrossedLines(nums1, nums2));
    }
}
