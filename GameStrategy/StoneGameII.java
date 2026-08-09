import java.util.Arrays;

// https://leetcode.com/problems/stone-game-ii
public class StoneGameII {
    // dp[i][M][turn]
    // i    = current index in piles
    // M    = current maximum allowed number of piles
    // turn = 0 -> Alice's turn (maximize)
    //        1 -> Bob's turn (minimize)
    static int[][][] dp = new int[101][201][2];

    static int solve(int i, int M, int turn, int[] piles) {
        int n = piles.length;

        // If we have reached the end of the piles
        if (i == n){
            return 0;
        }

        // If this state has already been calculated
        if (dp[i][M][turn] != -1){
            return dp[i][M][turn];
        }

        // Alice's turn -> maximize the number of stones
        if (turn == 0){
            int max = 0;
            int sum = 0;

            // Alice can take from 1 to 2*M piles
            for (int x = 1; x <= 2 * M; x++){
                // Not enough piles remaining
                if (i + x - 1 >= n){
                    break;
                }

                // Add the current pile
                sum += piles[i + x - 1];

                // After Alice takes x piles:
                // next player gets the turn
                // M becomes max(M, x)
                int value = solve(i+x, Math.max(M,x), 1 - turn, piles);

                // Total stones Alice can get
                max = Math.max(max, sum + value);
            }
            dp[i][M][turn] = max;
            return max;
        }
        // Bob's turn -> minimize Alice's final result
        int min = Integer.MAX_VALUE;

        // Bob can take from 1 to 2*M piles
        for (int x = 1; x <= 2 * M; x++) {

            // Not enough piles remaining
            if (i + x - 1 >= n) {
                break;
            }

            int value = solve(
                    i + x,
                    Math.max(M, x),
                    1 - turn,
                    piles
            );

            // Bob chooses the option that gives
            // Alice the minimum result
            min = Math.min(min, value);
        }

        dp[i][M][turn] = min;
        return min;
    }

    public static int stoneGameII(int[] piles) {

        // Fill DP array with -1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Start from index 0, M = 1
        // turn = 0 means Alice starts
        return solve(0, 1, 0, piles);
    }

    public static void main(String[] args) {
        int[] piles = {2,7,9,4,4};
        System.out.println(stoneGameII(piles));
    }
}
