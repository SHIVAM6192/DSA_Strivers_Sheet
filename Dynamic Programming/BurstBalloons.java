import java.util.Arrays;

// https://leetcode.com/problems/burst-balloons
public class BurstBalloons {
    int n;
    int[][] memo;

    public int solve(int i, int j, int[] nums_){
        if(i > j) return 0;
        if(memo[i][j] != -1){
            return memo[i][j];
        }

        int max = Integer.MIN_VALUE;

        for(int ind = i; ind <= j; ind++){
            int cost = nums_[i-1] * nums_[ind] * nums_[j+1] +
                    solve(i, ind-1, nums_) + solve(ind+1, j, nums_);
            max = Math.max(max, cost);
        }
        System.out.println(" i = " + i + " j= " + j + " cost = " + max);
        return memo[i][j] = max;
    }

    public int maxCoins(int[] nums) {
        n = nums.length;
        // Create new array
        int[] nums_ = new int[n+2];

        // Add 1 at starting of array
        nums_[0] = 1;
        System.arraycopy(nums, 0, nums_, 1, n);

        // Add 1 at the ending of the array
        nums_[nums_.length -1] = 1;

        memo = new int[n+2][n+2];

        for(int[] arr : memo){
            Arrays.fill(arr, -1);
        }

        return solve(1, n, nums_);
    }

    public static void main(String[] args) {
        BurstBalloons bb = new BurstBalloons();

        int[] nums = {3,1,5,8};
        System.out.println(bb.maxCoins(nums));
    }
}
