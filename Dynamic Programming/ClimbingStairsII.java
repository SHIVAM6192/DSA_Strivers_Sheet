public class ClimbingStairsII {
    // int[] memo;

    // public int solve(int i, int n, int[] costs){
    //     if(i == n)
    //         return 0;

    //     if(memo[i] != -1){
    //         return memo[i];
    //     }

    //     int j = i+1;
    //     int cost = Integer.MAX_VALUE;
    //     if(j <= n){
    //         cost = (costs[j-1] + (j - i) * (j - i)) + solve(j, n, costs);
    //     }

    //     j = i+2;
    //     if(j <= n){
    //         cost = Math.min(cost, (costs[j-1] + (j - i) * (j - i)) + solve(j, n, costs));
    //     }

    //     j = i+3;
    //     if(j <= n){
    //         cost = Math.min(cost, (costs[j-1] + (j - i) * (j - i)) + solve(j, n, costs));
    //     }

    //     return memo[i] = cost;
    // }
    // public int climbStairs(int n, int[] costs) {
    //     memo = new int[n+1];
    //     Arrays.fill(memo, -1);
    //     return solve(0, n, costs);
    // }

    public static int climbStairs(int n, int[] costs) {
        int[] dp = new int[n+1];

        for(int i=n-1; i>=0; i--){
            int cost = Integer.MAX_VALUE;

            int j = i+1;
            if(j <= n)
                cost = dp[j] + costs[j-1] + (j-i) * (j-i);

            j = i+2;
            if(j <= n)
                cost = Math.min(cost, dp[j] + costs[j-1] + (j-i) * (j-i));

            j = i+3;
            if(j <= n)
                cost = Math.min(cost, dp[j] + costs[j-1] + (j-i) * (j-i));

            dp[i] = cost;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int n = 4;
        int[] costs = {5,1,6,2};
        System.out.println(climbStairs(n, costs));
    }
}
