import java.util.Arrays;

public class StoneGame {
    public static int[][] dp = new int[501][501];

    public static int stoneCount(int i, int j, int[] piles){
        if (i > j)
            return 0;
        if (i == j)
            return piles[i];

        if (dp[i][j] != -1)
            return dp[i][j];

        int take_i = piles[i] +
                Math.max(stoneCount(i+2, j, piles), stoneCount(i+1, j-1, piles));

        int take_j = piles[j] +
                Math.max(stoneCount(i+1, j, piles), stoneCount(i, j-2, piles));

        return dp[i][j] = Math.max(take_i, take_j);
    }
    public static boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total_stone = 0;

        for (int s : piles)
            total_stone += s;

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        int alice_stone_count = stoneCount(0, n-1, piles);
        int bob_stone_count = total_stone - alice_stone_count;

        return alice_stone_count > bob_stone_count;
    }


    // Most optimized solution is Alice will always win here,
    // Because she has first choice to pick Piles
//    public static boolean stoneGame(int[] piles) {
//        return true;
//    }

    public static void main(String[] args) {
        int[] piles = {3,7,2,3};
        System.out.println(stoneGame(piles));
    }
}
